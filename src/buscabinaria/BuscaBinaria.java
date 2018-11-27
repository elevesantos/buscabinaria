package buscabinaria;

import java.util.Scanner;

public class BuscaBinaria {

    public static void main(String[] args) {
        
        Arvore a = new Arvore();        
        Node aux = null;
        Scanner entrada = new Scanner(System.in);
        
        int opcao;
        int valor;
        
        do {
            exibeMenu();
            opcao = entrada.nextInt();
            
            switch(opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido:");
                    valor = entrada.nextInt();
                    aux = a.inserir(aux, valor);
                    System.out.println("Inserido!");
                break;
                case 2:
                    System.out.print("Digite o valor a ser removido: ");
                    valor = entrada.nextInt();
                    if (a.buscar(aux, valor) != null) {
                        aux = a.remover(aux, valor);
                        System.out.println("Removido!");
                    } else {
                        System.out.println("Valor não encontrado!");
                    }
                break;
                case 3:
                   System.out.print("Digite o valor a ser buscado: ");
                   valor = entrada.nextInt();
                    if (a.buscar(aux, valor) != null) {
                        System.out.println("Valor encontrado com sucesso!");
                    } else {
                        System.out.println("Valor não encontrado!");
                    }
                break;
                case 4:
                    System.out.println("Valor mínimo: " + a.minimo(aux).info);
                break;
                case 5:
                    System.out.println("Valor máximo: " + a.maximo(aux).info);
                break;
                case 6:
                    System.out.print("Em ordem: ");
                    a.emOrdem(aux);
                    System.out.println("");
                break;
                case 7:
                    System.out.print("Pré ordem: ");
                    a.preOrdem(aux);
                    System.out.println("");
                break;
                case 8:
                    System.out.print("Pós ordem: ");
                    a.posOrdem(aux);
                    System.out.println("");
                break;
                case 9:
                    System.out.println("");
                break;
                default:
                    System.out.println("Opção inválida");
            }
        
        } while (opcao != 9 );
    }
    
    public static void exibeMenu() {
        System.out.println("Para executar a ação, digite o número correspondente: ");
        System.out.println("1 - inserir");
        System.out.println("2 - remover");
        System.out.println("3 - buscar");
        System.out.println("4 - mínimo");
        System.out.println("5 - máximo");
        System.out.println("6 - Em Ordem");
        System.out.println("7 - Pré Ordem");        
        System.out.println("8 - Pós Ordem");
        System.out.println("9 - Sair");
    }
    
}
