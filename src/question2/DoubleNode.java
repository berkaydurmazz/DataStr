
package question2;


public class DoubleNode {
    int number;
    String data;
    boolean hub;
    DoubleNode next;
    DoubleNode previous;
    public DoubleNode(String data) {
        this.data=data;
        previous=null;
        next=null;
        hub=false;
    }
    public boolean isHub(){
        return hub;
    }
    public boolean checkLetter(String message){
         int sameletter=0;
         for (int i = 0; i < message.length(); i++) {
             for (int j = 0; j < data.length(); j++) {
                 message=message.toUpperCase();
                 Character d=data.charAt(j);
                 Character m=message.charAt(i);
                 if(m.equals(d)){
                     sameletter++;
                 }
             }
        }
            if(sameletter>=2){
                return true;
            }return false;
        }
    
}
