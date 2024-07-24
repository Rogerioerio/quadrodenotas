package com.projeto.quadrodenotas.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

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

    private Date instant;

}
