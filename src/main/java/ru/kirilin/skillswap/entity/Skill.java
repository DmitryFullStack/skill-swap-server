package ru.kirilin.skillswap.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "skills")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Skill {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne
    private User user;

    private String name;
    private Integer experience;
    private Level level;
    private BigDecimal price;
}
