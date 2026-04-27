package MultiThreading.Revision.ObjectLevelLock;

public class HSBCBank {

    int accBalance;

    public HSBCBank(int bal){
        accBalance = bal;
    }


    public void withdrawal(int money){
         accBalance = accBalance - money;
    }

    public void deposit(int money){
        accBalance = accBalance + money;
    }

    public void checkBalance(){
        System.out.println("Balance: "+accBalance);
    }
}
