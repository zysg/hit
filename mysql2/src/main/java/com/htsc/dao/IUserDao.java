package com.htsc.dao;

import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVolds;
import com.htsc.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findByID(Integer uid);

    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userid);
    List<User> findByName(String username);

    int count();

    List<User> findByVo(QueryVo vo);

    List<User> findlnlds(QueryVolds volds);
}
