package com.example.carros.service;

import com.example.carros.model.Carro;
import com.example.carros.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarroService {
    private final CarroRepository carroRepository;

    @Transactional
    public Carro salvarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    @Transactional
    public Carro atualizarCarro(Long id) {
        return salvarCarro(getCarroPorId(id));
    }

    public Page<Carro> buscaPaginada(Pageable pageable) {
        return carroRepository.findAll(pageable);
    }

    public Carro getCarroPorId(Long id) {
        return carroRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void removerCarro(Long id) {
        carroRepository.delete(getCarroPorId(id));
    }
}
