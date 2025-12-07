package com.codeWithProjects.ecom.services.auth;


import com.codeWithProjects.ecom.dto.SignupRequest;
import com.codeWithProjects.ecom.dto.UserDto;
import com.codeWithProjects.ecom.entity.User;
import com.codeWithProjects.ecom.enums.UserRole;
import com.codeWithProjects.ecom.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public UserDto createUser(SignupRequest signupRequest){
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        System.out.println("Creating new user: " + signupRequest.getEmail());
        User createdUser = userRepository.save(user);
        userRepository.flush(); // Force l'écriture immédiate en base de données
        System.out.println("User created successfully with ID: " + createdUser.getId());
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;
    }

    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email).isPresent();
    }


    @PostConstruct
    public void creatAdminAccount(){
        java.util.Optional<User> adminAccount = userRepository.findFirstByRole(UserRole.ADMIN);
        if(adminAccount.isEmpty()){
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            User savedUser = userRepository.save(user);
            System.out.println("Admin account created with ID: " + savedUser.getId());
        } else {
            System.out.println("Admin account already exists");
        }
    }

}
