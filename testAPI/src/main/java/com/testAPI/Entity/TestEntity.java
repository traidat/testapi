package com.testAPI.Entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "TestEntity")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(name = "deviceName")
    String deviceName;

    @Column(name = "ts")
    Long ts;

    @Column(name = "alert")
    String alert;
}
