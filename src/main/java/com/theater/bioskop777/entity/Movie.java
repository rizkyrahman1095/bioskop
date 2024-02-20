package com.theater.bioskop777.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private Integer duration;

    @Column(name = "show_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String showDate;

    private String price;

    @OneToMany(mappedBy = "movie")
    private List<Theater> roomTheaterList = new ArrayList<>();

    @ManyToOne
    private Rating rating;

}
