package Punto2;



public class Stack<T> {
    private int size;
    private Node<T> top;
    public void Stack() {
        this.size = 0;
        this.top = null;

    }
    public void push(T data){
        Node newNode = new Node(data);
        if(isEmpty()){
            top = newNode;

        }else{
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return top == null;
    }

        public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");


        }else{
            T data = top.getData();
            top=top.getNext();
            size--;
            return data;
        }
        }
        public T peek(){
        return top.getData();
        }

    public Stack<T> clonarPila(){
        Stack<T> aux = new Stack<T>();
        Stack<T> cloned = new Stack<T>();
        while(!isEmpty()){
            cloned.push(pop());
        }

        while(aux.isEmpty()){
            T data= aux.pop();
            this.push(data);
            cloned.push(data);
        }
        return cloned;
    }
    public void print() {
        Node<T> actual = top;

        while (actual != null) {
            System.out.print(actual.getData() + " ");
            actual = actual.getNext();
        }

    }
    public void addAll(Stack<T> otraPila) {
        Stack<T> aux = new Stack<>();


        while (!otraPila.isEmpty()) {
            aux.push(otraPila.pop());
        }


        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }
    }

    public int size() {
        return size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


