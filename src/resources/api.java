package resources;

import Constants.Constants;
import models.Sprint;
import models.Ticket;
import services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class api {

    private TicketService ticketService;
    public List<Ticket> getDelayedTasksByType(Integer taskTypeId) {
        List<Ticket> tasks = new ArrayList<>();
        try {
            ticketService.getDelayedTicketsByType(Constants.Type.valueOf(taskTypeId));
        }
        catch(Exception e) {

        }
        return tasks;
    }


    public Sprint getSprintDetails(Integer id) {
        Sprint sprint = null;
        return sprint;
    }

    public List<Ticket> getTasksForUsers(Integer id) {
        List<Ticket> tasks = new ArrayList<>();
        return tasks;
    }
}
