package cs210Project;

public class Stack<G> {
//*Nested Node Class SinglyLinkedList Data Structure implementation
	class Node<G>{
		
		private G data;
		private Node<G> next;
		
		public Node() {
			data = null;
			next = null;
		}
		
		public Node (G d, Node<G> n) {
			data = d;
			next = n;
			
		}}//*endNodeClass
	
		//*Stack Data Structure
		private Node<G> top;
		private int size;
		
		public Stack() {
			top = null;
			size = 0;
		
			}
		
		//*Method size()
		public int size() {
			return size;
			
			}
		
		//*Method isEmpty
		public boolean isEmpty() {
			return size == 0;
			}
		
		//*Push()at top FILO like addfirst() in LL
		public void push(G e) {
			Node<G> newNod= new Node<G>(e,null);
			newNod.next=top;
			top=newNod;
			size++;
			}
		
		
		//*Pop()at last like removefirst() in LL
		public G pop() {
		if(top == null && size==0) {
		return null;
			}else {
				G e = top.data;
				top = top.next;
				size--;
				return e;
				}	
			}
		
		
		//*Peek() returns first element at top without removing it
		public G peek() {
			if(top == null) {
				return null;
			}else {
				G e = top.data;
				return e;
				}
			}
		
		
		//*Method Print to traverse
		public void Print() {
			if(size == 0) {
				System.out.println(" *The Stack is Empty!* ");
			}else {
				Node <G> pointer = top;
				while(pointer != null) {
					System.out.println(pointer.data);
					pointer = pointer.next;
					}
					}
			}
		
		//*Main Test
		public static void main(String[]args) {
			Stack s = new Stack();
			s.push(10);
			s.pop();
			s.push(11);
			s.pop();
			s.push(12);
			s.pop();
			s.push(13);
			s.pop();
			s.push(14);
			s.pop();
			System.out.println("Return element at the top: ");
			if(s.peek()==null)
				System.out.println("There is no element at the top of stack!!");
			else System.out.println("The element at the top of stack s is: ");
			System.out.println("Check whether the stack is empty or not in s1.. ");
			if(s.isEmpty()) {
				System.out.println("No elements in stack ");
			}else {
			System.out.println("");
			System.out.println("The contents of Stack s: ");
			s.Print();}
			
			Stack s1 = new Stack();
			System.out.println("Contents of Stack s1: ");
			s1.Print();
			
			Stack s2 = new Stack();
			s2.push("Haifa");
			s2.push("Maria");
			System.out.println("The contents of Stack s2: ");
			s2.Print();
			
		}//*endMainMethod	
}//*endStackClass
