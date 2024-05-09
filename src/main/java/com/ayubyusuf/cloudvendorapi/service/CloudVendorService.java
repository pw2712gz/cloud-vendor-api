package com.ayubyusuf.cloudvendorapi.service;

import com.ayubyusuf.cloudvendorapi.model.CloudVendor;

import java.util.List;

/**
 * Service interface for managing operations related to cloud vendors.
 */
public interface CloudVendorService {
    String createCloudVendor(CloudVendor cloudVendor);
    String updateCloudVendor(CloudVendor cloudVendor);
    String deleteCloudVendor(String cloudVendorId);
    CloudVendor getCloudVendor(String cloudVendorId);
    List<CloudVendor> getAllCloudVendors();
    List<CloudVendor> getByVendorName(String vendorName);
}