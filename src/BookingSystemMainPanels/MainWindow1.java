package BookingSystemMainPanels;




    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

//for animations

import org.jdesktop.animation.timing.*;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.interpolation.*;
import java.awt.Graphics;


import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.UIManager;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Types;
import java.awt.event.*;
/**
 *
 * @author Kevin
 */
public class MainWindow1 extends javax.swing.JFrame {

    
    public MainWindow1() {

        
        initComponents();

        
        //for Features Animations
        FeaturePanelsDesign();
        IntroVid1();
        RoundingCorners1();
        RoundingCheckIn();
        RoundInfoPanels();
        RoundingTheRoomSelectionPanels();
        Slide2.setLayout(null);
        
        //hiding things
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentMainWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            OnlinePaymentMainWindow2A1.setVisible(false);
        
        //Payment Total Details Updated!!
        //scrolling smooth
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        jScrollPane2.getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);
        MainTitleChanges();
        //LoginSystem FIx BUG
        
        AccountInfoPanel.setVisible(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setOpaque(false);
        RoomSectionPanel.setVisible(false);
        RoomInfoPanel.setVisible(false);
        LoginSystemPanel.setVisible(false);
        CheckInPayment.setVisible(false);
        ExitMessageWindowz.setVisible(false);
        HotelFeaturesPanels.setVisible(false);
        MenuButtonsPanels.setVisible(false);
        
        
        //total amount update Checkins
        TotalAmountA1Checkin.addActionListener(e -> PaymentDetailsA1());
        try {
            connection();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    public void MainTitleChanges() {
        
        String[] MainTitles =  {"Features", "Business Hub", "Luxury Escape"};
        String[] MainDesc = { "Reliable room service, gyms, pools, dining areas pact with buffet dishes from professional chefs,suitable for a guest's daily needs."
        , "Convenient location, fast Wi-Fi, and  meeting spaces for professionals on the go."
        , "Modern rooms, top notch amenities, and breathtaking views for a perfect view."};
        
        
        
        
        Timer titleTimer1 = new Timer(5000, new ActionListener() {
            int index = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                Title1.setText(MainTitles[index]); 
                index = (index + 1) % MainTitles.length;
                jTextArea2.setText(MainDesc[index]); 
                index = (index + 1) % MainDesc.length;
            }
        });
        titleTimer1.start();
    }
    //Logged in account
    String username = "";
    
    //Connection to database method ;>
    int LoginEnabled = 1;
    int RoomBooked = 1;
    String Usernamee = "";
     Connection con;
     Statement Stmt;
     PreparedStatement pst;
    
    //method for connection :>
    // "Db" means Database
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbURL = "jdbc:mysql://localhost:3307/hotelusers";
    private static final String DbPhoneNumber= "root";
    private static final String DbPassword = "";
    
    
    public void IntroVid1() {
        if (HotelFeaturesPanels.isVisible()) {
            
            Picture.setVisible(false);
            TextIntroA2.setVisible(false);
            TextIntroA3.setVisible(false);
            Slide2.setVisible(false);
            Slide1.setVisible(true);
            TextIntro1.setVisible(true);
            TextIntroA1.setVisible(true);
            DesignA1.setVisible(true);
            DescIntro1.setVisible(true);
            ShowButtonA1.setVisible(true);
            TextIntro1.setForeground(new Color(255, 255, 255, 0));
            TextIntroA1.setForeground(new Color(255, 255, 255, 0));
            DesignA1.setBackground(new Color(255, 255, 255, 0));
            DescIntro1.setForeground(new Color(255, 255, 255, 0));
            ShowButtonA1.setBackground(new Color(124, 119, 92, 0));
            ShowButtonA1.setForeground(new Color(255, 255, 255, 0));
            
            PropertySetter A1Intro = new PropertySetter(TextIntro1, "location", new Point(190, 100), new Point(190, 75));
            PropertySetter B1Intro = new PropertySetter(TextIntroA1, "location", new Point(180, 125), new Point(180, 100));
            PropertySetter C1Intro = new PropertySetter(DesignA1, "location", new Point(475, 200), new Point(475, 175));
            PropertySetter D1Intro = new PropertySetter(DescIntro1, "location", new Point(260, 215), new Point(260, 190));
            PropertySetter E1Intro = new PropertySetter(ShowButtonA1, "location", new Point(380, 550), new Point(380, 270));
            //fading animation
            PropertySetter A1Fade = new PropertySetter(TextIntro1, "foreground", new Color(255, 255, 255, 0), new Color(255, 255, 255, 255));
            PropertySetter B1Fade = new PropertySetter(TextIntroA1, "foreground", new Color(255, 255, 255, 0), new Color(255, 255, 255, 255));
            PropertySetter C1Fade = new PropertySetter(DesignA1, "background", new Color(255, 255, 255, 0), new Color(255, 255, 255, 255));
            PropertySetter D1Fade = new PropertySetter(DescIntro1, "foreground", new Color(255, 255, 255, 0), new Color(255, 255, 255, 255));
            PropertySetter E1Fade = new PropertySetter(ShowButtonA1, "background", new Color(124, 119, 92, 0), new Color(124, 119, 92, 255));
            PropertySetter EA1Fade = new PropertySetter(ShowButtonA1, "foreground", new Color(255, 255, 255, 0), new Color(255, 255, 255, 255));
            
            Animator FadeA1 = new Animator(400, A1Fade);
            Animator FadeB1 = new Animator(400, B1Fade);
            Animator FadeC1 = new Animator(400, C1Fade);
            Animator FadeD1 = new Animator(400, D1Fade);
            Animator FadeE1 = new Animator(600, E1Fade);
            Animator FadeEA1 = new Animator(600, EA1Fade);
            
            FadeB1.setStartDelay(200);
            FadeC1.setStartDelay(250);
            FadeD1.setStartDelay(300);
            FadeE1.setStartDelay(350);
            FadeEA1.setStartDelay(350);
            
            FadeE1.setAcceleration(0.6f);
            FadeEA1.setAcceleration(0.6f);
            
            FadeA1.start();
            FadeB1.start();
            FadeC1.start();
            FadeD1.start();
            FadeE1.start();
            FadeEA1.start();
            
            //
            Animator IntroA1 = new Animator(400, A1Intro);
            Animator IntroB1 = new Animator(400, B1Intro);
            Animator IntroC1 = new Animator(400, C1Intro);
            Animator IntroD1 = new Animator(400, D1Intro);
            Animator IntroE1 = new Animator(600, E1Intro);
            IntroB1.setStartDelay(200);
            IntroC1.setStartDelay(250);
            IntroD1.setStartDelay(300);
            IntroE1.setStartDelay(350);
            IntroA1.setDeceleration(0.3f);
            IntroB1.setDeceleration(0.3f);
            IntroC1.setDeceleration(0.3f);
            IntroD1.setDeceleration(0.3f);
            IntroE1.setDeceleration(0.3f);
            IntroA1.start();
            IntroB1.start();
            IntroC1.start();
            IntroD1.start();
            IntroE1.start();
             
            //start Fading
            
        }
    }
    public void OutroVid1() {
        //off selected features
        MenuButtonsPanels.setVisible(true);
        
        Feature1.setLocation(-375, 40);
        Feature2.setLocation(-375, 130);
        Feature3.setLocation(-375, 220);
        Feature4.setLocation(-375, 310);
        
        FeatureDeselectedAll();
        PropertySetter A1Fade = new PropertySetter(TextIntro1, "foreground", new Color(255, 255, 255, 255), new Color(255, 255, 255, 0));
            PropertySetter B1Fade = new PropertySetter(TextIntroA1, "foreground", new Color(255, 255, 255, 255), new Color(255, 255, 255, 0));
            PropertySetter C1Fade = new PropertySetter(DesignA1, "background", new Color(255, 255, 255, 255), new Color(255, 255, 255, 0));
            PropertySetter D1Fade = new PropertySetter(DescIntro1, "foreground", new Color(255, 255, 255, 255), new Color(255, 255, 255, 0));
            PropertySetter E1Fade = new PropertySetter(ShowButtonA1, "background", new Color(124, 119, 92, 255), new Color(124, 119, 92, 0));
            PropertySetter EA1Fade = new PropertySetter(ShowButtonA1, "foreground", new Color(255, 255, 255, 255), new Color(255, 255, 255, 0));
            
            Animator FadeA1 = new Animator(400, A1Fade);
            Animator FadeB1 = new Animator(400, B1Fade);
            Animator FadeC1 = new Animator(400, C1Fade);
            Animator FadeD1 = new Animator(400, D1Fade);
            Animator FadeE1 = new Animator(600, E1Fade);
            Animator FadeEA1 = new Animator(600, EA1Fade);
            FadeB1.setStartDelay(200);
            FadeC1.setStartDelay(250);
            FadeD1.setStartDelay(300);
            FadeE1.setStartDelay(350);
            FadeEA1.setStartDelay(350);
            
            FadeE1.setAcceleration(0.6f);
            FadeEA1.setAcceleration(0.6f);
            
            FadeA1.start();
            FadeB1.start();
            FadeC1.start();
            FadeD1.start();
            FadeE1.start();
            FadeEA1.start();
            Timer Timer1 = new Timer(700, e -> {
                TextIntro1.setVisible(false);
                TextIntroA1.setVisible(false);
                DesignA1.setVisible(false);
                DescIntro1.setVisible(false);
                ShowButtonA1.setVisible(false);
                Slide1.setVisible(false);
                Slide2.setVisible(true);
                //opening animation
                PropertySetter A2Intro = new PropertySetter(Feature1, "location", new Point(-375, 40), new Point(85, 40));
                PropertySetter B2Intro = new PropertySetter(Feature2, "location", new Point(-375, 130), new Point(85, 130));
                PropertySetter C2Intro = new PropertySetter(Feature3, "location", new Point(-375, 220), new Point(85, 220));
                PropertySetter D2Intro = new PropertySetter(Feature4, "location", new Point(-375, 310), new Point(85, 310));
                
                Animator IntroA2 = new Animator(500, A2Intro);
                Animator IntroB2 = new Animator(500, B2Intro);
                Animator IntroC2 = new Animator(500, C2Intro);
                Animator IntroD2 = new Animator(500, D2Intro);
                
                IntroA2.setDeceleration(0.4f);
                IntroB2.setDeceleration(0.4f);
                IntroC2.setDeceleration(0.4f);
                IntroD2.setDeceleration(0.4f);
                
                IntroB2.setStartDelay(30);
                IntroC2.setStartDelay(60);
                IntroD2.setStartDelay(90);
                
                IntroA2.start();
                IntroB2.start();
                IntroC2.start();
                IntroD2.start();
            });
            Timer1.setRepeats(false);
            Timer1.start();
    }
    
    public void FeatureDeselectedAll() {
        Feature1.setSize(365, 75);
        Feature2.setSize(365, 75);
        Feature3.setSize(365, 75);
        Feature4.setSize(365, 75);
        Picture.setVisible(true);
        TextIntroA2.setVisible(true);
        TextIntroA3.setVisible(true);
        Feature1.setVisible(true);
        FeatureA1.setVisible(true);
        FeatureB1.setVisible(false);
        Feature2.setVisible(true);
        FeatureA2.setVisible(true);
        FeatureB2.setVisible(false);
        Feature3.setVisible(true);
        FeatureA3.setVisible(true);
        FeatureB3.setVisible(false);
        Feature4.setVisible(true);
        FeatureA4.setVisible(true);
        FeatureB4.setVisible(false);
    }
    
    public void Feature1Selected() {
        PropertySetter A2Intro = new PropertySetter(Feature1, "size", Feature1.getSize(), new Dimension(850, 350));
        Animator Intro2 = new Animator(500, A2Intro);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.start();
        FeatureA1.setVisible(false);
        FeatureB1.setVisible(true);
        Picture.setVisible(false);
        TextIntroA2.setVisible(false);
        TextIntroA3.setVisible(false);
        Feature1.revalidate();
        Feature1.repaint();
        
        //turning off others
        Feature2.setVisible(false);
        Feature3.setVisible(false);
        Feature4.setVisible(false);
    }
    
    public void Feature2Selected() {
        PropertySetter A2Intro = new PropertySetter(Feature2, "size", Feature2.getSize(), new Dimension(850, 350));
        PropertySetter A2FixPos = new PropertySetter(Feature2, "location", Feature2.getLocation(), new Point(85, 40));
        Animator Intro2 = new Animator(500, A2Intro);
        Animator FixPosA2 = new Animator(500, A2FixPos);
        FixPosA2.setAcceleration(0.2f);
        FixPosA2.setDeceleration(0.3f);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.setStartDelay(30);
        Intro2.start();
        FixPosA2.start();
        FeatureA2.setVisible(false);
        FeatureB2.setVisible(true);
        Picture.setVisible(false);
        TextIntroA2.setVisible(false);
        TextIntroA3.setVisible(false);
                
        
        Feature2.revalidate();
        Feature2.repaint();
        
        //turning off others
        Feature1.setVisible(false);
        Feature3.setVisible(false);
        Feature4.setVisible(false);
    }
    
    public void Feature3Selected() {
        PropertySetter A2Intro = new PropertySetter(Feature3, "size", Feature4.getSize(), new Dimension(850, 350));
        PropertySetter A2FixPos = new PropertySetter(Feature3, "location", Feature4.getLocation(), new Point(85, 40));
        Animator Intro2 = new Animator(500, A2Intro);
        Animator FixPosA2 = new Animator(500, A2FixPos);
        FixPosA2.setAcceleration(0.2f);
        FixPosA2.setDeceleration(0.3f);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.setStartDelay(30);
        Intro2.start();
        FixPosA2.start();
        FeatureA3.setVisible(false);
        FeatureB3.setVisible(true);
        Picture.setVisible(false);
        TextIntroA2.setVisible(false);
        TextIntroA3.setVisible(false);
        Feature3.revalidate();
        Feature3.repaint();
        
        //turning off others
        Feature1.setVisible(false);
        Feature2.setVisible(false);
        Feature4.setVisible(false);
    }
    
    public void Feature4Selected() {
        PropertySetter A2Intro = new PropertySetter(Feature4, "size", Feature4.getSize(), new Dimension(850, 350));
        PropertySetter A2FixPos = new PropertySetter(Feature4, "location", Feature4.getLocation(), new Point(85, 40));
        Animator Intro2 = new Animator(500, A2Intro);
        Animator FixPosA2 = new Animator(500, A2FixPos);
        FixPosA2.setAcceleration(0.2f);
        FixPosA2.setDeceleration(0.3f);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.setStartDelay(30);
        Intro2.start();
        FixPosA2.start();
        FeatureA4.setVisible(false);
        FeatureB4.setVisible(true);
        Picture.setVisible(false);
        TextIntroA2.setVisible(false);
        TextIntroA3.setVisible(false);
        Feature4.revalidate();
        Feature4.repaint();
        
        //turning off others
        Feature1.setVisible(false);
        Feature2.setVisible(false);
        Feature3.setVisible(false);
    }
    
    public void Feature1Exit() {
        PropertySetter A2Intro = new PropertySetter(Feature1, "size", Feature1.getSize(), new Dimension(365, 75));
        Animator Intro2 = new Animator(400, A2Intro);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.start();
        FeatureA1.setVisible(true);
        FeatureB1.setVisible(false);
        Picture.setVisible(true);
        TextIntroA2.setVisible(true);
        TextIntroA3.setVisible(true);
        Feature1.revalidate();
        Feature1.repaint();
        
        //turning off others
        Feature2.setVisible(true);
        Feature3.setVisible(true);
        Feature4.setVisible(true);
    }
    
    public void Feature2Exit() {
        PropertySetter A2Intro = new PropertySetter(Feature2, "size", Feature2.getSize(), new Dimension(365, 75));
        PropertySetter A2FixPos = new PropertySetter(Feature2, "location", Feature2.getLocation(), new Point(85, 130));
        Animator Intro2 = new Animator(500, A2Intro);
        Animator FixPosA2 = new Animator(500, A2FixPos);
        FixPosA2.setAcceleration(0.2f);
        FixPosA2.setDeceleration(0.3f);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.setStartDelay(30);
        Intro2.start();
        FixPosA2.start();
        FeatureA2.setVisible(true);
        FeatureB2.setVisible(false);
        Picture.setVisible(true);
        TextIntroA2.setVisible(true);
        TextIntroA3.setVisible(true);
        Feature2.revalidate();
        Feature2.repaint();
        
        //turning off others
        Feature1.setVisible(true);
        Feature3.setVisible(true);
        Feature4.setVisible(true);
    }
    
    public void Feature3Exit() {
        PropertySetter A2Intro = new PropertySetter(Feature3, "size", Feature3.getSize(), new Dimension(365, 75));
        PropertySetter A2FixPos = new PropertySetter(Feature3, "location", Feature3.getLocation(), new Point(85, 220));
        Animator Intro2 = new Animator(500, A2Intro);
        Animator FixPosA2 = new Animator(500, A2FixPos);
        FixPosA2.setAcceleration(0.2f);
        FixPosA2.setDeceleration(0.3f);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.setStartDelay(30);
        Intro2.start();
        FixPosA2.start();
        FeatureA3.setVisible(true);
        FeatureB3.setVisible(false);
        Picture.setVisible(true);
        TextIntroA2.setVisible(true);
        TextIntroA3.setVisible(true);
        Feature3.revalidate();
        Feature3.repaint();
        
        //turning off others
        Feature1.setVisible(true);
        Feature2.setVisible(true);
        Feature4.setVisible(true);
    }
    
    public void Feature4Exit() {
        PropertySetter A2Intro = new PropertySetter(Feature4, "size", Feature4.getSize(), new Dimension(365, 75));
        PropertySetter A2FixPos = new PropertySetter(Feature4, "location", Feature4.getLocation(), new Point(85, 310));
        Animator Intro2 = new Animator(500, A2Intro);
        Animator FixPosA2 = new Animator(500, A2FixPos);
        FixPosA2.setAcceleration(0.2f);
        FixPosA2.setDeceleration(0.3f);
        Intro2.setAcceleration(0.2f);
        Intro2.setDeceleration(0.3f);
        Intro2.setStartDelay(30);
        Intro2.start();
        FixPosA2.start();
        FeatureA4.setVisible(true);
        FeatureB4.setVisible(false);
        Picture.setVisible(true);
        TextIntroA2.setVisible(true);
        TextIntroA3.setVisible(true);
        Feature4.revalidate();
        Feature4.repaint();
        
        //turning off others
        Feature1.setVisible(true);
        Feature2.setVisible(true);
        Feature3.setVisible(true);
    }
    
    public void FeaturePanelsDesign() {
        Feature1.setOpaque(false);
        Feature2.setOpaque(false);
        Feature3.setOpaque(false);
        Feature4.setOpaque(false);
        
        Feature1.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        Feature2.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        Feature3.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        Feature4.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );        
    }
    public void RoundingCorners1() {
        //Rounding corners in JPanels, and JLabels.
        Background6.setOpaque(false);
        Background6.setBackground(new Color( 203, 193, 155, 75));
        Background6.putClientProperty( FlatClientProperties.STYLE, "arc: 25" ); //This is a LoginFormPanel
        SignInButton2.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        SignInButton1.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        ExitLoginButton2.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        //for a SignUp Panels adding designs
        Background10.setOpaque(false);
        Background10.setBackground(new Color( 203, 193, 155, 75));
        Background10.putClientProperty( FlatClientProperties.STYLE, "arc: 25" );
        //ExitMessageWindow adding designs
        ExitMessageWindow.setOpaque(true);
        ExitMessageWindow.setBackground(new Color(0, 0, 0, 200));
        ExitMessageMainWindow.setOpaque(false);
        ExitMessageMainWindow.putClientProperty( FlatClientProperties.STYLE, "arc: 25" ); 
        ContinueButtonLogin.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        ExitButtonLogin.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        //ExitMessageWindow adding design
        GOSigninWindowButton.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        SignUpButton1.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        //BookButtons
        BookButtonA1.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        BookButtonA2.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        BookButtonB1.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        BookButtonB2.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        BookButtonC1.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        ExitInfoButton.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        //MenuButtonsETC
        MenuButtonsPanels.setBackground(new Color( 203, 193, 155));
        MenuButtonsPanels.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
    }
    public void RoundingCheckIn() {
        MainPanelBook1.setOpaque(false);
        MainPanelBook2.setOpaque(false);
        MainPanelBook1.putClientProperty( FlatClientProperties.STYLE, "arc: 25" );
        MainPanelBook2.putClientProperty( FlatClientProperties.STYLE, "arc: 25" );
        ConfirmButtonA1Checkin.putClientProperty( FlatClientProperties.STYLE, "arc: 25" );
        OnlinePaymentChooseA1.putClientProperty( FlatClientProperties.STYLE, "arc: 25" );
    }
    public void RoundInfoPanels() {
        //infos
        UsernameInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        EmailaddressInfo1.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        PhonenumberInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        RefundButton.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        //booking Info
        GuestNameInfo1.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        RoomtypeInfo2.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        AddressInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        RoompriceInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        TotalpriceInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        BookingschedInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        PaymentstatusInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        PaymentmethodInfo.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        MainInfoBackgroundPanel2.putClientProperty( FlatClientProperties.STYLE, "arc: 25" );
        MainInfoBackgroundPanel3.putClientProperty( FlatClientProperties.STYLE, "arc: 25" );
    }
    public void RoundingTheRoomSelectionPanels() {
        RoomASelectionPanel.setBackground(new Color(255,255,255, 100));
        RoomASelectionPanel.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        RoomASelectionPanel.setOpaque(false);
        RoomBSelectionPanel1.setBackground(new Color(255,255,255, 100));
        RoomBSelectionPanel1.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        RoomBSelectionPanel1.setOpaque(false);
        RoomBSelectionPanel2.setBackground(new Color(255,255,255, 100));
        RoomBSelectionPanel2.putClientProperty( FlatClientProperties.STYLE, "arc: 10" );
        RoomBSelectionPanel2.setOpaque(false);
        
        //Rooms
        
        RoomA1S.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        
        RoomA2S.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        RoomB1S.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        RoomB2S.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        RoomB1S1.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        
        //Room Pictures
        RoomA2Pic.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        RoomB1Pic.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        RoomB2Pic.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        RoomC1Pic.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
    }
    private void connection() throws SQLException {
        try {
            Class.forName(DbDriver);
            con = DriverManager.getConnection(DbURL, DbPhoneNumber, DbPassword);
            Stmt = con.createStatement();
            if (con != null) {
                System.out.println("Connection Success");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    // Info A1 PaymentDetails Function
        private int PriceDayA1 = 0;
        private int PriceNightA1 = 0;
        String roomname = "Loading";
    public void PaymentDetailsA1() {
        //int values
        System.out.println("PaymentDetailsA1 is using...");
        
        String inputDays = MaxDaysCheckinA1.getText();
        //hides the paymentoption
        OnlinePaymentWindow3A1.setVisible(false);
        OnlinePaymentWindow2A1.setVisible(false);
        OnlinePaymentWindow1A1.setVisible(false);
        
        int Days = Integer.parseInt(inputDays);
        int result = 0;
        ButtonGroup group = new ButtonGroup();
        group.add(RoomSchedDayCheckinA1);
        group.add(RoomSchedNightCheckinA1); 
        
        ButtonGroup paymentMethod = new ButtonGroup();
        paymentMethod.add(PaymentMethodCheckin1A1);
        paymentMethod.add(PaymentMethodCheckin2A3);
        paymentMethod.add(PaymentMethodCheckin2A2);
        
        ButtonGroup selectPaymentMethod = new ButtonGroup();
        selectPaymentMethod.add(GcashOptionA1);
        selectPaymentMethod.add(PaymayaOptionA1);
        
        if (PaymentMethodCheckin1A1.isSelected()) {
            OnlinePaymentChooseA1.setVisible(true);
        }
        if (PaymentMethodCheckin2A3.isSelected()) {
            OnlinePaymentChooseA1.setVisible(false);
            selectPaymentMethod.clearSelection();
        }
        
        if (PaymentMethodCheckin2A2.isSelected()) {
             OnlinePaymentChooseA1.setVisible(false);
             selectPaymentMethod.clearSelection();
        }
        
        
        if (PriceDayA1 == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "An error occured, please try again.");
            
            MenuButtonsPanels.setVisible(true);
            
            CheckinA1.setVisible(false);
            //making sure the other panel is not visible--
            RoomInfoPanel.setVisible(false);
            MainPanel1.setVisible(false);
            Timer Hotelappear1 = new Timer(1000, e -> {
               RoomSectionPanel.setVisible(true);
            });
            Hotelappear1.setRepeats(false);
            Hotelappear1.start();
            return;
        }
        if (PriceNightA1 == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "An error occured, please try again.");
            
            
            CheckinA1.setVisible(false);
            //making sure the other panel is not visible--
            RoomInfoPanel.setVisible(false);
            MainPanel1.setVisible(false);
            Timer Hotelappear1 = new Timer(1000, e -> {
               RoomSectionPanel.setVisible(true);
            });
            Hotelappear1.setRepeats(false);
            Hotelappear1.start();
            return;
        }
        //room choose:
        
        BookButtonA1.addActionListener(e -> {
            System.out.println("bookbuttonA1 triggered");
            PaymentDetailsA1(); 
            if (e.getSource() == BookButtonA1) {
                PriceDayA1 = 8499;
                PriceNightA1 = 7499;
                DesignCheckin1.setText("Single Class A"); 
                roomname = "Single Class A";
                
            }
        });
        BookButtonA2.addActionListener(e -> {
            System.out.println("bookbuttonA2 triggered");
            PaymentDetailsA1(); 
            if (e.getSource() == BookButtonA2) {
                PriceDayA1 = 9499;
                PriceNightA1 = 10499;
                DesignCheckin1.setText("Double Class A"); 
                roomname = "Double Class A";
                
            }
            });
        BookButtonB1.addActionListener(e -> {
            System.out.println("bookbuttonB1 triggered");
            PaymentDetailsA1(); 
            if (e.getSource() == BookButtonB1) {
                PriceDayA1 = 15499;
                PriceNightA1 = 16499;
                DesignCheckin1.setText("Family Room A"); 
                roomname = "Family Room A";
            }
            });
        BookButtonB2.addActionListener(e -> {
            System.out.println("bookbuttonB2 triggered");
            PaymentDetailsA1(); 
            if (e.getSource() == BookButtonB2) {
                PriceDayA1 = 17499;
                PriceNightA1 = 18499;
                DesignCheckin1.setText("Family Room B"); 
                roomname = "Family Room B";
            }
            });
        BookButtonC1.addActionListener(e -> {
            System.out.println("bookbuttonC1 triggered");
            PaymentDetailsA1(); 
            if (e.getSource() == BookButtonC1) {
                PriceDayA1 = 40499;
                PriceNightA1 = 50499;
                DesignCheckin1.setText("VIP Room (Exclusive)"); 
                roomname = "VIP Room (Exclusive)";
            }
            });
        
        

        RoomSchedDayCheckinA1.addActionListener(e -> PaymentDetailsA1());
        RoomSchedNightCheckinA1.addActionListener(e -> PaymentDetailsA1());
        
        
        switch(Days) {
            case 1:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 2:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 3:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 4:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 5 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 6 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 7 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 8 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 9 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 10 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            default:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * 1 - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * 1 - 2499;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
        }
        
 
       
    }
    
    public void AccountInfo() {
        String phonenumber, usernamee, emailaddress, guestname, address, roomtype, roomprice, bookingsched, totalamount,
                paymentmethod, paymentstatus;
        
        String query = "SELECT * FROM hotelusersdatabase WHERE Username=?";
        try {
        pst = con.prepareStatement(query);
        pst.setString(1, Usernamee); 
        ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                phonenumber = rs.getString("PhoneNumber");
                usernamee = rs.getString("Username"); 
                emailaddress = rs.getString("EmailAddress");
                guestname = rs.getString("GuestName");
                address = rs.getString("Address");
                roomtype = rs.getString("RoomType");
                roomprice = rs.getString("RoomPrice");
                bookingsched = rs.getString("BookingSched");
                totalamount = rs.getString("TotalAmount");
                paymentmethod = rs.getString("PaymentMethod");
                paymentstatus = rs.getString("PaymentStatus");
                UsernameInfo.setText("Username: " + usernamee);
                EmailaddressInfo1.setText("Email address: " + emailaddress);
                AddressInfo.setText("Address: " + address);
                GuestNameInfo1.setText("Guest Name: " + guestname);
                RoompriceInfo.setText(roomprice);
                TotalpriceInfo.setText(totalamount);
                BookingschedInfo.setText(bookingsched);
                PaymentstatusInfo.setText(paymentstatus);
                PhonenumberInfo.setText("Phone number: " + phonenumber);
                PaymentmethodInfo.setText("Payment Method: " + paymentmethod);
                RoomtypeInfo2.setText("Room type: " + roomtype);
            } else {
                UsernameInfo.setText("User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    public void AccountRefund() {
         String guestnameA1, addressA1, roomtypeA1, roompriceA1, totalamount, paymentmethod, paymentstatus;
        System.out.println("AccountRefund Triggered!");
         
        roompriceA1 = ".";
        totalamount = ".";
        guestnameA1 = ".";
        addressA1 = ".";
        roomtypeA1 = ".";
        paymentmethod = ".";
        paymentstatus = ".";
        int bookingtime = 0;
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        
        String REFUNDS = "UPDATE hotelusersdatabase "
                + "SET GuestName=?, Address=?, RoomType=?, RoomPrice=?, BookingSched=?, "
                + "TotalAmount=?, PaymentMethod=?, PaymentStatus=? WHERE Username=?";
        try (Connection con = DriverManager.getConnection(DbURL, DbPhoneNumber, DbPassword);
                    PreparedStatement stmt = con.prepareStatement(REFUNDS)) {
                    stmt.setString(1, guestnameA1);
                    stmt.setString(2, addressA1);
                    stmt.setString(3, roomtypeA1);
                    stmt.setString(4, roompriceA1);
                    stmt.setNull(5, Types.TIMESTAMP);
                    stmt.setString(6, totalamount);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
    private void CreateAccountButton () {
         //Sign up button 
        String PhoneNumber, Username, Emailaddress, Password;
        String email = EmailAddressSignUpInput.getText().trim();
        
        
        if ("".equals(UsernameSignUpInput.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Phone Number");
        }  else if ("".equals(UsernameSignUpInput.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Username");
        }  else if ("".equals(PasswordSignUpInput.getPassword())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Password");
        }  else if (NumberSignUpInput.getText().length() > 11) {
            JOptionPane.showMessageDialog(new JFrame(), "Minimum and maximum 11 digits allowed!");
            NumberSignUpInput.setText("");
        }  else if (NumberSignUpInput.getText().length() < 11) {
            JOptionPane.showMessageDialog(new JFrame(), "Minimum and maximum 11 digits allowed!");
            NumberSignUpInput.setText("");
        }  else if (UsernameSignUpInput.getText().length() > 45 ) {
            JOptionPane.showMessageDialog(new JFrame(), "Maximum 45 characters allowed!");
            UsernameSignUpInput.setText("");
        }  else if (UsernameSignUpInput.getText().length() < 5) {
            JOptionPane.showMessageDialog(new JFrame(), "Username should be minimum of 5 letters.");
            UsernameSignUpInput.setText("");
        }  else if (PasswordSignUpInput.getPassword().length > 45) {
            JOptionPane.showMessageDialog(new JFrame(), "Maximum 45 characters allowed!");
            PasswordSignUpInput.setText("");
        }  else if (PasswordSignUpInput.getPassword().length < 8) {
            JOptionPane.showMessageDialog(new JFrame(), "minimum 8 characters allowed!");
            PasswordSignUpInput.setText("");
        } else if (!email.contains("@")) {
            JOptionPane.showMessageDialog(new JFrame(), "it needs contain '@example.com'");
            EmailAddressSignUpInput.setText("");
        } else if ("".equals(EmailAddressSignUpInput.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Email address'");
            EmailAddressSignUpInput.setText("");
        } else if (EmailAddressSignUpInput.getText().length() < 5) {
            JOptionPane.showMessageDialog(new JFrame(), "Minimum 5 characters allowed");
            EmailAddressSignUpInput.setText("");
            
        } else {
            PhoneNumber = NumberSignUpInput.getText();
            Username = UsernameSignUpInput.getText();
            Password = new String(PasswordSignUpInput.getPassword());
            Emailaddress = EmailAddressSignUpInput.getText();
            String queryRegister = "INSERT into hotelusersdatabase(PhoneNumber, Username, EmailAddress, Password)"
                    + "VALUES ('" + PhoneNumber + "','" + Username + "','"+ Emailaddress + "','"+ Password +"')";
            try {   
                    Stmt.execute(queryRegister);
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
               
            }
            JOptionPane.showMessageDialog(new JFrame(), "Created Account! You can now sign in with an existed account.");
            NumberSignUpInput.setText("");
            UsernameSignUpInput.setText("");
            PasswordSignUpInput.setText("");
            EmailAddressSignUpInput.setText("");
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuButtonsPanels = new javax.swing.JPanel();
        UserNameGreetings = new javax.swing.JLabel();
        ViewHotelFeatureButton = new javax.swing.JButton();
        RoomSectionButtion = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        CompanyNameLabel = new javax.swing.JLabel();
        ViewHotelFeatureButton1 = new javax.swing.JButton();
        HotelFeaturesPanels = new javax.swing.JPanel();
        Slide1 = new javax.swing.JPanel();
        TextIntro1 = new javax.swing.JLabel();
        TextIntroA1 = new javax.swing.JLabel();
        DesignA1 = new javax.swing.JPanel();
        DescIntro1 = new javax.swing.JTextArea();
        ShowButtonA1 = new javax.swing.JButton();
        Slide2 = new javax.swing.JPanel();
        Feature1 = new javax.swing.JPanel();
        FeatureA1 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        FeatureButton5 = new javax.swing.JButton();
        FeatureB1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        FeatureButtonA1 = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        Feature2 = new javax.swing.JPanel();
        FeatureA2 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        FeatureButton2 = new javax.swing.JButton();
        FeatureB2 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jTextArea3 = new javax.swing.JTextArea();
        FeatureButtonA2 = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        Feature3 = new javax.swing.JPanel();
        FeatureA3 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        FeatureButton3 = new javax.swing.JButton();
        FeatureB3 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jTextArea6 = new javax.swing.JTextArea();
        FeatureButtonA4 = new javax.swing.JButton();
        jLabel138 = new javax.swing.JLabel();
        Feature4 = new javax.swing.JPanel();
        FeatureA4 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        FeatureButton4 = new javax.swing.JButton();
        FeatureB4 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jTextArea13 = new javax.swing.JTextArea();
        FeatureButtonA5 = new javax.swing.JButton();
        jLabel139 = new javax.swing.JLabel();
        TextIntroA2 = new javax.swing.JLabel();
        TextIntroA3 = new javax.swing.JLabel();
        Picture = new javax.swing.JLabel();
        Background9 = new javax.swing.JLabel();
        AccountInfoPanel = new javax.swing.JPanel();
        PhonenumberInfo = new javax.swing.JLabel();
        AccountInfoPanel2 = new javax.swing.JPanel();
        AccountInfoPanel1 = new javax.swing.JPanel();
        RefundButton = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        UsernameInfo = new javax.swing.JLabel();
        EmailaddressInfo1 = new javax.swing.JLabel();
        AddressInfo = new javax.swing.JLabel();
        GuestNameInfo1 = new javax.swing.JLabel();
        TotalpriceInfo = new javax.swing.JLabel();
        PaymentmethodInfo = new javax.swing.JLabel();
        RoompriceInfo = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        BookingschedInfo = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        PaymentstatusInfo = new javax.swing.JLabel();
        RoomtypeInfo2 = new javax.swing.JLabel();
        MainInfoBackgroundPanel3 = new javax.swing.JLabel();
        MainInfoBackgroundPanel2 = new javax.swing.JLabel();
        MainInfoBackgroundPanel1 = new javax.swing.JLabel();
        RoomSectionPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        RoomBSelectionPanel2 = new javax.swing.JPanel();
        RoomB1S1 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        RoomB1Button1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        RoomC1Pic = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        RoomBSelectionPanel1 = new javax.swing.JPanel();
        RoomB2S = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        RoomB2Button = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        RoomB2Pic = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        RoomB1S = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        RoomB1Button = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        RoomB1Pic = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        RoomASelectionPanel = new javax.swing.JPanel();
        RoomA2S = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        RoomA1Button1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        RoomA2Pic = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        RoomA1S = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        RoomA1Button = new javax.swing.JButton();
        RoomA1Pic1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        FeaturesText1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        MainPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Decoration1 = new javax.swing.JPanel();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Title1 = new javax.swing.JLabel();
        CompanyTitle = new javax.swing.JLabel();
        CompanyTitle1 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Background1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        RoomInfoPanel = new javax.swing.JPanel();
        InfoWindows = new javax.swing.JPanel();
        ExitInfoButton = new javax.swing.JButton();
        InfoWindowA1 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jTextArea7 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        BookButtonA1 = new javax.swing.JButton();
        InfoWindowA2 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jTextArea10 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        BookButtonA2 = new javax.swing.JButton();
        InfoWindowB1 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jTextArea8 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        BookButtonB1 = new javax.swing.JButton();
        InfoWindowB2 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jTextArea11 = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        BookButtonB2 = new javax.swing.JButton();
        InfoWindowC1 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jTextArea9 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        BookButtonC1 = new javax.swing.JButton();
        InfoWindowC2 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jTextArea12 = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        BookButtonC2 = new javax.swing.JButton();
        CheckInPayment = new javax.swing.JPanel();
        CheckinA1 = new javax.swing.JPanel();
        OnlinePaymentWindow1A1 = new javax.swing.JPanel();
        OnlinePayment2ndWindow1A1 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        PriceTextGcash1A2 = new javax.swing.JLabel();
        AccountNameA2 = new javax.swing.JLabel();
        OnlinePaymentButton1GA2 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        OnlinePaymentMainWindow1A1 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        PriceTextGcash2A2 = new javax.swing.JLabel();
        AccountNameA1 = new javax.swing.JLabel();
        OnlinePaymentButton1GA1 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        OnlinePaymentWindow2A1 = new javax.swing.JPanel();
        OnlinePayment2ndWindow2A1 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        PriceTextPaymaya2A2 = new javax.swing.JLabel();
        AccountNameA3 = new javax.swing.JLabel();
        OnlineExitButton1A1 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        OnlinePaymentMainWindow2A1 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        PriceTextPaymaya1A2 = new javax.swing.JLabel();
        AccountNameA4 = new javax.swing.JLabel();
        OnlinePaymentButton2GA1 = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        OnlinePaymentWindow3A1 = new javax.swing.JPanel();
        OnlinePayment2ndWindow2A2 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        PriceTextPaymaya2A3 = new javax.swing.JLabel();
        AccountNameA5 = new javax.swing.JLabel();
        OnlineExitButton1A2 = new javax.swing.JButton();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        OnlinePaymentMainWindow2A2 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        PriceTextPaymaya1A3 = new javax.swing.JLabel();
        AccountNameA6 = new javax.swing.JLabel();
        OnlinePaymentButton2GA2 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        UpdatePriceA1Button = new javax.swing.JButton();
        ConfirmButtonA1Checkin = new javax.swing.JButton();
        RoomSchedNightCheckinA1 = new javax.swing.JRadioButton();
        RoomSchedDayCheckinA1 = new javax.swing.JRadioButton();
        PaymentMethodCheckin1A1 = new javax.swing.JRadioButton();
        PaymentMethodCheckin2A2 = new javax.swing.JRadioButton();
        PaymentMethodCheckin2A3 = new javax.swing.JRadioButton();
        OnlinePaymentChooseA1 = new javax.swing.JPanel();
        GcashOptionA1 = new javax.swing.JRadioButton();
        PaymayaOptionA1 = new javax.swing.JRadioButton();
        CheckInGuestNameA1 = new javax.swing.JTextField();
        CheckInGuestAddressA1 = new javax.swing.JTextField();
        TotalAmountA1Checkin = new javax.swing.JTextField();
        CheckInGuestAddressA8 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        MaxDaysCheckinA1 = new javax.swing.JTextField();
        RoomPriceA1 = new javax.swing.JLabel();
        RoomPriceA2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        AddressLabel = new javax.swing.JLabel();
        DesignCheckin1 = new javax.swing.JLabel();
        CheckInGuestAddressA4 = new javax.swing.JLabel();
        CheckInGuestAddressA7 = new javax.swing.JLabel();
        LabelCheckinA1 = new javax.swing.JLabel();
        CheckInGuestAddressA6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        MainPanelBook1 = new javax.swing.JLabel();
        MainPanelBook2 = new javax.swing.JLabel();
        Background5 = new javax.swing.JLabel();
        CheckInGuestAddressA9 = new javax.swing.JLabel();
        LoginSystemPanel = new javax.swing.JPanel();
        ExitMessageWindowz = new javax.swing.JPanel();
        ExitMessageMainWindow = new javax.swing.JPanel();
        ExitButtonLogin = new javax.swing.JButton();
        ContinueButtonLogin = new javax.swing.JButton();
        jTextArea4 = new javax.swing.JTextArea();
        ExitMessageWindow = new javax.swing.JLabel();
        RegisterFormWindow = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        ExitLoginButton2 = new javax.swing.JButton();
        NumberSignUpInput = new javax.swing.JTextField();
        EmailAddressSignUpInput = new javax.swing.JTextField();
        UsernameSignUpInput = new javax.swing.JTextField();
        PasswordSignUpInput = new javax.swing.JPasswordField();
        SignUpButton1 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        GOSigninWindowButton = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        Background10 = new javax.swing.JLabel();
        Background8 = new javax.swing.JLabel();
        LoginFormWindow = new javax.swing.JPanel();
        ExitLoginButton3 = new javax.swing.JButton();
        jLabel108 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        PasswordSigninInput1 = new javax.swing.JPasswordField();
        UsernameSigninInput1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        SignInButton1 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        SignInButton2 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        Background6 = new javax.swing.JLabel();
        Background7 = new javax.swing.JLabel();
        Background3 = new javax.swing.JLabel();
        Background4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuButtonsPanels.setBackground(new java.awt.Color(225, 225, 225));
        MenuButtonsPanels.setOpaque(false);
        MenuButtonsPanels.setPreferredSize(new java.awt.Dimension(500, 300));
        MenuButtonsPanels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserNameGreetings.setBackground(new java.awt.Color(255, 255, 255));
        UserNameGreetings.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        UserNameGreetings.setForeground(new java.awt.Color(255, 255, 255));
        UserNameGreetings.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        UserNameGreetings.setText("Please Log in");
        MenuButtonsPanels.add(UserNameGreetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 150, 20));

        ViewHotelFeatureButton.setBackground(new java.awt.Color(203, 193, 155));
        ViewHotelFeatureButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ViewHotelFeatureButton.setForeground(new java.awt.Color(255, 255, 255));
        ViewHotelFeatureButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PirsonIcon.png"))); // NOI18N
        ViewHotelFeatureButton.setBorder(null);
        ViewHotelFeatureButton.setBorderPainted(false);
        ViewHotelFeatureButton.setDefaultCapable(false);
        ViewHotelFeatureButton.setFocusPainted(false);
        ViewHotelFeatureButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ViewHotelFeatureButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewHotelFeatureButton.setRolloverEnabled(false);
        ViewHotelFeatureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewHotelFeatureButtonActionPerformed(evt);
            }
        });
        MenuButtonsPanels.add(ViewHotelFeatureButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 40, 40));

        RoomSectionButtion.setBackground(new java.awt.Color(203, 193, 155));
        RoomSectionButtion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        RoomSectionButtion.setForeground(new java.awt.Color(255, 255, 255));
        RoomSectionButtion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/RoomIcon.png"))); // NOI18N
        RoomSectionButtion.setBorder(null);
        RoomSectionButtion.setBorderPainted(false);
        RoomSectionButtion.setDefaultCapable(false);
        RoomSectionButtion.setFocusPainted(false);
        RoomSectionButtion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RoomSectionButtion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RoomSectionButtion.setOpaque(true);
        RoomSectionButtion.setRolloverEnabled(false);
        RoomSectionButtion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSectionButtionActionPerformed(evt);
            }
        });
        MenuButtonsPanels.add(RoomSectionButtion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 40, 40));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Welcome to Auqeza");
        MenuButtonsPanels.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 150, 20));

        CompanyNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        CompanyNameLabel.setFont(new java.awt.Font("Georgia", 1, 23)); // NOI18N
        CompanyNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        CompanyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanyNameLabel.setText("Auqeza Suites");
        CompanyNameLabel.setPreferredSize(new java.awt.Dimension(160, 28));
        MenuButtonsPanels.add(CompanyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        ViewHotelFeatureButton1.setBackground(new java.awt.Color(203, 193, 155));
        ViewHotelFeatureButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ViewHotelFeatureButton1.setForeground(new java.awt.Color(255, 255, 255));
        ViewHotelFeatureButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PirsonIcon.png"))); // NOI18N
        ViewHotelFeatureButton1.setBorder(null);
        ViewHotelFeatureButton1.setBorderPainted(false);
        ViewHotelFeatureButton1.setDefaultCapable(false);
        ViewHotelFeatureButton1.setFocusPainted(false);
        ViewHotelFeatureButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ViewHotelFeatureButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewHotelFeatureButton1.setRolloverEnabled(false);
        ViewHotelFeatureButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewHotelFeatureButton1ActionPerformed(evt);
            }
        });
        MenuButtonsPanels.add(ViewHotelFeatureButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 40, 40));

        getContentPane().add(MenuButtonsPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 10, 600, 40));

        HotelFeaturesPanels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Slide1.setBackground(new java.awt.Color(255, 255, 255));
        Slide1.setOpaque(false);
        Slide1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextIntro1.setBackground(new java.awt.Color(255, 255, 255));
        TextIntro1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        TextIntro1.setForeground(new java.awt.Color(255, 255, 255));
        TextIntro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextIntro1.setText("Explore");
        TextIntro1.setPreferredSize(new java.awt.Dimension(400, 75));
        Slide1.add(TextIntro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 75, 600, 30));

        TextIntroA1.setBackground(new java.awt.Color(255, 255, 255));
        TextIntroA1.setFont(new java.awt.Font("Times New Roman", 0, 54)); // NOI18N
        TextIntroA1.setForeground(new java.awt.Color(255, 255, 255));
        TextIntroA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextIntroA1.setText("Aqueza Features");
        TextIntroA1.setPreferredSize(new java.awt.Dimension(400, 75));
        Slide1.add(TextIntroA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 610, -1));

        DesignA1.setBackground(new java.awt.Color(255, 255, 255));
        DesignA1.setPreferredSize(new java.awt.Dimension(30, 3));

        javax.swing.GroupLayout DesignA1Layout = new javax.swing.GroupLayout(DesignA1);
        DesignA1.setLayout(DesignA1Layout);
        DesignA1Layout.setHorizontalGroup(
            DesignA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        DesignA1Layout.setVerticalGroup(
            DesignA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Slide1.add(DesignA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 175, -1, -1));

        DescIntro1.setEditable(false);
        DescIntro1.setColumns(20);
        DescIntro1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        DescIntro1.setForeground(new java.awt.Color(255, 255, 255));
        DescIntro1.setRows(5);
        DescIntro1.setText("     Welcome to Aqueza Features Hotel, where luxury meets tranquility. \n    Located in the heart of the city, we offer an unforgettable experience \n          with exceptional service and sophisticated accommodations, \n                             perfect for both business and leisure.");
        DescIntro1.setWrapStyleWord(true);
        DescIntro1.setBorder(null);
        DescIntro1.setFocusable(false);
        DescIntro1.setOpaque(false);
        DescIntro1.setPreferredSize(new java.awt.Dimension(300, 100));
        Slide1.add(DescIntro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 440, 80));

        ShowButtonA1.setBackground(new java.awt.Color(124, 119, 92));
        ShowButtonA1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ShowButtonA1.setForeground(new java.awt.Color(255, 255, 255));
        ShowButtonA1.setText("Show Features");
        ShowButtonA1.setBorder(null);
        ShowButtonA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowButtonA1ActionPerformed(evt);
            }
        });
        Slide1.add(ShowButtonA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 220, 40));

        HotelFeaturesPanels.add(Slide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 440));

        Slide2.setBackground(new java.awt.Color(255, 255, 255));
        Slide2.setForeground(new java.awt.Color(225, 225, 225));
        Slide2.setOpaque(false);
        Slide2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Feature1.setBackground(new java.awt.Color(255, 255, 255));
        Feature1.setPreferredSize(new java.awt.Dimension(365, 75));
        Feature1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FeatureA1.setBackground(new java.awt.Color(255, 255, 255));
        FeatureA1.setPreferredSize(new java.awt.Dimension(365, 75));
        FeatureA1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 0, 0));
        jLabel109.setText("A Elegant Dining Area");
        FeatureA1.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        jLabel126.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setText("Dining Area");
        FeatureA1.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 30));

        FeatureButton5.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButton5.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButton5.setText("See details");
        FeatureButton5.setBorder(null);
        FeatureButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButton5ActionPerformed(evt);
            }
        });
        FeatureA1.add(FeatureButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 17, 120, 30));

        Feature1.add(FeatureA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 358, 68));

        FeatureB1.setBackground(new java.awt.Color(255, 255, 255));
        FeatureB1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(147, 141, 71));
        jLabel1.setText("An Elegant Dining Area");
        FeatureB1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 30));

        jLabel33.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Luxury Dining Area");
        FeatureB1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 370, 60));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Indulge in elegance at our luxurious dining area, where exquisite décor meets world-class cuisine. With ambient lighting, plush seating, and personalized service, every meal becomes a refined culinary experience in a sophisticated setting.");
        jTextArea1.setWrapStyleWord(true);
        FeatureB1.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 350, 100));

        FeatureButtonA1.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButtonA1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButtonA1.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButtonA1.setText("Exit");
        FeatureButtonA1.setBorder(null);
        FeatureButtonA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButtonA1ActionPerformed(evt);
            }
        });
        FeatureB1.add(FeatureButtonA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 260, 30));

        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HotelFeaturesImages/DiningAreaB.png"))); // NOI18N
        jLabel127.setText("jLabel127");
        jLabel127.setPreferredSize(new java.awt.Dimension(340, 340));
        FeatureB1.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        Feature1.add(FeatureB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 838, 338));

        Slide2.add(Feature1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 40, -1, -1));

        Feature2.setBackground(new java.awt.Color(255, 255, 255));
        Feature2.setPreferredSize(new java.awt.Dimension(365, 75));
        Feature2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FeatureA2.setBackground(new java.awt.Color(255, 255, 255));
        FeatureA2.setPreferredSize(new java.awt.Dimension(365, 75));
        FeatureA2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Best Gym in Aqueza Suites");
        FeatureA2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        jLabel102.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 0, 0));
        jLabel102.setText("Gym Area");
        jLabel102.setName(""); // NOI18N
        FeatureA2.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 30));

        FeatureButton2.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButton2.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButton2.setText("See details");
        FeatureButton2.setBorder(null);
        FeatureButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButton2ActionPerformed(evt);
            }
        });
        FeatureA2.add(FeatureButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 17, 120, 30));

        Feature2.add(FeatureA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 5, 358, 68));

        FeatureB2.setBackground(new java.awt.Color(255, 255, 255));
        FeatureB2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(147, 141, 71));
        jLabel128.setText("Best Gym in Aqueza Suites");
        FeatureB2.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 30));

        jLabel129.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 0, 0));
        jLabel129.setText("Luxury Gym Area");
        FeatureB2.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 370, 60));

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("The hotel gym offers a clean, modern space for guests to continue their workout routines while traveling. Designed to accommodate both beginners and fitness enthusiasts, the gym is equipped with a range of equipment for cardio, strength, and flexibility training.\n\n");
        jTextArea3.setWrapStyleWord(true);
        FeatureB2.add(jTextArea3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 350, 110));

        FeatureButtonA2.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButtonA2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButtonA2.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButtonA2.setText("Exit");
        FeatureButtonA2.setBorder(null);
        FeatureButtonA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButtonA2ActionPerformed(evt);
            }
        });
        FeatureB2.add(FeatureButtonA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 260, 30));

        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HotelFeaturesImages/GymAreaB.png"))); // NOI18N
        jLabel134.setText("jLabel127");
        jLabel134.setPreferredSize(new java.awt.Dimension(340, 340));
        FeatureB2.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        Feature2.add(FeatureB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 838, 338));

        Slide2.add(Feature2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        Feature3.setBackground(new java.awt.Color(255, 255, 255));
        Feature3.setPreferredSize(new java.awt.Dimension(365, 75));
        Feature3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FeatureA3.setBackground(new java.awt.Color(255, 255, 255));
        FeatureA3.setPreferredSize(new java.awt.Dimension(365, 75));
        FeatureA3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 0, 0));
        jLabel103.setText("Big Pool in Aqueza Suites");
        FeatureA3.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        jLabel105.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 0, 0));
        jLabel105.setText("Pool Area");
        FeatureA3.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 30));

        FeatureButton3.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButton3.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButton3.setText("See details");
        FeatureButton3.setBorder(null);
        FeatureButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButton3ActionPerformed(evt);
            }
        });
        FeatureA3.add(FeatureButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 17, 120, 30));

        Feature3.add(FeatureA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 6, 358, 68));

        FeatureB3.setBackground(new java.awt.Color(255, 255, 255));
        FeatureB3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(147, 141, 71));
        jLabel130.setText("Biggest Pool in Aqueza Suites");
        FeatureB3.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 30));

        jLabel131.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 0, 0));
        jLabel131.setText("Luxury Pool Area");
        FeatureB3.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 370, 60));

        jTextArea6.setEditable(false);
        jTextArea6.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jTextArea6.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setText("The Aqueza's swimming pool offers a refreshing retreat for guests of all ages. Designed for both relaxation and recreation, the pool area features crystal-clear water, comfortable lounge seating, and a serene atmosphere. Whether you want to take a morning dip, sunbathe by the poolside, or simply unwind, it’s the perfect spot to relax during your stay.");
        jTextArea6.setWrapStyleWord(true);
        FeatureB3.add(jTextArea6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 400, 150));

        FeatureButtonA4.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButtonA4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButtonA4.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButtonA4.setText("Exit");
        FeatureButtonA4.setBorder(null);
        FeatureButtonA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButtonA4ActionPerformed(evt);
            }
        });
        FeatureB3.add(FeatureButtonA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 260, 30));

        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HotelFeaturesImages/PoolAreaB.png"))); // NOI18N
        jLabel138.setText("jLabel127");
        jLabel138.setPreferredSize(new java.awt.Dimension(340, 340));
        FeatureB3.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        Feature3.add(FeatureB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 838, 338));

        Slide2.add(Feature3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 220, -1, -1));

        Feature4.setBackground(new java.awt.Color(255, 255, 255));
        Feature4.setPreferredSize(new java.awt.Dimension(365, 75));
        Feature4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FeatureA4.setBackground(new java.awt.Color(255, 255, 255));
        FeatureA4.setPreferredSize(new java.awt.Dimension(365, 75));
        FeatureA4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jLabel106.setText("Confortable Spa Area");
        FeatureA4.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        jLabel107.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setText("Spa Area");
        FeatureA4.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 30));

        FeatureButton4.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButton4.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButton4.setText("See details");
        FeatureButton4.setBorder(null);
        FeatureButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButton4ActionPerformed(evt);
            }
        });
        FeatureA4.add(FeatureButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 17, 120, 30));

        Feature4.add(FeatureA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 5, 356, 68));

        FeatureB4.setBackground(new java.awt.Color(255, 255, 255));
        FeatureB4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(147, 141, 71));
        jLabel132.setText("Comfortable Spa Area");
        FeatureB4.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 30));

        jLabel133.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(0, 0, 0));
        jLabel133.setText("Luxury Spa Area");
        FeatureB4.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 370, 60));

        jTextArea13.setEditable(false);
        jTextArea13.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea13.setColumns(20);
        jTextArea13.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jTextArea13.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea13.setLineWrap(true);
        jTextArea13.setRows(5);
        jTextArea13.setText("The Aqueza's Hotel spa provides a tranquil escape where guests can rejuvenate their body and mind. With a range of services including massages, facials, and body treatments, the spa blends luxury and relaxation in a serene environment. Soothing aromas, calming music, and skilled therapists ensure a peaceful experience designed for ultimate wellness.");
        jTextArea13.setWrapStyleWord(true);
        FeatureB4.add(jTextArea13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 400, 150));

        FeatureButtonA5.setBackground(new java.awt.Color(169, 158, 105));
        FeatureButtonA5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        FeatureButtonA5.setForeground(new java.awt.Color(255, 255, 255));
        FeatureButtonA5.setText("Exit");
        FeatureButtonA5.setBorder(null);
        FeatureButtonA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureButtonA5ActionPerformed(evt);
            }
        });
        FeatureB4.add(FeatureButtonA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 260, 30));

        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HotelFeaturesImages/PoolAreaB.png"))); // NOI18N
        jLabel139.setText("jLabel127");
        jLabel139.setPreferredSize(new java.awt.Dimension(340, 340));
        FeatureB4.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        Feature4.add(FeatureB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 838, 338));

        Slide2.add(Feature4, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 310, -1, -1));

        TextIntroA2.setBackground(new java.awt.Color(255, 255, 255));
        TextIntroA2.setFont(new java.awt.Font("Times New Roman", 0, 54)); // NOI18N
        TextIntroA2.setForeground(new java.awt.Color(255, 255, 255));
        TextIntroA2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TextIntroA2.setText("Aqueza Features");
        TextIntroA2.setPreferredSize(new java.awt.Dimension(400, 75));
        Slide2.add(TextIntroA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 430, -1));

        TextIntroA3.setBackground(new java.awt.Color(255, 255, 255));
        TextIntroA3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TextIntroA3.setForeground(new java.awt.Color(255, 255, 255));
        TextIntroA3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TextIntroA3.setText("Explore Aqueza Physical Features!");
        TextIntroA3.setPreferredSize(new java.awt.Dimension(400, 75));
        Slide2.add(TextIntroA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 430, 30));

        Picture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HotelFeaturesImages/Assist.jpg"))); // NOI18N
        Slide2.add(Picture, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 490, 500));

        HotelFeaturesPanels.add(Slide2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, 440));

        Background9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View None.jpg"))); // NOI18N
        Background9.setPreferredSize(new java.awt.Dimension(1000, 500));
        HotelFeaturesPanels.add(Background9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        getContentPane().add(HotelFeaturesPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        AccountInfoPanel.setBackground(new java.awt.Color(203, 189, 157));
        AccountInfoPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        AccountInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PhonenumberInfo.setBackground(new java.awt.Color(255, 255, 255));
        PhonenumberInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PhonenumberInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PhonenumberInfo.setText("Phone number:");
        PhonenumberInfo.setPreferredSize(new java.awt.Dimension(420, 35));
        AccountInfoPanel.add(PhonenumberInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 220, 435, -1));

        AccountInfoPanel2.setBackground(new java.awt.Color(255, 255, 255));
        AccountInfoPanel2.setPreferredSize(new java.awt.Dimension(50, 3));
        AccountInfoPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AccountInfoPanel.add(AccountInfoPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        AccountInfoPanel1.setBackground(new java.awt.Color(255, 255, 255));
        AccountInfoPanel1.setPreferredSize(new java.awt.Dimension(50, 3));
        AccountInfoPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AccountInfoPanel.add(AccountInfoPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        RefundButton.setBackground(new java.awt.Color(255, 0, 0));
        RefundButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RefundButton.setText("Cancel/Refund");
        RefundButton.setBorder(null);
        RefundButton.setBorderPainted(false);
        RefundButton.setFocusPainted(false);
        RefundButton.setPreferredSize(new java.awt.Dimension(350, 35));
        RefundButton.setRolloverEnabled(false);
        RefundButton.setVerifyInputWhenFocusTarget(false);
        RefundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefundButtonActionPerformed(evt);
            }
        });
        AccountInfoPanel.add(RefundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 425, -1, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Total Price");
        jLabel35.setPreferredSize(new java.awt.Dimension(500, 50));
        AccountInfoPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 210, 30));

        jLabel36.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Account Info");
        jLabel36.setPreferredSize(new java.awt.Dimension(500, 50));
        AccountInfoPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 170, 40));

        UsernameInfo.setBackground(new java.awt.Color(255, 255, 255));
        UsernameInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UsernameInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UsernameInfo.setText("Username");
        UsernameInfo.setPreferredSize(new java.awt.Dimension(420, 35));
        AccountInfoPanel.add(UsernameInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 120, 435, -1));

        EmailaddressInfo1.setBackground(new java.awt.Color(255, 255, 255));
        EmailaddressInfo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EmailaddressInfo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EmailaddressInfo1.setText("Email Address:");
        EmailaddressInfo1.setPreferredSize(new java.awt.Dimension(420, 35));
        AccountInfoPanel.add(EmailaddressInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 170, 435, -1));

        AddressInfo.setBackground(new java.awt.Color(255, 255, 255));
        AddressInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddressInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AddressInfo.setText("Address: ");
        AddressInfo.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(AddressInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 430, -1));

        GuestNameInfo1.setBackground(new java.awt.Color(255, 255, 255));
        GuestNameInfo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        GuestNameInfo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GuestNameInfo1.setText("Guest Name :");
        GuestNameInfo1.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(GuestNameInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 430, -1));

        TotalpriceInfo.setBackground(new java.awt.Color(255, 255, 255));
        TotalpriceInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TotalpriceInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalpriceInfo.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(TotalpriceInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 265, 210, -1));

        PaymentmethodInfo.setBackground(new java.awt.Color(255, 255, 255));
        PaymentmethodInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PaymentmethodInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PaymentmethodInfo.setText("Payment Method:");
        PaymentmethodInfo.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(PaymentmethodInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 430, -1));

        RoompriceInfo.setBackground(new java.awt.Color(255, 255, 255));
        RoompriceInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RoompriceInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RoompriceInfo.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(RoompriceInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 265, 210, -1));

        jLabel57.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Book Info");
        jLabel57.setPreferredSize(new java.awt.Dimension(450, 50));
        AccountInfoPanel.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 160, 40));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Room Price");
        jLabel59.setPreferredSize(new java.awt.Dimension(500, 50));
        AccountInfoPanel.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 210, 30));

        jLabel100.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Booking Schedule");
        jLabel100.setPreferredSize(new java.awt.Dimension(500, 50));
        AccountInfoPanel.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 305, 210, 30));

        BookingschedInfo.setBackground(new java.awt.Color(255, 255, 255));
        BookingschedInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookingschedInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookingschedInfo.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(BookingschedInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 335, 210, -1));

        jLabel101.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("Payment Status");
        jLabel101.setPreferredSize(new java.awt.Dimension(500, 50));
        AccountInfoPanel.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 305, 210, 30));

        PaymentstatusInfo.setBackground(new java.awt.Color(255, 255, 255));
        PaymentstatusInfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PaymentstatusInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PaymentstatusInfo.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(PaymentstatusInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 335, 210, -1));

        RoomtypeInfo2.setBackground(new java.awt.Color(255, 255, 255));
        RoomtypeInfo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RoomtypeInfo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RoomtypeInfo2.setText("Room Type:");
        RoomtypeInfo2.setPreferredSize(new java.awt.Dimension(450, 35));
        AccountInfoPanel.add(RoomtypeInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 145, 430, -1));

        MainInfoBackgroundPanel3.setBackground(new java.awt.Color(229, 229, 229));
        MainInfoBackgroundPanel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MainInfoBackgroundPanel3.setPreferredSize(new java.awt.Dimension(450, 450));
        AccountInfoPanel.add(MainInfoBackgroundPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 55, -1, 420));

        MainInfoBackgroundPanel2.setBackground(new java.awt.Color(229, 229, 229));
        MainInfoBackgroundPanel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MainInfoBackgroundPanel2.setPreferredSize(new java.awt.Dimension(450, 450));
        AccountInfoPanel.add(MainInfoBackgroundPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 55, -1, 420));

        MainInfoBackgroundPanel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MainInfoBackgroundPanel1.setOpaque(true);
        MainInfoBackgroundPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));
        AccountInfoPanel.add(MainInfoBackgroundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(AccountInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RoomSectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1000, 460));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(998, 1050));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RoomBSelectionPanel2.setBackground(new java.awt.Color(255, 255, 255));
        RoomBSelectionPanel2.setOpaque(false);
        RoomBSelectionPanel2.setPreferredSize(new java.awt.Dimension(900, 300));
        RoomBSelectionPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RoomB1S1.setBackground(new java.awt.Color(255, 255, 255));
        RoomB1S1.setOpaque(false);
        RoomB1S1.setPreferredSize(new java.awt.Dimension(550, 220));
        RoomB1S1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setBackground(new java.awt.Color(238, 236, 200));
        jLabel46.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(161, 147, 119));
        jLabel46.setText("  1-8 Capacity/Pax");
        jLabel46.setPreferredSize(new java.awt.Dimension(250, 25));
        RoomB1S1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 95, -1, -1));

        RoomB1Button1.setBackground(new java.awt.Color(228, 223, 192));
        RoomB1Button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomB1Button1.setForeground(new java.awt.Color(125, 109, 69));
        RoomB1Button1.setText("See room info");
        RoomB1Button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomB1Button1.setBorderPainted(false);
        RoomB1Button1.setFocusable(false);
        RoomB1Button1.setOpaque(true);
        RoomB1Button1.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomB1Button1.setRequestFocusEnabled(false);
        RoomB1Button1.setRolloverEnabled(false);
        RoomB1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomB1Button1ActionPerformed(evt);
            }
        });
        RoomB1S1.add(RoomB1Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 30));

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(161, 147, 119));
        jLabel38.setText("3 rooms Available");
        RoomB1S1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 125, 200, 20));

        jLabel39.setBackground(new java.awt.Color(238, 236, 200));
        jLabel39.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(161, 147, 119));
        jLabel39.setText("VIP Room");
        RoomB1S1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 200, 30));

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(161, 147, 119));
        jLabel40.setText("₱ 40,499 night/₱ 50,499 day");
        RoomB1S1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 220, 20));

        RoomC1Pic.setOpaque(false);
        RoomC1Pic.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/VIPRoom2 - Copy.png"))); // NOI18N
        jLabel37.setPreferredSize(new java.awt.Dimension(400, 200));

        javax.swing.GroupLayout RoomC1PicLayout = new javax.swing.GroupLayout(RoomC1Pic);
        RoomC1Pic.setLayout(RoomC1PicLayout);
        RoomC1PicLayout.setHorizontalGroup(
            RoomC1PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(RoomC1PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomC1PicLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        RoomC1PicLayout.setVerticalGroup(
            RoomC1PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(RoomC1PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RoomC1PicLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        RoomB1S1.add(RoomC1Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        RoomBSelectionPanel2.add(RoomB1S1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jLabel41.setBackground(new java.awt.Color(238, 236, 200));
        jLabel41.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(238, 236, 200));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("VIP (Exclusive)");
        RoomBSelectionPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 10, 820, 40));

        jPanel1.add(RoomBSelectionPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 975, -1));

        RoomBSelectionPanel1.setBackground(new java.awt.Color(255, 255, 255));
        RoomBSelectionPanel1.setOpaque(false);
        RoomBSelectionPanel1.setPreferredSize(new java.awt.Dimension(960, 300));
        RoomBSelectionPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RoomB2S.setBackground(new java.awt.Color(255, 255, 255));
        RoomB2S.setOpaque(false);
        RoomB2S.setPreferredSize(new java.awt.Dimension(450, 220));
        RoomB2S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setBackground(new java.awt.Color(238, 236, 200));
        jLabel42.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(161, 147, 119));
        jLabel42.setText("  4-6 Capacity/Pax");
        jLabel42.setPreferredSize(new java.awt.Dimension(250, 25));
        RoomB2S.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 230, -1));

        RoomB2Button.setBackground(new java.awt.Color(228, 223, 192));
        RoomB2Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomB2Button.setForeground(new java.awt.Color(125, 109, 69));
        RoomB2Button.setText("See room info");
        RoomB2Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomB2Button.setBorderPainted(false);
        RoomB2Button.setFocusable(false);
        RoomB2Button.setOpaque(true);
        RoomB2Button.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomB2Button.setRolloverEnabled(false);
        RoomB2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomB2ButtonActionPerformed(evt);
            }
        });
        RoomB2S.add(RoomB2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 200, 30));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(161, 147, 119));
        jLabel17.setText("3 rooms Available");
        RoomB2S.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 220, 20));

        jLabel18.setBackground(new java.awt.Color(238, 236, 200));
        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(161, 147, 119));
        jLabel18.setText("Family Room B");
        RoomB2S.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 230, 30));

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(161, 147, 119));
        jLabel27.setText("₱ 17,499 night/₱ 18,499 day");
        RoomB2S.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 230, 20));

        RoomB2Pic.setOpaque(false);
        RoomB2Pic.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/FamilyRoom2 - Copy.jpg"))); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(400, 200));

        javax.swing.GroupLayout RoomB2PicLayout = new javax.swing.GroupLayout(RoomB2Pic);
        RoomB2Pic.setLayout(RoomB2PicLayout);
        RoomB2PicLayout.setHorizontalGroup(
            RoomB2PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomB2PicLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        RoomB2PicLayout.setVerticalGroup(
            RoomB2PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomB2PicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomB2S.add(RoomB2Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        RoomBSelectionPanel1.add(RoomB2S, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        RoomB1S.setBackground(new java.awt.Color(255, 255, 255));
        RoomB1S.setOpaque(false);
        RoomB1S.setPreferredSize(new java.awt.Dimension(450, 300));
        RoomB1S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setBackground(new java.awt.Color(238, 236, 200));
        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(161, 147, 119));
        jLabel32.setText("  4 Capacity/Pax");
        jLabel32.setPreferredSize(new java.awt.Dimension(250, 25));
        RoomB1S.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 230, -1));

        RoomB1Button.setBackground(new java.awt.Color(228, 223, 192));
        RoomB1Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomB1Button.setForeground(new java.awt.Color(125, 109, 69));
        RoomB1Button.setText("See room info");
        RoomB1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomB1Button.setBorderPainted(false);
        RoomB1Button.setFocusable(false);
        RoomB1Button.setOpaque(true);
        RoomB1Button.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomB1Button.setRequestFocusEnabled(false);
        RoomB1Button.setRolloverEnabled(false);
        RoomB1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomB1ButtonActionPerformed(evt);
            }
        });
        RoomB1S.add(RoomB1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 200, 30));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(161, 147, 119));
        jLabel20.setText("3 rooms Available");
        RoomB1S.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 200, 20));

        jLabel21.setBackground(new java.awt.Color(238, 236, 200));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(161, 147, 119));
        jLabel21.setText("Family Room A");
        RoomB1S.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 230, 30));

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(161, 147, 119));
        jLabel28.setText("₱ 15,499 night/₱ 16,499 day");
        RoomB1S.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 230, 20));

        RoomB1Pic.setOpaque(false);
        RoomB1Pic.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/FamilyRoom1 - Copy.jpg"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(350, 200));

        javax.swing.GroupLayout RoomB1PicLayout = new javax.swing.GroupLayout(RoomB1Pic);
        RoomB1Pic.setLayout(RoomB1PicLayout);
        RoomB1PicLayout.setHorizontalGroup(
            RoomB1PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomB1PicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        RoomB1PicLayout.setVerticalGroup(
            RoomB1PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoomB1PicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        RoomB1S.add(RoomB1Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        RoomBSelectionPanel1.add(RoomB1S, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 220));

        jLabel22.setBackground(new java.awt.Color(238, 236, 200));
        jLabel22.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(238, 236, 200));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Family Class Rooms");
        RoomBSelectionPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 820, 40));

        jPanel1.add(RoomBSelectionPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 975, -1));
        RoomBSelectionPanel1.getAccessibleContext().setAccessibleDescription("");

        RoomASelectionPanel.setBackground(new java.awt.Color(255, 255, 255));
        RoomASelectionPanel.setOpaque(false);
        RoomASelectionPanel.setPreferredSize(new java.awt.Dimension(940, 300));
        RoomASelectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RoomA2S.setBackground(new java.awt.Color(255, 255, 255));
        RoomA2S.setOpaque(false);
        RoomA2S.setPreferredSize(new java.awt.Dimension(450, 220));
        RoomA2S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(238, 236, 200));
        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(161, 147, 119));
        jLabel30.setText("  2-4 Capacity/Pax");
        jLabel30.setPreferredSize(new java.awt.Dimension(250, 25));
        RoomA2S.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 190, 20));

        RoomA1Button1.setBackground(new java.awt.Color(228, 223, 192));
        RoomA1Button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomA1Button1.setForeground(new java.awt.Color(125, 109, 69));
        RoomA1Button1.setText("See room info");
        RoomA1Button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomA1Button1.setBorderPainted(false);
        RoomA1Button1.setDefaultCapable(false);
        RoomA1Button1.setFocusPainted(false);
        RoomA1Button1.setFocusable(false);
        RoomA1Button1.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomA1Button1.setVerifyInputWhenFocusTarget(false);
        RoomA1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomA1Button1ActionPerformed(evt);
            }
        });
        RoomA2S.add(RoomA1Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 200, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(161, 147, 119));
        jLabel6.setText("3 rooms Available");
        RoomA2S.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 190, 20));

        jLabel7.setBackground(new java.awt.Color(238, 236, 200));
        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(161, 147, 119));
        jLabel7.setText("Double Class A");
        RoomA2S.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 210, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(161, 147, 119));
        jLabel24.setText("₱ 9,499 night / ₱ 10,499 day");
        RoomA2S.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 220, 20));

        RoomA2Pic.setOpaque(false);
        RoomA2Pic.setPreferredSize(new java.awt.Dimension(200, 200));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/DoubleClassA - Copy.jpg"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(2, 200));

        javax.swing.GroupLayout RoomA2PicLayout = new javax.swing.GroupLayout(RoomA2Pic);
        RoomA2Pic.setLayout(RoomA2PicLayout);
        RoomA2PicLayout.setHorizontalGroup(
            RoomA2PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomA2PicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        RoomA2PicLayout.setVerticalGroup(
            RoomA2PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RoomA2PicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomA2S.add(RoomA2Pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        RoomASelectionPanel.add(RoomA2S, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        RoomA1S.setBackground(new java.awt.Color(255, 255, 255));
        RoomA1S.setOpaque(false);
        RoomA1S.setPreferredSize(new java.awt.Dimension(450, 220));
        RoomA1S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setBackground(new java.awt.Color(238, 236, 200));
        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(161, 147, 119));
        jLabel31.setText("  1 Capacity/Pax");
        jLabel31.setPreferredSize(new java.awt.Dimension(250, 25));
        RoomA1S.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(161, 147, 119));
        jLabel3.setText("3 rooms Available");
        RoomA1S.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel4.setBackground(new java.awt.Color(238, 236, 200));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(161, 147, 119));
        jLabel4.setText("Single Class A");
        RoomA1S.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(161, 147, 119));
        jLabel23.setText("₱ 7,499 night/₱ 8,499 day");
        RoomA1S.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        RoomA1Button.setBackground(new java.awt.Color(228, 223, 192));
        RoomA1Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomA1Button.setForeground(new java.awt.Color(125, 109, 69));
        RoomA1Button.setText("See room info");
        RoomA1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomA1Button.setBorderPainted(false);
        RoomA1Button.setDefaultCapable(false);
        RoomA1Button.setFocusPainted(false);
        RoomA1Button.setFocusable(false);
        RoomA1Button.setOpaque(true);
        RoomA1Button.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomA1Button.setRequestFocusEnabled(false);
        RoomA1Button.setRolloverEnabled(false);
        RoomA1Button.setVerifyInputWhenFocusTarget(false);
        RoomA1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomA1ButtonActionPerformed(evt);
            }
        });
        RoomA1S.add(RoomA1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 200, 30));

        RoomA1Pic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/SingleClassA - Copy.jpg"))); // NOI18N
        RoomA1Pic1.setPreferredSize(new java.awt.Dimension(200, 200));
        RoomA1S.add(RoomA1Pic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        RoomASelectionPanel.add(RoomA1S, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel11.setBackground(new java.awt.Color(238, 236, 200));
        jLabel11.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 236, 200));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Standard Class Rooms");
        RoomASelectionPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 5, 820, 40));

        jPanel1.add(RoomASelectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 975, -1));

        FeaturesText1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        FeaturesText1.setForeground(new java.awt.Color(161, 147, 119));
        FeaturesText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FeaturesText1.setText("Hotel Features");
        jPanel1.add(FeaturesText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 60));

        jScrollPane2.setViewportView(jPanel1);

        RoomSectionPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 450));

        Background.setBackground(new java.awt.Color(0, 0, 0));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background.setPreferredSize(new java.awt.Dimension(1000, 500));
        RoomSectionPanel.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(RoomSectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        MainPanel1.setEnabled(false);
        MainPanel1.setOpaque(false);
        MainPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(183, 163, 102));
        jPanel13.setPreferredSize(new java.awt.Dimension(1000, 75));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Anytime");
        jPanel13.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 35, 280, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Active Working Hours");
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 280, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Customer Support");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 280, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("- 87000");
        jPanel13.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 35, 280, 20));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/Clock_Icon - Copy.png"))); // NOI18N
        jPanel13.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/CustomerService_Icon - Copy.png"))); // NOI18N
        jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        MainPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 425, -1, -1));

        Decoration1.setPreferredSize(new java.awt.Dimension(3, 250));

        javax.swing.GroupLayout Decoration1Layout = new javax.swing.GroupLayout(Decoration1);
        Decoration1.setLayout(Decoration1Layout);
        Decoration1Layout.setHorizontalGroup(
            Decoration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        Decoration1Layout.setVerticalGroup(
            Decoration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        MainPanel1.add(Decoration1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 135, -1, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Modern rooms, top notch amenities,and breathtaking views for a perfect view.\n");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setAutoscrolls(false);
        jTextArea2.setBorder(null);
        jTextArea2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTextArea2.setDoubleBuffered(true);
        jTextArea2.setFocusable(false);
        jTextArea2.setOpaque(false);
        jTextArea2.setPreferredSize(new java.awt.Dimension(260, 100));
        MainPanel1.add(jTextArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, 110));

        jButton1.setBackground(new java.awt.Color(202, 184, 130));
        jButton1.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign In now");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        MainPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 180, 30));

        Title1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        Title1.setForeground(new java.awt.Color(248, 245, 222));
        Title1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title1.setText("Luxury Escape");
        Title1.setPreferredSize(new java.awt.Dimension(300, 50));
        MainPanel1.add(Title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 350, -1));

        CompanyTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CompanyTitle.setForeground(new java.awt.Color(248, 245, 222));
        CompanyTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanyTitle.setText("Hotel");
        CompanyTitle.setPreferredSize(new java.awt.Dimension(750, 50));
        MainPanel1.add(CompanyTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, 140, 10));

        CompanyTitle1.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        CompanyTitle1.setForeground(new java.awt.Color(248, 245, 222));
        CompanyTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CompanyTitle1.setText("Auqeza Suites");
        CompanyTitle1.setPreferredSize(new java.awt.Dimension(750, 50));
        MainPanel1.add(CompanyTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 140, -1));

        Logo.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        Logo.setForeground(new java.awt.Color(248, 245, 222));
        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/Logo1-removebg-preview - 40x40.png"))); // NOI18N
        Logo.setPreferredSize(new java.awt.Dimension(50, 50));
        MainPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 50));

        Background1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View None.jpg"))); // NOI18N
        Background1.setPreferredSize(new java.awt.Dimension(1000, 500));
        MainPanel1.add(Background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setPreferredSize(new java.awt.Dimension(1000, 500));
        MainPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Title2.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        Title2.setForeground(new java.awt.Color(248, 245, 222));
        Title2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title2.setText("Luxury Escape");
        Title2.setPreferredSize(new java.awt.Dimension(300, 50));
        MainPanel1.add(Title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        getContentPane().add(MainPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RoomInfoPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        RoomInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfoWindows.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindows.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindows.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitInfoButton.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        ExitInfoButton.setText("X");
        ExitInfoButton.setBorder(null);
        ExitInfoButton.setBorderPainted(false);
        ExitInfoButton.setFocusPainted(false);
        ExitInfoButton.setFocusable(false);
        ExitInfoButton.setPreferredSize(new java.awt.Dimension(250, 50));
        ExitInfoButton.setRolloverEnabled(false);
        ExitInfoButton.setVerifyInputWhenFocusTarget(false);
        ExitInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitInfoButtonActionPerformed(evt);
            }
        });
        InfoWindows.add(ExitInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 40, 40));

        InfoWindowA1.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindowA1.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindowA1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InfoRoomPics/SingleClassA.jpg"))); // NOI18N
        jLabel52.setPreferredSize(new java.awt.Dimension(400, 400));
        InfoWindowA1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTextArea7.setEditable(false);
        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jTextArea7.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea7.setLineWrap(true);
        jTextArea7.setRows(5);
        jTextArea7.setText("- Pax/Capacity: 2 guests\n- Bed Type: 1 queen bed\n- Amanities: free wifi, air conditioning, smart tv, \n- Private, bathroom with hot & cold shower,\n  complimentry toilets\n- Price per night: PHP 7,499\n- Price per day: PHP 8,499\n");
        jTextArea7.setFocusable(false);
        jTextArea7.setOpaque(false);
        InfoWindowA1.add(jTextArea7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 470, 200));

        jPanel4.setPreferredSize(new java.awt.Dimension(50, 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        InfoWindowA1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 100, -1, -1));

        jLabel51.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("SINGLE CLASS A");
        jLabel51.setToolTipText("");
        InfoWindowA1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 420, 40));

        BookButtonA1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BookButtonA1.setText("Book this room");
        BookButtonA1.setBorder(null);
        BookButtonA1.setFocusPainted(false);
        BookButtonA1.setFocusTraversalPolicyProvider(true);
        BookButtonA1.setFocusable(false);
        BookButtonA1.setPreferredSize(new java.awt.Dimension(250, 50));
        BookButtonA1.setRolloverEnabled(false);
        BookButtonA1.setVerifyInputWhenFocusTarget(false);
        BookButtonA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonA1ActionPerformed(evt);
            }
        });
        InfoWindowA1.add(BookButtonA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 400, 40));

        InfoWindows.add(InfoWindowA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        InfoWindowA2.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindowA2.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindowA2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InfoRoomPics/DoubleClassA.jpg"))); // NOI18N
        jLabel61.setPreferredSize(new java.awt.Dimension(400, 400));
        InfoWindowA2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTextArea10.setEditable(false);
        jTextArea10.setColumns(20);
        jTextArea10.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jTextArea10.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea10.setLineWrap(true);
        jTextArea10.setRows(5);
        jTextArea10.setText("- Pax/Capacity: 2-4 guests\n- Bed Type: 2 queen bed\n- Amanities: free wifi, air conditioning, smart tv, Private, bathroom with hot & cold shower,\n  complimentry toilets\n- Price per night: PHP 9,499\n- Price per day: PHP 10,499\n\n\n");
        jTextArea10.setFocusable(false);
        jTextArea10.setOpaque(false);
        InfoWindowA2.add(jTextArea10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 470, 200));

        jPanel10.setPreferredSize(new java.awt.Dimension(50, 3));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        InfoWindowA2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 100, -1, -1));

        jLabel62.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("DOUBLE CLASS A");
        jLabel62.setToolTipText("");
        InfoWindowA2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 420, 40));

        BookButtonA2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BookButtonA2.setText("Book this room");
        BookButtonA2.setBorder(null);
        BookButtonA2.setFocusPainted(false);
        BookButtonA2.setFocusTraversalPolicyProvider(true);
        BookButtonA2.setFocusable(false);
        BookButtonA2.setPreferredSize(new java.awt.Dimension(400, 40));
        BookButtonA2.setRolloverEnabled(false);
        BookButtonA2.setVerifyInputWhenFocusTarget(false);
        BookButtonA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonA2ActionPerformed(evt);
            }
        });
        InfoWindowA2.add(BookButtonA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        InfoWindows.add(InfoWindowA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        InfoWindowB1.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindowB1.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindowB1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InfoRoomPics/FamilyRoom1.jpg"))); // NOI18N
        jLabel53.setMinimumSize(new java.awt.Dimension(400, 365));
        jLabel53.setPreferredSize(new java.awt.Dimension(400, 400));
        InfoWindowB1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTextArea8.setEditable(false);
        jTextArea8.setColumns(20);
        jTextArea8.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jTextArea8.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea8.setLineWrap(true);
        jTextArea8.setRows(5);
        jTextArea8.setText("- Capacity/Pax: 4 guests\n- Bed Type: 2 Queen Beds\n- Amenities: Free WiFi, Air Conditioning, 50” Smart TV,  Living Area, Dining Table, Mini Bar, Private Balcony \n with City View, Complimentary Breakfast\n- Price per Night: PHP 15,499\n- Price per Day: PHP 16,499\n");
        jTextArea8.setFocusable(false);
        jTextArea8.setOpaque(false);
        InfoWindowB1.add(jTextArea8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 470, 200));

        jPanel6.setPreferredSize(new java.awt.Dimension(50, 3));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        InfoWindowB1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 100, -1, -1));

        jLabel54.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("FAMILY ROOM A");
        jLabel54.setToolTipText("");
        InfoWindowB1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 420, 40));

        BookButtonB1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BookButtonB1.setText("Book this room");
        BookButtonB1.setBorder(null);
        BookButtonB1.setFocusPainted(false);
        BookButtonB1.setFocusTraversalPolicyProvider(true);
        BookButtonB1.setFocusable(false);
        BookButtonB1.setPreferredSize(new java.awt.Dimension(400, 40));
        BookButtonB1.setRolloverEnabled(false);
        BookButtonB1.setVerifyInputWhenFocusTarget(false);
        BookButtonB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonB1ActionPerformed(evt);
            }
        });
        InfoWindowB1.add(BookButtonB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        InfoWindows.add(InfoWindowB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        InfoWindowB2.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindowB2.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindowB2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InfoRoomPics/FamilyRoom2.jpg"))); // NOI18N
        jLabel63.setPreferredSize(new java.awt.Dimension(400, 400));
        InfoWindowB2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTextArea11.setEditable(false);
        jTextArea11.setColumns(20);
        jTextArea11.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jTextArea11.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea11.setLineWrap(true);
        jTextArea11.setRows(5);
        jTextArea11.setText("- Capacity/Pax: 4-6 guests\n- Bed Type: 3 Queen Beds\n- Amenities: Free WiFi, Air Conditioning, 50” Smart TV,  Living Area, Dining Table, Mini Bar, Private Balcony \n with City View, Complimentary Breakfast\n- Price per Night: PHP 17,499\n- Price per Day: PHP 18,499\n");
        jTextArea11.setFocusable(false);
        jTextArea11.setOpaque(false);
        InfoWindowB2.add(jTextArea11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 470, 200));

        jPanel11.setPreferredSize(new java.awt.Dimension(50, 3));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        InfoWindowB2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 100, -1, -1));

        jLabel64.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("FAMILY ROOM B");
        jLabel64.setToolTipText("");
        InfoWindowB2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 420, 40));

        BookButtonB2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BookButtonB2.setText("Book this room");
        BookButtonB2.setBorder(null);
        BookButtonB2.setBorderPainted(false);
        BookButtonB2.setFocusPainted(false);
        BookButtonB2.setFocusTraversalPolicyProvider(true);
        BookButtonB2.setFocusable(false);
        BookButtonB2.setPreferredSize(new java.awt.Dimension(400, 40));
        BookButtonB2.setRolloverEnabled(false);
        BookButtonB2.setVerifyInputWhenFocusTarget(false);
        BookButtonB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonB2ActionPerformed(evt);
            }
        });
        InfoWindowB2.add(BookButtonB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        InfoWindows.add(InfoWindowB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        InfoWindowC1.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindowC1.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindowC1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InfoRoomPics/VIPRoom1.jpg"))); // NOI18N
        jLabel55.setMinimumSize(new java.awt.Dimension(400, 400));
        jLabel55.setPreferredSize(new java.awt.Dimension(400, 400));
        InfoWindowC1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTextArea9.setEditable(false);
        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jTextArea9.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea9.setLineWrap(true);
        jTextArea9.setRows(5);
        jTextArea9.setText("- Capacity/Pax: 1-8 guests\n- Bed Type: 1 King Beds, 2 Queen Beds\n- Amenities: Free Wifi, Air Conditioned, 65\" Smart TV,  Living Room, Dining Area, Kitchenette, Private Jacuzzi, Exclusive Lounge Access, Buffet Service\n Complimentary Breakfast\n- Price per Night: PHP 40,499\n- Price per Day: PHP 50,499");
        jTextArea9.setFocusable(false);
        jTextArea9.setOpaque(false);
        InfoWindowC1.add(jTextArea9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 470, 200));

        jPanel7.setBackground(new java.awt.Color(204, 204, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(50, 3));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        InfoWindowC1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 100, -1, -1));

        jLabel56.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("VIP 1");
        jLabel56.setToolTipText("");
        InfoWindowC1.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 420, 40));

        BookButtonC1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BookButtonC1.setText("Book this room");
        BookButtonC1.setBorder(null);
        BookButtonC1.setBorderPainted(false);
        BookButtonC1.setFocusPainted(false);
        BookButtonC1.setFocusTraversalPolicyProvider(true);
        BookButtonC1.setFocusable(false);
        BookButtonC1.setPreferredSize(new java.awt.Dimension(400, 40));
        BookButtonC1.setRolloverEnabled(false);
        BookButtonC1.setVerifyInputWhenFocusTarget(false);
        BookButtonC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonC1ActionPerformed(evt);
            }
        });
        InfoWindowC1.add(BookButtonC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        InfoWindows.add(InfoWindowC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        InfoWindowC2.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindowC2.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindowC2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InfoRoomPics/VIPRoom2.png"))); // NOI18N
        jLabel65.setPreferredSize(new java.awt.Dimension(400, 400));
        InfoWindowC2.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jTextArea12.setEditable(false);
        jTextArea12.setColumns(20);
        jTextArea12.setFont(new java.awt.Font("Mongolian Baiti", 1, 18)); // NOI18N
        jTextArea12.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea12.setLineWrap(true);
        jTextArea12.setRows(5);
        jTextArea12.setText("- Capacity/Pax: 1-10 guests.\n- Bed Type: 2 Queen Beds, 2 King Beds.\n- Amenities: Free Wifi, Air Conditioned, 65\" Smart TV,    Living Room, Dining Area, Kitchenette, Private Jacuzzi,  Exclusive Lounge Access, Buffet Service, Complimentary Breakfast.\n- 2 Guest Rooms.\n- Free Access: GYM, Pool.\n- Price per Night: PHP 55,499\n- Price per Day: PHP 60,499");
        jTextArea12.setFocusable(false);
        jTextArea12.setOpaque(false);
        InfoWindowC2.add(jTextArea12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 470, 250));

        jPanel12.setBackground(new java.awt.Color(204, 204, 0));
        jPanel12.setPreferredSize(new java.awt.Dimension(50, 3));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        InfoWindowC2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 100, -1, -1));

        jLabel66.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("VIP 2");
        jLabel66.setToolTipText("");
        InfoWindowC2.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 420, 40));

        BookButtonC2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BookButtonC2.setForeground(new java.awt.Color(255, 255, 255));
        BookButtonC2.setText("Book this room");
        BookButtonC2.setBorder(null);
        BookButtonC2.setContentAreaFilled(false);
        BookButtonC2.setFocusPainted(false);
        BookButtonC2.setFocusTraversalPolicyProvider(true);
        BookButtonC2.setFocusable(false);
        BookButtonC2.setPreferredSize(new java.awt.Dimension(250, 50));
        BookButtonC2.setRolloverEnabled(false);
        BookButtonC2.setVerifyInputWhenFocusTarget(false);
        InfoWindowC2.add(BookButtonC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        InfoWindows.add(InfoWindowC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        RoomInfoPanel.add(InfoWindows, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckInPayment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CheckinA1.setBackground(new java.awt.Color(255, 255, 255));
        CheckinA1.setPreferredSize(new java.awt.Dimension(1000, 500));
        CheckinA1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePaymentWindow1A1.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow1A1.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow1A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow1A1.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow1A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePayment2ndWindow1A1.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow1A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel71.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow1A1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel22.setBackground(new java.awt.Color(51, 51, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow1A1.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel23.setBackground(new java.awt.Color(51, 51, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Aqueza Suites");
        jLabel72.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel23.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel77.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Successfully Paid!");
        jLabel77.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel23.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow1A1.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel78.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(153, 153, 153));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("(Preview)");
        jLabel78.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A1.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcash1A2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcash1A2.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcash1A2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcash1A2.setText(" php 10000");
        PriceTextGcash1A2.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A1.add(PriceTextGcash1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA2.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA2.setText("09xxxxxxxx");
        AccountNameA2.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A1.add(AccountNameA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA2.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA2.setText("Exit");
        OnlinePaymentButton1GA2.setFocusable(false);
        OnlinePaymentButton1GA2.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA2.setRequestFocusEnabled(false);
        OnlinePaymentButton1GA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA2ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow1A1.add(OnlinePaymentButton1GA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel79.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(153, 153, 153));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("You Paid");
        jLabel79.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A1.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel80.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(153, 153, 153));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("using your GCash");
        jLabel80.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A1.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel81.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(153, 153, 153));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel81.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow1A1.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel82.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(153, 153, 153));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Account Number");
        jLabel82.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A1.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A1.add(OnlinePayment2ndWindow1A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow1A1.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow1A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePaymentMainWindow1A1.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow1A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel67.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow1A1.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel21.setBackground(new java.awt.Color(51, 51, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow1A1.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel20.setBackground(new java.awt.Color(51, 51, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Aqueza Suites");
        jLabel68.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel20.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel69.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Confirmation");
        jLabel69.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel20.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow1A1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel70.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(153, 153, 153));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("(Preview)");
        jLabel70.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcash2A2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcash2A2.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcash2A2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcash2A2.setText(" php 10000");
        PriceTextGcash2A2.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A1.add(PriceTextGcash2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA1.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA1.setText("09xxxxxxxx");
        AccountNameA1.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A1.add(AccountNameA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA1.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA1.setText("Confirm");
        OnlinePaymentButton1GA1.setFocusPainted(false);
        OnlinePaymentButton1GA1.setFocusable(false);
        OnlinePaymentButton1GA1.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA1.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton1GA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA1ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow1A1.add(OnlinePaymentButton1GA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel73.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 153, 153));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("You are about to pay");
        jLabel73.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A1.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel74.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 153, 153));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("using your GCash");
        jLabel74.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A1.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel75.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(153, 153, 153));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel75.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow1A1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel76.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(153, 153, 153));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Account Number");
        jLabel76.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A1.add(OnlinePaymentMainWindow1A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA1.add(OnlinePaymentWindow1A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentWindow2A1.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow2A1.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow2A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow2A1.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow2A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePayment2ndWindow2A1.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow2A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel84.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow2A1.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        jPanel24.setBackground(new java.awt.Color(0, 204, 0));
        jPanel24.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow2A1.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel25.setBackground(new java.awt.Color(0, 204, 0));
        jPanel25.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Aqueza Suites");
        jLabel85.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel25.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel86.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Successfully Paid!");
        jLabel86.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel25.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow2A1.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel87.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(153, 153, 153));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("(Preview)");
        jLabel87.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A1.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, -1));

        PriceTextPaymaya2A2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya2A2.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya2A2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya2A2.setText(" php 10000");
        PriceTextPaymaya2A2.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A1.add(PriceTextPaymaya2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA3.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA3.setText("09xxxxxxxx");
        AccountNameA3.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A1.add(AccountNameA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlineExitButton1A1.setBackground(new java.awt.Color(0, 204, 0));
        OnlineExitButton1A1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlineExitButton1A1.setText("Exit");
        OnlineExitButton1A1.setFocusPainted(false);
        OnlineExitButton1A1.setFocusable(false);
        OnlineExitButton1A1.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlineExitButton1A1.setRequestFocusEnabled(false);
        OnlineExitButton1A1.setVerifyInputWhenFocusTarget(false);
        OnlineExitButton1A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlineExitButton1A1ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow2A1.add(OnlineExitButton1A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel88.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(153, 153, 153));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("You Paid");
        jLabel88.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A1.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel89.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(153, 153, 153));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("using your PayMaya");
        jLabel89.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel90.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(153, 153, 153));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel90.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow2A1.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel91.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(153, 153, 153));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("Account Number");
        jLabel91.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A1.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A1.add(OnlinePayment2ndWindow2A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow2A1.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow2A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePaymentMainWindow2A1.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow2A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel92.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow2A1.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel26.setBackground(new java.awt.Color(0, 204, 0));
        jPanel26.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow2A1.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel27.setBackground(new java.awt.Color(0, 204, 0));
        jPanel27.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Aqueza Suites");
        jLabel93.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel27.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel94.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Confirmation");
        jLabel94.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel27.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow2A1.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel95.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(153, 153, 153));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("(Preview)");
        jLabel95.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A1.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 80, -1));

        PriceTextPaymaya1A2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya1A2.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya1A2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya1A2.setText(" php 10000");
        PriceTextPaymaya1A2.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A1.add(PriceTextPaymaya1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA4.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA4.setText("09xxxxxxxx");
        AccountNameA4.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A1.add(AccountNameA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton2GA1.setBackground(new java.awt.Color(0, 204, 0));
        OnlinePaymentButton2GA1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton2GA1.setText("Confirm");
        OnlinePaymentButton2GA1.setFocusPainted(false);
        OnlinePaymentButton2GA1.setFocusable(false);
        OnlinePaymentButton2GA1.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton2GA1.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton2GA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton2GA1ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow2A1.add(OnlinePaymentButton2GA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel96.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(153, 153, 153));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("You are about to pay");
        jLabel96.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A1.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel97.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(153, 153, 153));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("using your PayMaya");
        jLabel97.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A1.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel98.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(153, 153, 153));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel98.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow2A1.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel99.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(153, 153, 153));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Account Number");
        jLabel99.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A1.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A1.add(OnlinePaymentMainWindow2A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA1.add(OnlinePaymentWindow2A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentWindow3A1.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow3A1.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow3A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow2A2.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow2A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 202, 174), 3));
        OnlinePayment2ndWindow2A2.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow2A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(204, 202, 174));
        jPanel30.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow2A2.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel31.setBackground(new java.awt.Color(204, 202, 174));
        jPanel31.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("Aqueza Suites");
        jLabel110.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel31.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel111.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("Successfully Paid!");
        jLabel111.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel31.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow2A2.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel112.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(153, 153, 153));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("(Preview)");
        jLabel112.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 80, -1));

        PriceTextPaymaya2A3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya2A3.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya2A3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya2A3.setText(" php 10000");
        PriceTextPaymaya2A3.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(PriceTextPaymaya2A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA5.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA5.setText("09xxxxxxxx");
        AccountNameA5.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(AccountNameA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlineExitButton1A2.setBackground(new java.awt.Color(204, 202, 174));
        OnlineExitButton1A2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlineExitButton1A2.setText("Exit");
        OnlineExitButton1A2.setFocusPainted(false);
        OnlineExitButton1A2.setFocusable(false);
        OnlineExitButton1A2.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlineExitButton1A2.setRequestFocusEnabled(false);
        OnlineExitButton1A2.setRolloverEnabled(false);
        OnlineExitButton1A2.setVerifyInputWhenFocusTarget(false);
        OnlineExitButton1A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlineExitButton1A2ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow2A2.add(OnlineExitButton1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel113.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(153, 153, 153));
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("You Paid");
        jLabel113.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel114.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(153, 153, 153));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("using your AquezaCard");
        jLabel114.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel115.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(153, 153, 153));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel115.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow2A2.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel116.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(153, 153, 153));
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setText("Account Number");
        jLabel116.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/CreditCardIcon.png"))); // NOI18N
        jLabel125.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow2A2.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 240, 60));

        OnlinePaymentWindow3A1.add(OnlinePayment2ndWindow2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow2A2.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow2A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 202, 174), 3));
        OnlinePaymentMainWindow2A2.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow2A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/CreditCardIcon.png"))); // NOI18N
        jLabel117.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow2A2.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 240, 60));

        jPanel32.setBackground(new java.awt.Color(204, 202, 174));
        jPanel32.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow2A2.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel33.setBackground(new java.awt.Color(204, 202, 174));
        jPanel33.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Aqueza Suites");
        jLabel118.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel33.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel119.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("Confirmation");
        jLabel119.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel33.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow2A2.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel120.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(153, 153, 153));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("(Preview)");
        jLabel120.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 80, -1));

        PriceTextPaymaya1A3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya1A3.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya1A3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya1A3.setText(" php 10000");
        PriceTextPaymaya1A3.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(PriceTextPaymaya1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA6.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA6.setText("09xxxxxxxx");
        AccountNameA6.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(AccountNameA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton2GA2.setBackground(new java.awt.Color(204, 202, 174));
        OnlinePaymentButton2GA2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton2GA2.setText("Confirm");
        OnlinePaymentButton2GA2.setFocusPainted(false);
        OnlinePaymentButton2GA2.setFocusable(false);
        OnlinePaymentButton2GA2.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton2GA2.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton2GA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton2GA2ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow2A2.add(OnlinePaymentButton2GA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel121.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(153, 153, 153));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("You are about to pay");
        jLabel121.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel122.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(153, 153, 153));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("using your AquezaCard");
        jLabel122.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel123.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(153, 153, 153));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel123.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow2A2.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel124.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(153, 153, 153));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setText("Account Number");
        jLabel124.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow3A1.add(OnlinePaymentMainWindow2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA1.add(OnlinePaymentWindow3A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        UpdatePriceA1Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UpdatePriceA1Button.setText("Refresh Amount");
        UpdatePriceA1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UpdatePriceA1Button.setContentAreaFilled(false);
        UpdatePriceA1Button.setFocusPainted(false);
        UpdatePriceA1Button.setFocusable(false);
        UpdatePriceA1Button.setPreferredSize(new java.awt.Dimension(135, 30));
        UpdatePriceA1Button.setRequestFocusEnabled(false);
        UpdatePriceA1Button.setRolloverEnabled(false);
        UpdatePriceA1Button.setVerifyInputWhenFocusTarget(false);
        UpdatePriceA1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePriceA1ButtonActionPerformed(evt);
            }
        });
        CheckinA1.add(UpdatePriceA1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, -1, -1));

        ConfirmButtonA1Checkin.setBackground(new java.awt.Color(51, 51, 51));
        ConfirmButtonA1Checkin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ConfirmButtonA1Checkin.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButtonA1Checkin.setText("Pay & Confirm");
        ConfirmButtonA1Checkin.setBorder(null);
        ConfirmButtonA1Checkin.setFocusPainted(false);
        ConfirmButtonA1Checkin.setFocusable(false);
        ConfirmButtonA1Checkin.setPreferredSize(new java.awt.Dimension(150, 35));
        ConfirmButtonA1Checkin.setRequestFocusEnabled(false);
        ConfirmButtonA1Checkin.setRolloverEnabled(false);
        ConfirmButtonA1Checkin.setVerifyInputWhenFocusTarget(false);
        ConfirmButtonA1Checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonA1CheckinActionPerformed(evt);
            }
        });
        CheckinA1.add(ConfirmButtonA1Checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 205, 430, -1));

        RoomSchedNightCheckinA1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedNightCheckinA1.setText("6:00PM - 8:00AM Overnight");
        RoomSchedNightCheckinA1.setContentAreaFilled(false);
        RoomSchedNightCheckinA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedNightCheckinA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(RoomSchedNightCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 250, -1));

        RoomSchedDayCheckinA1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedDayCheckinA1.setSelected(true);
        RoomSchedDayCheckinA1.setText("6:00AM - 8:00AM Day");
        RoomSchedDayCheckinA1.setContentAreaFilled(false);
        RoomSchedDayCheckinA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedDayCheckinA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(RoomSchedDayCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 250, -1));

        PaymentMethodCheckin1A1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin1A1.setText("OnlinePayment");
        PaymentMethodCheckin1A1.setContentAreaFilled(false);
        PaymentMethodCheckin1A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin1A1ActionPerformed(evt);
            }
        });
        CheckinA1.add(PaymentMethodCheckin1A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        PaymentMethodCheckin2A2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin2A2.setText("Credit Card");
        PaymentMethodCheckin2A2.setActionCommand("");
        PaymentMethodCheckin2A2.setContentAreaFilled(false);
        PaymentMethodCheckin2A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin2A2ActionPerformed(evt);
            }
        });
        CheckinA1.add(PaymentMethodCheckin2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 110, -1));

        PaymentMethodCheckin2A3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin2A3.setText("Cash");
        PaymentMethodCheckin2A3.setActionCommand("");
        PaymentMethodCheckin2A3.setContentAreaFilled(false);
        PaymentMethodCheckin2A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin2A3ActionPerformed(evt);
            }
        });
        CheckinA1.add(PaymentMethodCheckin2A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 80, -1));

        OnlinePaymentChooseA1.setBackground(new java.awt.Color(204, 204, 204));
        OnlinePaymentChooseA1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GcashOptionA1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        GcashOptionA1.setText("GCash");
        GcashOptionA1.setContentAreaFilled(false);
        GcashOptionA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GcashOptionA1ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA1.add(GcashOptionA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, -1));

        PaymayaOptionA1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PaymayaOptionA1.setText("Pay Maya");
        PaymayaOptionA1.setContentAreaFilled(false);
        PaymayaOptionA1.setRequestFocusEnabled(false);
        PaymayaOptionA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymayaOptionA1ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA1.add(PaymayaOptionA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 110, -1));

        CheckinA1.add(OnlinePaymentChooseA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 140, 80));

        CheckInGuestNameA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestNameA1.setToolTipText("");
        CheckInGuestNameA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CheckInGuestNameA1.setFocusTraversalPolicyProvider(true);
        CheckInGuestNameA1.setPreferredSize(new java.awt.Dimension(250, 30));
        CheckInGuestNameA1.setVerifyInputWhenFocusTarget(false);
        CheckInGuestNameA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestNameA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(CheckInGuestNameA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 390, -1));

        CheckInGuestAddressA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA1.setToolTipText("");
        CheckInGuestAddressA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CheckInGuestAddressA1.setFocusTraversalPolicyProvider(true);
        CheckInGuestAddressA1.setPreferredSize(new java.awt.Dimension(250, 30));
        CheckInGuestAddressA1.setVerifyInputWhenFocusTarget(false);
        CheckInGuestAddressA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestAddressA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(CheckInGuestAddressA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 390, -1));

        TotalAmountA1Checkin.setEditable(false);
        TotalAmountA1Checkin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalAmountA1Checkin.setText("1");
        TotalAmountA1Checkin.setToolTipText("");
        TotalAmountA1Checkin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TotalAmountA1Checkin.setFocusTraversalPolicyProvider(true);
        TotalAmountA1Checkin.setFocusable(false);
        TotalAmountA1Checkin.setPreferredSize(new java.awt.Dimension(250, 30));
        TotalAmountA1Checkin.setRequestFocusEnabled(false);
        TotalAmountA1Checkin.setVerifyInputWhenFocusTarget(false);
        TotalAmountA1Checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountA1CheckinActionPerformed(evt);
            }
        });
        CheckinA1.add(TotalAmountA1Checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, 160, -1));

        CheckInGuestAddressA8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA8.setText("Payment Method");
        CheckInGuestAddressA8.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 160, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Payment Total & Confirmation");
        CheckinA1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 400, 46));

        MaxDaysCheckinA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaxDaysCheckinA1.setText("1");
        MaxDaysCheckinA1.setToolTipText("");
        MaxDaysCheckinA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MaxDaysCheckinA1.setFocusTraversalPolicyProvider(true);
        MaxDaysCheckinA1.setPreferredSize(new java.awt.Dimension(250, 30));
        MaxDaysCheckinA1.setVerifyInputWhenFocusTarget(false);
        MaxDaysCheckinA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxDaysCheckinA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(MaxDaysCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 110, -1));

        RoomPriceA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RoomPriceA1.setText("...");
        RoomPriceA1.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(RoomPriceA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 310, -1));

        RoomPriceA2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RoomPriceA2.setText("Discounted Price: 2499");
        RoomPriceA2.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(RoomPriceA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 160, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Full Name");
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, -1));

        AddressLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddressLabel.setText("Address");
        AddressLabel.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(AddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 110, -1));

        DesignCheckin1.setBackground(new java.awt.Color(255, 255, 255));
        DesignCheckin1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DesignCheckin1.setText("Single Class A");
        DesignCheckin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DesignCheckin1.setPreferredSize(new java.awt.Dimension(250, 30));
        DesignCheckin1.setVerifyInputWhenFocusTarget(false);
        CheckinA1.add(DesignCheckin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 120, -1));

        CheckInGuestAddressA4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA4.setText("Days");
        CheckInGuestAddressA4.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 160, -1));

        CheckInGuestAddressA7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA7.setText("1 -7 MAX");
        CheckInGuestAddressA7.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 150, -1));

        LabelCheckinA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA1.setText("RoomType");
        LabelCheckinA1.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(LabelCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 110, -1));

        CheckInGuestAddressA6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA6.setText("Total Amount:");
        CheckInGuestAddressA6.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 100, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Check in info");
        CheckinA1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 260, 46));

        MainPanelBook1.setOpaque(true);
        MainPanelBook1.setPreferredSize(new java.awt.Dimension(500, 450));
        MainPanelBook1.setRequestFocusEnabled(false);
        MainPanelBook1.setVerifyInputWhenFocusTarget(false);
        CheckinA1.add(MainPanelBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 450, 230));

        MainPanelBook2.setOpaque(true);
        MainPanelBook2.setPreferredSize(new java.awt.Dimension(500, 450));
        MainPanelBook2.setRequestFocusEnabled(false);
        MainPanelBook2.setVerifyInputWhenFocusTarget(false);
        CheckinA1.add(MainPanelBook2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 450, 460));

        Background5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background5.setPreferredSize(new java.awt.Dimension(1000, 500));
        CheckinA1.add(Background5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckInGuestAddressA9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA9.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA9.setText("Room Schedule");
        CheckInGuestAddressA9.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 110, -1));

        CheckInPayment.add(CheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RoomInfoPanel.add(CheckInPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        getContentPane().add(RoomInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoginSystemPanel.setBackground(new java.awt.Color(235, 231, 203));
        LoginSystemPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        LoginSystemPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitMessageWindowz.setBackground(new java.awt.Color(0, 0, 0));
        ExitMessageWindowz.setOpaque(false);
        ExitMessageWindowz.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitMessageMainWindow.setBackground(new java.awt.Color(204, 195, 142));
        ExitMessageMainWindow.setPreferredSize(new java.awt.Dimension(400, 400));
        ExitMessageMainWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitButtonLogin.setBackground(new java.awt.Color(147, 138, 103));
        ExitButtonLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ExitButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        ExitButtonLogin.setText("No");
        ExitButtonLogin.setBorder(null);
        ExitButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonLoginActionPerformed(evt);
            }
        });
        ExitMessageMainWindow.add(ExitButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 145, 31));

        ContinueButtonLogin.setBackground(new java.awt.Color(147, 138, 103));
        ContinueButtonLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ContinueButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        ContinueButtonLogin.setText("Yes");
        ContinueButtonLogin.setBorder(null);
        ContinueButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueButtonLoginActionPerformed(evt);
            }
        });
        ExitMessageMainWindow.add(ContinueButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 145, 31));

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextArea4.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("You havent logged in your account, Some features will be limited continue?");
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setFocusable(false);
        jTextArea4.setOpaque(false);
        jTextArea4.setRequestFocusEnabled(false);
        jTextArea4.setVerifyInputWhenFocusTarget(false);
        ExitMessageMainWindow.add(jTextArea4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, 86));

        ExitMessageWindowz.add(ExitMessageMainWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 160, 330, 150));

        ExitMessageWindow.setBackground(new java.awt.Color(0, 0, 0));
        ExitMessageWindow.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ExitMessageWindow.setOpaque(true);
        ExitMessageWindow.setPreferredSize(new java.awt.Dimension(1000, 500));
        ExitMessageWindowz.add(ExitMessageWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoginSystemPanel.add(ExitMessageWindowz, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        RegisterFormWindow.setBackground(new java.awt.Color(197, 177, 149, 100));
        RegisterFormWindow.setPreferredSize(new java.awt.Dimension(1000, 500));
        RegisterFormWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/Logo1-removebg-preview - 40x40.png"))); // NOI18N
        RegisterFormWindow.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 40, 40));

        ExitLoginButton2.setBackground(new java.awt.Color(142, 137, 111));
        ExitLoginButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ExitLoginButton2.setForeground(new java.awt.Color(255, 255, 255));
        ExitLoginButton2.setText("Exit");
        ExitLoginButton2.setBorder(null);
        ExitLoginButton2.setFocusPainted(false);
        ExitLoginButton2.setFocusTraversalPolicyProvider(true);
        ExitLoginButton2.setFocusable(false);
        ExitLoginButton2.setPreferredSize(new java.awt.Dimension(100, 35));
        ExitLoginButton2.setRolloverEnabled(false);
        ExitLoginButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitLoginButton2ActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(ExitLoginButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        NumberSignUpInput.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        NumberSignUpInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        NumberSignUpInput.setFocusCycleRoot(true);
        NumberSignUpInput.setInheritsPopupMenu(true);
        NumberSignUpInput.setPreferredSize(new java.awt.Dimension(250, 30));
        NumberSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(NumberSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 145, 370, -1));

        EmailAddressSignUpInput.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        EmailAddressSignUpInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        EmailAddressSignUpInput.setFocusCycleRoot(true);
        EmailAddressSignUpInput.setInheritsPopupMenu(true);
        EmailAddressSignUpInput.setPreferredSize(new java.awt.Dimension(250, 30));
        EmailAddressSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailAddressSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(EmailAddressSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 205, 370, -1));

        UsernameSignUpInput.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UsernameSignUpInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        UsernameSignUpInput.setFocusCycleRoot(true);
        UsernameSignUpInput.setInheritsPopupMenu(true);
        UsernameSignUpInput.setPreferredSize(new java.awt.Dimension(250, 30));
        UsernameSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(UsernameSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 265, 370, -1));

        PasswordSignUpInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        PasswordSignUpInput.setPreferredSize(new java.awt.Dimension(250, 30));
        PasswordSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(PasswordSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 325, 370, -1));

        SignUpButton1.setBackground(new java.awt.Color(142, 137, 111));
        SignUpButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SignUpButton1.setForeground(new java.awt.Color(255, 255, 255));
        SignUpButton1.setText("Create Account");
        SignUpButton1.setBorder(null);
        SignUpButton1.setFocusPainted(false);
        SignUpButton1.setFocusable(false);
        SignUpButton1.setPreferredSize(new java.awt.Dimension(100, 35));
        SignUpButton1.setRequestFocusEnabled(false);
        SignUpButton1.setRolloverEnabled(false);
        SignUpButton1.setVerifyInputWhenFocusTarget(false);
        SignUpButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButton1ActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(SignUpButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 170, -1));

        jLabel83.setBackground(new java.awt.Color(255, 255, 255));
        jLabel83.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("EmailAddress:");
        RegisterFormWindow.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 140, 25));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Username:");
        RegisterFormWindow.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 140, 25));

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Register to Auqeza Suites");
        RegisterFormWindow.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 63, 290, 30));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Already have an account?");
        RegisterFormWindow.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 140, 30));

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Password:");
        RegisterFormWindow.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 140, 25));

        GOSigninWindowButton.setBackground(new java.awt.Color(142, 137, 111));
        GOSigninWindowButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        GOSigninWindowButton.setForeground(new java.awt.Color(255, 255, 255));
        GOSigninWindowButton.setText("Sign In");
        GOSigninWindowButton.setBorder(null);
        GOSigninWindowButton.setFocusable(false);
        GOSigninWindowButton.setPreferredSize(new java.awt.Dimension(100, 35));
        GOSigninWindowButton.setRequestFocusEnabled(false);
        GOSigninWindowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GOSigninWindowButtonActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(GOSigninWindowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, -1));

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Phone number:");
        RegisterFormWindow.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 140, 25));

        Background10.setBackground(new java.awt.Color(189, 181, 152));
        Background10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background10.setOpaque(true);
        Background10.setPreferredSize(new java.awt.Dimension(500, 400));
        RegisterFormWindow.add(Background10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        Background8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background8.setPreferredSize(new java.awt.Dimension(1000, 500));
        RegisterFormWindow.add(Background8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoginSystemPanel.add(RegisterFormWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        LoginFormWindow.setBackground(new java.awt.Color(197, 177, 149, 100));
        LoginFormWindow.setPreferredSize(new java.awt.Dimension(1000, 500));
        LoginFormWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitLoginButton3.setBackground(new java.awt.Color(142, 137, 111));
        ExitLoginButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ExitLoginButton3.setForeground(new java.awt.Color(255, 255, 255));
        ExitLoginButton3.setText("X");
        ExitLoginButton3.setBorder(null);
        ExitLoginButton3.setFocusPainted(false);
        ExitLoginButton3.setFocusTraversalPolicyProvider(true);
        ExitLoginButton3.setFocusable(false);
        ExitLoginButton3.setPreferredSize(new java.awt.Dimension(100, 35));
        ExitLoginButton3.setRolloverEnabled(false);
        ExitLoginButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitLoginButton3ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(ExitLoginButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 40, -1));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/Logo1-removebg-preview - 40x40.png"))); // NOI18N
        LoginFormWindow.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 40, 40));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Sign in to Auqeza Suites");
        LoginFormWindow.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 270, 30));

        PasswordSigninInput1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        PasswordSigninInput1.setPreferredSize(new java.awt.Dimension(250, 30));
        PasswordSigninInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordSigninInput1ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(PasswordSigninInput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 300, -1));

        UsernameSigninInput1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UsernameSigninInput1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        UsernameSigninInput1.setFocusTraversalPolicyProvider(true);
        UsernameSigninInput1.setInheritsPopupMenu(true);
        UsernameSigninInput1.setPreferredSize(new java.awt.Dimension(250, 30));
        UsernameSigninInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameSigninInput1ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(UsernameSigninInput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 300, -1));

        jLabel45.setBackground(new java.awt.Color(0, 0, 0));
        jLabel45.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Doesnt have an account yet?");
        LoginFormWindow.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 160, 30));

        SignInButton1.setBackground(new java.awt.Color(142, 137, 111));
        SignInButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SignInButton1.setForeground(new java.awt.Color(255, 255, 255));
        SignInButton1.setText("Create Account");
        SignInButton1.setBorder(null);
        SignInButton1.setFocusable(false);
        SignInButton1.setPreferredSize(new java.awt.Dimension(100, 35));
        SignInButton1.setRequestFocusEnabled(false);
        SignInButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButton1ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(SignInButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 170, -1));

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Username:");
        LoginFormWindow.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 140, 30));

        SignInButton2.setBackground(new java.awt.Color(142, 137, 111));
        SignInButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SignInButton2.setForeground(new java.awt.Color(255, 255, 255));
        SignInButton2.setText("Sign in");
        SignInButton2.setBorder(null);
        SignInButton2.setFocusable(false);
        SignInButton2.setPreferredSize(new java.awt.Dimension(100, 35));
        SignInButton2.setRequestFocusEnabled(false);
        SignInButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButton2ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(SignInButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, -1, -1));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Password:");
        LoginFormWindow.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 140, 30));

        Background6.setBackground(new java.awt.Color(189, 181, 152));
        Background6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background6.setOpaque(true);
        Background6.setPreferredSize(new java.awt.Dimension(500, 300));
        LoginFormWindow.add(Background6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        Background7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background7.setPreferredSize(new java.awt.Dimension(1000, 500));
        LoginFormWindow.add(Background7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoginSystemPanel.add(LoginFormWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Background3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View None.jpg"))); // NOI18N
        Background3.setPreferredSize(new java.awt.Dimension(1000, 500));
        LoginSystemPanel.add(Background3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(LoginSystemPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Background4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Background4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View None.jpg"))); // NOI18N
        Background4.setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().add(Background4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Book button on Start
        if (LoginEnabled < 2) {
        MainPanel1.setVisible(false);
        MenuButtonsPanels.setVisible(false);
        RoomSectionPanel.setVisible(false);
        RoomInfoPanel.setVisible(false);
        RegisterFormWindow.setVisible(false);
        AccountInfoPanel.setVisible(false);
        //Opening main Login Window
        Timer timer2 = new Timer(500, e -> {
            LoginSystemPanel.setVisible(true);
        RegisterFormWindow.setVisible(false);
        LoginFormWindow.setVisible(true);
        PasswordSigninInput1.setVisible(true);
        UsernameSigninInput1.setVisible(true);
        });
        timer2.setRepeats(false);
        timer2.start();
    } else {
        jScrollPane2.setVisible(false);
        RoomSectionPanel.setVisible(true);
        MainPanel1.setVisible(false);
        jButton1.setVisible(false);
        MenuButtonsPanels.setVisible(false);
        
        Timer timer1 = new Timer(500, e -> {
            jScrollPane2.setVisible(true);
            jScrollPane2.setOpaque(false);
            jScrollPane2.getViewport().setOpaque(false);
        });
        timer1.setRepeats(false);
        timer1.start();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ViewHotelFeatureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewHotelFeatureButtonActionPerformed
        // Side Panel Open Account details
        if (LoginEnabled < 2) {
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            HotelFeaturesPanels.setVisible(false);
            RoomInfoPanel.setVisible(false);
            ExitMessageWindowz.setVisible(false);
            AccountInfoPanel.setVisible(false);
            ExitLoginButton3.setVisible(true);
            ExitLoginButton2.setVisible(true);
            
            //Opening main Login Window
            LoginSystemPanel.setVisible(true);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(true);
            
        } else {
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            RoomInfoPanel.setVisible(false);
            HotelFeaturesPanels.setVisible(false);
            //Opening Main Window Account
            LoginSystemPanel.setVisible(true);
            AccountInfoPanel.setVisible(true);
            LoginSystemPanel.setVisible(false);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(false);
            MenuButtonsPanels.setVisible(true);
            AccountInfo();
            
        }
    }//GEN-LAST:event_ViewHotelFeatureButtonActionPerformed

    private void RoomSectionButtionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSectionButtionActionPerformed

       //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomInfoPanel.setVisible(false);
            AccountInfoPanel.setVisible(false);
            HotelFeaturesPanels.setVisible(false);
            //Opening Main Window Account
            LoginSystemPanel.setVisible(true);
            LoginSystemPanel.setVisible(false);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(false);
            MenuButtonsPanels.setVisible(true);
            CompanyNameLabel.setVisible(true);
            
            Timer timer = new Timer(500, e -> {
                RoomSectionPanel.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        
    }//GEN-LAST:event_RoomSectionButtionActionPerformed

    private void UsernameSigninInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameSigninInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameSigninInput1ActionPerformed

    private void SignInButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInButton1ActionPerformed
        //going to signupWindow
        RegisterFormWindow.setVisible(true);
        NumberSignUpInput.setVisible(true);
        UsernameSignUpInput.setVisible(true);
        PasswordSignUpInput.setVisible(true);
        LoginFormWindow.setVisible(false);
        PasswordSigninInput1.setVisible(false);
        UsernameSigninInput1.setVisible(false);

    }//GEN-LAST:event_SignInButton1ActionPerformed

    private void SignInButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInButton2ActionPerformed
         //Signing In your Account code :>
         String Username, password;
         Username = UsernameSigninInput1.getText();
         password = new String(PasswordSignUpInput.getPassword());
         String queryLogin = "SELECT * FROM hotelusersdatabase WHERE Username = "
                 + "'" + Username + "' AND Password = '" + password + "'";
         
         
         try {
            pst = con.prepareStatement(queryLogin);
            ResultSet rs = pst.executeQuery();
            
            if(!rs.next()) {
                JOptionPane.showMessageDialog(null, "Invalid Credentials or already existed.");
            
            } else {
                JOptionPane.showMessageDialog(null, "Successfull Login!");
                LoginEnabled = 3;
                UsernameSigninInput1.setText("");
                PasswordSigninInput1.setText("");
                Usernamee = rs.getString("Username");
                UserNameGreetings.setText(Usernamee + "!");
                //loginscreen false4
                LoginFormWindow.setVisible(false);
                PasswordSigninInput1.setVisible(false);
                UsernameSigninInput1.setVisible(false);
                RegisterFormWindow.setVisible(false);
                NumberSignUpInput.setVisible(false);
                UsernameSignUpInput.setVisible(false);
                PasswordSignUpInput.setVisible(false);
                RoomSectionPanel.setVisible(true);
                MenuButtonsPanels.setVisible(true);
                

                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
        
    }//GEN-LAST:event_SignInButton2ActionPerformed

    private void BookButtonA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookButtonA1ActionPerformed
        // Booking room info A1 button
        if (RoomBooked > 2) {
            JOptionPane.showMessageDialog(new JFrame(), "You can only booked once" + "You can cancel your current booked in Account Info");
        }
        if (LoginEnabled < 2) {
            JOptionPane.showMessageDialog(null, "Before you continue you need to sign in");
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            RoomInfoPanel.setVisible(false);
            //Opening main Login Window
            LoginSystemPanel.setVisible(true);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(true);
            LoginSystemPanel.setOpaque(false);
            
        } 
        if (LoginEnabled > 2) {
            
            PaymentDetailsA1();
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentMainWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            OnlinePaymentMainWindow2A1.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(true);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowB2.setVisible(false);
            InfoWindowC1.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            PaymentDetailsA1(); 
            PriceDayA1 = 8499;
            PriceNightA1 = 7499;
            DesignCheckin1.setText("Single Class A"); 
            
            
        }
    }//GEN-LAST:event_BookButtonA1ActionPerformed

    private void NumberSignUpInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberSignUpInputActionPerformed

    }//GEN-LAST:event_NumberSignUpInputActionPerformed

    private void UsernameSignUpInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameSignUpInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameSignUpInputActionPerformed

    private void ExitLoginButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitLoginButton2ActionPerformed
        // exit Sign in/Sign up
        ExitMessageMainWindow.setVisible(false);
        ExitLoginButton2.setVisible(false);
        ExitMessageWindowz.setVisible(true);
        ExitMessageWindow.setVisible(true);
        ExitMessageWindow.setOpaque(true);
        
        Timer timer2 = new Timer(500, e -> {
            ExitMessageMainWindow.setVisible(true);
            });
        timer2.setRepeats(false);
        timer2.start();
    }//GEN-LAST:event_ExitLoginButton2ActionPerformed

    private void SignUpButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButton1ActionPerformed

       
        CreateAccountButton();       
    }//GEN-LAST:event_SignUpButton1ActionPerformed

    private void GOSigninWindowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GOSigninWindowButtonActionPerformed
        //going to sign in window
        RegisterFormWindow.setVisible(false);
        NumberSignUpInput.setVisible(false);
        UsernameSignUpInput.setVisible(false);
        PasswordSignUpInput.setVisible(false);
        LoginFormWindow.setVisible(true);
        PasswordSigninInput1.setVisible(true);
        UsernameSigninInput1.setVisible(true);
    }//GEN-LAST:event_GOSigninWindowButtonActionPerformed

    private void RoomA1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomA1ButtonActionPerformed
            // opening book info 1
        RoomInfoPanel.setVisible(true);
        InfoWindows.setVisible(true);
        InfoWindowA1.setVisible(true);
        //making sure other window is closed
        InfoWindowA2.setVisible(false);
        InfoWindowB1.setVisible(false);
        InfoWindowB2.setVisible(false);
        InfoWindowC1.setVisible(false);
        InfoWindowC2.setVisible(false);
        // other main window closed
        RoomSectionPanel.setVisible(false);
        LoginSystemPanel.setVisible(false);
        Background3.setVisible(false);
        MenuButtonsPanels.setVisible(false);
    }//GEN-LAST:event_RoomA1ButtonActionPerformed

    private void ExitInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitInfoButtonActionPerformed
        // Exiting Room Info Book
        RoomInfoPanel.setVisible(false);
        InfoWindows.setVisible(false);
        InfoWindowA1.setVisible(false);
        //making sure other window is open/
        jScrollPane2.setVisible(false);
        RoomSectionPanel.setVisible(true);
        MainPanel1.setVisible(false);
        jButton1.setVisible(false);
        MenuButtonsPanels.setVisible(true);
        
        
        Timer timer1 = new Timer(500, e -> {
            jScrollPane2.setVisible(true);
            jScrollPane2.setOpaque(false);
            jScrollPane2.getViewport().setOpaque(false);
        });
        timer1.setRepeats(false);
        timer1.start();
    }//GEN-LAST:event_ExitInfoButtonActionPerformed

    private void BookButtonA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookButtonA2ActionPerformed
        // Booking Room A2 info button
        if (RoomBooked > 2) {
            JOptionPane.showMessageDialog(new JFrame(), "You can only booked once" + "You can cancel your current booked in Account Info");
        }
        if (LoginEnabled < 2) {
            JOptionPane.showMessageDialog(null, "Before you continue you need to sign in");
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            RoomInfoPanel.setVisible(false);
            //Opening main Login Window
            LoginSystemPanel.setVisible(true);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(true);
            LoginSystemPanel.setOpaque(false);
            
        } else {
            PaymentDetailsA1();
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentMainWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            OnlinePaymentMainWindow2A1.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(true);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowB2.setVisible(false);
            InfoWindowC1.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            PaymentDetailsA1(); 
            PriceDayA1 = 9499;
            PriceNightA1 = 10499;
            DesignCheckin1.setText("Double Class A"); 
            
            
        }
    }//GEN-LAST:event_BookButtonA2ActionPerformed

    private void RoomA1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomA1Button1ActionPerformed
        //Open Window
        RoomInfoPanel.setVisible(true);
        InfoWindows.setVisible(true);
        InfoWindowA2.setVisible(true);
        //closing other windows
        MenuButtonsPanels.setVisible(false);
        MainPanel1.setVisible(false);
        RoomSectionPanel.setVisible(false);
        LoginSystemPanel.setVisible(false);
        //other Room Info Closed
        InfoWindowA1.setVisible(false);
        InfoWindowB1.setVisible(false);
        InfoWindowB2.setVisible(false);
        InfoWindowC1.setVisible(false);
        InfoWindowC2.setVisible(false);
        
        
    }//GEN-LAST:event_RoomA1Button1ActionPerformed

    private void MaxDaysCheckinA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxDaysCheckinA1ActionPerformed
           // MAX DAYS INPUT
       if ("".equals(MaxDaysCheckinA1.getText())) {
            JOptionPane.showMessageDialog( new JFrame(), "please input a number.");
        } else {
           try {
               int number = Integer.parseInt(MaxDaysCheckinA1.getText());
               if (number >= 1 && number <= 7) {
                   PaymentDetailsA1();
               } else {
                   JOptionPane.showMessageDialog(new JFrame(), "Please input a number between 1-10.");
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid number.");
               
           }
        }
        
    }//GEN-LAST:event_MaxDaysCheckinA1ActionPerformed

    private void PaymentMethodCheckin1A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin1A1ActionPerformed
        // if open
        PaymentDetailsA1();
    }//GEN-LAST:event_PaymentMethodCheckin1A1ActionPerformed

    private void RoomB1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomB1ButtonActionPerformed
        //Open Window B1
        RoomInfoPanel.setVisible(true);
        InfoWindows.setVisible(true);
        InfoWindowB1.setVisible(true);
        //closing other windows
        MenuButtonsPanels.setVisible(false);
        MainPanel1.setVisible(false);
        RoomSectionPanel.setVisible(false);
        LoginSystemPanel.setVisible(false);
        //other Room Info Closed
        InfoWindowA1.setVisible(false);
        InfoWindowA2.setVisible(false);
        InfoWindowB2.setVisible(false);
        InfoWindowC1.setVisible(false);
        InfoWindowC2.setVisible(false);
    }//GEN-LAST:event_RoomB1ButtonActionPerformed

    private void RoomB2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomB2ButtonActionPerformed
        //Open Window Window B2
        RoomInfoPanel.setVisible(true);
        InfoWindows.setVisible(true);
        InfoWindowB2.setVisible(true);
        //closing other windows
        MenuButtonsPanels.setVisible(false);
        MainPanel1.setVisible(false);
        RoomSectionPanel.setVisible(false);
        LoginSystemPanel.setVisible(false);
        //other Room Info Closed
        InfoWindowA1.setVisible(false);
        InfoWindowA2.setVisible(false);
        InfoWindowB1.setVisible(false);
        InfoWindowC1.setVisible(false);
        InfoWindowC2.setVisible(false);
    }//GEN-LAST:event_RoomB2ButtonActionPerformed

    private void RoomB1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomB1Button1ActionPerformed
        //Open Window Window C1
        RoomInfoPanel.setVisible(true);
        InfoWindows.setVisible(true);
        InfoWindowC1.setVisible(true);
        //closing other windows
        MenuButtonsPanels.setVisible(false);
        MainPanel1.setVisible(false);
        RoomSectionPanel.setVisible(false);
        LoginSystemPanel.setVisible(false);
        //other Room Info Closed
        InfoWindowA1.setVisible(false);
        InfoWindowA2.setVisible(false);
        InfoWindowB1.setVisible(false);
        InfoWindowB2.setVisible(false);
        InfoWindowC2.setVisible(false);
    }//GEN-LAST:event_RoomB1Button1ActionPerformed

    private void ConfirmButtonA1CheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonA1CheckinActionPerformed
        // CheckOut Room A1
                PaymentDetailsA1();
                ButtonGroup group = new ButtonGroup();
                group.add(PaymentMethodCheckin2A3);
                group.add(PaymentMethodCheckin1A1);
                group.add(PaymentMethodCheckin2A2);
                
                if (group.getSelection() == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "Select a payment method.");
                }
                if ("".equals(CheckInGuestNameA1.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Guest name should not be empty.");
                  return;
                }
                if ("".equals(CheckInGuestAddressA1.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "address should not be empty.");
                    return;
                }
                if (CheckInGuestNameA1.getText().length() < 5) {
                    JOptionPane.showMessageDialog(new JFrame(), "Guest name should be 5 characters minimum");
                     return;
                }
                if (CheckInGuestNameA1.getText().length() > 100) {
                    JOptionPane.showMessageDialog(new JFrame(), "Guest name should be 100 characters maximum");
                    return;
                 }
                if (CheckInGuestAddressA1.getText().length() < 5) {
                    JOptionPane.showMessageDialog(new JFrame(), "Guest name should be 5 characters minimum");
                    return;
                }
                if (CheckInGuestAddressA1.getText().length() > 150) {
                    JOptionPane.showMessageDialog(new JFrame(), "Guest name should be 150 characters maximum");
                    return;
                }  else if(GcashOptionA1.isSelected()) {
                    System.out.println("Making the GCash Payment Show");
                    OnlinePaymentMainWindow1A1.setVisible(true);
                    OnlinePaymentWindow1A1.setVisible(true);
                    OnlinePayment2ndWindow1A1.setVisible(false);
                    PriceTextGcash1A2.setText(TotalAmountA1Checkin.getText());
                    PriceTextGcash2A2.setText(TotalAmountA1Checkin.getText());
                } else if (PaymayaOptionA1.isSelected()) {
                    System.out.println("Making the Paymaya Payment Show");
                    OnlinePaymentMainWindow2A1.setVisible(true);
                    OnlinePaymentWindow2A1.setVisible(true);
                    OnlinePayment2ndWindow2A1.setVisible(false);
                    PriceTextPaymaya2A2.setText(TotalAmountA1Checkin.getText());
                    PriceTextPaymaya1A2.setText(TotalAmountA1Checkin.getText());
                } else if (PaymentMethodCheckin2A3.isSelected()) {
                      // Paymaya window Payment A1
                String guestnameA1, addressA1, roomtypeA1, roompriceA1, totalamount, paymentmethod, paymentstatus;
        
                PaymentDetailsA1();
                roompriceA1 = RoomPriceA1.getText();
                totalamount = TotalAmountA1Checkin.getText();
                guestnameA1 = CheckInGuestNameA1.getText();
                addressA1 = CheckInGuestAddressA1.getText();
                roomtypeA1 = roomname;
                paymentmethod = "Cash";
                paymentstatus = "Pending";
                Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        
                String AddUserbookfromdatabase = "UPDATE hotelusersdatabase "
                    + "SET GuestName=?, Address=?, RoomType=?, RoomPrice=?, BookingSched=?, "
                    + "TotalAmount=?, PaymentMethod=?, PaymentStatus=? WHERE Username=?";
                try (Connection con = DriverManager.getConnection(DbURL, DbPhoneNumber, DbPassword);
                    PreparedStatement stmt = con.prepareStatement(AddUserbookfromdatabase)) {
                    stmt.setString(1, guestnameA1);
                    stmt.setString(2, addressA1);
                    stmt.setString(3, roomtypeA1);
                    stmt.setString(4, roompriceA1);
                    stmt.setTimestamp(5, currentTime);
                    stmt.setString(6, totalamount);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
                } catch (SQLException ex) {
                   Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(new JFrame(), "Successfully reserved! you can view your pending payment on account info." + 
                        " you will be directly to room selections.");
                OnlinePaymentWindow1A1.setVisible(false);
            OnlinePayment2ndWindow1A1.setVisible(false);
            CheckinA1.setVisible(false);
            //making sure the other panel is not visible--
            RoomInfoPanel.setVisible(false);
            MainPanel1.setVisible(false);
            Timer Hotelappear2 = new Timer(1000, e -> {
                RoomSectionPanel.setVisible(true);
            });
            Hotelappear2.setRepeats(false);
            Hotelappear2.start();
            } else if (PaymentMethodCheckin2A2.isSelected()) {
                //credit card
                
                PriceTextPaymaya1A3.setText("PHP " + TotalAmountA1Checkin.getText());
                PriceTextPaymaya2A3.setText("PHP " + TotalAmountA1Checkin.getText());
                OnlinePaymentWindow3A1.setVisible(true);
                OnlinePaymentWindow3A1.setOpaque(false);
                OnlinePaymentWindow3A1.putClientProperty( FlatClientProperties.STYLE, "arc: 20" );
                OnlinePaymentMainWindow2A2.putClientProperty( FlatClientProperties.STYLE, "arc: 20" );
                OnlinePayment2ndWindow2A2.putClientProperty( FlatClientProperties.STYLE, "arc: 20" );
                OnlineExitButton1A2.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
                OnlinePaymentButton2GA2.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
                OnlinePaymentMainWindow2A2.setVisible(true);
                OnlinePayment2ndWindow2A2.setVisible(false);
            }
            
    }//GEN-LAST:event_ConfirmButtonA1CheckinActionPerformed

    private void ExitButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonLoginActionPerformed
        // Opening Login Window (On)
        ExitMessageWindowz.setVisible(false);
        ExitLoginButton2.setVisible(true);
        Timer timer2 = new Timer(500, e -> {
            ExitMessageMainWindow.setVisible(false);
            ExitLoginButton3.setVisible(true);
            });
        timer2.setRepeats(false);
        timer2.start();
    }//GEN-LAST:event_ExitButtonLoginActionPerformed

    private void ContinueButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueButtonLoginActionPerformed
        // Closing Login Window (Off)
        ExitLoginButton2.setVisible(true);
        LoginSystemPanel.setVisible(false);
        RoomSectionPanel.setVisible(true);
        MenuButtonsPanels.setVisible(true);
        ExitMessageMainWindow.setVisible(false);
        
        
        if (LoginEnabled < 2) {
            ExitMessageWindowz.setVisible(false);
            Timer timer2 = new Timer(500, e -> {
            jScrollPane2.setVisible(true);
            });
            timer2.setRepeats(false);
            timer2.start();
        }
        
        
    }//GEN-LAST:event_ContinueButtonLoginActionPerformed

    private void PasswordSigninInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordSigninInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordSigninInput1ActionPerformed

    private void PasswordSignUpInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordSignUpInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordSignUpInputActionPerformed

    private void RoomSchedDayCheckinA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedDayCheckinA1ActionPerformed
        // selected
        PaymentDetailsA1();
    }//GEN-LAST:event_RoomSchedDayCheckinA1ActionPerformed

    private void RoomSchedNightCheckinA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedNightCheckinA1ActionPerformed
        // selected
        PaymentDetailsA1();
    }//GEN-LAST:event_RoomSchedNightCheckinA1ActionPerformed

    private void UpdatePriceA1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePriceA1ButtonActionPerformed
        // Update Refresh Price
        PaymentDetailsA1();
    }//GEN-LAST:event_UpdatePriceA1ButtonActionPerformed

    private void TotalAmountA1CheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAmountA1CheckinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountA1CheckinActionPerformed

    private void CheckInGuestNameA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestNameA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestNameA1ActionPerformed

    private void CheckInGuestAddressA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestAddressA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestAddressA1ActionPerformed

    private void GcashOptionA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GcashOptionA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GcashOptionA1ActionPerformed

    private void PaymayaOptionA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymayaOptionA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymayaOptionA1ActionPerformed

    private void OnlinePaymentButton1GA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA1ActionPerformed
        //GCASH PAYMENT CONFIRMED ROOMA1
        
        String guestnameA1, addressA1, roomtypeA1, roompriceA1, totalamount, paymentmethod, paymentstatus;
        
        totalamount = TotalAmountA1Checkin.getText();
        roompriceA1 = RoomPriceA1.getText();
        guestnameA1 = CheckInGuestNameA1.getText();
        addressA1 = CheckInGuestAddressA1.getText();
        roomtypeA1 = roomname;
        paymentmethod = "Online payment GCash";
        paymentstatus = "Confirmed";
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        
        String AddUserbookfromdatabase = "UPDATE hotelusersdatabase "
                + "SET GuestName=?, Address=?, RoomType=?, RoomPrice=?, BookingSched=?, "
                + "TotalAmount=?, PaymentMethod=?, PaymentStatus=? WHERE Username=?";
        try (Connection con = DriverManager.getConnection(DbURL, DbPhoneNumber, DbPassword);
                    PreparedStatement stmt = con.prepareStatement(AddUserbookfromdatabase)) {
                    stmt.setString(1, guestnameA1);
                    stmt.setString(2, addressA1);
                    stmt.setString(3, roomtypeA1);
                    stmt.setString(4, roompriceA1);
                    stmt.setTimestamp(5, currentTime);
                    stmt.setString(6, totalamount);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        Timer paymentDelayed1 = new Timer(500, e -> {
            OnlinePaymentMainWindow1A1.setVisible(false);
        });
        
        paymentDelayed1.setRepeats(false);
        paymentDelayed1.start();
        Timer paymentDelayed2 = new Timer(500, e -> {
           OnlinePayment2ndWindow1A1.setVisible(true); 
        });
        
        paymentDelayed2.setRepeats(false);
        paymentDelayed2.start();
    }//GEN-LAST:event_OnlinePaymentButton1GA1ActionPerformed

    private void OnlinePaymentButton1GA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA2ActionPerformed
        // exit window A1 GCASH Payment
        JOptionPane.showMessageDialog(new JFrame(), "Successfully booked. You will be directly to room section"
         + (" you can view your book info on account info menu."));
        OnlinePaymentWindow1A1.setVisible(false);
        OnlinePayment2ndWindow1A1.setVisible(false);
        CheckinA1.setVisible(false);
        //making sure the other panel is not visible--
        RoomInfoPanel.setVisible(false);
        MainPanel1.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
            MenuButtonsPanels.setVisible(true);
           RoomSectionPanel.setVisible(true);
        });
        Hotelappear1.setRepeats(false);
        Hotelappear1.start();
        
    }//GEN-LAST:event_OnlinePaymentButton1GA2ActionPerformed

    private void EmailAddressSignUpInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailAddressSignUpInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailAddressSignUpInputActionPerformed

    private void OnlineExitButton1A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlineExitButton1A1ActionPerformed
        // exiting the payment window Paymaya A1
        JOptionPane.showMessageDialog(new JFrame(), "Successfully booked. You will be directly to room section"
         + (" you can view your book info on account info menu."));
        OnlinePaymentWindow2A1.setVisible(false);
        CheckinA1.setVisible(false);
        //making sure the other panel is not visible--
        RoomInfoPanel.setVisible(false);
        MainPanel1.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
            MenuButtonsPanels.setVisible(true);
           RoomSectionPanel.setVisible(true);
        });
        Hotelappear1.setRepeats(false);
        Hotelappear1.start();
    }//GEN-LAST:event_OnlineExitButton1A1ActionPerformed

    private void OnlinePaymentButton2GA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton2GA1ActionPerformed
        // Paymaya window Payment A1
         String guestnameA1, addressA1, roomtypeA1, roompriceA1, totalamount, paymentmethod, paymentstatus;
        
         
        roompriceA1 = RoomPriceA1.getText();
        totalamount = TotalAmountA1Checkin.getText();
        guestnameA1 = CheckInGuestNameA1.getText();
        addressA1 = CheckInGuestAddressA1.getText();
        roomtypeA1 = roomname;
        paymentmethod = "Online payment PayMaya";
        paymentstatus = "Confirmed";
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        
        String AddUserbookfromdatabase = "UPDATE hotelusersdatabase "
                + "SET GuestName=?, Address=?, RoomType=?, RoomPrice=?, BookingSched=?, "
                + "TotalAmount=?, PaymentMethod=?, PaymentStatus=? WHERE Username=?";
        try (Connection con = DriverManager.getConnection(DbURL, DbPhoneNumber, DbPassword);
                    PreparedStatement stmt = con.prepareStatement(AddUserbookfromdatabase)) {
                    stmt.setString(1, guestnameA1);
                    stmt.setString(2, addressA1);
                    stmt.setString(3, roomtypeA1);
                    stmt.setString(4, roompriceA1);
                    stmt.setTimestamp(5, currentTime);
                    stmt.setString(6, totalamount);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        Timer paymentDelayed1 = new Timer(500, e -> {
            OnlinePaymentMainWindow2A1.setVisible(false);
        });
        
        paymentDelayed1.setRepeats(false);
        paymentDelayed1.start();
        Timer paymentDelayed2 = new Timer(500, e -> {
           OnlinePayment2ndWindow2A1.setVisible(true); 
        });
        
        paymentDelayed2.setRepeats(false);
        paymentDelayed2.start();
    }//GEN-LAST:event_OnlinePaymentButton2GA1ActionPerformed

    private void BookButtonB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookButtonB1ActionPerformed
        // Booking button on A3
        if (RoomBooked > 2) {
            JOptionPane.showMessageDialog(new JFrame(), "You can only booked once" + "You can cancel your current booked in Account Info");
        }
        if (LoginEnabled < 2) {
            JOptionPane.showMessageDialog(null, "Before you continue you need to sign in");
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            RoomInfoPanel.setVisible(false);
            //Opening main Login Window
            LoginSystemPanel.setVisible(true);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(true);
            LoginSystemPanel.setOpaque(false);
            
        } else {
            PaymentDetailsA1();
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentMainWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            OnlinePaymentMainWindow2A1.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(true);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowB2.setVisible(false);
            InfoWindowC1.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            PaymentDetailsA1(); 
            PriceDayA1 = 15499;
            PriceNightA1 = 16499;
            DesignCheckin1.setText("Family Room A"); 
            
            
        }
    }//GEN-LAST:event_BookButtonB1ActionPerformed

    private void BookButtonB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookButtonB2ActionPerformed
        // Book button A4 selection
        if (RoomBooked > 2) {
            JOptionPane.showMessageDialog(new JFrame(), "You can only booked once" + "You can cancel your current booked in Account Info");
        }
        if (LoginEnabled < 2) {
            JOptionPane.showMessageDialog(null, "Before you continue you need to sign in");
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            RoomInfoPanel.setVisible(false);
            //Opening main Login Window
            LoginSystemPanel.setVisible(true);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(true);
            LoginSystemPanel.setOpaque(false);
            
        } else {
            PaymentDetailsA1();
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentMainWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            OnlinePaymentMainWindow2A1.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(true);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowB2.setVisible(false);
            InfoWindowC1.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            PaymentDetailsA1(); 
            PriceDayA1 = 17499;
            PriceNightA1 = 18499;
            DesignCheckin1.setText("Family Room B"); 
            
            
        }
    }//GEN-LAST:event_BookButtonB2ActionPerformed

    private void BookButtonC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookButtonC1ActionPerformed
        // Book button A4 selection
        if (RoomBooked > 2) {
            JOptionPane.showMessageDialog(new JFrame(), "You can only booked once" + "You can cancel your current booked in Account Info");
        }
        if (LoginEnabled < 2) {
            JOptionPane.showMessageDialog(null, "Before you continue you need to sign in");
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            RoomInfoPanel.setVisible(false);
            //Opening main Login Window
            LoginSystemPanel.setVisible(true);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(true);
            LoginSystemPanel.setOpaque(false);
            
        } else {
            PaymentDetailsA1();
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentMainWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            OnlinePaymentMainWindow2A1.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(true);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowB2.setVisible(false);
            InfoWindowC1.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            OnlinePaymentWindow1A1.setVisible(false);
            OnlinePaymentWindow2A1.setVisible(false);
            PaymentDetailsA1(); 
            PriceDayA1 = 40499;
            PriceNightA1 = 50499;
            DesignCheckin1.setText("VIP Room"); 
            
            
        }
    }//GEN-LAST:event_BookButtonC1ActionPerformed

    private void ExitLoginButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitLoginButton3ActionPerformed
        // exit Sign in/Sign up
        ExitLoginButton3.setVisible(false);
        ExitMessageMainWindow.setVisible(false);
        ExitLoginButton2.setVisible(false);
        ExitMessageWindowz.setVisible(true);
        ExitMessageWindow.setVisible(true);
        
        Timer timer2 = new Timer(500, e -> {
            ExitMessageMainWindow.setVisible(true);
            ExitMessageMainWindow.setOpaque(false);
            });
        timer2.setRepeats(false);
        timer2.start();
    }//GEN-LAST:event_ExitLoginButton3ActionPerformed

    private void PaymentMethodCheckin2A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin2A2ActionPerformed
        PaymentDetailsA1();
    }//GEN-LAST:event_PaymentMethodCheckin2A2ActionPerformed

    private void PaymentMethodCheckin2A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin2A3ActionPerformed
        PaymentDetailsA1();
    }//GEN-LAST:event_PaymentMethodCheckin2A3ActionPerformed

    private void OnlineExitButton1A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlineExitButton1A2ActionPerformed
       JOptionPane.showMessageDialog(new JFrame(), "Successfully booked. You will be directly to room section"
         + (" you can view your book info on account info menu."));
        OnlinePaymentWindow3A1.setVisible(false);
        OnlinePayment2ndWindow2A2.setVisible(false);
        CheckinA1.setVisible(false);
        //making sure the other panel is not visible--
        RoomInfoPanel.setVisible(false);
        MainPanel1.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
            MenuButtonsPanels.setVisible(true);
           RoomSectionPanel.setVisible(true);
        });
        Hotelappear1.setRepeats(false);
        Hotelappear1.start();
    }//GEN-LAST:event_OnlineExitButton1A2ActionPerformed

    private void OnlinePaymentButton2GA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton2GA2ActionPerformed
        // Paymaya window Payment A1
         String guestnameA1, addressA1, roomtypeA1, roompriceA1, totalamount, paymentmethod, paymentstatus;
        
         
        roompriceA1 = RoomPriceA1.getText();
        totalamount = TotalAmountA1Checkin.getText();
        guestnameA1 = CheckInGuestNameA1.getText();
        addressA1 = CheckInGuestAddressA1.getText();
        roomtypeA1 = roomname;
        paymentmethod = "Aqueza Card(Credit Card)";
        paymentstatus = "Confirmed";
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        
        String AddUserbookfromdatabase = "UPDATE hotelusersdatabase "
                + "SET GuestName=?, Address=?, RoomType=?, RoomPrice=?, BookingSched=?, "
                + "TotalAmount=?, PaymentMethod=?, PaymentStatus=? WHERE Username=?";
        try (Connection con = DriverManager.getConnection(DbURL, DbPhoneNumber, DbPassword);
                    PreparedStatement stmt = con.prepareStatement(AddUserbookfromdatabase)) {
                    stmt.setString(1, guestnameA1);
                    stmt.setString(2, addressA1);
                    stmt.setString(3, roomtypeA1);
                    stmt.setString(4, roompriceA1);
                    stmt.setTimestamp(5, currentTime);
                    stmt.setString(6, totalamount);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        Timer paymentDelayed1 = new Timer(500, e -> {
            OnlinePaymentMainWindow2A2.setVisible(false);
        });
        
        paymentDelayed1.setRepeats(false);
        paymentDelayed1.start();
        Timer paymentDelayed2 = new Timer(500, e -> {
           OnlinePayment2ndWindow2A2.setVisible(true); 
        });
        
        paymentDelayed2.setRepeats(false);
        paymentDelayed2.start();
    }//GEN-LAST:event_OnlinePaymentButton2GA2ActionPerformed

    private void RefundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefundButtonActionPerformed
        //Yes or No Refund
        int responseRefund = JOptionPane.showConfirmDialog(null, "Do you want to cancel your booked room in your account?",
                "Your recent booked payment will be back on your BankAccounts. This is iireversable!! Continue?", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (responseRefund == JOptionPane.YES_OPTION) {
            AccountRefund();
            System.out.println("User clicked YES");
            JOptionPane.showMessageDialog(new JFrame(), "Successfully Cancelled/Refund!" +
                    " Please wait for a few hour/days to get your money back "
                    + "If you didnt recieve the money after a few days, contact support.");
            //turning off Panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomInfoPanel.setVisible(false);
            AccountInfoPanel.setVisible(false);
            //Opening Main Window Account
            LoginSystemPanel.setVisible(true);
            LoginSystemPanel.setVisible(false);
            RegisterFormWindow.setVisible(false);
            LoginFormWindow.setVisible(false);
            MenuButtonsPanels.setVisible(true);
            CompanyNameLabel.setVisible(true);
            AccountRefund();
            
            Timer timer = new Timer(500, e -> {
                RoomSectionPanel.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        } else if (responseRefund == JOptionPane.NO_OPTION) {
            System.out.println("User clicked NO");
        } else {
            System.out.println("User closed the dialog");
        }
    }//GEN-LAST:event_RefundButtonActionPerformed

    private void ViewHotelFeatureButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewHotelFeatureButton1ActionPerformed
        // hotel feature open
        HotelFeaturesPanels.setVisible(true);
        AccountInfoPanel.setVisible(false);
        RoomSectionPanel.setVisible(false);
        MenuButtonsPanels.setVisible(true);
        IntroVid1();
    }//GEN-LAST:event_ViewHotelFeatureButton1ActionPerformed

    private void ShowButtonA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowButtonA1ActionPerformed
        // OutroVid1 Closing Animaiton fadeout
        OutroVid1();
    }//GEN-LAST:event_ShowButtonA1ActionPerformed

    private void FeatureButtonA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButtonA1ActionPerformed
        //Opening Feature1
        Feature1Exit();
    }//GEN-LAST:event_FeatureButtonA1ActionPerformed

    private void FeatureButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButton5ActionPerformed
        //Feature1 Open
        Feature1Selected();
    }//GEN-LAST:event_FeatureButton5ActionPerformed

    private void FeatureButtonA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButtonA2ActionPerformed
        // Feature 2 Exit
        Feature2Exit();
    }//GEN-LAST:event_FeatureButtonA2ActionPerformed

    private void FeatureButtonA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButtonA4ActionPerformed
        // Feature 3 Exit
        Feature3Exit();
    }//GEN-LAST:event_FeatureButtonA4ActionPerformed

    private void FeatureButtonA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButtonA5ActionPerformed
        // Feature 4 Exit
        Feature4Exit();
    }//GEN-LAST:event_FeatureButtonA5ActionPerformed

    private void FeatureButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButton2ActionPerformed
        // Feature 2 Open
        Feature2Selected();
    }//GEN-LAST:event_FeatureButton2ActionPerformed

    private void FeatureButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButton4ActionPerformed
        // Feature 4 Selected
        Feature4Selected();
    }//GEN-LAST:event_FeatureButton4ActionPerformed

    private void FeatureButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeatureButton3ActionPerformed
        // TODO Feature 3 Selected
        Feature3Selected();
    }//GEN-LAST:event_FeatureButton3ActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow1().setVisible(true);
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccountInfoPanel;
    private javax.swing.JPanel AccountInfoPanel1;
    private javax.swing.JPanel AccountInfoPanel2;
    private javax.swing.JLabel AccountNameA1;
    private javax.swing.JLabel AccountNameA2;
    private javax.swing.JLabel AccountNameA3;
    private javax.swing.JLabel AccountNameA4;
    private javax.swing.JLabel AccountNameA5;
    private javax.swing.JLabel AccountNameA6;
    private javax.swing.JLabel AddressInfo;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Background1;
    private javax.swing.JLabel Background10;
    private javax.swing.JLabel Background3;
    private javax.swing.JLabel Background4;
    private javax.swing.JLabel Background5;
    private javax.swing.JLabel Background6;
    private javax.swing.JLabel Background7;
    private javax.swing.JLabel Background8;
    private javax.swing.JLabel Background9;
    private javax.swing.JButton BookButtonA1;
    private javax.swing.JButton BookButtonA2;
    private javax.swing.JButton BookButtonB1;
    private javax.swing.JButton BookButtonB2;
    private javax.swing.JButton BookButtonC1;
    private javax.swing.JButton BookButtonC2;
    private javax.swing.JLabel BookingschedInfo;
    private javax.swing.JTextField CheckInGuestAddressA1;
    private javax.swing.JLabel CheckInGuestAddressA4;
    private javax.swing.JLabel CheckInGuestAddressA6;
    private javax.swing.JLabel CheckInGuestAddressA7;
    private javax.swing.JLabel CheckInGuestAddressA8;
    private javax.swing.JLabel CheckInGuestAddressA9;
    private javax.swing.JTextField CheckInGuestNameA1;
    private javax.swing.JPanel CheckInPayment;
    private javax.swing.JPanel CheckinA1;
    private javax.swing.JLabel CompanyNameLabel;
    private javax.swing.JLabel CompanyTitle;
    private javax.swing.JLabel CompanyTitle1;
    private javax.swing.JButton ConfirmButtonA1Checkin;
    private javax.swing.JButton ContinueButtonLogin;
    private javax.swing.JPanel Decoration1;
    private javax.swing.JTextArea DescIntro1;
    private javax.swing.JPanel DesignA1;
    private javax.swing.JLabel DesignCheckin1;
    private javax.swing.JTextField EmailAddressSignUpInput;
    private javax.swing.JLabel EmailaddressInfo1;
    private javax.swing.JButton ExitButtonLogin;
    private javax.swing.JButton ExitInfoButton;
    private javax.swing.JButton ExitLoginButton2;
    private javax.swing.JButton ExitLoginButton3;
    private javax.swing.JPanel ExitMessageMainWindow;
    private javax.swing.JLabel ExitMessageWindow;
    private javax.swing.JPanel ExitMessageWindowz;
    private javax.swing.JPanel Feature1;
    private javax.swing.JPanel Feature2;
    private javax.swing.JPanel Feature3;
    private javax.swing.JPanel Feature4;
    private javax.swing.JPanel FeatureA1;
    private javax.swing.JPanel FeatureA2;
    private javax.swing.JPanel FeatureA3;
    private javax.swing.JPanel FeatureA4;
    private javax.swing.JPanel FeatureB1;
    private javax.swing.JPanel FeatureB2;
    private javax.swing.JPanel FeatureB3;
    private javax.swing.JPanel FeatureB4;
    private javax.swing.JButton FeatureButton2;
    private javax.swing.JButton FeatureButton3;
    private javax.swing.JButton FeatureButton4;
    private javax.swing.JButton FeatureButton5;
    private javax.swing.JButton FeatureButtonA1;
    private javax.swing.JButton FeatureButtonA2;
    private javax.swing.JButton FeatureButtonA4;
    private javax.swing.JButton FeatureButtonA5;
    private javax.swing.JLabel FeaturesText1;
    private javax.swing.JButton GOSigninWindowButton;
    private javax.swing.JRadioButton GcashOptionA1;
    private javax.swing.JLabel GuestNameInfo1;
    private javax.swing.JPanel HotelFeaturesPanels;
    private javax.swing.JPanel InfoWindowA1;
    private javax.swing.JPanel InfoWindowA2;
    private javax.swing.JPanel InfoWindowB1;
    private javax.swing.JPanel InfoWindowB2;
    private javax.swing.JPanel InfoWindowC1;
    private javax.swing.JPanel InfoWindowC2;
    private javax.swing.JPanel InfoWindows;
    private javax.swing.JLabel LabelCheckinA1;
    private javax.swing.JPanel LoginFormWindow;
    private javax.swing.JPanel LoginSystemPanel;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MainInfoBackgroundPanel1;
    private javax.swing.JLabel MainInfoBackgroundPanel2;
    private javax.swing.JLabel MainInfoBackgroundPanel3;
    private javax.swing.JPanel MainPanel1;
    private javax.swing.JLabel MainPanelBook1;
    private javax.swing.JLabel MainPanelBook2;
    private javax.swing.JTextField MaxDaysCheckinA1;
    private javax.swing.JPanel MenuButtonsPanels;
    private javax.swing.JTextField NumberSignUpInput;
    private javax.swing.JButton OnlineExitButton1A1;
    private javax.swing.JButton OnlineExitButton1A2;
    private javax.swing.JPanel OnlinePayment2ndWindow1A1;
    private javax.swing.JPanel OnlinePayment2ndWindow2A1;
    private javax.swing.JPanel OnlinePayment2ndWindow2A2;
    private javax.swing.JButton OnlinePaymentButton1GA1;
    private javax.swing.JButton OnlinePaymentButton1GA2;
    private javax.swing.JButton OnlinePaymentButton2GA1;
    private javax.swing.JButton OnlinePaymentButton2GA2;
    private javax.swing.JPanel OnlinePaymentChooseA1;
    private javax.swing.JPanel OnlinePaymentMainWindow1A1;
    private javax.swing.JPanel OnlinePaymentMainWindow2A1;
    private javax.swing.JPanel OnlinePaymentMainWindow2A2;
    private javax.swing.JPanel OnlinePaymentWindow1A1;
    private javax.swing.JPanel OnlinePaymentWindow2A1;
    private javax.swing.JPanel OnlinePaymentWindow3A1;
    private javax.swing.JPasswordField PasswordSignUpInput;
    private javax.swing.JPasswordField PasswordSigninInput1;
    private javax.swing.JRadioButton PaymayaOptionA1;
    private javax.swing.JRadioButton PaymentMethodCheckin1A1;
    private javax.swing.JRadioButton PaymentMethodCheckin2A2;
    private javax.swing.JRadioButton PaymentMethodCheckin2A3;
    private javax.swing.JLabel PaymentmethodInfo;
    private javax.swing.JLabel PaymentstatusInfo;
    private javax.swing.JLabel PhonenumberInfo;
    private javax.swing.JLabel Picture;
    private javax.swing.JLabel PriceTextGcash1A2;
    private javax.swing.JLabel PriceTextGcash2A2;
    private javax.swing.JLabel PriceTextPaymaya1A2;
    private javax.swing.JLabel PriceTextPaymaya1A3;
    private javax.swing.JLabel PriceTextPaymaya2A2;
    private javax.swing.JLabel PriceTextPaymaya2A3;
    private javax.swing.JButton RefundButton;
    private javax.swing.JPanel RegisterFormWindow;
    private javax.swing.JButton RoomA1Button;
    private javax.swing.JButton RoomA1Button1;
    private javax.swing.JLabel RoomA1Pic1;
    private javax.swing.JPanel RoomA1S;
    private javax.swing.JPanel RoomA2Pic;
    private javax.swing.JPanel RoomA2S;
    private javax.swing.JPanel RoomASelectionPanel;
    private javax.swing.JButton RoomB1Button;
    private javax.swing.JButton RoomB1Button1;
    private javax.swing.JPanel RoomB1Pic;
    private javax.swing.JPanel RoomB1S;
    private javax.swing.JPanel RoomB1S1;
    private javax.swing.JButton RoomB2Button;
    private javax.swing.JPanel RoomB2Pic;
    private javax.swing.JPanel RoomB2S;
    private javax.swing.JPanel RoomBSelectionPanel1;
    private javax.swing.JPanel RoomBSelectionPanel2;
    private javax.swing.JPanel RoomC1Pic;
    private javax.swing.JPanel RoomInfoPanel;
    private javax.swing.JLabel RoomPriceA1;
    private javax.swing.JLabel RoomPriceA2;
    private javax.swing.JRadioButton RoomSchedDayCheckinA1;
    private javax.swing.JRadioButton RoomSchedNightCheckinA1;
    private javax.swing.JButton RoomSectionButtion;
    private javax.swing.JPanel RoomSectionPanel;
    private javax.swing.JLabel RoompriceInfo;
    private javax.swing.JLabel RoomtypeInfo2;
    private javax.swing.JButton ShowButtonA1;
    private javax.swing.JButton SignInButton1;
    private javax.swing.JButton SignInButton2;
    private javax.swing.JButton SignUpButton1;
    private javax.swing.JPanel Slide1;
    private javax.swing.JPanel Slide2;
    private javax.swing.JLabel TextIntro1;
    private javax.swing.JLabel TextIntroA1;
    private javax.swing.JLabel TextIntroA2;
    private javax.swing.JLabel TextIntroA3;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JTextField TotalAmountA1Checkin;
    private javax.swing.JLabel TotalpriceInfo;
    private javax.swing.JButton UpdatePriceA1Button;
    private javax.swing.JLabel UserNameGreetings;
    private javax.swing.JLabel UsernameInfo;
    private javax.swing.JTextField UsernameSignUpInput;
    private javax.swing.JTextField UsernameSigninInput1;
    private javax.swing.JButton ViewHotelFeatureButton;
    private javax.swing.JButton ViewHotelFeatureButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea13;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    // End of variables declaration//GEN-END:variables
    
}
