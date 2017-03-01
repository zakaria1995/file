/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Ran
 */
public class HW1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        while(true){
            System.out.println("Enter 1 To View Driver Disk In PC");
            System.out.println("Enter 2 To View Driver Disk Content");
            System.out.println("Enter 3 To View Folder Content");
            System.out.println("Enter 4 To Search On File Or Folder");
            System.out.println("Enter 5 To Sort File Or Folder");
            System.out.println("Enter 6 To Creat File Or Folder");
            System.out.println("Enter 7 To Remove File Or Folder");
            System.out.println("Enter 8 To Exit From Program");
            System.out.println("----------------------------------");
            Scanner in = new Scanner(System.in);
            int c;
            System.out.print("Enter Your Choice: ");
            c = in.nextInt();
            switch(c){
                case 1:{
                    Drive d = new Drive();
                    d.ViewDrives();
                    System.out.println("----------------------------------");
                    break;
                }
                case 2:{
                    System.out.print("Enter Drive Disk: ");
                    String Drivename;
                    Drivename = in.next();
                    Drive d = new Drive();
                    System.out.println("Name\t\t\t\tSize");
                    System.out.println("------------------------------------");
                    d.ViewDirve(Drivename);
                    System.out.println("----------------------------------");
                    break;
                }
                case 3:{
                    System.out.print("Enter The Path Of Folder: ");
                    String path;
                    path = in.next();
                    Folder fo = new Folder();
                    System.out.println("Name\t\t\t\tSize");
                    System.out.println("------------------------------------");
                    fo.PrintContent(path);
                    System.out.println("----------------------------------");
                    break;
                }
                case 4:{
                    System.out.println("Search On File Enter 1 | Search On Folder Enter 0: ");
                    int ch = in.nextInt();
                    if(ch == 1){
                        System.out.println("Enter The Path Of File: ");
                        String s = in.next();
                        MyFile f = new MyFile();
                        if(f.SearchFile(s))
                            System.out.println("The File Is Exists");
                        else
                            System.out.println("The File IsNot Exists");
                    }
                    else{
                        System.out.println("Enter The Path Of Folder: ");
                        String s = in.next();
                        Folder f = new Folder();
                        if(f.SearchFolder(s))
                            System.out.println("The Folder Is Exists");
                        else
                            System.out.println("The Folder IsNot Exists");
                    }
                    System.out.println("----------------------------------");
                    break;
                }
                case 5:{
                    System.out.print("To Sort By Name Enter 1 | To Sort By Size Enter 2: ");
                    int ch = in.nextInt();
                    if(ch == 1){
                        System.out.print("Enter The Path Of Folder: ");
                        String s = in.next();
                        Folder folder = new Folder();
                        folder.SortByName(s);
                    }
                    else{
                        System.out.print("Enter The Path Of Folder: ");
                        String s = in.next();
                        Folder folder = new Folder();
                        folder.SortBySize(s);
                    }
                    System.out.println("----------------------------------");
                    break;
                }
                case 6:{
                    System.out.print("Creat File Enter 1 | Creat Folder Enter 2: ");
                    int ch;
                    ch = in.nextInt();
                    if(ch == 1){
                        System.out.print("Enter The Path Of File: ");
                        String s;
                        s = in.next();
                        MyFile f1 = new MyFile();
                        f1.CreatNewFile(s);
                        System.out.println("----------------------------------");
                    }
                    else{
                        System.out.print("Enter The Path Of Folder: ");
                        String s;
                        s = in.next();
                        Folder fo = new Folder();
                        fo.CreatNewFolder(s);
                        System.out.println("----------------------------------");
                    }
                    System.out.println("----------------------------------");
                    break;
                }
                case 7:{
                    System.out.print("Remove File Enter 1 | Remove Folder Enter 2: ");
                    int ch;
                    ch = in.nextInt();
                    if(ch == 1){
                        System.out.print("Enter The Path Of File: ");
                        String s;
                        s = in.next();
                        MyFile f1 = new MyFile();
                        f1.DeleteFile(s);
                        System.out.println("----------------------------------");
                    }
                    else{
                        System.out.print("Enter The Path Of Folder: ");
                        String s;
                        s = in.next();
                        Folder fo = new Folder();
                        fo.DeleteFolder(s);
                        System.out.println("----------------------------------");
                    }
                    System.out.println("----------------------------------");
                    break;
                }
                case 8:{
                    exit(0);
                    break;
                }
                default:{
                   System.out.println("Please Enter Number Between 1-8");
                   System.out.println("----------------------------------");
                   break;
                }
            }
        }
    }
}
