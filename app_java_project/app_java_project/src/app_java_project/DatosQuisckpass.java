package app_java_project;

import javax.swing.JOptionPane;

public class DatosQuisckpass {

    private String codigo = "1000000001"; // Ejemplo de código inicial
    private Estado estado = Estado.Activo; // Estado inicial

    // Constructor vacío
    public DatosQuisckpass() {
    }

    // Obtener el estado actual
    public Estado getEstado() {
        return estado;
    }

    // Obtener el código actual
    public String getCodigo() {
        return codigo;
    }

    public boolean CambiarEstado(String pCodigo) {
        if (pCodigo.length() == 10 && pCodigo.substring(0, 3).equals("101") && pCodigo.equals(codigo)) {

            estado = (estado == Estado.Activo) ? Estado.Inactivo : Estado.Activo;
            return true; // Cambio exitoso
        }
        return false; // No se encontró el código
    }
}

