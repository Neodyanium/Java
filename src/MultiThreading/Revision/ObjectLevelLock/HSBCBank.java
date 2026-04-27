package MultiThreading.Revision.ObjectLevelLock;

public class HSBCBank {

    int accBalance;

    public int getAccBalance(){
        return accBalance;
    }

    public HSBCBank(int bal){
        accBalance = bal;
    }


    public synchronized void withdrawal(int money){
         accBalance = accBalance - money;
    }

    public synchronized void deposit(int money){
        accBalance = accBalance + money;
    }

    public synchronized void checkBalance(){
        System.out.println("Balance: "+accBalance);
    }
}
