package org.lessons.jaita.blogricette.repository;

import org.lessons.jaita.blogricette.model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RicettaRepository extends JpaRepository<Ricetta, Integer> {
}
