package com.booklist.service;

import com.booklist.beans.User;
import com.booklist.dataaccess.UserDataAccess;
import com.booklist.exceptiondataaccess.DataAccessException;
import com.booklist.exceptiondataaccess.DataIOException;
import com.booklist.exceptiondataaccess.DataNotFoundException;
import com.booklist.exceptionservice.NotMatchDataException;
import com.booklist.exceptionservice.SystemErrorException;

public class UserAccountManager {
    private UserDataAccess userDataAccess;

    public UserAccountManager() {
        this.userDataAccess = new UserDataAccess();
    }

    public User findUser(String userId, String password) throws NotMatchDataException, SystemErrorException {
        User user;
        try {
            user = userDataAccess.findUser(userId, password);
        } catch (DataNotFoundException e) {
            throw new NotMatchDataException(e.getMessage(), e);
        } catch (DataIOException | DataAccessException e) {
            throw new SystemErrorException(e.getMessage(), e);
        }
        return user;
    }
}
