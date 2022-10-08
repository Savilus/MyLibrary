package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter @Setter
public class RentedBook {

    private String title;
    private Date rentalDate;
    private Date deadlineReturnDate;
    private double fine;

}
