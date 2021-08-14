package com.cxd.service.serviceimpl;

import com.cxd.mapper.HotelMapper;
import com.cxd.pojo.Hotel;
import com.cxd.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    //查询所有的hotel
    @Override
    public List<Hotel> queryHotelList() {
        return hotelMapper.queryHotelList();
    }

//    用于点击查询具体的某一个酒店
    @Override
    public Hotel queryHotelById(int Id) {
        return null;
    }
}
