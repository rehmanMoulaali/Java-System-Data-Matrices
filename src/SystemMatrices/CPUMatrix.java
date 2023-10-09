package SystemMatrices;

import SystemMatrices.CPUData;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

public class CPUMatrix {
    public static List<CPUData> getAllThreadData(){ //get All the threads with CPU time taken by each
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        List<CPUData> cpuData=new ArrayList<>();
        for(Long threadID : threadMXBean.getAllThreadIds()) {
            ThreadInfo info = threadMXBean.getThreadInfo(threadID);
            cpuData.add(new CPUData(info.getThreadName(),info.getThreadState().toString(),threadMXBean.getThreadCpuTime(threadID)+""));
        }
        return cpuData;
    }
    public static double getProcessCpuLoad() throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = ObjectName.getInstance("java.lang:type=OperatingSystem");
        AttributeList list = mbs.getAttributes(name, new String[]{"ProcessCpuLoad"});

        if (list.isEmpty()) {
            return 0.0;
        }
        Attribute att = (Attribute) list.get(0);
        Double value = (Double) att.getValue();

        if (value < 0.0) {
            return getProcessCpuLoad();  // usually takes a couple of seconds before we get real values
        }
        return ((int) (value * 1000) / 10.0);        // returns a percentage value with 1 decimal point precision
    }
}
