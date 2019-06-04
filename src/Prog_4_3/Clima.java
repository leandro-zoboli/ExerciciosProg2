package Prog_4_3;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Clima extends Observable {

    private double temperatura;
    private double umidade;
    private int pressao;
    ArrayList<Observer> observadores;

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notifyObservers();
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
        notifyObservers();
    }

    public int getPressao() {
        return pressao;
    }

    public void setPressao(int pressao) {
        this.pressao = pressao;
        notifyObservers();
    }

    public Clima(double temperatura, double umidade, int pressao) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        this.observadores = new ArrayList<Observer>();
        this.addObserver(new Clima1());
        this.addObserver(new Clima2());
        this.addObserver(new Clima3());
        this.addObserver(new Clima4());
    }

    @Override
    public void addObserver(Observer o) {
        this.observadores.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observadores) {
            observer.update(this, this);
        }
    }
}
