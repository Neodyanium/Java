package MultiThreading.Revision.ObjectLevelLock;

public class PhonePe extends Thread{
    HSBCBank bank;

    PhonePe(HSBCBank bank){
        this.bank = bank;
    }

    public void run(){
        System.out.println("PhonePay Checking Balance");
        bank.checkBalance();
    }
}
