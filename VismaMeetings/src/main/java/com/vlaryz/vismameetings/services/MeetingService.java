package com.vlaryz.vismameetings.services;

import com.vlaryz.vismameetings.interfaces.IMeetingRepository;
import com.vlaryz.vismameetings.interfaces.IMeetingService;
import com.vlaryz.vismameetings.models.Meeting;
import com.vlaryz.vismameetings.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService implements IMeetingService {

    private IMeetingRepository meetingRepository;

    public MeetingService(IMeetingRepository repository) {
        meetingRepository = repository;
    }

    @Override
    public int createMeeting(Meeting meeting) {
        return meetingRepository.addMeeting(meeting);
    }

    @Override
    public boolean deleteMeeting(int id, int personId) {
        var meeting = meetingRepository.getMeetings().stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
        System.out.println(meeting.getId());

        if(meeting == null)
            return false;

        if(meeting.getResponsiblePerson().getId() != personId)
            return false;

        meetingRepository.deleteMeeting(meeting.getId());

        return true;
    }

    @Override
    public boolean addPersonToMeeting(int id, int personId, String name) {
        var meeting = meetingRepository.getMeetings().stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (meeting == null)
            return false;

        if(meeting.getPersons().stream()
                .anyMatch(p -> p.getId() == personId))
            return false;

        var meetingsDoIntersect = meetingRepository.getMeetings().stream()
                .anyMatch(m -> m.getResponsiblePerson().getId() == personId
                        && m.getStartDate().after(meeting.getEndDate())
                        && (meeting.getStartDate().after(m.getEndDate())));
        if(meetingsDoIntersect)
            return false;

        Person person = new Person(personId, name);
        meetingRepository.addPersonToMeeting(meeting.getId(), person);
        return true;
    }

    @Override
    public boolean removePersonFromMeeting(int id, int personId) {
        var meeting = meetingRepository.getMeetings().stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

        if (meeting == null)
            return false;

        if(meeting.getResponsiblePerson().getId() == personId)
            return false;

        meetingRepository.removePersonFromMeeting(meeting.getId(), personId);
        return true;
    }

    @Override
    public List<Meeting> listMeetings() {
        return meetingRepository.getMeetings();
    }

    @Override
    public List<Meeting> listMeetings(String filter, String value) {
        return null;
    }
}
