package com.conversorMonedas.modelos;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;


public class Conversion {
    private float cantidadBase;
    private float cantidadDestino;
    private String monedaBase;
    private String monedaDestino;
    private float tasaConversion;
    private LocalDateTime fechaConversion;
    private String ultimaFechaActuliazacion;


    public Conversion(){}

    public Conversion(ConversionRecord conversionRecord, float cantidad) {
        this.monedaBase = conversionRecord.base_code();
        this.monedaDestino = conversionRecord.target_code();
        this.tasaConversion = conversionRecord.conversion_rate();
        this.ultimaFechaActuliazacion = conversionRecord.time_last_update_utc();
        this.cantidadBase = cantidad;
        this.cantidadDestino = conversionRecord.conversion_rate() * cantidad;
        this.fechaConversion = now();
    }
    public Conversion(ConversionRecord conversionRecord) {
        this.monedaBase = conversionRecord.base_code();
        this.monedaDestino = conversionRecord.target_code();
        this.tasaConversion = conversionRecord.conversion_rate();
        this.ultimaFechaActuliazacion = conversionRecord.time_last_update_utc();
        this.fechaConversion = now();
    }

    public float ConvertirDinero(){
        this.cantidadDestino = this.cantidadBase*this.tasaConversion;
        return this.cantidadBase*this.tasaConversion;
    }

    @Override
    public String toString() {
        return "La conversion de "+ this.cantidadBase +" " + this.monedaBase +" a " + this.monedaDestino + " es >> " + this.cantidadDestino;
    }
}
