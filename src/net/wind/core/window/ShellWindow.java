package net.wind.core.window;

import net.wind.BoyLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.wind.core.window.Shell.inputUtils;

import net.wind.utils.shell.ShellCommand;
/**
 * createTime 2022/12/3 0003
 * fileName ShellWindow
 *
 * @author WindStream
 */


public class ShellWindow extends JFrame implements Runnable{
    public static JTextArea WindowMainArea = new JTextArea();
    public static String Session_Status = "No Session";
    public static String y_text;
    public static List<String> CommandHistory = new ArrayList<String>();
    //0 ---> Default
    public static int CommandHistory_Sel = 0;
    public static int CommandHistory_selKey2 =1;
    public static int CommandHistory_SelKey3 =1;
    public ShellWindow(){}
        @Override
        public void run() {
            //InputStream inputStream = BoyLoader.class.getClassLoader().getResourceAsStream("net/resources/logo.jpg");
            //icon_image = ImageIO.read(inputStream);

            this.setTitle("Shell Window || By WindStream");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            /*WindowMainArea.setEditable(false);
            WindowMainArea.setBackground(Color.BLACK);
            WindowMainArea.setForeground(Color.GREEN);*/

            Container c = getContentPane();
            JScrollPane jScrollPane = new JScrollPane(WindowMainArea);
            getContentPane().add(jScrollPane, BorderLayout.CENTER);
            //Set Color Of Background and Font
            WindowMainArea.setBackground(Color.BLACK);
           // WindowMainArea.setForeground(Color.GREEN);
            WindowMainArea.setForeground(Color.WHITE);
            //Set Selection-Color
            WindowMainArea.setSelectionColor(Color.WHITE);
            //Set Font
            WindowMainArea.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
            //Append Info of program
            WindowMainArea.append(BoyLoader.SoftWareName + "  "+BoyLoader.ProgramVersion + "\n");
            WindowMainArea.append("Project Created By " + BoyLoader.Team + "\n");
            WindowMainArea.append("Use command \"shell_help\" to know how to use it!\n\n");
            WindowMainArea.append("CircularHoleBoy("+Session_Status+")>");
            WindowMainArea.setSelectionStart(WindowMainArea.getText().length());
            y_text = WindowMainArea.getText();
            //add a keyListener
            WindowMainArea.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()){
                        case 8:
                            if (WindowMainArea.getText().length()-1 < y_text.length()){
                                e.consume();
                            }
                            break;
                        case 10:
                            e.consume();
                            break;
                        default:
                            WindowMainArea.setSelectionStart(WindowMainArea.getText().length());
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) {
                     //System.out.println(e.getKeyCode());
                    //38 ---> up
                    //40 ---> down
                    if (e.getKeyCode() == 38) {
                        CommandHistory_SelKey3=1;
                       WindowMainArea.setText(y_text);
                       if (CommandHistory.size() - CommandHistory_selKey2 < 0){
                           CommandHistory_selKey2-=1;
                       }
                       CommandHistory_Sel = CommandHistory.size() - CommandHistory_selKey2;
                       WindowMainArea.append(CommandHistory.get(CommandHistory_Sel ));
                        CommandHistory_selKey2 +=1;
                        //CommandHistory_SelKey3 -=1;
                    }
                    if (e.getKeyCode() == 40){
                        CommandHistory_selKey2=1;
                        WindowMainArea.setText(y_text);
                        if (CommandHistory_Sel + CommandHistory_SelKey3 >= CommandHistory.size()){
                            WindowMainArea.setText(y_text);
                        }else {
                            WindowMainArea.append(CommandHistory.get(CommandHistory_Sel +CommandHistory_SelKey3));
                        }
                        CommandHistory_SelKey3+=1;
                    }
                    if (e.getKeyCode() == 10) {
                        String command = inputUtils.getInputString(y_text,WindowMainArea.getText());
                        CommandHistory.add(command);
                        CommandHistory_selKey2 =1 ;
                        CommandHistory_SelKey3 =1;
                        //WindowMainArea.append("\nCircularHoleBoy("+Session_Status+")>");
                        try {
                            WindowMainArea.append("\n"+ShellCommand.command(command));
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        WindowMainArea.append("\nCircularHoleBoy("+Session_Status+")>");
                        y_text = WindowMainArea.getText();
                        WindowMainArea.setSelectionStart(y_text.length());
                    }
                }
            });
            WindowMainArea.setEditable(true);
            this.setSize(1000,600);
            this.setVisible(true);
        }



    public static void buildShellWindow(){
        Thread buildShellWindow =new Thread(new ShellWindow());
        buildShellWindow.setDaemon(true);
        buildShellWindow.setName("ShellWindow");
        buildShellWindow.setPriority(5);
        buildShellWindow.start();
    }
}
