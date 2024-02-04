package com.book;

import com.book.entity.BookingEntity;
import com.book.repository.BookingRepo;
import com.book.service.BookingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class HotelBookApplicationTests {

    @Mock
    private BookingRepo bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void getAllBookings() {
        // Mock data
        BookingEntity booking1 = new BookingEntity();
        booking1.setId(1);
        booking1.setUserId("user1");
        booking1.setHotelName("Hotel A");

        BookingEntity booking2 = new BookingEntity();
        booking2.setId(2);
        booking2.setUserId("user2");
        booking2.setHotelName("Hotel B");

        List<BookingEntity> mockBookings = Arrays.asList(booking1, booking2);

        // Mock repository behavior
        when(bookingRepository.findAll()).thenReturn(mockBookings);

        // Test service method
        List<BookingEntity> result = bookingService.getAllBookings();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals(booking1, result.get(0));
        assertEquals(booking2, result.get(1));
    }

    @Test
    void createBooking() {
        // Mock data
        BookingEntity newBooking = new BookingEntity();
        newBooking.setUserId("user3");
        newBooking.setHotelName("Hotel C");

        // Mock repository behavior
        when(bookingRepository.save(Mockito.any(BookingEntity.class))).thenReturn(newBooking);

        // Test service method
        BookingEntity result = bookingService.createBooking(newBooking);

        // Verify the result
        assertEquals(newBooking, result);
    }




}
