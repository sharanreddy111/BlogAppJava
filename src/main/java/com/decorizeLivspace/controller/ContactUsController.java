package com.decorizeLivspace.controller;

import com.decorizeLivspace.model.ContactUs;
import com.decorizeLivspace.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//The @Controller annotation is used to mark this class as a controller in the Spring MVC framework.
// It indicates that this class will handle incoming requests.
@Controller
public class ContactUsController {

//    The @Autowired annotation is used to inject an instance of the ContactUsService class into the controller.
    @Autowired
    private ContactUsService contactUsService;

// The showContactForm() method takes a Model object as a parameter.
// It adds a new instance of the ContactUs class to the model with the attribute name "contactUs".
// This allows the form in the corresponding view template to bind and display the contact form fields.
// The method returns the view name "pages-contactUs", which will be rendered and displayed to the user.

    @GetMapping("/contact/new")
    public String showContactForm(Model model) {
        model.addAttribute("contactUs", new ContactUs());
        return "pages-contactUs";
    }

//    The submitContactForm() method takes a @ModelAttribute("contactUs") parameter, which binds the form data submitted by the user to the ContactUs object.
//    The method then calls the processContactForm() method of the ContactUsService to handle the submitted form data.
//    After processing the form, the method redirects the user to the root ("/") URL.
    @PostMapping("/contact/new")
    public String submitContactForm(@ModelAttribute("contactUs") ContactUs contactUs) {
        contactUsService.processContactForm(contactUs);
        return "redirect:/";
    }

//    The getContactById() method takes the contact ID as a @PathVariable("id") parameter and retrieves the corresponding ContactUs object using the ContactUsService.
//    The retrieved ContactUs object is then added to the model with the attribute name "contactUs".
//    The method returns the view name "contactUs-viewByID", which will be rendered and displayed to the user.
    @GetMapping("/contact/{id}")
    public String getContactById(@PathVariable("id") Long id, Model model) {
        ContactUs contactUs = contactUsService.getContactById(id);
        model.addAttribute("contactUs", contactUs);
        return "contactUs-viewByID";
    }

//The deleteContactForm() method takes the contact ID as a @PathVariable("id") parameter.
// It retrieves the ContactUs object with the given ID using the ContactUsService,
// deletes it using the deleteContactForm() method of the service,
// and then redirects the user to the "/adminDashboard" URL
    @GetMapping("/contact/delete/{id}")
    public String deleteContactForm(@PathVariable("id") Long id) {
        ContactUs contactUs = contactUsService.getContactById(id);
        contactUsService.deleteContactForm(id);
        return "redirect:/adminDashboard";
    }
}
