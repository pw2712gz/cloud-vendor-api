package com.ayubyusuf.cloudvendorapi.repository;

import com.ayubyusuf.cloudvendorapi.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    private CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon", "USA", "xxxxx");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendorRepository.deleteAll();
    }

    @Test
    @DisplayName("Find CloudVendor by Name - Success Case")
    void shouldFindCloudVendorByNameWhenVendorExists() {
        List<CloudVendor> foundVendors = cloudVendorRepository.findByVendorName("Amazon");
        assertThat(foundVendors).isNotEmpty();
        assertThat(foundVendors.getFirst().getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(foundVendors.getFirst().getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }

    @Test
    @DisplayName("Find CloudVendor by Name - Failure Case")
    void shouldNotFindCloudVendorByNameWhenVendorDoesNotExist() {
        List<CloudVendor> foundVendors = cloudVendorRepository.findByVendorName("GCP");
        assertThat(foundVendors).isEmpty();
    }
}
