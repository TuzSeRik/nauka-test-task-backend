package io.github.tuzserik.naukatesttaskbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USERS_TABLE")
@JsonIgnoreProperties({"password"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, unique = true)
    @Getter
    private long id;

    @Column(name = "LOGIN", nullable = false, unique = true)
    @Setter
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    @Setter
    private String password;

    @OneToOne
    @JoinColumn(name = "id")
    @Setter
    private Image image;

    @Column(name = "NAME", nullable = false)
    @Setter
    private String name;

    @Column(name = "SECOND_NAME")
    @Setter
    private String secondName;

    @Column(name = "FAMILY_NAME", nullable = false)
    @Setter
    private String familyName;

    @Column(name = "BIRTHDAY_DATE", nullable = false)
    @Setter
    private long birthdayDate;

    @Column(name = "POSITION", nullable = false)
    @Setter
    private String position;

    @Column(name = "IS_WORKING_FROM_HOME", nullable = false)
    @Setter
    private boolean isWorkingFromHome;

    @Column(name = "CITY")
    @Setter
    private String city;

    @Column(name = "STREET")
    @Setter
    private String street;

    @Column(name = "HOUSE")
    @Setter
    private int house;

    @Column(name = "FLAT")
    @Setter
    private int flat;
}
