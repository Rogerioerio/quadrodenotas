package com.projeto.quadrodenotas.repositories;

import com.projeto.quadrodenotas.models.AnnotacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnotacionRepository extends JpaRepository<AnnotacionModel, Long> {

    @Query("select x from annotacion x where x.title like %?1%")
    List<AnnotacionModel> findByTitleIsLike(String name);

}
