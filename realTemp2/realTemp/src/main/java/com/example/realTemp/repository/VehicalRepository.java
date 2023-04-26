package com.example.realTemp.repository;

import com.example.realTemp.entity.Vehical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicalRepository extends JpaRepository<Vehical, UUID> {
}
