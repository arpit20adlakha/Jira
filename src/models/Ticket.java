package models;

import Factory.TicketFactory;
import Constants.Constants;
import exception.StatusNotFoundException;
import exception.SummaryInvalidException;
import exception.TicketIdNotValidException;

import java.util.*;

public class Ticket {
    Integer id;
    String summary;
    String description;
    Constants.Status status;
    Constants.Type ticketType;
    Date startDate;
    Date endDate;
    Integer assigneeId;
    List<Ticket> subTasks;


    public Integer getTicketId() {
        return this.id;
    }

    public Integer getAssigneeId() {
        return this.assigneeId;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDescription() {
        return this.description;
    }

    public Constants.Type getTicketType() {
        return this.ticketType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setAssigneeId(Integer assigneeId) throws TicketIdNotValidException{
        if (assigneeId == null) {
            throw new TicketIdNotValidException("ticket id is not valid");
        }
        this.assigneeId = assigneeId;
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) throws StatusNotFoundException {
        if(status == null) {
            throw new StatusNotFoundException("status  is not valid for a Ticket");
        }
        this.status = status;
    }

    public void setSummary(String summary) throws SummaryInvalidException{
        if (summary == null || summary == "") {
            throw new SummaryInvalidException("Summary should not be empty");
        }
        this.summary = summary;
    }

    public void setDescription(String description) throws SummaryInvalidException{
        if(description == null|| description == "") {
            throw new SummaryInvalidException("Descript can't be empty");
        }
        this.description = description;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTicketType(Constants.Type type) {
        this.ticketType = type;
    }


}
