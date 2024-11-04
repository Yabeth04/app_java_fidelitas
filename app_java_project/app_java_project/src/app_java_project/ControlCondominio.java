package app_java_project;

import java.util.ArrayList;

/**
 *
 * @author samue
 */
public class ControlCondominio {
    
    private ArrayList <DatosQuisckpass> ArrayQuis;
    private ArrayList <DatosQuisckpass> ArrayQuisEliminados;
    
    public ControlCondominio(){
    this.ArrayQuis = new ArrayList<>();
    }
    
    public void AgregarQuis(DatosQuisckpass a){
        this.ArrayQuis.add(a);
        
    }
    
    public int CantQuis(){
    return this.ArrayQuis.size();
    }
    
    public DatosQuisckpass MostrarQuis(){
    DatosQuisckpass b = null;
        for (DatosQuisckpass dato : ArrayQuis) {
            b = dato;
        }
    return b;
    }
    
}
