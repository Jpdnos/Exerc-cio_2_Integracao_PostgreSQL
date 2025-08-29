package service;

import dao.CarroDAO;
import model.Carro;

import java.sql.SQLException;
import java.util.List;

public class CarroService {

    private CarroDAO carroDAO;

    public CarroService() {
        try {
            carroDAO = new CarroDAO();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }

    // Criar carro
    public void add(Carro carro) {
        try {
            carroDAO.add(carro);
            System.out.println("Carro cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados ao adicionar: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao criar carro: " + e.getMessage());
        }
    }

    // Buscar carro por ID
    public Carro getById(int id) {
        try {
            return carroDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Atualizar carro
    public void update(Carro carro) {
        try {
            carroDAO.update(carro);
            System.out.println("Carro atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados ao atualizar: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao atualizar carro: " + e.getMessage());
        }
    }

    // Remover carro
    public void remove(int id) {
        try {
            carroDAO.remove(id);
            System.out.println("Carro removido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados ao remover: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao remover carro: " + e.getMessage());
        }
    }

    // Listar todos os carros
    public List<Carro> getAllList() {
        try {
            return carroDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}