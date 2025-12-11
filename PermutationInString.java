class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        HashMap<Character, Integer> currWindow = new HashMap<>();
        HashMap<Character, Integer> s1CharCounts = new HashMap<>();
        HashMap<Character, Integer> availableChar = new HashMap<>(); // Characters in the current window
        int lenS1 = s1.length(); // Window size
        for (int i = 0; i < lenS1; i++) {
            if (!s1CharCounts.containsKey(s1.charAt(i))) {
                s1CharCounts.putIfAbsent(s1.charAt(i), 1);
            } else {
                s1CharCounts.replace(s1.charAt(i), s1CharCounts.get(s1.charAt(i)) + 1);
            }
            if (!currWindow.containsKey(s1.charAt(i))) {
                currWindow.putIfAbsent(s1.charAt(i), 1);
            } else {
                currWindow.replace(s1.charAt(i), currWindow.get(s1.charAt(i)) + 1);
            }
            if (!availableChar.containsKey(s1.charAt(i))) {
                availableChar.put(s1.charAt(i), 0);
            }
        }

        int startPointer = 0;
        int endPointer = lenS1 - 1;
        int lenS2 = s2.length();
        int missingChar = lenS1;
        // Initialise current window
        for (int i = 0; i < lenS1; i++) {
            if (s1CharCounts.containsKey(s2.charAt(i)) && currWindow.get(s2.charAt(i)) > 0) {
                currWindow.replace(s2.charAt(i), currWindow.get(s2.charAt(i)) - 1);
                missingChar--;
                availableChar.replace(s2.charAt(i), availableChar.get(s2.charAt(i)) + 1);
            } else if (s1CharCounts.containsKey(s2.charAt(i))) {
                availableChar.replace(s2.charAt(i), availableChar.get(s2.charAt(i)) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : currWindow.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        System.out.println("\n");

        while (endPointer < lenS2) {
            if (missingChar == 0) {
                return true;
            }
            if (endPointer == lenS2 - 1) {
                break;
            }
            startPointer++;
            endPointer++;
            if (s1CharCounts.containsKey(s2.charAt(startPointer - 1)) && availableChar.get(s2.charAt(startPointer - 1)) - 1 < s1CharCounts.get(s2.charAt(startPointer - 1))) {
                currWindow.replace(s2.charAt(startPointer - 1), currWindow.get(s2.charAt(startPointer - 1)) + 1);
                availableChar.replace(s2.charAt(startPointer - 1), availableChar.get(s2.charAt(startPointer - 1)) - 1);
                missingChar++;
            } else if (s1CharCounts.containsKey(s2.charAt(startPointer - 1))) {
                availableChar.replace(s2.charAt(startPointer - 1), availableChar.get(s2.charAt(startPointer - 1)) - 1);
            }
            if (s1CharCounts.containsKey(s2.charAt(endPointer)) && availableChar.get(s2.charAt(endPointer)) + 1 <= s1CharCounts.get(s2.charAt(endPointer))) {
                currWindow.replace(s2.charAt(endPointer), currWindow.get(s2.charAt(endPointer)) - 1);
                availableChar.replace(s2.charAt(endPointer), availableChar.get(s2.charAt(endPointer)) + 1);
                missingChar--;
            } else if (s1CharCounts.containsKey(s2.charAt(endPointer))) {
                availableChar.replace(s2.charAt(endPointer), availableChar.get(s2.charAt(endPointer)) + 1);
            }
            for (Map.Entry<Character, Integer> entry : currWindow.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println("Key: " + key + ", Value: " + value);
            }
            System.out.println("\n");
        }
        return false;
    }
}
