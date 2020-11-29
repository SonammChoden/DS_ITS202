import java.util.*;

public class Solution1<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution1() {
        root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    //isEmpty
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }
        return false;  
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    //size
    public int size() {
      return size(root);
       
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) {
            return 0;
         }
        return 1 + size(x.left) + size(x.right);
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    //get
    public Value get(Key key){

        if(key==null) throw new IllegalArgumentException ("Key is null");  //when the key is null
            if(size()==0) throw new NoSuchElementException("Symbol table is empty");  // when the symboltable is empty.
        else{
            return get(root,key);
        }
    }
        
    private Value get(Node x, Key key) {
    //Node x = root;
        // traverse until the value of x is null otherwise will return null.
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null; 
    }   
    //}

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    //put
    public void put(Key key, Value val) {
        if(key==null)
        {
            throw new IllegalArgumentException ("Key is null"); // When the key is null.
        }
        //creating new node
        Node newest = new Node(key, val, 1);//d,1//b,2//f,3//f,4
        if (root == null) {
            root = newest;
            return;
        }
        Node parent = null, x = root;   //d,1
        while (x != null) {
            parent = x;             //d,1//f,3
            int cmp = key.compareTo(x.key);   //f>d//f=f
            if      (cmp < 0) x = x.left;     //x=null
            else if (cmp > 0) x = x.right;    //f,3
            else {
                x.val = val;      //3=4   // overwrite duplicate value.
                return;
            }   
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = newest;
        else         parent.right = newest;   
    }

    // private Node put(Node x, Key key, Value val) {
        
    // }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */

    //min
    public Key min() {
        if(size()==0) throw new NoSuchElementException ("The symbol table is empty");//symbol table is empty.
       
        return min (root).key;
    } 
    private Node min(Node x) { 
        x=root;
        while(x.left!=null)
            x=x.left;
        return x;      
    } 
    // /**
    //  * Returns the largest key in the symbol table less than or equal to {@code key}.
    //  *
    //  * @param  key the key
    //  * @return the largest key in the symbol table less than or equal to {@code key}
    //  * @throws NoSuchElementException if there is no such key
    //  * @throws IllegalArgumentException if {@code key} is {@code null}
    //  */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException ("Key is null");  //throwing exception if the key is null
        if(size()==0) throw new NoSuchElementException ("Symbol table is empty"); //if the size of symbol table is zero.

        Node a = floor(root, key);
        if(a==null) return null;
        else return a.key;     
    } 
    private Node floor(Node x, Key key) {
        //create newest node.
        Node newest = null, floor = min(x);

        while(x!=null)
        {
            int cmp=key.compareTo(x.key);

            if(cmp<0) x = x.left;

            else if(cmp>0)
            {
                int comp =floor.key.compareTo(x.key);

                if(comp<=0)
                {
                    floor=x;
                    newest=floor;
                }
                x=x.right;
            }
            else return x;
        }
        return newest;
    }
    // /**
    //  * Return the key in the symbol table whose rank is {@code k}.
    //  * This is the (k+1)st smallest key in the symbol table.
    //  *
    //  * @param  k the order statistic
    //  * @return the key in the symbol table of rank {@code k}
    //  * @throws IllegalArgumentException unless {@code k} is between 0 and
    //  *        <em>n</em>–1
    //  */
    public Key select(int rank){

        if(rank<0 || rank>=size()) throw new NoSuchElementException("Rank should be either greater than or equal to zero or less than size.");
       // creating temporary node x.
        Node x= select(root, rank);
        if(x!=null) return x.key;
        return null;
    }
    //Return key of rank or otherwise null 
    private Node select(Node x, int rank){
        while(x!=null){
            int size = size(x.left);

            //if the size of left node is greater then given rank.
            if(size > rank) x = x.left;

            //if the rank is greater than size of left node
            else if(size < rank){
                x = x.right;
                rank = rank - size - 1;
            }
            // Rank is equal to node
            else return x;
        }
        return null;
    }

    //  * Returns all keys in the symbol table in the given range,
    //  * as an {@code Iterable}.
    //  *
    //  * @param  lo minimum endpoint
    //  * @param  hi maximum endpoint
    //  * @return all keys in the symbol table between {@code lo} 
    //  *         (inclusive) and {@code hi} (inclusive)
    //  * @throws IllegalArgumentException if either {@code lo} or {@code hi}
    //  *         is {@code null}
    //  */
     public Iterable<Key> keys(Key lo, Key hi){
        if(lo==null || hi==null) throw new IllegalArgumentException(" Key is null");

        Queue<Key> queue_list = new LinkedList<Key>();
        keys(root, queue_list, lo, hi); 
        return queue_list;
    }

    //add key to the queue if the key>=lo && key<=hi
    private void keys(Node x, Queue<Key> queue_list, Key lo, Key hi){ 
        if (x == null) return;  
        
        Node temp = x;  
        //traverse through the tree until the Node is null
        while (temp != null){  
      
            int cmp = temp.key.compareTo(hi);
            int cam = temp.key.compareTo(lo);

            //set temp to right node if the node is null 
        
            if (temp.left == null){   
                if (cmp <= 0 && cam >= 0)  queue_list.offer(temp.key);
                temp = temp.right;
            }else{  
                Node node2 = temp.left;
                while (node2.right != null && node2.right != temp)  
                    node2 = node2.right;  

                if (node2.right == null){  
                    node2.right = temp;  
                    temp = temp.left; 
            
                // set node2.right to nul if node2.right equals to node.
                }else{  
                    node2.right = null;    
                    if (cmp <= 0 && cam >= 0)  queue_list.offer(temp.key);  
                    temp = temp.right;  
                }  
            }  
        }   
    }
   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  //Main Method
    public static void main(String[] args) { 
        Solution1 <String, Integer> obj = new Solution1 <String, Integer>();
        obj.put("ABDUL",1);
        System.out.println(obj.get("ABDUL"));

        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        System.out.println(obj.get("SAI"));

        obj.put("TASHI",4);
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.select(2));

        for (String s : obj.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        System.out.println(obj.get("SAMAL"));
        obj.put("NIMA",7);
        System.out.println(obj.size());
        System.out.println(obj.get("CHIMI"));
        System.out.println(obj.floor("CHIMA"));
        obj.put("SONAM",8);

        for (String s : obj.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();      
    }
}