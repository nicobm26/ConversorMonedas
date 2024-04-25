package com.conversorMonedas.principal;

import com.conversorMonedas.modelos.ConvertidorApi;

public class Principal {
    public static void main(String[] args) {
        ConvertidorApi convertidorApi = new ConvertidorApi();

        convertidorApi.convertir("USD", "COP", 1);
    }
}
