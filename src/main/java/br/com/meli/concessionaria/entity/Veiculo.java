package br.com.meli.concessionaria.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Veiculo {
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int doors;
    private BigDecimal price;
    private String currency;
    private List<Service> services;
    private int counOfOwners;
}
