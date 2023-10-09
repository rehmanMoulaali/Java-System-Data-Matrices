package SystemMatrices;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class JVMMemoryMatrix {
    private final static MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    public static Double getInitialMemory(){ //initial memory taken by JVM from OS
        return (double)memoryMXBean.getHeapMemoryUsage().getInit() /1073741824;
    }
    public static Double getUsedMemory(){ //The heap memory used by program
        return (double)memoryMXBean.getHeapMemoryUsage().getUsed() /1073741824;
    }
    public static Double getMaxMemory(){ //the max memory used by the process before hitting overflow error
        return (double)memoryMXBean.getHeapMemoryUsage().getMax() /1073741824;
    }
    public static Double getCommittedMemory(){ // the committed memory by os
        return (double)memoryMXBean.getHeapMemoryUsage().getCommitted() /1073741824;
    }

}
