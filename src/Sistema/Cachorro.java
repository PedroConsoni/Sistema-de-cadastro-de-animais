package Sistema;

public class Cachorro extends Animal {
    public boolean lateMuito;

    @Override
    public String toString() {
        return "Tipo: Cachorro\n" +
                super.toString() + "\n" +
                "Late muito: " + (lateMuito ? "Sim" : "Não");
    }
}

