//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 09/10/2023
//Última modificación: 11/10/2023

public class Estudiante {
    //Atributos que tendrán todos los estudiantes
    private String ID;
    private String nombre;
    private String direccion;
    private int cantPrestamos = 0;

    //Constructor para los estudiantes
    public Estudiante(String iD, String nombre, String direccion, int cantPrestamos) {
        ID = iD;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantPrestamos = cantPrestamos;
    }
    //Getters y Setters identificados como necesarios para la hora de pedir un libro
    public String getID(){
        return this.ID;
    }
    public int getCantPrestamos(){
        return this.cantPrestamos;
    }
    public void setCantPrestamos(){
        this.cantPrestamos++;
    }

    
}
