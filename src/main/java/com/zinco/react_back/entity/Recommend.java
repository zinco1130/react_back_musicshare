package com.zinco.react_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Recommend")
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recommandId;

    @ManyToOne
    @JoinColumn(name = "Picture_ID", referencedColumnName = "Picture_ID")
    private Picture picture;

    @Column(name = "Content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "Music_ID", referencedColumnName = "Music_ID")
    private Music music;
}