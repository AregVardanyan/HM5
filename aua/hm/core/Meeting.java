package am.aua.hm.core;

import am.aua.hm.exeptions.MalformedStringParameterException;

public class Meeting extends WorkEvent{
    private final double latitude;
    private final double longitude;

    public Meeting(String title, double latitude, double longitude) throws MalformedStringParameterException {
        super(title);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

    @Override
    public String getFullDetails() {
        return "Title: " + getTitle() + ", Location: (" + latitude + ", " + longitude + ")";
    }

    @Override
    public String toSaveFileString() {
        return "MEETING%%" + getTitle() + DELIMITER + latitude + DELIMITER + longitude;
    }

    @Override
    public boolean equals(Object other){
        if (other == null || getClass() != other.getClass()) return false;
        Meeting meeting = (Meeting) other;
        return getTitle().equals(meeting.getTitle()) && latitude == meeting.latitude && longitude == meeting.longitude;
    }
}
