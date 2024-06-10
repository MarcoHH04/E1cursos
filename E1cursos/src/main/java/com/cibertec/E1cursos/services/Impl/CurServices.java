package com.cibertec.E1cursos.services.Impl;

import com.cibertec.E1cursos.model.Cur;
import com.cibertec.E1cursos.rest.CurRepository;
import com.cibertec.E1cursos.services.ICurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurServices implements ICurServices {
    CurRepository _curRepository;

    @Autowired
    public CurServices(CurRepository curRepository) {
        _curRepository = curRepository;
    }

    @Override
    public List<Cur> Get() {
        return _curRepository.findAll();
    }

    @Override
    public Cur SaveCur(Cur entity) {
        Cur guardarCur = _curRepository.save(entity);
        return guardarCur;
    }

    @Override
    public Integer update(Integer id, Cur cur) {
        Optional<Cur> existingCur = _curRepository.findById(id);
        if (existingCur.isPresent()) {
            Cur curToUpdate = existingCur.get();
            curToUpdate.setNombre(cur.getNombre());
            curToUpdate.setHoras(cur.getHoras());
            _curRepository.save(curToUpdate);
            return 1;
        } else {
            return 0;
        }
    }
    @Override
    public Integer delete(Integer codCur) {
        Optional<Cur> optionalCur = _curRepository.findById(codCur);

        if (optionalCur.isPresent()) {
            _curRepository.deleteById(codCur);
            return 1;
        } else {
            return 0;
        }
    }
}