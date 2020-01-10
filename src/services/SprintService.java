package services;

import Factory.SprintFactory;
import Factory.TicketFactory;
import exception.TicketNotFoundException;
import models.Sprint;
import models.Ticket;

public class SprintService {
    static TicketService ticketService;

    public static void addTaskToSprint(Integer sprintId, Integer ticketId) throws TicketNotFoundException {

        if (ticketService.getTicketById(ticketId) == null) {
            throw new TicketNotFoundException("Ticket Not Found");
        }
        else {
            Sprint sprint = SprintFactory.sprintFactory.get(sprintId);
            // throw Sprint not found Exception
            sprint.getTasks().add(ticketService.getTicketById(ticketId));
        }
    }

    public static void removeTaskFromSprint(Integer sprintId, Integer ticketId) throws TicketNotFoundException{
        if (ticketService.getTicketById(ticketId) == null) {
            throw new TicketNotFoundException("Ticket Not Found");
        }
        else {

            Sprint sprint = SprintFactory.sprintFactory.get(sprintId);
            // throw Sprint not found Exception
            sprint.getTasks().remove(ticketService.getTicketById(ticketId));
        }
    }

    public static Sprint getSprintById(Integer id) {
        return SprintFactory.sprintFactory.get(id);
    }

    // Can be implemented

//    public void addTasksToSprint() {
//
//    }

    // public void removeTasksFromSprint() {
    // }
}
