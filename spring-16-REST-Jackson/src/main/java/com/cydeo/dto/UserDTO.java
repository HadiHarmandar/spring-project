package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    @JsonIgnore
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // deserialisation ok, serialisation no
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference // this field will be serialized
    private AccountDTO account;

}
