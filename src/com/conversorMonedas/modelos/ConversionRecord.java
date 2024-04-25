package com.conversorMonedas.modelos;

public record ConversionRecord(String base_code, String target_code, String time_last_update_utc,
                               float conversion_rate) {
}
