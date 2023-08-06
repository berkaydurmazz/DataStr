
package question1;


public class DNode {
    public String data;
    public String realname;
    public DNode next;
    public DNode previous;
     
    public DNode (String data){
        this.data=data;
        this.realname=data;
        next=null;
        previous=null;
        
    }
}
