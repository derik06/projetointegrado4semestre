package dao;

import model.Led;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LedDAO {

    public void ligarLed(Led led) {

        // String sqlInsert = "INSERT INTO `tb_fato_led`(`ID_FATO_LED`, `DT_INICIO`, `DT_FIM`, `INTERVALO_TEMPO`, `ID_LED`, `CONSUMO`, `VALOR`) VALUES (NULL, NOW(), NULL, NULL, ?, NULL, NULL)";
        String sqlInsert = "INSERT INTO tb_fato_led(ID_FATO_LED, DT_INICIO, DT_FIM, INTERVALO_TEMPO, ID_LED, CONSUMO, VALOR) VALUES (NULL, NOW(), NULL, NULL, ?, NULL, NULL)";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setInt(1, led.getIdLed());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desligarLed(Led led) {

        int idFatoLed = 0;

        String sqlQuery = "SELECT\r\n" + 
        		"    MAX(ID_FATO_LED)\r\n" + 
        		"FROM\r\n" + 
        		"    TB_FATO_LED\r\n" + 
        		"WHERE\r\n" + 
        		"    ID_LED = "+led.getIdLed();
        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stm = conn.prepareStatement(sqlQuery);
             ResultSet rs = stm.executeQuery()) {
            if (rs.next()) {
                idFatoLed = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sqlUpdate = "UPDATE `tb_fato_led` SET `DT_FIM`= NOW(), `INTERVALO_TEMPO` = NOW() - DT_INICIO, `CONSUMO` = (NOW() - DT_INICIO) * ( SELECT POTENCIA FROM tb_led WHERE ID_LED = ?),`VALOR` = ((NOW() - DT_INICIO) * (SELECT POTENCIA FROM tb_led WHERE ID_LED = ?)) * 1/*Valor em R$ por energia 0,001*/ WHERE ID_FATO_LED = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
             PreparedStatement stm2 = conn.prepareStatement(sqlUpdate);) {
            stm2.setInt(1, led.getIdLed());
            stm2.setInt(2, led.getIdLed());
            stm2.setInt(3, idFatoLed);
            stm2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
