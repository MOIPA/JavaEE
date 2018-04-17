package C3p0Learn;

import C3p0Learn.domain.Account;
import C3p0Learn.service.AccountServiceImpl;

public class main {


    public static void main(String[] args){
        AccountServiceImpl accountService = new AccountServiceImpl();
        for(Account account:accountService.getUsers()){
            System.out.println(account.getAccount());
        }
    }
}
