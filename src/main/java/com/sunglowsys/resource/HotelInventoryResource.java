package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.service.HotelInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelInventoryResource {

    private final HotelInventoryService hotelInventoryService;

    public HotelInventoryResource(HotelInventoryService hotelInventoryService) {
        this.hotelInventoryService = hotelInventoryService;
    }

    @PostMapping("/hotel-inventories")
    public ResponseEntity<?> createHotelInventory(@RequestBody HotelInventory hotelInventory){
        HotelInventory hotelInventory1 = hotelInventoryService.create(hotelInventory);
        return ResponseEntity.ok().body("HotelInventory si created:"+hotelInventory1);
    }

    @GetMapping("/hotel-inventories")
    public ResponseEntity<List<HotelInventory>> getAllHotelInventory(){
        List<HotelInventory> hotelInventoryList = hotelInventoryService.getAll();
        return ResponseEntity.ok().body(hotelInventoryList);

    }

    @GetMapping("/hotel-inventories/{id}")
    public ResponseEntity<HotelInventory> findHotelInventoryById(@PathVariable("id") Long id){
        HotelInventory hotelInventory1 = hotelInventoryService.find(id);
        return ResponseEntity.ok().body(hotelInventory1);
    }

    @PutMapping("/hotel-inventories/{id}")
    public ResponseEntity<?> updateHotelInventory(@RequestBody HotelInventory hotelInventory, @PathVariable("id") Long id){
        hotelInventoryService.update(hotelInventory, id);
        return ResponseEntity.ok().body(hotelInventory);
    }

    @DeleteMapping("/hotel-inventories/{id}")
    public void deleteHotelInventory(@PathVariable("id") Long id){
        hotelInventoryService.delete(id);
    }
}
