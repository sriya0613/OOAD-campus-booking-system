package com.campus.booking.controller;

import com.campus.booking.factory.ResourceFactory;
import com.campus.booking.model.Resource;
import com.campus.booking.repository.ResourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;

    // ✅ CREATE RESOURCE (using Factory Pattern)
    @PostMapping
    public Resource addResource(@RequestBody Resource resource) {

        Resource newResource = ResourceFactory.createResource(
                resource.getName(),
                resource.getType()
        );

        return resourceRepository.save(newResource);
    }

    // ✅ GET ALL RESOURCES
    @GetMapping
    public List<Resource> getAll() {
        return resourceRepository.findAll();
    }
}