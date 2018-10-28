package com.carlos.personaDemo.Controlador;


import com.carlos.personaDemo.Modelo.Data.PersonaDao;
import com.carlos.personaDemo.Modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class PersonaControlador {

    @Autowired
    PersonaDao personaDao;

    ArrayList<Persona> personas = new ArrayList();

    @RequestMapping(value = "")
    public String index() {

        return "aplicacion/formulario";
    }

    @RequestMapping(value = "persona")
    public String view(Model modelo, @RequestParam("name") String name,@RequestParam("lastName") String lastName,
                       @RequestParam("rut") int rut, HttpSession session){

        Persona p = new Persona(name,lastName,rut);
        personaDao.save(p);
        session.setAttribute("persona", p );
        return "aplicacion/datosPersona";
    }

   // @PostMapping("/persona")
    //public Persona createPersona(@Valid @RequestBody Persona persona){

      //  return personaDao.save(persona);
    //}



}
