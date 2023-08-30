package com.workintech.plant.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data

@AllArgsConstructor
public class FruitResponse {
    private int status;
    private String message;
    private long timestamp;
}
