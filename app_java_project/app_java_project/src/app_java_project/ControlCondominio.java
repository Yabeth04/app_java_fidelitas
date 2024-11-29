package app_java_project;

import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
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
    private List<String> listaBitacora;
    private int espacio;
    private int espacioEliminado;

    public ControlCondominio(int size) {
        this.listaQuisEliminados = new DatosQuisckpass[size];
        this.listaQuis = new DatosQuisckpass[size];
        this.espacio = size;
        this.espacioEliminado = size;
        listaBitacora = new ArrayList<>();
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
        if (listaQuis.length == espacio) { // La lista está vacía
            return "Rechazado (la lista está vacía)";
        }

        for (DatosQuisckpass quisckpass : listaQuis) {
            if (quisckpass != null && quisckpass.getCodigo().equals(pCodigo)) {
                if (quisckpass.getEstado() == Estado.Activo) {
                    return "Aceptado";
                } else {
                    return "Rechazado"; // Existe pero está inactivo
                }
            }
        }

        return "Rechazado"; // No se encontró el código en la lista
    }

    private static final String ARCHIVO_QUICKPASS = "quickpasses.txt"; // archivo donde se guardan los quickpasses

    public void registrar() {
        // Leer los datos del Quickpass
        String codigo = JOptionPane.showInputDialog("Ingrese el código del Quickpass:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del Quickpass:");

        // Buscar el Quickpass en la listaQuickpass
        DatosQuisckpass quickpassExistente = buscarQuickpassEnLista(codigo);

        if (quickpassExistente != null && quickpassExistente.getEstado().equals("Activo")) {
            // Si el Quickpass está en la lista y está activo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("quickpasses.txt", true))) {
                writer.write(codigo + "|" + "activo" + "|" + descripcion);
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Quickpass registrado exitosamente.");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al registrar el Quickpass.");
            }
        } else {
            // Si el Quickpass no está en la lista o no está activo
            JOptionPane.showMessageDialog(null, "El Quickpass no está registrado o no está activo.");
        }
    }

    private DatosQuisckpass buscarQuickpassEnLista(String codigo) {
        for (DatosQuisckpass quickpass : listaQuis) {
            if (quickpass != null) {
                System.out.println("Comparando " + codigo + " con " + quickpass.getCodigo());
                try {
                    int codigoQuickpass = Integer.parseInt(quickpass.getCodigo());
                    int codigoIngresado = Integer.parseInt(codigo);

                    if (codigoQuickpass == codigoIngresado) {
                        return quickpass; // Retorna el Quickpass si los códigos coinciden
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: El código no es un número válido.");
                }
            }
        }
        return null; // Si no lo encuentra
    }

    public void consultaFilial() {
        String filial = JOptionPane.showInputDialog("Ingrese la filial para buscar:");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_QUICKPASS));
            String line;
            boolean encontrado = false;

            while ((line = reader.readLine()) != null) {
                String[] partes = line.split("\\|");

                // Verificar si el código corresponde y si el Quickpass está activo
                if (partes[0].equals(filial) && partes[1].equals("activo")) {
                    JOptionPane.showMessageDialog(null, "Quickpass encontrado: " + partes[2]); // Mostrar descripción
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró el Quickpass o está inactivo.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
        }
    }
}
