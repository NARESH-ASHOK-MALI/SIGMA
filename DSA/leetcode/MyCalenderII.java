// You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.

// A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).

// The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.

// Implement the MyCalendarTwo class:

// MyCalendarTwo() Initializes the calendar object.
// boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
import java.util.ArrayList;
import java.util.List;

public class MyCalenderII {
    private final List<int[]> booked;
    private final List<int[]> overlaps;

    public MyCalenderII() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();

    }
    public boolean book(int startTime, int endTime) {
        for (int[] overlap : overlaps) {
            if (Math.max(overlap[0], startTime) < Math.min(overlap[1], endTime)) {
                return false;
            }
        }

        for (int[] event : booked) {
            int start = Math.max(event[0], startTime);
            int end = Math.min(event[1], endTime);
            if (start < end) {
                overlaps.add(new int[] {start, end});
            }
        }

        booked.add(new int[] {startTime, endTime});
        return true;
    }
}
