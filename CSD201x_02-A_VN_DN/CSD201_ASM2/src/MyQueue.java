public class MyQueue {
    Node head;
    Node tail;

    public MyQueue(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    public MyQueue() {
        head = tail = null;
    }
    public boolean isEmty(){
        return this.head == null;
    }
    public void enqueue(Product product){
        Node node = new Node(product);
        if (isEmty()){
            head = tail = node;
        }
        tail.next = node;
        tail = tail.next;
    }
    public void printQueue(MyQueue myList){
        if (isEmty()){
            System.out.println("Queue is Empty!");
        } else {
            Node curent = head;
            while (curent != null){
                System.out.println(curent.toString());
                curent = curent.next;
            }
        }
        OperationToProduct otp = new OperationToProduct();
        otp.writeFile(myList, "console_output.txt", true);
    }
}
