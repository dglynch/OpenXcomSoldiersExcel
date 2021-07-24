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
        headerRow.createCell(2).setCellValue("Base");
        headerRow.createCell(3).setCellValue("Rank");
        headerRow.createCell(4).setCellValue("Time Units");
        headerRow.createCell(5).setCellValue("Stamina");
        headerRow.createCell(6).setCellValue("Health");
        headerRow.createCell(7).setCellValue("Bravery");
        headerRow.createCell(8).setCellValue("Reactions");
        headerRow.createCell(9).setCellValue("Firing");
        headerRow.createCell(10).setCellValue("Throwing");
        headerRow.createCell(11).setCellValue("Strength");
        headerRow.createCell(12).setCellValue("PSI Strength");
        headerRow.createCell(13).setCellValue("PSI Skill");
        headerRow.createCell(14).setCellValue("Melee");
        headerRow.createCell(15).setCellValue("Missions");
        headerRow.createCell(16).setCellValue("Kills");

        int rowCount = 0;
        for (Soldier soldier : soldiers) {
            Row row = sheet.createRow(++rowCount);
            row.createCell(0).setCellValue(soldier.getId());
            row.createCell(1).setCellValue(soldier.getName());
            row.createCell(2).setCellValue(soldier.getBase());
            row.createCell(3).setCellValue(soldier.getRank());
            row.createCell(4).setCellValue(soldier.getTimeUnits());
            row.createCell(5).setCellValue(soldier.getStamina());
            row.createCell(6).setCellValue(soldier.getHealth());
            row.createCell(7).setCellValue(soldier.getBravery());
            row.createCell(8).setCellValue(soldier.getReactions());
            row.createCell(9).setCellValue(soldier.getFiring());
            row.createCell(10).setCellValue(soldier.getThrowing());
            row.createCell(11).setCellValue(soldier.getStrength());
            if (soldier.getPsiSkill() > 0) {
                row.createCell(12).setCellValue(soldier.getPsiStrength());
                row.createCell(13).setCellValue(soldier.getPsiSkill());
            }
            row.createCell(14).setCellValue(soldier.getMelee());
            row.createCell(15).setCellValue(soldier.getMissions());
            row.createCell(16).setCellValue(soldier.getKills());
        }

        sheet.autoSizeColumn(1);
        workbook.write(outputStream);
    }
}
