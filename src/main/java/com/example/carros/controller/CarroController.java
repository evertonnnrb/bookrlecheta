package com.example.carros.controller;

import com.example.carros.model.Carro;
import com.example.carros.model.dto.CarroDTO;
import com.example.carros.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;

    @GetMapping
    public ResponseEntity<Page<Carro>> buscarCarroPaginados(Pageable pageable) {
        return ResponseEntity.ok(carroService.buscaPaginada(pageable));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CarroDTO>> listarTodos() {
        return ResponseEntity.ok(carroService.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> bucarCarroPorId(@PathVariable Long id) {
        return carroService.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{tipo}")
    public ResponseEntity<List<Carro>> buscarPorTipo(@PathVariable String tipo) {
        List<Carro> carros = carroService.buscarPorTipo(tipo);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro) {
        return ResponseEntity.ok(carroService.salvarCarro(carro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id) {
        return ResponseEntity.ok(carroService.atualizarCarro(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Carro> removerCarro(@PathVariable Long id) {
        carroService.removerCarro(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

