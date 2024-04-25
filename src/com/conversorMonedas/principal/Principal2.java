package com.conversorMonedas.principal;

import com.conversorMonedas.modelos.Conversion;
import com.conversorMonedas.modelos.ConversionRecord;
import com.conversorMonedas.modelos.ConvertidorApi;
import com.conversorMonedas.modelos.Menu;

import java.util.Scanner;

public class Principal2 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConvertidorApi convertidorApi = new ConvertidorApi();
        ConversionRecord conversionRecord = null;
        Conversion conversion = null;

        System.out.println("Ingrese el valor que desea convertir");
        int opcion = teclado.nextInt();

        while (opcion != 7){
            Menu.menu();
            opcion = teclado.nextInt();
            System.out.println("Ingrese el valor que desea convertir");
            float cantidad = teclado.nextFloat();
            switch (opcion) {
                case 1 -> {
                    conversionRecord = ConvertidorApi.tasaConversion("USD", "COP");
                    conversion = new Conversion(conversionRecord, 1);
                    System.out.println(conversion.toString());
                }
                case 2 -> {
                    conversionRecord = ConvertidorApi.tasaConversion("ARS", "USD");
                    conversion = new Conversion(conversionRecord, cantidad);
                    System.out.println(conversion);
                }
                case 3 -> {
                    conversionRecord = ConvertidorApi.tasaConversion("USD", "BRL");
                    conversion = new Conversion(conversionRecord, cantidad);
                    System.out.println(conversion);
                }
                case 4 -> {
                    conversionRecord = ConvertidorApi.tasaConversion("BRL", "USD");
                    conversion = new Conversion(conversionRecord, cantidad);
                    System.out.println(conversion);
                }
                case 5 -> {
                    conversionRecord = ConvertidorApi.tasaConversion("USD", "COP");
                    conversion = new Conversion(conversionRecord, cantidad);
                    System.out.println(conversion);
                }
                case 6 -> {
                    conversionRecord = ConvertidorApi.tasaConversion("COP", "USD");
                    conversion = new Conversion(conversionRecord, cantidad);
                    System.out.println(conversion);
                }
                case 7 -> System.out.println("Hasta Luego");
                default -> System.out.println("Opcion no valida");
            }
        }


    }
}
