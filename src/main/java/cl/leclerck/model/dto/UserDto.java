package cl.leclerck.model.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import cl.leclerck.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Data
public class UserDto {
    private User user;
    private List<User> users;
}
