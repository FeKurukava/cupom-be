package com.cupons.utils;

public class DocumentoUtils {
    public static Long limparDocumentoRetornarLong(String documento) {
        if (documento == null) {
            return null;
        }

        String somenteNumeros = documento.replaceAll("[^0-9]", "");

        if (somenteNumeros.isEmpty()) {
            throw new IllegalArgumentException("Documento não possui dígitos numéricos.");
        }

        return Long.parseLong(somenteNumeros);
    }


}
