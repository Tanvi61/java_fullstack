package Day_10;

class SynchronizedCounter{
    int count = 0;
    public synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
public class CountingDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[1000];
        SynchronizedCounter counter = new SynchronizedCounter();
        for(int i=1;i<1000;i++){
            t[i] = new Thread(counter::increment);// Method reference 
            t[i].start();
        }
        for(int i=1;i<1000;i++){
            t[i].join();  
        }
        System.out.println("Final count : "+counter.getCount()); /// 999
    }
}
