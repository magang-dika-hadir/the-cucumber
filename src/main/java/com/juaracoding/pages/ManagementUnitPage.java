package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;

public class ManagementUnitPage {
    private WebDriver driver;

    public ManagementUnitPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//p[normalize-space()='Management']")
    private WebElement btnManagement;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Unit']")
    private WebElement btnUnit;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement search;

    @FindBy(xpath = "//h6[text()='Kopi item']")
    private WebElement txtSuccessSearch;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement btnReset;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSearch;

    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement btnTambah;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputUnit;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement btnCheckbox;

    @FindBy(xpath = "//input[@id='calendar']")
    private WebElement inputCalender;

    @FindBy(xpath = "//input[@placeholder='Tambahkan Aturan Cuti']")
    private WebElement inputAturanCuti;

    @FindBy(xpath = "//input[@id='ot_reason']")
    private WebElement inputReason;

    @FindBy(xpath = "//input[@id='max_day_ot']")
    private WebElement inputMaxHariPengajuan;

    @FindBy(xpath = "//div[@id='ot_upload']")
    private WebElement dropDownLembur;

    @FindBy(xpath = "//li[@data-value='yes' and contains(text(), 'Ya')]")
    private WebElement inputYes;

    @FindBy(xpath = "//button[text()='Tambah']")
    private WebElement btnSave;

    @FindBy(xpath = "//button[@aria-label='action']")
    private WebElement btnAction;

    @FindBy(xpath = "//li[contains(@class, 'MuiMenuItem-root')]")
    private WebElement shift;

    @FindBy(xpath = "//button[text()='Tambahkan']")
    private WebElement addShift;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputShift;

    @FindBy(xpath = "//p[@id='name-helper-text']")
    private WebElement txtInvalidShift;

    @FindBy(xpath = "//button[text()='Tambah']")
    private WebElement btnTambahShift;

    @FindBy(xpath = "//li[text()='Edit']")
    private WebElement edit;

    @FindBy(xpath = "//li[text()='Delete']")
    private WebElement delete;

    @FindBy(xpath = "//li[text()='Atur Virtual ID']")
    private WebElement virtualId;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement pilihFoto;

    @FindBy(xpath = "//button[text()='Atur']")
    private WebElement atur;

    @FindBy(xpath = "//div[text()='Foto tidak boleh kosong']")
    private WebElement txtInvalidFoto;

    @FindBy(xpath = "//*[@id='name-helper-text']")
    private WebElement txtInvalidFormUnit;

    @FindBy(xpath = "//h6[text()='19 Nov 2024']")
    private WebElement txtTanggal;

    @FindBy(xpath = "//div[text()='Berhasil Menambahkan Unit']")
    private WebElement txtDataSuccess;

    @FindBy(xpath = "//button[text()='Batal']")
    private WebElement btnBatal;

    @FindBy(xpath = "//div[contains(@class, 'MuiSnackbarContent-message')]")
    private WebElement txtAddShiftSuccess;

    @FindBy(xpath = "//button[text()='Batal']")
    private WebElement btnBatalShift;

    @FindBy(xpath = "//button[@aria-label='action']//*[name()='svg']")
    private WebElement btnActionAddJamKerjaShifting;

    @FindBy(xpath = "//li[normalize-space(text())='View']")
    private WebElement btnView;

    @FindBy(xpath = "//button[@aria-label='Open']")
    private WebElement btnDropDownShift;

    @FindBy(xpath = "//ul[@role='listbox']//li[@role='option' and normalize-space(.)='BCA Life']")
    private WebElement inputJamKerjaTambah;

    @FindBy(xpath = "//button[normalize-space(text())='Tambah']")
    private WebElement btnTambahJamKerja;

    @FindBy(xpath = "//div[normalize-space(text())='Berhasil Menambahkan Type Detail Shift']")
    private WebElement txtBerhasilTambahJamKerja;

    @FindBy(xpath = "//p[@id='shifting_id-helper-text']")
    private WebElement txtErrorShifting;

    @FindBy(xpath = "//li[normalize-space(text())='Delete']")
    private WebElement btnDelete;

    @FindBy(xpath = "//button[normalize-space(text())='Hapus']")
    private WebElement btnHapus;

    @FindBy(xpath = "//div[text()='Berhasil Mengatur Virtual ID']")
    private WebElement txtVirtualSuccess;

    @FindBy(xpath = "errorName")
     List<WebElement> errorMessages;

    @FindBy(xpath = "//button[normalize-space(text())='Batal']")
    private WebElement btnBatalVirtualID;

    @FindBy(xpath = "//button[@data-testid='colorpicker-button']")
    private WebElement btnWarna;

    @FindBy(xpath = "//div[contains(@class,'muicc-hsvgradient')]")
    private WebElement gradient;

    @FindBy(xpath = "//div[@data-testid='hsvgradient-cursor']")
    private WebElement dragAndDrop;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> tableRows;


