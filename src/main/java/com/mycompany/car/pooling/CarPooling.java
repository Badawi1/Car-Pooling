
package com.mycompany.car.pooling;

import java.util.*;

/**
 * Car pooling class which contains the main function
 */
public class CarPooling {

    /**
     * In the main function i create array of passengers, array of cars and array of routes of the cars then entering the data hard coded
     * Then i call the methods in the switch case
     * @param args String array
     */
    public static void main(String[] args) {
        
       
        Scanner input = new Scanner(System.in);
        passenger pass[] = new passenger[passenger.npassengers];
        car cr[] = new car[car.ncars];
        route rt[] = new route[route.nroutes];

        rt[0] = new route("sheraton","nozha");
        rt[1] = new route("dokki","maadi");
        rt[2] = new route("abbasya","ramses");
        cr[0] = new car(101,20,1,"ahmed",rt[0]);// id / number of trips per day / maximum capacity
        cr[1] = new car(201,15,2,"omar",rt[1]);
        cr[2] = new car(301,10,5,"wael",rt[2]);
        pass[0] = new nonsubscriber("mohamed",45,22); // name / age / id
        pass[1] = new subscriber("abdelrahman",50,44,50);// name / age / id / number of trips
        pass[2] = new nonsubscriber("zidan",20,66);

        int choice=0;
        int id;
        boolean flag;
        while(choice!=8)
        {
            System.out.println("[1] Search for routes");
            System.out.println("[2] Resereve");
            System.out.println("[3] Subscribe");
            System.out.println("[4] UnSubscribe");
            System.out.println("[5] Report Complaint/Review");
            System.out.println("[6] Display Passengers data");
            System.out.println("[7] Add a new car with a new route");
            System.out.println("[8] Exit");
                choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter Your id");
                id = input.nextInt();
                flag=false;
                for(int i=0;i<pass.length;i++)
                {
                    if(id==pass[i].getId())
                    {
                        flag=true;
                        pass[i].Search(cr);
                        break;
                    }
                }
                if(flag==false)
                {
                    System.out.println("Wrong ID");
                }
                    break;
                case 2:
                    System.out.println("Enter Your id");
                id = input.nextInt();
                flag = false;
                for(int i=0;i<pass.length;i++)
                {
                    if(id==pass[i].getId())
                    {
                        flag=true;
                        pass[i].Reserve(cr);
                        break;
                    }
                }
                if(flag==false)
                {
                    System.out.println("Wrong ID");
                }
                    break;
                    case 3:
                    System.out.println("Enter Your id");
                id = input.nextInt();
                flag=false;
                for(int i=0;i<pass.length;i++)
                {
                    if(id==pass[i].getId())
                    {
                        flag=true;
                        pass[i].subscribe(pass,id);
                        break;
                    }
                }
                if(flag==false)
                {
                    System.out.println("Wrong ID");
                }
                    break;
                    case 4:
                    System.out.println("Enter Your id");
                id = input.nextInt();
                flag=false;
                for(int i=0;i<pass.length;i++)
                {
                    if(id==pass[i].getId())
                    {
                        flag=true;
                        pass[i].unsubscribe(pass,id);
                        break;
                    }
                }
                if(flag==false)
                {
                    System.out.println("Wrong ID");
                }
                    break;
                    case 5:
                        System.out.println("Enter Your id");
                id = input.nextInt();
                flag=false;
                for(int i=0;i<pass.length;i++)
                {
                    if(id==pass[i].getId())
                    {
                        flag=true;
                        pass[i].reportReview(cr);
                        break;
                    }
                }
                if(flag==false)
                {
                    System.out.println("Wrong ID");
                }
                        break;
                    case 6:
                             displayPassengers.displayAllPassengers(cr, pass);
                        break;
                    case 7:
                        rt = addNewCar.addnewRoute(rt);
                        cr = addNewCar.addnewCar(cr, rt[route.nroutes-1]);
                        break;       
            }
        }
    }
}

/**
 *
 * class route which contains the routes of the cars(start location and destination)
 */
 class route
{
   
    /**
     * the start location and it is final because it is constant
     * Final Data member
     */
    protected final String location;
   
    /**
     * the destination and it is final because it is constant
     * Final Data member
     */
    protected final String destination;
   
    /**
     *The number of routes (the size of the array of routes)
     * Static Data member Because i will use it in the main
     */
    protected static int nroutes=3;
  
    /**
     *the constructor of the route class
     * @param location of the route
     * @param destination of the route
     */
    public route(String location,String destination)
    {
        this.location = location;
        this.destination = destination;
    }

