package com.example.InsurancePurchaseApp.controller;

import com.example.InsurancePurchaseApp.entity.Insurance;
import com.example.InsurancePurchaseApp.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/insurances")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService service;

    @GetMapping
    public List<Insurance> getAllInsurances() {
        return service.getAllInsurances();
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<String> purchaseInsurance(@PathVariable("id") Long id) {
        service.purchaseInsurance(id);
        return ResponseEntity.ok("Insurance purchased successfully!");
    }

    @GetMapping("/{id}/download-policy")
    public ResponseEntity<Resource> downloadPolicy(@PathVariable("id") Long id) throws IOException {
        Resource file = new ClassPathResource("static/dummy-policy.pdf");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=policy-" + id + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(file);
    }

}
