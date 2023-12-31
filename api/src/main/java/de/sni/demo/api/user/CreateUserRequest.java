package de.sni.demo.api.user;

import lombok.Data;

@Data
public class CreateUserRequest
{
    private String name;
    private String password;
}
