package com.example.InsurancePurchaseApp.config;

import com.example.InsurancePurchaseApp.entity.Insurance;
import com.example.InsurancePurchaseApp.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final InsuranceRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Insurance(null, "Health Insurance", "Covers medical expenses", 5000.0));
            repository.save(new Insurance(null, "Car Insurance", "Covers vehicle damages", 8000.0));
            repository.save(new Insurance(null, "Life Insurance", "Covers life risks", 10000.0));
            System.out.println("Sample insurances added to database.");
        }
    }
}
