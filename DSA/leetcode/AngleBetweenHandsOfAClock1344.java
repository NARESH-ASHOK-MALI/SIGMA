// Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

// Answers within 10-5 of the actual value will be accepted as correct.
public class AngleBetweenHandsOfAClock1344 {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12) * 30 + (minutes / 60.0) * 30;
        double minuteAngle = minutes * 6;
        double angle = Math.abs(hourAngle - minuteAngle);
        return Math.min(angle, 360 - angle);
    }
}