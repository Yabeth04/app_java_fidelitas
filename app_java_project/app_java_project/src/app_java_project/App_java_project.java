package app_java_project;

import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class App_java_project {

    public static void main(String[] args) {
        // INICIO MAIN
        //ArrayList <DatosQuisckpass> condomino = new ArrayList<>();
        //DatosQuisckpass condomino = new DatosQuisckpass(" ", " ", " ");
        ControlCondominio condomino = new ControlCondominio();

        int indice = 0;

        do {

            indice = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                    + "1) Agregar\n2) Consultar\n3) Eliminar\n4) Cambiar Estado\n0) Salir"));
            switch (indice) {
                case 1 -> {
                    String datofil = JOptionPane.showInputDialog(null, "Ingrese el número del Filial");

                    String datocod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");

                    // Validación del código
                    if (datocod.length() == 10 && datocod.substring(0, 3).equals("101")) {
                        String datoplaca = JOptionPane.showInputDialog(null, "Ingrese el número de la placa");

                        // Solo agrega si el código es válido
                        condomino.AgregarQuis(new DatosQuisckpass(datofil, datocod, datoplaca));

                        JOptionPane.showMessageDialog(null, "Código agregado. Total de quickpasses: " + condomino.CantQuis());
                    } else {
                        JOptionPane.showMessageDialog(null, "Código no válido. Debe comenzar con '101' y tener 10 dígitos.");
                    }
                }
                case 2 -> {

                    int indice2 = 0;
                    int indice3 = 0;
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
                                    DatosQuisckpass a = condomino.MostrarQuis();

                                    JOptionPane.showMessageDialog(null, a);

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

                    DatosQuisckpass a = condomino.MostrarQuis();

                    JOptionPane.showMessageDialog(null, a);

                    //EN LAS DOS FORMAS DEBE BUSCAR PRIMERO QUE SI EXISTA EL OBJETO
                    //CREAR METODOS
                }
                case 3 -> {
                    //ELIMINAR

                    //HACER UN SUBMENU PARA LAS DOS FORMAS DE ELIMINAR
                    //METODO ELIMINAR CON LA PLACA
                    //METODO ELIMINAR CON EL CODIGO
                    //DEBEN MOVERSE A OTRO ArrayList 
                }

                case 4 -> {
                    String codigoEstado = JOptionPane.showInputDialog("Ingrese el código para cambiar el estado:");
                    boolean cambioExitoso = condomino.CambiarEstado(codigoEstado);
                    if (cambioExitoso) {
                        JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el Quisckpass con ese código.");
                    }
                    //CAMBIAR ESTADO
                    //VERIFICA QUE SI EXISTA EL QUISCKPASS
                    //PERMITE CAMBIAR EL ESTADO DEL QUISCKPASS
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
