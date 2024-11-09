package org.pragadeesh.inventoryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID productId;
    private Integer quantity;
}
