import java.util.PriorityQueue;
import java.util.Comparator;

class MedianFinder {

    PriorityQueue<Integer> smallPQ;
    PriorityQueue<Integer> largePQ;
    int currSmallSize;
    int currLargeSize;

    public MedianFinder() {
        this.smallPQ = new PriorityQueue<>(Comparator.reverseOrder());
        this.largePQ = new PriorityQueue<>();
        this.currSmallSize = 0;
        this.currLargeSize = 0;
    }

    public void addNum(int num) {
        this.smallPQ.add(num); // By default add to small PQ
        this.currSmallSize++;
        if (this.largePQ.peek() != null && this.smallPQ.peek() > this.largePQ.peek()) {
            System.out.println("A");
            int transferVal = this.smallPQ.poll();
            this.currSmallSize--;
            this.largePQ.add(transferVal);
            this.currLargeSize++;
        }

        if (this.currLargeSize > this.currSmallSize + 1) {
            System.out.println("B");
            int deqVal = this.largePQ.poll();
            this.currLargeSize--;
            this.smallPQ.add(deqVal);
            this.currSmallSize++;
        }

        if (this.currSmallSize > this.currLargeSize + 1) {
            System.out.println("C");
            int deqVal = this.smallPQ.poll();
            this.currSmallSize--;
            this.largePQ.add(deqVal);
            this.currLargeSize++;
        }
        //printPQContents();
        return;
    }

    public double findMedian() {
        if (this.currSmallSize == this.currLargeSize) {
            double mid = (double) (this.smallPQ.peek() + this.largePQ.peek()) / 2;
            return mid;
        } else if (this.currSmallSize == this.currLargeSize + 1 && this.currLargeSize != 0) {
            double mid = this.smallPQ.peek();
            return mid;
        } else if (this.currSmallSize + 1 == this.currLargeSize) {
            double mid = this.largePQ.peek();
            return mid;
        } else {
            return this.smallPQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */