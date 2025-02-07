import java.util.Scanner;

/**
 *
 * @author Manal Alhihi
 */
public class Tower_Of_Hanoi_New {
    
    int disks;
    int number_moves ;
    StackTower S = new StackTower();
    StackTower E = new StackTower();
    StackTower D = new StackTower();
    
    //O(n)
    // read  number of disks
    void read ()
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter number of disks ");
        disks = input.nextInt();
        number_moves = (int)Math.pow(2, disks) -1;
        
        for ( int value = disks ; value >= 1 ; value -- )
            S.push(value);
        
        S.name = "[TOH 1]";
        E.name = "[TOH 2]";
        D.name= "[TOH 3]"; 
    }
    
    // O(1)
    String Make_move ( StackTower Source , StackTower Destination)
    {
        Integer data;
        String move_desc = "" ;
        
        if ( Destination.isEmpty())
        {
            data = Source.pop();
            Destination.push(data);
            move_desc = Source.name + " TO " + Destination.name ;
        }
        else if ( Source.isEmpty())
        {
            data = Destination.pop();
            Source.push(data);
            move_desc = Destination.name + " TO " + Source.name ;
        }
        else if ( Destination.peek() > Source.peek())
        {
            data = Source.pop();
            Destination.push(data);
            move_desc = Source.name + " TO " + Destination.name ;
        }
        else
        {
            data = Destination.pop();
            Source.push(data);
            move_desc = Destination.name + " TO " + Source.name ;
        }
        return ( "Move data " + data +  " FROM " + move_desc );
    }
    
    //O(n)
    void Moves()
    {
        print( "SOURCE Tower " , S );
        print( "DESTINATION Tower " , D );

        
        for ( int step = 1; step <= number_moves ; )
        {
               if (step <= number_moves)
               {
                    System.out.println(Make_move (S, E));
                    step++;
               }
               
               if (step <= number_moves)
               {
                    System.out.println(Make_move (S, D));
                    step++;
               }
               
               if (step <= number_moves)
               {
                    System.out.println(Make_move (E, D));
                    step++;
               }
         
        }
        
        print( "SOURCE Tower " , S );
        
        if ( ! D.isEmpty())
                print( "DESTINATION Tower " , D );
        else
                print( "DESTINATION Tower " , E );
        
    }
    //O(1)
    void print ( String str , StackTower stack)
    {
        System.out.println(str);
        stack.print();
    }
   
    //O(n)
    public static void main(String[] args)
     {
         Tower_Of_Hanoi_New TOH = new Tower_Of_Hanoi_New ();
         TOH.read();
         TOH.Moves();
     }
}
