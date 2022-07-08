package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.DBUtils;

public class HMC_DBUtils_stepdefinitions {
    @Given("kullanici DBUtils ile HMC veri tabanina baglanir")
    public void kullanici_db_utils_ile_hmc_veri_tabanina_baglanir() {
        DBUtils.getConnection();

    }

    @Given("kullanici DBUtils ile  {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_utils_ile_tablosundaki_verilerini_alir(String string, String string2) {


    }

    @Given("kullanici DBUtils ile  {string} sutunundaki verileri okur")
    public void kullanici_db_utils_ile_sutunundaki_verileri_okur(String string) {

    }

}
