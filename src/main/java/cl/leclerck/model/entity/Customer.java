package cl.leclerck.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter private Integer id;

	@Setter @Getter private String username;
	@Setter @Getter private String email;
	@Getter private String password;
	@Setter @Getter private String avatarUrl;
	
	
	@Setter @Getter private Role roles;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	@Setter @Getter private List<Review> reviews;
 
    public void setPassword(String password) {
    //    this.password = EncoderUtils.passwordEncoder().encode(password);
    }
    
    public String toJson() {
        Customer aux = new Customer(id, username, email, password, avatarUrl, roles, reviews);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(aux);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonString;
    }

}
