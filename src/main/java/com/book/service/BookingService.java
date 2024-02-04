package com.book.service;

import com.book.entity.BookingEntity;
import com.book.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    public List<BookingEntity> getAllBookings() {
        return bookingRepo.findAll();
    }

    public BookingEntity createBooking(BookingEntity booking) {
        return bookingRepo.save(booking);
    }

    public void cancelBooking(Integer bookingId) {
        bookingRepo.deleteById(bookingId);
    }
}
