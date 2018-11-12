package model.sqlite;

import model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoSQLite extends  SQLiteBase{

    public VeiculoSQLite() {
        open();

        try
        {
            PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Veiculos ("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "marca TEXT,"+
                    "modelo TEXT,"+
                    "hp INTEGER);");

            stm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
    }


    public void create(Veiculo v){
        open();

        try
        {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Veiculos VALUES (?,?,?,?);");

            stm.setString(2,v.getMarca());
            stm.setString(3,v.getModelo());
            stm.setInt(4,v.getHp());

            stm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }
    }

    public List<Veiculo> all(){
        ArrayList<Veiculo> result = new ArrayList<>();

        open();

        try
        {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Veiculos ORDER BY id ASC;");

            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                Veiculo v = new Veiculo(
                        rs.getInt(1), //id
                        rs.getString(2), //marca
                        rs.getString(3), //modelo
                        rs.getInt(4) //hp
                );

                result.add(v);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }

        return result;

    }

}