package com.myproject.humbleproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;
    @NotBlank
    @Column(name = "user_firstname")
    private String firstName;
    @NotBlank
    @Column(name = "user_lastname")
    private String lastName;
    @NotBlank
    @Column(name = "username",unique = true)
    private String username;
    @Email
    @NotBlank
    @Column(name = "email", unique = true)
    private String email;
    @NotBlank
    @Column(name = "user_password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
            message =
                    "Password must be at least 8 characters and contain at least one uppercase letter, one lowercase letter, and one number")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "account_Non_Expired")
    private boolean accountNonExpired;
    @Column(name = "account_Non_Locked")
    private boolean accountNonLocked;
    @Column(name = "credentials_Non_Expired")
    private boolean credentialsNonExpired;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(name = "user_roles")
    private Set<Role> roles = new HashSet<>();



}