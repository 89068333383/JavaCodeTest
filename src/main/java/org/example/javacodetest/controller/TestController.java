package org.example.javacodetest.controller;

import org.example.javacodetest.model.QueryWallet;
import org.example.javacodetest.model.Wallet;
import org.example.javacodetest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("")
public class TestController {

    @Autowired
    private TestService testService;

    public void setService(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/api/v1/wallets/{WALLET_UUID}")
    public ResponseEntity<String> getWallet(@PathVariable String WALLET_UUID) {
        return new ResponseEntity<>(testService.getWallets(WALLET_UUID), HttpStatus.OK);
    }
    @GetMapping("/api/v1/wallets/new/{amount}")
    public ResponseEntity<String> addWallet(@PathVariable int amount){

        return new ResponseEntity<>(":"+amount +":" +testService.addWallet(amount), HttpStatus.OK);
    }

    @PostMapping("/api/v1/wallets")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> modyWallet(@Validated @RequestBody QueryWallet queryWallet){
        var res = testService.modifyWallet(queryWallet);
        return new ResponseEntity<>(" - " + res,HttpStatus.OK);
    }
}
