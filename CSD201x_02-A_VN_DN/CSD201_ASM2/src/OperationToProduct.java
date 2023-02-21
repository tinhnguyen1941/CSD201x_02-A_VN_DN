import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class OperationToProduct {
    // 1. Đọc file:
    public static ArrayList readFile(String fileName){
        ArrayList<Product> arrayList = new ArrayList<>();

        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            String line = "";
            while (true){
                Product product = new Product();
                line = bf.readLine();
                if(line == null){
                    break;
                }
                String str[] = line.split("\\s+");
                String bcode = str[0];
                String title = str[1];
                int quantity = Integer.parseInt(str[2]);
                double price = Double.parseDouble(str[3]);
                product = new Product(bcode,title,quantity,price);
                arrayList.add(product);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }
    public Product addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input new ID: ");
        String bcode = sc.next();
        System.out.println("Input Product's Name: ");
        String title = sc.next();
        System.out.println("Input Product's quantity: ");
        int quantity = Integer.parseInt(sc.next());
        System.out.println("Input Product's price: ");
        double price = Double.parseDouble(sc.next());
        return new Product(bcode, title, quantity, price);
    }
    // Ghi thông tin sản phẩm vào file:
    public void writeFile(MyList myList, String fileName, boolean append){
        try{
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Node i = myList.head; i != null; i = i.next){
                bw.write(i.show(i.infor));
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e){}
        System.out.println("Suscerfull");
    }
    public void writeFile(MyQueue myList, String fileName, boolean append){
        try{
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Node i = myList.head; i != null; i = i.next){
                bw.write(i.show(i.infor));
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e){}
        System.out.println("Suscerfull");
    }
    public void writeFile(MyStack myList, String fileName, boolean append){
        try{
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Node i = myList.head; i != null; i = i.next){
                bw.write(i.show(i.infor));
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e){}
        System.out.println("Suscerfull");
    }
    // Tìm sản phẩm theo ID:
    public void findID(MyList myList){
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        String value = sc.nextLine();
        MyList ml = new MyList();
        for (Node i = myList.head; i != null; i = i.next){
            if (i.infor.getBcode().equals(value)){
                ml.addAtTail(i.infor);
            }
        }
        if (myList.isEmpty()) {
            System.out.println("Sản phẩm cần tìm: -1");
        } else {
            System.out.println("ID | Title | Quantity | Price");
            System.out.println("-----------------------------");
            ml.showInfor(ml);
        }
    }
    // Xoá sản phẩm trong linklist theo ID:
    public MyList deleteID(MyList myList){
        Scanner sc = new Scanner(System.in);
        System.out.print("ID for delete: ");
        String id = sc.nextLine();
        Node privious = null;
        Node temp = myList.head;
        while (temp != null){
            if (temp.infor.getBcode().equals(id)){
                if (privious != null) {
                    if(temp == myList.tail){
                       privious.next = myList.tail;
                       myList.tail = privious;
                    }
                    privious.next = temp.next;
                } else {
                    myList.head = temp.next;
                }
            }
            privious = temp;
            temp = temp.next;
        }
        return myList;
    }
    // Sắp xếp lại thứ tự theo anpha của ID:
    public MyList sortID(MyList myList){
        Product temp;
        for (Node i = myList.head; i != null; i = i.next){
            for (Node j = i.next; j != null; j = j.next){
                if (i.infor.getBcode().compareTo(j.infor.getBcode()) > 0){
                    temp = i.infor;
                    i.infor = j.infor;
                    j.infor = temp;
                }
            }
        }
        return myList;
    }
    // Chuyển 1 số nguyên sang sô nhị phân:
    public long convertBinary(int num){
        long numConvert;
        if (num == 0){
            return 0;
        } else {
            numConvert = num % 2;
            return convertBinary(num / 2) * 10 + numConvert;
        }

    }
    public void writeToFile(String fileName, String str, boolean append){
        try {
            FileWriter fw = new FileWriter(fileName,append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.newLine();
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}