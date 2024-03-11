import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class TrieNode{
        HashMap<String, TrieNode> childNode = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {

        //Map의 entrySet, keySet;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int eatInfoSize = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        TrieNode rootNode = new TrieNode();
        for (int t = 0; t < eatInfoSize; t++) {

            st = new StringTokenizer(br.readLine());

            int caveDepth = Integer.parseInt(st.nextToken());

            TrieNode currentNode = rootNode;

            for (int i = 0; i < caveDepth; i++) {
                String str = st.nextToken();
                if (!currentNode.childNode.containsKey(str)){
                    currentNode.childNode.put(str,new TrieNode());
                }
                currentNode = currentNode.childNode.get(str);//str을 가져온다.
            }
        }
        print(rootNode, "");
    }

    public static void print(TrieNode root, String bar){
        Object[] key = root.childNode.keySet().toArray();
        Arrays.sort(key);
        for (Object s : key){
            System.out.println(bar+s);
            print(root.childNode.get(s),bar+"--");
        }
    }
}
