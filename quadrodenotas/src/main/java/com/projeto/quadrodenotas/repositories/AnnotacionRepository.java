package com.projeto.quadrodenotas.repositories;

import com.projeto.quadrodenotas.models.AnnotacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotacionRepository extends JpaRepository<AnnotacionModel, Long> {
}
