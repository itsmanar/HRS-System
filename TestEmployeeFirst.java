
import java.util.Scanner;

public class TestEmployeeFirst {
// declear array as global to can deal with it any where
static Employee hiringEmployees[]  = new Employee[100] ; 
static int count ;  // index to first empty location 

public static void main(String[] args) {
Scanner input = new Scanner (System.in);
// fill array with 10 Employee
hiringEmployees[0] = new Employee(  "9876543222" ,  "Driver" , "15/12/2020" ,  "16:00" , "22:00" , true ,  1 ) ; 
hiringEmployees[1] = new Employee(  "9876543211" ,  "Cleaning Worker" ,"15/12/2020" ,  "08:00" , "16:00" , true ,  4  ) ; 
hiringEmployees[2] = new Employee(  "1234567899" ,  "Cleaning Worker" ,"N/A" ,  "N/A" , "N/A" , false ,  0  ) ; 
hiringEmployees[3] = new Employee(  "2234567891" ,  "Cleaning Worker" ,"17/12/2020" ,  "08:00" , "13:00" , true ,  2  ) ; 
hiringEmployees[4] = new Employee(  "1334567892" ,  "Driver" ,"11/12/2020" ,  "10:00" , "15:00" , true ,  1  ) ; 
hiringEmployees[5] = new Employee(  "4412356789" ,  "Cleaning Worker" ,"05/12/2020" ,  "12:00" , "16:00" , true ,  10) ; 
hiringEmployees[6] = new Employee(  "3114567894" ,  "Driver" ,"N/A" ,  "N/A" , "N/A" , false ,  2  ) ; 
hiringEmployees[7] = new Employee(  "8876543221" ,  "Driver" , "19/12/2020" ,  "08:00" , "14:00" , true ,  1 ) ; 
hiringEmployees[8] = new Employee(  "7776543267" ,  "Cleaning Worker" ,"N/A" ,  "N/A" , "N/A" , false ,  3  ) ; 
hiringEmployees[9] = new Employee(  "1176543266" ,  "Cleaning Worker" ,"02/12/2020" ,  "17:00" , "21:00" , true ,  12) ; 
count = 10 ; 
//=====================================================================
// Task  3 
System.out.println("Task 3 " ) ; 
String id_MaxFreq =  maximumFrequency(hiringEmployees[1] , hiringEmployees[2]);
if( id_MaxFreq.equals( "-1") )
System.out.println("Employees have different job titles");
else
System.out.println("Employee with the id number: (" + id_MaxFreq + ") can take a break during the weekend "); 
System.out.println(""); 

// task 4
System.out.println("Task 4 " ) ; 
String id_min =  minimumDuration(hiringEmployees[0] , hiringEmployees[1]);
if( id_min.equals( "Dates are Mismatched") )
System.out.println("Employees worked in a different date");
else
System.out.println("Employee with the id number: (" + id_min + ") worked less on ( " + hiringEmployees[0].getContractDate() + ") "); 
System.out.println(""); 

// task 5 
System.out.println("Task 5 " ) ; 
 id_MaxFreq =  maximumFrequency(hiringEmployees[0] , hiringEmployees[1]);
if( id_MaxFreq.equals( "-1") )
System.out.println("Employees have different job titles");
else
System.out.println("Employee with the id number: (" + id_MaxFreq + ") can take a break during the weekend "); 
System.out.println(""); 

// task 6
System.out.println("Task 6 " ) ; 
 id_min =  minimumDuration(hiringEmployees[1] , hiringEmployees[3]);
if( id_min.equals( "Dates are Mismatched") )
System.out.println("Employees worked in a different date");
else
System.out.println("Employee with the id number: (" + id_min + ") worked less on ( " + hiringEmployees[1].getContractDate() + ") "); 
System.out.println(""); 


//====================================================================
int choice ; 
do
{
System.out.println("Enter your choice : " ) ; 
System.out.println("1. Add a new employee" ) ;
System.out.println("2. Start a hiring contract" ) ;
System.out.println("3. End a hiring contract" ) ;
System.out.println("4. Display employee info" ) ;
System.out.println("5. Display HRS system status" ) ;
System.out.println("6. Exit" ) ;
choice = input.nextInt(); 

switch( choice )
{
case 1 :  // add new Emplyee

if( count == hiringEmployees.length)   // if array is full 
{
System.out.println("list is full"); 
break; 
}
System.out.println("Enter id "); 
String id = input.next(); 

boolean found = false ;    // search if id is exists in list
for( int i = 0 ;i < count  ;  i++)
if( hiringEmployees[i].getId() .equals( id )  ) 
{
System.out.println("Sorry , this id is already exists."); 
found = true; 
} 

if( found == true)    // then go back to menu

break ; 

System.out.println("Enter Jop"); 
input.nextLine();
String jop = input.nextLine(); 

hiringEmployees[count] = new Employee( ) ;   // creat object in array
hiringEmployees[count].setId( id ); 
hiringEmployees[count].setJobTitle(jop); 
hiringEmployees[count].setContractDate("N/A");
hiringEmployees[count].setStartTime("N/A");
hiringEmployees[count].setEndTime("N/A");
hiringEmployees[count].setHired(false);
hiringEmployees[count].setFrequency(0);
count++; 
System.out.println("add one Employee successful");
break; 
case 2 : 

System.out.println("Enter id ");
String d = input.next(); 

int loc = -1 ; 
for( int i = 0 ; i < count ; i++)
if( hiringEmployees[i].getId() .equals(d))
loc = i ; 


if( loc == -1 )
{
System.out.println("this id is not founed");
break; 
}

if( hiringEmployees[loc].getHired() ==  true )
{
System.out.println("this Employee is alreadey hierd ");
break; 
}

System.out.println("Ente Contract Date Format dd/mm/yyyy");
hiringEmployees[loc].setContractDate(   input.next()  );
System.out.println("Enter  contract???s start time (Format HH:00) using 24-hours notation");
hiringEmployees[loc].setStartTime(input.next() );
System.out.println("Enter  contract???s ends time (Format HH:00) using 24-hours notation");
hiringEmployees[loc].setEndTime( input.next() );

hiringEmployees[loc].setHired(true);
hiringEmployees[loc].updateFrequency();

System.out.println("Employee is now ready for starting the assigned job");
hiringEmployees[loc].displayInfo();

break; 

case 3 : 
System.out.println("Enter id ");
d = input.next(); 

loc = -1 ; 
for( int i = 0 ; i < count ; i++)
if( hiringEmployees[i].getId() .equals(d))
loc = i ; 


if( loc == -1 )
{
System.out.println("this id is not foune");
break; 
}

if( hiringEmployees[loc].getHired() ==  false )
{
System.out.println("this Employee is not hired ");
break; 
}
// duration 
System.out.println("Employee's duration : " + hiringEmployees[loc].calculateDuration() );
hiringEmployees[loc].displayInfo();
hiringEmployees[loc].setContractDate("N/A" );
hiringEmployees[loc].setStartTime("N/A" );
hiringEmployees[loc].setEndTime( "N/A" );

hiringEmployees[loc].setHired(false);

break; 

case 4 : 
System.out.println("Enter id ");
d = input.next(); 

loc = -1 ; 
for( int i = 0 ; i < count ; i++)
if( hiringEmployees[i].getId() .equals(d))
loc = i ; 


if( loc == -1 )
{
System.out.println("this id is not foune");
break; 
}

hiringEmployees[loc].displayInfo();

break; 

case 5 : 
if( count == 0 ) {
    System.out.println("empty list");
    break; }

int NoHired = 0 , NoAvailable = 0 ; 
for( int i = 0 ;i < count ; i++)
if( hiringEmployees[i].getHired() == true )
NoHired++; 
else
NoAvailable++; 

int max = 0 ; 
for( int i = 1 ;i < count ; i++)
    if( hiringEmployees[i].getFrequency() > hiringEmployees[max].getFrequency() )
        max = i ; 
        
String Id_max_freq =  hiringEmployees[max].getId()  ; 

System.out.println("The total number of employees who are currently registered in the system." + count );
System.out.println("The current number of hired employees  : " +  NoHired);
System.out.println("The number of available employees :  " + NoAvailable);

System.out.println("The id of the employee with the highest hiring frequency : " + Id_max_freq);
System.out.println(" A listing of all the employees in a table " ) ; 

System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|%-4s|\n","id" , "job" , "Date" ,
                      "sTime" , "eTime" , "hire"   ,"freq" ) ; 
for( int i = 0 ;i < count  ; i++)
hiringEmployees[i].displayInfo();
break; 

case 6 : 
    System.out.println("All info. will be lost. Are you sure you want to exit? (Yes/No)");
    String ansr = input.next(); 
    
    if( ansr.equalsIgnoreCase("yes"))
    {
        System.out.println("Good by ....");
    }
    else
        if( ansr.equalsIgnoreCase("no"))
        choice = 0; // to can return to do and print menu
    else{
            System.out.println("only yes or no accepted.");
            choice = 0 ; }

break; 
default : 
System.out.println("Not a valid selection!"); 

}// end switch

}while( choice != 6 ) ; 




}// end main

public static String maximumFrequency(Employee one, Employee two)
{
    
if( one.getJobTitle().equalsIgnoreCase(two.getJobTitle() )){
    if( one.getFrequency() > two.getFrequency() )
      return  one.getId() ; 
      else
      if( one.getFrequency() < two.getFrequency() )
      return  two.getId() ; 
      else
      return one.getId() + " - " + two.getId(); 

 }     
else
return "-1" ; 
}

public static String minimumDuration(Employee one, Employee two)
{
if( one.getContractDate().equalsIgnoreCase(two.getContractDate())){
    if( one.calculateDuration()< two.calculateDuration())
      return  one.getId() ; 
       else
       return  two.getId() ; }

return "Dates are Mismatched" ; 
}



}






















