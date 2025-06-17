package com.example.rest_api_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest_api_demo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

    //<CloudVendor, String>
    //CloudVendor model (primary_Key)Id is of type String
}
