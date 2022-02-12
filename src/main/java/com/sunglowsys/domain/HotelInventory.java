package com.sunglowsys.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "hotel_inventory")
public class HotelInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "hotel_inventory")
    private String hotelInventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelInventory() {
        return hotelInventory;
    }

    public void setHotelInventory(String hotelInventory) {
        this.hotelInventory = hotelInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelInventory that = (HotelInventory) o;
        return Objects.equals(id, that.id) && Objects.equals(hotelInventory, that.hotelInventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelInventory);
    }

    @Override
    public String toString() {
        return "HotelInventory{" +
                "id=" + id +
                ", hotelInventory='" + hotelInventory + '\'' +
                '}';
    }
}
