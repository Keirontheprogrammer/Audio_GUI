package org.example;

import javafx.geometry.Bounds;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyButton extends JFrame implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JLabel label;
    Clip clip;
    MyButton() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File  file=new File("04. R.I.P. SCREW.wav");
        AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
        clip=AudioSystem.getClip();
        clip.open(audioStream);



        button1=new JButton("Click click suckers");
        button1.setBounds(80,150,100,90);
        button1.addActionListener(this);
        button1.setBackground(Color.lightGray);
        button1.setFocusable(false);
//        button1.setBorder(BorderFactory.createEtchedBorder());

        button2=new JButton("PAUSE");
        button2.setBounds(200,150,100,90);
        button2.addActionListener(this);
        button2.setBackground(Color.lightGray);
        button2.setFocusable(false);
//        button2.setBorder(BorderFactory.createEtchedBorder());

        button3=new JButton("CLOSE");
        button3.setBounds(400,150,100,90);
        button3.addActionListener(this);
        button3.setBackground(Color.lightGray);
        button3.setFocusable(false);
//        button3.setBorder(BorderFactory.createEtchedBorder());
        button3.setEnabled(false);

        ImageIcon icon=new ImageIcon("360_F_705409131_qkbY7Kl3XyxOFhxm4TsDC7jHoJnVr6eD.jpg");
        label=new JLabel();
        label.setBounds(100,150,1348,110);

        label.setIcon(icon);
        label.setVisible(false);

        new JFrame();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(null);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            clip.start();
            label.setVisible(true);
        }
        else if(e.getSource()==button2){
            clip.stop();
        }
        else{
            clip.close();
        }
    }

}
