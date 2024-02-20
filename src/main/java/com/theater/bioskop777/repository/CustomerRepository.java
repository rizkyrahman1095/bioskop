package com.theater.bioskop777.repository;

import com.theater.bioskop777.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
