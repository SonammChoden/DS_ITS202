import java.util.*;

public class BST1<Key extends Comparable <Key>, Value>
{
	private Node root;

	public class Node
	{
		private Key key;
		private Value val;
		private Node left,right;
		private int size;

		public Node(Key key, Value val, int size)
		{
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}
	// public BST1()
	// {
	// 	root =null;
	// }
	//is empty
	public boolean isEmpty()
	{
		if(size() == 0)
		{
			return true;
		}
		return false;
	}

	public int size()
	{
		return size(root);
	}

	private int size(Node x)
	{
		if(x == null) return 0;
		else 
			return x.size;
	}

	//To check wether the given key is there in the symbol table or not.
	public boolean contains(Key key)
	{
		if(key == null) throw new IllegalArgumentException("The key to be contain is null.");
	
		return get(key) != null;	
	}
	//get 
	public Value get(Key key)
	{
		return get(root, key);
	}
	public Value get(Node x, Key key)
	{
		if(key == null) throw new IllegalArgumentException("key to be contained is null.");
		if(x == null) return null;
		int cmp = key.compareTo(x.key);

			if      (cmp < 0)    return get(x.left, key);
			else if (cmp > 0)    return get(x.right, key);
			else                 return x.val;
	}
	//put or inserting elements in a symbol table.
	public void put(Key key, Value val)
	{
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val)
	{
		if(x == null) 
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)     
			x.left = put(x.left, key, val);
		else if(cmp > 0)
			x.right = put(x.right, key, val);
		else 
			x.val = val;
		x.size=1+size(x.right)+size(x.left);
		return x;
	}
	//min 
	public Key min()
	{
		return min(root).key;
	}
	private Node min(Node x)
	{
		if(x.left == null) return x;
		return min(x.left);
	}
	// To finf the floor
	public Key floor(Key key)
	{
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}

	private Node floor(Node x, Key key)
	{
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if  (cmp == 0) return x;
		if  (cmp < 0)  return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;
	}
	//select the element
	public Key select(int k)
	{
		if (k < 0 || k >= size())
		{
			throw new IllegalArgumentException("key to be selected is null: "+k);
		}
		return select(root, k);
	}

	private Key select(Node x, int k)
	{
		if (x == null) return null;
		int leftsize = size(x.left);
		if (leftsize > k) return select(x.left, k);
		else if  (leftsize < k) return select(x.right, k - leftsize - 1);
		else return x.key;
	}

	 public Iterable<Key> keys(Key lo, Key hi) {
         if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        LinkedList<Key> arr = new LinkedList<Key>();
        keys(root, arr, lo, hi);
        return arr;  
    } 
	private void keys(Node x,LinkedList<Key> arr, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, arr, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) arr.add(x.key); 
        if (cmphi > 0) keys(x.right, arr, lo, hi);
        
    } 
	// deleting specific key-value pair from the tree
      public void deleteMin() {
        
        root = deleteMin(root);
        
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key) {
        root = delete(root, key);
        
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 
	public static void main(String args []){
		BST1 <String, Integer> obj=new BST1 <String, Integer>();
		obj.put("Ada",1);
		obj.put("Ballerina",3);
		obj.put("HTMl",5);
		obj.put("Java",7);
		obj.put("Dart",9);
		
		obj.delete("Java");

		System.out.println(obj.get("Ada"));
		System.out.println(obj.get("Ballerina"));
		System.out.println(obj.size());
		System.out.println(obj.floor("Ada"));
		
		System.out.println(obj.select(3));
		System.out.println(obj.isEmpty());
		//System.out.println(0bj.min("Ada"));
		
		System.out.println("All the test has passed");
	}

}