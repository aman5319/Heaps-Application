package heappp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by amidezcod on 5/6/17.
 */
public class Heap<E extends Comparable<E>> {
    ArrayList<E> arrayList = new ArrayList<>();

    //create default heap
    public Heap() {

    }

    //paramatrized constructor to create heap from array of objects
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    //add element to heap
    public void add(E objects) {
        arrayList.add(objects);// apeend to heap
        int currentIndex = arrayList.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            //if condition sastifies then swap to make heap
            if (arrayList.get(currentIndex).compareTo(arrayList.get(parentIndex)) > 0) {
                Collections.swap(arrayList, currentIndex, parentIndex);
            } else {
                break;//tree is heap now
            }
            currentIndex = parentIndex;
        }


    }

    public E remove() {
        if (arrayList.size() == 0) {
            return null;
        }
        E removedObject = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.remove(arrayList.get(arrayList.size() - 1));
        int currentIndex = 0;
        while (arrayList.size() - 1 > currentIndex) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;


            if (leftChildIndex >= arrayList.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < arrayList.size()) {
                if (arrayList.get(maxIndex).compareTo(
                        arrayList.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;

                }

            }

            // Swap if the current node is less than the maximum
            if (arrayList.get(currentIndex).compareTo(
                    arrayList.get(maxIndex)) < 0) {
                E temp = arrayList.get(maxIndex);
                arrayList.set(maxIndex, arrayList.get(currentIndex));
                arrayList.set(currentIndex, temp);
                currentIndex = maxIndex;

            } else
                break; // The tree is a heap

        }

        return removedObject;
    }

    public int getSize() {
        return arrayList.size();
    }
}
