package MultiThreading.Revision.ClassLevelLock;

public class ATM extends Thread{

    HSBCBank bank;

    ATM(HSBCBank bank){
        this.bank = bank;
    }

    ATM(){

    }


    public void run(){
        System.out.println("ATM Withdrawing Money");
        HSBCBank.withdrawal(2000);
        System.out.println("After atm Withdraw, Balance:"+ HSBCBank.getAccBalance());
    }
}
