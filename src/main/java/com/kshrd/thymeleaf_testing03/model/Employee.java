package com.kshrd.thymeleaf_testing03.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
