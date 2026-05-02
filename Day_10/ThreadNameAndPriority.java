package Day_10;

class Song extends Thread{
    public void run(){
        try{
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+" : "+t.getPriority());
            Thread.sleep(3000);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class ThreadNameAndPriority {
    public static void main(String[] args) {
        Song song = new Song();
        Thread t1 = new Thread(song);
        t1.setName("Marathi song");
        t1.setPriority(7);// Default priority is 5 / Highest priority is 10
        t1.start();
        Thread t2 = new Thread(song);
        t2.setName("Hindi song");
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        Thread t3 = new Thread(song);
        t3.setName("English song");
        t3.start();
    }
}
