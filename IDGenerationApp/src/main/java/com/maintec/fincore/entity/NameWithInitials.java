package com.maintec.fincore.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class NameWithInitials {

    private String firstName;
    private String middleName;
    private String lastName;
    private String initial;

    @SuppressWarnings("JpaAttributeMemberSignatureInspection")
    public String getFullName() {

        StringBuffer sb = new StringBuffer();

        sb.append(firstName);

        if( middleName != null ) {

            sb.append(" ");
            sb.append(middleName);
        }

        if( lastName != null ) {

            sb.append(" ");
            sb.append(lastName);
        }
        if( initial != null && !initial.equals("")) {
            sb.append(" ");
            sb.append(initial);
        }

        sb.append(" ");

        return sb.toString();
    }
}
