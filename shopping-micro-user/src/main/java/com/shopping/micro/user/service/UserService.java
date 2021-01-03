package com.shopping.micro.user.service;

import com.shopping.micro.user.cro.UserCro;
import com.shopping.micro.user.cro.UserEditCro;
import com.shopping.micro.user.cro.UserLoginCro;
import com.shopping.micro.user.cro.UserRegisteCro;
import com.shopping.micro.user.entity.User;
import org.springframework.data.domain.Page;


/**
 * @Author Gao
 * @Date 2020/10/22 0:31
 * @Version 1.0
 */
public interface UserService {

    /**
     * 注册用户
     * */
    void registerUser(UserRegisteCro userRegisteCro);


    /**
     * 分页查询所有用户
     * */
    Page<User> findAll(UserCro cro);

    /**
     * 通过手机号查找用户
     * */
    User findUserByMobile(String mobileNum);

    /**
     * 通过id查找用户
     * */
    User findUserById(Long id);

    /**
     * 编辑用户
     * */
    User editUser(UserEditCro userEditCro);

    /**
     * 通过用户名或者手机号查询用户
     * */
    User findUserByUserNameOrMobile(UserLoginCro userLoginCro);

    User findCurUserByUserNameOrMobile(String str);

    /**
     * 通过Id删除用户
     * */
    void deleteUserById(Long id);

}
