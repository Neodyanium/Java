package MultiThreading.Revision.ObjectLevelLock;

public class GooglePay extends Thread{
    HSBCBank bank;

    GooglePay(HSBCBank bank){
        this.bank = bank;
    }

    public void run(){
        System.out.println("Gpay Depositing Money ");
        bank.deposit(4000);
        System.out.println("After Gpay deposit, Balance:"+bank.getAccBalance());
    }
}
