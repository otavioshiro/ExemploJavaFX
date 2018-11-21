package model;

public class Veiculo {

    private Integer id;
    private String marca;
    private String modelo;
    private int hp;

    public Veiculo(String marca, String modelo, int hp) {
        this.marca = marca;
        this.modelo = modelo;
        this.hp = hp;
    }

    public Veiculo(int id, String marca, String modelo, int hp) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.hp = hp;
    }

    public Integer getid() {
        return id;
    }

    public void set_id(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString(){
        return "Veiculo ("+marca+"\t"+modelo+"\t"+hp+")["+id+"]";
    }

}
