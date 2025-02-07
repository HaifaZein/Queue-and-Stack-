package cs210Project;

public class Queue <G> {
//*Nested Node class SinglyLinkedList Data Structure implementation
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
		
		//*Queue LinkedList Data Structure implementation
		private Node<G> front,rear;
		private int size;
		
		public Queue() {
			front = rear = null;
			size = 0;
		}
		
		//*Method isEmpty()
		public boolean isEmpty() {
			return size == 0;
		}
		
		//*Method size()
		public int size() {
			return size;
		}
		
		//*enqueue()
		public void enqueue(G e) {
			if (rear == null) {
				front = rear = new Node<G>(e,null);
				
			}else {
				rear.next = new Node<G>(e,null);
				rear = rear.next;
				
			}
			size++;
		}
		
		//*deQueue()  "check it"
		public G deQueue() {
			if(front==null) {
				return null;}else {
			G temp = front.data;
			front = front.next;
			size--;
			if(front == null)
				rear = null;
			return temp;	}	
		}
		
		//*Print() for traversing
		public void Print() {
			if(size == 0)
				System.out.println(" *The Queue is Empty!* ");
			else {
			Node <G> pointer = front;
			while(pointer != null) {
				System.out.println(pointer.data);
				pointer = pointer.next;
			}}
			
		}
		//Main Test
		public static void main (String [] args) {
			Queue q = new Queue();
			q.enqueue(10);
			q.deQueue();
			q.enqueue(11);
			q.deQueue();
			q.enqueue(12);
			q.deQueue();
			
			System.out.println("The contents of Queue q: ");
			q.Print();
			
			Queue q1 = new Queue();
			System.out.println("The contents of Queue q1: ");
			q1.Print();
			
			Queue q2 = new Queue();
			q2.enqueue("CS210");
			q2.enqueue("CS285");
			System.out.println("Items before dequeue: ");
			q2.Print();
			if(!q2.isEmpty()) {
			q2.deQueue();
			System.out.println("Items after dequeue: ");
			q2.Print();}else {
				System.out.println("The queue is empty, nothing to dequeue.");
			}
			
			
		}//*endMainMethod
}//*endQueueClass
