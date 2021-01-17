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

    //file imports
    private static final String FILE_NAME = Constants.file1;
    public static final String FILE_NAME1 = Constants.file3;

    public static  String corp_name;

    //list for csv file
    public static  List<String> result = new ArrayList<String>();

    //for looping through the payment_details
    public static  HashMap<String, HashMap> payment_details = new HashMap<String, HashMap>();

    // Creating payment details of all individuals and headerTabs
    public static List<String> headerTabs = new ArrayList<String>();

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(FILE_NAME));

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Creating DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        //Obtaining a rowIterator and columnIterator and iterate over them
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();




        // Variable to denote first iteration to fetch header Tabs
        Boolean firstInitiative = true;


        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            // Hashmap to store each individual
            HashMap<String, String> personPaymentDetails = new HashMap<String, String>();

            // re-Initiating notation variables
            boolean userIdObtained = false;
            Integer rowLength = 0;
            String userId = "1";

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
                result.add(cellValue + ",");
                if (firstInitiative) { // used to fetch the header cells
                    headerTabs.add(cellValue);
                } else {
                    if (!userIdObtained) { // used to obtain the userId for a individual
                        userId = cellValue;
                        userIdObtained = true;
                    }
                    personPaymentDetails.put(headerTabs.get(rowLength++),cellValue); //assigning the cells to individual hashmap
                }
            }
            firstInitiative = false;
            payment_details.put(userId,personPaymentDetails); // mapping individual hashmap to overall hashmap
            System.out.println();
            
        }

        System.out.println("\n\nDetails stored in hash map as key,value pairs\n");

        //printing the list
        for(String id: payment_details.keySet()) {
            HashMap userDetails;
            userDetails = payment_details.get(id);
            System.out.println(userDetails);
        }

        List<String>sub_list = result.subList(6,result.size());

        System.out.println("\n\nDetails stored in list as comma seperated values\n");
        for(String ans: sub_list)
            System.out.print(ans);
        //System.out.println("\n" + "Data --> "+sub_list.get(0));

        //CSV Writer
        FileWriter writer = new FileWriter(FILE_NAME1);

        writer.write(sub_list.stream().collect(Collectors.joining()));
        writer.close();

        System.out.println("\n\nFile name and corporate name\n");

        //----------------------
        //gives file name
        String corp_file = charRemoveAt(FILE_NAME, 15);

        System.out.println("File Name --> " +corp_file);

        //To grab the corporate name
        int name_end = corp_file.indexOf("_");

        if(name_end != -1) {
            corp_name = corp_file.substring(0, name_end);
        }
        System.out.println("Corporate Name --> "+ corp_name);

        //----------------------

        BankController obj = new BankController();
        obj.addDetails();

    }

    //function to eliminate the path --> gives file name
    public static String charRemoveAt(String str, int p) {
        return  str.substring(p + 1);
    }

}