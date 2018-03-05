package cn.edu.nju.p.dto;

/**
 * Created by pc on 2018/3/5.
 */
public class BaseResult <T>{

    private int errorCode;
    private T data;

    public BaseResult(int errorCode, T data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    public BaseResult(){

    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
