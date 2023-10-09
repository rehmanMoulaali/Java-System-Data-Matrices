package SystemMatrices;

import java.io.File;

public class DiskUsageMatrix {
    private static String disk="C:";

    static File cDrive=cDrive=new File(disk);

    public static Double getTotalSpace(){
        return (double)cDrive.getTotalSpace() /1073741824;
    }

    public static Double getFreeSpace(){
        return (double)cDrive.getFreeSpace() /1073741824;
    }

    public static Double getUsableSpace(){
        return (double)cDrive.getUsableSpace()/1073741824;
    }

    public static String getDisk() {
        return disk;
    }

    public static void setDisk(String disk) {
        DiskUsageMatrix.disk = disk;
    }



}
