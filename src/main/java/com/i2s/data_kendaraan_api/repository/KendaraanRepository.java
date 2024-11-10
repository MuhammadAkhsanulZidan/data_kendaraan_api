package com.i2s.data_kendaraan_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.i2s.data_kendaraan_api.model.kendaraan.KendaraanModel;

import java.util.List;

@Repository
public interface KendaraanRepository extends JpaRepository<KendaraanModel, String>{
    List<KendaraanModel> findAllByRegistrationNumber(String registrationNumber);
    List<KendaraanModel> findAllByOwnerName(String ownerName);
    Optional<KendaraanModel> findByRegistrationNumber(String registrationNumber);
    void deleteByRegistrationNumber(String registrationNumber);
}
