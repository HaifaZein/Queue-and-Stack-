/**
 *
 * @author Manal Alhihi
 */
public class StackTower {
     
    class Node {
        public int data;
        
        public Node next;
        public Node () {
            data = 0;
            next = null;
        }
        public Node (int val) {
            data = val;
            next = null;
        }
    }
    
    private Node top;
    public String name ;
    private int size;

    public StackTower() {
            name = "";
            top = null;
            size = 0;
    }

    public boolean isEmpty(){
            return top == null;
    }
    
    public int size ()
    {
        return size;
    }

    public boolean full(){
            return false;
    }

    public void push(int e){
            Node tmp = new Node(e);
            tmp.next = top;
            top = tmp;
            size ++;
    }

    public int pop(){
            int e = top.data;
            top = top.next;
            size -- ;
            return e;
    }
   
     public int peek(){
            int e = top.data;
            return e;
    }
     public void print ()
     {
         if ( size == 0 )
             System.out.println("Empty Tower.....");
         else
         {
                Node tmp = top;
                while (tmp != null)
                {
                    System.out.println(tmp.data);
                    tmp = tmp.next;
                }
        }
         
     }
}