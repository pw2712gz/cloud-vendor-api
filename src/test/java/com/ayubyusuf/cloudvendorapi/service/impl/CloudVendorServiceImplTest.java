package com.ayubyusuf.cloudvendorapi.service.impl;

import com.ayubyusuf.cloudvendorapi.exception.CloudVendorNotFoundException;
import com.ayubyusuf.cloudvendorapi.model.CloudVendor;
import com.ayubyusuf.cloudvendorapi.repository.CloudVendorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;

    @InjectMocks
    private CloudVendorServiceImpl cloudVendorService;

    private CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon", "USA", "xxxxx");
    }

    @Test
    void shouldCreateCloudVendor() {
        when(cloudVendorRepository.save(any())).thenReturn(cloudVendor);
        String response = cloudVendorService.createCloudVendor(cloudVendor);
        assertThat(response).isEqualTo("Success");
        verify(cloudVendorRepository, times(1)).save(cloudVendor);
    }

    @Test
    void shouldUpdateCloudVendor() {
        when(cloudVendorRepository.save(any())).thenReturn(cloudVendor);
        String response = cloudVendorService.updateCloudVendor(cloudVendor);
        assertThat(response).isEqualTo("Success");
        verify(cloudVendorRepository).save(cloudVendor);
    }

    @Test
    void shouldDeleteCloudVendor_whenVendorExists() {
        when(cloudVendorRepository.existsById("1")).thenReturn(true);
        doNothing().when(cloudVendorRepository).deleteById("1");
        String response = cloudVendorService.deleteCloudVendor("1");
        assertThat(response).isEqualTo("Success");
        verify(cloudVendorRepository).deleteById("1");
    }

    @Test
    void shouldNotDeleteCloudVendor_whenVendorDoesNotExist() {
        when(cloudVendorRepository.existsById("1")).thenReturn(false);

        Exception exception = assertThrows(CloudVendorNotFoundException.class, () -> cloudVendorService.deleteCloudVendor("1"));

        String expectedMessage = "Cloud Vendor with ID: 1 does not exist.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        verify(cloudVendorRepository, never()).deleteById("1");
    }


    @Test
    void shouldGetCloudVendor() {
        when(cloudVendorRepository.findById("1")).thenReturn(Optional.of(cloudVendor));
        CloudVendor foundVendor = cloudVendorService.getCloudVendor("1");
        assertThat(foundVendor.getVendorName()).isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void shouldGetAllCloudVendors() {
        when(cloudVendorRepository.findAll()).thenReturn(Collections.singletonList(cloudVendor));
        assertThat(cloudVendorService.getAllCloudVendors()).containsExactly(cloudVendor);
    }

    @Test
    void shouldGetByVendorName() {
        when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(Collections.singletonList(cloudVendor));
        assertThat(cloudVendorService.getByVendorName("Amazon")).containsExactly(cloudVendor);
    }

}
