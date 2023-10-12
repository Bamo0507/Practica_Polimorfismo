//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 09/10/2023
//Última modificación: 11/10/2023

public abstract class Escritos{
    //Atributos a utilizar
    protected String titulo;
    protected String materia;
    protected int cantEjemplares;
    protected String estado;
    protected int identificacion;
    protected int cantPrestados;

    //Constructor que tendrán todos los tipos de escritos
    public Escritos(String titulo, String materia, int cantEjemplares, String estado, int identificacion, int cantPrestados) {
        this.titulo = titulo;
        this.materia = materia;
        this.cantEjemplares = cantEjemplares;
        this.estado = estado;
        this.identificacion = identificacion;
        this.cantPrestados = cantPrestados;

        this.cantEjemplares = cantEjemplares - cantPrestados;
        if(this.cantEjemplares != 0){
            this.estado = "Disponible";
        } else {
            this.estado = "No disponible";
        }
    } 

    //Getters y Setters para los atributos necesarios
    public int getIdentificacion(){
        return this.identificacion;
    }
    public String getMateria(){
        return this.materia;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public int getCantEjemplares(){
        return this.cantEjemplares;
    }
    public void setCantPrestamos(){
        this.cantPrestados--;
    }
}