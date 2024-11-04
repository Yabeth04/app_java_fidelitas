package app_java_project;

import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class DatosQuisckpass {
    private String filial; 
    private String codigo; 
    private String placa; 
    private Estado estado = Estado.Activo; 
    public int codigoError;
    
    public DatosQuisckpass(String pFilial, String pCodigo, String pPlaca){
    this.setFilial(pFilial);
    this.setCodigo(pCodigo);
    this.placa = placa;
    this.getEstado();
    }
    
    
    public String getFilial(){
    return filial;
    }
    
    public void setFilial(String pFilial){
        if (pFilial.length() > 0){
            filial = pFilial;
        }
        else {
        JOptionPane.showMessageDialog(null, "Error del tamaño del Filial");
        }
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String pCodigo){
        if(pCodigo.startsWith("101")){
            if (pCodigo.length() == 10) {
                codigo = pCodigo;
                
            } else {
                JOptionPane.showMessageDialog(null, "Error del tamaño del Codigo");          
            }        
        }else {
        JOptionPane.showMessageDialog(null, "Error el codigo no comienza en 101");
        }
    }
    
    
    public Estado getEstado(){
        return estado;
    }
    
    
}
