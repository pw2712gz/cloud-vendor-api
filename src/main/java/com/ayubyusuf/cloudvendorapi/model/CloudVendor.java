package com.ayubyusuf.cloudvendorapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Represents a cloud vendor with details such as name, address, and phone number.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cloud_vendor_info")
public class CloudVendor {
    @Id
    private String vendorId;  // Primary key
    private String vendorName;
    private String vendorAddress;
    private String vendorPhoneNumber;
}
