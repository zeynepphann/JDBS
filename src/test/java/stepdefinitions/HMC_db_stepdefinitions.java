package stepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;

public class HMC_db_stepdefinitions {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; user=techproed;password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";

    Connection connection; // Database'e baglanmamizi saglar
    Statement statement; //Query calistirmamizi saglar
    ResultSet resultSet; // query sonucunda donen sonucu store etmemize yariyor


    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        String query = "SELECT "+field+" FROM "+ table;
        resultSet = statement.executeQuery(query);
    }

    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String string) throws SQLException {

        resultSet.first();
        System.out.println(resultSet.getString("Price"));
        resultSet.next(); // iteratar'a benzer sekilde calisir
                         // next()'u imleci bir sonraki degerin yanina goturur
                          // bize true yada false doner
        System.out.println(resultSet.getString("Price")); // imlec neredeyse orayi yazdirir
        System.out.println("resultSet.next() = " + resultSet.next()); // true donduru
        System.out.println(resultSet.getString("Price"));

        // next kullanilirken cok dikkatli olmaliyiz
        //cunku nerede olursa olsun imleci bir sonraki elemente gecirecektir


        System.out.println("=============================Liste===============================");

        resultSet.first();
        resultSet.absolute(0);
        int sira=1;
        while (resultSet.next()){
            System.out.println(sira +  ". kayit "+ resultSet.getString("Price")); // imlec neredeyse orayi yazdirir
            sira++;

        }


        resultSet.last();
        System.out.println(resultSet.getRow());


    }

}
