package com.zjxu.hwl.http;//黄万霖

import android.util.Log;

import java.io.Serializable;

public class HttpResult<T>  implements Serializable {
    private int status;
    private String msg;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String result = "HttpResult{" +
                "data=" + data +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                '}';
        Log.i("zhiwei.zhao", "HttpResult:" + result);
        return result;
    }
}
