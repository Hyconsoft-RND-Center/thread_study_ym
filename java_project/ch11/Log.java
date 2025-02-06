package java_project.ch11;

public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    public static void println(String s) {
        getTSLog().println(s);
    }

    public static void close() {
        getTSLog().close();
    }

    private static TSLog getTSLog() {
        TSLog tslog = tsLogCollection.get();

        if(tslog == null) {
            tslog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tslog);
        }

        return tslog;
    }
}
