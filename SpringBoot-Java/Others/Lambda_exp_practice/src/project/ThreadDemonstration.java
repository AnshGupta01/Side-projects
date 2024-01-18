package project;

public class ThreadDemonstration {
    public static void main(String[] args) {

        //1st Thread: Thread Ansh
        Runnable thread1 = () -> {
           //body of the thread
           for(int i=1;i<=10;i++){
               System.out.println("Value of I is: "+ i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        };

        Thread t = new Thread(thread1);
        t.setName("Ansh");
        t.start();

        Runnable thread2 = () -> {
            for(int i=1; i<=10;i++){
                System.out.println(i*2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t2 = new Thread(thread2);
        t2.setName("Chaman");
        t2.start();

    }
}
