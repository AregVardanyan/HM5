package am.aua.hm.core;

import am.aua.hm.exeptions.MalformedStringParameterException;

public abstract class WorkEvent {
    private final String title;
    protected static final String DELIMITER = "%%";
    public WorkEvent(String title)  throws MalformedStringParameterException {
        if (title.contains(DELIMITER)) {
            throw new MalformedStringParameterException("Title contains delimiter sequence.");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public abstract String getFullDetails();
    public abstract String toSaveFileString();

    public abstract boolean equals(Object other);
}
