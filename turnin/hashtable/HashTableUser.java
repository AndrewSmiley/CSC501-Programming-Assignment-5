/**
 * Created by Andrew on 4/5/17.
 */
public class HashTableUser {
    public static void main(String[] args) {

        //create our temporary number storage
        Integer[] numbers = new Integer[75];
        //fill our number array with 75 random ints
        for(int i = 0; i < 75; i++){
            numbers[i]= 0 + (int)(Math.random() * ((999999- 0) + 1));
        }


        ChainedHashingHashTable chainedHashingHashTable = new ChainedHashingHashTable(31);
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable(101);
        QuadraticProbingHashTable quadraticProbingHashTable = new QuadraticProbingHashTable(101);
        for(int i = 0; i < 75; i++){
            chainedHashingHashTable.insert(numbers[i]);
            linearProbingHashTable.insert(numbers[i]);
            quadraticProbingHashTable.insert(numbers[i]);
        }
        System.out.println("Collisions:");
        System.out.println("Linear: "+linearProbingHashTable.getNumberOfCollisions());
        System.out.println("Quadratic: "+quadraticProbingHashTable.getNumberOfCollisions());
        System.out.println("Chained: "+chainedHashingHashTable.getNumberOfCollisions());

        System.out.println("\n\n");
        for(int i = 0; i < 75; i++){
            chainedHashingHashTable.search(numbers[i]);
            linearProbingHashTable.search(numbers[i]);
            quadraticProbingHashTable.search(numbers[i]);
        }

        System.out.println("Collisions:");
        System.out.println("Linear: "+linearProbingHashTable.getNumberOfCollisions());
        System.out.println("Quadratic: "+quadraticProbingHashTable.getNumberOfCollisions());
        System.out.println("Chained: "+chainedHashingHashTable.getNumberOfCollisions());

    }
}
