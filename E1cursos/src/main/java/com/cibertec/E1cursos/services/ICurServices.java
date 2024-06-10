package com.cibertec.E1cursos.services;

import com.cibertec.E1cursos.model.Cur;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICurServices {
    List<Cur> Get();
    Cur Save(Cur entity);
    Integer update(Integer id, Cur cur);
    Integer delete(Integer codCur);
}
