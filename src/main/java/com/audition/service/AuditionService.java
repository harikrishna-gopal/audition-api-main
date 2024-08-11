package com.audition.service;

import com.audition.integration.AuditionIntegrationClient;
import com.audition.model.AuditionComments;
import com.audition.model.AuditionPost;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hari
 */
@Service
public class AuditionService {

    @Autowired
    private AuditionIntegrationClient auditionIntegrationClient;


    public List<AuditionPost> getPosts() {
        return auditionIntegrationClient.getPosts();
    }

    /**
     *
     * @param postId -   Input postId
     * @return Audition Details based on a given postId
     *
     */
    public AuditionPost getPostById(final String postId) {
        return auditionIntegrationClient.getPostById(postId);
    }

    /**
     *
     * @param id - Input postId
     * @return Audition Comments based on a given postId
     *
     */
    public List<AuditionComments> getCommentsForPost(final String id) {
        return auditionIntegrationClient.getCommentsForPost(id);
    }


    /**
     *
     * @param postId - Input postId
     * @return Audition Comments comments for a particular Post
     *
     */
    public List<AuditionComments> getAllCommentsForPostId(final String postId) {
        return auditionIntegrationClient.getAllCommentsForPostId(postId);
    }


}
