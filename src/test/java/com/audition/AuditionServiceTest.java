package com.audition;

import com.audition.integration.AuditionIntegrationClient;
import com.audition.model.AuditionPost;
import com.audition.service.AuditionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Hari
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AuditionServiceTest {

    @Mock
    private AuditionIntegrationClient auditionIntegrationClient;

    @InjectMocks
    private AuditionService auditionService;

    @Test
    public void testgetPosts() {

        AuditionPost post = new AuditionPost();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
        // Arrange
        when(auditionIntegrationClient.getPosts()).thenReturn(Arrays.asList(post));

        // Act
        List<AuditionPost> posts = auditionService.getPosts();

        // Assert
        verify(auditionIntegrationClient, times(1)).getPosts();
        // Additional assertions based on the business logic
        // e.g., assert that the returned list contains the expected users
    }

    @Test
    public void testgPostById() {

        String postId = "1";
        AuditionPost post = new AuditionPost();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
        // Arrange
        when(auditionIntegrationClient.getPostById(postId)).thenReturn(post);

        // Act
        AuditionPost auditionPost = auditionService.getPostById(postId);

        // Assert
        verify(auditionIntegrationClient, times(1)).getPostById(postId);
        // Additional assertions based on the business logic
        // e.g., assert that the returned list contains the expected users
    }


}
