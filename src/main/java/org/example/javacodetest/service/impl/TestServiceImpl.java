package org.example.javacodetest.service.impl;

import org.example.javacodetest.model.Wallet;
import org.example.javacodetest.repository.WalletRepository;
import org.example.javacodetest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TestServiceImpl implements TestService {
    private WalletRepository walletRepository;

    @Autowired
    public void setWalletRepository(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Optional<Wallet> getWallets(UUID id ) {
        return walletRepository.findById(id);
    }


}
