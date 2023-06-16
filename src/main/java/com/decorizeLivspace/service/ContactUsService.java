package com.decorizeLivspace.service;

import com.decorizeLivspace.model.ContactUs;

import java.util.List;

public interface ContactUsService {

    List<ContactUs> getAllContacts();

    void processContactForm(ContactUs contactUs);

    ContactUs getContactById(Long id);

    void deleteContactForm(Long id);
}
