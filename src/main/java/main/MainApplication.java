package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

//apache poi imports
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

public class MainApplication  {

    private static final String FILE_NAME = Constants.file1;
    public static  String corp_name;
    public static  List<String> result = new ArrayList<String>();
    public static String[] arr = {};
    public static final String file3 = Constants.file3;


    public static void main(String[] args) throws IOException, InvalidFormatException {

        FileWriter writer = new FileWriter("K:/Work/Clayfin/WIPRO_23614.csv");


        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(FILE_NAME));

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Creating DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        //obtaining a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();


            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
                result.add(cellValue + ",");

            }

            System.out.println();
        }

        //printing the list
//        for(String ans: result)
//            System.out.print(ans);


        List<String>sub_list = result.subList(6,result.size());
        //sub_list.remove(sub_list.size() - 1);

        for(String ans: sub_list)
            System.out.print(ans);

//        String collect = sub_list.stream().collect(Collectors.joining(","));
//        System.out.println(collect);

        writer.write(sub_list.stream().collect(Collectors.joining()));
        writer.close();

//        System.out.println("\n" + "Data --> "+sub_list.get(0));

        //----------------------
        //gives file name
        String corp_file = charRemoveAt(FILE_NAME, 15);

        System.out.println("\n" + "\n" + "File Name --> " +corp_file);

        //To grab the corporate name
        int name_end = corp_file.indexOf("_");

        if(name_end != -1) {
            corp_name = corp_file.substring(0, name_end);
        }
        System.out.println("Corporate Name --> "+ corp_name);

        //----------------------

    }

    //function to eliminate the path --> gives file name
    public static String charRemoveAt(String str, int p) {
        return  str.substring(p + 1);
    }



}
