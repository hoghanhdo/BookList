package com.booklist.service;

import com.booklist.beans.User;
import com.booklist.dataaccess.UserDataAccess;
import com.booklist.dataaccess_exception.DataAccessException;
import com.booklist.dataaccess_exception.DataIOException;
import com.booklist.dataaccess_exception.DataNotFoundException;
import com.booklist.service_exception.NotMatchDataException;
import com.booklist.service_exception.SystemErrorException;

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
