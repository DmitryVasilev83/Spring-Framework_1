package ru.geekbrains.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;
    private String title;
    private float cost;
}
