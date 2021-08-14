package com.cxd.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //数据库修改下，加一个userId
    Integer orderId;
    String checkName;
    String checkPhone;
    String arriveTime;
    String leaveTime;
    Integer checkNum;
    Integer roomId;
    Integer userId;

    public Order(String checkName, String checkPhone, String arriveTime, String leaveTime,Integer checkNum ,Integer roomId, Integer userId) {
        this.checkName = checkName;
        this.checkPhone = checkPhone;
        this.arriveTime = arriveTime;
        this.leaveTime = leaveTime;
        this.checkNum =checkNum;
        this.roomId = roomId;
        this.userId = userId;
    }

    /* SimpleDateFormatsdf= new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

        Date nowDate= new Date();

        StringdateString= sdf.format(nowDate);*/

}
