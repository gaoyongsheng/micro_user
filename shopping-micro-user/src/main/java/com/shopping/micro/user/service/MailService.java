package com.shopping.micro.user.service;

import com.shopping.micro.user.vo.MailVo;

/**
 * @Author Gao
 * @Date 2020/12/25 23:52
 * @Version 1.0
 */
public interface MailService {

    MailVo sendMail(MailVo mailVo);
}
