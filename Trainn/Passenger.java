package Trainn;

public class Passenger {
    static int idd=1;
    private int id;
    private String name;
    private int age;
    private char gender;
    private char berth;
    char allotedberth;
    int allotednumber;

    Passenger(String name,int age,char gender,char berth){
        this.id=idd++;
        this.name = name;
        this.age = age;
        this.gender=gender;
        this.berth=berth;
        allotedberth=' ';
        allotednumber=-1;
    }

    public  int getId() {return id;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public char getGender() {return gender;}
    public char getBerth() {return berth;}
    public int getAllotednumber() {return allotednumber;}
    public char getAllotedberth() {return allotedberth;}

    public void setIdd(int idd) {this.idd = idd;}
    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setGender(char gender) {this.gender = gender;}
    public void setBerth(char berth) {this.berth = berth;}
    public void setAllotedberth(char allotedberth) {this.allotedberth = allotedberth;}

    public void PrintDetails(){
        System.out.println("id : "+id+" Name : "+name+" Age : "+age+" Gender : "+gender+" Berth : "+allotedberth);
    }
}
