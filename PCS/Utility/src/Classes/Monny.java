package Classes;


public class Monny {
    private double valor;
    private String usuario;
    
    public Monny(){
        valor = 0;
        usuario = "";
    }
    
    public Monny(double valor, String usuario){
        this.valor = valor;
        this.usuario = usuario;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
}
