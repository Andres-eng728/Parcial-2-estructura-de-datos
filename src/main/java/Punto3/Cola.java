package Punto3;



public class Cola<T> {

       private NodeSimple<T> firstNode;
       private NodeSimple<T> lastNode;
       private int size;

       public Cola() {
           firstNode = null;
           lastNode = null;
           size = 0;
       }

       public boolean isEmpty() {
           return firstNode == null;
       }

       public void encolar(T data) {

           NodeSimple<T> newNodeSimple= new NodeSimple(data);
           if (isEmpty()) {
               firstNode = newNodeSimple;
               lastNode = newNodeSimple;

           }
           else {
               lastNode.setNext(newNodeSimple);
               lastNode = newNodeSimple;
           }
           size++;
       }

    public T desencolar() {
        if (isEmpty()) {
            throw new RuntimeException("la cola esta vacia");

        }else{
            T data = firstNode.getData();
            firstNode = firstNode.getNext();
            if(firstNode == null){
                lastNode = null;
            }
            size--;
            return data;
        }
    }




    public void clear() {
           size = 0;
           firstNode = null;
           lastNode = null;
    }


    public void invertirCola() {
           if (isEmpty()) {
               throw new RuntimeException("la cola esta vacia");
           }
           T data = desencolar();
           invertirCola();
           encolar(data);

               }
           }





