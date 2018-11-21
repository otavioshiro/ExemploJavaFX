package model;

import model.sqlite.VeiculoSQLiteDAO;

import java.util.List;

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


    //-------------------------------------- DAO

    private static VeiculoSQLiteDAO dao = new VeiculoSQLiteDAO();

    public void save(){

        if(id != null && dao.find(id) != null)
            dao.update(this);
        else
            dao.create(this);
    }

    public void delete(){
        if(dao.find(id) != null)
            dao.delete(this);
    }

    public static List<Veiculo> all(){
        return dao.all();
    }

    public static Veiculo find(int pk){
        return dao.find(pk);
    }


}
