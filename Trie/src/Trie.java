import java.util.ArrayList;
import java.util.Collections;


public class Trie {
  
   // Alphabet size (# of symbols)
   static final int ALPHABET_SIZE = 26;
   static TrieNode root;
  
   static class TrieNode
   {
       TrieNode[] children = new TrieNode[ALPHABET_SIZE];
       boolean isEnd;
       int visits;
       TrieNode(){
           isEnd = false;
           visits=0;
           for (int i = 0; i < ALPHABET_SIZE; i++)
               children[i] = null;
       }
   }

   static void insert(String key)
   {
       int level;
       int length = key.length();
       int index;
  
       TrieNode tri = root;
  
       for (level = 0; level < length; level++)
       {
           index = key.charAt(level) - 'a';
           if (tri.children[index] == null)
               tri.children[index] = new TrieNode();
           tri.visits++;
           tri = tri.children[index];
           
       }
  
       tri.isEnd = true;
   }
   
   
   static boolean find(String key)
   {
       int level;
       int length = key.length();
       int index;
       TrieNode trie = root;
  
       for (level = 0; level < length; level++)
       {
           index = key.charAt(level) - 'a';
  
           if (trie.children[index] == null)
               return false;
  
           trie = trie.children[index];
       }
  
       return (trie != null && trie.isEnd);
   }
   
  

   static ArrayList<String> predict(String key, int x)
   {
	   ArrayList<String> result = new ArrayList<String>();
       TrieNode tri = root;
       ArrayList<String> word = new ArrayList<String>();
       ArrayList<Integer> visit = new ArrayList<Integer>();

       for (char c : key.toCharArray()) 
       {
           if (tri.children[c - 'a'] == null) 
        	{
        	   ArrayList<String> empty = new ArrayList<String>();
        	   return empty;
        	}
           word.add();
           
        	   
           
           tri = tri.children[c - 'a'];
           
           
       }
       result = predictHelper(word, x);
       
  
       return result;
   }
   
   static ArrayList<String> predictHelper(ArrayList<String> words, ArrayList<Integer> visit)
   {
	   ArrayList<String> highest = new ArrayList<String>();
	   for(int y = 0; y < words.size(); y++)
	   {
		   
	   }
	   return highest;
   }
  
   // Driver
   public static void main(String args[])
   {
       String keys[] = {"test", "apple", "tester", "ten", "testing", "tennant", "tenure", "tenacity", "tentacle", "tenantry", "tendency", "tent", "tenor", "tend", "tenders", "tend", "tending", "tender", "test", "test", "test",
    		    "quarintine", "quaffle", "quarrel", "quirrell", "quirrell", "quirrell", "quirrell", "quaffle", "quaffle", "quaffle", "quaffle", "quarintine"};
  
       root = new TrieNode();
  
       for (int i = 0; i < keys.length ; i++)
           insert(keys[i]);
  
       // Search for different keys
       System.out.println(Trie.predict("te", 2));
       System.out.println(Trie.predict("qu", 3));
       System.out.println(Trie.root.visits);
      
   }
}