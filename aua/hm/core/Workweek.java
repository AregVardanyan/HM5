package am.aua.hm.core;

import am.aua.hm.exeptions.MalformedStringParameterException;

public class Workweek {
    private final WorkEvent[][] schedule;

    public Workweek(){
        this.schedule = new WorkEvent[5][2];
    }

    public void removeFromSchedule(Days day, Times time) {
        schedule[day.ordinal()][time.ordinal()] = null;
    }

    public boolean isEmpty(Days day, Times time) {
        return schedule[day.ordinal()][time.ordinal()] == null;
    }

    public String getFullDetailsAt(Days day, Times time) {
        WorkEvent event = schedule[day.ordinal()][time.ordinal()];
        return event == null ? "Empty" : event.getFullDetails();
    }

    public String getTitleAt(Days day, Times time) {
        WorkEvent event = schedule[day.ordinal()][time.ordinal()];
        return event == null ? "Empty" : event.getTitle();
    }

    public static Workweek generateWorkweekFromStrings(String[] data) throws MalformedStringParameterException {
        Workweek workweek = new Workweek();
        for (String s : data) {
            String[] parts = s.split("%%");
            String type = parts[0];
            if (type.equals("VIDEOCALL")) {
                if (parts.length != 3) {
                    throw new MalformedStringParameterException("Invalid number of tokens for VideoCall.");
                }
                VideoCall vc = new VideoCall(parts[1], parts[2]);
            } else if (type.equals("MEETING")) {
                if (parts.length != 4) {
                    throw new MalformedStringParameterException("Invalid number of tokens for Meeting.");
                }
                Meeting meeting = new Meeting(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            }
        }
        return workweek;
    }
}
