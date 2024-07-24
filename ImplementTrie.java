class Trie {

    public Pair[] start;

    public class Pair {
        char character;
        boolean finalCharacter;
        Pair[] nextLevel;

        Pair(char character) {
            this.character = character;
            this.finalCharacter = false;
            this.nextLevel = new Pair[26];
        }

        Pair(char character, boolean finalCharacter) {
            this.character = character;
            this.finalCharacter = finalCharacter;
            this.nextLevel = new Pair[26];
        }
    }

    public Trie() {
        this.start = new Pair[26];
    }

    public void insert(String word) {
        Pair[] currentLevel = this.start;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentLevel[index] == null) {
                currentLevel[index] = new Pair(word.charAt(i));
            }
            if (i == word.length() - 1) {
                currentLevel[index].finalCharacter = true;
            }
            currentLevel = currentLevel[index].nextLevel;
        }
    }

    public boolean search(String word) {
        Pair[] currentLevel = this.start;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentLevel[index] == null) {
                return false;
            }
            if (i == word.length() - 1 && currentLevel[index].finalCharacter) {
                return true;
            }
            currentLevel = currentLevel[index].nextLevel;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Pair[] currentLevel = this.start;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (currentLevel[index] == null) {
                return false;
            }
            currentLevel = currentLevel[index].nextLevel;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */