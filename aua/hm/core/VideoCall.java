package am.aua.hm.core;

import am.aua.hm.exeptions.MalformedStringParameterException;

public class VideoCall extends WorkEvent{
    private final String email;

    public VideoCall(String title, String email) throws MalformedStringParameterException {
        super(title);
        if (!email.contains("@")) {
            throw new MalformedStringParameterException("Invalid email address.");
        }
        this.email = email;
    }


    @Override
    public String getFullDetails() {
        return "Title: " + getTitle() + ", Email: " + email;
    }

    @Override
    public String toSaveFileString() {
        return "VIDEOCALL" + DELIMITER + getTitle() + DELIMITER + email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        VideoCall videoCall = (VideoCall) other;
        return getTitle().equals(videoCall.getTitle()) && email.equals(videoCall.email);
    }

}
