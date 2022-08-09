package entity;

/**
 * @version 1.1
 * @author: zyc
 * @date: 2022/25
 */
public class BankAccount {
    String accNo;
    String password;

    public BankAccount(String accNo, String password){
        this.accNo = accNo;
        this.password = password;
    }

    public String getAccountNo(){
        return accNo;
    }

    public String getPassword(){
        return password;
    }

}
