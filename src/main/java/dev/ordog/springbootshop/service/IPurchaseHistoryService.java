package dev.ordog.springbootshop.service;

import dev.ordog.springbootshop.model.PurchaseHistory;
import dev.ordog.springbootshop.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findAllPurchasesOfUser(Long id);
}
