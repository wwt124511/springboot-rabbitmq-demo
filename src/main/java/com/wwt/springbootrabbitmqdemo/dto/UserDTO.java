package com.wwt.springbootrabbitmqdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author wwt
 * @ClassName UserDTO.java
 * @Description TODO
 * @CreateTime 2022-12-29 16:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String userName;

    private Integer age;
}
