package com.example.realTemp.service;



import com.example.realTemp.entity.Drivers;
import com.example.realTemp.setting.PageSettings;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface DriverService {

    List<Drivers> findAllDriver();
    Drivers putDriver(Drivers driver);
    Drivers updateDriver(Drivers driver, UUID id);
    Drivers deleteDriverById(UUID id);
    Drivers findDriverById(UUID id);

    Page<Drivers> getDriverPage(PageSettings pageSetting);
}
