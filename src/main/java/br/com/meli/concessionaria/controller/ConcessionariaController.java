package br.com.meli.concessionaria.controller;

import br.com.meli.concessionaria.dto.VeiculoDTO;
import br.com.meli.concessionaria.entity.Veiculo;
import br.com.meli.concessionaria.service.ConcessionariaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/veiculos")
@AllArgsConstructor
public class ConcessionariaController {

    private final ConcessionariaService concessionariaService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(concessionariaService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = modelMapper.map(veiculoDTO, Veiculo.class);
        Veiculo savedVeiculo = concessionariaService.save(veiculo);
        URI location = URI.create("/v1/api/veiculos/" + savedVeiculo.getId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Veiculo veiculo = concessionariaService.findById(id);
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> findAllByPriceRange(@RequestParam("since") BigDecimal lowerBound, @RequestParam("to") BigDecimal upperBound) {
        List<Veiculo> veiculosByPriceRange = concessionariaService.findByPriceRange(lowerBound, upperBound);
        return ResponseEntity.ok(veiculosByPriceRange);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> findAllByDateRange(@RequestParam("since") LocalDate lowerBound, @RequestParam("to") LocalDate upperBound) {
        List<Veiculo> veiculoByDateRange = concessionariaService.findByDateRange(lowerBound, upperBound);
        return ResponseEntity.ok(veiculoByDateRange);
    }
}
