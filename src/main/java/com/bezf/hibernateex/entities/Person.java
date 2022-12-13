package com.bezf.hibernateex.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "People")
public class Person {
    @EmbeddedId
    private PersonalData personal_data;
    private String phone_number;
    private String city_of_living;
}
