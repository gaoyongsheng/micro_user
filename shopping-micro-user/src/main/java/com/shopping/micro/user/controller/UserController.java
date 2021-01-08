package com.shopping.micro.user.controller;

import com.shopping.micro.user.cro.UserCro;
import com.shopping.micro.user.cro.UserEditCro;
import com.shopping.micro.user.cro.UserLoginCro;
import com.shopping.micro.user.cro.UserRegisteCro;
import com.shopping.micro.user.entity.User;
import com.shopping.micro.user.exception.MyShopException;
import com.shopping.micro.user.service.UserService;
import com.shopping.micro.user.vo.MailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Gao
 * @Date 2020/10/22 0:31
 * @Version 1.0
 */

@RestController
@Slf4j
@RequestMapping("/service/v1")
@Api(tags = "用户", description = "API接口")
public class UserController extends AbstractBaseCtrl {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/user.register")
    public Object registerUser(@RequestBody UserRegisteCro userRegisteCro){
        try{
            userService.registerUser(userRegisteCro);
            return success("");
        }catch(MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

    @PostMapping("/user.login")
    public Object userLogin(@RequestBody UserLoginCro userLoginCro){
        try{
            User user = userService.findUserByUserNameOrMobile(userLoginCro);
//            int data = 100;
//            if(redisUtils.hasKey("rankList")){
//                redisUtils.decr("rankList",1L);
//            } else {
//                redisUtils.set("rankList",data);
//            }

            return success(user);
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

    @PostMapping("/user.findAll")
    public Object findAllUser(@RequestBody UserCro userCro){
        Page<User> listUser = userService.findAll(userCro);
        return success(getData(listUser));
    }

    @PostMapping("/user.edit")
    public Object editUser(@RequestBody UserEditCro userEditCro){
        return success(userService.editUser(userEditCro));
    }

//    @GetMapping("/user.findById")
//    public Object findUserById(@RequestParam(value = "id",defaultValue = "0") Long id){
//    @PathVariable("xxx")
//    通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
    @GetMapping("/user.findById/{id}")
    public Object findUserById(@PathVariable("id") Long id){
        try{
            User curUser = userService.findUserById(id);
            return success(curUser);
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }

    }

    @GetMapping("/user.findByUserNameOrMobile/{str}")
    @ResponseBody
    public Object findUserByUserNameOrMobile(@PathVariable("str") String str){
        try{
            User curUser = userService.findCurUserByUserNameOrMobile(str);
            return success(curUser);
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }

    }

    @GetMapping("/user.deleteById")
    public Object deleteUserById(@RequestParam("id") Long id){
        try{

            userService.deleteUserById(id);
            return success("");
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

    @PostMapping("/mail.send")
    public Object sendMail(@RequestBody MailVo mailVo){
        mailService.sendMail(mailVo);
        return success("");
    }
}
