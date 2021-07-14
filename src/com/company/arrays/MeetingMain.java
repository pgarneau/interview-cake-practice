package com.company.arrays;

import java.util.*;

public class MeetingMain {

    public static void main() {
        List<Meeting> meetings = new ArrayList<>(Arrays.asList(
                new Meeting(0, 1),
                new Meeting(3, 5),
                new Meeting(4, 8),
                new Meeting(10, 12),
                new Meeting(9, 10)));

        List<Meeting> mergedMeetings = mergeRanges(meetings);
        mergedMeetings.forEach(meeting -> {
            System.out.println(meeting.getStartTime() + " " + meeting.getEndTime());
        });
    }

    private static List<Meeting> mergeRanges(List<Meeting> meetings) {
        meetings.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getStartTime() - o2.getStartTime();
            }
        });

        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(meetings.get(0));
        for (Meeting meeting : meetings) {
            Meeting targetMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            if (meeting.getStartTime() <= targetMeeting.getEndTime()) {
                targetMeeting.setEndTime(Math.max(meeting.getEndTime(), targetMeeting.getEndTime()));
            } else {
                mergedMeetings.add(meeting);
            }
        }

        return mergedMeetings;
    }
}
