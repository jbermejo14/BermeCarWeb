package com.bermecar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private int id;
    private String license_plate;
    private String brand;
    private String model;
    private String country;
    private int year;
    private float price;
    private String photo;
    private int user;
}