    /**
     * Getter method of the location
     * @return location of the route
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter method of the destination
     * @return destination of the route
     */
    public String getDestination() {
        return destination;
    }

    
   
}

/**
 * ticket class which contains the car code and the price of the car trip
 */
 class ticket
{

    /**
     * the price of the car trip
     * Calculated data member ( calculated when the passenger book a ticket)
     */
    private float price;

    /**
     * the car code that the passenger reserved
     */
    private int carcode;

    /**
     * default constructor of the ticket
     */
    public ticket()
    {
    
    }

    /**
     *parameterized constructor of the ticket
     * here i used overloading (with the default constructor)
     * @param price of the ticket
     * @param carcode of the car that the passenger rode
     */
    public ticket(int price, int carcode) {
        this.price = price;
        this.carcode = carcode;
    }

    /**
     * Getter Method of the price
     * @return price of the ticket
     */
    public float getPrice() {
        return price;
    }

    /**
     *Setter method of the price
     * @param price of the ticket
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *Getter method of car code
     * @return car code of the car that the passenger rode
     */
    public int getCarcode() {
        return carcode;
    }

    /**
     *Setter method of car code
     * @param carcode of the car that the passenger rode
     */
    public void setCarcode(int carcode) {
        this.carcode = carcode;
    }
    
}

/**
 * car class which contains the unique code of the car, number of trips per day, maximum capacity of the car,driver name of the car and unique route(object from the route)
 */
 class car 
{

    /**
     * the unique code of the car
     */
    public int code;

    /**
     * number of trips per day
     */
    private int numOfTrips;

    /**
     * maximum capacity of the car
     */
    private int maxCapacity;

    /**
     * car's driver name
     */
    public String driverName;

    /**
     * the unique route of the car(object from route class)
     */
    public route rt;

    /**
     * boolean data member to check the car if available or not
     */
    private boolean available;

    /**
     * Number of cars(size of cars array)
     * Static Data member because i will use it in the main
     */
    protected static int ncars =3;
    
    /**
     * it is array list which contains the reviews of the car which passenger rode
     */
    protected ArrayList<String> reviews;
        
    /**
     * parameterized constructor of the car
     * I set the boolean data member available to true because the car is available at the start
     * initialize object of array list of reviews
     * @param code of the car
     * @param numOfTrips number of trips per day
     * @param maxCapacity maximum car capacity
     * @param driverName of the car
     * @param rt the route of the car
     */
    public car(int code,int numOfTrips,int maxCapacity,String driverName,route rt)
        {
            this.code = code;
            this.numOfTrips = numOfTrips;
            this.maxCapacity = maxCapacity;
            this.driverName = driverName;
            this.rt = rt;
            this.available = true;
            reviews = new ArrayList<>();
        }

    /**
     * Getter method of the reviews array list
     * @return reviews of the car
     */
    public ArrayList<String> getReviews() {
        return reviews;
    }

    /**
     * Setter method of the reviews array list
     * @param reviews of the car
     */
    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }
        
    /**
     *Getter Method of the car code
     * @return code of the car
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter Method of the car code
     * @param code of the car
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter method of the number of trips per day
     * @return numofTrips per day of the car
     */
    public int getNumOfTrips() {
        return numOfTrips;
    }

    /**
     * Setter method of the number of trips per day
     * @param numOfTrips per day of the car
     */
    public void setNumOfTrips(int numOfTrips) {
        this.numOfTrips = numOfTrips;
    }

    /**
     * Getter method of the maximum capacity of the car
     * @return maximum capacity of the car
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Setter method of the maximum capacity of the car
     * @param maxCapacity of the car
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Getter method of the driver name
     * @return driverName of the car
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Setter method of the driver name
     * @param driverName of the car
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * Getter method to check the car if available
     * @return if the car is available or not
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Setter method to set the car if available or not
     * @param available availability of the car
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Getter method of the object route of the car
     * @return route of the car
     */
    public route getRt() {
        return rt;
    }

    /**
     * Setter method to the object route of the car
     * @param rt route of the car
     */
    public void setRt(route rt) {
        this.rt = rt;
    }
   
        
}

/**
 * Passenger interface which contains the search method and the reportReview method
 */
interface pass
{

    /**
     * Search method to search the car routes to book them
     * @param c the cars array
     */
    public void Search(car c[]);

    /**
     * reportReview method to write a review or a complaint of the ride
     * @param c the cars array
     */
    public void reportReview(car c[]);
}

