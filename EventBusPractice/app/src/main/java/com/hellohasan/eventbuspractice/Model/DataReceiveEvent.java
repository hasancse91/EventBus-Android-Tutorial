package com.hellohasan.eventbuspractice.Model;

public class DataReceiveEvent {
    private String eventTag;
    private String responseMessage;

    public DataReceiveEvent(String eventTag, String responseMessage) {
        this.eventTag = eventTag;
        this.responseMessage = responseMessage;
    }

    public boolean isTagMatchWith(String tag){
        return eventTag.equals(tag);
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
