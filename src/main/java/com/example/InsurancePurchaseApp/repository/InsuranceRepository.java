package com.example.InsurancePurchaseApp.repository;

import com.example.InsurancePurchaseApp.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
