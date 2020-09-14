package com.booklist.service;

import com.booklist.beans.BookListInfo;
import com.booklist.dataaccess.BookListDataAccess;
import com.booklist.exceptiondataaccess.DataAccessException;
import com.booklist.exceptiondataaccess.DataIOException;
import com.booklist.exceptiondataaccess.DataNotFoundException;
import com.booklist.exceptionservice.NotMatchDataException;
import com.booklist.exceptionservice.SystemErrorException;

import java.util.List;

public class BookListManager {

    private BookListDataAccess bookListDataAccess;

    public BookListManager() {
        this.bookListDataAccess = new BookListDataAccess();
    }

    public List<BookListInfo> showBookList (int accountId) throws SystemErrorException, NotMatchDataException {
        List<BookListInfo> bookList;
        try{
            bookList = bookListDataAccess.showBookList(accountId);
        } catch (DataAccessException e) {
            throw new SystemErrorException(e.getMessage(),e);
        } catch (DataNotFoundException e) {
            throw new NotMatchDataException(e.getMessage(),e);
        } catch (DataIOException e) {
            throw new SystemErrorException(e.getMessage(), e);
        }
        return bookList;
    }

/*    public static void main(String[] args){
        BookListManager bookManager = new BookListManager();
        List<BookListInfo> bookList;
        try{
            bookList = bookManager.showBookList(3);
            for (int i=0; i<bookList.size(); i++){
                System.out.println(bookList.get(i).getTitle());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

}
