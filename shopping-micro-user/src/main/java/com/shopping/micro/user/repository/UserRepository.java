package com.shopping.micro.user.repository;

import com.shopping.micro.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author Gao
 * @Date 2020/10/22 0:27
 * @Version 1.0
 */

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from user",nativeQuery = true)
    Page<User> findAllUsers(Pageable pageable);

    /**
     * 通过手机号查找用户
     * */
    User findUserByMobileNum(String mobileNum);

    /**
     * 通过用户名查找用户
     * */
    User findUserByUserName(String userName);

    /**
     * 通过Id查找用户
     * */
    User findUserById(Long id);

    /**
     * 通过Id删除用户
     * */
    void deleteUserById(Long id);

}
