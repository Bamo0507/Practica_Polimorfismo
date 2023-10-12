//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 09/10/2023
//Última modificación: 11/10/2023

public class Revista extends Escritos {
    //Atributos únicos de las revistas
    private String anio;
    private String numRevista;
    //Constructor para los objetos de tipo Revista
    public Revista(String titulo, String materia, int cantEjemplares, String estado, int identificacion, int cantPrestados, String anio, String numRevista) {
        super(titulo, materia, cantEjemplares, estado, identificacion, cantPrestados);
        this.anio = anio;
        this.numRevista = numRevista;
    }
    
}
