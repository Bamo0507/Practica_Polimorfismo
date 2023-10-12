//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 09/10/2023
//Última modificación: 11/10/2023

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class Biblioteca {
    //Variables a utilizar
    private static boolean valid = true;
    private static Scanner sc = new Scanner(System.in);
    private static String seleccion;
    private static String seleccionEscrito;
    private static int cantEjemplares;
    private static ArrayList<Escritos> escritos = new ArrayList<>();
    private static int identificacion;
    private static int cantPrestados;
    private static boolean encontrado = false;
    private static String materiaBuscada;
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static boolean idEncontrado = false;
    private static int cantPrestamos = 0;
    private static boolean asignacionEncontrada = false;
    private static String nombreCSV = "Registro.csv";

    public static void main(String[] args){
        //Iteramos una serie de escritos para el programa

        // Libros academicos
        escritos.add(new Libro("Introduccion a la Programacion", "Informatica", 15, "Disponible", 123456, 0, "Editorial Universitaria", "John Doe"));
        escritos.add(new Libro("Algebra Lineal", "Matematicas", 10, "Disponible", 234567, 0, "Editorial Educativa", "Jane Smith"));
        escritos.add(new Libro("Historia de la Filosofia", "Filosofia", 8, "Disponible", 345678, 0, "Editorial Académica", "Alberto Pérez"));


       // Crear instancias de la clase Revista
        escritos.add(new Revista("Revista de Ciencias", "Ciencia", 20, "Disponible", 100001, 0, "2023", "Vol. 1, No. 1"));
        escritos.add(new Revista("Historia y Cultura", "Historia", 15, "Disponible", 100002, 0, "2023", "Vol. 2, No. 3"));
        escritos.add(new Revista("Tecnologia Avanzada", "Tecnologia", 25, "Disponible", 100003, 0, "2023", "Vol. 3, No. 2"));

        // Crear instancias de la clase Artículo
        escritos.add(new Articulo("Articulo de Ciencias", "Ciencia", 10, "Disponible", 200001, 0, "Dr. Smith"));
        escritos.add(new Articulo("Articulo de Tecnología", "Tecnologia", 8, "Disponible", 200002, 0, "Dr. Johnson"));
        escritos.add(new Articulo("Articulo de Historia", "Historia", 15, "Disponible", 200003, 0, "Dra. Perez"));

        //Ciclo pra el menu principal
        while(valid){
            //Se imprime el menu principal para la administración
            System.out.println(menuPrincipal());
            seleccion = sc.nextLine();
            //Código a continuar acorde de la selección
            switch(seleccion){
                //Solicitamos toda la información necesaria para generar un documento nuevo
                case "1":
                    System.out.println("Muy bien, si deseas registrar un nuevo documento, tendrás que proporcionar toda la información necesaria :))");
                    System.out.println("Cuál es el título del documento?");
                    String titulo = sc.nextLine();
                    System.out.println("Cuál es la materia del curso?");
                    String materia = sc.nextLine();
                    System.out.println("Cuántos ejemplares se tienen del documento?");
                    cantEjemplares = obtenerEnteroValido(sc);
                    String estado = "Disponible";
                    System.out.println("Coloque el número de identificacion, por favor, asegurate que tenga 6 dígitos.");
                    while(true){
                        int identificacion = obtenerEnteroValido(sc);
                        if(identificacion>=100000 && identificacion<=999999){
                            break;
                        } else{
                            System.out.println("Lo siento, debes ingresar un número de 6 dígitos para el código de identificación.");
                        }
                    }
                    System.out.println("Cuántos ejemplares están prestados?");
                    while(true){
                        int cantPrestados = obtenerEnteroValido(sc);
                        if(cantPrestados <= cantEjemplares){
                            break;
                        } else {
                            System.out.println("La cantidad de documentos prestados no puede ser mayor a la cantidad de ejemplares con los que se cuenta.");
                        }
                    }                
                    //Verificamos el tipo de documento que el usuario desea agregar    
                    System.out.println(menuTiposEscritos());
                    seleccionEscrito = sc.nextLine();
                    switch(seleccionEscrito){
                        //Solicitamos información única de los libros
                        case "1":  
                            System.out.println("¿A qué editorial pertenece el libro?");
                            String editorial = sc.nextLine();
                            System.out.println("¿Quién es el autor del libro?");
                            String autor = sc.nextLine();
                            escritos.add(new Libro(titulo, materia, cantEjemplares, estado, identificacion, cantPrestados, editorial, autor)); 
                            break;
                        //Solicitamos información única de las revistas
                        case "2":
                            System.out.println("¿En qué año se publicó la revista?");
                            String anio = sc.nextLine();
                            System.out.println("¿Cuál es el número de la revistA?");
                            String numRevista = sc.nextLine();
                            escritos.add(new Revista(titulo, materia, cantEjemplares, estado, identificacion, cantPrestados, anio, numRevista));
                            break;
                        //Solicitamos información única de los artículos
                        case "3":
                            System.out.println("¿Quién es el árbitro del artículo?");
                            String arbitro = sc.nextLine();
                            escritos.add(new Articulo(titulo, materia, cantEjemplares, estado, identificacion, cantPrestados, arbitro));
                            break;
                        //Código a mostrar en caso que no se seleccione algo válido
                        default:
                            System.out.println("No ha seleccionado una opción válida, vuelva a intentarlo :)");
                            break;
                    }
                    break;
                
                //Encontrar el título de un documento dado su código de identificación
                case "2":
                    encontrado = false;
                    //Solicitud de código
                    System.out.println("Para conocer el título de un escrito, primero, debes ingresar el ID de este...");
                    System.out.println("Recuerda que se trata de un entero de 6 dígitos :)");
                    System.out.println("Colocar el código: ");
                    //Se verifica que sea un número de 6 dígitos
                    while(true){
                        identificacion = obtenerEnteroValido(sc);
                        if(identificacion>=100000 && identificacion<=999999){
                            break;
                        } else{
                            System.out.println("Lo siento, debes ingresar un número de 6 dígitos para el código de identificación.");
                        }
                    }
                    //Recorremos todos nuestros documentos y se verifica si el código dado coincide con alguno y se imprime
                    for (Escritos escrito: escritos){
                        if(escrito.getIdentificacion() == (identificacion)){
                            encontrado = true;
                            System.out.println("Este es el escrito que buscas: " + escrito.getTitulo() + ".\n");
                        }
                    } if (encontrado == false){
                        System.out.println("Lamentablemente no hemos encontrado ningún escrito con ese número de identificación.\n");
                    }
                    break;

                //Mostrar cuántos documentos se tienen de una materia
                case "3":
                    int conteoMaterias = 0;
                    System.out.println("¿De qué materia desea saber cuántos escritos se tienen?");
                    materiaBuscada = sc.nextLine();
                    //Recorremos el listado de escritos, y vamos contando los que coincidan con la materia dada
                    for (Escritos escrito: escritos){
                        if(escrito.getMateria().equals(materiaBuscada)){
                            conteoMaterias++;
                        }
                    }
                    System.out.println("\nSe han encontrado " + conteoMaterias + " escritos que correspondan a la materia de " + materiaBuscada + ".\n");
                    break;

                //Mostrar cantidad de revistas para alguna materia
                case "4":
                    int conteoRevistas = 0;
                    System.out.println("¿De qué materia desea saber cuántas revistas se tienen?");
                    materiaBuscada = sc.nextLine();
                    //Recorremos los escritos, verificamos que sean una instancia de Revista y que su materia coincida con la indicada
                    for (Escritos escrito: escritos){
                        if(escrito instanceof Revista && escrito.getMateria().equals(materiaBuscada)){
                            conteoRevistas++;
                        }
                    }
                    System.out.println("\nSe han encontrado " + conteoRevistas + " revistas para la materia de " + materiaBuscada + ".\n");
                    break;

                //Mostramos la información de todos los libros que se tienen hasta el momento
                case "5":
                System.out.println();
                    for(Escritos escrito: escritos){
                        if (escrito instanceof Libro){
                            System.out.println(escrito);
                            System.out.println();
                        }
                    }
                    break;

                //Generamos nuevos clientes, verificamos si ya son existentes, y luego dependiendo de cuál sea su caso,
                //Se les irá solicitando información para saber qué documento es el que desean
                case "6":
                    //Reseteamos los atributos guías
                    asignacionEncontrada = false;
                    idEncontrado = false;
                    cantPrestamos = 0;
                    //Verificamos que el número de identificación dado sea de 6 dígitos
                    System.out.println("Coloque el número de identificacion, por favor, asegurate que tenga 6 dígitos.");
                    while(true){
                        identificacion = obtenerEnteroValido(sc);
                        if(identificacion>=100000 && identificacion<=999999){
                            break;
                        } else{
                            System.out.println("Lo siento, debes ingresar un número de 6 dígitos para el código de identificación.");
                        }
                    }
                    //Solicitud de información para un cliente
                    System.out.println("¿Cuál es su ID?");
                    String ID = sc.nextLine();
                    for(Estudiante estudiante: estudiantes){
                        if(estudiante.getID().equals(ID)){
                            idEncontrado = true;
                        }
                    }
                    if(idEncontrado == false){
                        System.out.println("¿Cúal es su nombre?");
                        String nombreEstudiante = sc.nextLine();
                        System.out.println("¿Cuál es su dirección?");
                        String direccion = sc.nextLine();
                        System.out.println();
                        estudiantes.add(new Estudiante(ID, nombreEstudiante, direccion, cantPrestamos));
                    } 

                    //Recorremos los escritos para verificar que todavía se tengan ejemplares de la muestra buscada
                    for(Escritos escrito: escritos){
                            if(escrito.getIdentificacion() == identificacion && escrito.getCantEjemplares() > 0){
                                for(Estudiante estudiante: estudiantes){
                                    //Si se encuentra el ID dado dentro de nuestro registro, verificamos cuántos prestamos ha hecho, y dependiendo de su caso se le dará el prestamo
                                    if(estudiante.getID().equals(ID)){
                                        if(estudiante.getCantPrestamos() < 5){
                                            System.out.println("Se ha realizado con éxito el préstamo del escrito " + escrito.getTitulo() + ".\n");
                                            estudiante.setCantPrestamos();
                                            escrito.setCantPrestamos();
                                            asignacionEncontrada = true;
                                        } else {
                                            System.out.println("Ya estás prestano cinco documentos.\n");
                                        }
                                    }
                                }
                            }
                        }  
                    //Código a mostrar si no se encuentra el ID para el documento dado
                    if(asignacionEncontrada == false){
                        System.out.println("No se ha encontrado un escrito con ese código de identificación.\n");
                    } else {
                        System.out.println("En qué fecha estamos?");
                        String fechaActual = sc.nextLine();
                        System.out.println("Dentro de cuántos días lo devolverá?");
                        int cantDias = obtenerEnteroValido(sc);
                        String nuevaFila = ID + "," + fechaActual + ","+  cantDias;
                        try{
                            BufferedReader br = new BufferedReader(new FileReader(nombreCSV));
                            String linea;
                            boolean primeraFilaVacia = true;
                            while((linea = br.readLine()) != null){
                                if (linea.trim().isEmpty()){
                                    PrintWriter w = new PrintWriter(new FileWriter(nombreCSV, true));
                                    w.println(nuevaFila);
                                    w.close();
                                    primeraFilaVacia = false;
                                    System.out.println("Se ha guardado el registro.\n");
                                    break;
                                }
                            }
                            br.close();
                            if(primeraFilaVacia){
                                System.out.println("No se encontró una fila vacía para escribir");
                            }
                        } catch (IOException e) {
                            System.out.println("No se ha encontraod el archivo.");
                        }           
                    }
                    break;
                //Prorrogar la entrega en otro CSV
                case "7":
                    System.out.println("Provea su ID por favor.");
                    String idModificar = sc.nextLine();
                    System.out.println("¿Qué fecha es hoy?");
                    String newFecha = sc.nextLine();
                    try {
                        BufferedReader rd = new BufferedReader(new FileReader(nombreCSV));
                        PrintWriter w = new PrintWriter(new FileWriter("temp.csv"));
                        System.out.println("¿A cuánto quiere cambiar sus días para devolver el escrito?");
                        int newDia = obtenerEnteroValido(sc);
                        String newDiaS = Integer.toString(newDia);
                        String linea;
                        boolean seActualizo = false;
                        while ((linea = rd.readLine()) != null) {
                            String[] columnas = linea.split(",");
                            if (columnas.length >= 1 && columnas[0].equals(idModificar)) {
                                if (columnas.length < 3) {
                                    columnas = new String[]{columnas[0], newFecha, newDiaS};
                                } else {
                                    columnas[2] = newDiaS;
                                }
                                seActualizo = true;
                            }
                            w.println(String.join(",", columnas));
                        }
                        rd.close();
                        w.close();
                        if (seActualizo) {
                            // No se realiza la renombrar el archivo
                            System.out.println("Actualización existosa, tienes más días.");
                        } else {
                            System.out.println("No se ha encontrado un ID como el que proveíste.");
                        }
                    } catch (IOException e) {
                        System.out.println("No se ha encontrado el archivo");
                    }                           
                    break;

                //Salir del programa
                case "8":
                    System.out.println("Que tenga un feliz día.");
                    valid = false;    
                    break;           
                    

                //Código a mostrar si no se ingresa algo válido
                default:
                    System.out.println("Seleccione una opción válida.");
            }

        }  
    }

    //Devuelve nuestro menú principal
    public static String menuPrincipal(){
        return "1. Ingresar nuevos documentos a la biblioteca.\n" +"2. Mostrar título de un escrito.\n" + "3. Mostrar cantidad de escritos de una materia.\n" +"4. Mostrar cantidad de revistas de una materia.\n" +"5. Mostrar información de todos los libros.\n" +"6. Solicitar un libro.\n" + "7. Prorrogar entrega te libro\n" + "8. Salir\n" + "Por favor, seleccione una opción en el menú: ";
    }
    //Devuelve el menu para saber el tipo de documento
    public static String menuTiposEscritos(){
        return "Qué tipo de documento quiere ingresar: \n" + "1. Libro\n" + "2. Revista\n" + "3. Artículo\n";
    }

    //Método para asegurarse que se ingrese un entero en los campos necesarios
    public static int obtenerEnteroValido(Scanner scanner) {
        int numero = 0;
        boolean entradaValida = false;
        System.out.println("------------------------");
        do {
            try {
                System.out.print("Por favor, ingresa un número entero: ");
                String entrada = scanner.nextLine();
                numero = Integer.parseInt(entrada);
                entradaValida = true;
                System.out.println("");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debes ingresar un número entero.");
            }
        } while (!entradaValida);

        return numero;
    }

}
