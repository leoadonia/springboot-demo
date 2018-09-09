package io.adonia.springboot.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author leo
 * @create 2018/9/9
 */
@Data
public class BlogParam {

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "address不能为空")
    private String address;
}
