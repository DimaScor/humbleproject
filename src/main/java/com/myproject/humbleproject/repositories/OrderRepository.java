package com.myproject.humbleproject.repositories;

import com.myproject.humbleproject.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findUserByUserId(Long userId);

    Page<Order> findAll(Pageable pageable);

//    List<Order> findby();
}
