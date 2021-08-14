package com.cxd.mapper;

import com.cxd.pojo.Hotel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HotelMapper {
    List<Hotel>  queryHotelList();

    Hotel queryHotelById(int Id);
}
