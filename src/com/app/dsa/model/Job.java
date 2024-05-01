package com.app.dsa.model;

public class Job {
    public int id, profit, deadline;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}