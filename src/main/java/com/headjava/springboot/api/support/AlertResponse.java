package com.headjava.springboot.api.support;

public class AlertResponse {

    private String alert_id;

    private String error;

    public AlertResponse(String alert_id, String error) {
        this.alert_id = alert_id;
        this.error = error;
    }

    public String getAlert_id() {
        return alert_id;
    }

    public void setAlert_id(String alert_id) {
        this.alert_id = alert_id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
