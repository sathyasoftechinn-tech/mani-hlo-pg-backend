package com.hlopg_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "hostels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hostel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hostel_id")
    private Long hostelId;
    
    @Column(name = "hostel_name", nullable = false)
    private String hostelName;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String area;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String state;
    
    @Column(nullable = false, length = 6)
    private String pincode;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "pg_type", nullable = false)
    private PGType pgType;
    
    @Column(name = "price")
    private Double price = 0.0;
    
    @Column(name = "rating")
    private Double rating = 0.0;
    
    @Column(name = "popular")
    private Integer popular = 0;
    
    @Column(columnDefinition = "TEXT")
    private String amenities;
    
    @Column(columnDefinition = "TEXT")
    private String sharing;
    
    @Column(columnDefinition = "TEXT")
    private String rules;
    
    @Column(columnDefinition = "TEXT")
    private String images;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonIgnore
    private Owner owner;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    public enum PGType {
        MEN, WOMEN, CO_LIVING
    }
}