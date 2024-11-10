package com.i2s.data_kendaraan_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIResponseDto<T> {
    @JsonProperty("response_status")
    private String status;
    
    @JsonProperty("response_message")
    private String message;

    @JsonProperty("response_data")
    private T data;
}
