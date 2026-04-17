package com.campus.booking.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne
    private User user;

    @ManyToOne
    private Resource resource;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }
}