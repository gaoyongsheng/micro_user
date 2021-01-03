package com.shopping.micro.user.cro;

import com.shopping.micro.user.cro.base.BaseCro;
import com.shopping.micro.user.dto.AddressDto;

/**
 * @Author ldc
 * @Date 2020/12/2 11:44
 * @Version 1.0
 */
public class AddressCro extends BaseCro {

    private Long id;

    private String addrUser;

    private String addrMobile;

    private String addrProvince;

    private String addrCity;

    private String addrCounty;

    private String addrDetail;

    public AddressDto toDto(){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(id);
        addressDto.setAddrUser(addrUser);
        addressDto.setAddrMobile(addrMobile);
        addressDto.setAddrProvince(addrProvince);
        addressDto.setAddrCity(addrCity);
        addressDto.setAddrCounty(addrCounty);
        addressDto.setAddrDetail(addrDetail);
        return addressDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddrUser() {
        return addrUser;
    }

    public void setAddrUser(String addrUser) {
        this.addrUser = addrUser;
    }

    public String getAddrMobile() {
        return addrMobile;
    }

    public void setAddrMobile(String addrMobile) {
        this.addrMobile = addrMobile;
    }

    public String getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(String addrProvince) {
        this.addrProvince = addrProvince;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrCounty() {
        return addrCounty;
    }

    public void setAddrCounty(String addrCounty) {
        this.addrCounty = addrCounty;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }
}
