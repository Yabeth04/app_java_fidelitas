package app_java_project;

import javax.swing.JOptionPane;


/**
 *
 * @author samue
 */
public final class DatosQuisckpass {

    private String filial = null;
    private String codigo = null;
    private String placa = null;
    private Estado estado = Estado.Activo;

    public DatosQuisckpass() {
        this.setFilial();
        this.setCodigo();
        this.setPlaca();
        this.getEstado();
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial() {
        boolean bandera = true;

        while (bandera) {
            String pFilial = JOptionPane.showInputDialog(null, "Ingrese el número del Filial");
            if (pFilial.length() > 0) {
                filial = pFilial;
                bandera = false;
            } else {
                JOptionPane.showMessageDialog(null, "Error del tamaño del Filial");
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        boolean bandera = true;

        while (bandera) {
            String pCodigo = JOptionPane.showInputDialog(null, "Ingrese el número del codigo");
            if (pCodigo.length() == 10) {
                if (pCodigo.substring(0, 3).equals("101")) {
                    codigo = pCodigo;
                    bandera = false;

                } else {
                    JOptionPane.showMessageDialog(null, "Error el codigo no comienza en 101");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error del tamaño del Codigo");
            }
        }
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca() {
        boolean bandera = true;

        while (bandera) {
            String pPlaca = JOptionPane.showInputDialog(null, "Ingrese el número de la placa");
            if (pPlaca.length() > 0) {
                placa = pPlaca;
                bandera = false;
            } else {
                JOptionPane.showMessageDialog(null, "Error del tamaño de la placa");
            }
        }
    }

    public Estado getEstado() {
        return estado;
    }

    public Estado setEstado(Estado pEstado) {
        return this.estado = pEstado;
    }

    @Override
    public String toString() {
        return "Filial: " + filial + ", Codigo: " + codigo + ", Placa: " + placa + ", Estado: " + estado + "\n";
    }

}
