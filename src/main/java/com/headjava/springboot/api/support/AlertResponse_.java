package com.headjava.springboot.api.support;

import com.headjava.springboot.dao.Alert;

import java.util.List;

//Specific AlertResponse for the get request
public class AlertResponse_ {
    private String service_id;
    private String service_name;
    private List<Alert> alerts;
    private boolean success;
    private String error;

    public AlertResponse_(String service_id, String service_name, List<Alert> alerts, boolean success, String error) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.alerts = alerts;
        this.success = success;
        this.error = error;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
