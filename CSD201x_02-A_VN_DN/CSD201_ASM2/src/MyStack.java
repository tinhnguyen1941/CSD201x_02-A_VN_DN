public class MyStack {
    Node head;
    public MyStack() {
        head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(Product product){
        Node node = new Node(product);
        node.next = this.head;
        this.head = node;
    }
    public Node pop(){
        if (isEmpty()){
            return null;
        } else {
            Node x = this.head;
            this.head =this.head.next;
            return x;
        }
    }
    public void printStack(MyStack myList){
        if (head == null){
            System.out.println("Stack is Empty!");
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
    public String toString(){
        String resulf = "";
        Node current = this.head;
        while (current  != null){
            resulf += current.toString() + "\n";
            current = current.next;
        }
        return resulf;
    }
}
