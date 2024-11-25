package app_java_project;

import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.*;
import java.util.*;

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
        String condicion = JOptionPane.showInputDialog("Ingrese la condición:");

        // Obtener la fecha y hora actuales
        String fechaHora = java.time.LocalDateTime.now().toString();

        // Crear el texto para guardar en el archivo
        String logEntry = String.format("Codigo: %s; Placa: %s; Filial: %s; Condición: %s; Fecha: %s\n",
                codigo, placa, filial, condicion, fechaHora);

        // Guardar en el archivo "Historial.txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Historial.txt", true))) {
            writer.write(logEntry);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el acceso: " + e.getMessage());
        }
    }

    public void consultarPorFilial(String filial) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Filial: " + filial)) {
                    JOptionPane.showMessageDialog(null, line);
                    found = true;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos para la filial: " + filial);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el historial: " + e.getMessage());
        }
    }

    public void consultarPorFecha(String fechaInicio, String fechaFin) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String fecha = line.split("Fecha: ")[1].split(" ")[0]; // Extrae la fecha
                if (fecha.compareTo(fechaInicio) >= 0 && fecha.compareTo(fechaFin) <= 0) {
                    JOptionPane.showMessageDialog(null, line);
                    found = true;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos en el rango de fechas.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el historial: " + e.getMessage());
        }
    }

    public void consultarPorCodigo(String codigo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Codigo: " + codigo) || line.contains("Placa: " + codigo)) {
                    JOptionPane.showMessageDialog(null, line);
                    found = true;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos para el código o placa: " + codigo);
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
                contenido += line + "\n"; // Concatenación directa con el operador "+"
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("HistorialCompleto.txt"))) {
                writer.write(contenido); // Escribimos directamente la cadena concatenada
            }

            JOptionPane.showMessageDialog(null, "Archivo generado correctamente: HistorialCompleto.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el archivo: " + e.getMessage());
        }
    }

}
