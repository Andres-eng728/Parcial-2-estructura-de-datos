package co.edu.uniquindio.poo.Punto_1;
public class Node<T> {
    private T data;
    private Node next;

    public Node(T data){
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
}