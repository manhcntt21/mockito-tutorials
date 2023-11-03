package com.example.doanswermethod;

/**
 * @author manhdt14
 * created in 11/4/2023 3:40 AM
 */
public interface Callback {
    void onSuccess();
    void onFailure(String reason);
}
