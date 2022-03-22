package br.com.meli.concessionaria.dto;

import br.com.meli.concessionaria.entity.Service;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class VeiculoDTO {
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int doors;
    private BigDecimal price;
    private String currency;
    private List<ServiceDTO> services;
    private int counOfOwners;
}
