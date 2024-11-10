package app_java_project;

import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class App_java_project {

    public static void main(String[] args) {
        // INICIO MAIN
        DatosQuisckpass condomino = new DatosQuisckpass();

        int opcionMenuPrincipal = 0;

        do {
            opcionMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(
                    "------BIENVENIDO------\n---- Menu Principal ----\n"
                    + "1) Agregar\n2) Consultar\n3) Eliminar\n4) Cambiar Estado\n5) Salir"));

            switch (opcionMenuPrincipal) {
                case 1 -> {
                    //AGREGAR
                }
                case 2 -> {
                    //CONSULTAR
                }
                case 3 -> {
                    //ELIMINAR
                }
                case 4 -> {
                    //CAMBIAR ESTADO
                    String codigoEstado = JOptionPane.showInputDialog("Ingrese el código para cambiar el estado:");

                    boolean cambioExitoso = condomino.CambiarEstado(codigoEstado);

                    if (cambioExitoso) {
                        JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Codigo no valido o no existe.");
                    }
                }
                case 5 -> {
                    break;
                }

                default ->
                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");

            }//FIN SWITCH

        } while (opcionMenuPrincipal != 5);

        //FIN MAIN
    }
}
