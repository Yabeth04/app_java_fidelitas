package app_java_project;

import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class DatosQuisckpass {

    int Size = 10;
    private String ArrayEliminados[][] = new String[Size][4];
    private String ArrayQuis[][] = new String[Size][4];

    private String filial = null;
    private String codigo = null;
    private String placa = null;
    private Estado estado = Estado.Activo;

    public DatosQuisckpass() {
    }

    public DatosQuisckpass(String nulo) {
        this.setFilial();
        this.setCodigo();
        this.setPlaca();
        this.getEstado();
    }

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

    //CAMBIAR ESTADO
    public boolean CambiarEstado(String pCodigo) {
        for (int i = 0; i < ArrayQuis.length; i++) {
            for (int j = 0; j < ArrayQuis[i].length; j++) {
                if (pCodigo.equals(ArrayQuis[i][j])) {
                    if (ArrayQuis[i][3].equals("" + Estado.Activo)) {
                        ArrayQuis[i][3] = "" + Estado.Inactivo;
                    } else {
                        ArrayQuis[i][3] = "" + Estado.Activo;
                    }
                    return true;
                }
            }
        }
        return false;
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

    public void setCodigo() {
        boolean bandera = true;

        while (bandera) {
            String pCodigo = JOptionPane.showInputDialog(null, "Ingrese el número del codigo");
            if (pCodigo.startsWith("101")) {
                if (pCodigo.length() == 10) {
                    codigo = pCodigo;
                    bandera = false;

                } else {
                    JOptionPane.showMessageDialog(null, "Error del tamaño del Codigo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error el codigo no comienza en 101");
            }
        }
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

    // AGREGAR / INGRESAR CODIGO,FILIAL Y PLACA
    public void AgregarQuis() {
        int limite = 0;

        for (int i = 0; i < ArrayQuis.length; i++) {
            for (int j = 0; j < ArrayQuis[i].length; j++) {
                if (ArrayQuis[i][j] == null && limite < 4) {
                    switch (j) {
                        case 0 -> {
                            ArrayQuis[i][j] = filial;
                        }
                        case 1 -> {
                            ArrayQuis[i][j] = codigo;
                        }
                        case 2 -> {
                            ArrayQuis[i][j] = placa;
                        }
                        case 3 -> {
                            ArrayQuis[i][j] = "" + estado;
                        }
                    }
                    limite += 1;
                }
            }
        }
    }

    // OPCION CONSULTAR
    //TODOS LOS DATOS
    public String MostrarQuis() {
        String Res = "";
        for (int i = 0; i < ArrayQuis.length; i++) {
            for (int j = 0; j < ArrayQuis[i].length; j++) {
                if (ArrayQuis[i][j] != null) {
                    switch (j) {
                        case 0 -> {
                            Res += "Filial: " + ArrayQuis[i][j];
                        }
                        case 1 -> {
                            Res += ", Codigo: " + ArrayQuis[i][j];
                        }
                        case 2 -> {
                            Res += ", Placa: " + ArrayQuis[i][j];
                        }
                        case 3 -> {
                            Res += ", Estado: " + ArrayQuis[i][j] + "\n";
                        }
                    }
                }
            }
        }
        return Res;
    }

    //LOS DE UNA FILIAL
    public String MostrarFilial(String pConsulta) {
        String Res = "";
        for (int i = 0; i < ArrayQuis.length; i++) {
            for (int j = 0; j < ArrayQuis[i].length; j++) {
                if (ArrayQuis[i][j] != null) {
                    if (pConsulta.equals(ArrayQuis[i][j])) {
                        Res += "Filial: " + ArrayQuis[i][0];
                        Res += ", Codigo: " + ArrayQuis[i][1];
                        Res += ", Placa: " + ArrayQuis[i][2];
                        Res += ", Estado: " + ArrayQuis[i][3] + "\n";
                    }
                }
            }
        }
        return Res;
    }

    //MOSTRAR UNO EN ESPECIFICO
    public String MostrarUnoEspecifico(String pConsulta) {
        String Res = "";
        for (int i = 0; i < ArrayQuis.length; i++) {
            for (int j = 0; j < ArrayQuis[i].length; j++) {
                if (ArrayQuis[i][j] != null) {
                    // Buscar por código (o placa, depende de la entrada)
                    if (pConsulta.equals(ArrayQuis[i][1])) {  // 1 es el índice para el código
                        Res += "Filial: " + ArrayQuis[i][0];
                        Res += ", Codigo: " + ArrayQuis[i][1];
                        Res += ", Placa: " + ArrayQuis[i][2];
                        Res += ", Estado: " + ArrayQuis[i][3] + "\n";
                        return Res; // Devolver solo el primer resultado encontrado
                    }
                }
            }
        }
        return "No se encontró el código/placa especificado.";
    }

    //ELIMINAR 
    //ELIMINAR PLACA 
    public boolean EliminarPorPlaca(String placa) {
        for (int i = 0; i < ArrayQuis.length; i++) {
            if (ArrayQuis[i][2] != null && ArrayQuis[i][2].equals(placa)) {
                // busqueda de la placa, se "copia" a ArrayEliminados
                for (int j = 0; j < ArrayEliminados.length; j++) {
                    // se busca la primera fila vacía en ArrayEliminados para agregarse
                    if (ArrayEliminados[j][0] == null) {
                        ArrayEliminados[j][0] = ArrayQuis[i][0];
                        ArrayEliminados[j][1] = ArrayQuis[i][1];
                        ArrayEliminados[j][2] = ArrayQuis[i][2];
                        ArrayEliminados[j][3] = ArrayQuis[i][3];
                        break;  // se termina de "copiar" y sale del loop
                    }
                }

                //  elimina la placa de arrayquis
                ArrayQuis[i][0] = null;
                ArrayQuis[i][1] = null;
                ArrayQuis[i][2] = null;
                ArrayQuis[i][3] = null;

                return true;  // La placa eliminada-
            }
        }
        return false;  // La placa existe
    }

    // ELIMINAR POR CÓDIGO
    public boolean EliminarPorCodigo(String codigo) {
        for (int i = 0; i < ArrayQuis.length; i++) {
            if (ArrayQuis[i][1] != null && ArrayQuis[i][1].equals(codigo)) {
                // busqueda del código, se "copia" a ArrayEliminados
                for (int j = 0; j < ArrayEliminados.length; j++) {
                    // se busca la primera fila vacía en ArrayEliminados para agregarse
                    if (ArrayEliminados[j][0] == null) {
                        ArrayEliminados[j][0] = ArrayQuis[i][0];
                        ArrayEliminados[j][1] = ArrayQuis[i][1];
                        ArrayEliminados[j][2] = ArrayQuis[i][2];
                        ArrayEliminados[j][3] = ArrayQuis[i][3];
                        break;  // se termina de "copiar" y sale del loop
                    }
                }

                // elimina el código de ArrayQuis
                ArrayQuis[i][0] = null;
                ArrayQuis[i][1] = null;
                ArrayQuis[i][2] = null;
                ArrayQuis[i][3] = null;

                return true;  // el coodigo eliminado
            }
        }
        return false; //la placa si existe
    }
}
