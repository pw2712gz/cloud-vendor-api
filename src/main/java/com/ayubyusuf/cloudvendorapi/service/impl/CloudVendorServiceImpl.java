package com.ayubyusuf.cloudvendorapi.service.impl;

import com.ayubyusuf.cloudvendorapi.exception.CloudVendorNotFoundException;
import com.ayubyusuf.cloudvendorapi.model.CloudVendor;
import com.ayubyusuf.cloudvendorapi.repository.CloudVendorRepository;
import com.ayubyusuf.cloudvendorapi.service.CloudVendorService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementation of the CloudVendorService interface, managing cloud vendor data operations.
 */
@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    private final CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        if (!cloudVendorRepository.existsById(cloudVendorId)) {
            throw new CloudVendorNotFoundException("Cloud Vendor with ID: " + cloudVendorId + " does not exist.");
        }
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return cloudVendorRepository.findById(cloudVendorId)
                .orElseThrow(() -> new CloudVendorNotFoundException("Requested Cloud Vendor does not exist."));
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName) {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
