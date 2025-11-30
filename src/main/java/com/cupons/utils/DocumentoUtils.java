package com.cupons.utils;

public class DocumentoUtils {
    public static String limparDocumento(String documento) {
        if (documento == null) {
            return null;
        }

        String documentoFormatado = documento.replaceAll("[^0-9]", "");

        if (documentoFormatado.isEmpty()) {
            throw new IllegalArgumentException("Documento não possui dígitos numéricos.");
        }

        return documentoFormatado;
    }


}
