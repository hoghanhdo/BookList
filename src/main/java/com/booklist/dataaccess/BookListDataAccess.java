package com.booklist.dataaccess;

import com.booklist.beans.Book;
import com.booklist.beans.BookListInfo;
import com.booklist.exceptiondataaccess.AddBookException;
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
            "where u.id = ? order by l.added_date desc \n";

    private final String SQL_INSERT_BOOK = "insert into BOOKS(title, author, rating, pages)\n" +
            "values(?, ?, ?, ?)";
    private final String SQL_INSERT_BOOKLIST = "insert into BOOKLIST(book_id, user_id)\n" +
            "values(?,?)";

    //SHOW BOOK LIST
    public List<BookListInfo> showBookList(int accountId) throws DataNotFoundException, DataAccessException, DataIOException {

        List<BookListInfo> bookList = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            System.out.println("Driver created");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement ps = conn.prepareStatement(SQL_SELECT_BOOK)) {
                System.out.println("Connected");
                ps.setInt(1, accountId);
                System.out.println("Binding");
                try (ResultSet rs = ps.executeQuery()) {
                    System.out.println("Fetching results");
                    while (rs.next()) {
                        BookListInfo book = new BookListInfo(rs.getString("title"),
                                rs.getString("author"),
                                rs.getInt("pages"),
                                rs.getDouble("rating"),
                                StringUtils.formatTimeForView(rs.getString("added_date")));
                        bookList.add(book);
                    }
                    if (bookList != null) {
                        return bookList;
                    } else {
                        throw new DataNotFoundException("Your book list is empty.");
                    }
                }
            } catch (SQLException e) {
                throw new DataAccessException("Data cannot be read", e);
            }
        } catch (ClassNotFoundException e) {
            throw new DataIOException("Data Access Error", e);
        }
    }

    //ADD NEW BOOKS
    public void addBook(Book book, int userId) throws DataAccessException, AddBookException {
        try {
            Class.forName(DRIVER);
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                try (PreparedStatement ps = conn.prepareStatement(SQL_INSERT_BOOK, Statement.RETURN_GENERATED_KEYS)) {
                    conn.setAutoCommit(false);
                    ps.setString(1, book.getTitle());
                    ps.setString(2, book.getAuthor());
                    ps.setDouble(3, book.getRating());
                    ps.setInt(4, book.getPages());
                    ps.executeUpdate();
                    System.out.println("1.");
                    int generatedCode = -1;
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        System.out.println("2..");
                        generatedCode = rs.getInt("id");
                        PreparedStatement ps2 = conn.prepareStatement(SQL_INSERT_BOOKLIST);
                        ps2.setInt(1, generatedCode);
                        ps2.setInt(2, userId);
                        ps2.executeUpdate();
                        System.out.println("3...");
                        conn.commit();
                        System.out.println("Book was added successfully");
                    }
                } catch (SQLException e) {
                    conn.rollback();
                    throw new AddBookException("Failed to add book");
                }
            } catch (SQLException e) {
                throw new DataAccessException("Connection Error");
            }
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("Database Access Error");
        }
    }
}
