package com.hlopg_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.hlopg_backend.model.Hostel;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Long> {
    List<Hostel> findByOwnerOwnerId(Long ownerId);
    List<Hostel> findByCity(String city);
    List<Hostel> findByPopular(Integer popular);
    List<Hostel> findByCityAndPopular(String city, Integer popular);
    
    @Query("SELECT h FROM Hostel h WHERE h.city IN :cities ORDER BY h.rating DESC")
    List<Hostel> findTopHostelsByCities(@Param("cities") List<String> cities);
}

