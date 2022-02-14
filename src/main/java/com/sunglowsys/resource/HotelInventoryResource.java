package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.service.HotelInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelInventoryResource {

    private final Logger log = LoggerFactory.getLogger(HotelInventoryResource.class);

    private final HotelInventoryService hotelInventoryService;

    public HotelInventoryResource(HotelInventoryService hotelInventoryService) {
        this.hotelInventoryService = hotelInventoryService;
    }

    @PostMapping("/hotel-inventories")
    public ResponseEntity<?> createHotelInventory(@RequestBody HotelInventory hotelInventory) throws URISyntaxException {
        log.debug("Rest Request to save HotelInventory: {}",hotelInventory);
        if (hotelInventory.getId() != null){
            throw new RuntimeException("Id should be null in create API calls");
        }
        HotelInventory result = hotelInventoryService.create(hotelInventory);
        return ResponseEntity
                .created(new URI("/api/hotel-inventories/"+result.getId()))
                .body("HotelInventory is created:"+result);
    }

    @GetMapping("/hotel-inventories")
    public ResponseEntity<List<HotelInventory>> getAllHotelInventory(Pageable pageable){
        log.debug("Rest Request to get to all HotelInventory: {}",pageable.toString());
        Page<HotelInventory> result = hotelInventoryService.getAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());

    }

    @GetMapping("/hotel-inventories/{id}")
    public ResponseEntity<HotelInventory> findHotelInventoryById(@PathVariable("id") Long id){
        log.debug("Request to get all HotelInventories: {}",id);
        Optional<HotelInventory> result = hotelInventoryService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @PutMapping("/hotel-inventories")
    public ResponseEntity<HotelInventory> updateHotelInventory(@RequestBody HotelInventory hotelInventory){
        log.debug("Request to update HotelInventories: {}",hotelInventory);
        if (hotelInventory.getId() == null){
            throw new RuntimeException("Id should be not null to update api calls");
        }
        HotelInventory result = hotelInventoryService.update(hotelInventory);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/hotel-inventories/{id}")
    public ResponseEntity<Void> deleteHotelInventory(@PathVariable Long id){
        log.debug("Request to update HotelInventories: {}",id);
        hotelInventoryService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
