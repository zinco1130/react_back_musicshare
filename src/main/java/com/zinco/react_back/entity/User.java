package com.zinco.react_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "User_ID", nullable = false, unique = true)
    private String userId;

    @Column(name = "PW", nullable = false)
    private String password;

    @Column(name = "Nickname")
    private String nickname;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Picture> pictures;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Comment> comments;
}
