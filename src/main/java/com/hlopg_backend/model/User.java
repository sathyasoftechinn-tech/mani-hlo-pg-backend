// // // package com.hlopg_backend.model;

// // // import jakarta.persistence.*;
// // // import lombok.*;
// // // import org.hibernate.annotations.CreationTimestamp;
// // // import org.hibernate.annotations.UpdateTimestamp;

// // // import java.time.LocalDateTime;

// // // @Entity
// // // @Table(name = "users")
// // // @Data
// // // @NoArgsConstructor
// // // @AllArgsConstructor
// // // @Builder
// // // public class User {
    
// // //     @Id
// // //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// // //     @Column(name = "user_id")
// // //     private Long userId;
    
// // //     @Column(nullable = false)
// // //     private String name;
    
// // //     @Column(nullable = false, unique = true)
// // //     private String email;
    
// // //     @Column(nullable = false, unique = true)
// // //     private String phone;
    
// // //     @Column(nullable = false)
// // //     private String password;
    
// // //     @Enumerated(EnumType.STRING)
// // //     @Column(nullable = false)
// // //     private Gender gender;
    
// // //     @Enumerated(EnumType.STRING)
// // //     @Column(name = "user_type", nullable = false)
// // //     private UserType userType = UserType.USER;
    
// // //     @Column(name = "is_verified")
// // //     private Boolean isVerified = false;
    
// // //     @Column(name = "profile_image")
// // //     private String profileImage;
    
// // //     @CreationTimestamp
// // //     @Column(name = "created_at")
// // //     private LocalDateTime createdAt;
    
// // //     @UpdateTimestamp
// // //     @Column(name = "updated_at")
// // //     private LocalDateTime updatedAt;
    
// // //     public enum Gender {
// // //         MALE, FEMALE, OTHER
// // //     }
    
// // //     public enum UserType {
// // //         USER, OWNER, ADMIN
// // //     }
// // // }

// // package com.hlopg_backend.model;

// // import jakarta.persistence.*;
// // import lombok.*;
// // import java.time.LocalDateTime;

// // @Entity
// // @Table(name = "users")
// // @Data
// // @NoArgsConstructor
// // @AllArgsConstructor
// // @Builder
// // public class User {
    
// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     @Column(name = "user_id")
// //     private Long userId;
    
// //     @Column(nullable = false)
// //     private String name;
    
// //     @Column(unique = true, nullable = false)
// //     private String email;
    
// //     @Column(unique = true, nullable = false)
// //     private String phone;
    
// //     @Column(nullable = false)
// //     private String password;
    
// //     @Column(nullable = false)
// //     private String gender;
    
// //     @Column(name = "user_type", nullable = false)
// //     private String userType = "USER";
    
// //     @Column(name = "created_at")
// //     private LocalDateTime createdAt;
    
// //     @Column(name = "updated_at")
// //     private LocalDateTime updatedAt;
    
// //     @PrePersist
// //     protected void onCreate() {
// //         createdAt = LocalDateTime.now();
// //         updatedAt = LocalDateTime.now();
// //     }
    
// //     @PreUpdate
// //     protected void onUpdate() {
// //         updatedAt = LocalDateTime.now();
// //     }
// // }

// package com.hlopg_backend.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "users")
// @Data
// public class User {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;  // Note: Your table shows 'id', not 'user_id'
    
//     @Column(nullable = false)
//     private String name;
    
//     @Column(unique = true, nullable = false)
//     private String email;
    
//     @Column(unique = true, nullable = false)
//     private String phone;
    
//     @Column(nullable = false)
//     private String password;
    
//     @Column(nullable = false)
//     private String gender;
    
//     @Column(name = "user_type", nullable = false)
//     private String userType = "USER";
    
//     @Column(name = "created_at")
//     private LocalDateTime createdAt;
    
//     @Column(name = "updated_at")
//     private LocalDateTime updatedAt;
    
//     @PrePersist
//     protected void onCreate() {
//         createdAt = LocalDateTime.now();
//         updatedAt = LocalDateTime.now();
//     }
    
//     @PreUpdate
//     protected void onUpdate() {
//         updatedAt = LocalDateTime.now();
//     }
// }

package com.hlopg_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // This is 'id' in your database table
    
    @Column(nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true, nullable = false)
    private String phone;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String gender;
    
    @Column(name = "user_type", nullable = false)
    private String userType = "USER";
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}