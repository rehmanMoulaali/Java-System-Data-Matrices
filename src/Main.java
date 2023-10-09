import SystemMatrices.CPUMatrix;
import SystemMatrices.DiskUsageMatrix;
import SystemMatrices.JVMMemoryMatrix;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("===========DiskMatrix================");

        System.out.printf("Total space: %.2f GB%n", DiskUsageMatrix.getTotalSpace());
        System.out.printf("Free space: %.2f GB%n", DiskUsageMatrix.getFreeSpace());
        System.out.printf("Usable space: %.2f GB%n", DiskUsageMatrix.getUsableSpace());

        System.out.println("============JVM Memory matrix================");

        System.out.printf("Initial memory: %.2f GB%n", JVMMemoryMatrix.getInitialMemory());
        System.out.printf("Used heap memory: %.2f GB%n",JVMMemoryMatrix.getUsedMemory());
        System.out.printf("Max heap memory: %.2f GB%n", JVMMemoryMatrix.getMaxMemory());
        System.out.printf("Committed memory: %.2f GB%n", JVMMemoryMatrix.getCommittedMemory());

        System.out.println("==========CPU Matrix==========================");
        CPUMatrix.getAllThreadData().forEach(System.out::println);
        try {
            System.out.println("Percentage of CPU used by process "+ CPUMatrix.getProcessCpuLoad()+"%");
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(CPUMatrix.getAvailableProcessors());






    }
}