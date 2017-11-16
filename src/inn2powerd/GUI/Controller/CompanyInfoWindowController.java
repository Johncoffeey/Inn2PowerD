/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.GUI.Controller;

import inn2powerd.BE.Company;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author ddose
 */
public class CompanyInfoWindowController implements Initializable
{

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

    public void setCompany(Company company)
    {
        this.company = company;
        lblCName.setText(company.getName());
        lblCID.setText(Integer.toString(company.getId()));
        lblCCountry.setText(company.getCountry());
        lblCAddress.setText(company.getAddress());
        lblCWebsite.setText(company.getWebsite());
        lblCSME.setText(Integer.toString(company.getIsSME()));
        lblCLongitude.setText(Double.toString(company.getLng()));
        lblCLatitude.setText(Double.toString(company.getLat()));

    }

    public void showMap()
    {

        WebEngine engine = WVLocation.getEngine();
        engine.loadContent("<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <style>\n"
                + "            #map {\n"
                + "                height: 200px;\n"
                + "                width: 100%;\n"
                + "            }\n"
                + "            html, \n"
                + "            body {\n"
                + "                height: 200px;\n"
                + "                background-color:#F4F4F4;\n"
                + "            }\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body> \n"
                + "        <div id=\"map\"></div>\n"
                + "        <script>\n"
                + "            function initMap() {\n"
                + "            var uluru = {lat: " + company.getLat() + ", lng: " + company.getLng() + "};\n"
                + "            var map = new google.maps.Map(document.getElementById('map'), {\n"
                + "            zoom: 9,\n"
                + "            center: uluru\n"
                + "            });\n"
                + "            var marker = new google.maps.Marker({\n"
                + "            position: uluru,\n"
                + "            map: map\n"
                + "            });\n"
                + "            }\n"
                + "        </script>\n"
                + "        <script async defer\n"
                + "                src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBj0bQK6TqjApmhvVr5kVh2avIm-cZ4JEM&callback=initMap\">\n"
                + "        </script>\n"
                + "    </body>\n"
                + "</html>");
    }

    public void hideMap()
    {
        WebEngine engine = WVLocation.getEngine();
        engine.load(null);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

}
