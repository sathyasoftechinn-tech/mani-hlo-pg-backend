// package com.hlopg_backend.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

// import com.hlopg_backend.model.Booking;

// @Repository
// public interface BookingRepository extends JpaRepository<Booking, String> {
//     List<Booking> findByUserUserId(Long userId);
//     List<Booking> findByHostelHostelId(Long hostelId);
    
//     @Query("SELECT b FROM Booking b WHERE b.hostel.hostelId = :hostelId AND b.user.userId = :userId")
//     Optional<Booking> findByHostelAndUser(@Param("hostelId") Long hostelId, @Param("userId") Long userId);
    
//     @Query("SELECT COUNT(b) FROM Booking b WHERE b.hostel.hostelId = :hostelId AND b.status = 'CONFIRMED'")
//     Long countActiveBookingsByHostel(@Param("hostelId") Long hostelId);
// }
package com.hlopg_backend.repository;

import com.hlopg_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    
    // Keep only SIMPLE methods that don't cause errors
    // List<Booking> findByUserId(Long userId);
    // List<Booking> findByHostelId(Long hostelId);
    // List<Booking> findByStatus(Booking.BookingStatus status);
    
    // Comment out the problematic method
    // Optional<Booking> findByHostelAndUser(Long hostelId, Long userId);
    
    // Add owner methods if needed
    // List<Booking> findByOwnerId(Long ownerId);
}