package app_java_project;

import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author samue
 */
public class ControlCondominio {

    private DatosQuisckpass listaQuis[];
    private DatosQuisckpass listaQuisEliminados[];
    private int espacio;
    private int espacioEliminado;

    public ControlCondominio(int size) {
        this.listaQuisEliminados = new DatosQuisckpass[size];
        this.listaQuis = new DatosQuisckpass[size];
        this.espacio = size;
        this.espacioEliminado = size;
    }

    public void AgregarQuis(DatosQuisckpass DQ) {
        if (espacio > 0) {
            for (int i = 0; i < listaQuis.length; i++) {
                if (listaQuis[i] == null) {
                    listaQuis[i] = DQ;
                    espacio -= 1;
                    JOptionPane.showMessageDialog(null, "QUISCKPASS AGREGADO CORRECTAMENTE");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE AGREGAR MÁS QUISCKPASS");
        }
    }

    @Override
    public String toString() {
        String r = "";
        if (listaQuis.length != espacio) {
            r = "~~QUISCKPASS~~\n";
            for (int i = 0; i < listaQuis.length; i++) {
                if (listaQuis[i] != null) {
                    r += (i + 1) + ") " + listaQuis[i];
                }
            }
        } else {
            r += "LA LISTA ESTA VACIA";
        }
        return r;
    }

    public String toString(String pFilial) {
        String r = "";
        if (listaQuis.length != espacio) {
            r = "~~QUISCKPASS~~\n";
            for (int i = 0; i < listaQuis.length; i++) {
                if (listaQuis[i] != null && pFilial.equals(listaQuis[i].getFilial())) {
                    r += (i + 1) + ") " + listaQuis[i];
                }
            }
        } else {
            r += "LA LISTA ESTA VACIA";
        }
        return r;
    }

    public String toString(String pCodigo, String pFilial) {
        String r = "";
        if (listaQuis.length != espacio) {
            r = "~~QUISCKPASS~~\n";
            for (int i = 0; i < listaQuis.length; i++) {
                if (listaQuis[i] != null && pCodigo.equals(listaQuis[i].getCodigo()) && pFilial.equals(listaQuis[i].getFilial())) {
                    r += (i + 1) + ") " + listaQuis[i];
                }
            }
        } else {
            r += "LA LISTA ESTA VACIA";
        }
        return r;
    }

    public boolean CambiarEstado(String pCodigo) {
        for (int i = 0; i < listaQuis.length; i++) {
            if (listaQuis[i] != null) {
                if (pCodigo.equals(listaQuis[i].getCodigo())) {
                    // Cambiar estado y mostrar mensaje de confirmación
                    if (listaQuis[i].getEstado() == Estado.Activo) {
                        listaQuis[i].setEstado(Estado.Inactivo);
                    } else {
                        listaQuis[i].setEstado(Estado.Activo);
                    }

                    JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente a: " + listaQuis[i].getEstado());
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Código no encontrado.");
        return false;
    }

    public void EliminarQuis(String pCambio) {
        int cont = 0;
        for (int i = 0; i < listaQuis.length; i++) {
            if (listaQuis[i] != null) {
                if (pCambio.equals(listaQuis[i].getCodigo())) {
                    DatosQuisckpass Borrado = listaQuis[i];
                    for (int z = 0; z < listaQuisEliminados.length; z++) {
                        if (listaQuisEliminados[i] == null && cont == 0) {
                            listaQuisEliminados[i] = Borrado;
                            espacioEliminado -= 1;
                            cont += 1;
                        }
                    }
                    listaQuis[i] = null;
                    espacio += 1;

                } else if (pCambio.equals(listaQuis[i].getPlaca())) {
                    DatosQuisckpass Borrado = listaQuis[i];
                    for (int z = 0; z < listaQuisEliminados.length; z++) {
                        if (listaQuisEliminados[i] == null && cont == 0) {
                            listaQuisEliminados[i] = Borrado;
                            espacioEliminado -= 1;
                            cont += 1;
                        }
                    }
                    listaQuis[i] = null;
                    espacio += 1;

                } else {
                    JOptionPane.showMessageDialog(null, "ELIMINADO CORRECTAMENTE");
                }
            }
        }

    }

    public String toStringEliminado() {
        String r = "";
        if (listaQuisEliminados.length != espacioEliminado) {
            r = "~~QUISCKPASS ELIMINADOS~~\n";
            for (int i = 0; i < listaQuisEliminados.length; i++) {
                if (listaQuisEliminados[i] != null) {
                    r += (i + 1) + ") " + listaQuisEliminados[i];
                }
            }
        } else {
            r += "LA LISTA ESTA VACIA";
        }
        return r;
    }

    public String toStringEliminado(String pFilial) {
        String r = "";
        if (listaQuisEliminados.length != espacioEliminado) {
            r = "~~QUISCKPASS~~\n";
            for (int i = 0; i < listaQuisEliminados.length; i++) {
                if (listaQuisEliminados[i] != null && pFilial.equals(listaQuisEliminados[i].getFilial())) {
                    r += (i + 1) + ") " + listaQuisEliminados[i];
                }
            }
        } else {
            r += "LA LISTA ESTA VACIA";
        }
        return r;
    }

    public String toStringEliminado(String pCodigo, String pFilial) {
        String r = "";
        if (listaQuisEliminados.length != espacioEliminado) {
            r = "~~QUISCKPASS~~\n";
            for (int i = 0; i < listaQuisEliminados.length; i++) {
                if (listaQuisEliminados[i] != null && pCodigo.equals(listaQuisEliminados[i].getCodigo()) && pFilial.equals(listaQuisEliminados[i].getFilial())) {
                    r += (i + 1) + ") " + listaQuisEliminados[i];
                }
            }
        } else {
            r += "LA LISTA ESTA VACIA";
        }
        return r;
    }

    public String consultaCod(String pCodigo) {
        for (DatosQuisckpass quisckpass : listaQuis) {
            if (quisckpass != null && quisckpass.getCodigo().equals(pCodigo)) {
                // Si existe y su estado es activo, es aceptado
                if (quisckpass.getEstado() == Estado.Activo) {
                    return "Aceptado";
                } else {
                    return "Rechazado"; // Existe pero está inactivo
                }
            }
        }
        return "Rechazado"; // No se encontró el código en la lista
    }

    public void registrarAcceso() {
        // Datos de acceso (simulados, puedes modificar según lo que necesites)
        String codigo = JOptionPane.showInputDialog("Ingrese el código:");
        String placa = JOptionPane.showInputDialog("Ingrese la placa:");
        String filial = JOptionPane.showInputDialog("Ingrese la filial:");

        // Validación para la opción de la condición
        String condicion = "";
        try {
            int optionCondition = Integer.parseInt(JOptionPane.showInputDialog("1) Aceptado\n 2) Rechazado\n\nIngrese la opción de la condición: "));
            switch (optionCondition) {
                case 1 ->
                    condicion = "Aceptado";
                case 2 ->
                    condicion = "Rechazado";
                default -> {
                    condicion = "Rechazado"; // Condición por defecto
                    JOptionPane.showMessageDialog(null, "Opción inválida. Se usará 'Rechazado'.");
                }
            }
        } catch (NumberFormatException e) {
            // Si el usuario no ingresa un número válido
            condicion = "Rechazado";
            JOptionPane.showMessageDialog(null, "Opción inválida. Se usará 'Rechazado'.");
        }

        String fechaHora = LocalDateTime.now().toString();

        // Crear el texto para guardar en el archivo
        String logEntry = String.format("Código: %s; Placa: %s; Filial: %s; Condición: %s; Fecha: %s\n",
                codigo, placa, filial, condicion, fechaHora);

        // Guardar en el archivo "Historial.txt"
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Historial.txt", true), StandardCharsets.UTF_8))) {
            writer.write(logEntry);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el acceso: " + e.getMessage());
        }
    }

    public void consultarPorFilial(String filial) {
        boolean found = false;

        // Usamos try-with-resources para abrir y cerrar automáticamente el archivo
        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Verifica si la línea comienza con "Filial: "
                if (line.length() > 7 && line.substring(0, 7).equals("Filial:")) {
                    // Extrae la parte de la filial de la línea
                    String lineaFilial = line.substring(8); // El texto después de "Filial: "

                    // Comparar manualmente la cadena sin usar métodos avanzados
                    if (lineaFilial.length() >= filial.length()) {
                        String parteFilial = lineaFilial.substring(0, filial.length());
                        if (parteFilial.equals(filial)) {
                            JOptionPane.showMessageDialog(null, line);
                            found = true;
                        }
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "consulta registrada.puede verla en el archivo ");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el historial: " + e.getMessage());
        }
    }

    public void consultarPorFecha() {
        // Pedir al usuario el día, mes y año para las fechas de inicio y fin
        int diaInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de inicio:"));
        int mesInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de inicio:"));
        int añoInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de inicio:"));

        int diaFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de fin:"));
        int mesFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de fin:"));
        int añoFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fin:"));

        // Convertir las fechas a un formato simple "yyyyMMdd" para facilitar la comparación
        String fechaInicio = String.format("%04d%02d%02d", añoInicio, mesInicio, diaInicio);
        String fechaFin = String.format("%04d%02d%02d", añoFin, mesFin, diaFin);

        BufferedReader reader = null;
        String line;
        boolean found = false;

        try {
            reader = new BufferedReader(new FileReader("Historial.txt"));

            // Leer cada línea del archivo
            while ((line = reader.readLine()) != null) {
                // Verificar si la línea tiene al menos 17 caracteres 
                if (line.length() >= 17 && line.substring(0, 6).equals("Fecha:")) {
                    String fecha = line.substring(7, 17);  // "yyyy-MM-dd"

                    // Comparar las fechas manualmente 
                    if (esFechaValida(fecha, fechaInicio) && esFechaValida(fecha, fechaFin)) {
                        JOptionPane.showMessageDialog(null, line);
                        found = true;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "consulta registrada.puede verla en el archivo ");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el historial: " + e.getMessage());
        }
    }

    private boolean esFechaValida(String fechaComparar, String fechaReferencia) {
        // Comparar año
        int añoComparar = Integer.parseInt(fechaComparar.substring(0, 4));
        int añoReferencia = Integer.parseInt(fechaReferencia.substring(0, 4));
        if (añoComparar < añoReferencia) {
            return false;
        }
        if (añoComparar > añoReferencia) {
            return true;
        }

        // Comparar mes
        int mesComparar = Integer.parseInt(fechaComparar.substring(5, 7));
        int mesReferencia = Integer.parseInt(fechaReferencia.substring(5, 7));
        if (mesComparar < mesReferencia) {
            return false;
        }
        if (mesComparar > mesReferencia) {
            return true;
        }

        // Comparar día
        int diaComparar = Integer.parseInt(fechaComparar.substring(8, 10));
        int diaReferencia = Integer.parseInt(fechaReferencia.substring(8, 10));
        return diaComparar >= diaReferencia;
    }

    public void consultarPorCodigo(String codigo) {
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.length() > 7 && line.substring(0, 7).equals("Codigo:") && line.substring(7, 7 + codigo.length()).equals(codigo)) {
                    JOptionPane.showMessageDialog(null, line);
                    found = true;
                } else if (line.length() > 7 && line.substring(0, 7).equals("Placa:") && line.substring(7, 7 + codigo.length()).equals(codigo)) {
                    JOptionPane.showMessageDialog(null, line);
                    found = true;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "consulta registrada.puede verla en el archivo ");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el historial: " + e.getMessage());
        }
    }

    public void GenerarTxt() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String line;
            String contenido = ""; // Cadena inicial vacía
            while ((line = reader.readLine()) != null) {
                contenido += line + "\n"; // Concatenación directa
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("HistorialCompleto.txt"))) {
                writer.write(contenido);
            }

            JOptionPane.showMessageDialog(null, "Archivo generado correctamente: HistorialCompleto.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo: " + e.getMessage());
        }
    }
}
