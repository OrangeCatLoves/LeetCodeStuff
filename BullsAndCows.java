/*import java.util.HashMap;

class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
        }
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!hashmap.containsKey(secret.charAt(i))) {
                hashmap.put(secret.charAt(i), 1);
            } else {
                hashmap.put(secret.charAt(i), hashmap.get(secret.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (guess.charAt(i) != secret.charAt(i) && hashmap.containsKey(guess.charAt(i))) {
                cows++;
                hashmap.put(guess.charAt(i), hashmap.get(guess.charAt(i)) - 1);
                if (hashmap.get(guess.charAt(i)) == 0) {
                    hashmap.remove(guess.charAt(i));
                }
            } else if (guess.charAt(i) == secret.charAt(i) && hashmap.containsKey(guess.charAt(i))) {
                hashmap.put(guess.charAt(i), hashmap.get(guess.charAt(i)) - 1);
                if (hashmap.get(guess.charAt(i)) == 0) {
                    hashmap.remove(guess.charAt(i));
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}*/

public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
