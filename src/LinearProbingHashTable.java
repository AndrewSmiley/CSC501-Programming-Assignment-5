/**
 * Created by Andrew on 4/5/17.
 */
public class LinearProbingHashTable extends ChainedHashingHashTable {

    //this reflects the size of the inner has table (number of elements we've allocated for)
    int size;
    //this is our inner hash table
    Integer[] hashTable;

    /**
     * This is our
     * @param size
     */
    public LinearProbingHashTable(int size){
        this.size=size;
        this.hashTable = new Integer[size];
    }

    /**
     * This is our hashing function. We want to return an int index between 0 and size-1, so we do value modulo size
     * @param value the value to hash
     * @return int the hash key
     */
    public int hash(Integer value){
        int hash = value % size;
        return hash;
    }

    /**
     * This method allows us to insert into the hash table by inserting the value at the hashed index
     * @param value the value we want to insert into the hash table
     */
    public void insert(int value){
        //basically get the starting index from the hash value
        int index = this.hash(value);
        //then iterate till we reach the end OR till we find an empty position
        while(this.hashTable[index] != null && index < this.size-1){
            this.numberOfCollisions++;
            index++;
        }
        this.hashTable[index]=value;

//        insertLinkedList(value, hash(value));
    }

    /**
     * Retrieve a value from our hash table by getting the key and calling the linked list search funciton on the linked list
     * at that index
     * @param value the value to search for
     * @return int the index of the value?
     */
    //todo ask fox what to return here
    public int search(int value){
        int index = hash(value);
        //basically we want to probe forward until we find empty space (indicating that the element does not exist)
        // or while the element we are looking at is not the element we want
        while(index < size -1 && this.hashTable[index] != value){
            numberOfCollisions ++;
            index++;
        }
        //then return the value if we've found it, false otherwise
        return (this.hashTable[index] != null) ? this.hashTable[index] : null;
    }


//    /**
//     * * Add a value to our linked list
//     *
//     * @param value the value to add to our linked list
//     * @param index the index of hash table to insert at
//     */
//    public void  insertLinkedList(Integer value, int index) {
//        //handle the base case if our linked list is empty
//        if(this.hashTable[index] == null){
//            this.hashTable[index]= new Node(value);
////            size++; //increment the size because we've added an element
//        }else{
//            Node currentNode = this.hashTable[index]; //get the head of the linked list
//            //just walk the linked list to get the last node
//            while (currentNode.hasNext()){
//                currentNode = currentNode.next();//move toward the end
//            }
//            currentNode.setNext(new Node(value));//append to the tail
//            size++; //increment the size because we've added an element
//        }
//
//    }
//
//    /**
//     * This is our sequential search function. Find the index of the specified value, return VALUE_NOT_FOUND
//     * if the element does not exist in the list
//     * @param value the value to search for
//     * @return the index of the element we were searching for
//     */
//    public int searchLinkedList(int value, int index){
//        Node currentNode = this.hashTable[index]; //start at the head
//        int i = 0; //this is our current working index like if we were iterating over an array
//        //traverse the nodes with sequential serach
//        while(currentNode != null){
//
//            if(currentNode.getValue() == value){ //if the node we are on contains the value we want, then we return the index
//                return i; //return the index of the found value
//            }else{
//                //move to the next node in the series
//                currentNode = currentNode.next();
//
//                i++; //increase the index
//            }
//        }
//        return -1; //if not found, return the error code
//    }

}
