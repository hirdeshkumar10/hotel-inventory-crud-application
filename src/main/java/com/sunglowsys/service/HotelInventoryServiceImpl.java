package com.sunglowsys.service;
import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.repository.HotelInventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelInventoryServiceImpl implements HotelInventoryService{

    private final Logger log = LoggerFactory.getLogger(HotelInventoryServiceImpl.class);

    private final HotelInventoryRepository hotelInventoryRepository;

    public HotelInventoryServiceImpl(HotelInventoryRepository hotelInventoryRepository) {
        this.hotelInventoryRepository = hotelInventoryRepository;
    }


    @Override
    public HotelInventory create(HotelInventory hotelInventory) {
        log.debug("Request to save HotelInventory: {}",hotelInventory);
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public HotelInventory update(HotelInventory hotelInventory) {
        log.debug("Request to update HotelInventory: {}",hotelInventory);
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public Page<HotelInventory> getAll(Pageable pageable) {
        log.debug("Request to get to all HotelInventory: {}",pageable.toString());
        return hotelInventoryRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelInventory> findById(Long id) {
        log.debug("Request to get By id HotelInventory: {}",id);
        return hotelInventoryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete HotelInventory: {}",id);
        hotelInventoryRepository.deleteById(id);

    }
}
