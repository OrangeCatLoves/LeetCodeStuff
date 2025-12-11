class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int numberOfCars = position.length;
        for (int i = 0; i < numberOfCars; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        double timeTakenToReachTarget = ((double) target - (double) position[numberOfCars - 1]) / (double) map.get(position[numberOfCars - 1]);
        System.out.println(timeTakenToReachTarget);
        stack.push(timeTakenToReachTarget);
        for (int i = numberOfCars - 2; i >= 0; i--) {
            timeTakenToReachTarget = ((double) target - (double) position[i]) / (double) map.get(position[i]);
            System.out.println(timeTakenToReachTarget);
            if (timeTakenToReachTarget > stack.peek()) {
                stack.push(timeTakenToReachTarget);
            }
        }
        return stack.size();
    }
}
