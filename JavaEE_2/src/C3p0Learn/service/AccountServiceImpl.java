package C3p0Learn.service;

import C3p0Learn.dao.AccountDaoImpl;
import C3p0Learn.domain.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl {

    private AccountDaoImpl accountDao = new AccountDaoImpl();

    public List<Account> getUsers() {
        StringBuilder sb = new StringBuilder("select * from account");
        List<Object> list = new ArrayList<>();
        List<Account> accounts = accountDao.selectUsers(sb.toString(), list);
        return accounts;
    }
}
