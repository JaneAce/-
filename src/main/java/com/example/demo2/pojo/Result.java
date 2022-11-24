package com.example.demo2.pojo;

public class Result {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;

    public Result(){

    }
    public Result(Integer code,String message,Integer count,Object data){
        this.code = code;
        this.msg = message;
        this.count =count;
        this.data =data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public String toString(){
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", count='" + count + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
