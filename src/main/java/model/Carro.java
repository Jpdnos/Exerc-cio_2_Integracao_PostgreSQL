package model;

public class Carro {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private String cor;

    public Carro(int id, String placa, String marca, String modelo, int ano, String cor) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    // Getters
    public int getId() { return id; }
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public String getCor() { return cor; }

    // Setters
    public void setId(int id) { this.id = id; } 
    public void setPlaca(String placa) { this.placa = placa; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAno(int ano) { this.ano = ano; }
    public void setCor(String cor) { this.cor = cor; }

    @Override
    public String toString() {
        return "Carro [id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo 
                + ", ano=" + ano + ", cor=" + cor + "]";
    }
}
