package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface HotelInventoryService {

    HotelInventory create(HotelInventory hotelInventory);

    HotelInventory update(HotelInventory hotelInventory );

    Page<HotelInventory> getAll(Pageable pageable);

    Optional<HotelInventory> findById(Long Id);

    void delete(Long id);

}
