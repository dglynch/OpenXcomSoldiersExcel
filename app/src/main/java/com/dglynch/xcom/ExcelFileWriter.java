/*
    Copyright 2021 Dan Lynch

    This file is part of OpenXcom Soldiers Excel.

    OpenXcom Soldiers Excel is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by the Free
    Software Foundation, either version 3 of the License, or (at your option) any
    later version.

    This program is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
    FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
    details.

    You should have received a copy of the GNU General Public License along with
    this program; if not, see <http://www.gnu.org/licenses>.
*/

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
        int columnNumber = 0;
        headerRow.createCell(columnNumber++).setCellValue("Id");
        headerRow.createCell(columnNumber++).setCellValue("Name");
        headerRow.createCell(columnNumber++).setCellValue("Base");
        headerRow.createCell(columnNumber++).setCellValue("Rank");
        headerRow.createCell(columnNumber++).setCellValue("Missions");
        headerRow.createCell(columnNumber++).setCellValue("Kills");
        headerRow.createCell(columnNumber++).setCellValue("Days Wounded");
        headerRow.createCell(columnNumber++).setCellValue("PSI Training");
        headerRow.createCell(columnNumber++).setCellValue("Time Units");
        headerRow.createCell(columnNumber++).setCellValue("Stamina");
        headerRow.createCell(columnNumber++).setCellValue("Health");
        headerRow.createCell(columnNumber++).setCellValue("Bravery");
        headerRow.createCell(columnNumber++).setCellValue("Reactions");
        headerRow.createCell(columnNumber++).setCellValue("Firing");
        headerRow.createCell(columnNumber++).setCellValue("Throwing");
        headerRow.createCell(columnNumber++).setCellValue("Melee");
        headerRow.createCell(columnNumber++).setCellValue("Strength");
        headerRow.createCell(columnNumber++).setCellValue("PSI Strength");
        headerRow.createCell(columnNumber++).setCellValue("PSI Skill");
        //noinspection UnusedAssignment
        headerRow.createCell(columnNumber++).setCellValue("Score");

        int rowCount = 0;
        for (Soldier soldier : soldiers) {
            Row row = sheet.createRow(++rowCount);
            columnNumber = 0;
            row.createCell(columnNumber++).setCellValue(soldier.getId());
            row.createCell(columnNumber++).setCellValue(soldier.getName());
            row.createCell(columnNumber++).setCellValue(soldier.getBase());
            row.createCell(columnNumber++).setCellValue(soldier.getRank());
            row.createCell(columnNumber++).setCellValue(soldier.getMissions());
            row.createCell(columnNumber++).setCellValue(soldier.getKills());
            if (soldier.getRecovery() > 0) {
                row.createCell(columnNumber).setCellValue(soldier.getRecovery());
            }
            columnNumber++;
            if (soldier.getPsiTraining()) {
                row.createCell(columnNumber).setCellValue(soldier.getPsiTraining());
            }
            columnNumber++;
            row.createCell(columnNumber++).setCellValue(soldier.getTimeUnits());
            row.createCell(columnNumber++).setCellValue(soldier.getStamina());
            row.createCell(columnNumber++).setCellValue(soldier.getHealth());
            row.createCell(columnNumber++).setCellValue(soldier.getBravery());
            row.createCell(columnNumber++).setCellValue(soldier.getReactions());
            row.createCell(columnNumber++).setCellValue(soldier.getFiring());
            row.createCell(columnNumber++).setCellValue(soldier.getThrowing());
            row.createCell(columnNumber++).setCellValue(soldier.getMelee());
            row.createCell(columnNumber++).setCellValue(soldier.getStrength());
            if (soldier.getPsiSkill() > 0) {
                row.createCell(columnNumber).setCellValue(soldier.getPsiStrength());
                row.createCell(columnNumber + 1).setCellValue(soldier.getPsiSkill());
            }
            columnNumber += 2;
            //noinspection UnusedAssignment
            row.createCell(columnNumber++).setCellValue(soldier.getPromotionScore());
        }

        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        workbook.write(outputStream);
    }
}
