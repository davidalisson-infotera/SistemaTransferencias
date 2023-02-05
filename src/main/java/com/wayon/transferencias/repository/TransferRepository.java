package com.wayon.transferencias.repository;

import com.wayon.transferencias.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transferencia, Long> {
}
