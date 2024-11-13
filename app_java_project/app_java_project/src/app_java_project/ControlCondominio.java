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

    public void GenerarTxt() throws IOException {
        Path archivo = Paths.get("ListaQuisckpass.txt");

        // Validar si la lista es null o está vacía
        if (listaQuis == null || listaQuis.length == 0) {
            JOptionPane.showMessageDialog(null, "Lista vacía.");
            return;  // Salir si la lista está vacía o es null
        }

        // Crear una lista de líneas para escribir en el archivo
        List<String> lines = new ArrayList<>();

        // Recorrer la lista y agregar las líneas de los objetos no null
        for (DatosQuisckpass quisckpass : listaQuis) {
            if (quisckpass != null) {
                String linea = "Codigo: " + quisckpass.getCodigo() + "; Placa: " + quisckpass.getPlaca()
                        + "; Filial: " + quisckpass.getFilial() + " ; Estado: " + quisckpass.getEstado()
                        + " ; Fecha: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(new java.util.Date());
                lines.add(linea);  // Agregar la línea a la lista
            }
        }

        // Verificar si se agregaron líneas
        if (lines.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para escribir.");
            return;
        }

        // Escribir las líneas en el archivo
        Files.write(archivo, lines, StandardOpenOption.CREATE);

        // Mensaje de éxito
        JOptionPane.showMessageDialog(null, "Archivo de datos generado exitosamente.");
    }
}
