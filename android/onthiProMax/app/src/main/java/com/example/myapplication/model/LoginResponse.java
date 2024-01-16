package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("RESULT")
    private boolean result;

    public LoginResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
