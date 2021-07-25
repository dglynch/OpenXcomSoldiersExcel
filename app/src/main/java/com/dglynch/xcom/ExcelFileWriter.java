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
        headerRow.createCell(0).setCellValue("Id");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Base");
        headerRow.createCell(3).setCellValue("Rank");
        headerRow.createCell(4).setCellValue("Missions");
        headerRow.createCell(5).setCellValue("Kills");
        headerRow.createCell(6).setCellValue("Days Wounded");
        headerRow.createCell(7).setCellValue("Time Units");
        headerRow.createCell(8).setCellValue("Stamina");
        headerRow.createCell(9).setCellValue("Health");
        headerRow.createCell(10).setCellValue("Bravery");
        headerRow.createCell(11).setCellValue("Reactions");
        headerRow.createCell(12).setCellValue("Firing");
        headerRow.createCell(13).setCellValue("Throwing");
        headerRow.createCell(14).setCellValue("Melee");
        headerRow.createCell(15).setCellValue("Strength");
        headerRow.createCell(16).setCellValue("PSI Strength");
        headerRow.createCell(17).setCellValue("PSI Skill");
        headerRow.createCell(18).setCellValue("Score");

        int rowCount = 0;
        for (Soldier soldier : soldiers) {
            Row row = sheet.createRow(++rowCount);
            row.createCell(0).setCellValue(soldier.getId());
            row.createCell(1).setCellValue(soldier.getName());
            row.createCell(2).setCellValue(soldier.getBase());
            row.createCell(3).setCellValue(soldier.getRank());
            row.createCell(4).setCellValue(soldier.getMissions());
            row.createCell(5).setCellValue(soldier.getKills());
            if (soldier.getRecovery() > 0) {
                row.createCell(6).setCellValue(soldier.getRecovery());
            }
            row.createCell(7).setCellValue(soldier.getTimeUnits());
            row.createCell(8).setCellValue(soldier.getStamina());
            row.createCell(9).setCellValue(soldier.getHealth());
            row.createCell(10).setCellValue(soldier.getBravery());
            row.createCell(11).setCellValue(soldier.getReactions());
            row.createCell(12).setCellValue(soldier.getFiring());
            row.createCell(13).setCellValue(soldier.getThrowing());
            row.createCell(14).setCellValue(soldier.getMelee());
            row.createCell(15).setCellValue(soldier.getStrength());
            if (soldier.getPsiSkill() > 0) {
                row.createCell(16).setCellValue(soldier.getPsiStrength());
                row.createCell(17).setCellValue(soldier.getPsiSkill());
            }
            row.createCell(18).setCellValue(soldier.getPromotionScore());
        }

        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        workbook.write(outputStream);
    }
}
