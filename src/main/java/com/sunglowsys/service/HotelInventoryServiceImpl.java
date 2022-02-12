package com.sunglowsys.service;
import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.repository.HotelInventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelInventoryServiceImpl implements HotelInventoryService{

    private final HotelInventoryRepository hotelInventoryRepository;

    public HotelInventoryServiceImpl(HotelInventoryRepository hotelInventoryRepository) {
        this.hotelInventoryRepository = hotelInventoryRepository;
    }


    @Override
    public HotelInventory create(HotelInventory hotelInventory) {
        return hotelInventoryRepository.save(hotelInventory);
    }

    @Override
    public HotelInventory update(HotelInventory hotelInventory, Long id) {
        HotelInventory result = hotelInventoryRepository.findById(id).get();
        result.setHotelInventory(hotelInventory.getHotelInventory());
        return hotelInventoryRepository.save(result);
    }

    @Override
    public List<HotelInventory> getAll() {
        return hotelInventoryRepository.findAll();
    }

    @Override
    public HotelInventory find(Long id) {
        return hotelInventoryRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        hotelInventoryRepository.deleteById(id);

    }
}
