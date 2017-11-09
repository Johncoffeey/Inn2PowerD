/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.GUI;

import be.Company;
import dal.CompanyDAO;
import inn2powerd.BLL.IWordSearcher;
import inn2powerd.BLL.WordManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author ddose
 */
public class MainWindowController implements Initializable
{

    private WordManager wordManager;

    private Label label;
    @FXML
    private Accordion tPanes;

//    BLLManager bllManager = new BLLManager();
    @FXML
    private TextField txtQuery;

    FXMLLoader loader;
    Pane infoWindow;
    CompanyInfoWindowController CIWC;
    CompanyDAO cDAO;
    List<be.Company> list;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        wordManager = new WordManager();

        try
        {

            cDAO = new CompanyDAO();
            list = cDAO.getAllCompanies();

            for (be.Company company : list)
            {
                loader = new FXMLLoader(getClass().getResource("CompanyInfoWindow.fxml"));
                infoWindow = loader.load();
                CIWC = loader.getController();
                CIWC.setCompany(company);
                TitledPane pane = new TitledPane(company.getId() + "   -   " + company.getName(), infoWindow);
                tPanes.getPanes().add(pane);
            }

            //loadAllCompanies();
        } catch (IOException ex)
        {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hashmap()
    {

    }

    /**
     * Performs a word search.
     *
     * @param event
     */
    @FXML
    void handleSearch(ActionEvent event)
    {
        try
        {
            String query = txtQuery.getText().trim();
            List<String> searchResult = null;
            IWordSearcher searchStrategy = new IWordSearcher()
            {
                @Override
                public boolean compare(String word)
                {
                    return true;
                }
            };

            searchResult = wordManager.search(searchStrategy);

            String limit = "10"; //comboLimitation.getValue();
            try
            {
                int intLimit = Integer.parseInt(limit);
                searchResult = searchResult.subList(0, intLimit);
            } catch (NumberFormatException | IndexOutOfBoundsException nfe)
            {
                //Do nothing
            }

            tPanes.getPanes().clear();
            List<Company> allCompanies = cDAO.getAllCompanies();
            for (Company com : allCompanies)
            {

                if (com.getName().toLowerCase().contains(query.toLowerCase()))
                {

                    loader = new FXMLLoader(getClass().getResource("CompanyInfoWindow.fxml"));
                    infoWindow = loader.load();
                    CIWC = loader.getController();
                    CIWC.setCompany(com);
                    TitledPane pane = new TitledPane(com.getId() + "   -   " + com.getName(), infoWindow);
                    tPanes.getPanes().add(pane);
                }
            }
//            model.setWords(searchResult);
        } catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

}
