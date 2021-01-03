package com.shopping.micro.user.service;

import com.shopping.micro.user.dto.AddressDto;
import com.shopping.micro.user.entity.Address;

import java.util.List;

/**
 * @Author Gao
 * @Date 2020/12/2 10:25
 * @Version 1.0
 */
public interface AddressService {

    /**
     * @Author Gao
     * @Description //TODO 
     * @Date 10:52 2020/12/2
     * @Param [address]
     * @return void
     */
    void createAddress(AddressDto addressDto);
    
    /**
     * @Author ldc
     * @Description //TODO 
     * @Date 10:56 2020/12/2
     * @Param []
     * @return java.util.List<com.shopping.demo.entity.Address>
     */
    List<Address> findAllAddress(Long userId);

    /**
     * @Author ldc
     * @Description //TODO
     * @Date 17:26 2020/12/2
     * @Param [id]
     * @return com.shopping.demo.entity.Address
     */
    Address findAddressById(Long id);
    
    /**
     * @Author ldc
     * @Description //TODO 
     * @Date 10:59 2020/12/2
     * @Param [address]
     * @return com.shopping.demo.entity.Address
     */
    Address editAddress(AddressDto addressDto);
    
    /**
     * @Author ldc
     * @Description //TODO 
     * @Date 11:31 2020/12/2
     * @Param [address]
     * @return void
     */
    void deleteAddress(AddressDto addressDto);

}
