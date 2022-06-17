package com.example.TDD.model;

import java.time.LocalDate;

public class BookingModel {
    private String id;
    private String reserveName;
    private LocalDate checkin;
    private LocalDate checkout;
    private int numberGuest;

    public BookingModel(String id, String reserveName, LocalDate checkin, LocalDate checkout, int numberGuest) {
        this.id = id;
        this.reserveName = reserveName;
        this.checkin = checkin;
        this.checkout = checkout;
        this.numberGuest = numberGuest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public int getNumberGuest() {
        return numberGuest;
    }

    public void setNumberGuest(int numberGuest) {
        this.numberGuest = numberGuest;
    }
}
