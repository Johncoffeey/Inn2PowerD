//package inn2powerd.BLL;
//
//import dal.CompanyDAO;
//import inn2powerd.GUI.CompanyInfoWindowController;
//import inn2powerd.GUI.MainWindowController;
//import java.io.IOException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.control.TitledPane;
//import javafx.scene.layout.Pane;
//
//public class Search {
//
//    public String bla;
//
//    
//    
//    public void searchCompany() {
//        
//        try {
//            CompanyDAO cDAO = new CompanyDAO();
//            List<be.Company> list = cDAO.getAllCompanies();
//            tPanes.getPanes().clear();
//
//            for (be.Company company : list) {
//                bla = company.getName();
//                if (bla.toLowerCase().contains(txtText.getText().toLowerCase())) {
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/CompanyInfoWindow.fxml"));
//                    Pane infoWindow = loader.load();
//                    CompanyInfoWindowController CIWC = loader.getController();
//                    CIWC.setCompany(company);
//                    TitledPane pane = new TitledPane(company.getId() + "   -   " + company.getName(), infoWindow);
//                    tPanes.getPanes().add(pane);
//                }
//            }
//
//            //loadAllCompanies();
//        } catch (IOException ex) {
//            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
