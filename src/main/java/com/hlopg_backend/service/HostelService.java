package com.hlopg_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hlopg_backend.model.Hostel;
import com.hlopg_backend.repository.HostelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HostelService {
    
    private final HostelRepository hostelRepository;
    
    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }
    
    public List<Hostel> getPopularHostels() {
        return hostelRepository.findByPopular(1);
    }
    
    public List<Hostel> getHostelsByCity(String city) {
        return hostelRepository.findByCity(city);
    }
    
    public Hostel getHostelById(Long id) {
        return hostelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hostel not found"));
    }
    
    public List<Hostel> getHostelsByOwner(Long ownerId) {
        return hostelRepository.findByOwnerOwnerId(ownerId);
    }
    
    public Hostel createHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }
    
    public Hostel updateHostel(Long id, Hostel updatedHostel) {
        Hostel existingHostel = getHostelById(id);
        
        // Update fields
        if (updatedHostel.getHostelName() != null) {
            existingHostel.setHostelName(updatedHostel.getHostelName());
        }
        if (updatedHostel.getAddress() != null) {
            existingHostel.setAddress(updatedHostel.getAddress());
        }
        if (updatedHostel.getArea() != null) {
            existingHostel.setArea(updatedHostel.getArea());
        }
        if (updatedHostel.getCity() != null) {
            existingHostel.setCity(updatedHostel.getCity());
        }
        if (updatedHostel.getState() != null) {
            existingHostel.setState(updatedHostel.getState());
        }
        if (updatedHostel.getPincode() != null) {
            existingHostel.setPincode(updatedHostel.getPincode());
        }
        if (updatedHostel.getPgType() != null) {
            existingHostel.setPgType(updatedHostel.getPgType());
        }
        if (updatedHostel.getPrice() != null) {
            existingHostel.setPrice(updatedHostel.getPrice());
        }
        if (updatedHostel.getAmenities() != null) {
            existingHostel.setAmenities(updatedHostel.getAmenities());
        }
        if (updatedHostel.getSharing() != null) {
            existingHostel.setSharing(updatedHostel.getSharing());
        }
        if (updatedHostel.getImages() != null) {
            existingHostel.setImages(updatedHostel.getImages());
        }
        
        return hostelRepository.save(existingHostel);
    }
}