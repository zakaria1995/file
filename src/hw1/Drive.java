/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;
import java.io.File;
/**
 *
 * @author Ran
 */
class Drive {
    public String name;
    public long totalSpace;
    public long usedSpace;
    
    public void ViewDrives(){
        File[] roots = File.listRoots();
        System.out.println("AllDirves\t\tTotalSpace");
        for (File root : roots) {
            System.out.println(root + "\t\t" + root.getTotalSpace() + " bytes");
        }
    }
    
    public long getSizeFolder(File dir) {
        long size = 0;
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                size += file.length();
            }
            else
                size += getSizeFolder(file);
        }
        return size;
    }
    
    public void ViewDirve(String Name){
        File file = new File(Name + ":\\");
        if(file.exists()){
            File[] files = file.listFiles();
            if(files != null){
                for (File file1 : files) {
                    System.out.println(file1.getName() + "\t" + getSizeFolder(file1));
                }
            }
        }
    }
}
