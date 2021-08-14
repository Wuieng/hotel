package com.cxd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private Integer Id;
    private String Name;
    private String Address;
    private String Phone;
    private String Intro;

    public Hotel(String name, String address, String phone, String intro) {
        Name = name;
        Address = address;
        Phone = phone;
        Intro = intro;
    }
}
