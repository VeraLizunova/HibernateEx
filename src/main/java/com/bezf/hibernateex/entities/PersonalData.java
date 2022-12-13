package com.bezf.hibernateex.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonalData implements Serializable {
    private String name;
    private String surname;
    private int age;
}
