package cl.praxis.ClinicaPostPandemia.model.service.implementacion;

import cl.praxis.ClinicaPostPandemia.ClinicaPostPandemiaApplication;
import cl.praxis.ClinicaPostPandemia.model.dto.Paciente;
import cl.praxis.ClinicaPostPandemia.model.service.interfaz.PacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClinicaPostPandemiaApplication.class);
    private List<Paciente> pacienteList;

    public PacienteServiceImpl() {
        pacienteList = new ArrayList<>();
        pacienteList.add(new Paciente(1, "Julio", "Manzano", 'M', 45, "+5698775625", "julio.manzano@yahoo.com","/img/pacientesHombres/id01.png"));
        pacienteList.add(new Paciente(2, "María", "González", 'F', 34, "+5691234567", "maria.gonzalez@example.com","/img/pacientesMujeres/id02.png"));
        pacienteList.add(new Paciente(3, "Luis", "Martínez", 'M', 29, "+5692345678", "luis.martinez@example.com","/img/pacientesHombres/id03.png"));
        pacienteList.add(new Paciente(4, "Ana", "López", 'F', 53, "+5693456789", "ana.lopez@example.com","/img/pacientesMujeres/id04.png"));
        pacienteList.add(new Paciente(5, "Carlos", "García", 'M', 41, "+5694567890", "carlos.garcia@example.com","/img/pacientesHombres/id05.png"));
        pacienteList.add(new Paciente(6, "Sofía", "Hernández", 'F', 37, "+5695678901", "sofia.hernandez@example.com","/img/pacientesMujeres/id06.png"));
        pacienteList.add(new Paciente(7, "David", "Rodríguez", 'M', 32, "+5696789012", "david.rodriguez@example.com","/img/pacientesHombres/id07.png"));
        pacienteList.add(new Paciente(8, "Laura", "Pérez", 'F', 28, "+5697890123", "laura.perez@example.com","/img/pacientesMujeres/id08.png"));
        pacienteList.add(new Paciente(9, "Miguel", "Sánchez", 'M', 50, "+5698901234", "miguel.sanchez@example.com","/img/pacientesHombres/id09.png"));
        pacienteList.add(new Paciente(10, "Isabella", "Ramírez", 'F', 26, "+5699012345", "isabella.ramirez@example.com","/img/pacientesMujeres/id10.png"));
        pacienteList.add(new Paciente(11, "Javier", "Torres", 'M', 38, "+5690123456", "javier.torres@example.com","/img/pacientesHombres/id11.png"));
        pacienteList.add(new Paciente(12, "Valeria", "Flores", 'F', 47, "+5691234568", "valeria.flores@example.com","/img/pacientesMujeres/id12.png"));
        pacienteList.add(new Paciente(13, "Ricardo", "Vázquez", 'M', 35, "+5692345679", "ricardo.vazquez@example.com","/img/pacientesHombres/id13.png"));
        pacienteList.add(new Paciente(14, "Carmen", "Castro", 'F', 39, "+5693456780", "carmen.castro@example.com","/img/pacientesMujeres/id14.png"));
        pacienteList.add(new Paciente(15, "José", "Morales", 'M', 42, "+5694567891", "jose.morales@example.com","/img/pacientesHombres/id15.png"));
        pacienteList.add(new Paciente(16, "Natalia", "Ortiz", 'F', 33, "+5695678902", "natalia.ortiz@example.com","/img/pacientesMujeres/id16.png"));
        pacienteList.add(new Paciente(17, "Pedro", "Gutiérrez", 'M', 36, "+5696789013", "pedro.gutierrez@example.com","/img/pacientesHombres/id17.png"));
        pacienteList.add(new Paciente(18, "Elena", "Ruiz", 'F', 31, "+5697890124", "elena.ruiz@example.com","/img/pacientesMujeres/id18.png"));
        pacienteList.add(new Paciente(19, "Manuel", "Muñoz", 'M', 48, "+5698901235", "manuel.munoz@example.com","/img/pacientesHombres/id19.png"));
        pacienteList.add(new Paciente(20, "Paula", "Jiménez", 'F', 27, "+5699012346", "paula.jimenez@example.com","/img/pacientesMujeres/id20.png"));
    }

    public PacienteServiceImpl(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public List<Paciente> findAll() {
        logger.info("Ejecutando findAll() de PacienteServiceImpl");
        return pacienteList;
    }

    @Override
    public Paciente findOne(int id) {
        logger.info("Ejecutando findOne() de PacienteServiceImpl");
        return pacienteList.stream().filter(paciente -> paciente.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Paciente findOneP(int id) {
        logger.info("Ejecutando findOneP() de PacienteServiceImpl");
        return pacienteList.stream().filter(paciente -> paciente.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean create(Paciente p) {
        logger.info("Ejecutando create() de PacienteServiceImpl");
        pacienteList.add(p);
        return true;
    }

    @Override
    public boolean update(Paciente p) {
        logger.info("Ejecutando update() de PacienteServiceImpl");
        Paciente pacienteUp = findOne(p.getId());
        pacienteUp.setName(p.getName());
        pacienteUp.setLastName(p.getLastName());
        pacienteUp.setGender(p.getGender());
        pacienteUp.setAge(p.getAge());
        pacienteUp.setPhone(p.getPhone());
        pacienteUp.setEmail(p.getEmail());
        pacienteUp.setEmail(p.getUrl());
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Ejecutando delete() de PacienteServiceImpl");
        Paciente a = findOne(id);
        if(a != null){
            pacienteList.remove(a);
            return true;
        }
        return false;
    }
}