public enum LoggerMsg {

    IO_ERROR("Ошибка ввод/вывода"),
    TRACE_DESCRIPTION("Трассировщик создаёт пошаговые записи процесса"),
    DEBUG_DESCRIPTION("Отладчик регистрирует наиболее важные программные события"),
    INFO_DESCRIPTION("Поток фиксирует общую информацию о работе программы");

    private String msg;
    LoggerMsg(String msg) {
        this.msg = msg;
    }

    String getMsg() {
        return msg;
    }
}
