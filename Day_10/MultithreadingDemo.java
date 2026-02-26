package Day_10;

class Addition implements Runnable{
    // public int add(int a , int b){
    //     return a+b;
    // }
    // public int sub(int a , int b){
    //     return a-b;
    // }
    // public int multi(int a , int b){
    //     return a*b;
    // }
    // public int div(int a , int b){
    //     return a/b;
    // }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}

public class MultithreadingDemo{
    public static void main(String[] args) {
        Addition add = new Addition();
        for(int i=0;i<500;i++){
            Thread t = new Thread(add);
            t.start();
        }
    }
}
