package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class HelloWorldController {
    @GetMapping("/")
    public String hello() {
      return "hello world!"; 
    }

    @RequestMapping(value = "/bookings", produces = "application/json")
    public ResponseEntity<List<Booking>> getBookings() {
        List<Booking> bookings = new ArrayList<Booking>();
        Booking b = new Booking();
        b.setRef("OT-999999FT");
        b.setGuest("Mr. Friar");
        bookings.add(b);
        b = new Booking();
        b.setRef("OT-888888CT");
        b.setGuest("Mr. Clement");
        bookings.add(b);
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }
}

