package dev.ordog.springbootshop.controller;

import dev.ordog.springbootshop.model.PurchaseHistory;
import dev.ordog.springbootshop.security.UserPrincipal;
import dev.ordog.springbootshop.service.IPurchaseHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")
public class PurchaseHistoryController {

    private final IPurchaseHistoryService purchaseHistoryService;

    public PurchaseHistoryController(IPurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseHistory purchaseHistory) {
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseHistoryService.findAllPurchasesOfUser(userPrincipal.getId()));
    }
}
