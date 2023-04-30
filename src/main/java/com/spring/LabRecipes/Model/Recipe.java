package com.spring.LabRecipes.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    public String nome;
    @Column(nullable = false)
    public String ingredientes;
    @Column(nullable = false)
    public String modoDePreparo;
    @Column(nullable = false)
    public boolean restricoes;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;
}
