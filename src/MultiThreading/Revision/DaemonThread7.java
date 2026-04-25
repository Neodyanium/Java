package MultiThreading.Revision;

class MSWordOG extends Thread{

    public void typing(){
        try{
            for(int i=0;i<3;i++){
                System.out.println("Typing");
                Thread.sleep(2000);
            }
        }catch (Exception ignore){

        }
    }

    public void typeCheck(){
        try{
            for(int i=0;i<3;i++){
                System.out.println("Type-Checking");
                Thread.sleep(2000);
            }
        }catch (Exception ignore){

        }
    }

    public void saving(){
        try{
            for(int i=0;i<3;i++){
                System.out.println("Auto-saving");
                Thread.sleep(2000);
            }
        }catch (Exception ignore){

        }
    }
    public void run(){
        String name = Thread.currentThread().getName();

        if(name.equals("TYPE")){
            typing();
        }else if(name.equals("SPELL")){
            typeCheck();
        }else{
            saving();
        }
    }
}

class MSWord extends Thread{

    public void typing(){
        try{
            for(int i=0;i<3;i++){
                System.out.println("Typing");
                Thread.sleep(2000);
            }
        }catch (Exception ignore){

        }
    }

    public void typeCheck(){
        try{
            for(;;){
                System.out.println("Type-Checking");
                Thread.sleep(2000);
            }
        }catch (Exception ignore){

        }
    }

    public void saving(){
        try{
            for(;;){
                System.out.println("Auto-saving");
                Thread.sleep(2000);
            }
        }catch (Exception ignore){

        }
    }
    public void run(){
        String name = Thread.currentThread().getName();

        if(name.equals("TYPE")){
            typing();
        }else if(name.equals("SPELL")){
            typeCheck();
        }else{
            saving();
        }
    }

}

class DaemonThread {
    public static void main(String[] args) {

        //MSWord t1 = new MSWord("TYPE"); Didn't work
        /**
        MSWordOG mso1 = new MSWordOG();
        MSWordOG mso2 = new MSWordOG();
        MSWordOG mso3 = new MSWordOG();

        mso1.setName("TYPE");
        mso2.setName("SPELL");
        mso3.setName("SAVE");

        mso1.start();
        mso2.start();
        mso3.start();
         */

        /**
         * First run the above code and then run the below code they are a follow-up
         *
         * We notice that the SPELL CHECK and SAVE are esentially background processes or Secondary Threads, it will
         * work fine even if they executed once at the end, so we make them as demon process
         *
         * See how the daemon threads didn't print infinitely despite the infinite loop
         */



        MSWord ms1 = new MSWord();
        MSWord ms2 = new MSWord();
        MSWord ms3 = new MSWord();

        ms1.setName("TYPE");
        ms2.setName("SPELL");
        ms3.setName("SAVE");

        ms2.setDaemon(true);
        ms3.setDaemon(true);

        ms2.setPriority(4);
        ms3.setPriority(3);

        ms1.start();
        ms2.start();
        ms3.start();

    }

}
