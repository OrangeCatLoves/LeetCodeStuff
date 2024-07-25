import java.util.HashSet;

public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    /*public String alienOrder(String[] words) {
        // Write your code here
        Set<Integer> order = new HashSet<>();
        List<Integer>[] directedGraph = new List[26];
        int[] inDegree = new int[26];
        HashSet<Integer> allUniqueChar = new HashSet<>();
        // Populate allUniqueChar set
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                allUniqueChar.add(words[i].charAt(j) - 'a');
            }
        }
        // Populate adjacency list
        for (int i = 0; i < 26; i++) {
            directedGraph[i] = new ArrayList<>();
        }
        for (String word: words) {
            for (int i = 0; i < word.length() - 1; i++) {
                int index = word.charAt(i) - 'a';
                int val = word.charAt(i + 1) - 'a';
                // Take into account t -> t
                if (index != val) {
                    directedGraph[index].add(val);
                    inDegree[val]++;
                }
            }
        }
        // There are some nodes which are not even given, initialise in-degree val to -1
        for (int i = 0; i < inDegree.length; i++) {
            if (!allUniqueChar.contains(i)) {
                inDegree[i] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // Populate initial start of queue
        List<Integer> currList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                currList.add(i);
            }
        }
        Collections.sort(currList);
        q.addAll(currList);
        order.addAll(currList);
        List<Integer> nextList = new ArrayList<>();
        Queue<Integer> nextQueue = new LinkedList<>();
        while (!q.isEmpty()) {
            int currChar = q.poll();
            for (int neighbour: directedGraph[currChar]) { // Consider all neighbours
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    nextList.add(neighbour);
                }
            }
            if (q.isEmpty()) { // Reached all letters in the next topo level
                //System.out.println("A");
                Collections.sort(nextList);
                q.addAll(nextList);
                order.addAll(nextList);
                q = nextQueue;
                nextList = new ArrayList<>();
                nextQueue = new LinkedList<>();
            }
        }
        String finalResult = "";
        // For debugging
        System.out.println("allUniqueChar");
        for (Integer i : allUniqueChar) {
            System.out.println(i);
        }
        System.out.println("order");
        for (Integer i : order) {
            System.out.println(i);
        }

        for (Integer i: allUniqueChar) {
            if (!order.contains(i)) {
                return "";
            }
        }
        for (int val: order) {
            Character c = (char) val;
            String s = c.toString();
            finalResult = finalResult + s;
        }
        return finalResult;
    }*/
    /*public String alienOrder(String[] words) {
        if(words == null || words.length == 0){
          return "";
        }
        HashMap<Character, HashSet<Character>> directedGraph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        // Initialisation of directedGraph and inDegree with necessary key-value pair
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!directedGraph.containsKey(words[i].charAt(j))) {
                    directedGraph.put(words[i].charAt(j), new HashSet<>());
                }
                inDegree.put(words[i].charAt(j), 0);
            }
        }
        // Initialise the ordering with the words given
        // Words given are arranged in lexicographical order
        for (int i = 0; i < words.length - 1; i++) {
            int nextWord = i + 1;
            int currIndex = 0;
            while (currIndex < words[i].length() && currIndex < words[nextWord].length()) {
                if (words[i].charAt(currIndex) != words[nextWord].charAt(currIndex)) {
                    directedGraph.get(words[i].charAt(currIndex)).add(words[nextWord].charAt(currIndex));
                    break;
                }
                currIndex++;
            }
        }
        // Populate the in-degree HashMap
        for (char key : directedGraph.keySet()) {
            for (char neighbour : directedGraph.get(key)) {
                inDegree.put(neighbour, inDegree.get(neighbour) + 1);
            }
        }
        // By default PriorityQueue is a minHeap
        PriorityQueue<Character> queue = new PriorityQueue<>();
        // Start by add some chars where indegree = 0;
        for (char key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.add(key);
            }
        }
        StringBuilder sbr = new StringBuilder();
        while (!queue.isEmpty()) {
            char currentChar = queue.poll();
            sbr.append(currentChar);
            for (char neighbour : directedGraph.get(currentChar)) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if (inDegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if (sbr.length() != directedGraph.keySet().size()) {
            return "";
        }
        return sbr.toString();
    }*/
    /*public String alienOrder(String[] words) {
        Set[] adj = new Set[26];
        Boolean[] visited = new Boolean[26];
        Stack<Character> st = new Stack<Character>();
        StringBuilder strb = new StringBuilder();

        for(int i=0; i<words.length; i++) {
        	for(int j=0; j<words[i].length(); j++) {
        		adj[words[i].charAt(j) - 'a'] = new HashSet<>();
        	}
        }

        for(int i=0; i<words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int m = word1.length();
            int n = word2.length();

            int minLength = Math.min(m, n);

            if (m > n && word1.substring(0, minLength).equals(word2)) {
                return "";
            }

            for(int j=0; j<minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj[word2.charAt(j) - 'a'].add(word1.charAt(j));
                    break;
                }
            }
        }

        for(int i=0; i<26; i++) {
        	char curr = (char) (i + 'a');

            if(adj[i] != null && dfs(visited, curr, adj, st)) {
                return "";
            }
        }

        while(!st.isEmpty()) {
            strb.append(st.pop());
        }

        return strb.reverse().toString();
    }

    private boolean dfs(Boolean[] visited, Character ch, Set[] adj, Stack<Character> st) {
        if (visited[ch - 'a'] != null) return visited[ch - 'a'];
        visited[ch - 'a'] = true;

        for(Character nei : (Set<Character>) adj[ch - 'a']) {
            if (dfs(visited, nei, adj, st)) {
                return true;
            }
        }

        visited[ch - 'a'] = false;
        st.push(ch);
        return false;
    }*/
    public String alienOrder(String[] words) {
        // Graph depicted as an adjacency list
        Set<Integer>[] directedGraph = new HashSet[26];
        StringBuilder sbr = new StringBuilder();
        Boolean[] visited = new Boolean[26];
        Stack<Character> order = new Stack<>();
        // Initialisation of directedGraph
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                directedGraph[words[i].charAt(j) - 'a'] = new HashSet<>();
            }
        }
        // Initialise all edges in words
        for (int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i + 1];
            int currWordLen = currWord.length();
            int nextWordLen = nextWord.length();
            int minLen = Math.min(currWordLen, nextWordLen);
            if (nextWordLen < currWordLen && currWord.substring(0, minLen).equals(nextWord)) {
                return "";
            }
            for (int k = 0; k < minLen; k++) {
                if (currWord.charAt(k) != nextWord.charAt(k)) {
                    //directedGraph[currWord.charAt(k) - 'a'].add(nextWord.charAt(k) - 'a');
                    directedGraph[nextWord.charAt(k) - 'a'].add(currWord.charAt(k) - 'a');
                    break; // Why add a break here
                }
            }
        }
        // Perform topological sort and checking for cycles.
        for (int i = 0; i < 26; i++) {
            if (directedGraph[i] != null && dfs(directedGraph, visited, i, order)) {
                return "";
            }
        }

        while(!order.isEmpty()) {
            sbr.append(order.pop());
        }

        return sbr.reverse().toString();
    }

    // Mainly checks for cycles in the graph, return true of present, false otherwise
    // currChar is represented as 0-25 not ASCII Value
    private boolean dfs(Set<Integer>[] graph, Boolean[] visited, int currChar, Stack<Character> order) {
        if (visited[currChar] != null) {
            return visited[currChar];
        }
        visited[currChar] = true;
        for (Integer neighbour : graph[currChar]) {
            if (dfs(graph, visited, neighbour, order)) {
                return true;
            }
        }
        visited[currChar] = false;
        int x = currChar + 'a';
        char c = (char) x;
        order.push(c);
        return false;
    }
}