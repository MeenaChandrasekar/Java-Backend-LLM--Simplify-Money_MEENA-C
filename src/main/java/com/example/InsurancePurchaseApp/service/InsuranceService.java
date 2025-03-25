package com.example.InsurancePurchaseApp.service;

import com.example.InsurancePurchaseApp.entity.Insurance;
import com.example.InsurancePurchaseApp.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository repository;

    public List<Insurance> getAllInsurances() {
        return repository.findAll();
    }

    public void purchaseInsurance(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Insurance not found!");
        }
        System.out.println("Insurance with ID " + id + " purchased successfully.");
    }
}