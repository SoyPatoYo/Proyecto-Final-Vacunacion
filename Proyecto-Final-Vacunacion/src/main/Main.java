package main;

import accesoADatos.CiudadanoData;
import entidades.Ciudadano;




public class Main {

    
    public static void main(String[] args) {
        CiudadanoData cd=new CiudadanoData();
        Ciudadano persona=new Ciudadano(123, "Matias", "Pato", "Este", "matias@gmail.com", 15123123, "rengo", "Salud", true);
        //cd.guardarCiudadano(persona);
        //cd.modificarCiudadano(persona);
        System.out.println(cd.buscarCiudadanoPorDni(123)+" Tiene covid?:"+cd.buscarCiudadanoPorDni(123).isCovid());
    }
    
}
