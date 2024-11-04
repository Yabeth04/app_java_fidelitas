package app_java_project;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class App_java_project {

    public static void main(String[] args) {
        // INICIO MAIN
        ArrayList <DatosQuisckpass> condomino = new ArrayList<>();
//        DatosQuisckpass condomino = new DatosQuisckpass("", "10245678911", "123456789");

        int indice = 0;

        do {

            indice = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                    + "1) Agregar\n2) Consultar\n3) Eliminar\n4) Cambiar Estado\n0) Salir"));

            switch (indice) {
                case 1 -> {

                    String datofil = JOptionPane.showInputDialog(null, "Ingrese el número del Filial");
                    String datocod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigol");
                    String datoplaca = JOptionPane.showInputDialog(null, "Ingrese el número de la placa");
                    condomino.add( new DatosQuisckpass(datofil, datocod, datoplaca));
                    
                    JOptionPane.showMessageDialog(null, condomino.size());
                    JOptionPane.showMessageDialog(null, condomino);
                    JOptionPane.showMessageDialog(null, condomino.get(0));
                   

                }
                case 2 -> {
                    //HACER UN SUBMENU PARA LAS OPCIONES
                    /*-------MENU------
                    1) VISUALIZAR DATOS
                        1) TODOS LOS DATOS
                        2) LOS DE UNA FILIAL
                        3) UNO EN ESPECIFICO
                    2) VISUALIZAR DATOS ELIMINADOS
                        1) TODOS LOS DATOS
                        2) LOS DE UNA FILIAL
                        3) UNO EN ESPECIFICO
                    */
                    //PERMITE CONSULTAR DE 3 FORMAS: TODOS, SOLO UN FILIAL, O UNO ES ESPECIFICO
                    //PERMITE CONSULTAR DE LAS 3 FORMAS PERO EN LA LISTA DE ELIMINADOS
                    //EN LAS DOS FORMAS DEBE BUSCAR PRIMERO QUE SI EXISTA EL OBJETO
                    //CREAR METODOS
                }
                case 3 -> {
                    //HACER UN SUBMENU PARA LAS DOS FORMAS DE ELIMINAR
                    //METODO ELIMINAR CON LA PLACA
                    //METODO ELIMINAR CON EL CODIGO
                    //DEBEN MOVERSE A OTRO ArrayList 
                }
                case 4-> {
                    //VERIFICA QUE SI EXISTA EL QUISCKPASS
                    //PERMITE CAMBIAR EL ESTADO DEL QUISCKPASS
                    
                }
                case 0 ->{
                }
                
                default -> JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");

            }//FIN SWITCH

        } while (indice != 0);

        //FIN MAIN
    }

}
