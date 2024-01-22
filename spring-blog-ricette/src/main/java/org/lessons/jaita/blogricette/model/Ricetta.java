package org.lessons.jaita.blogricette.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ricette")
public class Ricetta {
    //--------------- ATTRIBUTI -----------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String title;
    @NotEmpty
    @Lob
    private String ingredients;
    private String image;
    @NotEmpty
    private String preparationTime;
    @NotNull
    private Integer numberPortions;
    @Lob
    private String text;

    @ManyToOne
    private Categoria categoria;

    //--------------- GETTER E SETTER -----------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getNumberPortions() {
        return numberPortions;
    }

    public void setNumberPortions(Integer numberPortions) {
        this.numberPortions = numberPortions;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
