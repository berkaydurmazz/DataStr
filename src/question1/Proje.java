
package question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Proje {

    public static String  reading() throws FileNotFoundException{
        File f = new File("class.txt");
        String result = null;
        Random rand = new Random();
         int n = 0;
         Scanner sc = new Scanner(f);
         while(sc.hasNext()){
           ++n;
           String line = sc.nextLine();
           if(rand.nextInt(n) == 0)
           result = line.substring(0, line.indexOf(" "));         
           }
        
       return result;      
      }
    public static int option;
    public static void main(String[] args) throws FileNotFoundException {
             Scanner scn= new Scanner(System.in);
             do{
                 System.out.println("**********************************************************");
            System.out.println("The Main Menu is below , please press the option number: ");
        System.out.println("Main Menu");
        System.out.println("1) Start the game \n 2) Quit");
          option= scn.nextInt();
        switch(option){
            case 1:
                
             
             System.out.println("How many players will play?  ");
             int playernumber= scn.nextInt();
             
             CircularLinkedList playerlist=  new CircularLinkedList(playernumber);
             for (int i = 0; i < playernumber; i++) {
                String p1name= reading();
                if(playerlist.search(p1name)==null){
                    playerlist.insertAfterFirst(p1name);
                }else i--;
                
            }
             String selectedname="";
      
        while(playerlist.size!=1){
          
        System.out.println(playerlist.toString());
         selectedname=losingLetter(randomChoose(playerlist),playerlist);
        
        System.out.println("The person who is chosen: "+ playerlist.first.realname);
        System.out.println( "Rest of the name : " +selectedname);
        
        if(selectedname==""){
              System.out.println("Eliminated name: "+ playerlist.first.realname);
             playerlist.deleteFirst();
          }
        pressEnterKeyToContinue();
        }
        
        if(playerlist.size==1){
        System.out.println("The winner is: "+playerlist.first.realname);
        }
        break;
        case 2:
            break;
            default:  System.out.println("Your option is not avaible! ");
      } 
    }while(option!=2);
  }
    public static  void pressEnterKeyToContinue(){ 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
            
        {}  
 }
     public static String randomChoose(CircularLinkedList playerlist){
         Random rand = new Random(); 
         DNode temp=playerlist.first;
         int rnumber=1+rand.nextInt(49);
         rnumber%=playerlist.size;
         System.out.println("Random number: "+((rnumber%playerlist.size)+1));
         int n=0;
         while(temp!=null){
             playerlist.rotate();
             n++;
        if(n==rnumber)
            return playerlist.first.data;
         }
         return null;
     }
     public static String losingLetter(String name,CircularLinkedList playerlist){
         String name2 ="";
         char[] charr= new char[name.length()];
         for (int i = 0; i < charr.length-1; i++) {
               charr[i]= name.charAt(i);
          } 
         for (int i = 0; i < charr.length-1; i++) {
             name2= name2+charr[i];
         }
         playerlist.first.data=name2;
      return name2;
     }
}
