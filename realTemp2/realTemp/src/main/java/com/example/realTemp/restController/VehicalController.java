package com.example.realTemp.restController;

import com.example.realTemp.entity.Vehical;
import com.example.realTemp.entity.VehicalDto;
import com.example.realTemp.service.VehicalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class VehicalController {

    @Autowired
    VehicalService vehicalService;

    @GetMapping("/vehicals")
    public List<VehicalDto> getAllVehical(){
        return vehicalService.GetAllVehicals();
    }

    @PostMapping("/add")
    public VehicalDto putVehical(@RequestBody @Valid VehicalDto vehicalDto){
        return vehicalService.SaveVehical(vehicalDto);
    }

    @GetMapping("/vehical/{id}")
    public Vehical findVehicalById(@PathVariable(value="id") UUID id){
        return vehicalService.findVehicalById(id);
    }
}
