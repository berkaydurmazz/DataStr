
package question1;


public class CircularLinkedList {
    public DNode first;
    int size=0;
   
    public CircularLinkedList(int playernumber){
        first=null;
       
    }
    public void insertAfterFirst(String s ){
        DNode dn= new DNode(s);
        if(first==null){
            first = dn;
            first.next = first;
            first.previous = first;
        }else{
            dn.previous=first;
            dn.next=first.next;
            first.next.previous=dn;
            first.next=dn;
            
        }
        
        size++;
    }
    public void rotate() {
        first = first.next;
    }
    @Override
    public String toString() {

        DNode tmp = first;
        String s = "";
        while (tmp != first.previous) {
            s += tmp.data + "->";
            tmp = tmp.next;
        }
        s += tmp.data;

        return s;
    }
    public DNode search(String name){
        
        DNode tmp = first;
        DNode tmp2=first;
        while(tmp!=null){
            if(tmp.data.equalsIgnoreCase(name))
                return tmp;
            tmp = tmp.next;
            if(tmp==tmp2){
                break;
            }
        }       
        return null;
    }
    public void deleteFirst(){
        if(first.next==first){
            first=null;
        }else{
            first.previous.next=first.next;
            first.next.previous=first.previous;
            first=first.next;
        }
        size--;
    }
}
