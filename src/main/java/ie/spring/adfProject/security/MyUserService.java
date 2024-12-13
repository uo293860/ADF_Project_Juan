package ie.spring.adfProject.security;

import ie.spring.adfProject.entities.MyUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ie.spring.adfProject.repositories.MyUserRepository;

import java.util.Collections;

@Service
@AllArgsConstructor
public class MyUserService implements UserDetailsService {
    private MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = myUserRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(),user.isCredentialsNonExpired(), user.isAccountNonLocked(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }
}
