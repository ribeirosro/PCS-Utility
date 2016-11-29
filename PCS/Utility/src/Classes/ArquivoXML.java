package Classes;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoXML<Type>{
    private ArrayList<Type> lista = new ArrayList<Type>();
    private String nomeArquivo;
    
    public ArquivoXML(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
        
    public ArrayList<Type> getLista() {
        return lista;
    }
        
    public void escreveXML(Type type) {
        lista.add(type);
        try {
            XMLEncoder encoder = null;
            try {
                encoder = new XMLEncoder(new FileOutputStream(nomeArquivo));
                encoder.writeObject(lista);
            } finally {
                if(encoder != null)
                    encoder.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void escreveXML() {
        try {
            XMLEncoder encoder = null;
            try {
                encoder = new XMLEncoder(new FileOutputStream(nomeArquivo));
                encoder.writeObject(lista);
            } finally {
                if(encoder != null)
                    encoder.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
        public void leXML() {
       
        try {
            XMLDecoder decoder = null;
            try {
                decoder = new XMLDecoder(new FileInputStream(nomeArquivo));
                lista = (ArrayList<Type>) decoder.readObject();
            } finally {
                if(decoder != null)
                    decoder.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
