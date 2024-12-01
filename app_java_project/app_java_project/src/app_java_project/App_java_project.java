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
                    // Menú secundario para visualizar
                    int indice2;
                    do {
                        indice2 = Integer.parseInt(JOptionPane.showInputDialog("********* MENU *********\n"
                                + "1) Visualizar Datos\n2) Visualizar Datos Eliminados\n3) Salir"));

                        switch (indice2) {
                            case 1 -> {
                                // Visualizar datos
                                int indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS *********\n"
                                        + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n4) Salir"));
                                switch (indice3) {
                                    case 1 -> {
                                        JOptionPane.showMessageDialog(null, CC.toString());
                                    }
                                    case 2 -> {
                                        String consulta = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                        JOptionPane.showMessageDialog(null, CC.toString(consulta));
                                    }
                                    case 3 -> {
                                        String consultaFil = JOptionPane.showInputDialog(null, "Ingrese el número de la Filial");
                                        String consultaCod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");
                                        JOptionPane.showMessageDialog(null, CC.toString(consultaCod, consultaFil));
                                    }
                                    case 4 -> {
                                        // Volver al menú anterior
                                    }
                                    default ->
                                        JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                                }
                            }
                            case 2 -> {
                                // Visualizar datos eliminados
                                int indice3 = Integer.parseInt(JOptionPane.showInputDialog("********* VISUALIZAR DATOS ELIMINADOS *********\n"
                                        + "1) Todos los datos \n2) Los de una filial \n3) Uno en especifico \n4) Salir"));
                                switch (indice3) {
                                    case 1 -> {
                                        JOptionPane.showMessageDialog(null, CC.toStringEliminado());
                                    }
                                    case 2 -> {
                                        String consulta = JOptionPane.showInputDialog(null, "Ingrese el número de la filial");
                                        JOptionPane.showMessageDialog(null, CC.toStringEliminado(consulta));
                                    }
                                    case 3 -> {
                                        String consultaFil = JOptionPane.showInputDialog(null, "Ingrese el número de la Filial");
                                        String consultaCod = JOptionPane.showInputDialog(null, "Ingrese el número del Codigo");
                                        JOptionPane.showMessageDialog(null, CC.toStringEliminado(consultaCod, consultaFil));
                                    }
                                    case 4 -> {
                                        // Volver al menú anterior
                                    }
                                    default ->
                                        JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                                }
                            }
                            case 3 -> {
                                // Volver al menú principal
                            }
                            default ->
                                JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                        }
                    } while (indice2 != 3);
                }
                case 3 -> {
                    // Eliminar
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
                            // Volver al menú principal
                        }
                        default ->
                            JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
                    }
                }
                case 4 -> {
                    // Cambiar estado
                    String codigoEstado = JOptionPane.showInputDialog("Ingrese el código para cambiar el estado:");

                    boolean cambioExitoso = CC.CambiarEstado(codigoEstado);

                    if (cambioExitoso) {
                        JOptionPane.showMessageDialog(null, "Estado cambiado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el Quisckpass con ese código.");
                    }
                }
                case 5 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese el código a consultar:");
                    String resultado = CC.consultaCod(codigo);
                    JOptionPane.showMessageDialog(null, "Resultado de la consulta: " + resultado);
                }
                case 6 -> {
                    // Menú de bitácora
                    int opcionBitacora;
                    do {
                        opcionBitacora = Integer.parseInt(JOptionPane.showInputDialog("****** BITACORA ******\n"
                                + "1) Registrar Acceso\n2) Consultar\n3) Salir"));

                        switch (opcionBitacora) {
                            case 1 -> {
                                CC.registrar();
                            }
                            case 2 -> {
                                // Submenú de consulta de bitácora
                                int opcionConsulta;
                                do {
                                    opcionConsulta = Integer.parseInt(JOptionPane.showInputDialog("***** CONSULTAR *****\n1) Consultar por Filial\n2) Consultar por Rango de Fechas\n3) Consultar por Placa\n4) Consultar por Codigo\n5) Salir"));
                                    switch (opcionConsulta) {
                                        case 1 -> {
                                            CC.consultarPorFilial();
                                        }
                                        case 2 -> {
                                            CC.consultarPorRangoDeFechas();
                                        }
                                        case 3 -> {
                                            CC.consultarPorPlaca();
                                        }
                                        case 4 -> {
                                            CC.consultarPorCodigo();
                                        }

                                        case 5 -> {
                                            // Volver al menú anterior
                                        }
                                        default -> {
                                            JOptionPane.showMessageDialog(null, "ERROR: Opción no válida");
                                        }
                                    }
                                } while (opcionConsulta != 5);
                            }
                            case 3 -> {
                                // Salir del menú de bitácora
                            }
                            default -> {
                                JOptionPane.showMessageDialog(null, "ERROR: Opción no válida");
                            }
                        }
                    } while (opcionBitacora != 3);
                }
                case 7 -> {
                    // Salir del programa
                    System.exit(0);
                }
                default ->
                    JOptionPane.showMessageDialog(null, "ERROR: Opcion no valida");
            }
        } while (indice != 7);
    }

}
