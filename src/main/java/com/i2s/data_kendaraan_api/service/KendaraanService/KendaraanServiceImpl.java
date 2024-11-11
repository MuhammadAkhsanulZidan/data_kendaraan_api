package com.i2s.data_kendaraan_api.service.KendaraanService;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.i2s.data_kendaraan_api.exception.ResourceNotFoundException;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanDto;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanFilter;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanModel;
import com.i2s.data_kendaraan_api.repository.KendaraanRepository;
import com.i2s.data_kendaraan_api.util.MappingUtil;

import jakarta.validation.Valid;

@Service
public class KendaraanServiceImpl implements KendaraanService {
    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Override
    public List<KendaraanDto> getKendaraanListData(KendaraanFilter filter) {
        List<KendaraanModel> kendaraanList;
        if (filter.getRegistrationNumber() != null) {
            kendaraanList = kendaraanRepository.findAllByRegistrationNumberContaining(filter.getRegistrationNumber());
        } else if (filter.getOwnerName() != null) {
            kendaraanList = kendaraanRepository.findAllByOwnerNameContaining(filter.getOwnerName());
        } else {
            kendaraanList = kendaraanRepository.findAll();
        }
        return MappingUtil.mapList(kendaraanList, KendaraanDto.class);
    }

    @Override
    public KendaraanDto getKendaraanData(String registrationNumber) {
        Optional<KendaraanModel> kendaraanData = kendaraanRepository.findByRegistrationNumber(registrationNumber);
        if (kendaraanData.isPresent()) {
            return MappingUtil.map(kendaraanData.get(), KendaraanDto.class);
        } else {
            throw new ResourceNotFoundException("Kendaraan data with " + registrationNumber + " is not found");
        }
    }

    @Override
    public KendaraanDto createKendaraanData(@Valid KendaraanDto kendaraanModel) {
        KendaraanModel savedKendaraan = kendaraanRepository.save(MappingUtil.map(kendaraanModel, KendaraanModel.class));
        return MappingUtil.map(savedKendaraan, KendaraanDto.class);
    }

    @Override
    public KendaraanDto editKendaraanData(KendaraanDto kendaraanEdit) {
        System.err.println(kendaraanEdit.getRegistrationNumber());
        KendaraanDto kendaraanData = getKendaraanData(kendaraanEdit.getRegistrationNumber());
        MappingUtil.setPatchedData(kendaraanEdit, kendaraanData);
        kendaraanRepository.save(MappingUtil.map(kendaraanData, KendaraanModel.class));
        return kendaraanData;
    }

    @Transactional
    @Override
    public KendaraanDto deleteKendaraanData(String registrationNumber) {
        KendaraanDto kendaraanDto = getKendaraanData(registrationNumber);
        System.out.println(kendaraanDto.getRegistrationNumber());
        kendaraanRepository.deleteByRegistrationNumber(kendaraanDto.getRegistrationNumber());
        return MappingUtil.map(kendaraanDto, KendaraanDto.class);
    }

}
