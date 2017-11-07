/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.DAL;

import inn2powerd.BE.Company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ddose
 */
public class DataManager
{

    public ObservableList<Company> getAllCompanies()
    {
        ObservableList<Company> data = FXCollections.observableArrayList();

        try (BufferedReader CSVFile = new BufferedReader(new FileReader("companies.csv")))
        {
            String dataRow = CSVFile.readLine();
            dataRow = CSVFile.readLine(); // Skip header
            while (dataRow != null)
            {
                String[] dataArray = dataRow.split(",");
                data.add(new Company(
                        Integer.parseInt(dataArray[0]),
                        dataArray[1],
                        dataArray[2],
                        dataArray[3],
                        dataArray[4],
                        Double.parseDouble(dataArray[5]),
                        Double.parseDouble(dataArray[6]),
                        Integer.parseInt(dataArray[7])));
                dataRow = CSVFile.readLine(); // Read next line of data.
            }
            return data;
        } catch (IOException ioe)
        {
            System.out.println("IO exception in DataManager: Returning null!" + ioe);
            return null;
        }

    }
}
