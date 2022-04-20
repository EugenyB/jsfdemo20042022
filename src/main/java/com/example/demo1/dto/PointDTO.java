package com.example.demo1.dto;

import com.example.demo1.model.Point;

public class PointDTO extends Point {
    public PointDTO(double x, double y) {
        super(x, y);
    }

    public String getStrX() {
        return String.format("%4.1f", getX());
    }

    public String getStrY() {
        return String.format("%8.6f", getY());
    }
}
