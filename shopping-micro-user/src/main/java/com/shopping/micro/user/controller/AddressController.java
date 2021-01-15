package com.shopping.micro.user.controller;

import com.shopping.micro.user.cro.AddressCro;
import com.shopping.micro.user.exception.MyShopException;
import com.shopping.micro.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ldc
 * @Date 2020/12/2 11:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/service/v1")
public class AddressController extends AbstractBaseCtrl {

    @Autowired
    AddressService addressService;

    @PostMapping("/address.add")
    public Object createAddress(@RequestBody AddressCro addressCro){
        addressService.createAddress(addressCro.toDto());
        return success("");
    }

    @GetMapping("/address.findAllByAddressId/{addrId}")
    public Object findAddressByAddrId(@PathVariable("addrId") Long addrId){
//        try{
            return success(addressService.findAddressById(addrId));
//        } catch (MyShopException ex){
//            ex.printStackTrace();
//            return failure(ex.getErrorCode(),ex.getMessage());
//        }

    }

    @GetMapping("/address.findAllByUserId/{userId}")
    public Object findAll(@PathVariable("userId") Long userId){
        return success(addressService.findAllAddress(userId));
    }

    @PostMapping("/address.delete")
    public Object deleteAddress(@RequestBody AddressCro addressCro){
//        try{
            addressService.deleteAddress(addressCro.toDto());
            return success("");
//        } catch (MyShopException ex){
//            return failure(ex.getErrorCode(),ex.getMessage());
//        }
    }

    @PostMapping("/address.edit")
    public Object editAddress(@RequestBody AddressCro addressCro){
//        try{
            return success(addressService.editAddress(addressCro.toDto()));
//        } catch (MyShopException ex){
//            return failure(ex.getErrorCode(),ex.getMessage());
//        }
    }
}
