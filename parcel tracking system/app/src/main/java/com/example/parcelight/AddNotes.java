package com.example.parcelight;

public class AddNotes {

    private String Tracking;
    private String Status;
    private String Notes;

    public AddNotes() {

    }

    public AddNotes(String tracking,String status, String notes) {
        Tracking = tracking;
        Status = status;
        Notes = notes;

    }

    public String getTracking() {
        return Tracking;
    }

    public void setTracking(String tracking) {
        Tracking = tracking;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }


}
