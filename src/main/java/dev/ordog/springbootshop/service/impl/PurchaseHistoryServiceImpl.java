package dev.ordog.springbootshop.service.impl;

import dev.ordog.springbootshop.model.PurchaseHistory;
import dev.ordog.springbootshop.repository.IPurchaseHistoryRepository;
import dev.ordog.springbootshop.repository.projection.IPurchaseItem;
import dev.ordog.springbootshop.service.IPurchaseHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryServiceImpl implements IPurchaseHistoryService {

    private final IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryServiceImpl(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }


    public List<IPurchaseItem> findAllPurchasesOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
