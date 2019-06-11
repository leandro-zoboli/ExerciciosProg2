package Prog_Lista_12;

import java.util.ArrayList;

public abstract class Sanduiche {
    
    ArrayList<Ingrediente> ingredientes = new ArrayList();
    
    public Sanduiche() {}
    
    public abstract double getPreco();
    
    public void addIngrediente(String ingrediente){
        ingredientes.add(new Ingrediente(ingrediente));
    }
    
    @Override
    public String toString(){
        String retorno = "Ingredientes: ";
        for (Ingrediente ingrediente : ingredientes) {
            retorno += ingrediente + ", ";
        }
        return retorno.substring(0, retorno.length() - 2);
    }
}
