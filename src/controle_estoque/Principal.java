package controle_estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        produtos.add(new Produto("Fio", 5, "m", 100));
        produtos.add(new Produto("Cimento", 4, "kg", 500));
        produtos.add(new Produto("Pregos", 800, "g", 1200));

        int menu = 1;
        Scanner sc = new Scanner(System.in);
        Principal pr = new Principal();
        while (menu != 0) {
            pr.tituloMenu();
            System.out.println("MENU PRINCIPAL\n");
            System.out.println("1 - CADASTRO DE PRODUTOS");
            System.out.println("2 - MOVIMENTAÇÃO");
            System.out.println("3 - REAJUSTE DE PREÇOS");
            System.out.println("4 - RELATÓRIOS");
            System.out.println("0 - FINALIZAR\n");
            System.out.print("OPÇÃO: ");
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    pr.menuCadastroProduto();
                    break;
                case 2:
                    pr.menuMovimentacao();
                    break;
                case 3:
                    pr.reajuste();
                    break;
                case 4:
                    pr.relatorio();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }

    private void menuCadastroProduto () {
        Scanner sc = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            tituloMenu();
            System.out.println("CADASTRO DE PRODUTOS\n");
            System.out.println("1 - INCLUSÃO");
            System.out.println("2 - ALTERAÇÃO");
            System.out.println("3 - CONSULTA");
            System.out.println("4 - EXCLUSÃO");
            System.out.println("0 - RETORNAR\n");
            System.out.print("OPÇÃO: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    incluirProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    consultarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }

    private void menuMovimentacao() {
        Scanner sc = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            tituloMenu();
            System.out.println("MOVIMENTAÇÃO\n");
            System.out.println("1 - ENTRADA");
            System.out.println("2 - SAÍDA");
            System.out.println("0 - RETORNAR\n");
            System.out.print("OPÇÃO: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    entradaProduto();
                    break;
                case 2:
                    saidaProduto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void entradaProduto() {
        Scanner sc = new Scanner(System.in);
        char op = 0;

        while (Character.toUpperCase(op) != 'N') {
            boolean produto_encontrado = false;
            tituloMenu();
            System.out.println("MOVIMENTAÇÃO - ENTRADA DE PRODUTO\n");
            System.out.print("PRODUTO: ");
            String nome = sc.nextLine();
            for (int i=0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO ENCONTRADO!");
                    produto_encontrado = true;

                    System.out.println("PRODUTO " + i);
                    System.out.println("Nome: " + produtos.get(i).getNome());
                    System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
                    System.out.println("----------------------------------------------------\n");

                    System.out.print("QUANTIDADE DE ENTRADA: ");
                    int quantidade = sc.nextInt();
                    while (quantidade <= 0) {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("QUANTIDADE DE ENTRADA: ");
                        quantidade = sc.nextInt();
                    }
                    System.out.println("QUANTIDADE FINAL: " + (produtos.get(i).getQnt_estoque() + quantidade));
                    sc.nextLine();
                    System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                    char confirmar = sc.next().charAt(0);
                    while (Character.toUpperCase(confirmar) != 'S' && Character.toUpperCase(confirmar) != 'N') {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                        confirmar = sc.next().charAt(0);
                    }
                    if (Character.toUpperCase(confirmar) == 'S') {
                        produtos.get(i).setAddQuant(quantidade);
                        break;
                    }
                }
            }
            if (!produto_encontrado) {
                System.out.println("PRODUTO NÃO ENCONTRADO!");
            }
            System.out.print("REPETIR OPERAÇÃO (S/N)? ");
            op = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    private void saidaProduto() {
        Scanner sc = new Scanner(System.in);
        char op = 0;

        while (Character.toUpperCase(op) != 'N') {
            boolean produto_encontrado = false;
            tituloMenu();
            System.out.println("MOVIMENTAÇÃO - SAIDA DE PRODUTO\n");
            System.out.print("PRODUTO: ");
            String nome = sc.nextLine();
            for (int i=0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO ENCONTRADO!");
                    produto_encontrado = true;

                    System.out.println("PRODUTO " + i);
                    System.out.println("Nome: " + produtos.get(i).getNome());
                    System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                    System.out.print("QUANTIDADE DE SAÍDA: ");
                    int quantidade = sc.nextInt();
                    while (quantidade <= 0) {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("QUANTIDADE DE SAÍDA: ");
                        quantidade = sc.nextInt();
                    }
                    System.out.println("QUANTIDADE FINAL: " + (produtos.get(i).getQnt_estoque() - quantidade));
                    sc.nextLine();
                    System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                    char confirmar = sc.next().charAt(0);
                    while (Character.toUpperCase(confirmar) != 'S' && Character.toUpperCase(confirmar) != 'N') {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                        confirmar = sc.next().charAt(0);
                    }
                    if (Character.toUpperCase(confirmar) == 'S') {
                        produtos.get(i).setRemoveQuant(quantidade);
                        break;
                    }
                }
            }
            if (!produto_encontrado) {
                System.out.println("PRODUTO NÃO ENCONTRADO!");
            }
            System.out.print("REPETIR OPERAÇÃO (S/N)? ");
            op = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    private void incluirProduto() {
        Scanner sc = new Scanner(System.in);
        char op = 0;
        while (Character.toUpperCase(op) != 'N') {
            tituloMenu();
            System.out.println("INCLUSÃO DE PRODUTO\n");
            System.out.print("NOME: ");
            String nome = sc.nextLine();
            for (int i=0; i < produtos.size(); i++) {
                while (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO JÁ CADASTRADO!");
                    System.out.print("\nNOME: ");
                    nome = sc.nextLine();
                    i=0;
                }
            }
            System.out.print("PREÇO: R$");
            double preco = sc.nextDouble();
            sc.nextLine();
            while (preco < 0) {
                System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                System.out.println();
                System.out.print("PREÇO: R$");
                preco = sc.nextDouble();
            }

            System.out.print("UNIDADE: ");
            String unidade = sc.nextLine();

            System.out.print("QUANTIDADE: ");
            int quantidade = sc.nextInt();
            while (quantidade <= 0) {
                System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                System.out.println();
                System.out.print("PREÇO: R$");
                quantidade = sc.nextInt();
            }
            sc.nextLine();
            System.out.print("CONFIRMA INCLUSAO (S/N)? ");
            char confirmar = sc.next().charAt(0);
            while (Character.toUpperCase(confirmar) != 'S' && Character.toUpperCase(confirmar) != 'N') {
                System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                System.out.println();
                System.out.print("CONFIRMA INCLUSAO (S/N)? ");
                confirmar = sc.next().charAt(0);
            }
            sc.nextLine();
            if (Character.toUpperCase(confirmar) == 'S') {
                produtos.add(new Produto(nome, preco, unidade, quantidade));
            }
            System.out.print("REPETIR OPERAÇÃO (S/N)? ");
            op = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    private void alterarProduto() {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        while (Character.toUpperCase(op) != 'N') {
            boolean produto_encontrado = false;
            tituloMenu();
            System.out.println("ALTERAÇÃO DE PRODUTO\n");
            System.out.print("INFORME O NOME DO PRODUTO: ");
            String nome = sc.nextLine();
            for (int i=0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO ENCONTRADO!");
                    produto_encontrado = true;

                    System.out.println("PRODUTO " + i);
                    System.out.println("Nome: " + produtos.get(i).getNome());
                    System.out.println("Preço Unitario: R$" + produtos.get(i).getPreco_unit());
                    System.out.println("Unidade: " + produtos.get(i).getUnidade());
                    System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
                    System.out.println("----------------------------------------------------\n");

                    System.out.print("\nPREÇO A SER ALTERADO: R$");
                    double preco = sc.nextDouble();
                    sc.nextLine();
                    while (preco < 0) {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("PREÇO: R$");
                        preco = sc.nextDouble();
                    }
                    System.out.print("UNIDADE A SER ALTERADA: ");
                    String unidade = sc.nextLine();
                    System.out.print("QUANTIDADE A SER ALTERADA: ");
                    int quantidade = sc.nextInt();
                    while (quantidade <= 0) {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("QUANTIDADE A SER ALTERADA:");
                        quantidade = sc.nextInt();
                    }
                    sc.nextLine();
                    System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                    char confirmar = sc.next().charAt(0);
                    while (Character.toUpperCase(confirmar) != 'S' && Character.toUpperCase(confirmar) != 'N') {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                        confirmar = sc.next().charAt(0);
                    }
                    if (Character.toUpperCase(confirmar) == 'S') {
                        produtos.set(i, new Produto(nome, preco, unidade, quantidade));
                        break;
                    }
                }
            }
            if (!produto_encontrado) {
                System.out.println("PRODUTO NÃO ENCONTRADO!");
            }
            System.out.print("REPETIR OPERAÇÃO (S/N)? ");
            op = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    private void consultarProduto() {
        Scanner sc = new Scanner(System.in);

        int op = 1;
        while (Character.toUpperCase(op) != 'N') {
            boolean produto_encontrado = false;
            tituloMenu();
            System.out.println("CONSULTA DE PRODUTO\n");
            System.out.print("INFORME O NOME DO PRODUTO: ");
            String nome = sc.nextLine();
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO ENCONTRADO!");
                    produto_encontrado = true;

                    System.out.println("PRODUTO " + i);
                    System.out.println("Nome: " + produtos.get(i).getNome());
                    System.out.println("Preço Unitario: R$" + produtos.get(i).getPreco_unit());
                    System.out.println("Unidade: " + produtos.get(i).getUnidade());
                    System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
                    System.out.println("----------------------------------------------------\n");
                }
            }
            if (!produto_encontrado) {
                System.out.println("PRODUTO NÃO ENCONTRADO!");
            }
            System.out.print("\nREPETIR OPERAÇÃO (S/N)? ");
            op = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    private void excluirProduto() {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        while (Character.toUpperCase(op) != 'N') {
            boolean produto_encontrado = false;
            tituloMenu();
            System.out.println("EXCLUSÃO DE PRODUTO\n");
            System.out.print("INFORME O NOME DO PRODUTO: ");
            String nome = sc.nextLine();
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO ENCONTRADO!");
                    produto_encontrado = true;

                    System.out.println("PRODUTO " + i);
                    System.out.println("Nome: " + produtos.get(i).getNome());
                    System.out.println("Preço Unitario: R$" + produtos.get(i).getPreco_unit());
                    System.out.println("Unidade: " + produtos.get(i).getUnidade());
                    System.out.println("Quantidade em estoque: " + produtos.get(i).getQnt_estoque());
                    System.out.println("----------------------------------------------------\n");

                    System.out.print("DESEJA MESMO EXCLUIR O PRODUTO (S/N)? ");
                    char confirmar_exclusao = sc.next().charAt(0);
                    while (Character.toUpperCase(confirmar_exclusao) != 'S'
                            && Character.toUpperCase(confirmar_exclusao) != 'N') {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                        confirmar_exclusao = sc.next().charAt(0);
                    }
                    if (Character.toUpperCase(confirmar_exclusao) == 'S') {
                        produtos.remove(i);
                        break;
                    }
                }
            }
            if (!produto_encontrado) {
                System.out.println("PRODUTO NÃO ENCONTRADO!");
            }
            System.out.print("REPETIR OPERAÇÃO (S/N)? ");
            op = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    private void reajuste() {
        Scanner sc = new Scanner(System.in);
        char op = 0;

        while (Character.toUpperCase(op) != 'N') {
            boolean produto_encontrado = false;
            tituloMenu();
            System.out.println("REAJUSTE DE PREÇOS\n");
            System.out.print("PRODUTO: ");
            String nome = sc.nextLine();
            for (int i=0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                    System.out.println("PRODUTO ENCONTRADO!");
                    produto_encontrado = true;

                    System.out.println("PRODUTO " + i);
                    System.out.println("Nome: " + produtos.get(i).getNome());
                    System.out.println("Valor: R$" + produtos.get(i).getPreco_unit());
                    System.out.println("----------------------------------------------------\n");

                    System.out.print("PERCENTUAL DE REAJUSTE (%): ");
                    double percentual = sc.nextDouble();
                    while (percentual < 0) {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("PERCENTUAL DE REAJUSTE (%): ");
                        percentual = sc.nextDouble();
                    }

                    double percentualSoma = produtos.get(i).getPreco_unit() * (1 + percentual / 100);
                    System.out.println("NOVO VALOR UNITÁRIO DO PRODUTO: R$" + (percentualSoma));
                    sc.nextLine();
                    System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                    char confirmar = sc.next().charAt(0);
                    while (Character.toUpperCase(confirmar) != 'S' && Character.toUpperCase(confirmar) != 'N') {
                        System.out.println("\nDIGITE UM VALOR VÁLIDO!");
                        System.out.println();
                        System.out.print("CONFIRMA ALTERAÇÃO (S/N)? ");
                        confirmar = sc.next().charAt(0);
                    }

                    if (Character.toUpperCase(confirmar) == 'S') {
                        produtos.get(i).setPreco_unit(percentualSoma);
                        break;
                    }
                }
            }

            if (!produto_encontrado) {
                System.out.println("PRODUTO NÃO ENCONTRADO!");
            }
            System.out.print("REPETIR OPERAÇÃO (S/N)? ");
            op = sc.next().charAt(0);
            sc.nextLine();

        }
    }

    private void relatorio() {
        int n = 1;
        tituloMenu();
        System.out.println("RELATÓRIO: LISTA DE PRODUTOS\n");
        if (produtos.isEmpty()) {
            System.out.println("NÃO HÁ PRODUTOS!");
        } else {
            for (Produto produtos : produtos) {
                System.out.println("PRODUTO " + n);
                System.out.println("Nome: " + produtos.getNome());
                System.out.println("Preço Unitario: R$" + produtos.getPreco_unit());
                System.out.println("Unidade: " + produtos.getUnidade());
                System.out.println("Quantidade em estoque: " + produtos.getQnt_estoque());
                System.out.println();
                n++;
            }
        }
    }

    private void tituloMenu() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
        System.out.println("----------------------------------------------------\n");
    }
}