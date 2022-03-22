package br.com.meli.concessionaria.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ServiceDTO {
    private LocalDate date;
    private int kilometers;
    private String description;
}
