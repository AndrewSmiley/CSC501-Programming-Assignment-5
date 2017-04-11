/**
 * Created by andrewsmiley on 03/08/17.
 */
public class UnorderedLinkedList {
    // the head element of our linked list
    Node head;
    //the number of nodes in our linked list
    int size;
    // the number of operations x operations takes
    int operations;
    //just a simple constant to reference a value we could not find
    public static final int VALUE_NOT_FOUND = -666;




    //overload the constructors

    /**
     * The default no-arg constructor
     */
    public UnorderedLinkedList() {
        this.head = null;
        this.size = 0;
        this.operations = 0;

    }

    /**
     * A constructor that will allow us to initiazlize this list with a default value
     * @param head
     */
    public UnorderedLinkedList(Node head) {
        //set the head = the haed we passed in
        this.head = head;
        this.size=0;
        this.operations =0;
    }
    /**
     * Override toString method to get the contents of our list
     * @return
     */
    @Override
    public String toString() {
        //base case of empty string
        if(this.isEmpty()){
            return "Empty Linked List";
        }
        StringBuilder sb = new StringBuilder();
        Node currentNode = this.head;
        while (currentNode != null){
            sb.append(currentNode.getValue()+" ");
            currentNode = currentNode.next();
        }
        return sb.toString();
    }



    /**
     * Get the number of operations performed on the list
     * @return the number of total operations
     */
    public int getOperations() {
        return operations;
    }

    /**
     * Set the number of operations
     * @param operations the number of operatons to set
     */
    public void setOperations(int operations) {
        this.operations = operations;
    }
    /**
     * Get the size of our linked list
     * @return the number of elements in our linked list
     */
    public int getSize() {
        return size;
    }



    /**
     * Get head, well, get THE head
     * @return the head of our linked list
     */
    public Node getHead() {
        return head;
    }

    /**
     * Set the head of our linked list
     * @param head a head to use on our linked list
     */
    public void setHead(Node head) {
        this.head = head;
    }



    /**
     * Remove all elements from our linked list
     */

    public void clear() {
        this.head = null; //just set the head to null to remove our nodes
//        operations = operations+1;//increase operations for clearning the node
        this.operations = 0;//reset operations
        this.size = 0; //set size to 0 since our linked list is empty
    }

    /**
     * Determine if our linked list is empty or not
     *
     * @return true if there are no elements in our linked list, false otherwise
     */

    public boolean isEmpty() {
        operations = operations+1;//add one operation because we compare values
        return this.head == null; //make it simple, ternary!

    }


    /**
     * Add a value to our linked list
     *
     * @param value the value to add to our linked list
     */
    public void  add(Integer value) {
        //handle the base case if our linked list is empty
        if(this.isEmpty()){
            this.head = new Node(value);
            operations++;// = operations+1;//increase the size of operations because we've added a new node
            size++; //increment the size because we've added an element
        }else{
            Node currentNode = this.head; //get the head of the linked list
            operations++;// = operations+1;//increase size of operations for fetching the first node
            //just walk the linked list to get the last node
            while (currentNode.hasNext()){
                currentNode = currentNode.next();//move toward the end
                operations = operations+1;//increase operations for moving to next node
            }
            currentNode.setNext(new Node(value));//append to the tail
            operations++;// = operations+1;//increase operations because we had to set a new node
            size++; //increment the size because we've added an element
        }

    }

    /**
     * Delete a node at the index specified. Zero indexed of course
     * @param index the index of the node we want to remove
     * @return  the number of operations we have done to execute the operation
     */
    public void deleteNth(int index){
//        int operations = 0; //the number of steps it takes to perform this operation
        //first, check to make sure we are not deleting something outsize the bounds of our linked list
        //otherwise, throw an exception
        operations++; //increase operations because of this comparison
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("The index you are trying to remove does not exist in this node");
        }
        //if we are deleting the first node
        operations++; //increase operations because of this comparison
        if(index == 0){
            operations++; //increase operations because of this comparison
            if(this.head.next() == null){
                this.head = null;
                size --;//decrement size because we have removed the node
            }else {
                this.head = this.head.next();
                operations++; //increment the number of operations because we have to check the next node
                size --;//decrement size because we have removed the node
            }
        }

        Node currentNode = this.head;//start at the top
        for(int i = 0; i < index-1; i++, this.operations++){
            operations++; //increase operations because of this traversal
            currentNode = currentNode.next(); // get the next element

            if (currentNode == null){
                throw  new IndexOutOfBoundsException("Trying to access an index that does not exist. Is something wrong with your linked list?");
            }
        }
        //once we have our current node, we can get hte next one and the one after that
        Node nextNode = currentNode.next();
        this.operations ++; //increment operations because we have to ge the next now
        currentNode.setNext(nextNode.next()); //from here, just attach the next node to the next node of our current operating node
        operations = operations+1;//increment operations because we have to now set the new node
        operations = operations+1;// increment operations because we have to grab the next of the next
        this.size--;
    }

    /**
     * This is our sequential search function. Find the index of the specified value, return VALUE_NOT_FOUND
     * if the element does not exist in the list
     * @param value the value to search for
     * @return the index of the element we were searching for
     */
    public int find(int value){
        Node currentNode = this.head; //start at the head
        operations++;//increase operations for this assignment
        int index = 0; //this is our current working index like if we were iterating over an array
        //traverse the nodes with sequential serach
        while(currentNode != null){
            operations++;//increase operations for the comparison
            if(currentNode.getValue() == value){ //if the node we are on contains the value we want, then we return the index
                return index; //return the index of the found value
            }else{
                //move to the next node in the series
                currentNode = currentNode.next();
                operations++;//increase operations for moving to the next
                index++; //increase the index
            }
        }
        return VALUE_NOT_FOUND; //if not found, return the error code
    }

    /**
     * Delete the value specified from the array
     * @param value the value we want to delete
     */
    public void delete(Integer value){
        Node currentNode = this.head; //start at the head
        operations++;//increase operations for this assignment
        //traverse the nodes with sequential serach
        while(currentNode != null){
            operations++;//increase operations for the comparison
            if(currentNode.getValue() == value){ //if the node we are on contains the value we want, then we return the index
                //once we have our current node, we can get hte next one and the one after that
                Node nextNode = currentNode.next();
                this.operations ++; //increment operations because we have to ge the next now
                currentNode.setNext(nextNode.next()); //from here, just attach the next node to the next node of our current operating node
                operations = operations+1;//increment operations because we have to now set the new node
                break;

            }else{
                //move to the next node in the series
                currentNode = currentNode.next();
                operations++;//increase operations for moving to the next
                operations = operations+1;// increment operations because we have to grab the next of the next
                this.size--;
            }
        }

    }
}