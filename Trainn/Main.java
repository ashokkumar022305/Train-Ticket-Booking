package Trainn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        while (true){
            System.out.println("Enter the option \n1.Book Ticket \n2.Cancel Ticket \n3.Print Available Ticket\n4.Print Booking Tickets\n5.Exit ");
            int option = in.nextInt();
            switch (option){
                case 1 ->{
                    System.out.println("Enter the name : ");
                    String name = in.next();
                    System.out.println("Enter the age : ");
                    int age = in.nextInt();
                    System.out.println("Enter the Gender(if male ->'M' else female ->'F') : ");
                    char gender = in.next().charAt(0);
                    System.out.println("Enter the berth preference (Upper 'U',Middle 'M',Lower 'L')");
                    char berth = in.next().charAt(0);
                    if(BookTicket.wlb==0){
                        System.out.println("Ticket not available");
                    }
                    else checking(new Passenger(name,age,gender,berth));
                }
                case 2 ->{
                    System.out.println("Enter the cancel id : ");
                    int cancel = in.nextInt();
                   BookTicket.cancelTicket(cancel);
                }
                case 3 -> BookTicket.printavailable();

                case 4-> BookTicket.printDetails();

                case 5-> System.exit(0);
            }
        }
    }

    public static void checking(Passenger p){
        BookTicket bookTicket = new BookTicket();
         if((p.getGender()=='F'||p.getAge()>60)&&BookTicket.alb>0&&p.getBerth()!='L'){
            System.out.println("Lower berth allocated.For the safety purpose we are provide like this..!");
            bookTicket.bookTicket(p,'L',p.getId());
            BookTicket.alb--;
        }

        else if((p.getBerth()=='U'&&BookTicket.aub>0)|| (p.getBerth()=='M'&&BookTicket.amb>0)|| (p.getBerth()=='L'&&BookTicket.alb>0)) {
             System.out.println("Preferred berth available");
             if (p.getBerth() == 'U') {
                 System.out.println("Upper berth allocated");
                 bookTicket.bookTicket(p, 'U', p.getId());
                 BookTicket.aub--;
             } else if (p.getBerth() == 'M') {
                 System.out.println("Middle berth allocated");
                 bookTicket.bookTicket(p, 'M', p.getId());
                 BookTicket.amb--;
             } else if (p.getBerth() == 'L') {
                 System.out.println("Lower berth allocated");
                 bookTicket.bookTicket(p, 'L', p.getId());
                 BookTicket.alb--;
             }
         }

        else if(BookTicket.aub>0){
            System.out.println("Upper berth allocated");
            bookTicket.bookTicket(p,'U',p.getId());
            BookTicket.aub--;
        }

        else if(BookTicket.amb>0){
            System.out.println("Middle berth allocated");
            bookTicket.bookTicket(p,'M', p.getId());
            BookTicket.amb--;
        }

        else if(BookTicket.alb>0){
            System.out.println("Lower berth allocated");
            bookTicket.bookTicket(p,'L',p.getId());
            BookTicket.alb--;
        }

        else if(BookTicket.racb>0){
            System.out.println("Rac allocated");
            bookTicket.racBookTicket(p,'R',p.getId());
            BookTicket.racb--;
        }

        else if(BookTicket.wlb>0){
            System.out.println("Waiting List");
            bookTicket.wlBookTicket(p,'W',p.getId());
            BookTicket.wlb--;
        }
    }
}
