package org.example.javacodetest.service;

import org.example.javacodetest.model.Wallet;

import java.util.Optional;
import java.util.UUID;

public interface TestService {
    public Optional<Wallet> getWallets(UUID uuid);
}
