package io.adonia.springboot.dal.entity;

import lombok.Data;

/**
 * @author leo
 * @create 2018/9/9
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String age;

    private String address;

    private String sex;
}
