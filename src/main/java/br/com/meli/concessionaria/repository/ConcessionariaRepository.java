package br.com.meli.concessionaria.repository;

import br.com.meli.concessionaria.entity.Veiculo;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ConcessionariaRepository {
    private final List<Veiculo> veiculos;

    public ConcessionariaRepository() {
        this.veiculos = new LinkedList<>();
    }

    public Veiculo save(Veiculo veiculo) {
        veiculo.setId(veiculos.size() - 1);
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> findAll() {
        return veiculos;
    }

    public Optional<Veiculo> findById(Integer id) {
        return veiculos.stream().filter(v -> v.getId().equals(id)).findFirst();
    }


    public List<Veiculo> findAllByPriceRange(BigDecimal lowerBound, BigDecimal upperBound) {
        return veiculos.stream().filter(v -> {
            BigDecimal price = v.getPrice();
            return price.compareTo(lowerBound) >= 0 && price.compareTo(upperBound) <= 0;
        }).collect(Collectors.toList());
    }

    public List<Veiculo> findAllByDateRange(LocalDate lowerBound, LocalDate upperBound) {
        return veiculos.stream().filter(v -> {
            LocalDate manufacturingDate = v.getManufacturingDate();
            return manufacturingDate.compareTo(lowerBound) >= 0 && manufacturingDate.compareTo(upperBound) <= 0;
        }).collect(Collectors.toList());
    }
}
