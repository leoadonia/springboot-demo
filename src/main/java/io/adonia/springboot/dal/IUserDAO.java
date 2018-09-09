package io.adonia.springboot.dal;

import io.adonia.springboot.dal.entity.User;

import java.util.List;

public interface IUserDAO {

    List<User> selectUserList();

}
