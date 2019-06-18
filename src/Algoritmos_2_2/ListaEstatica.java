package Algoritmos_2_2;

public class ListaEstatica {

    private int[] info;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    private void redimensionar() {
        int[] aux = new int[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            aux[i] = info[i];
        }
        info = aux;
    }

    public void inserir(int valor) {
        if (tamanho == 0) {
            info[tamanho] = valor;
            tamanho++;
        } else {
            if (tamanho == info.length) {
                redimensionar();
            }
            for (int i = 0; i < tamanho; i++) {
                if (valor < info[i]) {
                    int[] aux = new int[info.length];
                    int contAux = 0;
                    for (int j = 0; j < i; j++) {
                        aux[j] = info[j];
                        contAux++;
                    }
                    aux[contAux] = valor;
                    contAux++;
                    for (int j = i; j < tamanho + 1; j++) {
                        aux[contAux] = info[j];
                        contAux++;
                    }
                    info = aux;
                    break;
                } else if (i + 1 == tamanho) {
                    info[tamanho] = valor;
                    break;
                }
            }
            tamanho++;
        }
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                int[] aux = new int[info.length];
                int cont = 0;
                for (int j = 0; j < tamanho; j++) {
                    if (j != i) {
                        aux[cont] = info[j];
                        cont++;
                    }
                }
                info = aux;
                tamanho--;
            }
        }
    }

    public void liberar() {
        info = new int[10];
        tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao <= tamanho) {
            return info[posicao];
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public String toString() {
        String retorno = "";
        for (int i = 0; i < tamanho; i++) {
            retorno += info[i];
            if (i + 1 != tamanho) {
                retorno += ",";
            }
        }
        return retorno;
    }
}
