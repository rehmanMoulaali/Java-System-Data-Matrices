package SystemMatrices;

public class CPUData {
    private String threadName;
    private String threadState;
    private String threadCpuTime;

    public CPUData(String threadName, String threadState, String threadCpuTime) {
        this.threadName = threadName;
        this.threadState = threadState;
        this.threadCpuTime = threadCpuTime;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }

    public String getThreadCpuTime() {
        return threadCpuTime;
    }

    public void setThreadCpuTime(String threadCpuTime) {
        this.threadCpuTime = threadCpuTime;
    }

    @Override
    public String toString() {
        return "SystemMatrices.CPUData{" +
                "threadName='" + threadName + '\'' +
                ", threadState='" + threadState + '\'' +
                ", threadCpuTime in ns='" + threadCpuTime + '\'' +
                '}';
    }
}
