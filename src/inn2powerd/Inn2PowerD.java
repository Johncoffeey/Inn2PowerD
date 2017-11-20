/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd;

import inn2powerd.BE.Company;
import inn2powerd.DAL.CompanyDAO;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ddose
 */
public class Inn2PowerD extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI/View/MainWindow.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Inn2POWER");
        stage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        CompanyDAO companyDao = new CompanyDAO();
        companyDao.createCompany("John", "doe", "Niger", "Niger.com", 11.1, 13.1, 1);

        launch(args);
    }

}
