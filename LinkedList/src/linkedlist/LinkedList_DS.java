/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;
import my_class.MyClass;

/**
 *
 * @author buidu
 */
public class LinkedList_DS {
    public static Object read(String path) throws FileNotFoundException, FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
    
    public static void write(Object o,String path) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        fos.flush();
        oos.close();
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        LinkedList <String> ls = new LinkedList<>();
        LinkedList <String> ls2  = new LinkedList<>();
        //Được implements từ list deque Serializable cloneable
        /*
        1.Thêm và xóa phần tử: LinkedList cho phép thêm và xóa phần tử một cách hiệu quả. 
        Khi thêm một phần tử mới vào đầu hoặc cuối danh sách, chỉ cần thay đổi các tham
        chiếu của các node liên quan mà không cần di chuyển các phần tử khác. 
        Điều này làm cho thao tác thêm/xóa nhanh hơn so với ArrayList khi làm việc với danh sách lớn.
        
        2.Chèn phần tử: LinkedList cho phép chèn phần tử vào vị trí bất kỳ trong 
        danh sách với hiệu suất tốt. Khi chèn phần tử vào vị trí giữa danh sách, 
        chỉ cần thay đổi tham chiếu của các node liên quan, không cần di chuyển các phần tử khác. 
        Trong khi đó, ArrayList yêu cầu di chuyển các phần tử sau vị trí chèn, gây tốn kém hiệu năng đối với danh sách lớn.
        
        3.Xóa và truy cập phần tử ở đầu và cuối: 
        LinkedList cho phép xóa và truy cập phần tử ở đầu và cuối danh sách một cách hiệu quả. 
        Với việc chỉ cần thay đổi các tham chiếu, không cần di chuyển các phần tử,
        LinkedList thực hiện các thao tác này nhanh chóng.
        
        4.Xóa và truy cập phần tử ở đầu và cuối: LinkedList cho phép xóa và truy cập 
        phần tử ở đầu và cuối danh sách một cách hiệu quả. Với việc chỉ cần thay đổi các tham chiếu, 
        không cần di chuyển các phần tử, LinkedList thực hiện các thao tác này nhanh chóng.
        */
        
        /*
        ---Ngu
        1.Truy cập ngẫu nhiên chậm hơn: Truy cập phần tử ở vị trí ngẫu nhiên trong 
        LinkedList yêu cầu phải truy cập từ đầu danh sách và di chuyển qua các node.
        Trong khi đó, ArrayList cho phép truy cập ngẫu nhiên nhanh hơn vì nó sử dụng mảng động
        2.Chiếm dụng bộ nhớ: LinkedList sử dụng thêm bộ nhớ để lưu trữ các tham chiếu (references) 
        giữa các node, làm tăng tổng lượng bộ nhớ được sử dụng so với ArrayList.
        */
       
        //Add
        ls.add("A");
        ls.add("B");
        ls.add("C");
        ls.add("D");
        ls.addFirst("L");
        ls.addLast("O");
        
        //Remove
        System.out.println(ls.remove());
        ls.removeFirstOccurrence("D");
        ls.removeLast();
        ls.removeFirst();
        
        //gets
        System.out.println(ls.get(0));
        
        
        
        /*
        1.add
            add(element): Thêm phần tử vào cuối danh sách.
            add(index, element): Thêm phần tử vào vị trí chỉ định trong danh sách.
            addFirst(element): Thêm phần tử vào đầu danh sách.
            addLast(element): Thêm phần tử vào cuối danh sách.
        2.remove
            remove(): Xóa và trả về phần tử cuối cùng của danh sách.
            remove(index): Xóa phần tử ở vị trí chỉ định trong danh sách.
            removeFirst(): Xóa và trả về phần tử đầu danh sách.
            removeLast(): Xóa và trả về phần tử cuối danh sách.
            removeFirstOccurrence(element): Xóa phần tử đầu tiên có giá trị bằng element.
        3.get 
            get(index): Truy cập phần tử ở vị trí chỉ định trong danh sách.
            getFirst(): Truy cập phần tử đầu danh sách.
            getLast(): Truy cập phần tử cuối danh sách.
        4.check
            size(): Trả về số phần tử trong danh sách.
            isEmpty(): Kiểm tra xem danh sách có rỗng hay không.
            contains(element): Kiểm tra xem danh sách có chứa phần tử element hay không.
        5.loop
            forEach(action): Thực hiện hành động được chỉ định trên mỗi phần tử trong danh sách.
            iterator(): Trả về một đối tượng Iterator để duyệt qua danh sách.
        6.clear all
            clear(); xóa tất
        7.clone() sao chép all;
        */
        Iterator inter = ls.iterator();
        while(inter.hasNext()){
            System.out.println(inter.next());
        }
        System.out.println("---------------------------");
        ls.forEach((String t) -> {
            System.out.println(t);
        });
        System.out.println("---------------------");
        write(ls,"data.dat");
        ls2 = (LinkedList<String>)read("data.dat");
        for (String string : ls2) {
            System.out.println(string);
        }//test với warpper 
        //Test vơí object
        
        LinkedList<String> ls3 = new LinkedList<>();
//        ls3.add(new MyClass(0));
//        ls3.add(new MyClass(1));
//        ls3.add(new MyClass(2));
//        write(ls3,"obj.dat");
//        LinkedList<MyClass> ls4 = new LinkedList<>();
//        ls4 = (LinkedList<MyClass>) read("obj.dat");
//        ls4.forEach((t) -> {
//            System.out.println(t);
//        });
System.out.println("----------------------------------");
           ls3 =  (LinkedList<String>) ls.clone();
           ls3.forEach((t) -> {
               System.out.println(t);
           });
    }
}
