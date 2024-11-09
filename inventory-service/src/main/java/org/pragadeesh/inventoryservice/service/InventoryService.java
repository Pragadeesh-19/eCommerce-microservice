package org.pragadeesh.inventoryservice.service;

import org.pragadeesh.inventoryservice.model.Inventory;
import org.pragadeesh.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getInventoryByProductId(UUID productId) {
        return inventoryRepository.findById(productId).orElse(null);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory updateInventory(UUID productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }
}
