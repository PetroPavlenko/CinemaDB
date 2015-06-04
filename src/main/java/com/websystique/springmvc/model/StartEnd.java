package com.websystique.springmvc.model;

/**
 * Created by Petro on 27.05.2015.
 */
public class StartEnd {
    public String startTime;
    public String endTime;
    public int cinema_id;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    @Override
    public String toString() {
        return "StartEnd{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cinema_id=" + cinema_id +
                '}';
    }
}
