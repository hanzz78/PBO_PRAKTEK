import java.util.ArrayList;

public class ArrayStack<T> {
    private ArrayList<T> items;

    public ArrayStack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Underflow Error");
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
    }
}
