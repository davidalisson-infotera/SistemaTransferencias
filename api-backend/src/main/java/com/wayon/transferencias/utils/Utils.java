package com.wayon.transferencias.utils;

import com.wayon.transferencias.enums.TipoOperacao;

public class Utils {

    public static Double montaTaxaTipoA(Double taxa, Double valor) {
        taxa = 3 + valor * 0.33;
        return taxa;
    }

    ;

    public static Double montaTaxaTipoB(Double taxa, Double valor) {
        taxa = 12.0;
        return taxa;
    }

    ;

    public static Double montaTaxaTipoC(Double taxa, Double valor, Integer difDias) {
        if (difDias > 10 && difDias <= 20) {
            taxa = valor * 0.082;
            return taxa;
        } else if (difDias > 20 && difDias <= 30) {
            taxa = valor * 0.069;
            return taxa;
        } else if (difDias > 30 && difDias <= 40) {
            taxa = valor * 0.047;
            return taxa;
        } else if (difDias > 40) {
            taxa = valor * 0.017;
            return taxa;
        }
        return taxa;
    }

    public static Double montaTaxaTipoD(Double taxa, Double valor, Integer difDias) throws Exception {
        if (valor <= 1000) {
            taxa = montaTaxaTipoA(taxa, valor);
        } else if (valor >= 1001 && valor <= 2000) {
            taxa = montaTaxaTipoB(taxa, valor);
        } else if (valor > 2000) {
            taxa = montaTaxaTipoC(taxa, valor, difDias);
        } else {
            throw new Exception("Não há taxa aplicável");
        }

        return taxa;
    }

    ;


}
