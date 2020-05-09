package com.dsa.as.dao;

import com.dsa.as.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     *
     * @return
     */
    List<User> findAll();

    Integer countAll();
}
