package demo.thirdInterfacePay.base.entry;

public class JsonResult {
    private Boolean success;
    private String msg;
    private Object obj;
    private String code;

    public Boolean getSuccess() {
        return success;
    }

    public JsonResult setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JsonResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public JsonResult setObj(Object obj) {
        this.obj = obj;
        return this;
    }

    public String getCode() {
        return code;
    }

    public JsonResult setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                ", code='" + code + '\'' +
                '}';
    }
}
