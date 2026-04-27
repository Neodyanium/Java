package MultiThreading.Revision.ClassLevelLock;

public class PhonePe extends Thread{
    HSBCBank bank;

    PhonePe(HSBCBank bank){
        this.bank = bank;
    }

    public PhonePe() {

    }

    public void run(){
        System.out.print("PhonePay Checking Balance ");
        HSBCBank.checkBalance();
    }
}
