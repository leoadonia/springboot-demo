package io.adonia.springboot.dal.entity;

import com.alibaba.fastjson.annotation.JSONField;
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

    @JSONField(name = "link_id")
    public Integer getId() {
        return this.id;
    }
}
