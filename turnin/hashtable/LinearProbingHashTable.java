/**
 * Created by Andrew on 4/5/17.
 */

/**
 * This is our Linear probing hash table.
 * This class contains an inner hash table represented by an array that has a standard hasing function (value % size)
 * and will 'probe forward' looking for a place to insert or find a value by incrementing the index by one degree until
 * an empty array position is found or the value is found repsectively, or the index would exceed the array
 */
public class LinearProbingHashTable {

    //this reflects the size of the inner has table (number of elements we've allocated for)
    int size;
    //this is our member variable that represents the number of collisions
    int numberOfCollisions;
    //this is our inner hash table
    Integer[] hashTable;

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

    public LinearProbingHashTable(int size){
        this.size=size; //assign the size vairable
        this.hashTable = new Integer[size]; // create our inner hashtable array
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
        //then iterate till we reach the end OR till we find an empty position by incrementing the index by one degree
        //everytime we iterate we know that we have not found an empty position so we need to increase the number of collisions as well
        while(this.hashTable[index] != null && index < this.size-1){
            this.numberOfCollisions++;
            index++;
        }
        //then assign the value
        this.hashTable[index]=value;
    }

    /**
     * Retrieve a value from our hash table by getting the key and calling the linked list search funciton on the linked list
     * at that index
     * @param value the value to search for
     * @return int the index of the value?
     */
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

}
