package com.audition.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Getter
@Setter
//@Data
@Schema(
        name = "Audition Comments",
        description = "Schema to hold Audition Comments"
)
public class AuditionComments {

    @NotEmpty(message = "Account Comments PostID can not be a null or empty")
    @Pattern(regexp="(^$|[0-9])",message = "Account Comments PostID must be in digits")
    @Schema(
            description = "Account Comments PostID", example = "3454433243"
    )
    private int postId;

    @NotEmpty(message = "Account Comments ID can not be a null or empty")
    @Pattern(regexp="(^$|[0-9])",message = "Account Comments ID must be in digits")
    @Schema(
            description = "Account Comments PostID", example = "3454433243"
    )
    private int id;

    @NotEmpty(message = "Audition comments name can not be a null or empty")
    @Schema(
            description = "Audition comments name ", example = "alias odio sit"
    )
    private String name;

    @Schema(
            description = "Email address of the post", example = "sidney@gmail.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @NotEmpty(message = "Audition comments body can not be a null or empty")
    @Schema(
            description = "Audition comments body", example = "quia molestiae reprehenderit quasi aspernatur"
    )
    private String body;
}
