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
import java.time.Month;
import vistas.Principal;

public class Main {

    public static void main(String[] args) {

        //CiudadanoData cD = new CiudadanoData();
        //Ciudadano persona=new Ciudadano(55555, "Pepe", "Tito", "Este", "pepe@gmail.com", 15123321,"Asmatico","Salud", false);
        //cD.guardarCiudadano(persona);
//        cD.modificarCiudadano(persona);
        //System.out.println(cD.buscarCiudadanoPorDni(12345));
        //System.out.println(cD.listarCiudadanos());
        //cD.borrarCiudadanoPorDni(55555);
        //cD.borrarCiudadanoPorId(4);

        VacunaData vD = new VacunaData();
        Vacuna vacuna = new Vacuna (10000,"Astrazeneca","India",0.6,LocalDate.of(2016, 6, 2),"manaos");
        //vD.guardarVacuna(vacuna);
        //System.out.println(vD.buscarVacunas());
        //System.out.println("Numero total de vacunas: "+vD.contarVacunas());
        //vD.borrarVacuna(3);

        CentroSaludData csD = new CentroSaludData();
//          CentroSalud centro = new CentroSalud("Centro Medico1", "Calle 321", "Norte", vD.buscarVacuna(3),1);
//          csD.guardarCentroSalud(centro);
          //System.out.println(csD.buscarCentroSaludPorID(1));
          //csD.modificarCentroSalud(centro);
          //System.out.println(csD.listarCentrosSalud());
        
        //CitaData citaD = new CitaData();
        //Cita cita = new Cita(cD.buscarCiudadanoPorDni(12345), 0, LocalDateTime.of(2023, Month.OCTOBER, 10, 5, 5, 5), csD.buscarCentroSaludPorID(1), vD.buscarVacuna(1),true);
        //citaD.guardarCita(cita);
        //citaD.modificarCita(cita);
        //System.out.println(citaD.buscarCita(2));
        //System.out.println(citaD.listarCitasVencidas());
        
//        //Pruebas numero random
//        int num1=Principal.numeroAzar(200)+100;
//        int num2=Principal.numeroAzar(200)+100;
//        int num3=Principal.numeroAzar(200)+100;
//        int num4=Principal.numeroAzar(200)+100;
//        int suma=num1+num2+num3+num4;
//        System.out.println("vacuna 1="+num1);
//        System.out.println("vacuna 2="+num2);
//        System.out.println("vacuna 3="+num3);
//        System.out.println("vacuna 4="+num4);
//        System.out.println("Se colocaron en total:"+suma+" vacunas.");
//        int num5=Principal.numeroAzar(50)+10;
//        System.out.println("se cancelaron="+num5);
//        System.out.println("no asistieron="+(Principal.numeroAzar(50)+10));
//        System.out.println("se reprogramadaron="+(Principal.numeroAzar(50)+10));
//        
//    }

//        //CiudadanoData cD = new CiudadanoData();
//        //Ciudadano persona=new Ciudadano(55555, "Pepe", "Tito", "Este", "pepe@gmail.com", 15123321,"Asmatico","Salud", false);
//        //cD.guardarCiudadano(persona);
////        cD.modificarCiudadano(persona);
//        //System.out.println(cD.buscarCiudadanoPorDni(12345));
//        //System.out.println(cD.listarCiudadanos());
//        //cD.borrarCiudadanoPorDni(55555);
//        //cD.borrarCiudadanoPorId(4);
//
//        VacunaData vD = new VacunaData();
//        Vacuna vacuna = new Vacuna (3000,"Sputnik","Rusia",0.6,LocalDate.of(2016, 6, 2),"manaos");
//        //vD.guardarVacuna(vacuna);
//        //System.out.println(vD.buscarVacunas());
//        //System.out.println("Numero total de vacunas: "+vD.contarVacunas());
//        //vD.borrarVacuna(3);
//
         
//          CentroSalud centro = new CentroSalud("Centro Medico Pato", "Calle 321", "Sur",vD.buscarVacuna(2),0);
//          //csD.guardarCentroSalud(centro);
//          //System.out.println(csD.buscarCentroSaludPorID(1));
//          //csD.modificarCentroSalud(centro);
//          //System.out.println(csD.listarCentrosSalud());
//        
//        //CitaData citaD = new CitaData();
//        //Cita cita = new Cita(cD.buscarCiudadanoPorDni(12345), 0, LocalDateTime.of(2023, Month.OCTOBER, 10, 5, 5, 5), csD.buscarCentroSaludPorID(1), vD.buscarVacuna(1),true);
//        //citaD.guardarCita(cita);
//        //citaD.modificarCita(cita);
//        //System.out.println(citaD.buscarCita(2));
//        //System.out.println(citaD.listarCitasVencidas());
//        //System.out.println("numero:"+Principal.numeroAzar(1000));
//         //csD.guardarCentroSalud(centro);
//         //System.out.println("CENTRO ID : " + csD.listarCentrosSalud()+" ");
//         //System.out.println("Dosis del centro : "+csD.obtenerCantidadDosisPorCentro(4, "Rusia"));
//        csD.enviarVacunasAlCentro(5,"India", 1500);
//        csD.descontarVacunasDelLote(1,"Argentina", 1500);
    }  
}