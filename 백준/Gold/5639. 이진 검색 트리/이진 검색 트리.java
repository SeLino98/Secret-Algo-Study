import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> rootValueList = new ArrayList<>();
    static int index = 0;
    public static void main(String[] args) throws IOException {
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            rootValueList.add(Integer.parseInt(input));
        }
        BinaryTree binaryTree = new BinaryTree();
        Node node = binaryTree.preorderToBinaryTree(Integer.MAX_VALUE, Integer.MIN_VALUE);
        binaryTree.postorder(node);
        System.out.println(sb);
    }
    static class BinaryTree{


        Node preorderToBinaryTree(int max, int min){
            if (rootValueList.size()<=index) return null;
            int curValue = rootValueList.get(index);
            if (curValue<min||curValue>max) return null;
            index++;
            Node root = new Node(curValue);
            root.left = preorderToBinaryTree(curValue,min);
            root.right = preorderToBinaryTree(max,curValue);
            return root;
        }
        void postorder(Node node){
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            sb.append(node.data).append('\n');
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null; // 초기 값 세팅
        }
    }
}
