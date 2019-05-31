package Lista11_BuscaArvoreBinaria;

public class ArvoreBinariaAbstract<T> {

    NoArvoreBinaria<T> raiz;
    
    public static void main(String[] args) {
        ArvoreBinariaAbstract<Integer> teste = new ArvoreBinariaAbstract();
        System.out.println(teste.estaVazia());
        teste.setRaiz(new NoArvoreBinaria(5));
        System.out.println(teste.estaVazia());
        teste = new ArvoreBinariaAbstract();
        NoArvoreBinaria no = new NoArvoreBinaria(1);
        teste.setRaiz(no);
        no.setEsquerda(new NoArvoreBinaria(2, null, new NoArvoreBinaria(4)));
        no.setDireita(new NoArvoreBinaria(3, new NoArvoreBinaria(5), new NoArvoreBinaria(6)));
        System.out.println(teste.toString());
        System.out.println(teste.pertence(1));
        System.out.println(teste.pertence(3));
        System.out.println(teste.pertence(6));
        System.out.println(teste.pertence(10));
        System.out.println(teste.contarNos());
    }
    
    public ArvoreBinariaAbstract() {
        raiz = new NoArvoreBinaria(null);
    }
    
    public void setRaiz(NoArvoreBinaria<T> raiz){
        this.raiz = raiz;
    }
    
    public boolean estaVazia(){
        return raiz.getInfo() == null;
    }
    
    public boolean pertence(T info){
        return pertence(raiz, info);
    }
    
    private boolean pertence(NoArvoreBinaria<T> no, T info){
        if(no != null){
            if(no.getInfo().equals(info))
                return true;
            if(pertence(no.getEsquerda(), info))
                return true;
            if(pertence(no.getDireita(), info))
                return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return ArvorePre(raiz);
    }
    
    private String ArvorePre(NoArvoreBinaria<T> no){
        String noAtual = "<";
        if(no != null){
            noAtual += no.getInfo();
            noAtual += ArvorePre(no.getEsquerda());
            noAtual += ArvorePre(no.getDireita());
        }
        noAtual += ">";
        return noAtual;
    }
    
    public int contarNos(){
        return contarNos(raiz);
    }
    
    private int contarNos(NoArvoreBinaria<T> no){
        int quantidadeNos = 0;
        if (no != null){
            quantidadeNos += contarNos(no.getEsquerda());
            quantidadeNos += contarNos(no.getDireita());
            quantidadeNos++;
        }
        return quantidadeNos;
    }
}
