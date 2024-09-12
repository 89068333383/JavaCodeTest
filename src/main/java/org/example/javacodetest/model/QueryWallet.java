package org.example.javacodetest.model;

import org.springframework.lang.NonNull;

public class QueryWallet {
    @NonNull
    private String valletId;
    @NonNull
    private OperationType operationType;
    @NonNull
    private Integer amount;

    @NonNull
    public String getValletId() {
        return valletId;
    }

    public void setValletId(@NonNull String valletId) {
        this.valletId = valletId;
    }

    @NonNull
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(@NonNull OperationType operationType) {
        this.operationType = operationType;
    }

    @NonNull
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(@NonNull Integer amount) {
        this.amount = amount;
    }
}
