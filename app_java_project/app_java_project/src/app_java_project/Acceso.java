/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_java_project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author yabet
 */
public class Acceso {
    // Método para registrar la consulta en el archivo de texto

    public static void registrarActividad(String consulta, String resultado, String codigo, String placa, String filial, Estado estado) {
        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaHora = ahora.format(formatter);

        // Formato de la línea a guardar en el archivo
        String linea = "Código: " + codigo + "; Placa: " + placa + "; Filial: " + filial + "; Condición: " + estado + "; Fecha: " + fechaHora + "; Consulta: " + consulta + "; Resultado: " + resultado + "\n";

        // Guardar en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial.txt", true))) {
            writer.write(linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método de ejemplo para consultar por filial
    public static void consultarPorFilial(String filial) {
        // Lógica para realizar la consulta (puedes adaptarlo según tu caso)
        String resultado = "Consulta exitosa para la filial: " + filial;  // Suponiendo que se obtiene algún resultado
        registrarActividad("Consultar por filial", resultado, "1011234567", "123ABC", filial, Estado.Activo);  // Aquí se registra la consulta
    }
}
