package com.booklist.dataaccess;

import com.booklist.beans.User;
import com.booklist.dataaccess_exception.DataAccessException;
import com.booklist.dataaccess_exception.DataIOException;
import com.booklist.dataaccess_exception.DataNotFoundException;

import java.sql.*;

import static com.booklist.dataaccess.AccessConstants.*;

public class UserDataAccess {
    private static final String SQL_SELECT_USER = "SELECT * FROM USERS WHERE name = ? and password = ?";

    public static User findUser(String userId, String password) throws DataNotFoundException, DataAccessException, DataIOException {
        try {
            Class.forName(DRIVER);
            //System.out.println("Driver created");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                //System.out.println("Connected");
                try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT_USER)) {
                    //System.out.println("Prepared Statement created");
                    ps.setString(1, userId);
                    ps.setString(2, password);
                    //System.out.println("Biding");
                    try (ResultSet rs = ps.executeQuery()) {
                        //System.out.println("Result Set fetched");
                        if (rs.next()) {
                            //System.out.println("If data != null");
                            User user = new User(rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("password"),
                                    rs.getString("first_name"),
                                    rs.getString("last_name"));
                            return user;
                        } else {
                            throw new DataNotFoundException("User Not Found");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DataAccessException("Data Access Error", e);
        }
    }
}

