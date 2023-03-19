package com.maintec.fincore.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
}
