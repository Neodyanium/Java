package MultiThreading.Revision.ObjectLevelLock;

public class LaunchBank {
    public static void main(String[] args) {
        HSBCBank bank = new HSBCBank(4000);
        ATM atm = new ATM(bank);
        GooglePay gpay = new GooglePay(bank);
        PhonePe ppay = new PhonePe(bank);

        atm.start();
        gpay.start();
        ppay.start();
    }
}
