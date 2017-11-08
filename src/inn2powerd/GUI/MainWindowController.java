/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.GUI;

import dal.CompanyDAO;
import inn2powerd.BLL.BLLManager;
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
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author ddose
 */
public class MainWindowController implements Initializable
{

    private Label label;
    @FXML
    private Accordion tpaneName;

    BLLManager bllManager = new BLLManager();
    @FXML
    private AnchorPane tableCompanies;

    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {
            // Tilføj pane
            //TitledPane pane = new TitledPane("Test", new Button("B1"));
            // tpaneName.getPanes().add(pane);

            // Gtét company list
            CompanyDAO cDAO = new CompanyDAO();
            List<be.Company> list = cDAO.getAllCompanies();
            for (be.Company company : list)
            {
                TitledPane pane = new TitledPane(company.getId() + "   -   " + company.getName(), FXMLLoader.load(getClass().getResource("CompanyInfoWindow.fxml")));
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
