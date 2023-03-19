package com.maintec.fincore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(
        name = "PHOTOGRAPHS",
        schema = "public"
)
@Data
public class Images {
    @Id
    @Column(name = "FC_IMAGE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IMAGE_SEQUENCER")
    @SequenceGenerator(
            name = "IMAGE_SEQUENCER",
            sequenceName = "IMAGE_SEQUENCER"
    )
    private Long id;
    @Column(
            name = "FC_TITLE",
            length = 255
    )
    private String title;
    @Column(
            name = "FC_IMAGE_URL",
            length = 255
    )
    private String imageURL;
    @Column(
            name = "FC_IMAGE_TYPE",
            length = 255
    )
    private String imageType;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "FC_ENTERED_BY"
    )
    private User enteredBy;
    @Column(
            name = "FC_ENTERED_DATE"
    )
    private LocalDate enteredDate;
    @Column(
            name = "FC_EXPIRY_DATE"
    )
    private String expiryDate;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "BRANCH"
    )
    private Branch branch;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "FC_ID_IMAGES"
    )
    private ID parentID;
    @Version
    @Column(
            name = "FC_VERSION_ID",
            nullable = false
    )
    private long versionID;
}
