package Exercise_02;

import java.util.Scanner;

class Train {
    int avlSeat;

    public Train(int avlSeat) {
        this.avlSeat = avlSeat;
    }

    public synchronized void bookSeat(int reserveSeats) {
        try {
            Thread t = Thread.currentThread();
            System.out.println("\nAvailable Seats: " + avlSeat);
            System.out.println(t.getName() + " wants to book " + reserveSeats + " seats");

            if (avlSeat >= reserveSeats) {
                Thread.sleep(2000); 
                avlSeat -= reserveSeats;
                System.out.println(reserveSeats + " seats booked for " + t.getName());
            } else {
                System.out.println("Not enough seats for " + t.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person implements Runnable {
    Train train;
    int seats;

    public Person(Train train, int seats) {
        this.train = train;
        this.seats = seats;
    }

    @Override
    public void run() {
        train.bookSeat(seats);
    }
}

public class TicketBooking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total available seats: ");
        int totalSeats = sc.nextInt();

        Train train = new Train(totalSeats);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name of person " + i + ": ");
            String name = sc.next();

            System.out.print("Enter seats to book: ");
            int seats = sc.nextInt();

            Thread t = new Thread(new Person(train, seats));
            t.setName(name);
            t.start();
        }

        sc.close();
    }
}