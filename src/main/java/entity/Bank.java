package entity;

/**
 * @version 1.1
 * @author: zyc
 * @date: 2022/5/28
 */
public class Bank {

    String name;
    public static BankAccount[] array = new BankAccount[4];

    public Bank(){
        array[0] = new BankAccount("6214680021598808","123456");
        array[1] = new BankAccount("1234567891011121","123456");
        array[2] = new BankAccount("9876543210123456","123456");
        array[3] = new BankAccount("9999999999999999","123456");
    }

    public BankAccount[] getArray(){
        return array;
    }

    public String getACC(int i){
        return array[i].getAccountNo();
    }

    public String getPAS(int i){
        return array[i].getPassword();
    }

    public int getLength(){
        return array.length;
    }
    
}
/*
public class Bank {

    String name;
    public static BankAccount[] array = new BankAccount[10];

    public Bank(){
        array[0] = new BankAccount("6214680021598808","123456");
        array[1] = new BankAccount("1234567891011121","123456");
        array[2] = new BankAccount("9876543210123456","123456");
        array[3] = new BankAccount("9999999999999999","123456");
    }

    public BankAccount[] getArray(){
        return array;
    }

    public static String getACC(int i){
        return array[i].getAccountNo();
    }

    public static String getPAS(int i){
        return array[i].getPassword();
    }

    public int getLength(){
        return array.length;
    }
    
}
*/