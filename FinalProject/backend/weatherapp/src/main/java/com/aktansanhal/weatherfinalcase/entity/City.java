package com.aktansanhal.weatherfinalcase.entity;

import com.aktansanhal.weatherfinalcase.general.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class City extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

    @Column(name = "temp", length = 100)
    private String temp;

    @Column(name = "info_date", length = 100)
    private String infoDate;

    @Column(name = "icon", length = 100)
    private String icon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



}
