

package projects;
import java.util.*;
import java.util.InputMismatchException;

//main class
public class Main {
    public static void main(String[] args) {
    Supervisor headOfProgram = new Supervisor(); 
    //sample data to initialize system
    headOfProgram.addCourse(new Course("Liner algabra","Dr.Sara","Math"));
    headOfProgram.addCourse(new Course("Java programing","Dr.Amal","Computer scince"));
    headOfProgram.addCourse(new Course("Acadmic writing","Dr.Norah","English language"));
    headOfProgram.addCourse(new Course("Calculus","Dr.Farah","Math"));
   //command line interface to allow supervisor and students to interact with the system    
   System.out.println("Welcome to Course Management System");
   System.out.println("please select your role:");
   System.out.println("1. Supervisor");
   System.out.println("2. Student");
   System.out.println("3. Exit");
   System.out.println("Enter your choice:");  
   Scanner input = new Scanner(System.in);//to get input from user
   
   try {//error handling for invalid input
   int num = input.nextInt();
   if (num==1){//supervisor menu of options
   System.out.println("Welcome to Courses Management System");    
   System.out.println("1. Add a new course to the system");
   System.out.println("2. Display courses based on area");
   System.out.println("3. Search for a course by title");
   System.out.println("4. Search for a course by instructor");
   System.out.println("5. Display all courses"); 
   System.out.println("6. Exit"); 
   System.out.println("Enter your choice number");    
   int num2 = input.nextInt();  
   switch(num2){ //actions to perform for supervisor
           case 1:
       System.out.println("Enter the course title:");
       String title = input.nextLine();
       input.nextLine();
       System.out.println("Enter the name of the instractor:");
       String instractor = input.nextLine();
       System.out.println("Enter the name of area:");
       String area = input.nextLine();
       headOfProgram.addCourse(new Course(title,instractor,area));
       System.out.println("Course added successfully");
        break;   

    case 2:  
       System.out.println("Enter name of area");
       String seerch = input.nextLine();
        headOfProgram.displayCourseByArea(seerch);
        break;   
    case 3:       
       System.out.println("Enter course title to search");
       String search = input.nextLine();
       headOfProgram.searchByTitle(search);
       break;
    case 4: 
        System.out.println("Enter course instractor to search");
        String search2 = input.nextLine();
        headOfProgram.searchByInstructor(search2);
        break;
    case 5:
       headOfProgram.displayCourse();
      break;   
    case 6:
        System.out.println("Goodbye");
        break;
    default: 
        System.out.println("Invaild choice number from 1 to 6 ");         
    }     
    }
    else if (num==2){//students menu options
       System.out.println("Welcome to Courses Management System");
       System.out.println("1. Search for course by title");
       System.out.println("2. Search for course by instructor name");
       System.out.println("3. Search for courses by area name");
       System.out.println("4. Display all courses");
       System.out.println("5. Exit");
       System.out.println("Enter your choice number");
       int y = input.nextInt();
    switch(y){ //actions to preform for students
     case 1:
       System.out.println("Enter course title to search");
       String name = input.nextLine();
       input.nextLine();
       headOfProgram.searchByTitle(name);
       break;
    case 2:
       System.out.println("Enter course instractor to search");
       String name2 = input.nextLine();
       headOfProgram.searchByInstructor(name2);
       break;
    case 3:
        System.out.println("Enter name of area:");
        String name3 = input.nextLine();
        headOfProgram.displayCourseByArea(name3);
        break;
    case 4:
       headOfProgram.browseCourse();
    case 5:
        System.out.println("GoodBye");
       break;
     default:
        System.out.println("Invaild choice, choes number from 1 to 3");      
       }    
   } 
    else if (num==3){// exit option
     System.out.println("GoodBye");
    }
    else System.out.println("Plese choose number from 1 to 3 to start the program");// if user choose number out of the three option
}
   catch (InputMismatchException e){//if user input not intrger this will catch the error
       System.out.println("invaild input, plese try again");
   }
    }
}

class Course {
    //instance variables
    private String title;
    private String instructor;
    private String area;
   //set methods to set the title, instructor and area of courses in the object
 public void setTitle(String title){
     this.title = title; // store the title
 }  
 public void setInstructor(String instructor){
     this.instructor = instructor; //store the instructor
 }  
 public void setArea(String area){
     this.area = area; //store the area
 }    
  //get methods to retrieve the title, instructor and area from the object  
 public String getTitle(){
     return title; //return value of title to caller
 }   
public String getInstructor(){
    return instructor; // return value of instructor to caller
}    
 public String getArea(){
     return area; //return value of area to caller
 }   
    public Course(String title, String instructor, String area){//constructor
        this.title = title;
        this.instructor = instructor;
        this.area = area;
    }  
}

class Supervisor {
 //an arrayList to store, add and display courses
 private ArrayList<Course> courses = new ArrayList();   
 //method to add a new course to the system, using the add method in the arrayList  
 public void addCourse(Course c){
     courses.add(c); 
}   
 //method to display list of all courses in system
 public void displayCourse(){
     if (courses.isEmpty()){//same as (courses.size()==0)
      System.out.println("There is no courses found to display");
       } else {
      for (Course c: courses){//loop for course object
      System.out.println(c.getTitle()+ " "+ c.getInstructor()+" "+c.getArea());
      }                
     }      
 }
 //method to browse courses and it's same as the display method
 public void browseCourse(){
     if (courses.isEmpty()){//same as (courses.size()==0)
     System.out.println("There is no courses found to browse");
       } else {
    System.out.println("courses available for browsing:");
      for (Course c: courses){//loop for course object
    System.out.println(c.getTitle()+ " "+ c.getInstructor()+" "+c.getArea());
      }                
     }
 }
//method to search by title
 public void searchByTitle (String courseTitle){          
    boolean search = false;
    for (Course course : courses){        
          if(course.getTitle().compareToIgnoreCase(courseTitle) ==0 ){ 
     /*we use the method ComparetoIgnoreCase to ensure it`ll give us a matching courseTitle.
     ==0 which means they`re matching.*/        
    System.out.println("Course Title: "+ course.getTitle()+ ", Instructor: "+ course.getInstructor()+ ", Area:"+ course.getArea());                
    search = true;   //update the value 
         } }                                
    if (!search){   //if no matches were found,print a message                                     
    System.out.println("No courses found with this title");}
    }
//method to search by instructor
 public void searchByInstructor (String instructor){            
    boolean search = false;
    for (Course course : courses){        
      if(course.getInstructor().compareToIgnoreCase(instructor) ==0 ){       
      /*we use the method ComparetoIgnoreCase to ensure it`ll give us a matching courseTitle.
      ==0 which means they`re matching.*/        
    System.out.println("Course Title: "+course.getTitle()+", Instructor: "+course.getInstructor()+", Area:"+ course.getArea());                
    search = true;   //update the value 
                } }
        if (!search){       //if no matches were found,print a message                          
    System.out.println("No courses found with this instrctor");}
    }
 //method to display courses by area
 public void displayCourseByArea (String area){            
    boolean search = false;
    for (Course course : courses){        
      if(course.getArea().compareToIgnoreCase(area) ==0 ){         
      /*we use the method ComparetoIgnoreCase to ensure it`ll give us a matching courseTitle.
      ==0 which means they`re matching.*/        
    System.out.println("Course Title: "+course.getTitle()+", Instructor: "+ course.getInstructor()+", Area:"+ course.getArea());                 
     search = true;   //update the value 
         } }                                
    if (!search){    //if no matches were found,print a message                                     
    System.out.println("No courses found in this area");}    
 }
}



