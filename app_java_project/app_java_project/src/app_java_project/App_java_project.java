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
                    //FALTA HACER UN CONTROL QUE SI LOS DATOS ESTAN MAL
                    //NO LOS AGREGE AL ARREGLO
                    //SE PODRIA HACER EL DATOSQUISCKPASS DENTRO DE LA FUNCION
                    //AGREGARQUIS
                    String datofil = JOptionPane.showInputDialog(null, "Ingrese el número del Filial");

                    String datocod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");

                    String datoplaca = JOptionPane.showInputDialog(null, "Ingrese el número de la placa");

                    condomino.AgregarQuis(new DatosQuisckpass(datofil, datocod, datoplaca));

                    JOptionPane.showMessageDialog(null, condomino.CantQuis());

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
