package com.i2s.data_kendaraan_api.service.KendaraanService;

import java.util.List;

import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanDto;
import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanFilter;

public interface KendaraanService {
    public List<KendaraanDto> getKendaraanListData(KendaraanFilter filter);
    public KendaraanDto getKendaraanData(String registrationNumber);
    public KendaraanDto createKendaraanData(KendaraanDto kendaraanModel);
    public KendaraanDto editKendaraanData(KendaraanDto kendaraanModel);
    public KendaraanDto deleteKendaraanData(String registrationNumber);
}
