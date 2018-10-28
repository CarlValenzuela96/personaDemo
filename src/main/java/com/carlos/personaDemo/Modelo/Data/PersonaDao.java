package com.carlos.personaDemo.Modelo.Data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.carlos.personaDemo.Modelo.Persona;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonaDao extends CrudRepository<Persona, Integer> {

    Persona findById (int id);
}
