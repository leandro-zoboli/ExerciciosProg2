package Algoritmos_5_3;

public class OrdenacaoMergeSort<T extends Comparable> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = super.getInfo();
        mergeSort(0, info.length - 1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }

    private void merge(int inicio, int fim, int meio) {
        T[] info = super.getInfo();
        int tamanhoEsquerda = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamanhoEsquerda];
        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = info[inicio + i];
        }

        int tamanhoDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamanhoDireita];
        for (int i = 0; i < tamanhoDireita; i++) {
            direita[i] = info[meio + 1 + i];
        }

        int contEsquerda = 0;
        int contDireita = 0;
        int i = 0;

        for (i = inicio; i <= fim; i++) {
            if (contEsquerda < tamanhoEsquerda && contDireita < tamanhoDireita) {
                if (esquerda[contEsquerda].compareTo(direita[contDireita]) < 0) {
                    info[i] = esquerda[contEsquerda];
                    contEsquerda++;
                } else {
                    info[i] = direita[contDireita];
                    contDireita++;
                }
            } else {
                break;
            }
        }

        while (contEsquerda < tamanhoEsquerda) {
            info[i] = esquerda[contEsquerda];
            i++;
            contEsquerda++;
        }

        while (contDireita < tamanhoDireita) {
            info[i] = direita[contDireita];
            i++;
            contDireita++;
        }
    }
}
