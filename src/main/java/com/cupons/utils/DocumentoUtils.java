package com.cupons.utils;

public class DocumentoUtils {

    public static String limparDocumento(String valor) {
        if (valor == null) return null;
        return valor.replaceAll("[^0-9]", "");
    }

    public static String limparCep(String cep) {
        return limparDocumento(cep);
    }

    public static boolean isCnpjValido(String cnpj) {
        return cnpj != null && cnpj.matches("\\d{14}");
    }

    public static boolean isCpfValido(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
