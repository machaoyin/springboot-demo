package com.mcy.springbootdemo.repository;

import com.mcy.springbootdemo.custom.CommonRepository;
import com.mcy.springbootdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<User, Integer> {

}
