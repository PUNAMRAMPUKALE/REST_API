package com.example.rest_api_demo.repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.rest_api_demo.model.CloudVendor;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    private CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1", "Amazon", "USA", "4356545654");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendorRepository.deleteAll();
        cloudVendor = null;
    }

    @Test
    void testFindByVendorName_Found() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");

        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }

    @Test
    void testFindByVendorName_NotFound(){
  List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GCP");
  assertThat(cloudVendorList.isEmpty()).isTrue();




    }
}
