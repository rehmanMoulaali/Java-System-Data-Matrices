package SystemMatrices;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class JVMMemoryMatrix {
    private final static MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    public static Double getInitialMemory(){
        return (double)memoryMXBean.getHeapMemoryUsage().getInit() /1073741824;
    }
    public static Double getUsedMemory(){
        return (double)memoryMXBean.getHeapMemoryUsage().getUsed() /1073741824;
    }
    public static Double getMaxMemory(){
        return (double)memoryMXBean.getHeapMemoryUsage().getMax() /1073741824;
    }
    public static Double getCommittedMemory(){
        return (double)memoryMXBean.getHeapMemoryUsage().getCommitted() /1073741824;
    }

}
