package com.example.carros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(name = "url_foto", columnDefinition = "TEXT")
    private String urlFoto;

    @Column(name = "url_video", columnDefinition = "TEXT")
    private String urlVideo;

    private String latitude;

    private String longitude;

    private String tipo;
}