/**
 * passenger class which contains the information of the passenger and his functions
 * abstract class implements the pass interface
 */
abstract  class passenger implements pass
{

    /**
     * The name of the passenger
     */
    private String name;

    /**
     *The age of the passenger
     */
    protected int age;

    /**
     *The id of the passenger
     */
    private int id;

    /**
     * Number of passengers ( the size of the array of passengers)
     * Static data member
     */
    protected static int npassengers=3;

    /**
     * array list of tickets of the cars which the passenger rode ( to link between the passenger and the car )
     */
    protected ArrayList<ticket> ti;

    /**
     * object from class ticket 
     */
    protected ticket t;

    /**
     * parameterized constructor of the passenger class
     * I initialized object of the array list of tickets
     * @param name of the passenger
     * @param age of the passenger 
     * @param id of the passenger
     */
    public passenger(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
        ti=new ArrayList<>();
    }

    /**
     * Getter method of the passenger name
     * @return name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method of the passenger name
     * @param name of the passenger
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method of the passenger age
     * @return age of the passenger
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method of the passenger age
     * @param age of the passenger
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method of the passenger id
     * @return id of the passenger
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method of the passenger id
     * @param id of the passenger
     */
    public void setId(int id) {
        this.id = id;
    }

    /** 
     * Overriden method from interface pass 
     * Final method
     * The passenger enters the start location and the destination he wants to reserve
     * if the route is available it displays that the route is available with the car code of the car if he wants to reserve
     * if the route is not available it displays that the route is not available
     * @param c the array of cars to search the routes in it
     */
    @Override
    public final void Search(car c[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The Start Location");
        String location = input.next();
        System.out.println("Enter The destination");
        String destination = input.next();
        
        boolean flag = false;
        for(int i=0; i<c.length; i++)
        {
        if(location.equals(c[i].rt.location)&&destination.equals(c[i].rt.destination))
        {
            if(c[i].isAvailable())
            {
            System.out.println("This route is available with the car code: " + c[i].getCode());
            flag = true;
            break;
            }
        }
        }
        if(flag==false)
        {
            System.out.println("This route is not available");
        }
    }
    
    /**
     * abstract method will be overrided in the subclass 
     * ( i override this method because the price of the ticket will change depends on if the passenger subscriber or not)
     * @param c array of the cars
     */
    abstract public void Reserve(car c[]);
    
    /**
     * abstract method will be overrided in the subclass 
     * ( i override this method because it depends on the passenger type if he was instance of subscriber so he cannot subscribe again and if he was a non-subscriber so he can subscribe)
     * @param p passengers array
     * @param ids id of the passenger taken from the main function
     */
    abstract public void subscribe(passenger[] p,int ids);

    /**
     * abstract method will be overrided in the subclass 
     * ( i override this method because it depends on the passenger type if he was instance of subscriber so he can un-subscribe and if he was a non-subscriber so he cannot un-subscribe)
     * @param p passengers array
     * @param ids id of the passenger taken from the main function
     */
    abstract public void unsubscribe(passenger[] p,int ids);
 
    /**
     * First the passenger enter the car code of the car which he wants to write the review
     * then i check if he rood this car or not
     * if he rood this car so he can write the review then it will be added the reviews of the car ( reviews array list of the car)
     * if he didn't ride this car so i display that he didn't ride this car
     * @param c the array of cars
     */
    @Override
  public void reportReview(car c[])
  {
      Scanner input = new Scanner(System.in);
      System.out.println("Please Enter Car Code You Want To Report");
      int cd = input.nextInt();
      boolean flag = false;
      for(int i=0; i<ti.size(); i++)
      {
          if(cd==ti.get(i).getCarcode())
          {
              System.out.println("Please Report Your Review");
              String report = input.next();
              System.out.println("Report Submitted");
              flag = true;
              for(int j=0;j<c.length;j++)
              {
                  if(cd==c[j].getCode())
                  {
                      c[j].reviews.add(report);
                      break;
                  }
              }
              break;
          }
      }
      if(flag==false)
      {
          System.out.println("You didn't ride this car");
      }
  }
  
}

/**
 * subclass non-subscriber inherits from passenger class and contains the overriden methods
 * 
 */
 class nonsubscriber extends passenger
{

    /**
     * constructor of the non-subscriber
     * here i call the constructor of the parent class ( passenger )
     * @param name of the passenger
     * @param age of the passenger
     * @param id of the passenger
     */
    public nonsubscriber(String name, int age, int id) {
        super(name, age, id);
    }
    
