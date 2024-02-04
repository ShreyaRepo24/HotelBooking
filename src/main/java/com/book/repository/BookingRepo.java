package com.book.repository;

import com.book.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<BookingEntity,Integer> {
}
