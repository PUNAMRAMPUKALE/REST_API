package com.example.rest_api_demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest_api_demo.model.CloudVendor;
import com.example.rest_api_demo.repository.CloudVendorRepository;
import com.example.rest_api_demo.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

//Initiated a cloudVendorRepository and created a constructor
CloudVendorRepository cloudVendorRepository;

CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository){
    this.cloudVendorRepository=cloudVendorRepository;
}

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {

        //data of CloudVendor will get saved via Repository Layer into database
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        
        cloudVendorRepository.save(cloudVendor);
        return "Successfully updated";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        
        cloudVendorRepository.deleteById(cloudVendorId); 
        return "successfully deleted";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
       
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }

}
