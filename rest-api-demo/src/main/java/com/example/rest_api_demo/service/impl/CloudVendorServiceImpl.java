package com.example.rest_api_demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.rest_api_demo.exception.CloudVendorNotFoundException;
import com.example.rest_api_demo.model.CloudVendor;
import com.example.rest_api_demo.repository.CloudVendorRepository;
import com.example.rest_api_demo.service.CloudVendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class CloudVendorServiceImpl implements CloudVendorService {

//Initiated a cloudVendorRepository and created a constructor

CloudVendorRepository cloudVendorRepository;
private static final Logger logger = LoggerFactory.getLogger(CloudVendorServiceImpl.class);

CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository){
    this.cloudVendorRepository=cloudVendorRepository;
}

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {

        //data of CloudVendor will get saved via Repository Layer into database
        try {
            cloudVendorRepository.save(cloudVendor);
            return "Success";
        } catch (Exception e) {
            logger.error("Error creating Cloud Vendor: {}", e.getMessage(), e);
            throw new RuntimeException("Unable to create Cloud Vendor. Please try again later.");
        }
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        if (!cloudVendorRepository.existsById(cloudVendor.getVendorId()))
        throw new CloudVendorNotFoundException("Cloud Vendor not found for update");
        cloudVendorRepository.save(cloudVendor);
        return "Successfully updated";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {   
        if (!cloudVendorRepository.existsById(cloudVendorId))
        throw new CloudVendorNotFoundException("Cloud Vendor not found for deletion");
        cloudVendorRepository.deleteById(cloudVendorId); 
        return "successfully deleted";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
       if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
       throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
       return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
       if(cloudVendorRepository.findAll().isEmpty())
       throw new CloudVendorNotFoundException("No Cloud Vendor present");
       return cloudVendorRepository.findAll();
    }

}
