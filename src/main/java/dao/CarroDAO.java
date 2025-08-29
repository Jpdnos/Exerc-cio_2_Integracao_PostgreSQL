package dao;

import model.Carro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    private Connection conn;

    public CarroDAO() throws SQLException {
       
        String url = "jdbc:postgresql://localhost:5432/teste";
        String user = "ti2cc";
        String password = "ti@cc";
        conn = DriverManager.getConnection(url, user, password);
    }

    // Adicionar carro
    public void add(Carro carro) throws SQLException {
        String sql = "INSERT INTO carros (placa, marca, modelo, ano, cor) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getModelo());
            stmt.setInt(4, carro.getAno());
            stmt.setString(5, carro.getCor());
            stmt.executeUpdate();
        }
    }

    // Buscar por ID
    public Carro get(int id) throws SQLException {
        String sql = "SELECT * FROM carros WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Carro(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("cor")
                );
            }
        }
        return null;
    }

    // Atualizar carro
    public void update(Carro carro) throws SQLException {
        String sql = "UPDATE carros SET placa=?, marca=?, modelo=?, ano=?, cor=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getModelo());
            stmt.setInt(4, carro.getAno());
            stmt.setString(5, carro.getCor());
            stmt.setInt(6, carro.getId());
            stmt.executeUpdate();
        }
    }

    // Remover carro
    public void remove(int id) throws SQLException {
        String sql = "DELETE FROM carros WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Listar todos
    public List<Carro> getAll() throws SQLException {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carros ORDER BY id";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                carros.add(new Carro(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("cor")
                ));
            }
        }
        return carros;
    }
}


