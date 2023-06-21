package org.example;

public class Pair {
    private String lCase;
    private String uCase;

    public Pair(String lCase, String uCase) {
        this.lCase = lCase;
        this.uCase = uCase;
    }

    public String getlCase() {
        return lCase;
    }

    public void setlCase(String lCase) {
        this.lCase = lCase;
    }

    public String getuCase() {
        return uCase;
    }

    public void setuCase(String uCase) {
        this.uCase = uCase;
    }
}
