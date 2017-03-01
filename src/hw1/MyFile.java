/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Ran
 */
public class MyFile {
    public String name;
    public int size;
    
    
    public void CreatNewFile(String path) throws IOException {
        File file = new File(path);
        if(file.createNewFile()){
            System.out.println("The File Is Created ^_^");
        }
        else{
            System.out.println("The File Is Already Exists!!");
        }
    }
    
    public void DeleteFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
            System.out.println("The File Is Deleted");
        }
        else{
            System.out.println("The File Is Not Exists!!");
        }
    }
    public boolean SearchFile(String s){
        File file = new File(s);
        return file.exists();
    }
}
