package org.example.javacodetest.repository;

import org.example.javacodetest.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {
  }