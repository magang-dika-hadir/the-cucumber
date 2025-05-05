package com.juaracoding;

import com.juaracoding.Utils.Constants;
import com.juaracoding.Utils.Utils;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ManagementUnitPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class ManagementUnitTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static ManagementUnitPage managementUnitPage = new ManagementUnitPage();
    private static LoginPage loginPage = new LoginPage();

    public ManagementUnitTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
//    Scenario Filter Data
    @Given("I am on the unit page")
    public void i_am_on_the_unit_page(){
        driver.get(Constants.URL);
        loginPage.loginUsername("admin@hadir.com","MagangSQA_JC@123");
        extentTest.log(LogStatus.PASS,"I am on the unit page");
    }
    @When("I click login")
    public void i_click_login(){
        loginPage.setBtnSubmit();
        extentTest.log(LogStatus.PASS,"I click login");
    }
    @And("I click management")
    public void i_click_management(){
        managementUnitPage.setBtnManagement();
        Utils.delay(3);
        extentTest.log(LogStatus.PASS,"I click management");
    }
    @And("I click submenu unit")
    public void i_click_submenu_unit(){
        managementUnitPage.setBtnUnit();
        Utils.delay(3);
        extentTest.log(LogStatus.PASS,"I click submenu unit");
    }
    @And("I input unit valid")
    public void i_input_unit_valid(){
        managementUnitPage.setSearch("Kopi Item");
        extentTest.log(LogStatus.PASS,"I input unit");
    }
    @And("I click searching unit")
    public void i_click_searching_unit(){
        managementUnitPage.setBtnSearch();
        extentTest.log(LogStatus.PASS,"I click searching unit");
    }
    @Then("I see unit valid")
    public void i_see_unit_valid(){
        Utils.delay(5);
        String tableRowText = managementUnitPage.getTableRowText(0);
        System.out.println(tableRowText);
        assertTrue(tableRowText != null && !tableRowText.isEmpty(),"Table row should not be null or empty");
        extentTest.log(LogStatus.PASS,"I see unit valid");
    }

    //Scenario Reset
    @When("I click button reset")
    public void i_click_button_reset(){
        Utils.delay(3);
        managementUnitPage.setReset();
        extentTest.log(LogStatus.PASS,"I click button reset");
    }
    @Then("I see all unit on page unit")
    public void i_see_all_unit_on_page_unit(){
        Utils.delay(5);
        String tableRowText = managementUnitPage.getTableRowText(1);
        System.out.println(tableRowText);
        Assert.assertNotNull(tableRowText,"The table displays all the data");
        extentTest.log(LogStatus.PASS,"I see all unit on page unit");
    }

    //Scenario Added Unit Data Valid
    @When("I click button add data unit")
    public void i_click_button_add_data_unit(){
        Utils.delay(2);
        managementUnitPage.setBtnTambah();
        extentTest.log(LogStatus.PASS,"I click button add data unit");
    }
    @And("I fill form add data valid")
    public void i_fill_form_add_data_valid(){
        managementUnitPage.addUnit("Kopi Susu","Zack","Cuti Hamil",
                "Lembur Juara Coding","3");
        extentTest.log(LogStatus.PASS,"I fill form add data valid");
    }
    @Then("I see message success added")
    public void i_see_message_berhasil_menambahkan_data(){
        Utils.delay(3);
        Assert.assertEquals(managementUnitPage.getTxtDataSuccess(),"Berhasil Menambahkan Unit");
        extentTest.log(LogStatus.PASS,"I see message success added");
    }

    //Scenario Added Unit Data invalid
    @When("I click button add data unit invalid")
    public void i_click_button_add_data_unit_invalid(){
        Utils.delay(2);
        managementUnitPage.setBtnTambah();
        extentTest.log(LogStatus.PASS,"I click button add data unit invalid");
    }
    @And("Im not fill in the data unit name")
    public void im_not_fill_in_the_data_unit_name(){
        Utils.delay(2);
        managementUnitPage.addUnit("","Zack","Cuti Hamil",
                "Lembur Juara Coding","3");
        extentTest.log(LogStatus.PASS,"Im not fill in the data unit name");
    }
    @Then("I see message invalid added")
    public void i_see_message_invalid_added(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtInvalidFormUnit(),"Nama unit tidak boleh kosong!.");
        managementUnitPage.setBtnBatal();
        extentTest.log(LogStatus.PASS,"I see message invalid added");
    }
