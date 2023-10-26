package com.example.birdfarmprojectbe.dto;

public class ScheduleDTO {
    private String startDate;

    private String endDate;

    private Integer staffID;

    private String note;

    private Integer status;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String startDate, String endDate, Integer staffID, String note, Integer status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.staffID = staffID;
        this.note = note;
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
