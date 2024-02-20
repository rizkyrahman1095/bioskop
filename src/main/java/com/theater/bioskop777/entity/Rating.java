package com.theater.bioskop777.entity;


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
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String description;
    @OneToMany(mappedBy = "rating")
    private List<Movie> movies = new ArrayList<>();

}
