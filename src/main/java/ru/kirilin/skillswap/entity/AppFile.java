package ru.kirilin.skillswap.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "files")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AppFile {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private UUID id;
    @Enumerated(EnumType.STRING)
    private FileType fileType;
    @Lob
    @Column(name = "data")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;
}
