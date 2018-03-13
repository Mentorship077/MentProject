package axcontrol;

import axcontrol.po.Axcontrol;
import com.mentProject.gmail.core.driver.WebDriverManager;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String URL = "https://www.axcontrol.com/";
    private static Workbook wb = new XSSFWorkbook();
    private static String relianceElectric = "relianceElectric";

    public static void main(String[] args) throws IOException {
        Axcontrol axcontrol = new Axcontrol();
        WebDriverManager.gotoURL(URL);
        axcontrol.clickRelianceElectric();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet(relianceElectric);
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Title");
        row.createCell(1).setCellValue("Description");

//
        List<WebElement> list = axcontrol.getProductTitle();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(axcontrol.getProductTitle().get(i).getText());
            row1.createCell(1).setCellValue(axcontrol.getProductDescription().get(i).getText());
        }

        WebDriverManager.quitTheBrowser();

        Main main = new Main();
        main.writeInFile("Axcontrols.xlsx");
    }

    public void newSheet(String sheetName) throws IOException {

//        // Create a row and put some cells in it. Rows are 0 based.
//        Row row = sheet.createRow(0);
//        // Create a cell and put a value in it.
//        row.createCell(0).setCellValue(1);
//        row.createCell(1).setCellValue(1.2);
//        row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string"));
//        row.createCell(3).setCellValue(true);


    }

    public void writeInFile(String fileName) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        wb.write(fileOut);
        fileOut.close();
    }
}
