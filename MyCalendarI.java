class MyCalendar {

    private List<int[]> Calender;

    public MyCalendar() {
        this.Calender = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] interval : this.Calender) {
            if (interval[0] > end) {
                break;
            }
            if (interval[1] > start && end > interval[0]) {
                return false;
            }
        }
        int[] interval = new int[] {start, end};
        this.Calender.add(interval);
        this.Calender.sort((a, b) -> Integer.compare(a[0], b[0]));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
