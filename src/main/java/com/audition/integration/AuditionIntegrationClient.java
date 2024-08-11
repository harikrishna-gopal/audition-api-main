package com.audition.integration;

import com.audition.common.exception.ResourceNotFoundException;
import com.audition.common.exception.SystemException;
import com.audition.model.AuditionComments;
import com.audition.model.AuditionPost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
/**
 * @author Hari
 */
@Component
public class AuditionIntegrationClient {


    @Autowired
    private RestTemplate restTemplate;

    public List<AuditionPost> getPosts() {
        // TODO make RestTemplate call to get Posts from
        /*Map<String, Integer> params = new HashMap<>();
        params.put("userId", userId);
        params.put("id", id);*/

         List<AuditionPost> auditionPosts =
                 List.of(restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", AuditionPost[].class));

        return auditionPosts;
    }

    public AuditionPost getPostById(final String id) {
        // TODO get post by post ID call from https://jsonplaceholder.typicode.com/posts/
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        try {
            AuditionPost auditionPosts =
                    restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/{id}", AuditionPost.class, params);
            return auditionPosts;
        } catch (final HttpClientErrorException e) {
            //if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                //throw new SystemException("Cannot find a Post with id " + id, "Resource Not Found", 404);
                throw new ResourceNotFoundException(" post by post ID", " ID ", id);
           /* } else {
                // TODO Find a better way to handle the exception so that the original error message is not lost. Feel free to change this function.
                throw new SystemException("Unknown Error message");
            }*/
        }
    }

    // TODO Write a method GET comments for a post from https://jsonplaceholder.typicode.com/posts/{postId}/comments - the comments must be returned as part of the post.
    public List<AuditionComments> getCommentsForPost(final String id) {
        // TODO Write a method GET comments for a post from https://jsonplaceholder.typicode.com/posts/{postId}/comments - the comments must be returned as part of the post.
        Map<String, String> params = new HashMap<>();
        params.put("postId", id);
        try {
            List<AuditionComments> auditionPostComments =
                    List.of(restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/{postId}/comments", AuditionComments[].class, params));
            return auditionPostComments;
        } catch (final HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResourceNotFoundException("Cannot find comments for a Post  " , id, "Resource Not Found");
            } else {
                // TODO Find a better way to handle the exception so that the original error message is not lost. Feel free to change this function.
                throw new SystemException("Unknown Error message");
            }
        }
    }


    // TODO write a method. GET comments for a particular Post from https://jsonplaceholder.typicode.com/comments?postId={postId}.
    // The comments are a separate list that needs to be returned to the API consumers. Hint: this is not part of the AuditionPost pojo.
    public List<AuditionComments> getAllCommentsForPostId(final String postId) {
        // TODO Write a method GET comments for a post from https://jsonplaceholder.typicode.com/posts/{postId}/comments - the comments must be returned as part of the post.
        Map<String, String> params = new HashMap<>();
        params.put("postId", postId);
        try {
            List<AuditionComments> auditionPostComments =
                    List.of(restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments?postId={postId}", AuditionComments[].class, params));
            return auditionPostComments;
        } catch (final HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResourceNotFoundException("Cannot find a Post with id ",  postId, "Resource Not Found");
            } else {
                // TODO Find a better way to handle the exception so that the original error message is not lost. Feel free to change this function.
                throw new SystemException("Unknown Error message");
            }
        }
    }


}
