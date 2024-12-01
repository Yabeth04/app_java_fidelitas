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
import java.text.ParseException;

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
        String codigo = JOptionPane.showInputDialog("Ingrese el código del Quickpass:");

        // Buscar el Quickpass en la lista
        DatosQuisckpass quickpassExistente = buscarQuickpassEnLista(codigo);

        if (quickpassExistente != null) {
            // Si el Quickpass existe, registra el acceso sin importar su estado
            String estado = quickpassExistente.getEstado() == Estado.Activo ? "Activo" : "Inactivo";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("quickpasses.txt", true))) {
                writer.write(codigo + "|" + estado); 
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Quickpass registrado exitosamente.");

                // Registrar en el historial
                String placa = quickpassExistente.getPlaca(); // obtener la placa desde el objeto
                String filial = quickpassExistente.getFilial(); // obtneer la filial desde el objeto
                registrarEnHistorial(codigo, placa, filial, estado);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al registrar el Quickpass.");
            }
        } else {
            // Si el Quickpass no está en la lista
            JOptionPane.showMessageDialog(null, "El Quickpass no está registrado.");
        }
    }

    private void registrarEnHistorial(String codigo, String placa, String filial, String condicion) {
        String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        String registro = "Código: " + codigo
                + "; Placa: " + placa
                + "; Filial: " + filial
                + "; Condición: " + condicion
                + "; Fecha: " + fechaHora;

        try (BufferedWriter historialWriter = new BufferedWriter(new FileWriter("Historial.txt", true))) {
            historialWriter.write(registro);
            historialWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar en el historial.");
        }
    }

    public DatosQuisckpass buscarQuickpassEnLista(String codigo) {
        for (DatosQuisckpass quisckpass : listaQuis) {
            if (quisckpass != null && quisckpass.getCodigo().equals(codigo)) {
                return quisckpass; // Retorna el objeto si lo encuentra
            }
        }
        return null; // Retorna null si no encuentra el código
    }

    public void consultarPorFilial() {
        String filialBuscada = JOptionPane.showInputDialog("Ingrese la filial que desea consultar:");

        if (filialBuscada == null || filialBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una filial válida.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String linea;
            boolean encontrado = false;
            String resultado = "Accesos registrados para la filial: " + filialBuscada + "\n";

            while ((linea = reader.readLine()) != null) {
                // Buscar líneas que contienen la filial buscada
                if (linea.contains("Filial: " + filialBuscada)) {
                    resultado += linea + "\n";
                    encontrado = true;
                }
            }

            if (encontrado) {
                // Solo mostrar los resultados de la consulta en el JOptionPane
                JOptionPane.showMessageDialog(null, resultado);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos para la filial: " + filialBuscada);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de historial.");
        }
    }

    public void consultarPorRangoDeFechas() {
        String fechaInicioStr = JOptionPane.showInputDialog("Ingrese la fecha de inicio (dd/MM/yyyy):");
        String fechaFinStr = JOptionPane.showInputDialog("Ingrese la fecha de fin (dd/MM/yyyy):");

        if (fechaInicioStr == null || fechaInicioStr.isEmpty() || fechaFinStr == null || fechaFinStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un rango de fechas válido.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = null;
        Date fechaFin = null;

        try {
            fechaInicio = sdf.parse(fechaInicioStr);
            fechaFin = sdf.parse(fechaFinStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "El formato de fecha es incorrecto. Use (dd/MM/yyyy).");
            return;
        }

        // Leer el archivo de historial
        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String linea;
            boolean encontrado = false;
            String resultado = "Accesos registrados entre las fechas: " + fechaInicioStr + " y " + fechaFinStr + "\n";

            while ((linea = reader.readLine()) != null) {
                // Buscar la fecha en la línea
                String[] partes = linea.split("; ");
                if (partes.length > 4) {
                    String fechaStr = partes[4].substring(7); // Obtener la parte de la fecha (formato: Fecha: dd/MM/yyyy)
                    try {
                        Date fechaRegistro = sdf.parse(fechaStr);

                        if (!fechaRegistro.before(fechaInicio) && !fechaRegistro.after(fechaFin)) {
                            resultado += linea + "\n";
                            encontrado = true;
                        }
                    } catch (ParseException e) {
                        // Si la fecha no es válida, continuar con la siguiente línea
                        continue;
                    }
                }
            }

            if (encontrado) {
                // Mostrar los resultados
                JOptionPane.showMessageDialog(null, resultado);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos dentro del rango de fechas.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de historial.");
        }
    }

    public void consultarPorCodigo() {
        String codigoBuscado = JOptionPane.showInputDialog("Ingrese el código del Quickpass que desea consultar:");

        if (codigoBuscado == null || codigoBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un código válido.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String linea;
            boolean encontrado = false;
            String resultado = "Accesos registrados para el código: " + codigoBuscado + "\n";

            while ((linea = reader.readLine()) != null) {
                // Buscar líneas que contienen el código buscado
                if (linea.contains("Código: " + codigoBuscado)) {
                    resultado += linea + "\n";
                    encontrado = true;
                }
            }

            if (encontrado) {
                // Solo mostrar los resultados de la consulta en el JOptionPane
                JOptionPane.showMessageDialog(null, resultado);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos para el código: " + codigoBuscado);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de historial.");
        }
    }

    public void consultarPorPlaca() {
        String placaBuscada = JOptionPane.showInputDialog("Ingrese la placa del vehículo que desea consultar:");

        if (placaBuscada == null || placaBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una placa válida.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("Historial.txt"))) {
            String linea;
            boolean encontrado = false;
            String resultado = "Accesos registrados para la placa: " + placaBuscada + "\n";

            while ((linea = reader.readLine()) != null) {
                if (linea.contains("Placa: " + placaBuscada)) {
                    resultado += linea + "\n";
                    encontrado = true;
                }
            }

            if (encontrado) {
                JOptionPane.showMessageDialog(null, resultado);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos para la placa: " + placaBuscada);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de historial.");
        }
    }

}
