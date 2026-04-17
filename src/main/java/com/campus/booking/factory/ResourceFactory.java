package com.campus.booking.factory;

import com.campus.booking.model.Resource;

public class ResourceFactory {

    public static Resource createResource(String name, String type) {
        Resource resource = new Resource();
        resource.setName(name);
        resource.setType(type);
        resource.setStatus("AVAILABLE");
        return resource;
    }
}