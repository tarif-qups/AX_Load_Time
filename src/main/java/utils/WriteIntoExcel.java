package utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteIntoExcel {
    public void writeData(List<String> events, List<Long> timestamp, List<Long> duration) throws IOException {
        File file = new File("./data/AX_Load_Time.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Load Time");
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("Event Name");
        row.createCell(1).setCellValue("Timestamp");
        row.createCell(2).setCellValue("Duration");

        for (int i = 0; i<3; i++) {
            XSSFCellStyle cellStyle = wb.createCellStyle();
            XSSFFont font = wb.createFont();
            font.setBold(true);
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 11);
            cellStyle.setFont(font);
            cellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            row.getCell(i).setCellStyle(cellStyle);
        }

        for (int j = 0; j<events.size(); j++){
            Row row1 = sheet.createRow(j+1);

            row1.createCell(0).setCellValue(events.get(j));
            row1.createCell(1).setCellValue(timestamp.get(j));
            row1.createCell(2).setCellValue(duration.get(j));
        }

        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);
        fos.close();
    }
}
