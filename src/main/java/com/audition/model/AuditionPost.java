package com.audition.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * @author Hari
 */
@Getter
@Setter
@Schema(
        name = "Audition Posts",
        description = "Schema to hold UserId and AuditionId information"
)
//@Data
public class AuditionPost {

    @Schema(
            description = "UserId of user", example = "1"
    )
    //@NotEmpty(message = "UserId cannot be a null or empty")
    //@Pattern(regexp = "(^$|[0-9]{10})", message = "UserId must be a number ")
    @NonNull
    @Size(min = 1, max = 10, message = "UserID should be a number ")
    private int userId;

    @Schema(
            description = "Id of user", example = "For UserId 1 id between 1 to 10, For UserId 2 id between 11 to 20 "
    )
    @NotEmpty(message = "Id cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{2})", message = "Id must be a number ")
    @Size(min = 1, max = 10, message = "Id should be a number ")
    private int id;

    @Schema(
            description = "Title of Audition"
    )
    private String title;

    @Schema(
            description = "Body of Audition content"
    )
    private String body;

}
