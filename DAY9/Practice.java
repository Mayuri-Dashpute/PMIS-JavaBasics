
package DAY9;

class Box<T> {
    private T item;

    void set(T item) {
        this.item = item;
    }

    T get() {
        return item;
    }
}

public class Practice {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("Samsung");
        String s = box.get();
        System.out.println(s);

        Box<Integer> box1 = new Box<>();
        box1.set(2500);
        int s1 = box1.get();
        System.out.println(s1);
    }
}
