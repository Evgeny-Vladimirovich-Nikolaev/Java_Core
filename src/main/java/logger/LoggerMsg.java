public enum LoggerMsg {

    IO_ERROR("Ошибка ввод/вывода");

    private String msg;
    LoggerMsg(String msg) {
        this.msg = msg;
    }
    String getMsg() {
        return msg;
    }
}
