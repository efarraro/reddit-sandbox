package com.example.efarraro.readit.data;

public interface OnTaskCompleteListener<T> {
    void taskCompleted(T result);
}
