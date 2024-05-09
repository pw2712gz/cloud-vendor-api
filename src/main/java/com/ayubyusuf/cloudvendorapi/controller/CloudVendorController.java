package com.ayubyusuf.cloudvendorapi.controller;

import com.ayubyusuf.cloudvendorapi.model.CloudVendor;
import com.ayubyusuf.cloudvendorapi.response.ResponseHandler;
import com.ayubyusuf.cloudvendorapi.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing cloud vendor information.
 */
@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    private final CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // Retrieves details for a specific cloud vendor by ID
    @GetMapping("/{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    // Retrieves a list of all cloud vendors
    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorService.getAllCloudVendors();
    }

    // Creates a new cloud vendor entry
    @PostMapping
    public ResponseEntity<String> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseEntity.ok("Cloud Vendor Created Successfully");
    }

    // Updates an existing cloud vendor entry
    @PutMapping
    public ResponseEntity<String> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return ResponseEntity.ok("Cloud Vendor Updated Successfully");
    }

    // Deletes a cloud vendor by ID
    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return ResponseEntity.ok("Cloud Vendor Deleted Successfully");
    }
}
