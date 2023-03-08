package DataDrivenFramework;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLUtility {
    /*
    Excel utility için oluşturduğumuz class aşağıdaki gibidir. Üç adet metot var bu metotlar bize excel sayfasındaki sütun sayısı,
     satır sayısını ve herhangi bir hücredeki veriyi döndürmektedir.
     */
    public FileInputStream fi;
    public Workbook workbook;
   public Sheet sheet;
   public Row row;
   public Cell cell;


    String path;
    XLUtility(String path){
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
     //Dosyaya eriştiğimiz kısım
        fi=new FileInputStream(path);
     //Dosyayı workbook olarak okuyoruz
        workbook= WorkbookFactory.create(fi);
      //Workbook'taki sheet'e erişme
       sheet=workbook.getSheet(sheetName);
        int rowcount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException{
        fi=new FileInputStream(path);
        workbook= WorkbookFactory.create(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rowNum);
        int cellcount=row.getLastCellNum(); //Bir satırdaki sütun sayısını alıyoruz
        workbook.close();
        fi.close();
        return cellcount;
    }

    public String gellCellData(String sheetName, int rowNum, int colNum) throws IOException{
        fi=new FileInputStream(path);
        workbook= WorkbookFactory.create(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rowNum);
        cell=row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try{
            data = formatter.formatCellValue(cell);
        }
        catch(Exception e)
        {
            data="";
        }
        workbook.close();
        fi.close();
        return data;
    }
}

