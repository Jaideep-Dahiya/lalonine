package com.example.storeFile;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private int price;
    private int quantity;
}
