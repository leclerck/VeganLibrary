package cl.leclerck.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import cl.leclerck.config.EncoderUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter private Integer id;
	@Setter @Getter private String username;
	@Setter @Getter private String email;
	@Getter private String password;
	@Setter @Getter private String avatarUrl;
	@Setter @Getter private Role role;
	
    public void setContrasenia(String contrasenia) {
//        this.password = EncoderUtils.passwordEncoder().encode(contrasenia);
    }
}
