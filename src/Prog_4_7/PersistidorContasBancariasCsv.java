package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class PersistidorContasBancariasCsv implements Iterable<String> {

    private File dataFile;

    public PersistidorContasBancariasCsv() throws IOException {
        dataFile = new File("contasbancarias.csv");
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
    }

    /**
     * Grava uma conta bancária
     *
     * @param numero
     * @param titular
     * @param saldo
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void gravar(String numero, String titular, double saldo) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(dataFile, true))) {
            if (dataFile.length() == 0) {
                pw.println("Número;Titular;Saldo");
            }

            pw.println(String.format(Locale.ROOT, "%s;%s;%.2f", numero, titular, saldo));
        }
    }

    /**
     * Procura por um registro
     *
     * @param dadoPesquisar Valor a ser pesquisado
     * @param colunaArquivo Coluna do arquivo a ser pesquisado (0-Número da
     * conta;1-Titular ou 2-Saldo)
     * @return Registro encontrado ou null
     * @throws FileNotFoundException
     */
    public String procurarRegistro(String dadoPesquisar, byte colunaArquivo) throws FileNotFoundException {
        String registro;
        try (Scanner sc = new Scanner(dataFile)) {

            for (String linha : this) {
                if (!linha.trim().equals("")) {
                    String[] dados = linha.split(";");
                    if (dados[colunaArquivo].equals(dadoPesquisar)) {
                        return linha;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public Iterator<String> iterator() {
        try {
            return new CsvIterator();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private class CsvIterator implements Iterator<String> {

        private Scanner sc;

        CsvIterator() throws FileNotFoundException {
            sc = new Scanner(dataFile);
            if (dataFile.length() > 0) {
                next();
            }
        }

        @Override
        public boolean hasNext() {
            return sc.hasNextLine();
        }

        @Override
        public String next() {
            return sc.nextLine();
        }

    }

}
