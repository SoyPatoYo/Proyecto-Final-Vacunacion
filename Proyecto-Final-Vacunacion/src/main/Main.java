package main;

import accesoADatos.CentroSaludData;
import accesoADatos.CitaData;
import accesoADatos.CiudadanoData;
import accesoADatos.VacunaData;
import entidades.CentroSalud;
import entidades.Cita;
import entidades.Ciudadano;
import entidades.Vacuna;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        CiudadanoData cD = new CiudadanoData();
//        Ciudadano persona=new Ciudadano(12345, "Guillermo", "Gonzalez", "Este", "guille@gmail.com", 15321321,"Asmatico","Salud", false);
//        cD.guardarCiudadano(persona);
//        cD.modificarCiudadano(persona);
        //System.out.println(cD.buscarCiudadanoPorDni(12345));
        //System.out.println(cD.listarCiudadanos());

        VacunaData vD = new VacunaData();
//        Vacuna vacuna = new Vacuna ("Sputnik","RusiaPro",0.3,LocalDate.of(2016, 6, 2),"manaos");
//        vD.guardarVacuna(vacuna);
        //System.out.println(vD.buscarVacunas());

        CentroSaludData csD = new CentroSaludData();
          //CentroSalud centro = new CentroSalud(1,"Centro Medico", "Calle 321", "Norte", vD.buscarVacuna(1));
          //csd.guardarCentroSalud(centro);
          //System.out.println(csD.buscarCentroSaludPorID(1));
          //csd.modificarCentroSalud(centro);
          //System.out.println(csD.listarCentrosSalud());
        
        CitaData citaD = new CitaData();
        Cita cita = new Cita(cD.buscarCiudadanoPorDni(12345), 0, LocalDateTime.now(), csD.buscarCentroSaludPorID(1), LocalDateTime.now(), vD.buscarVacuna(1));
        citaD.guardarCita(cita);
    }

}
