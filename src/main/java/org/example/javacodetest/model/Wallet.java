package org.example.javacodetest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(name = "uuid", nullable = false, length = Integer.MAX_VALUE)
    private String uuid;

    @Column(name = "amount")
    private Integer amount;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  "Счет='" + uuid + '\'' +
                ", amount=" + amount;
    }
}