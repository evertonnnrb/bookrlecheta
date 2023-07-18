package com.example.carros.repository;

import com.example.carros.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByTipo(String tipo);
}
