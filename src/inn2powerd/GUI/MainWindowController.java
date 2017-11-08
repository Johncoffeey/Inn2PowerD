/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.GUI;

import dal.CompanyDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author ddose
 */
public class MainWindowController implements Initializable
{

    private Label label;
    @FXML
    private Accordion tpaneName;

//    BLLManager bllManager = new BLLManager();
    @FXML
    private AnchorPane tableCompanies;

    

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {
            
            CompanyDAO cDAO = new CompanyDAO();
            List<be.Company> list = cDAO.getAllCompanies();
            for (be.Company company : list)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CompanyInfoWindow.fxml"));
                Pane infoWindow = loader.load();
                CompanyInfoWindowController CIWC = loader.getController();
                CIWC.setCompany(company);
                TitledPane pane = new TitledPane(company.getId() + "   -   " + company.getName(), infoWindow);
                tpaneName.getPanes().add(pane);
            }

            //loadAllCompanies();
        } catch (IOException ex)
        {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadAllCompanies()
    {
        //tableCompanies.setItems(bllManager.getAllCompanies());
    }

}
