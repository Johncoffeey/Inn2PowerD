/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.GUI.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Danni
 */
public class AddCompanyWindowController implements Initializable
{

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtCountry;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtWebsite;
    @FXML
    private TextField txtLatitude;
    @FXML
    private TextField txtLongitude;
    @FXML
    private TextField txtIsSME;
    @FXML
    private Button btnAddCompanyClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void handleWrittingToCompaniesFile(ActionEvent event)
    {
        try (FileWriter fw = new FileWriter("companies.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
        {
            if (txtId.getText().trim().equals("") || !txtId.getText().matches("[0-9]*") || txtName.getText().trim().equals("") || txtName.getText().contains(",")
                    || txtCountry.getText().trim().equals("") || txtCountry.getText().contains(",") || txtAddress.getText().trim().equals("")
                    || txtAddress.getText().contains(",") || txtWebsite.getText().trim().equals("") || txtWebsite.getText().contains(",")
                    || txtLatitude.getText().trim().equals("") || !txtLatitude.getText().matches("[0-9]*") && !txtLatitude.getText().contains(".")
                    || txtLatitude.getText().contains(",") || txtLongitude.getText().trim().equals("") || !txtLongitude.getText().matches("[0-9]*")
                    && !txtLongitude.getText().contains(".") || txtLongitude.getText().contains(",") || txtIsSME.getText().trim().equals("")
                    || !txtIsSME.getText().matches("[0-9]*"))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Wrong info dude!");
                alert.show();

            } else
            {
                out.println(txtId.getText().trim() + "," + txtName.getText().trim() + "," + txtCountry.getText().trim() + "," + txtAddress.getText().trim()
                        + "," + txtWebsite.getText().trim() + "," + txtLatitude.getText().trim() + "," + txtLongitude.getText().trim() + "," + txtIsSME.getText().trim());

                Stage stage = (Stage) btnAddCompanyClose.getScene().getWindow();
                stage.close();
            }

        } catch (IOException e)
        {
            System.out.println(e);
        }

//        try
//        {
//            Files.write(Paths.get("companies.csv"), "bla bla".getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException e)
//        {
//            //exception handling left as an exercise for the reader
//        }
    }

}
