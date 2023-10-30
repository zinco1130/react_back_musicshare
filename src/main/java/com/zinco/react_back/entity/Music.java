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
@Table(name = "Music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer musicId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Singer")
    private String singer;

    @OneToMany(mappedBy = "music")
    @ToString.Exclude
    private Set<Comment> comments;

    @OneToMany(mappedBy = "music")
    @ToString.Exclude
    private Set<Recommend> recommandations;
}
