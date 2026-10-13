

public class GenericDemo {
   static<T> T first(T[] arr)
   {
    return arr[0];
   }

public static void main(String[] args) {
   Box<String> nameBox=new Box<>("Dhruvi");
   String name=nameBox.get();
   System.out.println("My name is "+name);

    
}
   
    
}
