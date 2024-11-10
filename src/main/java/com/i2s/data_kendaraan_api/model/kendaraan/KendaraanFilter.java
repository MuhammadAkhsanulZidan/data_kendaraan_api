package com.i2s.data_kendaraan_api.model.kendaraan;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KendaraanFilter {
    @JsonProperty("registration_number")
    private String registrationNumber;

    @JsonProperty("owner_name")
    private String ownerName;
}
