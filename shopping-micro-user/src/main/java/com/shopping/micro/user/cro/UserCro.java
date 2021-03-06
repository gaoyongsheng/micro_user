package com.shopping.micro.user.cro;

import com.shopping.micro.user.cro.base.BaseCro;

public class UserCro extends BaseCro {

    // 当前第几页。从0开始
    private int offset;
    // 每页的数量
    private int pageSize;

    public UserCro() {}

    public UserCro(int offset, int pageSize) {
        this.offset = offset;
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
