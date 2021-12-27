public class ErrorLog extends Thread{

    ErrorLog() {
        printSelf();
    }

    void printSelf() {
        for(int i = 0; i < 10; i++) {
            System.out.println("error");
            try{
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
