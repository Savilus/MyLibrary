package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date rentalDate;
    private Date returnDate;
    private Date maxReturnDate;
    private double fine;

    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;


}
