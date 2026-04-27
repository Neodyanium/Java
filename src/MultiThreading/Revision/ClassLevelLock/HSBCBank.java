package MultiThreading.Revision.ClassLevelLock;

public class HSBCBank {

    static int accBalance;

    public static int getAccBalance(){
        return accBalance;
    }

    public HSBCBank(int bal){
        accBalance = bal;
    }


    public static synchronized void withdrawal(int money){
         accBalance = accBalance - money;
    }

    public static synchronized void deposit(int money){
        accBalance = accBalance + money;
    }

    public static synchronized void checkBalance(){
        System.out.println("Balance: "+accBalance);
    }
}
