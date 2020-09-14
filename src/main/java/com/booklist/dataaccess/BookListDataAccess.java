package com.booklist.dataaccess;
import com.booklist.beans.BookListInfo;
import com.booklist.exceptiondataaccess.DataAccessException;
import com.booklist.exceptiondataaccess.DataIOException;
import com.booklist.exceptiondataaccess.DataNotFoundException;
import com.booklist.utility.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.booklist.dataaccess.AccessConstants.*;


public class BookListDataAccess {
    private static String SQL_SELECT_BOOK = "select b.title, b.author, b.pages, b.rating, l.added_date\n" +
            "from books b\n" +
            "join booklist l on b.id = l.book_id\n" +
            "join users u on l.user_id = u.id\n" +
            "where u.id = ? \n";

    //SHOW BOOK LIST
    public List<BookListInfo> showBookList(int accountId) throws DataNotFoundException, DataAccessException, DataIOException {

        List<BookListInfo> bookList = new ArrayList<>();
        try{
            Class.forName(DRIVER);
            System.out.println("Driver created");
            try (Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
                 PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BOOK)){
                System.out.println("Connected");
                ps.setInt(1,accountId);
                System.out.println("Binding");
                try (ResultSet rs = ps.executeQuery()){
                    System.out.println("Fetching results");
                    while (rs.next()){
                        BookListInfo book = new BookListInfo(rs.getString("title"),
                                rs.getString("author"),
                                rs.getInt("pages"),
                                rs.getFloat("rating"),
                                StringUtils.formatTimeForView(rs.getString("added_date")));
                        bookList.add(book);
                    }
                    if (bookList != null){
                        return bookList;
                    } else {
                        throw new DataNotFoundException("Your book list is empty.");
                    }
                }
            }catch (SQLException e){
                throw new DataAccessException("Data cannot be read", e);
            }
        } catch (ClassNotFoundException e) {
            throw new DataIOException ("Data Access Error", e);
        }
    }

    //ADD NEW BOOKS
    public void addBook(String title, String author, int pages, float rating) throws DataNotFoundException,
            DataAccessException, DataIOException{

    }

}
