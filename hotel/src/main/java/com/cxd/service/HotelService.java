package com.cxd.service;

import com.cxd.pojo.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> queryHotelList();

    Hotel queryHotelById(int Id);

}
