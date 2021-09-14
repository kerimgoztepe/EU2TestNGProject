package com.cybertek.tests.HW;


import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaturdayListCheck {
    @Test
    public void Canvas() throws IOException {

        String path = "C:\\Users\\LENOVO\\IdeaProjects\\EU2TestNGProject\\src\\test\\resources\\dersler.xlsx";
        Workbook workbook = WorkbookFactory.create(new File(path));
        Sheet weeklyList = workbook.getSheet("Saturday");
        int lastRow1 = weeklyList.getLastRowNum();
        //***********************************************/
        Sheet studentList = workbook.getSheet("maillist");
        //***********************************************/
        int lastRow2 = studentList.getLastRowNum();

        ArrayList<Cell> everyoneList = new ArrayList<>();
        ArrayList<Cell> myStudentList = new ArrayList<>();

        for (int i = 1; i <= lastRow1; i++) {
            everyoneList.add(weeklyList.getRow(i).getCell(1));
        }

        for (int i = 1; i <= lastRow2; i++) {
            myStudentList.add(studentList.getRow(i).getCell(0));
        }
        int z = 0;
        for (Cell cell : myStudentList) {
            System.out.printf("%02d",++z);
            boolean exists = false;
            for (int i = 0; i < everyoneList.size(); i++) {
                if (everyoneList.get(i).getStringCellValue().equals(cell.getStringCellValue())) {
                    DataFormatter formatter = new DataFormatter();
                    //creating formatter using the default locale
                    String cellValue = formatter.formatCellValue(weeklyList.getRow(i + 1).getCell(2));
                    //Returns the formatted value of a cell as a String regardless of the cell type.
                    System.out.println(" +++   " + weeklyList.getRow(i + 1).getCell(0).getStringCellValue() + " " + cellValue);
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                System.out.println(" ---   " + cell.getStringCellValue());
            }
        }
    }

}
