package com.wayon.transferencias.service;


import com.wayon.transferencias.enums.TipoOperacao;
import com.wayon.transferencias.model.Transferencia;
import com.wayon.transferencias.repository.TransferRepository;
import com.wayon.transferencias.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;

    public Transferencia agendarTransfers(Transferencia transfer) {
        transfer.setTaxa(calculaTaxa(transfer));
        return transferRepository.save(transfer);
    }

    public List<Transferencia> consultarTransfers() {
        return transferRepository.findAll();
    }

    private Double calculaTaxa(Transferencia transfer) {
        LocalDate dataTransfer = transfer.getDataTransferencia();
        LocalDate dataAgendamento = transfer.getDataAgendamento();
        Double value = transfer.getValor();

        int difDias = (int) ChronoUnit.DAYS.between(dataAgendamento, dataTransfer);
        Double taxa = 0.0;

        switch (transfer.getTipoOperacao()) {
            case "A":
                if (difDias == 0) {
                    taxa = Utils.montaTaxaTipoA(taxa, value);
                    return taxa;
                }
                break;
            case "B":
                if (difDias > 0 && difDias <= 10) {
                    taxa = Utils.montaTaxaTipoB(taxa, value);
                    return taxa;
                }
                break;
            case "C":
                taxa = Utils.montaTaxaTipoC(taxa, value, difDias);
                return taxa;
            case "D":
                try {
                    taxa = Utils.montaTaxaTipoD(taxa, value, difDias);
                } catch (Exception ex){
                    throw new NullPointerException("Tipo de operação vazio");
                }
                return taxa;

            default:
                throw new IllegalArgumentException("A transferencia deve ser após a data agendada");
        }
        return taxa;
    }
}