//    Scenario I added and did not fill in the data lokasi tetap aturan cuti and unit kalender
    @When("I click button add data unit invalid 2")
    public void i_click_button_add_data_unit_invalid_2(){
        managementUnitPage.setBtnTambah();
        extentTest.log(LogStatus.PASS,"I click button add data unit invalid 2");
    }
    @And("Im not input lokasi tetap and unit kalender also aturan cuti")
    public void im_not_input_lokasi_tetap_and_unit_kalender_also_aturan_cuti(){
        Utils.delay(2);
        managementUnitPage.addUnit("Juara Coding","","","","");
        extentTest.log(LogStatus.PASS,"Im not input lokasi tetap and unit kalender also aturan cuti");
    }
    @Then("I see message Berhasil Menambahkan Unit")
    public void i_see_message_Berhasil_Menambahkan_Unit(){
        Utils.delay(2);
        Assert.assertTrue(managementUnitPage.getErrorMessages().size() > 0 && managementUnitPage.getErrorMessages().get(0).isDisplayed(),
                "BUG: Pesan error validasi tidak muncul padahal field mandatory kosong 'pilih unit kalender, lokasi absen tetap, aturan cuti");
        System.out.println("Validasi field mandatory bekerja dengan benar (pesan error muncul)");
        extentTest.log(LogStatus.PASS,"I see message Berhasil Menambahkan Unit");
    }

    //Scenario I added a new shift
    @When("I click button action")
    public void i_click_button_action(){
        managementUnitPage.setSearch("Kopi Susu");
        Utils.delay(2);
        managementUnitPage.setBtnSearch();
        Utils.delay(2);
        managementUnitPage.setBtnAction();
        extentTest.log(LogStatus.PASS,"I click button action");
    }
    @And("I click button shift")
    public void i_click_button_shift(){
        managementUnitPage.setShift();
        extentTest.log(LogStatus.PASS,"I click button shift");
    }
    @And("I click button add a new shift")
    public void i_click_button_add_a_new_shift(){
        Utils.delay(2);
        managementUnitPage.setAddShift();
        extentTest.log(LogStatus.PASS,"I click button add a new shift");
    }
    @And("I fill a new shift")
    public void i_fill_a_new_shift(){
        Utils.delay(2);
        managementUnitPage.fillShift("Shift baru");
        extentTest.log(LogStatus.PASS,"I fill a new shift");
    }
    @Then("I see message success added a new shift")
    public void i_see_message_success_added_a_new_shift(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtAddShiftSuccess(),"Berhasil Menambahkan Shift Type");
        extentTest.log(LogStatus.PASS,"I see message success added a new shift");
    }

    //I added a new shift but no input shift name
    @When("I click button added a new shift")
    public void i_click_button_added_a_new_shift(){
        managementUnitPage.setAddShift();
        extentTest.log(LogStatus.PASS,"I click button added a new shift");
    }
    @And("Im not fill a new shift name")
    public void im_not_fill_a_new_shift_name(){
        managementUnitPage.fillShift("");
        extentTest.log(LogStatus.PASS,"Im not fill a new shift name");
    }
    @Then("I see message invalid added a new shift")
    public void i_see_message_invalid_added_a_new_shift(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtInvalidShift(),"Nama Shift tidak boleh kosong!.");
        managementUnitPage.setBtnBatalShift();
        Utils.delay(2);
        extentTest.log(LogStatus.PASS,"I see message invalid added a new shift");
    }

    //Scenario I added additional work hours
    @When("I click the action button on the new shift")
    public void i_click_the_action_button_on_the_new_shift(){
        Utils.delay(2);
        managementUnitPage.setBtnActionAddJamKerjaShifting();
        extentTest.log(LogStatus.PASS,"I click the action button on the new shift");
    }
    @And("I click button view on new shift")
    public void i_click_button_view_on_new_shift(){
        Utils.delay(2);
        managementUnitPage.setBtnView();
        extentTest.log(LogStatus.PASS,"I click button view on new shift");
    }
    @And("I click button add on shift")
    public void I_click_button_add_on_shift(){
        Utils.delay(2);
        managementUnitPage.setBtnAddJamkerja();
        extentTest.log(LogStatus.PASS,"I click button add on shift");
    }
    @And("I input additional working hours")
    public void i_input_additional_working_hours(){
        Utils.delay(2);
        managementUnitPage.setInputJamKerjaTambah();
        extentTest.log(LogStatus.PASS,"I input additional working hours");
    }
    @Then("I see message Berhasil Menambah Type Detail Shift")
    public void i_see_message_Success_Added_Type_Detail_Shift(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtBerhasilTambahJamKerja(),"Berhasil Menambahkan Type Detail Shift");
        extentTest.log(LogStatus.PASS,"I see message Berhasil Menambah Type Detail Shift");
    }

    //I added additional work hours but not input shifting
    @When("I click button add shift")
    public void i_click_button_add_shift(){
        Utils.delay(2);
        managementUnitPage.setBtnAddJamkerja();
        extentTest.log(LogStatus.PASS,"I click button add shift");
    }
    @And("Im not input additional work hours")
    public void im_not_input_additional_work_hours(){
        Utils.delay(2);
        managementUnitPage.setBtnTambahJamKerja();
        extentTest.log(LogStatus.PASS,"Im not input additional work hours");
    }
    @Then("I see message shifting id is a required field")
    public void i_see_message_shifting_id_is_a_required_field(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtErrorShifting(),"shifting_id is a required field");
        managementUnitPage.setBtnBatalShift();
        extentTest.log(LogStatus.PASS,"I see message shifting id is a required field");
    }

    //Scenario I delete additional work hours
    @When("I click button action on additional work hours")
    public void i_click_button_action_on_additional_work_hours(){
        Utils.delay(2);
        managementUnitPage.setBtnAction();
        extentTest.log(LogStatus.PASS,"I click button action on additional work hours");
    }
    @And("I click button delete additional work hours")
    public void i_click_button_delete_additional_work_hours(){
        Utils.delay(2);
        managementUnitPage.setBtnDelete();
        extentTest.log(LogStatus.PASS,"I click button delete additional work hours");
    }
    @Then("I click button hapus")
    public void i_click_button_hapus(){
        Utils.delay(2);
        managementUnitPage.setBtnHapus();
        extentTest.log(LogStatus.PASS,"I click button hapus");
    }

    //Scenario Im  not input virtual id
    @When("I go to unit page")
    public void i_go_to_unit_page(){
        Utils.delay(2);
        managementUnitPage.setBtnManagement();
        managementUnitPage.setBtnUnit();
        extentTest.log(LogStatus.PASS,"I click button menu management and submenu unit");
    }
    @And("I filter unit")
    public void i_filter_unit(){
        Utils.delay(2);
        managementUnitPage.setSearch("Kopi Susu");
        managementUnitPage.setBtnSearch();
        extentTest.log(LogStatus.PASS,"I filter username unit");
    }
    @And("I click button action virtual ID")
    public void i_click_button_action_virtual_ID(){
        Utils.delay(1);
        managementUnitPage.setBtnAction();
        extentTest.log(LogStatus.PASS,"I click button action in virtual ID");
    }
    @And("I click button Virtual ID")
    public void i_click_button_virtual_ID(){
        Utils.delay(1);
        managementUnitPage.setbtnVirtual();
        extentTest.log(LogStatus.PASS,"I click button virtual ID");
    }

    @And("I click button save")
    public void i_click_button_save(){
        Utils.delay(2);
        managementUnitPage.setAtur();
        extentTest.log(LogStatus.PASS,"I click button atur");
    }
    @Then("I see message Foto tidak boleh kosong")
    public void I_see_message_foto_tidak_boleh_kosong(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtInvalidFoto(),"Foto tidak boleh kosong");
        Utils.delay(2);
        managementUnitPage.setBtnBatalVirtualID();
        extentTest.log(LogStatus.PASS,"I see message Foto tidak boleh kosong");
    }

    //Scenario I uploaded a file that exceeds the capacity.
    @When("I click virtual button")
    public void i_click_virtual_button(){
        Utils.delay(1);
        managementUnitPage.setbtnVirtual();
        extentTest.log(LogStatus.PASS,"I click virtual button");
    }
    @And("I upload file that exceeds the capacity")
    public void i_upload_file_that_exceeds_the_capacity(){
        Utils.delay(1);
        managementUnitPage.setMaxVirtual();
        extentTest.log(LogStatus.PASS,"I upload file that exceeds the capacity");
    }
    @And("I click button choose colour")
    public void i_click_button_choose_colour(){
        Utils.delay(1);
        managementUnitPage.setBtnWarna();
        extentTest.log(LogStatus.PASS,"I click button choose colour");
    }
    @And("I fill colour footer")
    public void i_fill_colour_footer(){
        Utils.delay(1);
        managementUnitPage.setGradient();
        managementUnitPage.setDragAndDrop();
        extentTest.log(LogStatus.PASS,"I fill colour footer");
    }
    @And("I click button submit")
    public void i_click_button_submit(){
        Utils.delay(1);
        managementUnitPage.setAtur();
        extentTest.log(LogStatus.PASS,"I click button submit");
    }
    @Then("I see message Foto tidak boleh kosong 2")
    public void i_see_message_Foto_tidak_boleh_kosong_2(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtInvalidFoto(),"Foto tidak boleh kosong");
        managementUnitPage.setBtnBatalVirtualID();
        extentTest.log(LogStatus.PASS,"I see message Foto tidak boleh kosong 2");
    }

    //Scenario I input virtual id valid
    @When("I click button virtual")
    public void i_click_button_virtual(){
        Utils.delay(1);
        managementUnitPage.setbtnVirtual();
        extentTest.log(LogStatus.PASS,"I click button virtual");
    }
    @And("I click button pilih foto")
    public void i_click_button_pilih_foto(){
        Utils.delay(1);
        managementUnitPage.setVirtualId();
        extentTest.log(LogStatus.PASS,"I click button pilih foto");
    }
    @And("I click button warna")
    public void i_click_button_warna(){
        Utils.delay(1);
        managementUnitPage.setBtnWarna();
        extentTest.log(LogStatus.PASS,"I click button warna");
    }
    @And("I choose colour")
    public void i_choose_colour(){
        managementUnitPage.setGradient();
        managementUnitPage.setDragAndDrop();
        extentTest.log(LogStatus.PASS,"I choose colour");
    }
    @And("I click button atur")
    public void i_click_button_atur(){
        Utils.delay(2);
        managementUnitPage.setAtur();
        extentTest.log(LogStatus.PASS,"I click button atur");
    }
    @Then("I see message Berhasil Mengatur Virtual ID")
    public void I_see_message_Berhasil_Mengatur_Virtual_ID(){
        Utils.delay(2);
        Assert.assertEquals(managementUnitPage.getTxtVirtualSuccess(),"Berhasil Mengatur Virtual ID");
        extentTest.log(LogStatus.PASS,"I see message Berhasil Mengatur Virtual ID");
    }
}
