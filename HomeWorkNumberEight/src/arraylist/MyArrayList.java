package arraylist;

import java.util.*;

/**
 * Created by lodo4ka on 08/05/2017.
 */
public class MyArrayList implements Collection{



    private Object[] myStore;
    private int actSize = 0;

    public MyArrayList() {
        myStore = new Object[10];
    }

    public MyArrayList(Object[] o){
        myStore = o;
    }


    public Object get(int index){
        if(index < actSize){
            return myStore[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    public void add(Object obj){
        if(myStore.length-actSize <= 5){
            increaseListSize();

        }
        myStore[actSize++] = obj;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    private void increaseListSize() {
        myStore = Arrays.copyOf(myStore, myStore.length*2);
        System.out.println("\nNew length: " +myStore.length);
    }

    public Object remove(int index){
        if(index < actSize){
            Object obj = myStore[index];
            myStore[index] = null;
            int tmp = index;
            while (tmp < actSize){
                myStore[tmp] = myStore[tmp+1];
                myStore[tmp+1] = null;
                tmp++;
            }
            actSize--;
            return obj;
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int size(){
        return actSize;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
