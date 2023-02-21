
import java.util.ArrayList;
import java.util.Scanner;

public class ASM2_Main {
    public static void showMenu(){
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display.");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data.");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID.");
        System.out.println("6. Delete by ID.");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary.");
        System.out.println("9. Load to stack and display.");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
        System.out.println("Choise: ");
    }
    public static void main(String[] args) {
        OperationToProduct otp = new OperationToProduct();
        MyList myList = new MyList();
        ArrayList<Product> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu();
            int choise = sc.nextInt();
            switch (choise) {
                case 1:

                    // Đọc dữ liệu có sẵn từ file đã tự tạo và lưu vào danh sách móc nối và hiển thị danh sách ra màn hình:
                    System.out.println("ID | Title | Quantity | Price");
                    System.out.println("-----------------------------");
                    myList.clear();
                    list = otp.readFile("data.txt");
                    if(list == null){
                        System.out.println("File is Empty!");
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            myList.addAtTail(list.get(i));
                        }
                        myList.showInfor(myList);
                    }
                    System.out.println();
                    break;
                case 2:
                    //  Nhập và thêm một sản phẩm vào cuối của danh sách móc nối:
                    Product product = otp.addProduct();
                    // Thêm product vào cuối danh sách:
                    myList.addAtTail(product);
                    System.out.println();
                    break;
                case 3:
                    // Hiển thị thông tin của các sản phẩm trong danh sách móc nối:
                    if (myList.isEmpty()){
                        System.out.println("EMPTY!!!");
                    } else {
                        System.out.println("ID | Title | Quantity | Price");
                        System.out.println("-----------------------------");
                        myList.showInfor(myList);
                    }
                    System.out.println();
                    break;
                case 4:
                    // Lưu danh sách móc nối các sản phẩm vào file:
                    if (myList.isEmpty()){
                        System.out.println("List is Empty!");
                    } else {
                        otp.writeFile(myList, "data.txt", false);
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 5:
                    // Tìm kiếm thông tin của sản phẩm theo ID
                    otp.findID(myList);
                    System.out.println();
                    break;
                case 6:
                    // Xóa sản phẩm trong danh sách theo ID:
                    if (myList.isEmpty()){
                        System.out.println("List is Empty!");
                    } else {
                        MyList myListAfterDelete = otp.deleteID(myList);
                        System.out.println("Product after delete: ");
                        myListAfterDelete.showInfor(myListAfterDelete);
                    }
                    System.out.println();
                    break;
                case 7:
                    // Sắp xếp các sản phẩm  trong danh sách móc nối theo ID:
                    if (myList.isEmpty()){
                        System.out.println("List is Empty!");
                    } else {
                        otp.sortID(myList);
                        myList.showInfor(myList);
                    }
                    System.out.println();
                    break;
                case 8:
                    // Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List ra hệ đếm nhị phân bằng phương pháp đệ quy.
                    if (myList.isEmpty()){
                        System.out.println("List is Empty!");
                    }
                    else {
                        int num = myList.head.infor.getQuantity();
                        String str = "After conver binary " + num + " => " + otp.convertBinary(num);
                        System.out.print(str);
                        otp.writeToFile("console_output.txt", str, true);
                    }
                    System.out.println();
                    break;
                case 9:
                    // Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack.
                    MyStack myStack = new MyStack();
                    list = otp.readFile("data.txt");
                    for (int i = 0; i < list.size(); i++){
                        myStack.push(list.get(i));
                    }
                    // Hiển thị ra màn hình các sản phẩm có trong stack.
                    myStack.printStack(myStack);
                    System.out.println();
                    break;
                case 10:
                    // Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.
                    MyQueue myQueue = new MyQueue();
                    list = otp.readFile("data.txt");
                    for (int i = 0; i < list.size(); i++){
                        myQueue.enqueue(list.get(i));
                    }
                    myQueue.printQueue(myQueue);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("THANKS!!");
                    System.exit(0);
                default:
                    System.out.println("Giá trị không tồn tại, vui lòng chọn lại!");


            }

        }
    }
}
