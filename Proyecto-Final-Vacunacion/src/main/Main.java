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
        //Ciudadano persona=new Ciudadano(55555, "Pepe", "Tito", "Este", "pepe@gmail.com", 15123321,"Asmatico","Salud", false);
        //cD.guardarCiudadano(persona);
//        cD.modificarCiudadano(persona);
        //System.out.println(cD.buscarCiudadanoPorDni(12345));
        //System.out.println(cD.listarCiudadanos());
        //cD.borrarCiudadanoPorDni(55555);
        //cD.borrarCiudadanoPorId(4);

        VacunaData vD = new VacunaData();
        Vacuna vacuna = new Vacuna ("Sputnik","RusiaPro",0.3,LocalDate.of(2016, 6, 2),"manaos");
        //vD.guardarVacuna(vacuna);
        //System.out.println(vD.buscarVacunas());
        System.out.println("Numero total de vacunas: "+vD.contarVacunas());
        //vD.borrarVacuna(3);

        CentroSaludData csD = new CentroSaludData();
          //CentroSalud centro = new CentroSalud(1,"Centro Medico", "Calle 321", "Norte", vD.buscarVacuna(1));
          //csd.guardarCentroSalud(centro);
          //System.out.println(csD.buscarCentroSaludPorID(1));
          //csD.modificarCentroSalud(centro);
          //System.out.println(csD.listarCentrosSalud());
        
        CitaData citaD = new CitaData();
        //Cita cita = new Cita(1,cD.buscarCiudadanoPorDni(12345), 0, LocalDateTime.now(), csD.buscarCentroSaludPorID(1), LocalDateTime.now(), vD.buscarVacuna(1));
        //citaD.guardarCita(cita);
        //citaD.modificarCita(cita);
        //System.out.println(citaD.buscarCita(1));
        //System.out.println(citaD.listarCitas());
        
    }

}
