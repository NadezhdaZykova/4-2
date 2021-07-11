package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class FlyTicket implements Comparable<FlyTicket> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTime;

    public int compareTo(FlyTicket o) {
        return this.price - o.price;
    }
}
