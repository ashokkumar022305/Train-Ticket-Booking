package Trainn;

import java.util.ArrayList;
import java.util.HashMap;

public class BookTicket {
    static int aub=1;
    static int amb=1;
    static int alb=1;
    static int racb=1;
    static int wlb=1;

    static HashMap<Integer,Passenger>map = new HashMap<>();
    static ArrayList<Passenger>list = new ArrayList<>();
    static ArrayList<Passenger>raclist = new ArrayList<>();
    static ArrayList<Passenger>wlist = new ArrayList<>();

    public void bookTicket(Passenger p,char allottedberth , int id){
      p.allotedberth=allottedberth;
      p.allotednumber=id;
      list.add(p);
      map.put(id,p);
      System.out.println("Happy Journey..!");
    }


    public void racBookTicket(Passenger p,char allottedberth , int id){
        p.allotedberth=allottedberth;
        p.allotednumber=id;
        raclist.add(p);
        map.put(id,p);
    }

    public void wlBookTicket(Passenger p,char allottedberth , int id){
        p.allotedberth=allottedberth;
        p.allotednumber=id;
        wlist.add(p);
        map.put(id,p);
    }

    public static void cancelTicket(int cancel) {
        if(!map.containsKey(cancel)){
            System.out.println("Enter the valid id");
            return;
        }
        else{
            map.remove(cancel);
        }
        boolean isFounded = false;
        char c = ' ';
        for (Passenger passenger : list) {
            if (passenger.getId() == cancel) {
                c = passenger.getAllotedberth();
                isFounded = true;
                list.remove(passenger);
                System.out.println("Removed successfully..!");
                break;
            }
        }
        if (isFounded && raclist.isEmpty() ) {
            if (c == 'U') aub++;
            else if (c == 'M') amb++;
            else if (c == 'L') alb++;
            else if (c == 'R') racb++;
            else if (c == 'W') wlb++;
        }

        if (isFounded) {
            if (!raclist.isEmpty()) {
                raclist.get(0).setAllotedberth(c);
                list.add(raclist.get(0));
                map.put(raclist.get(0).getId(),raclist.get(0));
                raclist.remove(0);
                if (wlist.isEmpty()){
                    racb++;
                }
            }
            if (!wlist.isEmpty()) {
                wlist.get(0).setAllotedberth('R');
                raclist.add(wlist.get(0));
                map.put(wlist.get(0).getId(),wlist.get(0));
                wlist.remove(0);
                wlb++;
            }
        }



        if(!isFounded){
            for (Passenger passenger : raclist){
                if(passenger.getId()==cancel){
                    isFounded =true;
                    raclist.remove(passenger);
                    System.out.println("Removed successfully..!");
                    break;
                }
            }
            if(isFounded && !wlist.isEmpty()){
                wlist.get(0).setAllotedberth('R');
                raclist.add(wlist.get(0));
                map.put(wlist.get(0).getId(),wlist.get(0));
                wlist.remove(0);
                wlb++;
            }
            else if(isFounded){
                racb++;
            }
        }



        if(!isFounded){
            for (Passenger passenger : wlist){
                if(cancel== passenger.getId()){
                    isFounded =true;
                    wlist.remove(passenger);
                    System.out.println("Removed successfully..!");
                    wlb++;
                    break;
                }
            }
        }
        if (!isFounded) {
            System.out.println("Enter the valid id");
        }
    }



    public static void printDetails(){
        System.out.println("Passenger List : ");
       // boolean found =false;
        for (Passenger passenger : map.values()){
            passenger.PrintDetails();
        }
       /* for (Passenger passenger : list){
            found=true;
            passenger.PrintDetails();
        }
        if (!found){
            System.out.println("No data found");
        }
        System.out.println("RAC passenger details :");
        for (Passenger passenger: raclist){
            passenger.PrintDetails();
        }
        System.out.println("Waiting List passenger details :");
        for (Passenger passenger : wlist){
            passenger.PrintDetails();
        }*/
    }


    public static void printavailable(){
        System.out.println("Available Upper berth : "+aub);
        System.out.println("Available Middle berth : "+amb);
        System.out.println("Available Lower berth : "+alb);
        System.out.println("Available RAC : "+racb);
        System.out.println("Available Waiting List : "+wlb);
    }

}
