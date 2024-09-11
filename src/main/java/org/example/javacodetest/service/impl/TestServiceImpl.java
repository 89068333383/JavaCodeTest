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
    public String getWallets(String id ) {
        String res;
        var result = walletRepository.findById(id).orElse(null);
        if (result == null){
            res = "Счет не существует";
        }else res = result.toString();
        return res;
    }

    @Override
    public boolean addWallet(int amount) {
        String noDashUUID = UUID.randomUUID().toString().replace("-", "");
        Wallet wallet = new Wallet();
        wallet.setUuid(noDashUUID);
        wallet.setAmount(amount);
        walletRepository.save(wallet);
        return true;
    }


}
