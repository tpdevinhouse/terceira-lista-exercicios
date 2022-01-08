package devinflix.aplicativo;

import devinflix.filmes.Filme;
import devinflix.recomendacoes.Recomendacao;
import devinflix.usuarios.Usuario;

import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Aplicativo {

    public static void main(String[] args) {

        // Variável para iniciar a lógica
        boolean iniciar = false;

        // Variável para iniciar se o usuário já pagou a fatura
        boolean pago = false;

        // Variável incremental
        int i = 0;
        int generoAventura = 0;
        int generoAcao = 0;
        int generoCientifico = 0;

        // Variável likeFilme1
        int likeFilme1 = 0;

        // Variáveis para implementar a lógica de dar sugestão de filme apenas 1 vez por mês
        boolean avaliou = false;
        LocalDate date =  LocalDate.now();
        int diaAtual = date.getDayOfMonth();
        int ultDiaMes = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);


        // Entrada do console
        Scanner entrada = new Scanner((System.in));

        // Cria a base do Array de usuários
        ArrayList<Usuario> usuario = new ArrayList<>();

        // Cria a base do Array de filmes
        ArrayList<Filme> listaFilmes = new ArrayList<>();

        // Cria a base do Array de recomendações
        ArrayList<Recomendacao> recomendacao = new ArrayList<>();

        // Base de filmes - Start
        Filme vingadores = new Filme(
                "Vingadores Ultimato",
                """
                        Após Thanos eliminar metade das criaturas vivas de todo o universo, os heróis sobreviventes
                        precisam lidar com a dor da perda de amigos e seus entes queridos. Com Tony Stark vagando
                        perdido no espaço sem água nem comida, Steve Rogers e Natasha Romanov precisam liderar a
                        resistência contra o titã.""",
                "Aventura",
                "https://www.devinflix.com.br/filmes/adventure/vingadores-ultimato/watch"
        );

        Filme  interestelar = new Filme(
                "Interestelar",
                """
                        As reservas naturais da Terra estão chegando ao fim e um grupo de astronautas recebe a missão
                        de verificar possíveis planetas para receberem a população mundial, possibilitando a
                        continuação da espécie. Cooper é chamado para liderar o grupo e aceita a missão sabendo que
                        pode nunca mais ver os filhos. Ao lado de Brand, Jenkins e Doyle, ele seguirá em
                        busca de um novo lar..""",
                "Ficção Científica",
                "https://www.devinflix.com.br/filmes/sci-fi/interestelar/watch"
        );

        Filme velozes = new Filme(
                "Velozes e Furiosos 9",
                """
                        Dominic Toretto e Letty vivem uma vida pacata ao lado do filho. Mas eles logo são ameaçados
                        pelo passado de Dom: seu irmão desaparecido Jakob, que retorna e está trabalhando ao
                        lado de Cipher. Cabe a Dom reunir a equipe novamente para enfrentá-los.""",
                "Ação",
                "https://www.devinflix.com.br/filmes/action/velozes-furiosos-9/watch"
        );

        Filme venom = new Filme(
                "Venom",
                """
                        O jornalista Eddie Brock desenvolve força e poder sobre-humanos quando seu corpo se funde com
                        o alienígena Venom. Dominado pela raiva, Venom tenta controlar as novas e perigosas
                        habilidades de Eddie.
                        """,
                "Ação",
                "https://www.devinflix.com.br/filmes/action/venom/watch"
        );

        Filme jumanji = new Filme(
                "Jumanji",
                """
                        Alan Parrish desapareceu quando era menino e ninguém acredita na história de seu amigo de
                        que ele foi sugado por um jogo de tabuleiro. Vinte e seis anos depois, duas crianças acham o
                        jogo no sótão e, quando começam a jogar, Alan é libertado. Mas a disputa ainda não acabou e
                        Alan precisa terminar antes de ser realmente solto.
                        """,
                "Aventura",
                "https://www.devinflix.com.br/filmes/adventure/jumanji/watch"
        );

        Filme shazam = new Filme(
                "Shazam",
                """
                        Billy Batson tem apenas 14 anos de idade, mas recebeu de um antigo mago o dom de se transformar
                        em um super-herói adulto chamado Shazam. Ao gritar a palavra SHAZAM!, o adolescente se
                        transforma nessa sua poderosa versão adulta para se divertir e testar suas habilidades.
                        Contudo, ele precisa aprender a controlar seus poderes para enfrentar o malvado
                        Dr. Thaddeus Sivana.
                        """,
                "Aventura",
                "https://www.devinflix.com.br/filmes/adventure/shazam/watch"
        );

        // Adiciona os filmes no Array - Start
        listaFilmes.add(vingadores);
        listaFilmes.add(interestelar);
        listaFilmes.add(velozes);
        listaFilmes.add(venom);
        listaFilmes.add(jumanji);
        listaFilmes.add(shazam);
        // Adiciona os filmes no Array - End
        // Base de filmes - End


        // Interação com o usuário
        System.out.println("\nSeja bem vindo(a) a DevInFlix ;)");
        System.out.println("\nPara acessar a plataforma, por gentileza realizar o seu cadastro a seguir:");

        // Cadastro de usuário - Start
        System.out.print("\nDigite seu nome completo: ");
        String nomeCompleto = entrada.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = entrada.nextLine();

        System.out.print("Digite um nome de usuário: ");
        String nomeUsuario = entrada.nextLine();

        System.out.print("Digite sua data de nascimento: ");
        String dataNasc = entrada.nextLine();

        System.out.print("Digite seu endereço: ");
        String endereco = entrada.nextLine();
        // Cadastro de usuário - End

        // Adiciona os valores para o Array de novo usuário
        usuario.add(new Usuario(nomeCompleto, cpf,
                nomeUsuario, dataNasc, endereco));

        // Inicia o lógica do programa
        iniciar = true;

        // Lógica do Aplicativo
        //System.out.println(usuario.get(0).nick);
        boolean escolha = true;

        while (iniciar) {

            System.out.println("\n\nOlá " + usuario.get(0).getNick() + ", de uma olhada na nossa menu abaixo ;)");

            menu:
            if(escolha) {
                // Lista todos os filmes da base
                System.out.println(
                        "1 - " + listaFilmes.get(0).getNome() +
                                ", 2 - " + listaFilmes.get(1).getNome() +
                                ", 3 - " + listaFilmes.get(2).getNome() +
                                ", 4 - " + listaFilmes.get(3).getNome() +
                                ", 5 - " + listaFilmes.get(4).getNome() +
                                ", 6 - " + listaFilmes.get(5).getNome() +
                                "\n7 - Sugestões de Filmes, " +
                                "8 - Área Administrativa"
                );

//                for(Filme movies: listaFilmes) {
//                    i++;
//                    System.out.print(i + " - " + movies.nome + " / ");
//                }

                System.out.println();
                System.out.print("\nDigite o número do menu para prosseguir: ");
                int escolhaFilme = entrada.nextInt();

                // Decidir qual filme o usuário irar ver
                filme1:
                if (escolhaFilme == 1 && pago) {
                        System.out.println("Você escolheu o filme " +
                                listaFilmes.get(0).getNome() + ", o que você deseja fazer?");

                        // Mostrar opções
                        System.out.print("\n1 - Assistir, 2 - Descrição, 3 - Avaliar, 4 - Recomendar, " +
                                "5 - Voltar Menu Principal: ");
                        int navegacao = entrada.nextInt();

                        voltar1:
                        if (navegacao == 1) {
                            System.out.println("Conectando..." + listaFilmes.get(0).getLink());
                            System.out.println("Conexão concluída");
                            System.out.println("Assistindo o filme");

                            // Incrementa a visualização do filme
                            generoAventura++;

                            System.out.println("\nVocê terminou de assistir o filme " + listaFilmes.get(0).getNome() +
                                    ", o que você deseja fazer agora?");

                            System.out.print("\n1 - Menu Principal, 2 - Avaliar, 3 - Sair: ");

                            int descicaoFilme1 = entrada.nextInt();

                            if (descicaoFilme1 == 1) {
                                break filme1;

                                // Avaliar o filme
                            } else if (descicaoFilme1 == 2) {
                                System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                        + listaFilmes.get(0).getNome());
                                System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                                System.out.print("Escolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                                int avaliacao1 = entrada.nextInt();

                                if (avaliacao1 == 1) {
                                    likeFilme1++;
                                } else if (avaliacao1 == 2) {
                                    likeFilme1--;
                                }
                                break filme1;

                            } else if (descicaoFilme1 == 3) {
                                System.out.println("\nObrigado por usar a DevInFlix, esperamos o seu retorno =)");
                                break;
                            }

                        } else if (navegacao == 2) {
                            System.out.println("\nSinopse do Filme: " + listaFilmes.get(0).getSinopse());
                            System.out.print("\nDigite o número 1, para voltar ao menu principal: ");
                            int navegacao2 = entrada.nextInt();

                            if (navegacao2 == 1) {
                                break voltar1;
                            }

                            // Avaliar o filme - acrescentar apenas uma avaliacao por mes
                        } else if (navegacao == 3) {

                            System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                    + listaFilmes.get(0).getNome());
                            System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                            System.out.print("\nEscolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                            int avaliacao1 = entrada.nextInt();

                            if (avaliacao1 == 1) {
                                likeFilme1++;
                            } else if (avaliacao1 == 2) {
                                likeFilme1--;
                            }
                            break filme1;

                            // Recomendação - aprimorar
                        } else if (navegacao == 4) {
                            Scanner entrada1 = new Scanner((System.in));

                            System.out.print("\nDigite o nome de usuário que receberá a recomendação: ");
                            String recoUser = entrada1.nextLine();

                            System.out.print("\nDigite o porque você deseja recomendar esse filme: ");
                            String recoTexto = entrada1.nextLine();

                            recomendacao.add(new Recomendacao(recoUser, recoTexto));

                            for (Recomendacao verReco: recomendacao) {
                                System.out.print("\nRecomendação enviada para o usuário: " + verReco.getNomeUsuario());
                                System.out.print("\nComentário enviando: " + verReco.getComentario());
                            }

                        } else if (navegacao == 5) {
                            break voltar1;
                        }
                }

                filme2:
                if (escolhaFilme == 2 && pago) {
                    System.out.println("Você escolheu o filme " +
                            listaFilmes.get(1).getNome() + ", o que você deseja fazer?");

                    // Mostrar opções
                    System.out.print("\n1 - Assistir, 2 - Descrição, 3 - Avaliar, 4 - Recomendar, " +
                            "5 - Voltar Menu Principal: ");
                    int navegacao = entrada.nextInt();

                    voltar2:
                    if (navegacao == 1) {
                        System.out.println("Conectando..." + listaFilmes.get(1).getLink());
                        System.out.println("Conexão concluída");
                        System.out.println("Assistindo o filme");

                        // Incrementa a visualização do filme
                        generoCientifico++;

                        System.out.println("\nVocê terminou de assistir o filme " + listaFilmes.get(1).getNome() +
                                ", o que você deseja fazer agora?");

                        System.out.print("\n1 - Menu Principal, 2 - Avaliar, 3 - Sair: ");

                        int descicaoFilme1 = entrada.nextInt();

                        if (descicaoFilme1 == 1) {
                            break filme2;

                            // Avaliar o filme
                        } else if (descicaoFilme1 == 2) {
                            System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                    + listaFilmes.get(1).getNome());
                            System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                            System.out.print("Escolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                            int avaliacao1 = entrada.nextInt();

                            if (avaliacao1 == 1) {
                                likeFilme1++;
                            } else if (avaliacao1 == 2) {
                                likeFilme1--;
                            }
                            break filme2;

                        } else if (descicaoFilme1 == 3) {
                            System.out.println("\nObrigado por usar a DevInFlix, esperamos o seu retorno =)");
                            break;
                        }

                    } else if (navegacao == 2) {
                        System.out.println("\nSinopse do Filme: " + listaFilmes.get(1).getSinopse());
                        System.out.print("\nDigite o número 1, para voltar ao menu principal: ");
                        int navegacao2 = entrada.nextInt();

                        if (navegacao2 == 1) {
                            break voltar2;
                        }

                        // Avaliar o filme - acrescentar apenas uma avaliacao por mes
                    } else if (navegacao == 3) {

                        System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                + listaFilmes.get(1).getNome());
                        System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                        System.out.print("\nEscolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                        int avaliacao1 = entrada.nextInt();

                        if (avaliacao1 == 1) {
                            likeFilme1++;
                        } else if (avaliacao1 == 2) {
                            likeFilme1--;
                        }
                        break filme2;

                        // Recomendação - aprimorar
                    } else if (navegacao == 4) {
                        Scanner entrada1 = new Scanner((System.in));

                        System.out.print("\nDigite o nome de usuário que receberá a recomendação: ");
                        String recoUser = entrada1.nextLine();

                        System.out.print("\nDigite o porque você deseja recomendar esse filme: ");
                        String recoTexto = entrada1.nextLine();

                        recomendacao.add(new Recomendacao(recoUser, recoTexto));

                        for (Recomendacao verReco: recomendacao) {
                            System.out.print("\nRecomendação enviada para o usuário: " + verReco.getNomeUsuario());
                            System.out.print("\nComentário enviando: " + verReco.getComentario());
                        }

                    } else if (navegacao == 5) {
                        break voltar2;
                    }
                }

                filme3:
                if (escolhaFilme == 3 && pago) {
                    System.out.println("Você escolheu o filme " +
                            listaFilmes.get(2).getNome() + ", o que você deseja fazer?");

                    // Mostrar opções
                    System.out.print("\n1 - Assistir, 2 - Descrição, 3 - Avaliar, 4 - Recomendar, " +
                            "5 - Voltar Menu Principal: ");
                    int navegacao = entrada.nextInt();

                    voltar3:
                    if (navegacao == 1) {
                        System.out.println("Conectando..." + listaFilmes.get(2).getLink());
                        System.out.println("Conexão concluída");
                        System.out.println("Assistindo o filme");

                        // Incrementa a visualização do filme
                        generoAcao++;

                        System.out.println("\nVocê terminou de assistir o filme " + listaFilmes.get(2).getNome() +
                                ", o que você deseja fazer agora?");

                        System.out.print("\n1 - Menu Principal, 2 - Avaliar, 3 - Sair: ");

                        int descicaoFilme1 = entrada.nextInt();

                        if (descicaoFilme1 == 1) {
                            break filme3;

                            // Avaliar o filme
                        } else if (descicaoFilme1 == 2) {
                            System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                    + listaFilmes.get(2).getNome());
                            System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                            System.out.print("Escolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                            int avaliacao1 = entrada.nextInt();

                            if (avaliacao1 == 1) {
                                likeFilme1++;
                            } else if (avaliacao1 == 2) {
                                likeFilme1--;
                            }
                            break filme3;

                        } else if (descicaoFilme1 == 3) {
                            System.out.println("\nObrigado por usar a DevInFlix, esperamos o seu retorno =)");
                            break;
                        }

                    } else if (navegacao == 2) {
                        System.out.println("\nSinopse do Filme: " + listaFilmes.get(2).getSinopse());
                        System.out.print("\nDigite o número 1, para voltar ao menu principal: ");
                        int navegacao2 = entrada.nextInt();

                        if (navegacao2 == 1) {
                            break voltar3;
                        }

                        // Avaliar o filme - acrescentar apenas uma avaliacao por mes
                    } else if (navegacao == 3) {

                        System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                + listaFilmes.get(2).getNome());
                        System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                        System.out.print("\nEscolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                        int avaliacao1 = entrada.nextInt();

                        if (avaliacao1 == 1) {
                            likeFilme1++;
                        } else if (avaliacao1 == 2) {
                            likeFilme1--;
                        }
                        break filme3;

                        // Recomendação - aprimorar
                    } else if (navegacao == 4) {
                        Scanner entrada1 = new Scanner((System.in));

                        System.out.print("\nDigite o nome de usuário que receberá a recomendação: ");
                        String recoUser = entrada1.nextLine();

                        System.out.print("\nDigite o porque você deseja recomendar esse filme: ");
                        String recoTexto = entrada1.nextLine();

                        recomendacao.add(new Recomendacao(recoUser, recoTexto));

                        for (Recomendacao verReco: recomendacao) {
                            System.out.print("\nRecomendação enviada para o usuário: " + verReco.getNomeUsuario());
                            System.out.print("\nComentário enviando: " + verReco.getComentario());
                        }

                    } else if (navegacao == 5) {
                        break voltar3;
                    }
                }

                filme4:
                if (escolhaFilme == 4 && pago) {
                    System.out.println("Você escolheu o filme " +
                            listaFilmes.get(3).getNome() + ", o que você deseja fazer?");

                    // Mostrar opções
                    System.out.print("\n1 - Assistir, 2 - Descrição, 3 - Avaliar, 4 - Recomendar, " +
                            "5 - Voltar Menu Principal: ");
                    int navegacao = entrada.nextInt();

                    voltar4:
                    if (navegacao == 1) {
                        System.out.println("Conectando..." + listaFilmes.get(3).getLink());
                        System.out.println("Conexão concluída");
                        System.out.println("Assistindo o filme");

                        // Incrementa a visualização do filme
                        generoAcao++;

                        System.out.println("\nVocê terminou de assistir o filme " + listaFilmes.get(3).getNome() +
                                ", o que você deseja fazer agora?");

                        System.out.print("\n1 - Menu Principal, 2 - Avaliar, 3 - Sair: ");

                        int descicaoFilme1 = entrada.nextInt();

                        if (descicaoFilme1 == 1) {
                            break filme4;

                            // Avaliar o filme
                        } else if (descicaoFilme1 == 2) {
                            System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                    + listaFilmes.get(3).getNome());
                            System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                            System.out.print("Escolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                            int avaliacao1 = entrada.nextInt();

                            if (avaliacao1 == 1) {
                                likeFilme1++;
                            } else if (avaliacao1 == 2) {
                                likeFilme1--;
                            }
                            break filme4;

                        } else if (descicaoFilme1 == 3) {
                            System.out.println("\nObrigado por usar a DevInFlix, esperamos o seu retorno =)");
                            break;
                        }

                    } else if (navegacao == 2) {
                        System.out.println("\nSinopse do Filme: " + listaFilmes.get(3).getSinopse());
                        System.out.print("\nDigite o número 1, para voltar ao menu principal: ");
                        int navegacao2 = entrada.nextInt();

                        if (navegacao2 == 1) {
                            break voltar4;
                        }

                        // Avaliar o filme - acrescentar apenas uma avaliacao por mes
                    } else if (navegacao == 3) {

                        System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                + listaFilmes.get(3).getNome());
                        System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                        System.out.print("\nEscolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                        int avaliacao1 = entrada.nextInt();

                        if (avaliacao1 == 1) {
                            likeFilme1++;
                        } else if (avaliacao1 == 2) {
                            likeFilme1--;
                        }
                        break filme4;

                        // Recomendação - aprimorar
                    } else if (navegacao == 4) {
                        Scanner entrada1 = new Scanner((System.in));

                        System.out.print("\nDigite o nome de usuário que receberá a recomendação: ");
                        String recoUser = entrada1.nextLine();

                        System.out.print("\nDigite o porque você deseja recomendar esse filme: ");
                        String recoTexto = entrada1.nextLine();

                        recomendacao.add(new Recomendacao(recoUser, recoTexto));

                        for (Recomendacao verReco: recomendacao) {
                            System.out.print("\nRecomendação enviada para o usuário: " + verReco.getNomeUsuario());
                            System.out.print("\nComentário enviando: " + verReco.getComentario());
                        }

                    } else if (navegacao == 5) {
                        break voltar4;
                    }
                }

                filme5:
                if (escolhaFilme == 5 && pago) {
                    System.out.println("Você escolheu o filme " +
                            listaFilmes.get(4).getNome() + ", o que você deseja fazer?");

                    // Mostrar opções
                    System.out.print("\n1 - Assistir, 2 - Descrição, 3 - Avaliar, 4 - Recomendar, " +
                            "5 - Voltar Menu Principal: ");
                    int navegacao = entrada.nextInt();

                    voltar5:
                    if (navegacao == 1) {
                        System.out.println("Conectando..." + listaFilmes.get(4).getLink());
                        System.out.println("Conexão concluída");
                        System.out.println("Assistindo o filme");

                        // Incrementa a visualização do filme
                        generoAventura++;

                        System.out.println("\nVocê terminou de assistir o filme " + listaFilmes.get(4).getNome() +
                                ", o que você deseja fazer agora?");

                        System.out.print("\n1 - Menu Principal, 2 - Avaliar, 3 - Sair: ");

                        int descicaoFilme1 = entrada.nextInt();

                        if (descicaoFilme1 == 1) {
                            break filme5;

                            // Avaliar o filme
                        } else if (descicaoFilme1 == 2) {
                            System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                    + listaFilmes.get(4).getNome());
                            System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                            System.out.print("Escolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                            int avaliacao1 = entrada.nextInt();

                            if (avaliacao1 == 1) {
                                likeFilme1++;
                            } else if (avaliacao1 == 2) {
                                likeFilme1--;
                            }
                            break filme5;

                        } else if (descicaoFilme1 == 3) {
                            System.out.println("\nObrigado por usar a DevInFlix, esperamos o seu retorno =)");
                            break;
                        }

                    } else if (navegacao == 2) {
                        System.out.println("\nSinopse do Filme: " + listaFilmes.get(4).getSinopse());
                        System.out.print("\nDigite o número 1, para voltar ao menu principal: ");
                        int navegacao2 = entrada.nextInt();

                        if (navegacao2 == 1) {
                            break voltar5;
                        }

                        // Avaliar o filme - acrescentar apenas uma avaliacao por mes
                    } else if (navegacao == 3) {

                        System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                + listaFilmes.get(4).getNome());
                        System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                        System.out.print("\nEscolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                        int avaliacao1 = entrada.nextInt();

                        if (avaliacao1 == 1) {
                            likeFilme1++;
                        } else if (avaliacao1 == 2) {
                            likeFilme1--;
                        }
                        break filme5;

                        // Recomendação - aprimorar
                    } else if (navegacao == 4) {
                        Scanner entrada1 = new Scanner((System.in));

                        System.out.print("\nDigite o nome de usuário que receberá a recomendação: ");
                        String recoUser = entrada1.nextLine();

                        System.out.print("\nDigite o porque você deseja recomendar esse filme: ");
                        String recoTexto = entrada1.nextLine();

                        recomendacao.add(new Recomendacao(recoUser, recoTexto));

                        for (Recomendacao verReco: recomendacao) {
                            System.out.print("\nRecomendação enviada para o usuário: " + verReco.getNomeUsuario());
                            System.out.print("\nComentário enviando: " + verReco.getComentario());
                        }

                    } else if (navegacao == 5) {
                        break voltar5;
                    }
                }

                filme6:
                if (escolhaFilme == 6 && pago) {
                    System.out.println("Você escolheu o filme " +
                            listaFilmes.get(5).getNome() + ", o que você deseja fazer?");

                    // Mostrar opções
                    System.out.print("\n1 - Assistir, 2 - Descrição, 3 - Avaliar, 4 - Recomendar, " +
                            "5 - Voltar Menu Principal: ");
                    int navegacao = entrada.nextInt();

                    voltar6:
                    if (navegacao == 1) {
                        System.out.println("Conectando..." + listaFilmes.get(5).getLink());
                        System.out.println("Conexão concluída");
                        System.out.println("Assistindo o filme");

                        // Incrementa a visualização do filme
                        generoAventura++;

                        System.out.println("\nVocê terminou de assistir o filme " + listaFilmes.get(5).getNome() +
                                ", o que você deseja fazer agora?");

                        System.out.print("\n1 - Menu Principal, 2 - Avaliar, 3 - Sair: ");

                        int descicaoFilme1 = entrada.nextInt();

                        if (descicaoFilme1 == 1) {
                            break filme6;

                            // Avaliar o filme
                        } else if (descicaoFilme1 == 2) {
                            System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                    + listaFilmes.get(5).getNome());
                            System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                            System.out.print("Escolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                            int avaliacao1 = entrada.nextInt();

                            if (avaliacao1 == 1) {
                                likeFilme1++;
                            } else if (avaliacao1 == 2) {
                                likeFilme1--;
                            }
                            break filme6;

                        } else if (descicaoFilme1 == 3) {
                            System.out.println("\nObrigado por usar a DevInFlix, esperamos o seu retorno =)");
                            break;
                        }

                    } else if (navegacao == 2) {
                        System.out.println("\nSinopse do Filme: " + listaFilmes.get(5).getSinopse());
                        System.out.print("\nDigite o número 1, para voltar ao menu principal: ");
                        int navegacao2 = entrada.nextInt();

                        if (navegacao2 == 1) {
                            break voltar6;
                        }

                        // Avaliar o filme - acrescentar apenas uma avaliacao por mes
                    } else if (navegacao == 3) {

                        System.out.println("\nEscolha abaixo uma das opções para avaliar o filme "
                                + listaFilmes.get(5).getNome());
                        System.out.println("\nEsse filme possui uma quantidade de likes de: " + likeFilme1);
                        System.out.print("\nEscolha 1 para dar like no filme ou 2 para dar deslike no filme: ");
                        int avaliacao1 = entrada.nextInt();

                        if (avaliacao1 == 1) {
                            likeFilme1++;
                        } else if (avaliacao1 == 2) {
                            likeFilme1--;
                        }
                        break filme6;

                        // Recomendação - aprimorar
                    } else if (navegacao == 4) {
                        Scanner entrada1 = new Scanner((System.in));

                        System.out.print("\nDigite o nome de usuário que receberá a recomendação: ");
                        String recoUser = entrada1.nextLine();

                        System.out.print("\nDigite o porque você deseja recomendar esse filme: ");
                        String recoTexto = entrada1.nextLine();

                        recomendacao.add(new Recomendacao(recoUser, recoTexto));

                        for (Recomendacao verReco: recomendacao) {
                            System.out.print("\nRecomendação enviada para o usuário: " + verReco.getNomeUsuario());
                            System.out.print("\nComentário enviando: " + verReco.getComentario());
                        }

                    } else if (navegacao == 5) {
                        break voltar6;
                    }
                }

                // Sugestões de filmes
                if (escolhaFilme == 7) {
                    Scanner entradaSugestao = new Scanner((System.in));

                    if ((diaAtual < ultDiaMes) && avaliou) {
                        System.out.println("\nVocê já enviou uma sugestão de filme este mês =)");
                        System.out.println("Agradecemos por usar a nossa plataforma de streming");
                        break menu;
                    } else {
                        System.out.print("\nDigite o filme que você gostaria de ver na plataforma: ");
                        String sugesFilme = entradaSugestao.nextLine();
                        System.out.println("A sugestão para o filme " + sugesFilme + " foi enviada com sucesso!");
                        avaliou = true;
                        break menu;
                    }

                }

                // Área Administrativa
                if (escolhaFilme == 8) {

                    System.out.println("Digite 1 para efetuar o seu pagamento da mensalidade");
                    System.out.println("Digite 2 para acessar a Área Administrativa");
                    Scanner entradaAdm = new Scanner((System.in));
                    int escolhaAdm = entradaAdm.nextInt();

                    if (escolhaAdm == 1){
                        System.out.println("DevInFlix agradece pelo pagamento");
                        pago = true;
                        break menu;
                    } else if (escolhaAdm == 2){
                        Scanner entradaAdmN = new Scanner((System.in));

                        System.out.print("Digite o login administrativo: ");
                        String loginAdm = entradaAdmN.nextLine();
                        System.out.print("Digite a senha administrativa: ");
                        String senhaAdm = entradaAdmN.nextLine();

                        if (Objects.equals(loginAdm, "admin") && Objects.equals(senhaAdm, "devinflix123")) {

                            System.out.println("\nSeja bem vindo ao painel administrativo");
                            System.out.println("\nEscolha 1 para cadastrar usuários em lote");
                            System.out.println("Escolha 2 para acessar categorias mais vistas");

                            Scanner entradaDash = new Scanner((System.in));
                            int escolhaDash = entradaDash.nextInt();

                            if (escolhaDash == 1) {
                                String nomeUsers = null;

                                int l = 0;

                                boolean inicia = true;

                                System.out.println("Bem vindo ao cadastro de usuários em lote");

                                System.out.print("Quantos usuários você deseja criar?: ");
                                int numeroUser = entrada.nextInt();


                                while (inicia) {

                                    for (int x = 0; x < numeroUser; x++) {
                                        Scanner entrada1 = new Scanner((System.in));
                                        l++;
                                        System.out.print("Digite o nome dos usuario " + l +": ");
                                        nomeUsers = entrada1.nextLine();

                                        List<String> userOnlines = List.of(nomeUsers);

                                        userOnlines.forEach((nomes) -> {
                                            System.out.println("Usuário cadastrado e online: " + nomes);
                                        });

                                    }
                                    inicia = false;
                                }
                                break menu;

                            } else if (escolhaDash == 2) {
                                System.out.println("\n\nSegue abaixo as views por categoria");
                                System.out.println("A categoria Aventura possui " + generoAventura + " visualizações");
                                System.out.println("A categoria Ação possui " + generoAcao + " visualizações");
                                System.out.println("A categoria Ficção Científica possui " + generoCientifico +
                                        " visualizações");

                                System.out.print("\nDigite o número 1, para voltar ao menu principal: ");
                                int voltarMenu = entrada.nextInt();

                                if (voltarMenu == 1) {
                                    break menu;
                                }
                            }


                        } else {
                            System.out.println("Credenciais inválidas");
                            break menu;
                        }

                    }


                }

                // Verificar se o usuário já efetuou o pagamento
                if (!pago) {
                    System.out.println("\nVocê ainda não pagou a sua fatura, acesse o menu 8 para efetuar o pagamento");
                }

            }

        }

    }

}
