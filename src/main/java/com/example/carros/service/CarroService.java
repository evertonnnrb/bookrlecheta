package com.example.carros.service;

import com.example.carros.model.Carro;
import com.example.carros.model.dto.CarroDTO;
import com.example.carros.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroRepository carroRepository;

    @Transactional
    public Carro salvarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long id) {
        Carro carro = buscarPorId(id).get();
        return carroRepository.save(carro);
    }

    public List<CarroDTO> getCarros() {
        return carroRepository.findAll()
                .stream()
                .map(CarroDTO::create)
                .collect(Collectors.toList());
    }

    public Page<Carro> buscaPaginada(Pageable pageable) {
        return carroRepository.findAll(pageable);
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    @Transactional
    public void removerCarro(Long id) {
        carroRepository.delete(buscarPorId(id).get());
    }

    public List<Carro> buscarPorTipo(String tipo) {
        return carroRepository.findByTipo(tipo);
    }
}
