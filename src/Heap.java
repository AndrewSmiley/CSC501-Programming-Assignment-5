/**
 * Created by Andrew on 4/11/17.
 */
public class Heap {
    //this is the size our our heap (i.e. how many elemetns to allocate for
    int capacity;
    //this is the number of elemnts actuall stored in our heap
    int size;



    //this is our actual inner array to store the heap elements
    Integer[] heap;

    public Heap(int _size){
        this.capacity = _size;//point our size ot it
        this.heap = new Integer[_size]; //init our array
        this.size = 0; //set our size to 0

    }


    /**
     * This is our insertion method. Insert an item into the heap, maintaining the complete binary tree
     * @param value the value to insert
     * @throws Exception throw an exception if the value already exists in the heap
     */
    public void insert(int value) throws Exception{
        this.heap[size] = value; //place the item at the 'bottom' of our heap
        int place = size; //store a placeholder for our index
        int parent = (place -1) / 2; // the index of the parent node
        int temp; //init temp outide of hte loop
        while (place > 0 && heap[place] > heap[parent]){
            //swap place and parent
            temp = heap[place];
            heap[place]= heap[parent];
            heap[parent]= temp;
            //update the place index
            place = parent;
            parent = (place -1) / 2; // the index of the parent

        }
        size++; //increment size
    }


    /**
     * This is our delete method for our heap. In this case, we always delete the head, essentially breaking up the
     * heap and then we rebuild the heap for an O(log(n)) operation
     * @return int the previous head
     */
    public int delete(){

        int tempHead = heap[0];//temporarily store the head item
        heap[0] = heap[size-1]; //then replace it with the last element in the heap
        int root =0; //mark the root of the heap
        //mark the left child of the root
        int left = 2*root+1;
        //then mark the right subchild
        int right = left+1;

        int temp =0;//create a temp variable to use during our swaps
        //basically iterate till we've either reached a root index that is greater than or equal to half hte size
        //and while the 'root' is less than the left and right subnodes
        while (root <= size/ 2 && heap[root] < Math.min(heap[left], heap[right])){
            //if the left is bigger than the right, looks like we need to swap the left and root nodes
            if(heap[left] > heap[right])  {
                //do the swap
                temp = heap[root];
                heap[root] = heap[left];
                heap[left] = temp;
                //update the root, left and right nodes
                root = 2 * root + 1;
                left = 2 * root + 1;
                right = left + 1;  }
            else {
                //otherwise, we need to swap the root and left nodes
                temp = heap[root];
                heap[root] = heap[right];
                heap[right] = temp;
                //update the root, left and right nodes
                root = 2 * root + 2;
                left = 2 * root + 1;
                right = left + 1;  }
        }
        //decrement size
        //return the old head
        size--;
        return tempHead;

    }

    /**
     * This is our method to check if our heap is empty or not. Basically one simple line, return true if the size of hte
     * heap is > 0, false otherwise
     * @return boolean t true if the size of the heap is > 0, false otherwise
     */
    public boolean isEmpty(){ return this.size  > 0;}
}
