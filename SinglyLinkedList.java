package classes;

public class SinglyLinkedList {

    private final static int DEFAULT_MAXIMUM = 10;
    private SLLNode[] listArray;
    private int first;
    private int firstFree;
    private int length;

    public SinglyLinkedList() {

        listArray = new SLLNode[DEFAULT_MAXIMUM];//initializing the size to the default value
        first = -1; //initializing first to null
        firstFree = 0; //initializing first free to null
        length = 0; //initializing lenght to null
    }

    public SinglyLinkedList(int size){

        listArray = new SLLNode[size]; //initializing the size of the array
        first = -1; //initializing first to null
        firstFree = 0; //initializing first free to null
        length = 0; //initializing lenght to null
    }

    public boolean insert(String data){

            //Creation of a new node
            SLLNode sllNodeTemp = new SLLNode(data,-1);
            listArray[firstFree++] = sllNodeTemp;

            //if first is null
            if(first == -1){
                first = firstFree - 1;

            }else {
                //Check if is in ascending order
                if(data.compareToIgnoreCase(listArray[first].getData()) > 0){

                    //temporary pointer
                    int pointer = first;
                    // first is not null pointer
                    while (pointer != -1){
                        //value pointing to
                        int nextPointer = listArray[pointer].getNext();
                        //if the next value is null checking
                        if(nextPointer == -1){
                            //if it is null we set the first free value to first and stop
                            listArray[pointer].setNext(firstFree - 1);
                            break;

                            //Check if is in descending order or the two string value are same
                        }else if (data.compareToIgnoreCase(listArray[nextPointer].getData()) <= 0){
                            //if it is in descending order we set the first free value to first
                            listArray[pointer].setNext(firstFree - 1);
                            //set the value of the next pointer to the node and stop
                            sllNodeTemp.setNext(nextPointer);
                            break;
                        }
                        //set the value of the nextPointer to the temporary one
                        pointer = nextPointer;
                    }
                }else {
                    //Check if is in descending order
                    sllNodeTemp.setNext(first);
                    first = firstFree - 1;
                }
            }

        return true;
    }

    public boolean insertModifiedVersion7(String data){

        //first free assigned to the next pointer
//        if (length >= listArray.length) return false;
        int next = firstFree;

        //first free in the arraylist is not null
        if(!(listArray[firstFree] == null ? true : false)){
            next = listArray[firstFree].getNext();
        } else {
            next = firstFree + 1;
        }
        //Create new node
        SLLNode sllNode = listArray[firstFree]= new SLLNode(data, -1);
//        listArray[firstFree] = sllNode;

        //first is null
        if (first == -1){
            first = firstFree;
        }else {
            //Checking if it is descending order between two elements
            if (data.compareToIgnoreCase(listArray[first].getData()) < 0){
                sllNode.setNext(first);
                first = firstFree;
            }else {
                //our first assigned to the temp next pointer
                int pointer = first;
                while (pointer != -1){//when it is not null
                    //assigning the next pointer
                    int nextPointer = listArray[pointer].getNext();

                    if (nextPointer == -1){//when it is not null
                        listArray[pointer].setNext(firstFree);
                        break;
                    }
                    //when it is the expected data or descending order between two elements
                    if (data.compareToIgnoreCase(listArray[nextPointer].getData()) <= 0){
                        listArray[pointer].setNext(firstFree);
                        sllNode.setNext(nextPointer);
                        break;
                    }
                    pointer = nextPointer;
                }
            }
        }
        firstFree = next;
        length++;
        return true;
    }

    public boolean remove(String data){

        boolean isFound = false;
        //if first is null(empty)
        if(first == -1){
        }else if (listArray[first].getData().compareToIgnoreCase(data) != 0
                && isEmpty()){//if there is a mismatch

        }else if (listArray[first].getData().compareToIgnoreCase(data) == 0){//match item
            int tempFirst = first;
            first = listArray[first].getNext();
            listArray[tempFirst].setNext(-1);
            isFound = true;
        }else {// if found more than two elements
            int anotherTempFirst = first;
            int current = listArray[first].getNext();

            while (current != -1){
                //if the inserted data is equal to the current data(first data)
                if(listArray[current].getData().compareToIgnoreCase(data) == 0) {

                    //setting the current next data to the temporary one
                    listArray[anotherTempFirst].setNext(listArray[current].getNext());
                    //And the set that current first to a null
                    listArray[current].setNext(-1);
                    isFound = true;
                    break;

                }else {
                    //otherwise set the current to the temporary
                    anotherTempFirst = current;
                    current = listArray[current].getNext();
                }
            }
        }
        return isFound;
    }

