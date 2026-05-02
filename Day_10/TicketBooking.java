package Day_10;

import java.util.Scanner;

class Train implements Runnable{
    int avlSeat,reserveSeats;

    public Train(int avlSeat, int reserveSeats) {
        super();
        this.avlSeat = avlSeat;
        this.reserveSeats = reserveSeats;
    }

    @Override
    public synchronized void run() {
        try{
            System.out.println("Available Seat : "+avlSeat+"\n Asking for Reaserve "+reserveSeats);
            Thread t = Thread.currentThread();
            if(avlSeat >= reserveSeats){
                Thread.sleep(5000);//Payment
                System.out.println(reserveSeats+" Seats booked for : "+t.getName());
                avlSeat-=reserveSeats;
            }else{
                System.out.println("Sorry seats are not available try next time.. "+t.getName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

public class TicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total available seats : ");
        int bookingSeats = sc.nextInt();
        Train train = new Train(bookingSeats, bookingSeats);
        Thread t1 = new Thread(train);
        t1.setName("Tanvi");
        t1.start();
        Thread t2 = new Thread(train);
        t2.setName("Shruti");
        t2.start();
        Thread t3 = new Thread(train);
        t3.setName("Gauri");
        t3.start();
        Thread t4 = new Thread(train);
        t4.setName("Ruchika");
        t4.start();
        sc.close();
    }
    
}
