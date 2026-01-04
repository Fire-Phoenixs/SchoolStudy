package MyStack;

import java.util.ArrayList;

public class Mystack {
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    public void push(Object o) {
        list.add(o);
    }

    public int search(Object o) {
        int index = list.lastIndexOf(o);
        if (index != -1) {
            return list.size() - index;
        } 
        else {
            return -1;
        }
    }
}
