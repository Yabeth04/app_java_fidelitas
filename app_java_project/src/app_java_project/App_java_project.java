package app_java_project;

import javax.swing.JOptionPane;

public class App_java_project {

    public static void main(String[] args) {
        // Inicializar el controlador de condominio
        ControlCondominio control = new ControlCondominio(10); // Capacidad de 10 registros

        // Mostrar opciones al usuario
        String[] opciones = {"Registrar acceso", "Consultar por filial", "Consultar por fecha", "Consultar por código o placa"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Elija una opción", "Control de Condominio",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        switch (opcion) {
            case "Registrar acceso":
                control.registrarAcceso();
                break;
            case "Consultar por filial":
                control.consultarPorFilial();
                break;
            case "Consultar por fecha":
                control.consultarPorFecha();
                break;
            case "Consultar por código o placa":
                control.consultarPorCodigoOPlaca();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
        }
    }
}

class ControlCondominio {

    private String[] historial;
    private int contador;

    public ControlCondominio(int capacidad) {
        historial = new String[capacidad];
        contador = 0;
    }

    public void registrarAcceso() {
        try {
            // Solicitar los datos al usuario
            String codigo = JOptionPane.showInputDialog("Ingrese el código:");
            String placa = JOptionPane.showInputDialog("Ingrese la placa:");
            String filial = JOptionPane.showInputDialog("Ingrese la filial:");
            String condicion = JOptionPane.showInputDialog("Ingrese la condición (Aceptado o Denegado):");

            // Obtener la fecha y hora actual del sistema
            String fecha = java.time.LocalDateTime.now().toString(); // Fecha y hora en formato ISO

            // Formatear el registro
            String registro = String.format("Codigo: %s; Placa: %s; Filial: %s; Condición: %s; Fecha: %s", codigo, placa, filial, condicion, fecha);

            // Escribir el registro en el archivo Historial.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial.txt", true))) {
                writer.write(registro);
                writer.newLine();  // Añadir una nueva línea después de cada registro
            }

            JOptionPane.showMessageDialog(null, "Acceso registrado exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar acceso: " + e.getMessage());
        }
    }

    // Consultar por filial específica
    public void consultarPorFilial() {
        String filial = JOptionPane.showInputDialog("Ingrese la filial a consultar:");
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < contador; i++) {
            if (historial[i].contains("Filial: " + filial)) {
                resultado += historial[i] + "\n";
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
