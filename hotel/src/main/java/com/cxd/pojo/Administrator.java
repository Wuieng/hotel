package com.cxd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator {
/*
*- 登录-java
- 帮助客户重置密码，生成新的随机密码
- 注销客户
* - 登录-python
- 管理员新增酒店
- 管理员帮助酒店工作人员注册账号*/
    private Integer Id;
    private String Password;

}
