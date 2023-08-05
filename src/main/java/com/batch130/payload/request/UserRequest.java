package com.batch130.payload.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRequest implements Serializable {

    @NotNull(message = "Please enter your name")
    @Size(min=2, max=16, message = "Your username should be at least 2 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your name must consist of the characters .")
    private String firstName;


    @NotNull(message = "Please enter your surname")
    @Size(min=2, max=16, message = "Your surname should be at least 4 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your surname must consist of the characters .")
    private String lastName;

    @NotNull(message = "Please enter your email address")
    @Email
    private String email;


    @NotNull(message = "Please enter your username")
    @Size(min=4, max=16, message = "Your username should be at least 4 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = "Your username must consist of the characters .")
    private String userName;

    @NotNull(message = "Please enter your password")
    @Size(min=8, max=60, message = "Please enter your password as al least 8 chars")
    private String password;


}
