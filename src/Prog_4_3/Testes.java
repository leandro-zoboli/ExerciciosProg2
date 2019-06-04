package Prog_4_3;

public class Testes {

    public static void main(String[] args) {
        Clima clima = new Clima(16, 50, 1020);
        clima.setTemperatura(50);
        
        clima.notifyObservers();
    }
}
