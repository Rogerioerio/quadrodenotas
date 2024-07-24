package com.projeto.quadrodenotas.controllers;

import com.projeto.quadrodenotas.models.AnnotacionModel;
import com.projeto.quadrodenotas.repositories.AnnotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnotacionController {

    @Autowired
    AnnotacionRepository annotRepository;

    @GetMapping("/quadrodenotas")
    public ResponseEntity<List<AnnotacionModel>> getAllAnnotacions() {
        List<AnnotacionModel> annotList = annotRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(annotList);
    }
}
