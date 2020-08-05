package cl.leclerck.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cl.leclerck.service.AuthServiceImpl;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private UserDetailsService userDetailsService;
    private AuthenticationSuccessHandler authenticationHandler;
    
    @Autowired
    public WebSecurityConfig(
        AuthServiceImpl userDetailsService, 
        AuthenticationHandler authenticationHandler) {
    
       this.userDetailsService = userDetailsService;
       this.authenticationHandler = authenticationHandler;
     
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(userDetailsService).passwordEncoder(EncoderUtils.passwordEncoder());
    }
//HABILITA RECURSOS STATIC CUANDO NO SE ESTÁ LOGGEADO
//    @Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/img/**", "/css/**", "/js/**").permitAll()
//				.antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/login").permitAll().antMatchers("/signin")
//				.permitAll().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//				.anyRequest().authenticated().and().formLogin().loginPage("/login")
//				.successHandler(authenticationHandler).failureUrl("/login?error=true").usernameParameter("username")
//				.passwordParameter("password").and().exceptionHandling().accessDeniedPage("/recurso-prohibido");
//	}
//
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/auth/**").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/auth/login").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/auth/signin").permitAll()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/auth/login")
        .successHandler(authenticationHandler)
        .failureUrl("/login?error=true")
        .usernameParameter("username").passwordParameter("password")
        .and().exceptionHandling().accessDeniedPage("/denied-page");

    }
    
}
