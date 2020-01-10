package models;


import java.util.Date;
import java.util.List;

public class Sprint {
    Integer id;
    List<Ticket> tasks;
    Date startDate;
    Date endDate;

    public Integer getId() {
        return this.id;
    }
    public List<Ticket> getTasks() {
        return this.tasks;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addList(List<Ticket> tickets) {
        this.tasks = tickets;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



}
