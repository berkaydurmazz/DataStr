
package question2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;




public class Test {
  static  DoubleLinkedList playerlist=  new DoubleLinkedList();
  static int option=0;
  static int  p;
  String message;
  static int k; 
  static DoubleNode source;
     public static String  reading() throws FileNotFoundException{
        File f = new File("class.txt");
        String result = null;
        Random rand = new Random();
     int n = 0;
     Scanner sc = new Scanner(f);
     while(sc.hasNext()){
        ++n;
        String line = sc.nextLine();
        if(rand.nextInt(n)== 0)
           result = line.substring(0, line.indexOf(" "));         
     }
        
     return result;      
  }
    
     public static void main(String[] args) throws FileNotFoundException ,NumberFormatException{
         System.out.println("Welcome To THE GAME");
         Scanner scn= new Scanner(System.in);
         
       do{
           System.out.println("The following options are available for you: ");
           System.out.println("Please choose an option \n 1) Start the game \n 2) Press 2 to quit when entering message");
           option= scn.nextInt();
           switch(option){
               case 1:   
                  int p=1;
                   while(p<2)  { 
                   try {           
                    System.out.print("Enter the number of hubs: ");
                    p = Integer.parseInt(scn.next());
            
                    }
                    catch(java.lang.NumberFormatException e) {
                     System.out.println("Error, please enter a valid number greater than 1: ");
                
                    }
                    }
        
                int[] rnumberarray= new int[p];
        
                for (int i = 0; i < p; i++) {
                  Random rand = new Random();
                  rnumberarray[i]=1+rand.nextInt(29);
                 for (int j = 0; j < i; j++) {
                  if(rnumberarray[i]==rnumberarray[j]){
                    i--;
                    break;
                  }
                 }
            
                }  
       
                  for (int i = 0; i < 30; i++) {
                String p1name= reading();
             
                  if(playerlist.search(p1name)==null&&playerlist.search(p1name+'*')==null){
                   playerlist.insertlast(p1name);
                   playerlist.last.number=i+1;
                    }else
                     i--;
              
                  for (int j = 0; j < rnumberarray.length; j++) {
                  if(playerlist.last.number==rnumberarray[j]&&playerlist.search(p1name+'*')==null){
                    playerlist.last.hub=true;
                    playerlist.makeHub(playerlist.last);
                     }
                   }  
                }
                int k=1;
                while(k<2)  { 
                try {           
                  System.out.print("Enter the number of students to pass the message : ");
                   k=Integer.parseInt(scn.next());

            
                 }
                catch(java.lang.NumberFormatException e) {
                 System.out.println("Error, please enter a valid number greater than 1: ");
                
                 }
                }
               System.out.print("The train is: ");
                playerlist.print();
         
               System.out.print("Enter the message: ");
               String message= scn.next();
              if(isNumeric(message)){
             System.exit(0);
                }
               System.out.println("Enter the source student: ");
                String student=scn.next();
          
                do{
             
                 while(playerlist.search(student)==null){
                 System.out.println("Please enter a name in the train.");
                 System.out.println("Enter the source student: ");
                  student=scn.next();
                 }
                 source=playerlist.search(student);
                 
                 System.out.print(source.data+" passes message "+message+" in forward direction: ");
                 DoubleNode temp=source.next;
                  for (int i = 0; i < k; i++) {
                   System.out.print(temp.data+",");
                   temp=temp.next;
                   }
                   break;
                  }while(playerlist.search(student)==null);
                   enter2(k, message, source.next);
                  break;
                  case 2:
                    break;
                   default:  System.out.println("Your option is not avaible! ");  
                 }
                
       }while(option!=2);
        
     }
     public static boolean isNumeric(String str) {
        if (str == null) {
        return false;
      }
       try {
        double d = Double.parseDouble(str);
          } catch (NumberFormatException nfe) {
        return false;
       }
       return true;
}
     public static void enter(int k){
         Scanner sc= new Scanner(System.in);
         
         System.out.println("\n Enter the message: ");
         String message= sc.next();
         if(isNumeric(message)){
             System.exit(0);
         }
         System.out.print("Enter the source student: ");
         String student=sc.next();
         
         do{
             DoubleNode source1=playerlist.search(student);
            
            System.out.print(source1.data+" passes message "+" in forward direction: ");
            
            DoubleNode temp=source1.next;
            DoubleNode temp2=temp;
              for (int i = 0; i < k; i++) {
                  System.out.print(temp2.data+",");
                  temp2=temp2.next;
              }
              
              enter2(k,message,temp);
              break;
         }while(playerlist.search(student)==null);
         
         
     }
     public  static void enter2(int k,String message,DoubleNode source){
           DoubleNode temp=source;
         for (int i = 0; i < k; i++) {
             if(temp.isHub()&&temp.checkLetter(message)){
                 source=temp;
                 System.out.println("");
                 System.out.print(source.data+" passes message "+message+" in forward direction: ");
                 DoubleNode temp2=temp.next;
                for (int j = 0; j < k; j++) {
                  System.out.print(temp2.data+",");
                  temp2=temp2.next;
                }
                break;
             }temp=temp.next;
          }
         if(temp.isHub()&&temp.checkLetter(message)){
             enter2(k,message,temp.next);
         }else{
                 enter(k);
             }
          
     }
}
