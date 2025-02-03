//package com.example.forum.models;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class User {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        private String username;
//        private String password;
//        private String email;
//
//
//}

package com.example.forum.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

//        @Column(unique = true, nullable = false)
        private String username;

//        @Column(nullable = false)
        private String password;

//        @Column(unique = true, nullable = false)
        private String email;

        private String profilePicture;
//        @ElementCollection(fetch = FetchType.EAGER)
//        @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//        @Column(name = "role")
//        private Set<String> roles = new HashSet<>();


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

//        public Set<String> getRoles() {
//                return roles;
//        }
//
//        public void setRoles(Set<String> roles) {
//                this.roles = roles;
//        }

        public String getProfilePicture() {
                return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
                this.profilePicture = profilePicture;
        }
}

