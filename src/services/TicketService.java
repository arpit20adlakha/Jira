package services;

import Constants.Constants;
import Factory.TicketFactory;
import exception.StatusNotFoundException;
import exception.TicketIdNotValidException;
import exception.TicketNotFoundException;
import models.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TicketService {

    public static List<Ticket> getDelayedTicketsByType(Constants.Type ticketType) {
        List<Ticket> ticketList = new ArrayList<>();
        for (Map.Entry<Integer, Ticket> entry : TicketFactory.ticketMap.entrySet()) {
            Ticket ticket = entry.getValue();
            Date currentDate = new Date();
            if (currentDate.after(ticket.getEndDate()) && (ticket.getTicketType() == ticketType.TASK) && (ticket.getStatus() != Constants.Status.CLOSED)) {
                ticketList.add(ticket);
            }
        }
        return ticketList;
    }

    public static List<Ticket> getTasksForUser(Integer userId) {
        List<Ticket> ticketList = new ArrayList<>();
        for (Map.Entry<Integer, Ticket> entry : TicketFactory.ticketMap.entrySet()) {
            Ticket ticket = entry.getValue();
            if(ticket.getAssigneeId() == userId) {
                ticketList.add(ticket);
            }
        }
        return ticketList;
    }

    public static void changeTicketStatus(Integer ticketId, Constants.Status status) throws StatusNotFoundException , TicketNotFoundException{
        Ticket ticket = TicketFactory.ticketMap.get(ticketId);
        if (ticket == null) {
            throw new TicketNotFoundException("Please check the ticket id "+ ticketId);
        }
        ticket.setStatus(status);
    }

    public static Ticket getTicketById(Integer ticketId) {
        return TicketFactory.ticketMap.get(ticketId);
    }

}
