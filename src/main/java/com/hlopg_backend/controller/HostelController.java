package com.hlopg_backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hlopg_backend.dto.ApiResponse;
import com.hlopg_backend.model.Hostel;
import com.hlopg_backend.service.HostelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/hostels")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HostelController {
    
    private final HostelService hostelService;
    
    @GetMapping("/popular")
    public ResponseEntity<ApiResponse> getPopularHostels() {
        try {
            List<Hostel> hostels = hostelService.getPopularHostels();
            return ResponseEntity.ok(ApiResponse.builder()
                    .success(true)
                    .data(hostels)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }
    
    @GetMapping("/city/{city}")
    public ResponseEntity<ApiResponse> getHostelsByCity(@PathVariable String city) {
        try {
            List<Hostel> hostels = hostelService.getHostelsByCity(city);
            return ResponseEntity.ok(ApiResponse.builder()
                    .success(true)
                    .data(hostels)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getHostelById(@PathVariable Long id) {
        try {
            Hostel hostel = hostelService.getHostelById(id);
            return ResponseEntity.ok(ApiResponse.builder()
                    .success(true)
                    .data(hostel)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> createHostel(
            @RequestBody Hostel hostel) {
        try {
            Hostel createdHostel = hostelService.createHostel(hostel);
            return ResponseEntity.ok(ApiResponse.builder()
                    .success(true)
                    .message("Hostel created successfully")
                    .data(createdHostel)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateHostel(
            @PathVariable Long id,
            @RequestBody Hostel hostelUpdates) {
        try {
            Hostel updated = hostelService.updateHostel(id, hostelUpdates);
            return ResponseEntity.ok(ApiResponse.builder()
                    .success(true)
                    .message("Hostel updated successfully")
                    .data(updated)
                    .build());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }
    
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<ApiResponse> getHostelsByOwner(@PathVariable Long ownerId) {
        try {
            List<Hostel> hostels = hostelService.getHostelsByOwner(ownerId);
            return ResponseEntity.ok(ApiResponse.builder()
                    .success(true)
                    .data(hostels)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build());
        }
    }
}