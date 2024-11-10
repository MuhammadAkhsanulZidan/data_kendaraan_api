package com.i2s.data_kendaraan_api.model.kendaraan;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "[vehicle_info]")
public class KendaraanModel {
    @Id
    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "brand")
    private String brand;

    @Column(name = "production_year", length = 4)
    private BigDecimal productionYear;

    @Column(name = "cilinder_capacity")
    private BigDecimal cilinderCapacity;

    @Column(name = "color_id")
    private String colorId;

    @Column(name = "fuel")
    private String fuel;
}
