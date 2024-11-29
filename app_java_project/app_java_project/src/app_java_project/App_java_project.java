package app_java_project;

import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class App_java_project {

    public static void main(String[] args) {
        // INICIO MAIN
        ControlCondominio CC = new ControlCondominio(5);
        App_java_project cc = new App_java_project();

        int indice = 0;

        do {
            indice = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                    + "1) Agregar\n2) Visualizar\n3) Eliminar\n4) Cambiar Estado\n5) Consultar\n6) Registrar Accesos\n7) Salir"));

            switch (indice) {
                case 1 -> {
                    CC.AgregarQuis(new DatosQuisckpass());
                }
                case 2 -> {
                    int indice2 = 0; //MENU SECUNDARIO
                    int indice3 = 0; //SUBMENU SECUNDARIO           

                    indice2 = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                            + "1) Visualizar Datos\n2) Visualizar Datos Eliminados\n3) Salir"));

                    switch (indice2) {
                        case 1 -> {//VISUALIZAR DATOS
                            indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n4) Salir"));

                            switch (indice3) {
                                case 1 -> { //MOSTRAR TODOS LOS DATOS
                                    JOptionPane.showMessageDialog(null, CC.toString());
                                }

                                case 2 -> { //MOSTRAR LOS DATOS DE UNA FILIAL
                                    String consulta = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                    JOptionPane.showMessageDialog(null, CC.toString(consulta));
                                }

                                case 3 -> {//MOSTRAR LOS DATOS DE UNO EN ESPECIFICO  
                                    String consultaFil = JOptionPane.showInputDialog(null, "Ingrese el número de la Filial");
                                    String consultaCod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");
                                    JOptionPane.showMessageDialog(null, CC.toString(consultaCod, consultaFil));
                                }

                                case 4 -> {
                                    /*SALIR*/ }
                                default ->
                                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                            }
                        }
                        case 2 -> {
                            //VISUALIZAR DATOS ELIMINADOS
                            indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS ELIMINADOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n4) Salir"));
                            switch (indice3) {
                                case 1 -> { //MOSTRAR TODOS LOS DATOS
                                    JOptionPane.showMessageDialog(null, CC.toStringEliminado());
                                }

                                case 2 -> { //MOSTRAR LOD DATOS DE UNA FILIAL
                                    String consulta = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                    JOptionPane.showMessageDialog(null, CC.toStringEliminado(consulta));
                                }

                                case 3 -> { //MOSTRAR LOS DATOS DE UNO EN ESPECIFICO
                                    String consultaFil = JOptionPane.showInputDialog(null, "Ingrese el número de la Filial");
                                    String consultaCod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");
                                    JOptionPane.showMessageDialog(null, CC.toStringEliminado(consultaCod, consultaFil));
                                }

                                case 4 -> {
                                    /*SALIR*/ }
                                default ->
                                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                            }
                        }
                        case 3 -> {
                            /*SALIR*/ }
                        default ->
                            JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                    }
                }
                case 3 -> {
                    //ELIMINAR
                    int menuEliminar = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                            + "1) ELIMINAR CON LA PLACA\n2) ELIMINAR CON EL CODIGO\n3) Salir"));

                    switch (menuEliminar) {
                        case 1 -> {
                            String placa = JOptionPane.showInputDialog("Ingrese la placa: ");
                            CC.EliminarQuis(placa);
                        }

                        case 2 -> {
                            String codigo = JOptionPane.showInputDialog("Ingrese el codigo: ");
                            CC.EliminarQuis(codigo);
                        }

                        case 3 -> {
                            /*SALIR*/ }
                        default ->
                            JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                    }
                }
                case 4 -> {
                    //CAMBIAR ESTADO
                    String codigoEstado = JOptionPane.showInputDialog("Ingrese el código para cambiar el estado:");

                    boolean cambioExitoso = CC.CambiarEstado(codigoEstado);

                    if (cambioExitoso) {
                        JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el Quisckpass con ese código.");
                    }
                }
                case 5 -> {
                    // Lógica para consultar por código
                    String codigo = JOptionPane.showInputDialog("Ingrese el código a consultar:");
                    String resultado = CC.consultaCod(codigo);
                    JOptionPane.showMessageDialog(null, "Resultado de la consulta: " + resultado);
                    break;
                }
                case 6 -> {
                    int opcionBitacora = 0;
                    opcionBitacora = Integer.parseInt(JOptionPane.showInputDialog("****** BITACORA ******\n"
                            + "1) Registrar Quickpass\n2) Consultar por Filial\n"));
                    
                    switch(opcionBitacora) {
                        case 1 ->{
                            CC.registrar(); 
                        }
                        case 2 -> {
                            CC.consultaFilial(); 
                        }
                    }
                    break;
                }
                case 7 -> {
                    /*SALIR*/
                }
                default ->
                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
            }//FIN SWITCH
        } while (indice != 7);
        //FIN MAIN
    }

}
