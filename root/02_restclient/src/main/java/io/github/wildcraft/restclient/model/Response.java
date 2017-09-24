package io.github.wildcraft.restclient.model;

/**
 * Created by NAS on 9/24/2017
 */
public class Response {

    private String responseText;
    private int statuscode;

    public Response(String responseText, int statuscode) {
        this.responseText = responseText;
        this.statuscode = statuscode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }
}
