package com.example.realTemp.mapper;

import com.example.realTemp.entity.DriverDto;
import com.example.realTemp.entity.Drivers;

public class DriverMapper {

    public static DriverDto mapToDriverDto(Drivers driver){
        return new DriverDto(
                driver.getId(),
                driver.getfName(),
                driver.getlName(),
                driver.getAge(),
                driver.getDescription(),
                driver.getEmail(),
                driver.getVehicals()
        );
    }

    public static Drivers mapToDriver(DriverDto driverDto){
        return new Drivers(
                driverDto.getId(),
                driverDto.getFname(),
                driverDto.getLname(),
                driverDto.getAge(),
                driverDto.getDescription(),
                driverDto.getEmail(),
                driverDto.getVehicals()
        );
    }

}
