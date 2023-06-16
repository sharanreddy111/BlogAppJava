package com.decorizeLivspace.service;

import com.decorizeLivspace.model.ContactUs;
import com.decorizeLivspace.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsServiceImpl implements ContactUsService{


    @Autowired
    private ContactUsRepository contactUsRepository;
    @Override
    public void processContactForm(ContactUs contactUs) {
        this.contactUsRepository.save(contactUs);
    }

    @Override
    public ContactUs getContactById(Long id) {
        return contactUsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Contact id: " + id));
    }

    @Override
    public void deleteContactForm(Long id) {
        ContactUs contactUs = contactUsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Contact id: " + id));

        contactUsRepository.delete(contactUs);
    }

    @Override
    public List<ContactUs> getAllContacts(){
        return contactUsRepository.findAll();
    }
}
