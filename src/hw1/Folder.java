/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Ran
 */
public class Folder {
    public String name;
    public long size;
    
    
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
    
    public void PrintContent(String nameFolder){
        File file = new File(nameFolder);
        if(file.exists()){
            File[] files = file.listFiles();
            if(files != null){
                for (File file1 : files) {
                    System.out.println(file1.getName() + "\t" + getSizeFolder(file1));
                }
            }
        }
    }
    
    public void CreatNewFolder(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
            System.out.println("The Folder Is Created ^_^");
        }
        else{
            System.out.println("The Folder Is Already Exists!!");
        }
    }
    
    public boolean deleteDirectory(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(files != null){
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
        }
        return(directory.delete());
    }
    public void DeleteFolder(String path){
        File file = new File(path);
        if(file.exists()){
            deleteDirectory(file);
            System.out.println("The Folder Is Deleted");
        }
        else{
            System.out.println("The Folder Is Not Exists!!");
        }      
    }
    
    public boolean SearchFolder(String path){
        File file = new File(path);
        if(file.exists()){
            File[] files = file.listFiles();
            if(files != null){
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        deleteDirectory(file1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void SortByName(String path) {
        File file = new File(path);
        if(file.exists()){
            String [] ss ;
            ss = file.list();
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(ss));
            Collections.sort(list);
            for (String list1 : list) {
                System.out.println(list1);
            }
        }
        else
            System.out.println("The Folder IsNot Exists!!");
    }
    
    public void SortBySize(String path) {
        File file = new File(path);
        Map<Long,String> map = new HashMap<>();
        if(file.exists()){
            File[] files = file.listFiles();
            if(files != null){
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        map.put(getSizeFolder(file1), file1.getName());
                    } else {
                        map.put(file1.length(), file1.getName());
                    }
                }
                Set<Long> keys = map.keySet();
                TreeSet<Long> sortedkeys = new TreeSet<>(keys);
                for(Long key : sortedkeys){
                    System.out.println(map.get(key));
                }
            }
        }
        else
            System.out.println("The Folder IsNot Exists!!");
    }
}