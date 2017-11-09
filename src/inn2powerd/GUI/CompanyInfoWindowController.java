/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.GUI;

import be.Company;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author ddose
 */
public class CompanyInfoWindowController implements Initializable {

    private Company company;
    @FXML
    private Label lblCID;
    @FXML
    private Label lblCCountry;
    @FXML
    private Label lblCAddress;
    @FXML
    private Label lblCWebsite;
    @FXML
    private Label lblCSME;
    @FXML
    private Label lblCLongitude;
    @FXML
    private Label lblCLatitude;
    @FXML
    private Label lblCName;
    @FXML
    private WebView WVLocation;

    public void setCompany(Company company) {
        this.company = company;
        lblCName.setText(company.getName());
        lblCID.setText(Integer.toString(company.getId()));
        lblCCountry.setText(company.getCountry());
        lblCAddress.setText(company.getAddress());
        lblCWebsite.setText(company.getWebsite());
        lblCSME.setText(Integer.toString(company.getIsSME()));
        lblCLongitude.setText(Double.toString(company.getLng()));
        lblCLatitude.setText(Double.toString(company.getLat()));


//        WebEngine engine = WVLocation.getEngine();
//        final URL urlGoogleMaps = getClass().getResource("maps.html");
//        engine.load(urlGoogleMaps.toExternalForm());

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