    /**
     * Overriden method from parent class (passenger)
     * ( i divided the cars into three categories and the price depends on the category of the car )
     * ( the first category that has id between 100 and 200 and its price is low)
     * ( the second category that has id between 200 and 300 and its price is medium)
     * ( the third category that has id between 300 and 400 and its price is high)
     * Passenger(non-subscriber) enters the car code of the car he wants to reserve ( which it displayed when he searched the route )
     * then i check if the car available or not ( or the car code exist or not )
     * if the car is available so i check which category he reserved
     * then i create object from ticket and put the price(depends on the category) and the car code of the car then add it to the tickets of the passenger ( array list of tickets)
     * then i decrease the capacity of the car
     * then i check if the capacity reached zero then i set the car that is not available
     * then i display the ticket price 
     * if the car is not available or the car code is not exist so we display that the car is not available
     * @param c the array of cars
     * throws: Exception ( java defined exception ) if the passenger enters the car code in string
     */
    @Override
public void Reserve(car c[])
{
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Car's Code you want to reserve");
    try{
    int carcode = input.nextInt();
    
    
    boolean flag = false;
        for(int i=0; i<c.length; i++)
        {
            if(carcode==c[i].getCode())
            {
                if(c[i].isAvailable())
                {
                flag = true;
                if(carcode>100 && carcode<200)
                {
                    t = new ticket(40,carcode);
                    ti.add(t);
                    c[i].setMaxCapacity(c[i].getMaxCapacity()-1);
                    if(c[i].getMaxCapacity()<1)
                    {
                        c[i].setAvailable(false);
                    }
                    System.out.println("Ticket Reserved and the price is "+t.getPrice()+ " pounds");

                    break;
                }
                else if(carcode>200 && carcode<300)
                {
                    t = new ticket(70,carcode);
                    ti.add(t);
                    c[i].setMaxCapacity(c[i].getMaxCapacity()-1);
                    if(c[i].getMaxCapacity()<1)
                    {
                        c[i].setAvailable(false);
                    }
                    System.out.println("Ticket Reserved and the price is "+t.getPrice()+ " pounds");
                    
                    break;
                }
                else if(carcode>300 && carcode<400)
                {
                    t = new ticket(100,carcode);
                    ti.add(t);
                    c[i].setMaxCapacity(c[i].getMaxCapacity()-1);
                    if(c[i].getMaxCapacity()<1)
                    {
                        c[i].setAvailable(false);
                    }
                    System.out.println("Ticket Reserved and the price is "+t.getPrice()+ " pounds");
                    
                    break;
                }
            }
            }
        }
         if(flag==false)
         {
          System.out.println("This car is not available");
         }
    }
    catch(Exception ex){
        System.out.println(ex.toString());
    }
}

    /**
     * Overriden method from the parent class ( passenger )
     * passenger(non-subscriber) enters the number of trips he wants to reserve
     * then we check the age and the number of trips if they are below the minimum so we display that he cannot subscribe
     * if they are above the minimum i make the passenger(non-subscriber) instance of subscriber ( here i used Polymorphism )
     * @param p the array of passengers
     * @param ids the id of the passenger that he want to subscribe
     * throws: InvalidInput Exception ( user defined exception ) if the number of trips or the age were below the minimum
     */
    @Override
public void subscribe(passenger[] p,int ids)
{
    Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of trips you want to reserve");
        int ntrips = input.nextInt();
        try{
        if(ntrips<20||age<40)
        {
            throw new InvalidInput("The minimum number of trips to subscribe are 20 and the minimum age to subscribe is 40");
        }
        
        
        else {
        for(int i=0;i<p.length;i++)
        {
            if(p[i].getId()==ids)
            {
                p[i] = new subscriber(p[i].getName(),p[i].getAge(),p[i].getId(),ntrips);
                System.out.println("Subscribed");
                break;
            }
        }
        
            }
        
}
        catch(InvalidInput ex)
        {
            System.out.println(ex.getMessage());
        }
}

    /**
     *Overriden method from the parent class ( passenger )
     * Because he is already a non-subscriber so we display that he cannot un-subscribe
     * @param p the array of passengers
     * @param ids the id of the passenger
     */
    @Override
public void unsubscribe(passenger[] p,int ids)
{
    System.out.println("You Are Already a non-subscriber");
}
}

/**
 *subclass subscriber inherits from passenger class and contains the Overriden methods
 */
 class subscriber extends passenger
{

