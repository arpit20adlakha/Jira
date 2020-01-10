import Constants.Constants;
import Factory.SprintFactory;
import Factory.TicketFactory;
import models.Sprint;
import models.Ticket;
import services.SprintService;
import services.TicketService;
import utils.DateFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            Date startDate = DateFormatter.getDateObject("20/06/2019");
            Date endDate = DateFormatter.getDateObject("24/06/2019");
            Ticket ticket = new Ticket();
            ticket.setStatus(Constants.Status.BACKLOG);
            ticket.setAssigneeId(3);
            ticket.setDescription("the task is related to production deployment");
            ticket.setId(1);
            ticket.setSummary("Prod Task");
            ticket.setTicketType(Constants.Type.TASK);
            ticket.setStartDate(startDate);
            ticket.setEndDate(endDate);
            TicketFactory.ticketMap.put(ticket.getTicketId(), ticket);

            Date startDate1 = DateFormatter.getDateObject("25/06/2019");
            Date endDate1 = DateFormatter.getDateObject("28/06/2019");
            Ticket ticket1 = new Ticket();
            ticket1.setStatus(Constants.Status.INPROGRESS);
            ticket1.setAssigneeId(6);
            ticket1.setDescription("the task is related to staging deployment");
            ticket1.setId(4);
            ticket1.setSummary("Staging Task");
            ticket1.setStartDate(startDate1);
            ticket1.setEndDate(endDate1);
            ticket1.setTicketType(Constants.Type.TASK);

            TicketFactory.ticketMap.put(ticket1.getTicketId(), ticket1);

            Date sprintstartDate = DateFormatter.getDateObject("20/06/2019");
            Date sprintendDate = DateFormatter.getDateObject("28/06/2019");
            Sprint currentSprint = new Sprint();
            currentSprint.setId(8);
            List<Ticket> ticketList = currentSprint.getTasks();
            if (ticketList.isEmpty()) {
                ticketList = new ArrayList<>();
            }

            currentSprint.addList(ticketList);
            currentSprint.setStartDate(sprintstartDate);
            currentSprint.setEndDate(sprintendDate);
            SprintFactory.sprintFactory.put(currentSprint.getId(), currentSprint);

//            Scanner s = new Scanner(System.in);

        }
        catch(Exception e) {
            System.out.println("There is an exception " + e.getMessage());
        }


        try {Thread.sleep(10000);}
        catch(InterruptedException e) {
            System.out.println("Failed in Sleeping");
        }

        delayedTasks();

        tasksForUser();

        changeTicketStatus();

        try {
            SprintService.addTaskToSprint(8, 4);
        }
        catch(Exception e) {

        }

        getSprintDetails(8);

        try {
            SprintService.removeTaskFromSprint(8, 4);
        }
        catch(Exception e) {

        }
        getSprintDetails(8);



    }

    public static void delayedTasks () {
        List<Ticket> tickets = TicketService.getDelayedTicketsByType(Constants.Type.TASK);
        for (Ticket ticket : tickets) {
            System.out.println("The details are : User id :" + ticket.getAssigneeId() + "Status : " + ticket.getStatus() + "  Description :" + ticket.getDescription() +
                    "Summary : " + ticket.getSummary() + "StartDate :" + ticket.getStartDate() + "EndDate : " + ticket.getEndDate());
        }

    }
    public static void tasksForUser() {
        List<Ticket> tickets1 = TicketService.getTasksForUser(3);
        for (Ticket ticket : tickets1) {
            System.out.println("The details are : User id :" + ticket.getAssigneeId() + "Status : " + ticket.getStatus() + " Description :" + ticket.getDescription() +
                    "Summary : " + ticket.getSummary() + "StartDate :" + ticket.getStartDate() + "EndDate : " + ticket.getEndDate());
        }
    }
    public static void changeTicketStatus() {
        try {
            TicketService.changeTicketStatus(1, Constants.Status.valueOf(4));

        } catch (Exception e) {
            System.out.println();
        }
    }

    public static void getTasksForSprint(Integer id) {

        Sprint sprint = SprintService.getSprintById(id);

        List<Ticket> tickets = sprint.getTasks();
        System.out.println("Sprint Id: " + sprint.getId());
        System.out.println("Start Date : " + sprint.getStartDate());
        System.out.println("End Date : "+ sprint.getEndDate());
        for (Ticket ticket : tickets) {
            System.out.println("The details of the tasks are : User id :" + ticket.getAssigneeId() + "Status : " + ticket.getStatus() + "Description :" + ticket.getDescription() +
                    "Summary : " + ticket.getSummary() + "StartDate :" + ticket.getStartDate() + "EndDate : " + ticket.getEndDate());
        }

    }

    public static void getSprintDetails(Integer id) {
        Sprint sprint = SprintService.getSprintById(id);

        List<Ticket> tickets = sprint.getTasks();
        System.out.println("Sprint Id: " + sprint.getId());
        System.out.println("Start Date : " + sprint.getStartDate());
        System.out.println("End Date : "+ sprint.getEndDate());
        for (Ticket ticket : tickets) {
            System.out.println("The details of the tasks are : User id :" + ticket.getAssigneeId() + "Status : " + ticket.getStatus() + "Description :" + ticket.getDescription() +
                    "Summary : " + ticket.getSummary() + "StartDate :" + ticket.getStartDate() + "EndDate : " + ticket.getEndDate());
        }
    }

}
