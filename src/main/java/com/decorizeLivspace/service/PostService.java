package com.decorizeLivspace.service;

import com.decorizeLivspace.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(Long id);

    void savePost(Post post);
    void createPost(Post post);

    void updatePost(Long id, Post updatedPost);

    void deletePost(Long id);
}
