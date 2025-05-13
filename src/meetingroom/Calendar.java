package meetingroom;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private final List<Meeting> scheduledIntervals;

    public Calendar(){
        scheduledIntervals = new ArrayList<>();
    }

    public List<Meeting> getScheduledIntervals() {
        return scheduledIntervals;
    }

    public void addMeeting(Meeting meeting) {
        scheduledIntervals.add(meeting);
    }

    public void removeMeeting(Integer meetingId) {
        scheduledIntervals.forEach(m -> {
            if(m.getMeetingId().equals(meetingId)){
                scheduledIntervals.remove(m);
            }
        });
    }
}
