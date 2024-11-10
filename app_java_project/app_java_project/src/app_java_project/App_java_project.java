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
                    //FALTA ARREGLAR EL SETPLACA 
                    //HAY QUE PONERLE RESTRICCIONES
                    condomino.setFilial();

                    condomino.setCodigo();

                    condomino.setPlaca();

                    condomino.AgregarQuis();

                }
                case 2 -> {
                    int opcionMenuConsultar = 0;
                    int opcionSubMenuConsultar = 0;

                    opcionMenuConsultar = Integer.parseInt(JOptionPane.showInputDialog(
                            "********* MENU CONSULTAR *********\n"
                            + "1) Visualizar Datos\n2) Visualizar Datos Eliminados\n0) Salir"));

                    switch (opcionMenuConsultar) {
                        case 1 -> {
                            opcionSubMenuConsultar = Integer.parseInt(JOptionPane.showInputDialog(
                                    "********* VISUALIZAR DATOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n0) Salir"));
                            String consultaNumeroFilial = "";
                            switch (opcionSubMenuConsultar) {
                                case 1 -> {
                                    //MOSTRAR TODOS LOS DATOS
                                    JOptionPane.showMessageDialog(null, condomino.MostrarQuis());
                                }
                                case 2 -> {
                                    //MOSTRAR LOS DATOS DE UNA FILIAL
                                    consultaNumeroFilial = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                    JOptionPane.showMessageDialog(null, condomino.MostrarFilial(consultaNumeroFilial));

                                }
                                case 3 -> {
                                    //MOSTRAR LOS DATOS DE UNO EN ESPECIFICO
                                    consultaNumeroFilial = JOptionPane.showInputDialog(
                                            null, "Ingrese el número de la filial o el código");
                                    String resultadoBusqueda = condomino.MostrarUnoEspecifico(consultaNumeroFilial);
                                    JOptionPane.showMessageDialog(null, resultadoBusqueda);
                                }
                                case 0 -> {
                                    //SALIR
                                }
                                default ->
                                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                            }

                        }
                        case 2 -> {
                            //VISUALIZAR DATOS ELIMINADOS
                            opcionSubMenuConsultar = Integer.parseInt(JOptionPane.showInputDialog(
                                    "********* VISUALIZAR DATOS ELIMINADOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n0) Salir"));

                            switch (opcionSubMenuConsultar) {
                                case 1 -> {
                                    //MOSTRAR TODOS LOS DATOS

                                }
                                case 2 -> {
                                    //MOSTRAR LOD DATOS DE UNA FILIAL

                                }
                                case 3 -> {
                                    //MOSTRAR LOS DATOS DE UNO EN ESPECIFICO

                                }
                                case 0 -> {
                                    break;
                                }
                                default ->
                                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                            }
                        }
                        case 0 -> {

                        }
                        default ->
                            JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                    }

                    //EN LAS DOS FORMAS DEBE BUSCAR PRIMERO QUE SI EXISTA EL OBJETO
                    //CREAR METODOS
                }
                case 3 -> {
                    //ELIMINAR

                    int opcionMenuEliminar = Integer.parseInt(JOptionPane.showInputDialog(
                            "****** MENU ELIMINAR ******\n1) Eliminar Placa\n2)Eliminar Codigo\n3) Salir"));
                    switch (opcionMenuEliminar) {
                        case 1 -> {
                            // Eliminar placa
                            String placaEliminar = JOptionPane.showInputDialog(null, "Ingrese la placa a eliminar");
                            boolean eliminado = condomino.EliminarPorPlaca(placaEliminar);
                            if (eliminado) {
                                JOptionPane.showMessageDialog(null, "Placa eliminada con éxito.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Placa no encontrada.");
                            }
                        }
                        case 2 -> {
                            // Eliminar placa
                            String placaEliminar = JOptionPane.showInputDialog(null, "Ingrese el codigo a eliminar");
                            boolean eliminado = condomino.EliminarPorCodigo(placaEliminar);
                            if (eliminado) {
                                JOptionPane.showMessageDialog(null, "Codigo eliminada con éxito.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Codigo no encontrado.");
                            }
                        }
                        case 3 -> {
                            //SALIR
                        }
                        default ->
                            JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                    }
                    //HACER UN SUBMENU PARA LAS DOS FORMAS DE ELIMINAR
                    //METODO ELIMINAR CON LA PLACA
                    //METODO ELIMINAR CON EL CODIGO
                    //DEBEN MOVERSE A OTRO ARRAY
                }
                case 4 -> {
                    //CAMBIAR ESTADO
                    String codigoEstado = JOptionPane.showInputDialog("Ingrese el código para cambiar el estado:");

                    boolean cambioExitoso = condomino.CambiarEstado(codigoEstado);

                    if (cambioExitoso) {
                        JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el Quisckpass con ese código.");
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
