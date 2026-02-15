package meetingroom;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

public class MeetingRoom {
    private final Integer meetingRoomId;
    private final Calendar calendar;

    public MeetingRoom(Integer meetingRoomId){
        this.meetingRoomId = meetingRoomId;
        calendar = new Calendar();
    }
    public boolean isAvailable(Timestamp start, Timestamp end){
        List<Meeting> meetingList = calendar.getScheduledIntervals();
        meetingList.sort(Comparator.comparing(Meeting::getStartTime));
        int i = 0, n = meetingList.size();
        while(i < n){
            if(meetingList.get(i).getEndTime().compareTo(start) < 0){
                if(i+1 == n || (i+1 < n && meetingList.get(i+1).getStartTime().compareTo(end) > 0)){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
    public void scheduleMeeting(Meeting meeting){
        calendar.addMeeting(meeting);
    }
    public void removeMeeting(Integer meetingId){
        calendar.removeMeeting(meetingId);
    }
    public Integer getMeetingRoomId() {
        return meetingRoomId;
    }
}
