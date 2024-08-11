package com.audition.web;

import com.audition.common.exception.ErrorResponseDto;
import com.audition.common.exception.ResourceNotFoundException;
import com.audition.model.AuditionComments;
import com.audition.model.AuditionPost;
import com.audition.service.AuditionService;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * @author Hari
 */

@Tag(
        name = "REST APIs in Audition",
        description = "REST APIs in Audition to GET audition Posts and Comments details"

)
@RestController
@Validated
@AllArgsConstructor
public class AuditionController {

    @Autowired
    AuditionService auditionService;

    // TODO Add a query param that allows data filtering. The intent of the filter is at developers discretion.
    @Operation(
            summary = "Fetch Audition Posts Detail's REST API",
            description = "REST API to fetch Audition posts by UserId "
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @RequestMapping(
            value = "/posts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<AuditionPost>> getPosts( @RequestParam("userId")  Integer userId) {

        List<AuditionPost> posts = auditionService.getPosts();

        // TODO Add logic that filters response data based on the query param
        List<AuditionPost> filteredPosts = this.getPostsForQueryParams(userId, posts);

        return ResponseEntity.status(HttpStatus.OK).body(filteredPosts);

    }

    // TODO Add logic that filters response data based on the query param
    private List<AuditionPost> getPostsForQueryParams(Integer userId, List<AuditionPost> posts) {
        List<AuditionPost> filteredPost = posts.stream().filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());

        if(filteredPost.isEmpty()) {
           throw new ResourceNotFoundException("Audition posts", "UserId", userId.toString());
        }
        return filteredPost;
    }

    @Operation(
            summary = "Fetch Audition Detail's Post REST API by Post ID",
            description = "REST API to fetch Audition Post by Post ID "
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<AuditionPost> getPosts(@PathVariable ("id")
                                                                   @Pattern(regexp="(^$|[0-9]{2})",message = "Id must be a number with single or double digit" )
            final String postId) {
        final AuditionPost auditionPosts = auditionService.getPostById(postId);

        // TODO Add input validation

        return ResponseEntity.status(HttpStatus.OK).body(auditionPosts);
    }


    // TODO Add additional methods to return comments for each post. Hint: Check https://jsonplaceholder.typicode.com/
    @Operation(
            summary = "Fetch Comments for individual post ",
            description = "REST API to fetch Comments for individual post"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @RequestMapping(value = "/posts/{postId}/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<AuditionComments>> getCommentsForIndividualPost(@PathVariable("postId")
                                                                                                 @Pattern(regexp="(^$|[0-9]{2})",message = "Id must be a number with single or double digit" )
                                                                                                 final String postId) {
        final List<AuditionComments> auditionComments = auditionService.getCommentsForPost(postId);

        // TODO Add input validation

        return ResponseEntity.status(HttpStatus.OK).body(auditionComments);
    }



    // TODO write a method. GET comments for a particular Post from https://jsonplaceholder.typicode.com/comments?postId={postId}.
    @Operation(
            summary = "Fetch Comments for a  particular post",
            description = "REST API to fetch Comments for a particular post by Post ID "
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @RequestMapping(value = "/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<AuditionComments>> getCommentsForPost(@RequestParam("postId")
                                                                       @Pattern(regexp="(^$|[0-9]{2})",message = "Post Id must be a number with single or double digit" )
                                                                       final String postId) {
        final List<AuditionComments> auditionComments = auditionService.getAllCommentsForPostId(postId);

        // TODO Add input validation

        return ResponseEntity.status(HttpStatus.OK).body(auditionComments);
    }




}
