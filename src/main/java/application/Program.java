package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Seller;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    private static Scanner sc = new Scanner(System.in);
    private static SellerDao seller = DaoFactory.createSellerDao();
    private static DepartmentDao dept = DaoFactory.createDepartmentDao();

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        int opcaoPrincipal = 0;
        while (opcaoPrincipal != 3) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Gerenciar Vendedores");
            System.out.println("2 - Gerenciar Departamentos (Requer Senha)");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            opcaoPrincipal = sc.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    menuVendedores();
                    break;
                case 2:

                    boolean tentarnovamente = true;

                    while (tentarnovamente) {

                        System.out.print("Digite a senha de administrador: ");
                        String senha = sc.next();

                        if (senha.equals("123")) {
                            menuDepartamentos();
                            tentarnovamente = false;
                        }
                        else  {
                            System.out.println("Senha incorreta! Acesso negado.");

                            boolean opcaovalida = true;

                            while (opcaovalida) {

                                System.out.println("Deseja tentar novamente? [ S / N ]");
                                char opcao = sc.next().charAt(0);
                                if (opcao == 'S' || opcao == 's') {
                                    opcaovalida = false;
                                } else if (opcao == 'N' || opcao == 'n') {
                                    System.out.println("Voltando...");
                                    opcaovalida = false;
                                    tentarnovamente = false;
                                } else {
                                    System.out.println("Opção inválida, tente novamente.");
                                }
                            }
                        }

                    }

                    break;

                case 3:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    }
            }
        sc.close();
    }

    private static void menuVendedores() {
        System.out.println("\n--- MENU VENDEDORES ---");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar todos");
        System.out.println("3 - Inserir novo vendedor");
        System.out.println("4 - Atualizar vendedor");
        System.out.println("5 - Deletar vendedor");
        System.out.println("6 - Buscar vendedores por departamento");
        System.out.println("7 - Voltar");
        System.out.print("Opção: ");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:

                boolean repetirbusca = true;

                while (repetirbusca) {

                    System.out.println("Digite o id do vendedor: ");
                    int id = sc.nextInt();

                    var vendedorencontrado = seller.findById(id);
                    if (vendedorencontrado == null) {
                        System.out.println("Vendedor inexistente!");
                    } else {
                        System.out.println("Vendedor encontrado! \n");
                        System.out.println(vendedorencontrado);
                    }

                    boolean opcaovalida = true;

                    while (opcaovalida) {

                        System.out.println("Deseja fazer outra busca? [ S / N ]");
                        char opSN = sc.next().charAt(0);
                        if (opSN == 'S' || opSN == 's') {
                            opcaovalida = false;
                        } else if (opSN == 'N' || opSN == 'n') {
                            System.out.println("Voltando...");
                            opcaovalida = false;
                            repetirbusca =  false;
                        } else {
                            System.out.println("Opção inválida, tente novamente.");
                        }
                    }
                }
                break;

            case 2:

                System.out.println("\n Lista de Todos os Vendedores: \n");

                for (Seller s : seller.findAll())
                System.out.println(s);

                break;

                // case -> voltar ou opção inválida
            case 7:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida! Tente novamente.");
                menuVendedores();
            break;

        }
    }

    private static void menuDepartamentos() {
        System.out.println("\n--- MENU DEPARTAMENTOS ---");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar todos");
        System.out.println("3 - Inserir departamento");
        System.out.println("4 - Atualizar departamento");
        System.out.println("5 - Deletar departamento");
        System.out.println("6 - Voltar");
        System.out.print("Opção: ");

        int opcao = sc.nextInt();

        switch (opcao) {

            // case -> voltar ou opção inválida
            case 6:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                menuDepartamentos();
                break;

        }
    }

}
