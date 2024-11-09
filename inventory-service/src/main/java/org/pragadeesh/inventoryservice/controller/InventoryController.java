package org.pragadeesh.inventoryservice.controller;

import org.pragadeesh.inventoryservice.model.Inventory;
import org.pragadeesh.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{productId}")
    public Inventory getInventoryByProductId(@PathVariable UUID productId) {
        return inventoryService.getInventoryByProductId(productId);
    }

    @PutMapping("/{productId}")
    public Inventory updateInventory(@PathVariable UUID productId,
                                     @RequestParam Integer quantity) {
        return inventoryService.updateInventory(productId, quantity);
    }
}
