package ru.kirilin.skillswap.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "requirements")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Requirement {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private Level level;
}
