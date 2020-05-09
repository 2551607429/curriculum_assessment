package com.dsa.key.dao;

import com.dsa.key.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("keyUserMapper")
public interface UserMapper {
    /**
     *
     * @return
     */
    public List<User> findAll();
}
