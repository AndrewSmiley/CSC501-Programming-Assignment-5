/**
 * Created by Andrew on 4/5/17.
 */
public class ChainedHashingHashTable {
    //this reflects the size of the inner has table (number of elements we've allocated for)
    int size;
    //this is our storage for the number of collisions when performing our operations
    int numberOfCollisions;
    //this is our inner hash table
    Node[] hashTable;

    /**
     * This is our getter for our number of collisions
     * @return the number of collisions
     */
    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }


    /**
     * This is our constructor. Create a hashtable or the given size
     * @param size the size of our hash table
     */

    public ChainedHashingHashTable(int size){
        this.size = size;
        this.hashTable = new Node[size];
        this.numberOfCollisions = 0;
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
        //basically we simply hash the value and then do the linked list insert at that key
        insertLinkedList(value, this.hash(value));
    }

    /**
     * Retrieve a value from our hash table by getting the key and calling the linked list search funciton on the linked list
     * at that index
     * @param value the value to search for
     * @return int the index of the value?
     */
    //todo ask fox what to return here
    public int search(int value){
        //again, just do the linked list search at the hashed value key
        return searchLinkedList(value, hash(value));
    }


    /**
     * * Add a value to our linked list
     *
     * @param value the value to add to our linked list
     * @param index the index of hash table to insert at
     */
    public void  insertLinkedList(Integer value, int index) {
        //handle the base case if our linked list is empty
        if(this.hashTable[index] == null){
            //store  the new node at the head
            this.hashTable[index]= new Node(value);
        }else{
            //create the new head (new node)
            Node newNode = new Node(value);
            //point it to our current head
            newNode.setNext(this.hashTable[index]);
            //finally, set our current head to the new node
            this.hashTable[index] = newNode;
        }

    }

    /**
     * This is our sequential search function. Find the index of the specified value, return VALUE_NOT_FOUND
     * if the element does not exist in the list
     * @param value the value to search for
     * @return the index of the element we were searching for
     */
    public int searchLinkedList(int value, int index){
        Node currentNode = this.hashTable[index]; //start at the head
        //check to see if the current head is not null and if it is our given value
        if(this.hashTable[index] != null && this.hashTable[index].getValue() == value){
            return this.hashTable[index].getValue();
        }
        //traverse the nodes with sequential serach
        while(currentNode != null){
            if(currentNode.getValue() == value){ //if the node we are on contains the value we want, then we return the index
                return  currentNode.getValue(); //return the value stored
            }else{
                //move to the next node in the series
                currentNode = currentNode.next();
                this.numberOfCollisions++; //increase the number of collisions
            }
        }
        return -1; //if not found, return the error code
    }

}