    /**
     * the number of trips of the subscriber ( calculated data member because it decreasing every time the subscriber reserve a trip )
     */
    protected int numoftrips;

    /**
     *constructor of the subscriber class
     * here i call the constructor of the parent class ( passenger )
     * @param name of the subscriber
     * @param age of the subscriber
     * @param id of the subscriber 
     * @param numoftrips of the subscriber
     */
    public subscriber(String name, int age, int id,int numoftrips) {
        super(name, age, id);
        this.numoftrips=numoftrips;
    }

    /**
     * Getter method of the number of trips of the subscriber
     * @return number of trips of the subscriber 
     */
    public int getNumoftrips() {
        return numoftrips;
    }

    /**
     * Setter method of the number of trips of the subscriber
     * @param numoftrips of the subscriber
     */
    public void setNumoftrips(int numoftrips) {
        this.numoftrips = numoftrips;
    }
    
    /**
     * Overriden method from the parent class ( passenger )
     *( i divided the cars into three categories and the price depends on the category of the car )
     * ( the first category that has id between 100 and 200 and its price is low)
     * ( the second category that has id between 200 and 300 and its price is medium)
     * ( the third category that has id between 300 and 400 and its price is high)
     * Passenger (subscriber) enters the car code of the car he wants to reserve ( which it displayed when he searched the route )
     * then i check if the car available or not ( or the car code exist or not )
     * if the car is available so i check which category he reserved
     * then i create object from ticket and put the price with the 50% discount(depends on the category) and the car code of the car then add it to the tickets of the passenger ( array list of tickets)
     * then i decrease the number of trips that he subscribed
     * then i decrease the capacity of the car 
     * then i check if the capacity reached zero then i set the car that is not available
     * then i display the ticket price and the remaining number of trips
     * if the car is not available or the car code is not exist so we display that the car is not available
     * @param c the array of cars
     * throws: Exception ( java defined exception ) if he entered the car code in string
     */
    @Override
public void Reserve(car c[])
{
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Car's Code you want to reserve");
    try{
    int carcode = input.nextInt();
    boolean flag = false;
        for(int i=0; i<c.length; i++)
        {
            if(carcode==c[i].getCode())
            {
                if(c[i].isAvailable())
                {
                flag = true;
                if(carcode>100 && carcode<200)
                {
                    t = new ticket(20,carcode);
                    ti.add(t);
                    c[i].setMaxCapacity(c[i].getMaxCapacity()-1);
                    if(c[i].getMaxCapacity()<1)
                    {
                        c[i].setAvailable(false);
                    }
                    System.out.println("Ticket Reserved and the price is "+t.getPrice()+ " pounds");
                    numoftrips--;
                    System.out.println("Number Of Trips Remained is "+numoftrips);
                    break;
                }
                else if(carcode>200 && carcode<300)
                {
                    t = new ticket(35,carcode);
                    ti.add(t);
                    c[i].setMaxCapacity(c[i].getMaxCapacity()-1);
                    if(c[i].getMaxCapacity()<1)
                    {
                        c[i].setAvailable(false);
                    }
                    System.out.println("Ticket Reserved and the price is "+t.getPrice()+ " pounds");
                    numoftrips--;
                    System.out.println("Number Of Trips Remained is "+numoftrips);
                    break;
                }
                else if(carcode>300 && carcode<400)
                {
                    t = new ticket(50,carcode);
                    ti.add(t);
                    c[i].setMaxCapacity(c[i].getMaxCapacity()-1);
                    if(c[i].getMaxCapacity()<1)
                    {
                        c[i].setAvailable(false);
                    }
                    System.out.println("Ticket Reserved and the price is "+t.getPrice()+ " pounds");
                    numoftrips--;
                    System.out.println("Number Of Trips Remained is "+numoftrips);
                    break;
                }
            }
            }
        }
         if(flag==false)
         {
          System.out.println("This car is not available");
         }
    }
    catch(Exception ex){
        System.out.println(ex.toString());
    }
}

    /**
     * Overriden method from the parent class ( passenger )
     * the subscriber cannot subscribe so i display that he is already a subscriber
     * @param p the passengers array
     * @param ids the id of the passenger ( subscriber )
     */
    @Override
public void subscribe(passenger[] p,int ids)
{
    System.out.println("You Are Already a subscriber");
}

