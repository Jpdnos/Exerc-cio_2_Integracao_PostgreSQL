package app;

import service.CarroService;
import model.Carro;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CarroService carroService = new CarroService();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha restante

            if (option == 1) {
                insertCarro(carroService, scanner);
            } else if (option == 2) {
                listAllCarros(carroService);
            } else if (option == 3) {
                updateCarro(carroService, scanner);
            } else if (option == 4) {
                removeCarro(carroService, scanner);
            } else if (option == 5) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 5);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Inserir Carro");
        System.out.println("2. Listar Carros");
        System.out.println("3. Atualizar Carro");
        System.out.println("4. Excluir Carro");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void insertCarro(CarroService service, Scanner scanner) {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        Carro novoCarro = new Carro(0, placa, marca, modelo, ano, cor);
        service.add(novoCarro);
    }

    private static void listAllCarros(CarroService service) {
        List<Carro> carros = service.getAllList();
        if (carros != null && !carros.isEmpty()) {
            System.out.println("\n--- Lista de Carros ---");
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        } else {
            System.out.println("Nenhum carro encontrado.");
        }
    }

    private static void updateCarro(CarroService service, Scanner scanner) {
        System.out.print("Digite o ID do carro para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha

        Carro carro = service.getById(id);
        if (carro != null) {
            System.out.println("Carro encontrado: " + carro);
            System.out.println("Digite os novos dados (deixe em branco para manter o atual):");

            System.out.print("Nova Placa (" + carro.getPlaca() + "): ");
            String novaPlaca = scanner.nextLine();
            if (!novaPlaca.isEmpty()) {
                carro.setPlaca(novaPlaca);
            }

            System.out.print("Nova Marca (" + carro.getMarca() + "): ");
            String novaMarca = scanner.nextLine();
            if (!novaMarca.isEmpty()) {
                carro.setMarca(novaMarca);
            }

            System.out.print("Novo Modelo (" + carro.getModelo() + "): ");
            String novoModelo = scanner.nextLine();
            if (!novoModelo.isEmpty()) {
                carro.setModelo(novoModelo);
            }

            System.out.print("Novo Ano (" + carro.getAno() + "): ");
            String novoAnoStr = scanner.nextLine();
            if (!novoAnoStr.isEmpty()) {
                try {
                    carro.setAno(Integer.parseInt(novoAnoStr));
                } catch (NumberFormatException e) {
                    System.out.println("Ano inválido. Mantendo o ano atual.");
                }
            }

            System.out.print("Nova Cor (" + carro.getCor() + "): ");
            String novaCor = scanner.nextLine();
            if (!novaCor.isEmpty()) {
                carro.setCor(novaCor);
            }

            service.update(carro);
        } else {
            System.out.println("Carro com ID " + id + " não encontrado.");
        }
    }

    private static void removeCarro(CarroService service, Scanner scanner) {
        System.out.print("Digite o ID do carro para excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        service.remove(id);
    }
}