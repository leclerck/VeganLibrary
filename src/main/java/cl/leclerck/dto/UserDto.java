package cl.leclerck.dto;

import java.util.List;

import cl.leclerck.model.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UserDto extends GenericDto{
    @Setter @Getter private List<User> users;

    public UserDto(String message, String code) {
        super(message, code);
    }

    public UserDto(List<User> users, String message, String code) {
        super(message, code);
        this.users = users;
    }
}
