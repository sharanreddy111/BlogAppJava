package com.decorizeLivspace.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ContactUs")
@Data
public class ContactUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
}
