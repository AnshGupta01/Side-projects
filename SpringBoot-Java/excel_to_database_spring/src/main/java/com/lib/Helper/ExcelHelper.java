package com.lib.Helper;

import com.lib.Entity.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    //checking for file format
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        return (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
    }

    //convert excel to list of products
    public static List<Product> convertExcelToListOfProduct(InputStream is) {
        List<Product> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cell = nextRow.iterator();

                int cid = 0;
                Product p = new Product();

                while (cell.hasNext()) {
                    Cell cells = cell.next();
                    switch (cid) {
                        case 0:
                            p.setProduct_id((int) cells.getNumericCellValue());
                            break;
                        case 1:
                            p.setProduct_name(cells.getStringCellValue());
                            break;
                        case 2:
                            p.setProduct_desc(cells.getStringCellValue());
                            break;
                        case 3:
                            p.setProduct_price(cells.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
