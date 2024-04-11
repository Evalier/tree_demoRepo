// Name: Eva Santana
// Date: 4/7/2024 
// File: TreeDemo.java 

class Node{ // Implement 6 different functions and commit them 6 different times 
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
	   * Pre-order traversal
	   * Prints the value of every node in preorder
	   * 
	   * @param root the root node of the tree
	   */
	   public void preOrderTraversal(Node root){
	      if (root != null){
	         System.out.print(root.value + " ");
	         preOrderTraversal(root.left);
	         preOrderTraversal(root.right);
	      }
	   }
	   
	   
	   /**
	   * In-order traversal
	   * 
	   * @param root the root node of the tree
	   */
	   public void inOrderTraversal(Node root){
       		if (root != null) {
          		inOrderTraversal(root.left);
          		System.out.print(root.value + " ");
          		inOrderTraversal(root.right);
       		}
	   }
	   
	   
	   
	   /**
	   * Post-order traversal
	   * 
	   * @param root the root node of the tree
	   */
	   public void postOrderTraversal(Node root){
       		if (root != null) {
          		postOrderTraversal(root.left);
          		postOrderTraversal(root.right);
          		System.out.print(root.value + " ");
       		}
	   }
	   
	   
	   
	   /**
	   * A method to find the node in the tree with a specific value.
	   * 
	   * @param root the root node of the tree
	   * @param key the specific value to be found
	   * @return true if the value is found, false otherwise
	   */
	   public boolean find(Node root, int key){
       if (root != null) {
          if (root.value == key) {
            return true; 
          }
          if (find(root.left, key) || find(root.right, key)) {
            return true;
          }
       }
       return false; 
	   }
	   
	   
	   
	   /**
	   * A method to find the node in the tree with the smallest key.
	   * 
	   * @param root the root node of the tree
	   * @return the smallest key in the tree
	   */
	   public int getMin(Node root){
       		if (root != null && root.left != null) {
         		return getMin(root.left);
       		}
       		return root.value;
	    }
	  
	  
	   /**
	   * A method to find the node in the tree with the largest key.
	   * 
	   * @param root the root node of the tree
	   * @return the largest key in the tree
	   */
	   public int getMax(Node root){
       		if (root != null && root.right != null) {
         		return getMax(root.right);
       		}
       		return root.value; 
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert(24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();

        System.out.println(t1.find(t1.root, 90));

       System.out.println(t1.getMin(t1.root));
	     System.out.println(t1.getMax(t1.root));
	      
	   }  
	}
