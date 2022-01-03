public enum Paths {

    LOG_BY_CALLABLE("./src/main/resources/executorLog.txt"),
    LOG_BY_RUNNABLE("./src/main/resources/Log.txt");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
