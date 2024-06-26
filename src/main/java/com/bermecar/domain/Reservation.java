package com.bermecar.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private int id;
    private Date datetime;
    private Car car;
    private User user;
}
