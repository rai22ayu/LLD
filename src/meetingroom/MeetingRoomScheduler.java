package meetingroom;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomScheduler {
    private final List<MeetingRoom> meetingRooms = new ArrayList<>();

    public MeetingRoomScheduler() {
        for(int i = 0; i < 10 ; i++){
            MeetingRoom meetingRoom = new MeetingRoom(i);
            meetingRooms.add(meetingRoom);
        }
    }
    public MeetingRoom bookMeeting(Meeting meeting){
        for (MeetingRoom room : meetingRooms) {
            if (room.isAvailable(meeting.getStartTime(), meeting.getEndTime())) {
                room.scheduleMeeting(meeting);
                return room;
            }
        }
        return null; // No available room found
    }

    public void cancelMeeting(Integer meetingId){
        for (MeetingRoom room : meetingRooms) {
            room.removeMeeting(meetingId);
        }
    }
}
