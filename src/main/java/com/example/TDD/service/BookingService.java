package com.example.TDD.service;

import com.example.TDD.model.BookingModel;
import com.example.TDD.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalculatorWithDatabase(String name) {
        Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);
        if(bookingModelOptional.isPresent()){
            return  Period.between(
                            bookingModelOptional.get().getCheckin(),
                            bookingModelOptional.get().getCheckout())
                    .getDays();
        }
        return 0;
    }
}
