package com.cxd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /*- 注册、登录
- 浏览、维护基本信息（比如姓名或名称，联系方式等字段)
- 查看酒店列表和基本信息
- 单独查看酒店细节信息（比如地址、简介、设施服务、房客类型、价格）
- 选择预定酒店
- 设置入住时间、退房时间、房间类型及数量、预计入住人数、有无儿童等
- 浏览自己预定的正常订单*/

    private Integer Id;
    private String Name;
    private String Password;
    private String Phone;

    public User(Integer id, String password) {
        Id = id;
        Password = password;
    }
}
