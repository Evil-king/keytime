package com.yepu.p_do;

import java.io.Serializable;

public class HomeCount implements Serializable{
    private  int personCount;
    private int msgCount;

    public HomeCount(int personCount,int msgCount){
         this.personCount=personCount;
         this.msgCount=msgCount;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }
}
