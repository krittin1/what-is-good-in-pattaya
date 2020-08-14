package com.pattaya.group1.web_service.model;

import java.util.List;

public class LogResponse {
    private int numberOfLogs;
    private int pageNumber;
    private int logsPerPage;
    private List<Log> logs;

    public LogResponse(int numberOfLogs, int pageNumber, int logsPerPage) {
        this(numberOfLogs,pageNumber,logsPerPage,null);
    }

    public LogResponse(int numberOfLogs, int pageNumber, int logsPerPage, List<Log> logs) {
        this.numberOfLogs = numberOfLogs;
        this.pageNumber = pageNumber;
        this.logsPerPage = logsPerPage;
        this.logs = logs;
    }

    public int getNumberOfLogs() {
        return numberOfLogs;
    }

    public void setNumberOfLogs(int numberOfLogs) {
        this.numberOfLogs = numberOfLogs;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getLogsPerPage() {
        return logsPerPage;
    }

    public void setLogsPerPage(int logsPerPage) {
        this.logsPerPage = logsPerPage;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
