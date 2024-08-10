package com.projeto.quadrodenotas.controllers;

import com.projeto.quadrodenotas.dtos.AnnotacionDTO;
import com.projeto.quadrodenotas.models.AnnotacionModel;
import com.projeto.quadrodenotas.repositories.AnnotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<List<AnnotacionModel>> getAnnotacionByTitleIsLike(@PathVariable(value = "name") String title) {
        List<AnnotacionModel> annotList = annotRepository.findByTitleIsLike(title);

        return ResponseEntity.status(HttpStatus.OK).body(annotList);
    }

    @PostMapping("/quadrodenotas")
    public ResponseEntity<AnnotacionModel> saveNewAnnotacion(@RequestBody AnnotacionDTO annotacionDTO) {
        var annotacionModel = new AnnotacionModel(annotacionDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(annotRepository.save(annotacionModel));
    }

    @PutMapping("/quadrodenotas/{id}")
    public ResponseEntity<Object> updateAnnotacion(@PathVariable(value = "id") Long annot_id,
                                                                   @RequestBody AnnotacionDTO annotacionDTO) {
        Optional<AnnotacionModel> annotacionAux = annotRepository.findById(annot_id);
        if(annotacionAux.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
        }

        var annotacionModel = annotacionAux.get();

        if (annotacionDTO.title() != null) {
            annotacionModel.setTitle(annotacionDTO.title());
        }
        if (annotacionDTO.content() != null) {
            annotacionModel.setContent(annotacionDTO.content());
        }

        return ResponseEntity.status(HttpStatus.OK).body(annotRepository.save(annotacionModel));
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
