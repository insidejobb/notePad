import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class note extends JFrame implements ActionListener{


    // frame declaration
    JFrame f;
    //text area declarattion
    JTextArea t;
    //creating menubar
    JMenuBar menubar;
    //constructor
    note(){

        //initilizing the frame
        f=new JFrame("notepad");
        //initilizing textArea
        t=new JTextArea();
        //menubar declaration
        menubar=new JMenuBar();

        //creatin the file menu
        JMenu file=new JMenu("File");
        //creating the options for file
        JMenuItem f1=new JMenuItem("New");
        JMenuItem f2=new JMenuItem("SAVE");
        JMenuItem f3=new JMenuItem("OPEN");
        JMenuItem f4=new JMenuItem("PRINT");

        //adding actionlistenrs to each of the options
        f1.addActionListener(this);
        f2.addActionListener(this);
        f3.addActionListener(this);
        f4.addActionListener(this);
        //adding the options to the file menu
        file.add(f1);
        file.add(f2);
        file.add(f3);
        file.add(f4);


        //creating the edit menu
        JMenu edit=new JMenu("Edit");
        //creating the options for file
        JMenuItem e1=new JMenuItem("cut");
        JMenuItem e2=new JMenuItem("copy");
        JMenuItem e3=new JMenuItem("paste");
        

        //adding actionlistenrs to each of the options
        e1.addActionListener(this);
        e2.addActionListener(this);
        e3.addActionListener(this);
        
        //adding the options to the file menu
        edit.add(e1);
        edit.add(e2);
        edit.add(e3);

        //creating the close button
        JMenuItem close=new JMenuItem("close");
        close.addActionListener(this);

        menubar.add(file);
        menubar.add(edit);
        menubar.add(close);

        f.setJMenuBar(menubar);
        f.add(t);
        f.setSize(1280,720);
        f.show();


    }
    
    //to add the functionalities
    public void actionPerformed(ActionEvent e){
        String s=e.getActionCommand();

        switch(s){
            case "New":
            t.setText("");
                break;

            case "SAVE":
            JFileChooser j=new JFileChooser();
            int r=j.showSaveDialog(null);
            //r containes sttaus of dialogbox 1 if clicked on save
            if(r==0){
                //declare a file object
                File fi=new File(j.getSelectedFile().getAbsolutePath());

                
                    try {
                        FileWriter fw=new FileWriter(fi);
                        BufferedWriter bw=new BufferedWriter(fw);
                        bw.write(t.getText());

                        bw.flush();
                        bw.close();


                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
            }
            else{
                JOptionPane.showMessageDialog(f, "the use has cancelled the operation");

            }


                break;
            case "OPEN":
            //creating the objet of Jfilechooser class with starting path of :
            JFileChooser ji=new JFileChooser(" ");

            //invoke saveddialogbox
            int ri=ji.showSaveDialog(null);
            //r containes sttaus of dialogbox 1 if clicked on save
            if(ri==0){
                //declare a file object
                File fi=new File(ji.getSelectedFile().getAbsolutePath());

                
                    try {
                        FileReader fw=new FileReader(fi);
                        BufferedReader br=new BufferedReader(fw); 

                        String s1="",s2="";
                        //first line stored in s1
                        s1=br.readLine();
                        while((s2=br.readLine())!=null){
                            s1=s1+"\n"+s2;
                            
                        }
                        //all the content of the file copied into s1
                        t.setText(s1);


                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
            }
            else{
                JOptionPane.showMessageDialog(f, "the use has cancelled the operation");

            }

                break;
            case "PRINT":
                try {
                    t.print();
                } catch (PrinterException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                break;
            case "cut":
            t.cut();
                break;
            case "copy":
            t.copy();
                break;
            case "paste":
            t.paste();
                break;
            case "close":
            f.setVisible(false);
                break;
        }
    }
    public static void main(String []args){


        note n=new note();

    }
    
}
