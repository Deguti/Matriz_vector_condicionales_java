/**
 * Fecha: 06/09/2023
 * @author Derick Gutierrez
 */
package portafolio_03_derickgutierrez;

import java.util.Scanner;
import java.util.Random;


public class Portafolio_03_DerickGutierrez {

    
    public static void main(String[] args) {
        
        //declaracion de variables y arreglos
        int opcion;
        int num;
        int tamañoVectores;
        //Instancias
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("____Bienvenido al portafolio 3 que desea hacer____");
            System.out.println("Precione 1 Para la solucion de empleados o 2 para el vector de numeros aleatorios.");
            System.out.println("Digite 3 para salir");
            num = scanner.nextInt();
            switch (num) {
            case 1:
                
                System.out.println("Digite el Tamaño de los vectores a utilizar se tomara su valor para los tres vectores");
                tamañoVectores = scanner.nextInt();
                String Nombres[] = new String[tamañoVectores];                  
                int edades[] = new int[tamañoVectores];
                double salario[] = new double[tamañoVectores]; 
                
                do {
                opcion= MostrarEmpleados(scanner);
                    switch (opcion) {
                        case 1:
                            cantidadTrabajadores(Nombres);
                            break;
                        case 2:
                            IntroducirTrabajadores(Nombres, edades, salario);
                            break;
                        case 3:
                            burbujaNombre(Nombres, edades, salario);
                            break;
                        case 4:
                            insercionEdad(Nombres, edades, salario);
                            break;
                        case 5:
                            shellsortSalario(Nombres, edades, salario);
                            break;
                        case 6:
                            mostrarInformacionEmpleados(Nombres, edades, salario);
                            break;
                        case 7:
                            System.out.println("Fin del Programa empleados ");
                            break;
                        default:
                            throw new AssertionError();
                    }
                } while (opcion !=7);
                break;
            case 2:
                
                Random randon = new Random();
                int arregloAleatorio[] = new int[10];

                for (int i = 0; i < 10; i++) {
                    int numAleatorio;
                    boolean repetido;

                    do {
                        numAleatorio = randon.nextInt(10) + 1;
                        repetido = false;
                        for (int j = 0; j < i; j++) {// este lo uso para hacer la verificacion del numero
                            if (arregloAleatorio[j] == numAleatorio) {
                                repetido = true;
                                break;
                            }
                        }
                    } while (repetido);
                    arregloAleatorio[i] = numAleatorio;//
                }

                System.out.print("Arreglo aleatorio: ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(arregloAleatorio[i] + " ");
                }
                  
                Random random = new Random();
                int n = 0; // Dimensiones de la matriz
                int[][] matriz = null; // Matriz
                boolean matrizLlena = false; 
                do {
                    // Menú de opciones
                    System.out.println("Menú:");
                    System.out.println("1) Llenar la matriz con números aleatorios entre 1 y 200.");
                    System.out.println("2) Mostrar la matriz.");
                    System.out.println("3) Sumar una fila indicada por el usuario.");
                    System.out.println("4) Sumar una columna indicada por el usuario.");
                    System.out.println("5) Sumar la diagonal principal.");
                    System.out.println("6) Sumar la diagonal inversa.");
                    System.out.println("7) El promedio de los valores de la matriz.");
                    System.out.println("0) Salir.");

                    opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese la dimensión n para una matriz cuadrada n x n: ");
                            n = scanner.nextInt();
                            matriz = new int[n][n];

                            // Llenar la matriz con números aleatorios entre 1 y 200
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                    matriz[i][j] = random.nextInt(200) + 1;
                                }
                            }
                            matrizLlena = true;
                            System.out.println("Matriz llenada con números aleatorios entre 1 y 200.");
                            break;
                        case 2:
                            if (!matrizLlena) {
                                System.out.println("Primero debe llenar la matriz.");
                            } else {
                                mostrarMatriz(matriz);
                            }
                            break;
                        case 3:
                            if (!matrizLlena) {
                                System.out.println("Primero debe llenar la matriz.");
                            } else {
                                System.out.print("Ingrese el número de la fila a sumar (0 a " + (n - 1) + "): ");
                                int filaSumar = scanner.nextInt();
                                if (filaSumar >= 0 && filaSumar < n) {
                                    int sumaFila = sumarFila(matriz, filaSumar);
                                    System.out.println("La suma de la fila " + filaSumar + " es: " + sumaFila);
                                } else {
                                    System.out.println("Fila no válida.");
                                }
                            }
                            break;
                        case 4:
                            if (!matrizLlena) {
                                System.out.println("Primero debe llenar la matriz.");
                            } else {
                                System.out.print("Ingrese el número de la columna a sumar (0 a " + (n - 1) + "): ");
                                int columnaSumar = scanner.nextInt();
                                if (columnaSumar >= 0 && columnaSumar < n) {
                                    int sumaColumna = sumarColumna(matriz, columnaSumar);
                                    System.out.println("La suma de la columna " + columnaSumar + " es: " + sumaColumna);
                                } else {
                                    System.out.println("Columna no válida.");
                                }
                            }
                            break;
                        case 5:
                            if (!matrizLlena) {
                                System.out.println("Primero debe llenar la matriz.");
                            } else {
                                int sumaDiagonalPrincipal = sumarDiagonalPrincipal(matriz);
                                System.out.println("La suma de la diagonal principal es: " + sumaDiagonalPrincipal);
                            }
                            break;
                        case 6:
                            if (!matrizLlena) {
                                System.out.println("Primero debe llenar la matriz.");
                            } else {
                                int sumaDiagonalInversa = sumarDiagonalInversa(matriz);
                                System.out.println("La suma de la diagonal inversa es: " + sumaDiagonalInversa);
                            }
                            break;
                        case 7:
                            if (!matrizLlena) {
                                System.out.println("Primero debe llenar la matriz.");
                            } else {
                                double promedioMatriz = calcularPromedioMatriz(matriz);
                                System.out.println("El promedio de los valores de la matriz es: " + promedioMatriz);
                            }
                            break;
                        case 0:
                            System.out.println("Saliendo del programa.");
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                } while (matrizLlena);
                break;
            default:
                System.err.println("El numero es incorrecto digite un o dos");
                break;
            }//fin del primer swith            
        } while (num !=3);                           
    }//fin del main
    
    //Metodos
    public static int MostrarEmpleados(Scanner scanner){
        System.out.println("____Primera Parte Empleados____");
        System.out.println("1-Indicar la cantidad de trabajadores");
        System.out.println("2-Introducir los datos de los trabajadores");
        System.out.println("3-Ordenar por nombre");
        System.out.println("4-Ordenar por edad");
        System.out.println("5-Ordenar por salario");
        System.out.println("6-Mostrar Informacion de los empleados");
        System.out.println("7-Salir");
        return scanner.nextInt();
    }//fin del metodo mostrar empleados
    
    // Función para mostrar la matriz
    private static void mostrarMatriz(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }//fin de la funcion mostrar matriz

    // Función para sumar una fila
    private static int sumarFila(int[][] matriz, int fila) {
        int suma = 0;
        int n = matriz.length;
        for (int j = 0; j < n; j++) {
            suma += matriz[fila][j];
        }
        return suma;
    }//fin de funcion sumar fila

    // Función para sumar una columna
    private static int sumarColumna(int[][] matriz, int columna) {
        int suma = 0;
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][columna];
        }
        return suma;
    }//fin de funcion para sumar columna

    // Función para sumar la diagonal principal
    private static int sumarDiagonalPrincipal(int[][] matriz) {
        int suma = 0;
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }//fin de diagonal principal

    // Función para sumar la diagonal inversa
    private static int sumarDiagonalInversa(int[][] matriz) {
        int suma = 0;
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][n - 1 - i];
        }
        return suma;
    }//fin de metodo diagonal inversa

    // Función para calcular el promedio de los valores de la matriz
    private static double calcularPromedioMatriz(int[][] matriz) {
        int suma = 0;
        int contador = 0;
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma += matriz[i][j];
                contador++;
            }
        }
        return (double) suma / contador;
    }//fin de Sacar promedio
    
    //Cantidad trabajadores
    public static void cantidadTrabajadores(String[]nombres){
        int cantidad = 0;
        for(String nombre:nombres){
            if (nombre!=null && !nombre.isEmpty()) {
                cantidad++;
            }
        }
        if (cantidad ==0) {
            System.out.println("Aun no ah ingresado trabajadores utilize la opcion 2 del menu");
        }
        else{
            System.out.println("La cantidad de trabajadores es: " + cantidad); 
        }     
    }//fin del metodo CantidadTrabajadores
    
    //Introducir los datos del trabajador
    public static void IntroducirTrabajadores(String[] nombres, int [] edades, double[] salarios){
        String Nombre;
        int edad;
        double Salario;        
        Scanner scanner = new Scanner(System.in);       
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Ingrese el nombre del empleado numero " + i + " :");
            Nombre = scanner.nextLine();
            System.out.println("Ingrese la edad del empeado: ");
            edad = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el Salario del empleado: ");
            Salario = scanner.nextDouble();
            scanner.nextLine();
            nombres [i] = Nombre;
            edades[i] = edad;
            salarios[i] =Salario;      
        }       
    }//fin del metodo introducir trabajadores
    
    
    //Metodo burbuja   
    public static void burbujaNombre(String[] nombres, int[] edades, double[] salarios) {
        int n = nombres.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                // Compara nombres para el ordenamiento
                if (nombres[i - 1].compareTo(nombres[i]) > 0) {
                    // Intercambia nombres
                    String tempNombre = nombres[i - 1];
                    nombres[i - 1] = nombres[i];
                    nombres[i] = tempNombre;

                    // Intercambia edades y salarios correspondientes
                    int tempEdad = edades[i - 1];
                    edades[i - 1] = edades[i];
                    edades[i] = tempEdad;

                    double tempSalario = salarios[i - 1];
                    salarios[i - 1] = salarios[i];
                    salarios[i] = tempSalario;

                    swapped = true;
                }
            }
        } while (swapped);
    }//Fin del metodo

    //Metodo de para ordenar insercion
    public static void insercionEdad(String[] nombres, int[] edades, double[] salarios) {
        int n = edades.length;
        for (int i = 1; i < n; i++) {
            int keyEdad = edades[i];
            double keySalario = salarios[i];
            String keyNombre = nombres[i];
            int j = i - 1;

            // Mueve elementos de edades y salarios a la derecha si son mayores que la clave
            while (j >= 0 && edades[j] > keyEdad) {
                edades[j + 1] = edades[j];
                salarios[j + 1] = salarios[j];
                nombres[j + 1] = nombres[j];
                j = j - 1;
            }

            // Inserta la clave en su lugar correcto
            edades[j + 1] = keyEdad;
            salarios[j + 1] = keySalario;
            nombres[j + 1] = keyNombre;
        }
    }//fin de insercion

    //Metodo ordenar Shellsort
    public static void shellsortSalario(String[] nombres, int[] edades, double[] salarios) {
        int n = salarios.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                double tempSalario = salarios[i];
                String tempNombre = nombres[i];
                int tempEdad = edades[i];
                int j;
                for (j = i; j >= gap && salarios[j - gap] > tempSalario; j -= gap) {
                    salarios[j] = salarios[j - gap];
                    nombres[j] = nombres[j - gap];
                    edades[j] = edades[j - gap];
                }
                salarios[j] = tempSalario;
                nombres[j] = tempNombre;
                edades[j] = tempEdad;
            }
        }
    }//fin del metodo Shellsort
    
    //Mostrar Empleados   
    public static void mostrarInformacionEmpleados(String[] nombres, int[] edades, double[] salarios) {
        System.out.println("Información de los empleados:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Empleado " + (i + 1) + ":");
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Edad: " + edades[i]);
            System.out.println("Salario: " + salarios[i]);
            System.out.println();
        }
    }
    
}//fin de la clase
