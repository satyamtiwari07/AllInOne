package com.example.realTemp.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderStatus {

    private Vehical vehical;
    private String status;//progress,completed
    private String message;
}
