package com.cibertec.E1cursos.controller;

import com.cibertec.E1cursos.model.Cur;
import com.cibertec.E1cursos.service.ICurService;
import com.cibertec.E1cursos.service.Impl.CurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

  @RestController
public class CurController {
    ICurService iCurService;

    @Autowired
    public CurController(ICurService iCurService) {
        this.iCurService=iCurService;
    }
    @GetMapping("/listar")
    public List<Cur> getAll() {return iCurService.Get();}
    @PostMapping("/guardar")
    public Cur saveCur(@RequestBody Animal entity) {
        return iCurService.Save(entity);
    }


      @PutMapping("/actualizar/{id}")
      public ResponseEntity<Integer> updateCur(@PathVariable Integer id, @RequestBody Cur cur) {
          Integer updated = iCurService.update(id, cur);
          if (updated == 1) {
              return new ResponseEntity<>(HttpStatus.OK);
          } else {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      @DeleteMapping("/eliminar/{id}")
      public ResponseEntity<Integer> deleteCur(@PathVariable Integer id) {
          Integer deleted = iCurService.delete(id);
          if (deleted == 1) {
              return new ResponseEntity<>(HttpStatus.OK);
          } else {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
}