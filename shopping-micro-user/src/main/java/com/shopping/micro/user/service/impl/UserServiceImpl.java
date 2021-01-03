package com.shopping.micro.user.service.impl;

import com.shopping.micro.user.constants.ShopExceptionCode;
import com.shopping.micro.user.cro.UserCro;
import com.shopping.micro.user.cro.UserEditCro;
import com.shopping.micro.user.cro.UserLoginCro;
import com.shopping.micro.user.cro.UserRegisteCro;
import com.shopping.micro.user.dto.UserDto;
import com.shopping.micro.user.entity.User;
import com.shopping.micro.user.exception.MyShopException;
import com.shopping.micro.user.repository.UserRepository;
import com.shopping.micro.user.service.UserService;
import com.shopping.micro.user.utils.DateTimeUtils;
import com.shopping.micro.user.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@CacheConfig(cacheNames = "curLoginUser")
@Service
@Transactional
public class UserServiceImpl extends AbstractBaseImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(UserRegisteCro userRegisteCro) throws MyShopException {

        User curUser = findUserByMobile(userRegisteCro.getMobileNum());
        if(curUser != null){
            throw new MyShopException(ShopExceptionCode.USER_ALREADY_EXISTS,"用户已存在");
        }
        UserDto userDto = userRegisteCro.toDto();
        userDto.setAddTime(DateTimeUtils.getSysCurDate());
        userRepository.save(new User(userDto));
    }


    @Override
    public Page<User> findAll(UserCro cro) {
        Pageable pageable = getPageable(cro.getOffset(),cro.getPageSize());
        Page<User> listUser = userRepository.findAllUsers(pageable);
        return listUser;
    }

    @Override
    public User findUserByMobile(String mobileNum) {
        User curUser = userRepository.findUserByMobileNum(mobileNum);
        return curUser;
    }

    @CachePut(key = "#result.id")
    @Override
    public User editUser(UserEditCro userEditCro) {
        // 获取当前登录的用户信息
//        User curUser = findUserById(userEditCro.getId());
//        curUser.setUserName(userEditCro.getUserName());
//        curUser.setTrueName(userEditCro.getTrueName());
//        curUser.setMobileNum(userEditCro.getMobileNum());
//        curUser.setEmail(userEditCro.getEmail());
//        curUser.setSex(userEditCro.getSex());
//        curUser.setUserRole(userEditCro.getUserRole());
//        return curUser;


        Optional<User> optionalUser =  userRepository.findById(userEditCro.getId());
        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setId(userEditCro.getId());
            user.setUserName(userEditCro.getUserName());
            user.setTrueName(userEditCro.getTrueName());
            user.setEmail(userEditCro.getEmail());
            user.setMobileNum(userEditCro.getMobileNum());
            user.setSex(userEditCro.getSex());
            user.setUserRole(userEditCro.getUserRole());

            return userRepository.save(user);
        } else {
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在"); // 用户不存在
        }
    }

    @Override
    public User findUserByUserNameOrMobile(UserLoginCro userLoginCro) {
        String str = userLoginCro.getUserName();
        if(Util.checkIsPhone(str)){   // 是手机号
            User curUser1 = userRepository.findUserByMobileNum(userLoginCro.getUserName());
            if(null == curUser1){
                throw new MyShopException(ShopExceptionCode.MOBILE_NO_REGIST,"该手机号未被注册"); // 该手机号未被注册
            } else {
                return curUser1;
            }
        } else {
            User curUser2 = userRepository.findUserByUserName(userLoginCro.getUserName());
            if(null == curUser2){
                throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在"); // 用户不存在
            } else {
                return curUser2;
            }
        }
    }

    @Cacheable
    @Override
    public User findCurUserByUserNameOrMobile(String str) {
        if(Util.checkIsPhone(str)){   // 是手机号
            User curUser1 = userRepository.findUserByMobileNum(str);
            if(null == curUser1){
                throw new MyShopException(ShopExceptionCode.MOBILE_NO_REGIST,"该手机号未被注册"); // 该手机号未被注册
            } else {
                return curUser1;
            }
        } else {
            User curUser2 = userRepository.findUserByUserName(str);
            if(null == curUser2){
                throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在"); // 用户不存在
            } else {
                return curUser2;
            }
        }
    }

    @Cacheable
    @Override
    public User findUserById(Long id) {
        User user = userRepository.findUserById(id);
        if(null == user){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在");
        }
        return user;
    }

    @CacheEvict
    @Override
    public void deleteUserById(Long id) {
        if(null == findUserById(id)){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"用户不存在");
        }
        userRepository.deleteUserById(id);
    }


}
