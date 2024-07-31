class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> dq = new LinkedList<>();
        Queue<Integer> rq = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'D')
                dq.add(i);
            else
                rq.add(i);
        }
        while (!rq.isEmpty() && !dq.isEmpty()){
            int rIndex = rq.poll();
            int dIndex = dq.poll();
            if (rIndex < dIndex)
                rq.add(rIndex + n);
            else
                dq.add(dIndex + n);
        }
        if (rq.isEmpty())
            return "Dire";
        return "Radiant";
    }
}