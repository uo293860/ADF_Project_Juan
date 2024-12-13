package ie.spring.adfProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "myusers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    @Id
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String county;
    private String role;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;

}
