package Algoritmos_5_3;

public class Teste13 {

    public static void main(String[] args) {
        OrdenacaoMergeSort<Integer> ord = new OrdenacaoMergeSort();
        ord.setInfo(new Integer[]{70, 2, 88, 15, 90, 30});
        System.out.println("Vetor original: " + ord.toString());
        ord.ordenar();
        System.out.println("Vetor ordenado: " + ord.toString());
    }
}
