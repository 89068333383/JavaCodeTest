package org.example.javacodetest.service.impl;

import org.example.javacodetest.model.QueryWallet;
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

    @Override
    public String modifyWallet(QueryWallet queryWallet) {
        String res;
        var result = walletRepository.findById(queryWallet.getValletId()).orElse(null);
        if (result == null){
            res = "Счет не существует";
        }else if (queryWallet.getOperationType().ordinal() == 1) {
            if (queryWallet.getAmount()<=result.getAmount()){
                result.setAmount(result.getAmount()-queryWallet.getAmount());
                walletRepository.save(result);
                res = "Операция выполнена";
            }else res = "Не достаточно средств";
        }else if (queryWallet.getOperationType().ordinal() == 0) {
            result.setAmount(result.getAmount()+queryWallet.getAmount());
            walletRepository.save(result);
            res = "Операция выполнена";
        } else res = "Не верный запрос";
        return res;
    }

}
