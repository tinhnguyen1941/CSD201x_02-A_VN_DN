public class MyList {
    Node head;
    Node tail;

    public MyList() {
        head = null;
        tail = null;
    }
    public int length(){
        int length = 0;
        if (isEmpty()){
            length = 0;
        } else {
            for (Node i = head; i != null; i = i.next){
                length ++;
            }
        }
        return length;
    }
    public void addAtTail(Product product){
        Node node = new Node(product, null);
        if (head == null){
            this.head = node;
            this.tail = node;
        } else {
            tail.next = node;
            this.tail = node;
        }
    }
    public void showInfor(MyList myList){
        Node current = head;
        while (current != null){
            System.out.println(current);
            current = current.next;
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
    public boolean isEmpty(){
        return head == null;
    }
    public void clear(){
        this.head = null;
    }
}
