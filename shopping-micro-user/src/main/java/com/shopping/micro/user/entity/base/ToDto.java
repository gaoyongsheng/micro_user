package com.shopping.micro.user.entity.base;

import java.io.Serializable;

public interface ToDto<T> extends Serializable {
    T toDto();
}
