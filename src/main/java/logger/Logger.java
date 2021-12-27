public class Logger {

    public static void main(String[] args) {
        ErrorLog error = new ErrorLog();
        error.start();
        WarningLog warning = new WarningLog();
        warning.start();
        for (int i = 0; i < 5; i++) {
            try {
                error.sleep(5000);
                Thread.sleep(3000);
            } catch(InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            finally {

            }
        }
    }
}
