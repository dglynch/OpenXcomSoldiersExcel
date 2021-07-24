package com.dglynch.xcom;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelFileWriter {
    public static void writeSoldiers(List<Soldier> soldiers, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("Name");

        int rowCount = 0;
        for (Soldier soldier : soldiers) {
            Row row = sheet.createRow(++rowCount);
            row.createCell(0).setCellValue(rowCount);
            row.createCell(1).setCellValue(soldier.getName());
        }

        for (int i = 0; i < 2; i++) {
            sheet.autoSizeColumn(i);
        }
        workbook.write(outputStream);
    }
}
