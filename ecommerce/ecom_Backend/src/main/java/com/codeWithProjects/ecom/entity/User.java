package com.codeWithProjects.ecom.entity;

import com.codeWithProjects.ecom.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;



    
    private UserRole role;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;
}
