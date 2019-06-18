package Algoritmos_5_2;

public class OrdenacaoBolha<T extends Comparable> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        boolean teste = true;
        T[] info = super.getInfo();
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info.length; j++) {
                if (info[j].compareTo(info[i]) > 0) {
                    trocar(i, j);
                }
            }
        }
    }
}
