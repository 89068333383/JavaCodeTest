package org.example.javacodetest.service;

import org.example.javacodetest.model.Wallet;

import java.util.Optional;

public interface TestService {
    public String getWallets(String uuid);
    public boolean addWallet(int amount);
}
