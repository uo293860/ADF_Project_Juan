package ie.spring.adfProject.repositories;

import ie.spring.adfProject.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MyUserRepository extends JpaRepository<MyUser, String> {
}
