package app_java_project;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class ControlCondominio {

    private ArrayList<DatosQuisckpass> ArrayQuis;
    private ArrayList<DatosQuisckpass> ArrayQuisEliminados;

    public ControlCondominio() {
        this.ArrayQuis = new ArrayList<>();
        this.ArrayQuisEliminados = new ArrayList<>();
    }

    public void AgregarQuis(DatosQuisckpass a) {
        this.ArrayQuis.add(a);
    }

    public int CantQuis() {
        return this.ArrayQuis.size();
    }

    public DatosQuisckpass MostrarQuis() {
        DatosQuisckpass b = null;
        for (DatosQuisckpass dato : ArrayQuis) {
            b = dato;
        }
        return b;
    }

    public boolean CambiarEstado(String codigo) {
        for (DatosQuisckpass dato : ArrayQuis) {
            if (dato.getCodigo().equals(codigo)) {
                // Cambiar el estado del Quisckpass al contrario del actual
                if (dato.getEstado() == Estado.Activo) {
                    dato.setEstado(Estado.Inactivo);
                } else {
                    dato.setEstado(Estado.Activo);
                }
                return true; // Cambio exitoso
            }
        }
        return false; // No se encontró el código
    }

}
