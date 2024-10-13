package excel;
// Java Program to Illustrate Reading
// Data to Excel File Using Apache POI

// Import statements

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {


    // Main driver method
    public static void main(String[] args) {
        List<Object> cellList = new ArrayList<>();

        // Try block to check for exceptions
        try {

            // Reading file from local directory
            FileInputStream file = new FileInputStream(
                    new File("gfgcontribute.xlsx"));

            // Create Workbook instance holding reference to
            // .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            // Till there is an element condition holds true
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();


                // For each row, iterate through all the
                // columns
                Iterator<Cell> cellIterator
                        = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            cellList.add(cell.getNumericCellValue());
                            break;
                        case STRING:
                            cellList.add(cell.getStringCellValue());
                            break;
                    }

                }


                System.out.println("");
            }

            // Closing file output streams
            file.close();
            System.out.println(cellList);
        }

        // Catch block to handle exceptions
        catch (Exception e) {

            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }
}