    public boolean removeModifiedVersion5(String data){
        //space to be removed
        int arraySpace = -1;
        boolean isFound = false;

        //if first is null(empty)
        if(first == -1){
        }else if (listArray[first].getData().compareToIgnoreCase(data) != 0
                && isEmpty()){//if there is a mismatch

        }else if (listArray[first].getData().compareToIgnoreCase(data) == 0){//match item
            int tempFirst = arraySpace = first;
//            arraySpace =  = first;
            first = listArray[first].getNext();
            listArray[tempFirst].setNext(-1);
            isFound = true;

        }else {// if found more than two elements

            int anotherTempFirst = first;
            int current = listArray[first].getNext();

            while (current != -1) {
                //if the inserted data is equal to the current data(first data)
                if (listArray[current].getData().compareToIgnoreCase(data) == 0) {

                    //setting the current next data to the temporary one
                    listArray[anotherTempFirst].setNext(listArray[current].getNext());
                    //And the set that current first to a null
                    listArray[current].setNext(-1);
                    arraySpace = current;
                    isFound = true;
                    break;

                } else {
                    //otherwise set the current to the temporary
                    anotherTempFirst = current;
                    current = listArray[current].getNext();
                }
            }
        }
        if (isFound){
            //removing the element at the end of the list
            if (arraySpace == firstFree -1){

            }else if (firstFree - 1 == first){
                listArray[arraySpace].setData(listArray[firstFree - 1].getData());
                listArray[arraySpace].setNext(listArray[firstFree - 1].getNext());
                first = arraySpace;
            }else {//check middle of array
                int high = firstFree - 1;
                //copy last to removed space
                listArray[arraySpace].setData(listArray[high].getData());
                listArray[arraySpace].setNext(listArray[high].getNext());

                //element pointing to the last
                int tempFirst = first;
                while (tempFirst != -1){
                    if(listArray[tempFirst].getNext() == high){
                        listArray[tempFirst].setNext(arraySpace);
                        break;
                    }else {
                        tempFirst = listArray[tempFirst].getNext();
                    }
                }
                //And finally decrement the first free
                firstFree--;
            }

        }
        return isFound;
    }

    public boolean removeModifiedVersion7(String data) {

        //removed element becomes null
        int itemRemoved = -1;
        boolean isFound = false;
        //if first is null(empty)
        if (first == -1) {

            //if there is a mismatch with one existing element//
        } else if (listArray[first].getData().compareToIgnoreCase(data) != 0 && isEmpty()) {

            //if matches the first elelment
        } else if (listArray[first].getData().compareToIgnoreCase(data) == 0) {

            //assign first to temp
            int tempFirst = first;

            //get its first
            first = listArray[first].getNext();
            //and then set it to null
            listArray[tempFirst].setNext(-1);

            itemRemoved = tempFirst;
            isFound = true;

        } else {// if found more than two elements

            int anotherTempFirst = first;
            int current = listArray[first].getNext();

            while (current != -1) {

                //if the inserted data is equal to the current data(first data)
                if (listArray[current].getData().compareToIgnoreCase(data) == 0) {

                    //setting the current next data to the temporary one
                    listArray[anotherTempFirst].setNext(listArray[current].getNext());
                    itemRemoved = current;
                    isFound = true;
                    break;
                } else {
                    anotherTempFirst = current;
                    current = listArray[current].getNext();
                }

            }
            if (isFound) {
                listArray[itemRemoved].setNext(firstFree);
                firstFree = itemRemoved;
            }
        }
        return isFound;
    }

    public boolean isEmpty() {

        //if first is null(empty) returns true otherwise false
        return listArray[first].getNext() == -1;
    }

    public boolean isFull() {
        //return true if first free is way over than the list length otherwise false
        return firstFree >= listArray.length;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nfirst: ").append(first).append("\n").append("firstFree: ").append(firstFree).append("\n\n");
        stringBuilder.append("\t\t\tIndex\t\t Data\t Indices").append("\n\n");
        for(int i = 0; i < listArray.length && listArray[i] != null; i++){
            if (listArray[i] != null){
                //call the overrided method from SLLNode and then display it
                stringBuilder.append("\t\t\t ").append(i).append(": ").append(listArray[i].toString()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

   public SLLIterator getIterator() {
        return new SLLIterator(first, listArray);
   }
}
