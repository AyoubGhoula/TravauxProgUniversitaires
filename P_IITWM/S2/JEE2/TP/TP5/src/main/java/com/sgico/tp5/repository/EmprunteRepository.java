package com.sgico.tp5.repository;

import com.sgico.tp5.entity.Emprunte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprunteRepository extends JpaRepository<Emprunte, Long> {
}

