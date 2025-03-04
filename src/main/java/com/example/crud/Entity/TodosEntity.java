package com.example.crud.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Todos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class TodosEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String status;

}

