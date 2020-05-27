package com.cybertek.tests.day19_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2:sheet that we want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //how many rows in the sheet
        System.out.println("Row count = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("Column count = " + qa3short.columnCount());

        //get all column names
        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());
        System.out.println("qa3short.getColumnsNames().get(0) = " + qa3short.getColumnsNames().get(0));

        //get all data in list of maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        System.out.println("dataList.get(0) = " + dataList.get(0));
        System.out.println("dataList.get(2).get(\"firstname\") = " + dataList.get(2).get("firstname"));
        

        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);
        }

        //get all data in 2d array
        String[][] dataArray = qa3short.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray)); //row by row



    }
}

