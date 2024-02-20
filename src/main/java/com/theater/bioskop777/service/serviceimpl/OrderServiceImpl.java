package com.theater.bioskop777.service.serviceimpl;

import com.theater.bioskop777.dto.request.OrderRequest;
import com.theater.bioskop777.dto.respon.ControllerResponse;
import com.theater.bioskop777.entity.Customer;
import com.theater.bioskop777.entity.Seat;
import com.theater.bioskop777.entity.Theater;
import com.theater.bioskop777.entity.Ticket;
import com.theater.bioskop777.repository.CustomerRepository;
import com.theater.bioskop777.repository.SeatRepository;
import com.theater.bioskop777.repository.TheaterRepository;
import com.theater.bioskop777.repository.TicketRepository;
import com.theater.bioskop777.service.OrderService;
import com.theater.bioskop777.util.AgeUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final CustomerRepository customerRepository;

    private final SeatRepository seatRepository;

    private final TicketRepository ticketRepository;

    private final TheaterRepository theaterRepository;

    public OrderServiceImpl(CustomerRepository customerRepository, SeatRepository seatRepository, TicketRepository ticketRepository, TheaterRepository theaterRepository) {
        this.customerRepository = customerRepository;
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
        this.theaterRepository = theaterRepository;
    }

    @Transactional
    @Override
    public ResponseEntity<?> orderTicket(OrderRequest orderRequest) {

        // customer validation
        Optional<Customer> customer = customerRepository.findById(orderRequest.getCustomerId());
        if (customer.isEmpty()) {
            ControllerResponse<Customer> customerNotFound = ControllerResponse.<Customer>builder()
                    .status("Failed")
                    .message("Failed")
                    .data(null)
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerNotFound);
        }

        // seat validation
        Optional<Seat> seat = seatRepository.findById(orderRequest.getSeatId());
        if (seat.isEmpty()) {
            ControllerResponse<Customer> seatNotFound = ControllerResponse.<Customer>builder()
                    .status("Failed")
                    .message("Failed")
                    .data(null)
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(seatNotFound);
        }

        // rating validation
        LocalDate birthDate = customer.get().getBirthDate().toLocalDate();
        int age = AgeUtil.ageCounter(birthDate);

        Integer ageRating = seat.get()
                .getTheater()
                .getMovie()
                .getRating().getAge();

        if (age < ageRating) {
            ControllerResponse<?> ageNotValid = ControllerResponse.builder()
                    .status("Failed")
                    .message("Belum cukup umur")
                    .data(null)
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ageNotValid);
        }
        Seat existingSeat = seat.get();
        Customer existingCustomer = customer.get();
        Ticket ticket = new Ticket();
        ticket.setSeat(existingSeat);
        ticket.setCustomer(existingCustomer);

        ticketRepository.save(ticket);

        // update stock chair
        Theater theater = seat.get().getTheater();
        Integer stock = theater.getStock();
        theater.setStock(stock -1);

        theaterRepository.save(theater);

        ControllerResponse<?> successResponse = ControllerResponse.builder()
                .status("Success")
                .message("Order success")
                .data("ticket")
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);

    }

}
