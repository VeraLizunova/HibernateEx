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
    private PersonalData personalData;
    private String phoneNumber;
    private String cityOfLiving;
}
