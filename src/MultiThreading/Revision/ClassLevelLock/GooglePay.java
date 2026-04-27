package MultiThreading.Revision.ClassLevelLock;

public class GooglePay extends Thread{
    HSBCBank bank;

    GooglePay(HSBCBank bank){
        this.bank = bank;
    }

    public GooglePay() {

    }

    public void run(){
        System.out.println("Gpay Depositing Money ");
        HSBCBank.deposit(4000);
        System.out.println("After Gpay deposit, Balance:"+HSBCBank.getAccBalance());
    }
}
