package br.com.meli.concessionaria.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Service {
    private LocalDate date;
    private int kilometers;
    private String description;
}