    public void setGradient(){
        Actions actions = new Actions(driver);
        actions.moveToElement(gradient,80,40).click().perform();
    }

    public void setDragAndDrop(){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(dragAndDrop,30,10).perform();
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }

    public void setBtnManagement(){

        btnManagement.click();
    }
    public void setBtnUnit(){

        btnUnit.click();
    }

    public void setSearch(String inputSearch){

        this.search.sendKeys(inputSearch);
    }
    public void setBtnSearch(){

        btnSearch.click();
    }

    public void setBtnWarna(){
        btnWarna.click();
    }

    public void setReset(){

        btnReset.click();
    }
    public void setBtnTambah(){

        btnTambah.click();
    }

    public void setBtnBatal(){

        btnBatal.click();
    }
    public void setBtnBatalVirtualID(){
        btnBatalVirtualID.click();
    }
    public void setBtnActionAddJamKerjaShifting(){
        btnActionAddJamKerjaShifting.click();
    }

    public void setBtnView(){
        btnView.click();
    }

    public void setBtnAddJamkerja(){
        btnTambah.click();
    }

    public void setInputJamKerjaTambah(){
        btnDropDownShift.click();
        inputJamKerjaTambah.click();
        btnTambahJamKerja.click();
    }
    public void setBtnTambahJamKerja(){
        btnTambahJamKerja.click();
    }
    public void setBtnDelete(){
        btnDelete.click();
    }
    public void setBtnHapus(){
        btnHapus.click();
    }

    public void addUnit(String namaUnit,String pilihUnitKalender,String aturanCuti, String overtimeReason,String maksHaripengajuan){
        this.inputUnit.sendKeys(namaUnit);
        btnCheckbox.click();
        this.inputCalender.sendKeys(pilihUnitKalender);
        this.inputAturanCuti.sendKeys(aturanCuti);
        this.inputReason.sendKeys(overtimeReason);
        this.inputMaxHariPengajuan.sendKeys(maksHaripengajuan);
        dropDownLembur.click();
        inputYes.click();
        btnSave.click();
    }

    public String getTableRowText(int rowIndex) {
        try {
            if (tableRows.isEmpty()) {
                System.out.println("Table is empty");
                return null;
            }

            if (rowIndex >= 0 && rowIndex < tableRows.size()) {
                return tableRows.get(rowIndex).getText();
            } else { //
                throw new IndexOutOfBoundsException("Row index out of bounds: " + rowIndex);
            }
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void setBtnAction(){

        btnAction.click();
    }

    public void setShift(){

        shift.click();
    }
    public void setAddShift(){

        addShift.click();
    }
    public void fillShift(String namaShift){
        this.inputShift.sendKeys(namaShift);
        btnTambahShift.click();
    }

    public void setEdit(String namaUnit,String pilihUnitKalender,String aturanCuti, String overtimeReason,String maksHaripengajuan){
        btnAction.click();
        edit.click();
        this.inputUnit.sendKeys();
        btnCheckbox.click();
        this.inputCalender.sendKeys();
        this.inputAturanCuti.sendKeys();
        this.inputReason.sendKeys();
        this.inputMaxHariPengajuan.sendKeys();
        dropDownLembur.click();
        inputYes.click();
        btnSave.click();
    }

    public void setMaxVirtual(){
        File file = new File("C:\\Users\\Respati.DESKTOP-QMOIPL0.000\\Downloads\\test 2.jpg");
        pilihFoto.sendKeys(file.getAbsolutePath());
    }

    public void setVirtualId(){
        File file = new File("C:\\Users\\Respati.DESKTOP-QMOIPL0.000\\Downloads\\SS 1.png");
        pilihFoto.sendKeys(file.getAbsolutePath());
    }

    public void setAtur(){
        atur.click();
    }

    public void setbtnVirtual(){
        virtualId.click();
    }
    public void setBtnBatalShift(){
        btnBatalShift.click();
    }

    public String getTxtSuccessSearch(){
        return txtSuccessSearch.getText();
    }
    public String getTxtInvalidFoto(){

        return txtInvalidFoto.getText();
    }
    public String getTxtInvalidShift(){

        return txtInvalidShift.getText();
    }

    public String getTxtInvalidFormUnit(){

        return txtInvalidFormUnit.getText();
    }
    public String getTxtBerhasilTambahJamKerja(){
        return txtBerhasilTambahJamKerja.getText();
    }

    public String getTxtTanggal(){
        return txtTanggal.getText();
    }

    public String getTxtDataSuccess(){
        return txtDataSuccess.getText();
    }

    public String getTxtAddShiftSuccess(){
        return txtAddShiftSuccess.getText();
    }
    public String getTxtErrorShifting(){
        return txtErrorShifting.getText();
    }
    public String getTxtVirtualSuccess(){
        return txtVirtualSuccess.getText();
    }
}
