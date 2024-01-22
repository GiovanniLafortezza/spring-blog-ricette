package org.lessons.jaita.blogricette.repository;

import org.lessons.jaita.blogricette.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
