package org.lessons.jaita.blogricette.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "categorie")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "categoria")
    private List<Ricetta> ricettaList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ricetta> getRicettaList() {
        return ricettaList;
    }

    public void setRicettaList(List<Ricetta> ricettaList) {
        this.ricettaList = ricettaList;
    }
}
