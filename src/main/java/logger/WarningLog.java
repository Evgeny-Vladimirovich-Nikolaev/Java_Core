public class WarningLog extends Thread{

    WarningLog() {
        printSelf();
    }

    void printSelf() {
        for(int i = 0; i < 10; i++) {
            System.out.println("warning");
            try{
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
