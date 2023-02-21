public class Node {
    Product infor;
    Node next;

    public Node(Product product) {
        this.infor = product;
    }
    public Node(Product infor, Node next) {
        this.infor = infor;
        this.next = next;
    }
    public String show(Product product){
        return product.getBcode() + " " + product.getTitle() + " " + product.getQuantity() + " " + product.getPrice();
    }
    public String toString(){
        return infor.toString();
    }
}
