package com.example.TDD;

import com.example.TDD.model.BookingModel;
import com.example.TDD.repository.BookingRepository;
import com.example.TDD.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;



import static org.mockito.Mockito.any;

import java.time.LocalDate;
import java.util.Optional;


@RunWith(SpringRunner.class)
public class BookingServiceTest {

    BookingModel bookingModel;

    @TestConfiguration
    static class bookServiceTestConfiguration{

        @Bean
        public BookingService bookingService(){
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator(){
        String name = "geninho";
        Mockito.when(bookingRepository.findByReserveName(any())).thenReturn(Optional.of(bookingModel));
        int days = bookingService.daysCalculatorWithDatabase(name);
        Assertions.assertEquals(days,10);
    }

    @Before
    public void setup(){
        LocalDate checkIn = LocalDate.parse("2022-11-10");
        LocalDate checkOut = LocalDate.parse("2022-11-20");
        bookingModel = new BookingModel("1","Geninho",checkIn,checkOut,2);

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(Optional.of(bookingModel));
    }
}
