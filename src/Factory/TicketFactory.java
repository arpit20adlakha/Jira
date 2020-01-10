package Factory;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketFactory {
    public static Map<Integer, Ticket> ticketMap = new HashMap<>();

    public static void createTicket(Ticket ticket) {
        ticketMap.put(ticket.getTicketId(), ticket);
    }

}
