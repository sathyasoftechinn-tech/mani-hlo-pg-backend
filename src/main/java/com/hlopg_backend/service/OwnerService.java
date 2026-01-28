// // package com.hlopg_backend.service;

// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.stereotype.Service;

// // import java.util.Optional;

// // import com.hlopg_backend.dto.AuthRequest;
// // import com.hlopg_backend.dto.AuthResponse;
// // import com.hlopg_backend.dto.RegisterRequest;
// // import com.hlopg_backend.model.OTP;
// // import com.hlopg_backend.model.Owner;
// // import com.hlopg_backend.repository.OwnerRepository;

// // import lombok.RequiredArgsConstructor;

// // @Service
// // @RequiredArgsConstructor
// // public class OwnerService {
    
// //     private final OwnerRepository ownerRepository;
// //     private final PasswordEncoder passwordEncoder;
// //     private final AuthenticationManager authenticationManager;
// //     private final JWTService jwtService;
// //     private final CustomUserDetailsService userDetailsService;
// //     private final OTPService otpService;
    
// //     public Owner registerOwner(RegisterRequest request) {
// //         if (ownerRepository.existsByEmail(request.getEmail())) {
// //             throw new RuntimeException("Email already registered");
// //         }
// //         if (ownerRepository.existsByPhone(request.getPhone())) {
// //             throw new RuntimeException("Phone already registered");
// //         }
        
// //         Owner owner = Owner.builder()
// //                 .name(request.getName())
// //                 .email(request.getEmail().toLowerCase())
// //                 .phone(request.getPhone())
// //                 .password(passwordEncoder.encode(request.getPassword()))
// //                 .isVerified(false)
// //                 .build();
        
// //         Owner savedOwner = ownerRepository.save(owner);
        
// //         // Generate OTP
// //         otpService.generateOTP(request.getPhone(), OTP.Purpose.REGISTRATION);
        
// //         return savedOwner;
// //     }
    
// //     public Optional<Owner> findByIdentifier(String identifier) {
// //         if (identifier.matches("^[6-9]\\d{9}$")) {
// //             return ownerRepository.findByPhone(identifier);
// //         } else {
// //             return ownerRepository.findByEmail(identifier.toLowerCase());
// //         }
// //     }
    
// //     public AuthResponse authenticateOwner(AuthRequest request) {
// //         // Find owner by identifier
// //         Owner owner = findByIdentifier(request.getIdentifier())
// //                 .orElseThrow(() -> new RuntimeException("Owner not found"));
        
// //         // Authenticate
// //         authenticationManager.authenticate(
// //                 new UsernamePasswordAuthenticationToken(
// //                         owner.getEmail(),
// //                         request.getPassword()
// //                 )
// //         );
        
// //         // Generate token
// //         UserDetails userDetails = userDetailsService.loadUserByUsername(owner.getEmail());
// //         String token = jwtService.generateToken(userDetails);
        
// //         return AuthResponse.builder()
// //                 .token(token)
// //                 .success(true)
// //                 .owner(AuthResponse.OwnerResponse.builder()
// //                         .ownerId(owner.getOwnerId())
// //                         .name(owner.getName())
// //                         .email(owner.getEmail())
// //                         .phone(owner.getPhone())
// //                         .userType(owner.getUserType().name())
// //                         .build())
// //                 .build();
// //     }
// // }


// package com.hlopg_backend.service;

// import java.util.Optional;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.hlopg_backend.dto.AuthRequest;
// import com.hlopg_backend.dto.AuthResponse;
// import com.hlopg_backend.dto.OwnerRegisterRequest;
// import com.hlopg_backend.model.OTP;
// import com.hlopg_backend.model.Owner;
// import com.hlopg_backend.repository.OwnerRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class OwnerService {
    
//     private final OwnerRepository ownerRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final AuthenticationManager authenticationManager;
//     private final JWTService jwtService;
//     private final CustomUserDetailsService userDetailsService;
//     private final OTPService otpService;
    
//     public Owner registerOwner(OwnerRegisterRequest request) {
//         // Check if email exists
//         if (ownerRepository.findByEmail(request.getEmail()).isPresent()) {
//             throw new RuntimeException("Email already registered");
//         }
        
//         // Check if phone exists
//         if (ownerRepository.findByPhone(request.getPhone()).isPresent()) {
//             throw new RuntimeException("Phone already registered");
//         }
        
//         // Create owner
//         Owner owner = Owner.builder()
//                 .name(request.getName())
//                 .email(request.getEmail().toLowerCase())
//                 .phone(request.getPhone())
//                 .password(passwordEncoder.encode(request.getPassword()))
//                 .userType(Owner.UserType.OWNER) // Fixed: Use Owner.UserType
//                 .isVerified(false)
//                 .build();
        
//         Owner savedOwner = ownerRepository.save(owner);
        
//         // Generate OTP
//         otpService.generateAndSendOTP(request.getPhone(), OTP.Purpose.REGISTRATION);
        
//         return savedOwner;
//     }
    
//     public Optional<Owner> findByIdentifier(String identifier) {
//         // Try email first
//         Optional<Owner> byEmail = ownerRepository.findByEmail(identifier.toLowerCase());
//         if (byEmail.isPresent()) {
//             return byEmail;
//         }
        
//         // Try phone
//         return ownerRepository.findByPhone(identifier);
//     }
    
//     // This method is optional if you want separate auth logic
//     public AuthResponse authenticateOwner(AuthRequest request) {
//         // Find owner by identifier
//         Owner owner = findByIdentifier(request.getIdentifier())
//                 .orElseThrow(() -> new RuntimeException("Owner not found"));
        
//         // Authenticate
//         authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                         owner.getEmail(),
//                         request.getPassword()
//                 )
//         );
        
//         // Generate token
//         UserDetails userDetails = userDetailsService.loadUserByUsername(owner.getEmail());
//         String token = jwtService.generateToken(userDetails);
        
//         return AuthResponse.builder()
//                 .success(true)
//                 .message("Login successful")
//                 .token(token)
//                 .owner(AuthResponse.OwnerResponse.builder()
//                         .ownerId(owner.getOwnerId())
//                         .name(owner.getName())
//                         .email(owner.getEmail())
//                         .phone(owner.getPhone())
//                         .userType(owner.getUserType().name())
//                         .build())
//                 .build();
//     }
// }

package com.hlopg_backend.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hlopg_backend.dto.OwnerRegisterRequest;
import com.hlopg_backend.model.OTP;
import com.hlopg_backend.model.Owner;
import com.hlopg_backend.repository.OwnerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerService {
    
    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;
    private final OTPService otpService;
    
    public Owner registerOwner(OwnerRegisterRequest request) {
        // Check if email exists
        if (ownerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        
        // Check if phone exists
        if (ownerRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException("Phone already registered");
        }
        
        // Create owner
        Owner owner = Owner.builder()
                .name(request.getName())
                .email(request.getEmail().toLowerCase())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .userType(Owner.UserType.OWNER)
                .isVerified(false)
                .build();
        
        Owner savedOwner = ownerRepository.save(owner);
        
        // Generate OTP
        otpService.generateOTP(request.getPhone(), OTP.Purpose.REGISTRATION);
        
        return savedOwner;
    }
    
    public Optional<Owner> findByIdentifier(String identifier) {
        // Try email first
        Optional<Owner> byEmail = ownerRepository.findByEmail(identifier.toLowerCase());
        if (byEmail.isPresent()) {
            return byEmail;
        }
        
        // Try phone
        return ownerRepository.findByPhone(identifier);
    }
}