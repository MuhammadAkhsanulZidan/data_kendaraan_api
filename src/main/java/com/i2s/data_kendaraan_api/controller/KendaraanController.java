package com.i2s.data_kendaraan_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i2s.data_kendaraan_api.dto.APIResponseDto;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanDto;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanFilter;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanModel;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanDto;
import com.i2s.data_kendaraan_api.service.KendaraanService.KendaraanService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/kendaraan")
public class KendaraanController {
    @Autowired
    private KendaraanService kendaraanService;

    @GetMapping
    public ResponseEntity<APIResponseDto<List<KendaraanDto>>> getKendaraanListData(
            @RequestParam(name = "registration_number", required = false) String registrationNumber,
            @RequestParam(name = "owner_name", required = false) String ownerName) {

        KendaraanFilter filter = new KendaraanFilter(registrationNumber, ownerName);
        
        List<KendaraanDto> kendaraanList = kendaraanService.getKendaraanListData(filter);
        APIResponseDto<List<KendaraanDto>> response = new APIResponseDto<>(HttpStatus.OK.toString(), "",
                kendaraanList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{registration_number}")
    public ResponseEntity<APIResponseDto<KendaraanDto>> getKendaraanData(
            @PathVariable("registration_number") String registrationNumber) {

        KendaraanDto kendaraan = kendaraanService.getKendaraanData(registrationNumber);
        APIResponseDto<KendaraanDto> response = new APIResponseDto<>(HttpStatus.OK.toString(), "",
                kendaraan);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponseDto<KendaraanDto>> createKendaraanData(@RequestBody KendaraanDto kendaraanDto) {
        KendaraanDto kendaraanData = kendaraanService.createKendaraanData(kendaraanDto);
        APIResponseDto<KendaraanDto> response = new APIResponseDto<>(HttpStatus.OK.toString(), "Data berhasil dibuat", kendaraanData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> editKendaraanData(@RequestBody KendaraanDto kendaraanDto){
        System.err.println(kendaraanDto.getRegistrationNumber());
        KendaraanDto kendaraanData = kendaraanService.editKendaraanData(kendaraanDto);
        APIResponseDto<KendaraanDto> response = new APIResponseDto<>(HttpStatus.OK.toString(), "Data "+kendaraanDto.getRegistrationNumber()+" berhasil diedit", kendaraanData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<APIResponseDto<KendaraanDto>> deleteKendaraanData(@RequestParam(required = true, name = "registration_number") String registrationNumber ){
        KendaraanDto kendaraanData = kendaraanService.deleteKendaraanData(registrationNumber);
        APIResponseDto<KendaraanDto> response = new APIResponseDto<>(HttpStatus.OK.toString(), "Data "+registrationNumber+" berhasil dihapus", kendaraanData);
        return new ResponseEntity<>(response, HttpStatus.OK);    
    }
}
