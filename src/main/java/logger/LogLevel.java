public enum LogLevel {

            ERROR(10),
            WARN(6),
            INFO(4),
            DEBUG(2),
            TRACE(1);

            private int level;

            LogLevel(int level) {
                this.level = level;
            }

            public int getLevel() {
                return level;
            }
}
