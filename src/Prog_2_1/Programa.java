package Prog_2_1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Programa {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Collection<String> cidadesLitoraneas = new ArrayList<String>();
        Collection<String> cidadesValeItajai = new ArrayList<String>();

        File ArquivoCidadesLitoraneas = new File("C:\\Users\\leandroz\\Downloads\\arquivos\\litoraneas.txt");
        preencherLista(cidadesLitoraneas, ArquivoCidadesLitoraneas);

        File ArquivoCidadesValeItajai = new File("C:\\Users\\leandroz\\Downloads\\arquivos\\valeitajai.txt");
        preencherLista(cidadesValeItajai, ArquivoCidadesValeItajai);

        System.out.println("Cidades litorâneas:");
        for (String cidade : cidadesLitoraneas) {
            System.out.println(cidade);
        }
        System.out.println("Total de cidades litorâneas: " + cidadesLitoraneas.size());

        System.out.println("------------------------");
        System.out.println("Cidades do Vale do Itajai:");
        for (String cidade : cidadesValeItajai) {
            System.out.println(cidade);
        }

        System.out.println("Total de cidades do Vale do Itajaí: " + cidadesValeItajai.size());

        System.out.println("------------------------");
        System.out.println("Cidades que são do Vale do Itajaí e litorâneas");
        for (String cidadeValeItajai : cidadesValeItajai) {
            if (cidadesLitoraneas.contains(cidadeValeItajai)) {
                System.out.println(cidadeValeItajai);
            }
        }
        System.out.println("------------------------");
        System.out.println("Cidades que são do Vale do Itajaí e não litorâneas");
        for (String cidadeValeItajai : cidadesValeItajai) {
            if (!cidadesLitoraneas.contains(cidadeValeItajai)) {
                System.out.println(cidadeValeItajai);
            }
        }

        System.out.println("------------------------");
        System.out.println("Cidades que são litorâneas e não pertencem ao Vale do Itajaí");
        for (String cidadeLitoranea : cidadesLitoraneas) {
            if (!cidadesValeItajai.contains(cidadeLitoranea)) {
                System.out.println(cidadeLitoranea);
            }
        }

        Iterator<String> cidadesValeItajaiIterator = cidadesValeItajai.iterator();
        while (cidadesValeItajaiIterator.hasNext()) {
            String cidadeValeItajai = cidadesValeItajaiIterator.next();
            if (cidadeValeItajai.startsWith("A")) {
                cidadesValeItajaiIterator.remove();
            }
        }

        //System.out.println(cidadesLitoraneas.select(t =  > cidadesValeItajai.where(r =  > r == t)));
    }

    public static void preencherLista(Collection<String> listaCidades, File arquivo) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(arquivo);
        int i = 0;
        i = fis.read();
        String cidade = "";
        while (i != -1) {
            if (i != (int) '\n') {
                cidade += (char) i;
            } else {
                listaCidades.add(cidade);
                cidade = "";
            }
            i = fis.read();
        }
        if (!cidade.equals("")) {
            listaCidades.add(cidade);
        }
    }
}
