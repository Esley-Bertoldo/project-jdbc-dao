package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SellerDao seller = DaoFactory.createSellerDao();
        DepartmentDao dept = DaoFactory.createDepartmentDao();

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
                    menuVendedores(sc);
                    break;
                case 2:
                    System.out.print("Digite a senha de administrador: ");
                    String senha = sc.next();

                    if (senha.equals("admin123")) {
                        menuDepartamentos(sc);
                    } else {
                        System.out.println("Senha incorreta! Acesso negado.");
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

    private static void menuVendedores(Scanner sc) {
        System.out.println("\n--- MENU VENDEDORES ---");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar todos");
        System.out.println("3 - Inserir novo vendedor");
        System.out.println("4 - Atualizar vendedor");
        System.out.println("5 - Deletar vendedor");
        System.out.println("6 - Buscar vendedores por departamento");
        System.out.print("Opção: ");

        int opcao = sc.nextInt();

        if (opcao == 1) {
            System.out.print("Digite o ID do vendedor: ");
            int id = sc.nextInt();
            System.out.println("Buscando vendedor...");
        }
    }

    private static void menuDepartamentos(Scanner sc) {
        System.out.println("\n--- MENU DEPARTAMENTOS ---");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar todos");
        System.out.println("3 - Inserir departamento");
        System.out.println("4 - Atualizar departamento");
        System.out.println("5 - Deletar departamento");
        System.out.print("Opção: ");

        int opcao = sc.nextInt();
    }

}
