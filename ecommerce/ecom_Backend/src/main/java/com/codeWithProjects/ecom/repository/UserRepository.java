package com.codeWithProjects.ecom.repository;


import com.codeWithProjects.ecom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    java.util.Optional<User> findFirstByEmail(String email);
    java.util.Optional<User> findFirstByRole(com.codeWithProjects.ecom.enums.UserRole role);
}
