package com.decorizeLivspace.service;

import com.decorizeLivspace.model.Post;
import com.decorizeLivspace.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog post id: " + id));
    }

    @Override
    public void savePost(Post post) {
        this.postRepository.save(post);
    }

    @Override
    public void createPost(Post post) {

        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, Post updatedPost) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog post id: " + id));
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setCategory(updatedPost.getCategory());
        post.setPrecaution(updatedPost.getPrecaution());
        post.setStep_1(updatedPost.getStep_1());
        post.setStep_2(updatedPost.getStep_2());
        post.setStep_3(updatedPost.getStep_3());
        post.setStep_4(updatedPost.getStep_4());
        post.setStep_5(updatedPost.getStep_5());
        post.setStep_6(updatedPost.getStep_6());
        post.setStep_7(updatedPost.getStep_7());

        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog post id: " + id));
        postRepository.delete(post);
    }
}
