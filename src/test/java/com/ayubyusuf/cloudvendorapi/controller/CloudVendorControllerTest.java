package com.ayubyusuf.cloudvendorapi.controller;

import com.ayubyusuf.cloudvendorapi.model.CloudVendor;
import com.ayubyusuf.cloudvendorapi.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService cloudVendorService;

    private List<CloudVendor> cloudVendorList;
    private CloudVendor cloudVendorOne;

    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("1", "Amazon", "USA", "xxxxx");
        CloudVendor cloudVendorTwo = new CloudVendor("2", "GCP", "UK", "yyyyy");
        cloudVendorList = new ArrayList<>(List.of(cloudVendorOne, cloudVendorTwo));
    }

    @AfterEach
    void tearDown() {
        // Clean up after tests if necessary
    }

    @Test
    void getCloudVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
        mockMvc.perform(get("/cloudvendor/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        mockMvc.perform(get("/cloudvendor"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createCloudVendorDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
        mockMvc.perform(post("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateCloudVendorDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("Cloud Vendor Updated Successfully");
        mockMvc.perform(put("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Cloud Vendor Deleted Successfully");
        mockMvc.perform(delete("/cloudvendor/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
