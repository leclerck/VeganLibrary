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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService_;
    private AuthenticationSuccessHandler authenticationHandler;
    
    @Autowired
    public WebSecurityConfig(
        AuthServiceImpl userDetailsService, 
        AuthenticationHandler authenticationHandler) {
    
       this.userDetailsService_ = userDetailsService;
       this.authenticationHandler = authenticationHandler;
     
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService_)
            .passwordEncoder(EncoderUtils.passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers(
                "/pictures/**", 
                "/frontImages/**", 
                "/css/**", 
                "/js/**",
                "/auth/**",
                "/login",
                "/signin"
        ).permitAll()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
        .permitAll()
        
        .antMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()

        .and().formLogin().loginPage("/login")
        .successHandler(authenticationHandler)
        .failureUrl("/login?error=true")
        .and().exceptionHandling().accessDeniedPage("/denied-page");

    }
    
}
