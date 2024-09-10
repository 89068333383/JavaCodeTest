package org.example.javacodetest.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", nullable = false)
    private UUID id;

    @Column(name = "amount")
    private Integer amount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

/*
 TODO [Reverse Engineering] create field to map the 'operationtype' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "operationtype", columnDefinition = "operationtypeclass")
    private Object operationtype;
*/
}