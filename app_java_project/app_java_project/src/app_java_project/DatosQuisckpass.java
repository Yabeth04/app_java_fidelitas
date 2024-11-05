package app_java_project;

import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class DatosQuisckpass {

    private String filial;
    private String codigo;
    private String placa;
    private Estado estado = Estado.Activo; // Estado por defecto es Activo.

    public DatosQuisckpass(String pFilial, String pCodigo, String pPlaca) {
        this.setFilial(pFilial);
        this.setCodigo(pCodigo);
        this.setPlaca(pPlaca);
        this.getEstado();
    }

    //OBTENER DATOS
    public String getFilial() {
        return filial;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public Estado getEstado() {
        return estado;
    }

    //MODIFICAR DATOS
    public void setFilial(String pFilial) {
        if (pFilial.length() > 0) {
            filial = pFilial;
        } else {
            JOptionPane.showMessageDialog(null, "Error del tamaño del Filial");
        }
    }

    public void setCodigo(String pCodigo) {
        if (pCodigo.length() == 10 && pCodigo.substring(0, 3).equals("101")) {
            codigo = pCodigo;

        } else {
            JOptionPane.showMessageDialog(null, "Código no válido. Debe comenzar con '101' y tener 10 dígitos.");
        }
    }

    public String setPlaca(String pPlaca) {
        return placa = pPlaca;
    }

    public void setEstado(Estado pEstado) {
        this.estado = pEstado;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Filial: " + filial + "\nCodigo: " + codigo + "\nPlaca: " + placa + "\nEstado: " + estado;
    }
}
