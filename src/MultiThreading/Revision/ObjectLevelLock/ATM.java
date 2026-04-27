package MultiThreading.Revision.ObjectLevelLock;

public class ATM extends Thread{

    HSBCBank bank;

    ATM(HSBCBank bank){
        this.bank = bank;
    }

    public void run(){
        System.out.println("ATM Withdrawing Money");
        bank.withdrawal(2000);
        System.out.println("After atm Withdraw, Balance:"+bank.getAccBalance());
    }
}
