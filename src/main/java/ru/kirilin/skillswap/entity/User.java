package ru.kirilin.skillswap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private AccountId id;

    private String login;
    private String name;
    private UUID logoId;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Skill> skills;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Requirement> requirements;

    @Getter
    @Setter
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class AccountId implements Serializable {
        @EqualsAndHashCode.Include
        private String accountNumber;
        @Enumerated(EnumType.STRING)
        @EqualsAndHashCode.Include
        private AccountType accountType;
    }
}
