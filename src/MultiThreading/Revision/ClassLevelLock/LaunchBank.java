package MultiThreading.Revision.ClassLevelLock;

public class LaunchBank {
    public static void main(String[] args) {
        HSBCBank bank = new HSBCBank(4000);
        ATM atm = new ATM();
        GooglePay gpay = new GooglePay();
        PhonePe ppay = new PhonePe();

        atm.start();
        gpay.start();
        ppay.start();
    }
}
