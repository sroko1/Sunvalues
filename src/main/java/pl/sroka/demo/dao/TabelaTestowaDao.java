package pl.sroka.demo.dao;

import pl.sroka.demo.model.TabelaTestowa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TabelaTestowaDao {


    private static String connectionString = "jdbc:postgresql://surus.db.elephantsql.com:5432/gmovxgzf";
    private static final String username = "gmovxgzf";
    private static String password = "GoGWcr__m2ph4AD1xeZK1PESZIcGU-Bl";

    public List<TabelaTestowa> list() throws SQLException {
        List<TabelaTestowa> tabelaTestowaList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {

            String sql = "SELECT * FROM tabela_testowa";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                TabelaTestowa tabelaTestowa = new TabelaTestowa(resultSet.getInt("id"),
                        resultSet.getString("kolumna1"), resultSet.getString("kolumna2"),
                        resultSet.getString("kolumna3"), resultSet.getInt("kolumna4"));

                tabelaTestowaList.add(tabelaTestowa);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return tabelaTestowaList;

    }

}