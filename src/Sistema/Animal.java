package Sistema;

public abstract class Animal {
    public String nome;
    public int idade;
    public String raca;
    public String tipoSanguineo;
    public String atividadeFavorita;

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "Raça: " + raca + "\n" +
                "Tipo Sanguíneo: " + tipoSanguineo + "\n" +
                "Atividade Favorita: " + atividadeFavorita;
    }
}
