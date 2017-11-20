/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inn2powerd.DAL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import inn2powerd.BE.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Simon Zidoree
 */
public class CompanyDAO {

    private DataBaseConnector dbConnector;

    public CompanyDAO() {
        dbConnector = new DataBaseConnector();
    }

    public void createCompany(String name, String address, String country, String website, double lat, double lng, int isSME) throws SQLServerException, SQLException {
        PreparedStatement ps;
        ResultSet rs;

        try (Connection con = dbConnector.getConnection()) {
            System.out.println(con.isClosed());

            ps = con.prepareStatement("INSERT INTO Company (Name, Country, Address, Website, lat, lng, isSME)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, country);
            ps.setString(4, website);
            ps.setString(5, Double.toString(lat));
            ps.setString(6, Double.toString(lng));
            ps.setString(7, Integer.toString(isSME));

            ps.execute();

        }
    }
}
