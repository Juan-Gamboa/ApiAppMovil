package com.example.myapplication.services.models;

public class InfoApiDate {

    private String date;
    private int timezone_type;
    private String timezone;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimezone_type() {
        return timezone_type;
    }

    public void setTimezone_type(int timezone_type) {
        this.timezone_type = timezone_type;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
