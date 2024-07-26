package com.projeto.quadrodenotas.controllers;

import com.projeto.quadrodenotas.dtos.AnnotacionDTO;
import com.projeto.quadrodenotas.models.AnnotacionModel;
import com.projeto.quadrodenotas.repositories.AnnotacionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AnnotacionController {

    @Autowired
    AnnotacionRepository annotRepository;

    @GetMapping("/quadrodenotas")
    public ResponseEntity<List<AnnotacionModel>> getAllAnnotacions() {
        List<AnnotacionModel> annotList = annotRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(annotList);
    }

    @GetMapping("/quadrodenotas/{name}")
    public ResponseEntity<List<AnnotacionModel>> getAnnotacionByName(@PathVariable(value = "name") String name) {
        List<AnnotacionModel> annotList = annotRepository.findAll();
        List<AnnotacionModel> filteredAnnotList = ;

        return ResponseEntity.status(HttpStatus.OK).body();
    }

    @PostMapping("/quadrodenotas")
    public ResponseEntity<AnnotacionModel> saveNewAnnotacion(@RequestBody AnnotacionDTO annotacionDTO) {
        var annotacionModel = new AnnotacionModel(annotacionDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(annotRepository.save(annotacionModel));
    }

    @DeleteMapping("/quadrodenotas/{id}")
    public ResponseEntity<Object> deleteAnnotacion(@PathVariable(value = "id") Long annot_id) {
        Optional<AnnotacionModel> annotacionModel = annotRepository.findById(annot_id);
        if(annotacionModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
        }
        annotRepository.delete(annotacionModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Anotação Deletada.");
    }
}
