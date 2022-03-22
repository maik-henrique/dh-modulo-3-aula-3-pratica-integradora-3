package br.com.meli.concessionaria.service;

import br.com.meli.concessionaria.entity.Veiculo;
import br.com.meli.concessionaria.exceptions.ResourceNotFoundException;
import br.com.meli.concessionaria.repository.ConcessionariaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConcessionariaService {
    private final ConcessionariaRepository concessionariaRepository;

    public Veiculo save(Veiculo veiculo) {
        return concessionariaRepository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return concessionariaRepository.findAll();
    }

    public List<Veiculo> findByPriceRange(BigDecimal lowerBound, BigDecimal upperBound) {
        return concessionariaRepository.findAllByPriceRange(lowerBound, upperBound);
    }

    public List<Veiculo> findByDateRange(LocalDate lowerBound, LocalDate upperBound) {
        return concessionariaRepository.findAllByDateRange(lowerBound, upperBound);
    }

    public Veiculo findById(Integer id) {
        Optional<Veiculo> veiculoOptional = concessionariaRepository.findById(id);
        return veiculoOptional.orElseThrow(() -> new ResourceNotFoundException(("Não foi encontrado veículo com o id especificado")));
    }
}
