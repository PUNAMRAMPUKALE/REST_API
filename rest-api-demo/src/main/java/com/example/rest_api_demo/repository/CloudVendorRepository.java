package com.example.rest_api_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest_api_demo.model.CloudVendor;
//This is the layer actully talking to database
public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

    //<CloudVendor, String>
    //CloudVendor model (primary_Key)Id is of type String

    //JpaRepository has all method implemented and tested,
    //we have to just use it,not need to test again n again



    //This method not by JPA ,i have written so it has to be unit tested
List<CloudVendor>findByVendorName(String vendorName);
}
