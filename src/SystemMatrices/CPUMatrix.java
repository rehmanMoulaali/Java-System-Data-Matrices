package SystemMatrices;

import SystemMatrices.CPUData;
import org.hyperic.sigar.Sigar;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

public class CPUMatrix {
    private static OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

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
    public static Double getAvailableProcessors(){
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double cpuUsage = osBean.getAvailableProcessors();

//        Sigar sigar=new Sigar();
//        try {
//            System.out.println(sigar.getCpuPerc().getCombined() * 100);
//        }catch (Exception e){}
        return cpuUsage;

    }
   
}
