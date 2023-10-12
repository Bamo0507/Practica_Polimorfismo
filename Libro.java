//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 09/10/2023
//Última modificación: 11/10/2023

public class Libro extends Escritos {
    //Atributos únicos de los libros
    private String editorial;
    private String autor;
    //Constructor para los libros
    public Libro(String titulo, String materia, int cantEjemplares, String estado, int identificacion, int cantPrestados, String editorial, String autor) {
        super(titulo, materia, cantEjemplares, estado, identificacion, cantPrestados);
        this.editorial = editorial;
        this.autor = autor;
    }   
    //Texto qeu se devolverá para el listado de los libros
    public String toString(){
        return this.titulo + "---" + this.autor + "---" + this.materia;
    }
}
