package com.example.Sample.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    private int pid;
    private String name;
    private double price;
    private String company;
    
    @JsonFormat(pattern = "HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalTime time;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
