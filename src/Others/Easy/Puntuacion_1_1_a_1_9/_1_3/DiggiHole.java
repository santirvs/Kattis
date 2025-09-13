package Others.Easy.Puntuacion_1_1_a_1_9._1_3;

// Leer los datos
// numTrabajadores, horasTrabajadas, metrosCubicos, nuevoNumTrabajadores, nuevoMetrosCubicos
// Calcular la productividad por trabajador en metros cúbicos por hora / trabajador*metrosCubicos
// Calcular las horas que tardarían con el nuevo número de trabajadores y la nueva cantidad de metros cúbicos si se mantiene la misma productividad
// Horas = (nuevoMetrosCubicos / productividad) / nuevoNumTrabajadores

import java.util.Scanner;

public class DiggiHole {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Leer los datos
        double numTrabajadores = scan.nextDouble();
        double horasTrabajadas = scan.nextDouble();
        double metrosCubicos = scan.nextDouble();
        double nuevoNumTrabajadores = scan.nextDouble();
        double nuevoMetrosCubicos = scan.nextDouble();
        //Calcular la productividad
        double productividad = (metrosCubicos / horasTrabajadas) / numTrabajadores;
        //Calcular las horas que tardarían con el nuevo número de trabajadores y la nueva
        double horas = (nuevoMetrosCubicos / productividad) / nuevoNumTrabajadores;
        //Mostrar el resultado, con 3 decimales
        System.out.printf("%.3f%n", horas);


    }
}