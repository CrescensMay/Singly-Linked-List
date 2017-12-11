package classes;

import java.util.Iterator;

public class SLLIterator implements Iterator<String> {
    private int currentPosition;
    private SLLNode[] iteratedListArray;

    public SLLIterator(int firstNode, SLLNode[] listArray) {
        this.currentPosition = firstNode;
        this.iteratedListArray = listArray;
    }

    @Override
    public boolean hasNext() {
        //return non-null current position
        return currentPosition != -1;
    }

    @Override
    public String next() {

        String returnedString = iteratedListArray[currentPosition].getData();
        currentPosition = iteratedListArray[currentPosition].getNext();
        return returnedString;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove method here!");
    }
}
