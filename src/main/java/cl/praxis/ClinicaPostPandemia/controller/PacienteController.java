package cl.praxis.ClinicaPostPandemia.controller;

import cl.praxis.ClinicaPostPandemia.ClinicaPostPandemiaApplication;
import cl.praxis.ClinicaPostPandemia.model.dto.Paciente;
import cl.praxis.ClinicaPostPandemia.model.service.interfaz.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private static final Logger logger = LoggerFactory.getLogger(ClinicaPostPandemiaApplication.class);
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        logger.info("Ejecutando findAll() de PacienteController");
        model.addAttribute("pacientes", service.findAll());
        return "pacienteList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        logger.info("Ejecutando findOne() de PacienteController");
        model.addAttribute("paciente", service.findOne(id));
        return "pacienteEdit";
    }

    @GetMapping("/paciente/{id}")
    public String findOneP(@PathVariable("id") int id, Model model){
        logger.info("Ejecutando findOneP() de PacienteController");
        model.addAttribute("paciente", service.findOneP(id));
        return "pacienteOneList";
    }

    @PostMapping
    public String update(@ModelAttribute Paciente paciente){
        logger.info(paciente.getName());
        boolean result = service.update(paciente);
        if(result){
            logger.info("Paciente actualizado correctamente");
        }else{
            logger.error("Error al actualizar el Paciente");
        }
        return "redirect:/pacientes";
    }

    @GetMapping("/new")
    public ModelAndView create(){
        logger.info("Ejecutando create() de PacienteController con ModelAndView");
        return new ModelAndView("pacienteNew");
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Paciente paciente){
        logger.info(paciente.getName());
        boolean result = service.create(paciente);
        if(result){
            logger.info("Paciente creado exitosamente");
        }else{
            logger.error("Error al crear el Paciente");
        }
        return "redirect:/pacientes";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id){
        logger.info("Ejecutando delete() de PacienteController");
        boolean result = service.delete(id);
        if(result){
            logger.info("Paciente eliminado exitosamente");
        }else{
            logger.error("Error al eliminar el Paciente");
        }
        return "redirect:/pacientes";
    }
}
