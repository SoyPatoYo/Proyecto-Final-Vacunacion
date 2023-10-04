package main;

import accesoADatos.CiudadanoData;
import entidades.Ciudadano;




public class Main {

    
    public static void main(String[] args) {
        CiudadanoData cd=new CiudadanoData();
        Ciudadano persona=new Ciudadano(12345, "Guillermo", "Gonzalez", "Norte", "guille@gmail.com", 15321321, "Asmatico", "Salud", false);
        //cd.guardarCiudadano(persona);
        //cd.modificarCiudadano(persona);
        //System.out.println(cd.buscarCiudadanoPorDni(123));
    }
    
}
