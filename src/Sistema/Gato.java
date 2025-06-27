package Sistema;

public class Gato extends Animal {
    public boolean miaMuito;

    @Override
    public String toString() {
        return "Tipo: Gato\n" +
                super.toString() + "\n" +
                "Mia muito: " + (miaMuito ? "Sim" : "Não");
    }
}