    /**
     * Overriden method from the parent class ( passenger )
     * i make the passenger(subscriber) instance of non-subscriber ( here i used Polymorphism )
     * @param p the array of passengers
     * @param ids the id of the subscriber
     */
    @Override
public void unsubscribe(passenger[] p,int ids)
{
        for(int i=0;i<p.length;i++)
        {
            if(p[i].getId()==ids)
            {
                p[i] = new nonsubscriber(p[i].getName(),p[i].getAge(),p[i].getId());
                System.out.println("UnSubscribed");
                break;
            }
        }
      
}
}

/**
 * Invalid input class of user defined exception 
 */
class InvalidInput extends Exception
    {
         InvalidInput(String s)
        {
            super(s);
        }
        
    }

/**
 * i created single class to display the passengers with the cars the rode 
 * to apply the Single Responsibility Principle which means that the class should have only one job
 * so it's not the passenger job to display all the passengers so i created this class to display all the passengers
 */
 class displayPassengers
{

    /**
     * Static method which displays all the passengers with the cars they rode
     * Firstly i display the passenger then i check if he rode any of the cars then i display it ( using the array list of tickets which contains the car code that the passenger rode)
     * then if he did not ride any car then i display None
     * and so on to all the passengers
     * @param c the array of cars
     * @param p the array of passengers
     */
    public static void displayAllPassengers(car[] c,passenger[] p)
    {
        
         
         for(int i=0;i<p.length;i++){
             boolean flag = false;
      String n = p[i].getName();
      int a = p[i].getAge();
      int d = p[i].getId();
          System.out.println("Passenger name is "+ n);
          System.out.println("Passenger age is "+a);
          System.out.println("Passenger id is "+d);
          System.out.println("The Cars Details Which The Passenger Rode");
          for(int j=0; j<p[i].ti.size(); j++)
      {
          for(int z=0; z<c.length; z++)
          {
          if(p[i].ti.get(j).getCarcode()==c[z].getCode())
          {
              System.out.println("Car Code is "+c[z].getCode());
              System.out.println("The Start Location is "+c[z].getRt().getLocation());
              System.out.println("The Destination is "+c[z].getRt().getDestination());
              System.out.println("Car Driver Name is "+c[z].getDriverName());
              System.out.println("The Ticket Price is "+p[i].ti.get(j).getPrice());
              flag = true;
              break;
          }
              }
      }
          if(flag==false)
      System.out.println("None");
         }
          
    }
    
}

/**
 *i created single class to add a new car with a new route 
 * to apply the Single Responsibility Principle which means that the class should have only one job
 * so it's not any of the classes job to add a new car with a new route so i created this class to do this job
 */
class addNewCar
{

    /**
     * Static method to add a new route to the routes array
     * first i enter the location and the destination of the route
     * first i create new array of routes with size of the old array +1 ( number of routes )
     * then i copy the elements from the old array to the new array
     * then i put in the last index of the new array an object of class route
     * then i increase the number of routes
     * @param r the array of routes
     * @return the new array of routes
     * @see <a href="https://www.geeksforgeeks.org/how-to-add-an-element-to-an-array-in-java/">Reference</a>
     */
    public static route[] addnewRoute(route[] r)
    {
        route newrt[] = new route[route.nroutes+1];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter location");
        String loc = input.next();
        System.out.println("Enter destination");
        String dest = input.next();
        for(int i =0;i<route.nroutes;i++)
        {
            newrt[i]= r[i];
        }
        newrt[route.nroutes] = new route(loc,dest);
        route.nroutes++;
        return newrt;
    }
    
    /**
     *Static method to add a new car to the cars array
     * first i enter the car code, number of trips per day, car maximum capacity and the driver name
     * first i create new array of cars with size of the old array +1 ( number of cars)
     * then i copy the elements from the old array to the new array
     * then i put in the last index of the new array an object of class car
     * then i increase the number of cars
     * @param cr the array of cars
     * @param r object of class route
     * @return the new array of cars
     * @see <a href="https://www.geeksforgeeks.org/how-to-add-an-element-to-an-array-in-java/">Reference</a>
     */
    public static car[] addnewCar(car[] cr,route r)
    {
        car newcar[] = new car[car.ncars+1];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter car code");
        int cod = input.nextInt();
        System.out.println("Enter car number of trips per day");
        int num = input.nextInt();
        System.out.println("Enter car maximum capacity");
        int capc = input.nextInt();
        System.out.println("Enter the driver name");
        String dname = input.next();
        for(int i =0;i<car.ncars;i++)
        {
            newcar[i]= cr[i];
        }
        newcar[car.ncars] = new car(cod,num,capc,dname,r);
        car.ncars++;
        return newcar;
    }
    
}
