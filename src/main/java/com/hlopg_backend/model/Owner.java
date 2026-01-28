// package com.hlopg_backend.model;

// import jakarta.persistence.*;
// import lombok.*;
// import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.UpdateTimestamp;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "owners")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Owner {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "owner_id")
//     private Long ownerId;
    
//     @Column(nullable = false)
//     private String name;
    
//     @Column(nullable = false, unique = true)
//     private String email;
    
//     @Column(nullable = false, unique = true)
//     private String phone;
    
//     @Column(nullable = false)
//     private String password;
    
//     @Enumerated(EnumType.STRING)
//     @Column(name = "user_type", nullable = false)
//     private User.UserType userType = User.UserType.OWNER;
    
//     @Column(name = "is_verified")
//     private Boolean isVerified = false;
    
//     @Column(name = "profile_image")
//     private String profileImage;
    
//     @Column(name = "aadhar_number")
//     private String aadharNumber;
    
//     @Column(name = "pan_number")
//     private String panNumber;
    
//     @CreationTimestamp
//     @Column(name = "created_at")
//     private LocalDateTime createdAt;
    
//     @UpdateTimestamp
//     @Column(name = "updated_at")
//     private LocalDateTime updatedAt;
// }

package com.hlopg_backend.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long ownerId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, unique = true)
    private String phone;
    
    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    @Builder.Default
    private UserType userType = UserType.OWNER;
    
    @Column(name = "is_verified")
    @Builder.Default
    private Boolean isVerified = false;
    
    @Column(name = "profile_image")
    private String profileImage;
    
    @Column(name = "aadhar_number")
    private String aadharNumber;
    
    @Column(name = "pan_number")
    private String panNumber;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Add UserType enum inside Owner class
    public enum UserType {
        OWNER, ADMIN
    }
    
    // Or use the same User.UserType enum if you prefer
    // private User.UserType userType = User.UserType.OWNER;
}