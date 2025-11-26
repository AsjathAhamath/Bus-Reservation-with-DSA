public class Queue {
    private QNode front,rear;

    public Queue(){
        this.front = this.rear = null;
    }

    public void enqueue(Reservation reservation){
        QNode newNode = new QNode(reservation);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Added to writing list: " + reservation.getCustomerName());
    }
    
    public Reservation dequeue(){
        if (isEmpty()) {
            System.out.println("Waiting list is Empty");
            return null;
            
        }
        Reservation removedReservation = front.reservation;
        front = front.next;
        if(front == null){
            rear = null;
    }
    System.out.println("Removed from waiting list: " + removedReservation.getCustomerName());
    return removedReservation;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Waiting list is empty");
            return;
        }
        System.out.print("Waiting list");
        QNode current = front;
        while (current != null) {
            System.out.print(current.reservation.getCustomerName() + "");
            current = current.next;
            
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return front == null;
    }

    public QNode getFront(){
        return front;
    }
}
