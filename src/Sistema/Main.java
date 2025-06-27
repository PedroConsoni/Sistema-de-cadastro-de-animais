package Sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criação de um array de animais de tamanho fixo
        int numeroMax = 10;
        Animal[] animais = new Animal[numeroMax];

        // Contadores
        int opcao = 0;
        int animaisCadastrados = 0;

        // Loop principal do menu com todas as suas opções
        while (opcao != 6) {
            System.out.println("============================================================================= MENU =============================================================================");
            System.out.println("1. Cadastrar animais");
            System.out.println("2. Listar animais cadastrados");
            System.out.println("3. Listar informações do animal");
            System.out.println("4. Atualizar informações do animal");
            System.out.println("5. Deletar animais");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção do usuário
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                //Cadastro de animais
                case 1:
                    System.out.print("Escolha a opção A ( Gato ) ou a opção B ( Cachorro ): ");
                    String escolhaDeAnimal = scanner.nextLine();

                    // Verifica se ainda há espaço no array e se o usuário escolheu a opção "A"
                    if (animaisCadastrados < numeroMax && escolhaDeAnimal.equalsIgnoreCase("A")) {
                        Gato novoGato = new Gato();
                        System.out.print("Digite o nome do seu gato: ");
                        novoGato.nome = scanner.nextLine();
                        System.out.print("Digite a idade do seu gato: ");
                        novoGato.idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite a raça do seu gato: ");
                        novoGato.raca = scanner.nextLine();
                        System.out.print("Digite o tipo sanguíneo do seu gato ( A / B / AB ): ");
                        novoGato.tipoSanguineo = scanner.nextLine();
                        System.out.print("Digite a atividade favorita do seu gato: ");
                        novoGato.atividadeFavorita = scanner.nextLine();
                        System.out.print("O gato mia muito? ( Sim / Não ) ");
                        String miaResposta = scanner.nextLine();
                        novoGato.miaMuito = miaResposta.equalsIgnoreCase("Sim");

                        animais[animaisCadastrados] = novoGato;
                        animaisCadastrados++;

                        // Verifica se ainda há espaço no array e se o usuário escolheu a opção "B"
                    } else if (animaisCadastrados < numeroMax && escolhaDeAnimal.equalsIgnoreCase("B")) {
                        Cachorro novoCachorro = new Cachorro();
                        System.out.print("Digite o nome do seu cachorro: ");
                        novoCachorro.nome = scanner.nextLine();
                        System.out.print("Digite a idade do seu cachorro: ");
                        novoCachorro.idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite a raça do seu cachorro: ");
                        novoCachorro.raca = scanner.nextLine();
                        System.out.print("Digite o tipo sanguíneo do seu cachorro ( DEA 1.1 / DEA 1.2 / DEA 3 / DEA 4 / DEA 5 / DEA 6 / DEA 7 / DEA 8 ): ");
                        novoCachorro.tipoSanguineo = scanner.nextLine();
                        System.out.print("Digite a atividade favorita do seu cachorro: ");
                        novoCachorro.atividadeFavorita = scanner.nextLine();
                        System.out.print("O cachorro late muito? ( Sim / Não ) ");
                        String lateResposta = scanner.nextLine();
                        novoCachorro.lateMuito = lateResposta.equalsIgnoreCase("Sim");

                        animais[animaisCadastrados] = novoCachorro;
                        animaisCadastrados++;
                        break;
                    } else {
                        System.out.println("Você inseriu uma opção inválida");
                    }
                    break;

                case 2:

                    // Pergunta ao usuário se ele deseja visualizar a lista da opção "A" ( Gato ) ou da opção "B" ( Cachorro )
                    if (animaisCadastrados != 0) {
                        System.out.print("Deseja listar a opção A (Gato) ou opção B (Cachorro)? ");
                        String tipoLista = scanner.nextLine();

                        boolean encontrou = false;
                        System.out.println("================================================================== Lista de animais cadastrados =================================================================");
                        for (int i = 0; i < animaisCadastrados; i++) {
                            if (tipoLista.equalsIgnoreCase("A") && animais[i] instanceof Gato) {
                                System.out.println(animais[i].nome);
                                encontrou = true;
                            } else if (tipoLista.equalsIgnoreCase("B") && animais[i] instanceof Cachorro) {
                                System.out.println(animais[i].nome);
                                encontrou = true;
                            }
                        }

                        if (!encontrou) {
                            System.out.println("Nenhum animal do tipo selecionado foi encontrado.");
                        }

                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    break;


                case 3:

                    // Pergunta ao usuário qual animal ele deseja visualizar as informações e depois exibe elas
                    if (animaisCadastrados != 0) {
                        System.out.print("Você deseja visualizar as informações da opção A (Gato) ou opção B (Cachorro)? ");
                        String escolhaVisualizar = scanner.nextLine();

                        boolean encontrou = false;

                        for (int i = 0; i < animaisCadastrados; i++) {
                            if (escolhaVisualizar.equalsIgnoreCase("A") && animais[i] instanceof Gato) {
                                System.out.println((i + 1) + ". " + animais[i].nome);
                                encontrou = true;
                            } else if (escolhaVisualizar.equalsIgnoreCase("B") && animais[i] instanceof Cachorro) {
                                System.out.println((i + 1) + ". " + animais[i].nome);
                                encontrou = true;
                            }
                        }

                        if (!encontrou) {
                            System.out.println("Não há animais do tipo escolhido.");
                            break;
                        }

                        // Pede ao usuário para digitar o número do animal que ele deseja visualizar as informações
                        System.out.print("Digite o número do animal para visualizar as informações: ");
                        int indiceEscolhido = scanner.nextInt();
                        scanner.nextLine();

                        // Verifica se o número escolhido é válido
                        if (indiceEscolhido >= 1 && indiceEscolhido <= animaisCadastrados) {
                            Animal animalSelecionado = animais[indiceEscolhido - 1];

                            if ((escolhaVisualizar.equalsIgnoreCase("A") && animalSelecionado instanceof Gato) ||
                                    (escolhaVisualizar.equalsIgnoreCase("B") && animalSelecionado instanceof Cachorro)) {

                                System.out.println("================================================================================================================================================================");
                                System.out.println(animalSelecionado);
                                System.out.println("================================================================================================================================================================");

                            } else {
                                System.out.println("O número selecionado não corresponde ao tipo de animal escolhido.");
                            }

                        } else {
                            System.out.println("Número inválido.");
                        }

                    } else {
                        System.out.println("Nenhum animal cadastrado.");
                    }
                    break;


                case 4:

                    // Pergunta ao usuário qual animal ele deseja atualizar as informações
                    if (animaisCadastrados != 0) {
                        System.out.print("Você deseja atualizar a opção A ( Gato ) ou a opção B ( Cachorro )? ");
                        String tipoAnimal = scanner.nextLine();

                        if (tipoAnimal.equalsIgnoreCase("A") || tipoAnimal.equalsIgnoreCase("B")) {
                            System.out.println("================================================================================================================================================================");
                            for (int i = 0; i < animaisCadastrados; i++) {
                                if (tipoAnimal.equalsIgnoreCase("A") && animais[i] instanceof Gato) {
                                    System.out.println((i + 1) + ". " + animais[i].nome);

                                } else if (tipoAnimal.equalsIgnoreCase("B")  && animais[i] instanceof Cachorro) {
                                    System.out.println((i + 1) + ". " + animais[i].nome);

                                }
                            }

                            // Pede ao usuário para digitar o número do animal que ele deseja atualizar as informações
                            System.out.print("Digite o número do animal que deseja atualizar: ");
                            int indiceAtualizar = scanner.nextInt();
                            scanner.nextLine();

                            // Verifica se o número escolhido é válido
                            if (indiceAtualizar >= 1 && indiceAtualizar <= animaisCadastrados) {
                                Animal animalSelecionado = animais[indiceAtualizar - 1];

                                if (tipoAnimal.equalsIgnoreCase("A") && animalSelecionado instanceof Gato) {
                                    Gato novoGato = (Gato) animalSelecionado;

                                    System.out.println("Atualizando os dados do gato: " + novoGato.nome);

                                    System.out.print("Insira o nome atualizado do gato: ");
                                    novoGato.nome = scanner.nextLine();

                                    System.out.print("Insira a idade atualizada do gato: ");
                                    novoGato.idade = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Insira a raça atualizada do gato: ");
                                    novoGato.raca = scanner.nextLine();

                                    System.out.print("Insira o tipo sanguíneo atualizado do gato: ");
                                    novoGato.tipoSanguineo = scanner.nextLine();

                                    System.out.print("Insira a atividade favorita atualizada do gato: ");
                                    novoGato.atividadeFavorita = scanner.nextLine();

                                    System.out.print("Insira se o gato mia muito ( Sim / Não ): ");
                                    String respostaMia = scanner.nextLine();
                                    novoGato.miaMuito = respostaMia.equalsIgnoreCase("Sim");

                                    System.out.println("Informações do gato atualizada com sucesso");

                                } else if (tipoAnimal.equalsIgnoreCase("B") && animalSelecionado instanceof Cachorro) {
                                    Cachorro novoCachorro = (Cachorro) animalSelecionado;

                                    System.out.println("Atualizando os dados do cachorro: " + novoCachorro.nome);

                                    System.out.print("Insira o nome atualizado do cachorro: ");
                                    novoCachorro.nome = scanner.nextLine();

                                    System.out.print("Insira a idade atualizada do cachorro: ");
                                    novoCachorro.idade = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Insira a raça atualizada do cachorro: ");
                                    novoCachorro.raca = scanner.nextLine();

                                    System.out.print("Insira o tipo sanguíneo atualizado do cachorro: ");
                                    novoCachorro.tipoSanguineo = scanner.nextLine();

                                    System.out.print("Insira a atividade favorita atualizada do cachorro: ");
                                    novoCachorro.atividadeFavorita = scanner.nextLine();

                                    System.out.print("Insira se o cachorro late muito ( Sim / Não ): ");
                                    String respostaLate = scanner.nextLine();
                                    novoCachorro.lateMuito = respostaLate.equalsIgnoreCase("Sim");

                                    System.out.println("Informações do cachorro atualizada com sucesso");

                                } else {
                                    System.out.println("O número selecionado não corresponde há nenhum tipo de animal");
                                }
                            } else {
                                System.out.println("Número inválido");
                            }
                        } else {
                            System.out.println("Opção inválida");
                        }
                    } else {
                        System.out.println("Não há animais cadastrados");
                    }
                    break;

                case 5:

                    // Pergunta ao usuário qual tipo de animal ele deseja deletar
                    if (animaisCadastrados != 0) {
                        System.out.print("Você deseja deletar a opção A (Gato) ou opção B (Cachorro)? ");
                        String tipoExcluir = scanner.nextLine();

                        boolean encontrou = false;
                        System.out.println("=================================================================== Lista de animais ===================================================================");
                        for (int i = 0; i < animaisCadastrados; i++) {
                            if (tipoExcluir.equalsIgnoreCase("A") && animais[i] instanceof Gato) {
                                System.out.println((i + 1) + ". " + animais[i].nome);
                                encontrou = true;
                            } else if (tipoExcluir.equalsIgnoreCase("B") && animais[i] instanceof Cachorro) {
                                System.out.println((i + 1) + ". " + animais[i].nome);
                                encontrou = true;
                            }
                        }

                        if (!encontrou) {
                            System.out.println("Não há animais do tipo selecionado para excluir.");
                            break;
                        }

                        // Pede ao usuário para digitar o número do animal que ele deseja deletar
                        System.out.print("Digite o número do animal que deseja excluir: ");
                        int indiceExcluir = scanner.nextInt();
                        scanner.nextLine();

                        // Verifica se o número escolhido é válido
                        if (indiceExcluir >= 1 && indiceExcluir <= animaisCadastrados) {
                            Animal animalSelecionado = animais[indiceExcluir - 1];

                            boolean tipoConfere = (tipoExcluir.equalsIgnoreCase("A") && animalSelecionado instanceof Gato)
                                    || (tipoExcluir.equalsIgnoreCase("B") && animalSelecionado instanceof Cachorro);

                            if (tipoConfere) {
                                for (int i = indiceExcluir - 1; i < animaisCadastrados - 1; i++) {
                                    animais[i] = animais[i + 1];
                                }

                                animais[animaisCadastrados - 1] = null;
                                animaisCadastrados--;

                                System.out.println("Animal excluído com sucesso.");
                            } else {
                                System.out.println("O número selecionado não corresponde ao tipo de animal escolhido.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    } else {
                        System.out.println("Não há animais para excluir.");
                    }
                    break;


                case 6:

                    // Finaliza o programa
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("Essa opção é inválida");
                    break;
            }
        }

        scanner.close();
    }
}

