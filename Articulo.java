//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 09/10/2023
//Última modificación: 11/10/2023

public class Articulo extends Escritos {
    //Atributo único para los artículos
    private String arbitro;
    //Constructor para los artículos
    public Articulo(String titulo, String materia, int cantEjemplares, String estado, int identificacion,
            int cantPrestados, String arbitro) {
        super(titulo, materia, cantEjemplares, estado, identificacion, cantPrestados);
        this.arbitro = arbitro;
    }

    

    
    
}
