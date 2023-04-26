package com.example.realTemp.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicalDto {

    @NotBlank(message = "Vehical Name Should Not be Empty")
    @NotNull(message = "Vehical Name Should Not br Null")
    String vehicalName;

    @Min(0)
    long price;

    String vehicalDescription;

    Drivers drivers;

}
