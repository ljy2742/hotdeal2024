package com.hotdealwork.hotdealwork.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "ID")
    private String username;

    @NotEmpty(message = "비밀번호")
    private String password;

    @NotEmpty(message = "비밀번호 확인")
    private String checkPassword;

    @NotEmpty(message = "이메일")
    @Email
    private String email;
}
