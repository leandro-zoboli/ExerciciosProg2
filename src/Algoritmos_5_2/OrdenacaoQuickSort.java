package Algoritmos_5_2;

public class OrdenacaoQuickSort<T extends Comparable> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        quickSort(0, super.getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indexPivo = particionar(inicio, fim);
            quickSort(inicio, indexPivo - 1);
            quickSort(indexPivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T[] info = super.getInfo();
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) {
                break;
            }
            trocar(a, b);
        }

        trocar(b, inicio);
        return b;
    }

}
