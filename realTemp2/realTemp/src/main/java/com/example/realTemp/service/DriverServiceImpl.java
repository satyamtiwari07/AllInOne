package com.example.realTemp.service;

import com.example.realTemp.dao.DriverDao;
import com.example.realTemp.entity.Drivers;
import com.example.realTemp.exception.DriverNotFoundException;
import com.example.realTemp.repository.DriverRepository;
import com.example.realTemp.setting.PageSettings;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverServiceImpl implements DriverService {

    DriverDao driverDao;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    public void DriverServiceImpl(DriverDao driverDao){
        this.driverDao = driverDao;
    }

    @Autowired
    public DriverServiceImpl(DriverRepository dr) {
        this.driverRepository = dr;
    }

    @Override
    public List<Drivers> findAllDriver() {

        List<Drivers>temp = driverRepository.findAll();
        return temp;
    }

    @Override
    public Drivers putDriver(Drivers driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Drivers updateDriver(Drivers driver, UUID id) {

        Drivers d = new Drivers();
        Optional<Drivers> s = driverRepository.findById(id);

        d=s.get();
        d.setfName(driver.getfName());
        d.setlName(driver.getlName());
        d.setAge(driver.getAge());
        d.setDescription(driver.getDescription());
        d.setVehicals(driver.getVehicals());

        return driverRepository.save(d);
    }

    @Override
    public Drivers deleteDriverById(UUID id) {
        Drivers d = findDriverById(id);
        driverRepository.deleteById(id);
        return d;
    }

    @Override
    public Drivers findDriverById(UUID id) {

        return driverRepository.findById(id).orElseThrow(()->new DriverNotFoundException("Can't find Driver with Id :" + id));
    }

    @Override
    public Page<Drivers> getDriverPage(@NonNull PageSettings pageSetting) {

        Sort DriverSort = pageSetting.buildSort();
        Pageable DriversPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), DriverSort);
        return driverRepository.findAll(DriversPage);

    }


}
