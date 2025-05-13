package meetingroom;

import java.sql.Time;
import java.sql.Timestamp;

public class MeetingRoom {
    private final Integer meetingRoomId;
    private final Calendar calendar;

    public MeetingRoom(Integer meetingRoomId){
        this.meetingRoomId = meetingRoomId;
        calendar = new Calendar();
    }
    public boolean isAvailable(Timestamp start, Timestamp end){
        for(Meeting meeting : calendar.getScheduledIntervals()){
            if(meeting.getStartTime().after(start) && meeting.getEndTime().after(start)){
                return false;
            }else if(meeting.getStartTime().before(end) && meeting.getEndTime().before(end)) {
                return false;
            }
        }
        return true;
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
