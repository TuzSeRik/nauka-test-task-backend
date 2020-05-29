package io.github.tuzserik.naukatesttaskbackend.model;

import lombok.Getter;

import javax.persistence.*;

@SuppressWarnings("FieldMayBeFinal")
@Entity
@Table(name = "IMAGES_TABLE")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "image")
    private User user;

    @Column(name = "NAME", nullable = false, unique = true)
    @Getter
    private String name;

    @Column(name = "TYPE", nullable = false)
    @Getter
    private String type;

    @Column(name = "DATA", nullable = false)
    @Getter
    private byte[] data;

    public Image() {}

    public Image(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
