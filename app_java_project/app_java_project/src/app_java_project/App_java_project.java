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

        int indice = 0;

        do {

            indice = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                    + "1) Agregar\n2) Consultar\n3) Eliminar\n4) Cambiar Estado\n0) Salir"));

            switch (indice) {
                case 1 -> {
                    //FALTA ARREGLAR EL SETPLACA 
                    //HAY QUE PONERLE RESTRICCIONES
                    condomino.setFilial();
                    
                    condomino.setCodigo();

                    condomino.setPlaca();

                    condomino.AgregarQuis();

                }
                case 2 -> {

                    int indice2 = 0; //MENU SECUNDARIO
                    int indice3 = 0; //SUBMENU SECUNDARIO
                    
                    indice2 = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                            + "1) Visualizar Datos\n2) Visualizar Datos Eliminados\n0) Salir"));

                    switch (indice2) {
                        case 1 -> {
                            //VISUALIZAR DATOS
                            indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n0) Salir"));

                            switch (indice3) {
                                case 1 -> {
                                    //MOSTRAR TODOS LOS DATOS
                                    JOptionPane.showMessageDialog(null, condomino.MostrarQuis() );

                                }
                                case 2 -> {
                                    //MOSTRAR LOS DATOS DE UNA FILIAL
                                    String consulta = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                    
                                     JOptionPane.showMessageDialog(null, condomino.MostrarFilial(consulta) );

                                }
                                case 3 -> {
                                    //MOSTRAR LOS DATOS DE UNO EN ESPECIFICO

                                }
                                case 0 -> {

                                }
                                default ->
                                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                            }

                        }
                        case 2 -> {
                            //VISUALIZAR DATOS ELIMINADOS
                            indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS ELIMINADOS *********\n"
                                    + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n0) Salir"));

                            switch (indice3) {
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
                case 0 -> {
                }

                default ->
                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");

            }//FIN SWITCH

        } while (indice != 0);

        //FIN MAIN
    }
}
