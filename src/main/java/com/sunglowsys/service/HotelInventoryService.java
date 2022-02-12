package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface HotelInventoryService {

    HotelInventory create(HotelInventory hotelInventory);

    HotelInventory update(HotelInventory hotelInventory ,Long id);

    List<HotelInventory> getAll();

    HotelInventory find(Long Id);

    void delete(Long id);

}
