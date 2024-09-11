package org.example.javacodetest.controller;

import org.example.javacodetest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/wallets")
public class TestController {

    @Autowired
    private TestService testService;

    public void setService(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/{WALLET_UUID}")
    public ResponseEntity<String> getWallet(@PathVariable String WALLET_UUID) {
        return new ResponseEntity<>(testService.getWallets(WALLET_UUID), HttpStatus.OK);
    }
    @GetMapping("/new/{amount}")
    public ResponseEntity<String> addWallet(@PathVariable int amount){

        return new ResponseEntity<>(":"+amount +":" +testService.addWallet(amount), HttpStatus.OK);
    }
}
