package arraylist;

import java.util.*;

/**
 * Created by lodo4ka on 08/05/2017.
 */
public class MyArrayList<E> implements Collection<E>{




    private E[] values;

     public MyArrayList(){
        values = (E[]) new Object[0];
    }


    public E get(int index){
         return values[index];
    }


    @Override
    public int size() {
        return 0;
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
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

         try{
             E[] temp = values;
             values = (E[]) new Object[temp.length + 1];
             System.arraycopy(temp, 0, values, 0, temp.length);
             values[values.length - 1] = e;
             return true;
         }
         catch (ClassCastException ex){
             ex.printStackTrace();
         }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

}
