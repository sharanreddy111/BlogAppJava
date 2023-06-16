package com.decorizeLivspace.controller;

import com.decorizeLivspace.model.Post;
import com.decorizeLivspace.repository.PostRepository;
import com.decorizeLivspace.service.ContactUsService;
import com.decorizeLivspace.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ContactUsService contactUsService;

//    getAllPosts: This method is invoked when a GET request is made to "/tutorials" URL.
//    It takes a Model object as a parameter, which is used to add an attribute called "posts" to the model.
//    The "posts" attribute contains all the posts obtained from the postService.getAllPosts() method.
//    Finally, it returns the view name "pages-tutorials".
    @GetMapping("/tutorials")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "pages-tutorials";
    }

//    getPostById: This method handles a GET request to "/post/{id}", where "{id}" represents a dynamic value for the post ID.
//    The actual ID value is extracted from the URL using the @PathVariable annotation.
//    It retrieves the specific post with the given ID using postService.getPostById(id).
//    The retrieved post is added as an attribute called "post" to the Model object. It returns the view name "post-viewByID"
    @GetMapping("/post/{id}")
    public String getPostById(@PathVariable("id") Long id, Model model) {
        Post blogPost = postService.getPostById(id);
        model.addAttribute("post", blogPost);
        return "post-viewByID";
    }

//    showPostForm: This method is responsible for rendering a form for creating a new post.
//    It takes a Model object and adds a new instance of the Post class as an attribute called "post".
//    This attribute can be used in the view for binding form data. It returns the view name "post-create".
    @GetMapping("/post/new")
    public String showPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post-create";
    }
//createPost: This method handles a POST request to "/post/new" URL, which is the submission of the form created in the showPostForm method.
// It receives a Post object, annotated with @ModelAttribute("post"), which binds the form data to the blogPost object.
// It then saves the post using postService.savePost(blogPost). Finally, it redirects the user to the "/tutorials" URL.
    @PostMapping("/post/new")
    public String createPost(@ModelAttribute("post") Post blogPost) {
        postService.savePost(blogPost);
        return "redirect:/tutorials";
    }

//    showEditForm: This method is invoked when a GET request is made to "/post/edit/{id}".
//    It retrieves the post with the given ID using postService.getPostById(id) and adds it as an attribute called "post" to the Model object.
//    The method returns the view name "post-update", which represents the form for editing an existing post.
    @GetMapping("/post/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Post blogPost = postService.getPostById(id);
        model.addAttribute("post", blogPost);
        return "post-update";
    }

//    updatePost: This method handles a POST request to "/post/edit/{id}".
//    It receives the updated post object, annotated with @ModelAttribute("post"),
//    and the post ID extracted from the URL using @PathVariable("id").
//    It fetches the existing post with the given ID using postService.getPostById(id),
//    and then calls postService.updatePost(id, updatedBlogPost) to update the post with the new data.
//    Finally, it redirects the user to the "/tutorials" URL.
    @PostMapping("/post/edit/{id}")
    public String updatePost(@PathVariable("id") Long id, @ModelAttribute("post") Post updatedBlogPost) {
        Post blogPost = postService.getPostById(id);
        postService.updatePost(id, updatedBlogPost);
        return "redirect:/tutorials";
    }

//    deletePost: This method is responsible for deleting a post. It receives the post ID through the URL using @PathVariable("id").
//    It fetches the post with the given ID using postService.getPostById(id), and then calls postService.deletePost(id) to delete the post.
//    Finally, it redirects the user to the "/adminDashboard" URL.
    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        Post blogPost = postService.getPostById(id);
        postService.deletePost(id);
        return "redirect:/adminDashboard";
    }
}
