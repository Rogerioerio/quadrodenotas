package com.projeto.quadrodenotas.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.quadrodenotas.dtos.AnnotacionDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity(name = "annotacion")
@Table(name = "annotacion")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "annot_=id")
public class AnnotacionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long annot_id;

    private String title;

    private String content;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date instant;

    public AnnotacionModel(AnnotacionDTO annotacionDTO) {
        this.title = annotacionDTO.title();
        this.content = annotacionDTO.content();
        this.instant = Date.from(Instant.now());
    }

}
