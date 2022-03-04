package com.assessment.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "consoles")
@AllArgsConstructor
@NoArgsConstructor
public class Console {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String company;
     private String name;
}
