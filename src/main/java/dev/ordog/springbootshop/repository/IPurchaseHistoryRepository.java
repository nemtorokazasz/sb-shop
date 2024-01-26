package dev.ordog.springbootshop.repository;

import dev.ordog.springbootshop.model.PurchaseHistory;
import dev.ordog.springbootshop.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query("select " +
    "p.title as title, ph.price as price, ph.purchaseTime as purchaseTime " +
    "from PurchaseHistory ph left join Product p on p.id = ph.productId " +
    "where ph.userId = :userId")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);


}
