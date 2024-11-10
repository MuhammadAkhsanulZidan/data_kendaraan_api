package com.i2s.data_kendaraan_api.model.kendaraan;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KendaraanDto {
    @JsonProperty("registration_number")
    private String registrationNumber;

    @JsonProperty("owner_name")
    private String ownerName;

    private String brand;

    @JsonProperty("production_year")
    private BigDecimal productionYear;

    @JsonProperty("cilinder_capacity")
    private BigDecimal cilinderCapacity;

    @JsonProperty("color_id")
    private String colorId;

    private String fuel;

}
