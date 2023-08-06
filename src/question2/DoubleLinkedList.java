
package question2;


public class DoubleLinkedList {
    DoubleNode first;
    DoubleNode last;
    DoubleNode current;
    int sizeofdll;
    String[] studentnames;
     public DoubleLinkedList(){
         first=null;
         last=null;
         current=null;
         sizeofdll=0;
         studentnames=new String[30];
     }
   
       public void insertlast(String x){
        DoubleNode n=new DoubleNode(x);
        if(first==null && last==null){
            first=n;
        }else{
            last.next=n;
        }
           for (int i = 0; i < studentnames.length; i++) {
                studentnames[i]=x;
           }
        n.previous=last;
        last=n;
        sizeofdll++;
    }
    public DoubleNode search(String name){
       
        DoubleNode tmp = first;
        while(tmp!=null){
            if(tmp.data.equalsIgnoreCase(name))
                return tmp;
            tmp = tmp.next;
        }       
        return null;
    }
    public void insertfirst(String x){
        DoubleNode n=new DoubleNode(x);

        if(first==null){
            first=n;
        }else
            n.next=first;
            first.previous=null;
            first=n;
     sizeofdll++;
    }
    public DoubleNode makeHub(DoubleNode db){
        db.data=db.data +"*";
        db.hub=true;
        return db;
    }
    void print(){
        DoubleNode tmp=this.first;
        while(tmp!= null){
            System.out.print(tmp.data+"<->");
            tmp=tmp.next;
        }
        System.out.println("");
    }
    
}
