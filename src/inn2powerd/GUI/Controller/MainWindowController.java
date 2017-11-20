/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.GUI.Controller;

import inn2powerd.BE.Company;
import inn2powerd.DAL.DataManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ddose
 */
public class MainWindowController implements Initializable
{

    public String getName;
    public String getID;

    private Label label;
    @FXML
    private Accordion tPanes;
    @FXML
    private TextField txtText;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtDeleteCompany;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {

            DataManager dm = new DataManager();
            List<Company> list = dm.getAllCompanies();
            for (Company company : list)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/inn2powerd/GUI/View/CompanyInfoWindow.fxml"));
                Pane infoWindow = loader.load();
                CompanyInfoWindowController CIWC = loader.getController();
                CIWC.setCompany(company);
                TitledPane pane = new TitledPane(company.getId() + "   -   " + company.getName(), infoWindow);
                tPanes.getPanes().add(pane);

                pane.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) ->
                {
                    if (isNowExpanded)
                    {
                        CIWC.showMap();
                    }
                });
                pane.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) ->
                {
                    if (wasExpanded)
                    {
                        CIWC.hideMap();
                    }
                });
            }

            //loadAllCompanies();
        } catch (IOException ex)
        {
//            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSearch(ActionEvent event)
    {

        try
        {
            DataManager dm = new DataManager();
            List<Company> list = dm.getAllCompanies();

            tPanes.getPanes().remove(0, tPanes.getPanes().size()); // Ask Stegger about this

            for (Company company : list)
            {
                getName = company.getName();
                getID = Integer.toString(company.getId());

                if (getName.toLowerCase().contains(txtText.getText().toLowerCase().trim()) || getID.equals(txtText.getText().trim()))

                {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/inn2powerd/GUI/View/CompanyInfoWindow.fxml"));
                    Pane infoWindow = loader.load();
                    CompanyInfoWindowController CIWC = loader.getController();
                    TitledPane pane = new TitledPane(company.getId() + "   -   " + company.getName(), infoWindow);
                    CIWC.setCompany(company);
                    tPanes.getPanes().add(pane);

                    pane.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) ->
                    {
                        if (isNowExpanded)
                        {
                            CIWC.showMap();
                        }
                    });
                    pane.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) ->
                    {
                        if (wasExpanded)
                        {
                            CIWC.hideMap();
                        }
                    });
                }
            }

            System.out.println("Number of results: " + tPanes.getPanes().size());

        } catch (IOException ex)
        {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleAddCompany(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/inn2powerd/GUI/View/AddCompanyWindow.fxml"));
        Parent root = (Parent) fxmlLoader1.load();
        Stage stage = new Stage();
        stage.setTitle("Add company");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleDeleteCompany(ActionEvent event) throws FileNotFoundException, IOException
    {
//
//        try
//        {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("companiess.csv"));
//
//            BufferedReader CSVFile = new BufferedReader(new FileReader("companies.csv"));
//
//            String line = CSVFile.readLine();
//            while (line != null)
//            {
//                String[] linesplit = line.split(",");
//                if (linesplit[0].equals(txtDeleteCompany.getText().trim()))
//                {
//                    System.out.println(line);
//
//                } else
//                {
//                    writer.write(line);
//                    writer.newLine();
//                }
//                line = CSVFile.readLine();
//            }
//
//        } catch (IOException e)
//        {
//            System.out.println(e);
//        }
//
    }
}
