/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app_java_project;

/**
 *
 * @author yabet
 */
public class App_java_project {
    public static void main(String[] args) {
import javax.swing.JOptionPane;

public class ControlCondominio {
    private String[] historial;
    private int contador;

    public ControlCondominio(int capacidad) {
        historial = new String[capacidad];
        contador = 0;
    }

    // Registrar acceso en memoria (sin archivos)
    public void registrarAcceso() {
        if (contador >= historial.length) {
            JOptionPane.showMessageDialog(null, "Error: Capacidad máxima alcanzada.");
            return;
        }

        String codigo = JOptionPane.showInputDialog("Ingrese el código:");
        String placa = JOptionPane.showInputDialog("Ingrese la placa:");
        String filial = JOptionPane.showInputDialog("Ingrese la filial:");
        String condicion = JOptionPane.showInputDialog("Ingrese la condición (Aceptado o Denegado):");

        // Simulación de la fecha como texto fijo (ya que no podemos usar Date ni SimpleDateFormat)
        String fecha = "15/05/2024 14:40"; 
        String registro = String.format("Codigo: %s; Placa: %s; Filial: %s; Condición: %s; Fecha: %s", codigo, placa, filial, condicion, fecha);

        historial[contador++] = registro;
        JOptionPane.showMessageDialog(null, "Acceso registrado exitosamente.");
    }

    // Consultar por filial específica
    public void consultarPorFilial() {
        String filial = JOptionPane.showInputDialog("Ingrese la filial a consultar:");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < contador; i++) {
            if (historial[i].contains("Filial: " + filial)) {
                resultado.append(historial[i]).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, resultado.length() > 0 ? resultado.toString() : "No se encontraron registros para la filial especificada.");
    }

    // Consultar por fecha (simulación sin Date)
    public void consultarPorFecha() {
        String fechaInicio = JOptionPane.showInputDialog("Ingrese la fecha de inicio (dd/MM/yyyy):");
        String fechaFin = JOptionPane.showInputDialog("Ingrese la fecha de fin (dd/MM/yyyy):");
        StringBuilder resultado = new StringBuilder();

        // Suponiendo fecha fija "15/05/2024 14:40" como ejemplo
        for (int i = 0; i < contador; i++) {
            String fechaRegistro = "15/05/2024";
            if (fechaRegistro.compareTo(fechaInicio) >= 0 && fechaRegistro.compareTo(fechaFin) <= 0) {
                resultado.append(historial[i]).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, resultado.length() > 0 ? resultado.toString() : "No se encontraron registros en el rango de fechas especificado.");
    }

    // Consultar por código o placa
    public void consultarPorCodigoOPlaca() {
        String termino = JOptionPane.showInputDialog("Ingrese el código o placa a consultar:");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < contador; i++) {
            if (historial[i].contains("Codigo: " + termino) || historial[i].contains("Placa: " + termino)) {
                resultado.append(historial[i]).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, resultado.length() > 0 ? resultado.toString() : "No se encontraron registros para el código o placa especificado.");
    }
}

}
