package com.example.realTemp.service;

import com.example.realTemp.entity.Drivers;
import com.example.realTemp.entity.Vehical;
import com.example.realTemp.entity.VehicalDto;

import java.util.List;
import java.util.UUID;

public interface VehicalService {
    VehicalDto SaveVehical(VehicalDto vehical);
    List<VehicalDto> GetAllVehicals();
    Vehical findVehicalById(UUID id);
}
