package com.cibertec.E1cursos.rest;

import com.cibertec.E1cursos.model.Cur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurRepository  extends JpaRepository<Cur , Integer> {
}