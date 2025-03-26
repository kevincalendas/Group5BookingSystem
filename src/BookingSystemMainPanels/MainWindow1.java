package BookingSystemMainPanels;




    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



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
/**
 *
 * @author Kevin
 */
public class MainWindow1 extends javax.swing.JFrame {

    
    public MainWindow1() {
        initComponents();
        
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
        HotelFeaturesPanel.setVisible(false);
        MenuOpenButton.setVisible(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setOpaque(false);
        RoomSectionPanel.setVisible(false);
        RoomInfoPanel.setVisible(false);
        LoginSystemPanel.setVisible(false);
        AccountInfoWindow.setVisible(false);
        CheckInPayment.setVisible(false);
        ExitMessageWindow.setVisible(false);
        
        //total amount update Checkins
        TotalAmountA1Checkin.addActionListener(e -> PaymentDetailsA1());
        TotalAmountCheckinA2.addActionListener(e -> PaymentDetailsA2());
        TotalAmountCheckinA3.addActionListener(e -> PaymentDetailsA3());
        try {
            connection();
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        MenuButtonsPanels.setVisible(false);
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
    private static final String DbURL = "jdbc:mysql://localhost:3306/hotelusers";
    private static final String DbPhoneNumber= "root";
    private static final String DbPassword = "";
    
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
    public void PaymentDetailsA1() {
        //int values
        String inputDays = MaxDaysCheckinA1.getText();
        
        int PriceDayA1 = 8499;
        int PriceNightA1 = 7499;
        int Days = Integer.parseInt(inputDays);
        int result = 0;
        ButtonGroup group = new ButtonGroup();
        group.add(RoomSchedDayCheckinA1);
        group.add(RoomSchedNightCheckinA1); 

        RoomSchedDayCheckinA1.addActionListener(e -> PaymentDetailsA1());
        RoomSchedNightCheckinA1.addActionListener(e -> PaymentDetailsA1());
        
        
        switch(Days) {
            case 1:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 2:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 3:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 4:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 5 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 6 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 7 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 8 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 9 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;
            case 10 :
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
                break;    
            default:
                if (RoomSchedDayCheckinA1.isSelected()) {
                    result = PriceDayA1 * 1;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA1.isSelected()) {
                    result = PriceNightA1 * 1;
                    RoomPriceA1.setText("Room price selected: " + PriceDayA1);
                }
                TotalAmountA1Checkin.setText("PHP " + result);
        }
        
 
       
    }
    public void PaymentMethodA1() {
        if (GcashOptionA1.isSelected()) {
            OnlinePaymentWindow1A1.setVisible(true);
            OnlinePaymentMainWindow1A1.setVisible(true);
            OnlinePayment2ndWindow1A1.setVisible(false);
            PriceTextGcash2A2.setText(TotalAmountA1Checkin.getText());
            PriceTextGcash1A2.setText(TotalAmountA1Checkin.getText());
            System.out.println("GCash Option Has been confirmed! at the room A1");
        }
        if (PaymayaOptionA1.isSelected()) {
            OnlinePaymentWindow2A1.setVisible(true);
            OnlinePaymentMainWindow2A1.setVisible(true);
            OnlinePayment2ndWindow2A1.setVisible(false);
            PriceTextPaymaya1A2.setText(TotalAmountA1Checkin.getText());
            PriceTextPaymaya2A2.setText(TotalAmountA1Checkin.getText());
            System.out.println("PayMaya Option Has been confirmed! at the room A1");
        }
        if (PaymentMethodCheckin3A1.isSelected()) {
            
        }
    }
    public void PaymentCheckInA1() {
        String Usernameee, guestnameA1, addressA1, roomtypeA1, bookingschedA1, totalamountA1, paymentmethodA1;
        
        ButtonGroup PaymentGroup = new ButtonGroup();
        PaymentGroup.add(PaymentMethodCheckin1A1);
        PaymentMethodCheckin1A1.addActionListener(e -> PaymentCheckInA1());
        PaymentGroup.add(PaymentMethodCheckin2A1);
        PaymentMethodCheckin2A1.addActionListener(e -> PaymentCheckInA1());
        PaymentGroup.add(PaymentMethodCheckin3A1);
        PaymentMethodCheckin3A1.addActionListener(e -> PaymentCheckInA1());
        
        ButtonGroup OnlinePaymentSelected = new ButtonGroup();
        OnlinePaymentSelected.add(GcashOptionA1);
        GcashOptionA1.addActionListener(e -> PaymentCheckInA1());
        OnlinePaymentSelected.add(PaymayaOptionA1);
        PaymayaOptionA1.addActionListener(e -> PaymentCheckInA1());
        
        Usernameee = Usernamee;
        int roompriceA1 = 0;
        //getting the details in paymentInfo in standard room
        guestnameA1 = CheckInGuestNameA1.getText();
        addressA1 = CheckInGuestAddressA1.getText();
        roomtypeA1 = "Single Class A";
        if (RoomSchedDayCheckinA1.isSelected()) {
            roompriceA1 = 8499;
        } else if (RoomSchedNightCheckinA1.isSelected()) {
            roompriceA1 = 7499;
        }
        
        
        if ("".equals(CheckInGuestNameA1.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Guest Name");
        } else if ("".equals(CheckInGuestAddressA1.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Address");
        } else if (PaymentGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a payment method.");
        } else if (PaymentMethodCheckin1A1.isSelected()) {
            System.out.println("Online payment has been selected at room 1");
            OnlinePaymentChooseA1.setVisible(true);
        } else if (PaymentMethodCheckin3A1.isSelected()) {
            System.out.println("Online payment has been selected at room 1");
        }
    }
    //Info A2 PaymentDetails Function
    public void PaymentDetailsA2() {
        //int values
        String inputDays = MaxDaysCheckinA2.getText();
        
        int PriceDayA1 = 8499;
        int PriceNightA1 = 10499;
        int Days = Integer.parseInt(inputDays);
        int result = 0;
        ButtonGroup group = new ButtonGroup();
        group.add(RoomSchedDayCheckinA2);
        group.add(RoomSchedNightCheckinA2); 

        RoomSchedDayCheckinA2.addActionListener(e -> PaymentDetailsA2());
        RoomSchedNightCheckinA2.addActionListener(e -> PaymentDetailsA2());
        
        
        switch(Days) {
            case 1:
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 2:
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 3:
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 4:
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 5 :
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 6 :
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 7 :
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 8 :
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 9 :
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
            case 10 :
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;  
            default:
                if (RoomSchedDayCheckinA2.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA2.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA2.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA2.setText("PHP " + result);
                
                break;
        }
        
 
       
    }
    public void PaymentMethodA2() {
        if (GcashOptionA2.isSelected()) {
            OnlinePaymentWindow1A2.setVisible(true);
            OnlinePaymentMainWindow1A2.setVisible(true);
            OnlinePayment2ndWindow1A2.setVisible(false);
            PriceTextGcashA2.setText(TotalAmountCheckinA2.getText());
            PriceTextGcash1A3.setText(TotalAmountCheckinA2.getText());
        }
        if (PaymayaOptionA2.isSelected()) {
            OnlinePaymentWindow2A2.setVisible(true);
            OnlinePaymentMainWindow2A2.setVisible(true);
            OnlinePayment2ndWindow2A2.setVisible(false);
            PriceTextPaymaya1A2.setText(TotalAmountCheckinA2.getText());
            PriceTextPaymaya2A2.setText(TotalAmountCheckinA2.getText());
        }
    }
    public void PaymentCheckInA2() {
        String Usernameee, guestnameA1, addressA1, roomtypeA1, bookingschedA1, totalamountA1, paymentmethodA1;
        
        ButtonGroup PaymentGroup = new ButtonGroup();
        PaymentGroup.add(PaymentMethodCheckin1A2);
        PaymentMethodCheckin1A2.addActionListener(e -> PaymentCheckInA1());
        PaymentGroup.add(PaymentMethodCheckin2A2);
        PaymentMethodCheckin2A2.addActionListener(e -> PaymentCheckInA1());
        PaymentGroup.add(PaymentMethodCheckin3A2);
        PaymentMethodCheckin3A2.addActionListener(e -> PaymentCheckInA1());
        
        ButtonGroup OnlinePaymentSelected = new ButtonGroup();
        OnlinePaymentSelected.add(GcashOptionA2);
        GcashOptionA2.addActionListener(e -> PaymentCheckInA2());
        OnlinePaymentSelected.add(PaymayaOptionA2);
        PaymayaOptionA2.addActionListener(e -> PaymentCheckInA2());
        
        Usernameee = Usernamee;
        int roompriceA1 = 0;
        //getting the details in paymentInfo in standard room
        guestnameA1 = CheckInGuestNameA2.getText();
        addressA1 = CheckInGuestAddressA2.getText();
        roomtypeA1 = "Single Class A";
        if (RoomSchedDayCheckinA2.isSelected()) {
            roompriceA1 = 8499;
        } else if (RoomSchedNightCheckinA2.isSelected()) {
            roompriceA1 = 7499;
        }
        
        
        if ("".equals(CheckInGuestNameA2.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Guest Name");
        } else if ("".equals(CheckInGuestAddressA2.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Address");
        } else if (PaymentGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a payment method.");
        } else if (PaymentMethodCheckin1A2.isSelected()) {
            OnlinePaymentChooseA2.setVisible(true);
        }
    }
    //Info A3 PaymentDetails Function
    public void PaymentDetailsA3() {
        //int values
        String inputDays = MaxDaysCheckinA3.getText();
        
        int PriceDayA1 = 15499;
        int PriceNightA1 = 16499;
        int Days = Integer.parseInt(inputDays);
        int result = 0;
        ButtonGroup group = new ButtonGroup();
        group.add(RoomSchedDayCheckinA3);
        group.add(RoomSchedNightCheckinA3); 

        RoomSchedDayCheckinA3.addActionListener(e -> PaymentDetailsA3());
        RoomSchedNightCheckinA3.addActionListener(e -> PaymentDetailsA3());
        
        
        switch(Days) {
            case 1:
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 2:
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 3:
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 4:
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 5 :
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 6 :
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 7 :
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 8 :
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 9 :
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break;
            case 10 :
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
                break; 
            default:
                if (RoomSchedDayCheckinA3.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA3.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA3.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA3.setText("PHP " + result);
                
        }
        
 
       
    }
    public void PaymentMethodA3() {
        if (GcashOptionA3.isSelected()) {
            OnlinePaymentWindow1A3.setVisible(true);
            OnlinePaymentMainWindow1A3.setVisible(true);
            OnlinePayment2ndWindow1A3.setVisible(false);
            PriceTextGcashA3.setText(TotalAmountCheckinA3.getText());
            PriceTextGcash1A4.setText(TotalAmountCheckinA3.getText());
        }
        if (PaymayaOptionA3.isSelected()) {
            OnlinePaymentWindow2A3.setVisible(true);
            OnlinePaymentMainWindow2A3.setVisible(true);
            OnlinePayment2ndWindow2A3.setVisible(false);
            PriceTextPaymaya1A3.setText(TotalAmountCheckinA3.getText());
            PriceTextPaymaya2A3.setText(TotalAmountCheckinA3.getText());
        }
    }
    public void PaymentCheckInA3() {
        String Usernameee, guestnameA1, addressA1, roomtypeA1, bookingschedA1, totalamountA1, paymentmethodA1;
        
        ButtonGroup PaymentGroup = new ButtonGroup();
        PaymentGroup.add(PaymentMethodCheckin1A3);
        PaymentMethodCheckin1A3.addActionListener(e -> PaymentCheckInA3());
        PaymentGroup.add(PaymentMethodCheckin2A3);
        PaymentMethodCheckin2A3.addActionListener(e -> PaymentCheckInA3());
        PaymentGroup.add(PaymentMethodCheckin3A3);
        PaymentMethodCheckin3A3.addActionListener(e -> PaymentCheckInA3());
        
        ButtonGroup OnlinePaymentSelected = new ButtonGroup();
        OnlinePaymentSelected.add(GcashOptionA3);
        GcashOptionA3.addActionListener(e -> PaymentCheckInA3());
        OnlinePaymentSelected.add(PaymayaOptionA3);
        PaymayaOptionA3.addActionListener(e -> PaymentCheckInA3());
        
        Usernameee = Usernamee;
        int roompriceA1 = 0;
        //getting the details in paymentInfo in standard room
        guestnameA1 = CheckInGuestNameA3.getText();
        addressA1 = CheckInGuestAddressA3.getText();
        roomtypeA1 = "Single Class A";
        if (RoomSchedDayCheckinA3.isSelected()) {
            roompriceA1 = 15499;
        } else if (RoomSchedNightCheckinA3.isSelected()) {
            roompriceA1 = 16499;
        }
        
        
        if ("".equals(CheckInGuestNameA3.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Guest Name");
        } else if ("".equals(CheckInGuestAddressA3.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Address");
        } else if (PaymentGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a payment method.");
        } else if (PaymentMethodCheckin1A3.isSelected()) {
            OnlinePaymentChooseA3.setVisible(true);
        }
    }
    //Info A4 PaymentDetails Function
    public void PaymentDetailsA4() {
        //int values
        String inputDays = MaxDaysCheckinA4.getText();
        
        int PriceDayA1 = 15499;
        int PriceNightA1 = 16499;
        int Days = Integer.parseInt(inputDays);
        int result = 0;
        ButtonGroup group = new ButtonGroup();
        group.add(RoomSchedDayCheckinA4);
        group.add(RoomSchedNightCheckinA4); 

        RoomSchedDayCheckinA4.addActionListener(e -> PaymentDetailsA4());
        RoomSchedNightCheckinA4.addActionListener(e -> PaymentDetailsA4());
        
        
        switch(Days) {
            case 1:
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 2:
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 3:
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 4:
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 5 :
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 6 :
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 7 :
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 8 :
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 9 :
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            case 10 :
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
                
                break;
            default:
                if (RoomSchedDayCheckinA4.isSelected()) {
                    result = PriceDayA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceDayA1);
                } else if (RoomSchedNightCheckinA4.isSelected()) {
                    result = PriceNightA1 * Days;
                    RoomPriceA4.setText("Room price selected: " + PriceNightA1);
                }
                TotalAmountCheckinA4.setText("PHP " + result);
        }
        
 
       
    }
    public void PaymentMethodA4() {
        if (GcashOptionA4.isSelected()) {
            OnlinePaymentWindow1A4.setVisible(true);
            OnlinePaymentMainWindow1A4.setVisible(true);
            OnlinePayment2ndWindow1A4.setVisible(false);
            PriceTextGcashA4.setText(TotalAmountCheckinA4.getText());
            PriceTextGcash1A4.setText(TotalAmountCheckinA4.getText());
        }
        if (PaymayaOptionA4.isSelected()) {
            OnlinePaymentWindow2A4.setVisible(true);
            OnlinePaymentMainWindow2A4.setVisible(true);
            OnlinePayment2ndWindow2A4.setVisible(false);
            PriceTextPaymaya1A4.setText(TotalAmountCheckinA4.getText());
            PriceTextPaymaya2A4.setText(TotalAmountCheckinA4.getText());
        }
    }
    public void PaymentCheckInA4() {
        String Usernameee, guestnameA1, addressA1, roomtypeA1, bookingschedA1, totalamountA1, paymentmethodA1;
        
        ButtonGroup PaymentGroup = new ButtonGroup();
        PaymentGroup.add(PaymentMethodCheckin1A4);
        PaymentMethodCheckin1A4.addActionListener(e -> PaymentCheckInA3());
        PaymentGroup.add(PaymentMethodCheckin2A4);
        PaymentMethodCheckin2A4.addActionListener(e -> PaymentCheckInA3());
        PaymentGroup.add(PaymentMethodCheckin3A4);
        PaymentMethodCheckin3A4.addActionListener(e -> PaymentCheckInA3());
        
        ButtonGroup OnlinePaymentSelected = new ButtonGroup();
        OnlinePaymentSelected.add(GcashOptionA4);
        GcashOptionA4.addActionListener(e -> PaymentCheckInA3());
        OnlinePaymentSelected.add(PaymayaOptionA4);
        PaymayaOptionA4.addActionListener(e -> PaymentCheckInA3());
        
        Usernameee = Usernamee;
        int roompriceA1 = 0;
        //getting the details in paymentInfo in standard room
        guestnameA1 = CheckInGuestNameA4.getText();
        addressA1 = CheckInGuestAddressA4.getText();
        roomtypeA1 = "Single Class A";
        if (RoomSchedDayCheckinA4.isSelected()) {
            roompriceA1 = 15499;
        } else if (RoomSchedNightCheckinA4.isSelected()) {
            roompriceA1 = 16499;
        }
        
        
        if ("".equals(CheckInGuestNameA4.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Guest Name");
        } else if ("".equals(CheckInGuestAddressA4.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Required Address");
        } else if (PaymentGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a payment method.");
        } else if (PaymentMethodCheckin1A4.isSelected()) {
            OnlinePaymentChooseA4.setVisible(true);
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
        }  else if ("".equals(PasswordSignUpInput.getText())) {
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
        }  else if (PasswordSignUpInput.getText().length() > 45) {
            JOptionPane.showMessageDialog(new JFrame(), "Maximum 45 characters allowed!");
            PasswordSignUpInput.setText("");
        }  else if (PasswordSignUpInput.getText().length() < 8) {
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
            Password = PasswordSignUpInput.getText();
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

        MenuOpenButton = new javax.swing.JButton();
        HotelFeaturesPanel = new javax.swing.JPanel();
        MenuButtonsPanels = new javax.swing.JPanel();
        UserNameGreetings = new javax.swing.JLabel();
        ViewHotelFeatureButton = new javax.swing.JButton();
        ExitMenuButton = new javax.swing.JButton();
        RoomSectionButtion = new javax.swing.JButton();
        ViewHotelFeatureButton1 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
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
        RoomSectionPanel = new javax.swing.JPanel();
        CompanyNameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        RoomBSelectionPanel2 = new javax.swing.JPanel();
        RoomB2S1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        RoomB2Button1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        RoomB1S1 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        RoomB1Button1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        RoomBSelectionPanel1 = new javax.swing.JPanel();
        RoomB2S = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        RoomB2Button = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        RoomB1S = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        RoomB1Button = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        RoomASelectionPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        RoomA2S = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RoomA1Button1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        RoomA1S = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        RoomA1Button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Background = new javax.swing.JLabel();
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
        OnlinePaymentChooseA1 = new javax.swing.JPanel();
        Designnn = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        GcashOptionA1 = new javax.swing.JRadioButton();
        PaymayaOptionA1 = new javax.swing.JRadioButton();
        UpdatePriceA1Button = new javax.swing.JButton();
        ConfirmButtonA1Checkin = new javax.swing.JButton();
        RoomSchedNightCheckinA1 = new javax.swing.JRadioButton();
        RoomSchedDayCheckinA1 = new javax.swing.JRadioButton();
        PaymentMethodCheckin1A1 = new javax.swing.JRadioButton();
        PaymentMethodCheckin2A1 = new javax.swing.JRadioButton();
        PaymentMethodCheckin3A1 = new javax.swing.JRadioButton();
        CheckInGuestNameA1 = new javax.swing.JTextField();
        CheckInGuestAddressA1 = new javax.swing.JTextField();
        TotalAmountA1Checkin = new javax.swing.JTextField();
        CheckInGuestAddressA8 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        MaxDaysCheckinA1 = new javax.swing.JTextField();
        RoomPriceA1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        AddressLabel = new javax.swing.JLabel();
        DesignCheckin1 = new javax.swing.JLabel();
        CheckInGuestAddressA4 = new javax.swing.JLabel();
        CheckInGuestAddressA7 = new javax.swing.JLabel();
        LabelCheckinA1 = new javax.swing.JLabel();
        LabelCheckinA2 = new javax.swing.JLabel();
        CheckInGuestAddressA6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Background5 = new javax.swing.JLabel();
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
        OnlinePayment2ndWindow3A1 = new javax.swing.JPanel();
        jLabel205 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        PriceTextPaymaya2A6 = new javax.swing.JLabel();
        AccountNameA17 = new javax.swing.JLabel();
        OnlineExitButton1A5 = new javax.swing.JButton();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        OnlinePaymentMainWindow3A1 = new javax.swing.JPanel();
        jLabel213 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        PriceTextPaymaya1A6 = new javax.swing.JLabel();
        AccountNameA18 = new javax.swing.JLabel();
        OnlinePaymentButton2GA5 = new javax.swing.JButton();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        CheckInGuestAddressA9 = new javax.swing.JLabel();
        CheckinA2 = new javax.swing.JPanel();
        OnlinePaymentWindow1A2 = new javax.swing.JPanel();
        OnlinePayment2ndWindow1A2 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        PriceTextGcash1A3 = new javax.swing.JLabel();
        AccountNameA5 = new javax.swing.JLabel();
        OnlinePaymentButton1GA3 = new javax.swing.JButton();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        OnlinePaymentMainWindow1A2 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        PriceTextGcashA2 = new javax.swing.JLabel();
        AccountNameA6 = new javax.swing.JLabel();
        OnlinePaymentButton1GA4 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        OnlinePaymentWindow2A2 = new javax.swing.JPanel();
        OnlinePayment2ndWindow2A2 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        PriceTextPaymaya2A3 = new javax.swing.JLabel();
        AccountNameA7 = new javax.swing.JLabel();
        OnlineExitButton1A2 = new javax.swing.JButton();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        OnlinePaymentMainWindow2A2 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        PriceTextPaymaya1A3 = new javax.swing.JLabel();
        AccountNameA8 = new javax.swing.JLabel();
        OnlinePaymentButton2GA2 = new javax.swing.JButton();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        OnlinePaymentChooseA2 = new javax.swing.JPanel();
        Designnn1 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        GcashOptionA2 = new javax.swing.JRadioButton();
        PaymayaOptionA2 = new javax.swing.JRadioButton();
        UpdatePriceA1Button1 = new javax.swing.JButton();
        ConfirmButtonA1Checkin1 = new javax.swing.JButton();
        RoomSchedNightCheckinA2 = new javax.swing.JRadioButton();
        RoomSchedDayCheckinA2 = new javax.swing.JRadioButton();
        PaymentMethodCheckin1A2 = new javax.swing.JRadioButton();
        PaymentMethodCheckin2A2 = new javax.swing.JRadioButton();
        PaymentMethodCheckin3A2 = new javax.swing.JRadioButton();
        CheckInGuestNameA2 = new javax.swing.JTextField();
        CheckInGuestAddressA2 = new javax.swing.JTextField();
        TotalAmountCheckinA2 = new javax.swing.JTextField();
        RoomPriceA2 = new javax.swing.JLabel();
        CheckInGuestAddressA14 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        MaxDaysCheckinA2 = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        AddressLabel1 = new javax.swing.JLabel();
        DesignCheckin2 = new javax.swing.JLabel();
        CheckInGuestAddressA5 = new javax.swing.JLabel();
        CheckInGuestAddressA11 = new javax.swing.JLabel();
        LabelCheckinA3 = new javax.swing.JLabel();
        LabelCheckinA4 = new javax.swing.JLabel();
        CheckInGuestAddressA12 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        Background6 = new javax.swing.JLabel();
        CheckInGuestAddressA13 = new javax.swing.JLabel();
        CheckinA3 = new javax.swing.JPanel();
        OnlinePaymentWindow1A3 = new javax.swing.JPanel();
        OnlinePayment2ndWindow1A3 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        PriceTextGcash1A4 = new javax.swing.JLabel();
        AccountNameA9 = new javax.swing.JLabel();
        OnlinePaymentButton1GA5 = new javax.swing.JButton();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        OnlinePaymentMainWindow1A3 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        PriceTextGcashA3 = new javax.swing.JLabel();
        AccountNameA10 = new javax.swing.JLabel();
        OnlinePaymentButton1GA6 = new javax.swing.JButton();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        OnlinePaymentWindow2A3 = new javax.swing.JPanel();
        OnlinePayment2ndWindow2A3 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        PriceTextPaymaya2A4 = new javax.swing.JLabel();
        AccountNameA11 = new javax.swing.JLabel();
        OnlineExitButton1A3 = new javax.swing.JButton();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        OnlinePaymentMainWindow2A3 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        PriceTextPaymaya1A4 = new javax.swing.JLabel();
        AccountNameA12 = new javax.swing.JLabel();
        OnlinePaymentButton2GA3 = new javax.swing.JButton();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        OnlinePaymentChooseA3 = new javax.swing.JPanel();
        Designnn2 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        GcashOptionA3 = new javax.swing.JRadioButton();
        PaymayaOptionA3 = new javax.swing.JRadioButton();
        UpdatePriceA1Button2 = new javax.swing.JButton();
        ConfirmButtonA1Checkin2 = new javax.swing.JButton();
        RoomSchedNightCheckinA3 = new javax.swing.JRadioButton();
        RoomSchedDayCheckinA3 = new javax.swing.JRadioButton();
        PaymentMethodCheckin1A3 = new javax.swing.JRadioButton();
        PaymentMethodCheckin2A3 = new javax.swing.JRadioButton();
        PaymentMethodCheckin3A3 = new javax.swing.JRadioButton();
        CheckInGuestNameA3 = new javax.swing.JTextField();
        CheckInGuestAddressA3 = new javax.swing.JTextField();
        TotalAmountCheckinA3 = new javax.swing.JTextField();
        RoomPriceA3 = new javax.swing.JLabel();
        CheckInGuestAddressA15 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        MaxDaysCheckinA3 = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        AddressLabel2 = new javax.swing.JLabel();
        DesignCheckin3 = new javax.swing.JLabel();
        CheckInGuestAddressA10 = new javax.swing.JLabel();
        CheckInGuestAddressA16 = new javax.swing.JLabel();
        LabelCheckinA5 = new javax.swing.JLabel();
        LabelCheckinA6 = new javax.swing.JLabel();
        CheckInGuestAddressA17 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        Background7 = new javax.swing.JLabel();
        CheckInGuestAddressA18 = new javax.swing.JLabel();
        CheckinA4 = new javax.swing.JPanel();
        OnlinePaymentWindow1A4 = new javax.swing.JPanel();
        OnlinePayment2ndWindow1A4 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        PriceTextGcash1A5 = new javax.swing.JLabel();
        AccountNameA13 = new javax.swing.JLabel();
        OnlinePaymentButton1GA7 = new javax.swing.JButton();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        OnlinePaymentMainWindow1A4 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        PriceTextGcashA4 = new javax.swing.JLabel();
        AccountNameA14 = new javax.swing.JLabel();
        OnlinePaymentButton1GA8 = new javax.swing.JButton();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        OnlinePaymentWindow2A4 = new javax.swing.JPanel();
        OnlinePayment2ndWindow2A4 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        PriceTextPaymaya2A5 = new javax.swing.JLabel();
        AccountNameA15 = new javax.swing.JLabel();
        OnlineExitButton1A4 = new javax.swing.JButton();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        OnlinePaymentMainWindow2A4 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        PriceTextPaymaya1A5 = new javax.swing.JLabel();
        AccountNameA16 = new javax.swing.JLabel();
        OnlinePaymentButton2GA4 = new javax.swing.JButton();
        jLabel198 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        OnlinePaymentChooseA4 = new javax.swing.JPanel();
        Designnn3 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        GcashOptionA4 = new javax.swing.JRadioButton();
        PaymayaOptionA4 = new javax.swing.JRadioButton();
        UpdatePriceA1Button3 = new javax.swing.JButton();
        ConfirmButtonA1Checkin3 = new javax.swing.JButton();
        RoomSchedNightCheckinA4 = new javax.swing.JRadioButton();
        RoomSchedDayCheckinA4 = new javax.swing.JRadioButton();
        PaymentMethodCheckin1A4 = new javax.swing.JRadioButton();
        PaymentMethodCheckin2A4 = new javax.swing.JRadioButton();
        PaymentMethodCheckin3A4 = new javax.swing.JRadioButton();
        CheckInGuestNameA4 = new javax.swing.JTextField();
        CheckInGuestAddress1A4 = new javax.swing.JTextField();
        TotalAmountCheckinA4 = new javax.swing.JTextField();
        RoomPriceA4 = new javax.swing.JLabel();
        CheckInGuestAddressA20 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        MaxDaysCheckinA4 = new javax.swing.JTextField();
        jLabel203 = new javax.swing.JLabel();
        AddressLabel3 = new javax.swing.JLabel();
        DesignCheckin4 = new javax.swing.JLabel();
        CheckInGuestAddressA21 = new javax.swing.JLabel();
        CheckInGuestAddressA22 = new javax.swing.JLabel();
        LabelCheckinA7 = new javax.swing.JLabel();
        LabelCheckinA8 = new javax.swing.JLabel();
        CheckInGuestAddressA23 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        Background8 = new javax.swing.JLabel();
        CheckInGuestAddressA24 = new javax.swing.JLabel();
        LoginSystemPanel = new javax.swing.JPanel();
        AccountInfoPanel = new javax.swing.JPanel();
        ExitMessageWindow = new javax.swing.JPanel();
        ExitMessageMainWindow = new javax.swing.JPanel();
        ExitButtonLogin = new javax.swing.JButton();
        ContinueButtonLogin = new javax.swing.JButton();
        jTextArea4 = new javax.swing.JTextArea();
        ExitLoginButton2 = new javax.swing.JButton();
        LoginFormWindow = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        PasswordSigninInput1 = new javax.swing.JPasswordField();
        UsernameSigninInput1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        SignInButton1 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        SignInButton2 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        RegisterFormWindow = new javax.swing.JPanel();
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
        AccountInfoWindow = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        Background2 = new javax.swing.JLabel();
        Background3 = new javax.swing.JLabel();
        Background4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuOpenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/Logo1-removebg-preview - 40x40.png"))); // NOI18N
        MenuOpenButton.setBorder(null);
        MenuOpenButton.setBorderPainted(false);
        MenuOpenButton.setContentAreaFilled(false);
        MenuOpenButton.setFocusPainted(false);
        MenuOpenButton.setRolloverEnabled(false);
        MenuOpenButton.setVerifyInputWhenFocusTarget(false);
        MenuOpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOpenButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MenuOpenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HotelFeaturesPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        HotelFeaturesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(HotelFeaturesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MenuButtonsPanels.setBackground(new java.awt.Color(213, 208, 153, 200));
        MenuButtonsPanels.setPreferredSize(new java.awt.Dimension(250, 500));
        MenuButtonsPanels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserNameGreetings.setBackground(new java.awt.Color(255, 255, 255));
        UserNameGreetings.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        UserNameGreetings.setForeground(new java.awt.Color(255, 255, 255));
        UserNameGreetings.setText("Username!");
        MenuButtonsPanels.add(UserNameGreetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 200, 20));

        ViewHotelFeatureButton.setBackground(new java.awt.Color(209, 199, 155));
        ViewHotelFeatureButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ViewHotelFeatureButton.setForeground(new java.awt.Color(255, 255, 255));
        ViewHotelFeatureButton.setText("Account/User");
        ViewHotelFeatureButton.setBorder(null);
        ViewHotelFeatureButton.setBorderPainted(false);
        ViewHotelFeatureButton.setContentAreaFilled(false);
        ViewHotelFeatureButton.setDefaultCapable(false);
        ViewHotelFeatureButton.setFocusTraversalPolicyProvider(true);
        ViewHotelFeatureButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ViewHotelFeatureButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewHotelFeatureButton.setOpaque(true);
        ViewHotelFeatureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewHotelFeatureButtonActionPerformed(evt);
            }
        });
        MenuButtonsPanels.add(ViewHotelFeatureButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, 40));

        ExitMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/Logo1-removebg-preview - 40x40.png"))); // NOI18N
        ExitMenuButton.setBorder(null);
        ExitMenuButton.setBorderPainted(false);
        ExitMenuButton.setContentAreaFilled(false);
        ExitMenuButton.setDefaultCapable(false);
        ExitMenuButton.setFocusTraversalPolicyProvider(true);
        ExitMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuButtonActionPerformed(evt);
            }
        });
        MenuButtonsPanels.add(ExitMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RoomSectionButtion.setBackground(new java.awt.Color(209, 199, 155));
        RoomSectionButtion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        RoomSectionButtion.setForeground(new java.awt.Color(255, 255, 255));
        RoomSectionButtion.setText("Available Rooms");
        RoomSectionButtion.setBorder(null);
        RoomSectionButtion.setBorderPainted(false);
        RoomSectionButtion.setContentAreaFilled(false);
        RoomSectionButtion.setDefaultCapable(false);
        RoomSectionButtion.setFocusTraversalPolicyProvider(true);
        RoomSectionButtion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RoomSectionButtion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RoomSectionButtion.setOpaque(true);
        RoomSectionButtion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSectionButtionActionPerformed(evt);
            }
        });
        MenuButtonsPanels.add(RoomSectionButtion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 250, 40));

        ViewHotelFeatureButton1.setBackground(new java.awt.Color(209, 199, 155));
        ViewHotelFeatureButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ViewHotelFeatureButton1.setForeground(new java.awt.Color(255, 255, 255));
        ViewHotelFeatureButton1.setText("Hotel Essentials");
        ViewHotelFeatureButton1.setBorder(null);
        ViewHotelFeatureButton1.setBorderPainted(false);
        ViewHotelFeatureButton1.setContentAreaFilled(false);
        ViewHotelFeatureButton1.setDefaultCapable(false);
        ViewHotelFeatureButton1.setFocusTraversalPolicyProvider(true);
        ViewHotelFeatureButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ViewHotelFeatureButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewHotelFeatureButton1.setOpaque(true);
        ViewHotelFeatureButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewHotelFeatureButton1ActionPerformed(evt);
            }
        });
        MenuButtonsPanels.add(ViewHotelFeatureButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, 40));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Welcome to Auqeza");
        MenuButtonsPanels.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 200, 20));

        getContentPane().add(MenuButtonsPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        RoomSectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CompanyNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        CompanyNameLabel.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        CompanyNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        CompanyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanyNameLabel.setText("Auqeza Suites");
        RoomSectionPanel.add(CompanyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 0, 820, 40));

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1000, 460));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(998, 1130));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RoomBSelectionPanel2.setBackground(new java.awt.Color(0, 0, 0));
        RoomBSelectionPanel2.setOpaque(false);
        RoomBSelectionPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RoomB2S1.setBackground(new java.awt.Color(0,0,0, 90));
        RoomB2S1.setPreferredSize(new java.awt.Dimension(250, 300));
        RoomB2S1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(51, 51, 51, 200));
        jPanel19.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel59.setBackground(new java.awt.Color(238, 236, 200));
        jLabel59.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(238, 236, 200));
        jLabel59.setText("  1-10 Capacity/Pax");
        jLabel59.setPreferredSize(new java.awt.Dimension(250, 25));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomB2S1.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, -1, -1));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/VIPRoom2 - Copy.png"))); // NOI18N
        jLabel33.setPreferredSize(new java.awt.Dimension(400, 200));
        RoomB2S1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        RoomB2Button1.setBackground(new java.awt.Color(228, 223, 192));
        RoomB2Button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomB2Button1.setForeground(new java.awt.Color(125, 109, 69));
        RoomB2Button1.setText("See room info");
        RoomB2Button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomB2Button1.setContentAreaFilled(false);
        RoomB2Button1.setFocusable(false);
        RoomB2Button1.setOpaque(true);
        RoomB2Button1.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomB2Button1.setRolloverEnabled(false);
        RoomB2Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomB2Button1ActionPerformed(evt);
            }
        });
        RoomB2S1.add(RoomB2Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 30));

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel34.setText("3 rooms Available");
        RoomB2S1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 200, 20));

        jLabel35.setBackground(new java.awt.Color(238, 236, 200));
        jLabel35.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(238, 236, 200));
        jLabel35.setText("VIP Room B");
        RoomB2S1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 200, 30));

        jLabel36.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(213, 204, 179));
        jLabel36.setText("₱ 55,499 night/₱ 60,499 day");
        RoomB2S1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        RoomBSelectionPanel2.add(RoomB2S1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        RoomB1S1.setBackground(new java.awt.Color(0,0,0, 90));
        RoomB1S1.setPreferredSize(new java.awt.Dimension(250, 300));
        RoomB1S1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(51, 51, 51, 200));
        jPanel18.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel46.setBackground(new java.awt.Color(238, 236, 200));
        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(238, 236, 200));
        jLabel46.setText("  1-8 Capacity/Pax");
        jLabel46.setPreferredSize(new java.awt.Dimension(250, 25));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomB1S1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, -1, -1));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/VIPRoom1 - Copy.jpg"))); // NOI18N
        jLabel37.setPreferredSize(new java.awt.Dimension(400, 200));
        RoomB1S1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 200));

        RoomB1Button1.setBackground(new java.awt.Color(228, 223, 192));
        RoomB1Button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomB1Button1.setForeground(new java.awt.Color(125, 109, 69));
        RoomB1Button1.setText("See room info");
        RoomB1Button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomB1Button1.setContentAreaFilled(false);
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
        RoomB1S1.add(RoomB1Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 30));

        jLabel38.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel38.setText("3 rooms Available");
        RoomB1S1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 200, 20));

        jLabel39.setBackground(new java.awt.Color(238, 236, 200));
        jLabel39.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(238, 236, 200));
        jLabel39.setText("VIP Room A");
        RoomB1S1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 200, 30));

        jLabel40.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(213, 204, 179));
        jLabel40.setText("₱ 40,499 night/₱ 50,499 day");
        RoomB1S1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 220, 20));

        RoomBSelectionPanel2.add(RoomB1S1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel41.setBackground(new java.awt.Color(238, 236, 200));
        jLabel41.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(238, 236, 200));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("VIP");
        RoomBSelectionPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 10, 820, 40));

        jPanel9.setBackground(new java.awt.Color(197, 179, 124));
        jPanel9.setPreferredSize(new java.awt.Dimension(50, 2));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        RoomBSelectionPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jPanel1.add(RoomBSelectionPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 950, -1));

        RoomBSelectionPanel1.setBackground(new java.awt.Color(0, 0, 0));
        RoomBSelectionPanel1.setOpaque(false);
        RoomBSelectionPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RoomB2S.setBackground(new java.awt.Color(0,0,0, 90));
        RoomB2S.setPreferredSize(new java.awt.Dimension(250, 300));
        RoomB2S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(51, 51, 51, 200));
        jPanel17.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel42.setBackground(new java.awt.Color(238, 236, 200));
        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(238, 236, 200));
        jLabel42.setText("  4-6 Capacity/Pax");
        jLabel42.setPreferredSize(new java.awt.Dimension(250, 25));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomB2S.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, -1, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/FamilyRoom2 - Copy.jpg"))); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(400, 200));
        RoomB2S.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        RoomB2Button.setBackground(new java.awt.Color(228, 223, 192));
        RoomB2Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomB2Button.setForeground(new java.awt.Color(125, 109, 69));
        RoomB2Button.setText("See room info");
        RoomB2Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomB2Button.setContentAreaFilled(false);
        RoomB2Button.setFocusable(false);
        RoomB2Button.setOpaque(true);
        RoomB2Button.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomB2Button.setRolloverEnabled(false);
        RoomB2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomB2ButtonActionPerformed(evt);
            }
        });
        RoomB2S.add(RoomB2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 30));

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText("3 rooms Available");
        RoomB2S.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 200, 20));

        jLabel18.setBackground(new java.awt.Color(238, 236, 200));
        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 236, 200));
        jLabel18.setText("Family Room B");
        RoomB2S.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 200, 30));

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(213, 204, 179));
        jLabel27.setText("₱ 17,499 night/₱ 18,499 day");
        RoomB2S.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 230, 20));

        RoomBSelectionPanel1.add(RoomB2S, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        RoomB1S.setBackground(new java.awt.Color(0,0,0, 90));
        RoomB1S.setPreferredSize(new java.awt.Dimension(250, 300));
        RoomB1S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(51, 51, 51, 200));
        jPanel16.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel32.setBackground(new java.awt.Color(238, 236, 200));
        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(238, 236, 200));
        jLabel32.setText("  4 Capacity/Pax");
        jLabel32.setPreferredSize(new java.awt.Dimension(250, 25));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomB1S.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, -1, -1));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/FamilyRoom1 - Copy.jpg"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(400, 200));
        RoomB1S.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 200));

        RoomB1Button.setBackground(new java.awt.Color(228, 223, 192));
        RoomB1Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomB1Button.setForeground(new java.awt.Color(125, 109, 69));
        RoomB1Button.setText("See room info");
        RoomB1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomB1Button.setContentAreaFilled(false);
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
        RoomB1S.add(RoomB1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 30));

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel20.setText("3 rooms Available");
        RoomB1S.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 200, 20));

        jLabel21.setBackground(new java.awt.Color(238, 236, 200));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(238, 236, 200));
        jLabel21.setText("Family Room A");
        RoomB1S.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 200, 30));

        jLabel28.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(213, 204, 179));
        jLabel28.setText("₱ 15,499 night/₱ 16,499 day");
        RoomB1S.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 20));

        RoomBSelectionPanel1.add(RoomB1S, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel22.setBackground(new java.awt.Color(238, 236, 200));
        jLabel22.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(238, 236, 200));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Family Class Rooms");
        RoomBSelectionPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 820, 40));

        jPanel8.setBackground(new java.awt.Color(197, 179, 124));
        jPanel8.setPreferredSize(new java.awt.Dimension(50, 2));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        RoomBSelectionPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jPanel1.add(RoomBSelectionPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 950, -1));

        RoomASelectionPanel.setBackground(new java.awt.Color(0, 0, 0));
        RoomASelectionPanel.setOpaque(false);
        RoomASelectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(197, 179, 124));
        jPanel5.setPreferredSize(new java.awt.Dimension(50, 2));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        RoomASelectionPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        RoomA2S.setBackground(new java.awt.Color(0,0,0, 90));
        RoomA2S.setPreferredSize(new java.awt.Dimension(250, 300));
        RoomA2S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(51, 51, 51, 200));
        jPanel14.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel30.setBackground(new java.awt.Color(238, 236, 200));
        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(238, 236, 200));
        jLabel30.setText("  2-4 Capacity/Pax");
        jLabel30.setPreferredSize(new java.awt.Dimension(250, 25));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomA2S.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/DoubleClassA - Copy.jpg"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(400, 200));
        RoomA2S.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        RoomA1Button1.setBackground(new java.awt.Color(228, 223, 192));
        RoomA1Button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomA1Button1.setForeground(new java.awt.Color(125, 109, 69));
        RoomA1Button1.setText("See room info");
        RoomA1Button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomA1Button1.setContentAreaFilled(false);
        RoomA1Button1.setDefaultCapable(false);
        RoomA1Button1.setFocusPainted(false);
        RoomA1Button1.setFocusable(false);
        RoomA1Button1.setOpaque(true);
        RoomA1Button1.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomA1Button1.setVerifyInputWhenFocusTarget(false);
        RoomA1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomA1Button1ActionPerformed(evt);
            }
        });
        RoomA2S.add(RoomA1Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("3 rooms Available");
        RoomA2S.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 200, 20));

        jLabel7.setBackground(new java.awt.Color(238, 236, 200));
        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(238, 236, 200));
        jLabel7.setText("Double Class A");
        RoomA2S.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 200, 30));

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(213, 204, 179));
        jLabel24.setText("₱ 9,499 night / ₱ 10,499 day");
        RoomA2S.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 230, 220, 20));

        RoomASelectionPanel.add(RoomA2S, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        RoomA1S.setBackground(new java.awt.Color(0,0,0, 90));
        RoomA1S.setPreferredSize(new java.awt.Dimension(250, 300));
        RoomA1S.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(51, 51, 51, 200));
        jPanel15.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel31.setBackground(new java.awt.Color(238, 236, 200));
        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(238, 236, 200));
        jLabel31.setText("  1 Capacity/Pax");
        jLabel31.setPreferredSize(new java.awt.Dimension(250, 25));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        RoomA1S.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RoomPicturesABC/SingleClassA - Copy.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 200));
        RoomA1S.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 200));

        RoomA1Button.setBackground(new java.awt.Color(228, 223, 192));
        RoomA1Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RoomA1Button.setForeground(new java.awt.Color(125, 109, 69));
        RoomA1Button.setText("See room info");
        RoomA1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(197, 181, 153), 2));
        RoomA1Button.setContentAreaFilled(false);
        RoomA1Button.setDefaultCapable(false);
        RoomA1Button.setFocusPainted(false);
        RoomA1Button.setFocusable(false);
        RoomA1Button.setOpaque(true);
        RoomA1Button.setPreferredSize(new java.awt.Dimension(150, 25));
        RoomA1Button.setVerifyInputWhenFocusTarget(false);
        RoomA1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomA1ButtonActionPerformed(evt);
            }
        });
        RoomA1S.add(RoomA1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("3 rooms Available");
        RoomA1S.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 250, 200, 20));

        jLabel4.setBackground(new java.awt.Color(238, 236, 200));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 236, 200));
        jLabel4.setText("Single Class A");
        RoomA1S.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 200, 30));

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(213, 204, 179));
        jLabel23.setText("₱ 7,499 night/₱ 8,499 day");
        RoomA1S.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 230, 200, 20));

        RoomASelectionPanel.add(RoomA1S, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jLabel11.setBackground(new java.awt.Color(238, 236, 200));
        jLabel11.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 236, 200));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Standard Class Rooms");
        RoomASelectionPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 820, 40));

        jPanel1.add(RoomASelectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane2.setViewportView(jPanel1);

        RoomSectionPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 980, -1));

        Background.setBackground(new java.awt.Color(0, 0, 0));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background.setPreferredSize(new java.awt.Dimension(1000, 500));
        RoomSectionPanel.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(RoomSectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        RoomInfoPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        RoomInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InfoWindows.setBackground(new java.awt.Color(102, 102, 102));
        InfoWindows.setPreferredSize(new java.awt.Dimension(1000, 500));
        InfoWindows.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitInfoButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ExitInfoButton.setForeground(new java.awt.Color(255, 255, 255));
        ExitInfoButton.setText("Go back");
        ExitInfoButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        ExitInfoButton.setContentAreaFilled(false);
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
        InfoWindows.add(ExitInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 110, 40));

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
        BookButtonA1.setForeground(new java.awt.Color(255, 255, 255));
        BookButtonA1.setText("Book this room");
        BookButtonA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        BookButtonA1.setContentAreaFilled(false);
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
        InfoWindowA1.add(BookButtonA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 380, -1, -1));

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
        BookButtonA2.setForeground(new java.awt.Color(255, 255, 255));
        BookButtonA2.setText("Book this room");
        BookButtonA2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        BookButtonA2.setContentAreaFilled(false);
        BookButtonA2.setFocusPainted(false);
        BookButtonA2.setFocusTraversalPolicyProvider(true);
        BookButtonA2.setFocusable(false);
        BookButtonA2.setPreferredSize(new java.awt.Dimension(250, 50));
        BookButtonA2.setRolloverEnabled(false);
        BookButtonA2.setVerifyInputWhenFocusTarget(false);
        BookButtonA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonA2ActionPerformed(evt);
            }
        });
        InfoWindowA2.add(BookButtonA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 380, -1, -1));

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
        BookButtonB1.setForeground(new java.awt.Color(255, 255, 255));
        BookButtonB1.setText("Book this room");
        BookButtonB1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        BookButtonB1.setContentAreaFilled(false);
        BookButtonB1.setFocusPainted(false);
        BookButtonB1.setFocusTraversalPolicyProvider(true);
        BookButtonB1.setFocusable(false);
        BookButtonB1.setPreferredSize(new java.awt.Dimension(250, 50));
        BookButtonB1.setRolloverEnabled(false);
        BookButtonB1.setVerifyInputWhenFocusTarget(false);
        BookButtonB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonB1ActionPerformed(evt);
            }
        });
        InfoWindowB1.add(BookButtonB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 380, -1, -1));

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
        BookButtonB2.setForeground(new java.awt.Color(255, 255, 255));
        BookButtonB2.setText("Book this room");
        BookButtonB2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        BookButtonB2.setContentAreaFilled(false);
        BookButtonB2.setFocusPainted(false);
        BookButtonB2.setFocusTraversalPolicyProvider(true);
        BookButtonB2.setFocusable(false);
        BookButtonB2.setPreferredSize(new java.awt.Dimension(250, 50));
        BookButtonB2.setRolloverEnabled(false);
        BookButtonB2.setVerifyInputWhenFocusTarget(false);
        BookButtonB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookButtonB2ActionPerformed(evt);
            }
        });
        InfoWindowB2.add(BookButtonB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 380, -1, -1));

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
        BookButtonC1.setForeground(new java.awt.Color(255, 255, 255));
        BookButtonC1.setText("Book this room");
        BookButtonC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        BookButtonC1.setContentAreaFilled(false);
        BookButtonC1.setFocusPainted(false);
        BookButtonC1.setFocusTraversalPolicyProvider(true);
        BookButtonC1.setFocusable(false);
        BookButtonC1.setPreferredSize(new java.awt.Dimension(250, 50));
        BookButtonC1.setRolloverEnabled(false);
        BookButtonC1.setVerifyInputWhenFocusTarget(false);
        InfoWindowC1.add(BookButtonC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 380, -1, -1));

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
        BookButtonC2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
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

        OnlinePaymentChooseA1.setBackground(new java.awt.Color(96, 87, 69));
        OnlinePaymentChooseA1.setOpaque(false);
        OnlinePaymentChooseA1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Designnn.setBackground(new java.awt.Color(255, 255, 255));
        Designnn.setPreferredSize(new java.awt.Dimension(3, 50));
        Designnn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton2.setText("jRadioButton1");
        Designnn.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        OnlinePaymentChooseA1.add(Designnn, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 7, -1, -1));

        GcashOptionA1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        GcashOptionA1.setForeground(new java.awt.Color(255, 255, 255));
        GcashOptionA1.setText("GCash");
        GcashOptionA1.setContentAreaFilled(false);
        GcashOptionA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GcashOptionA1ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA1.add(GcashOptionA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, -1));

        PaymayaOptionA1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PaymayaOptionA1.setForeground(new java.awt.Color(255, 255, 255));
        PaymayaOptionA1.setText("Pay Maya");
        PaymayaOptionA1.setContentAreaFilled(false);
        PaymayaOptionA1.setRequestFocusEnabled(false);
        PaymayaOptionA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymayaOptionA1ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA1.add(PaymayaOptionA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 110, -1));

        CheckinA1.add(OnlinePaymentChooseA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 180, 130));

        UpdatePriceA1Button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UpdatePriceA1Button.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePriceA1Button.setText("Refresh Amount");
        UpdatePriceA1Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        UpdatePriceA1Button.setContentAreaFilled(false);
        UpdatePriceA1Button.setFocusPainted(false);
        UpdatePriceA1Button.setFocusable(false);
        UpdatePriceA1Button.setPreferredSize(new java.awt.Dimension(135, 35));
        UpdatePriceA1Button.setRequestFocusEnabled(false);
        UpdatePriceA1Button.setRolloverEnabled(false);
        UpdatePriceA1Button.setVerifyInputWhenFocusTarget(false);
        UpdatePriceA1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePriceA1ButtonActionPerformed(evt);
            }
        });
        CheckinA1.add(UpdatePriceA1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        ConfirmButtonA1Checkin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ConfirmButtonA1Checkin.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButtonA1Checkin.setText("Pay & Confirm");
        ConfirmButtonA1Checkin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        ConfirmButtonA1Checkin.setContentAreaFilled(false);
        ConfirmButtonA1Checkin.setFocusPainted(false);
        ConfirmButtonA1Checkin.setFocusable(false);
        ConfirmButtonA1Checkin.setPreferredSize(new java.awt.Dimension(150, 40));
        ConfirmButtonA1Checkin.setRequestFocusEnabled(false);
        ConfirmButtonA1Checkin.setRolloverEnabled(false);
        ConfirmButtonA1Checkin.setVerifyInputWhenFocusTarget(false);
        ConfirmButtonA1Checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonA1CheckinActionPerformed(evt);
            }
        });
        CheckinA1.add(ConfirmButtonA1Checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 190, -1));

        RoomSchedNightCheckinA1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedNightCheckinA1.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedNightCheckinA1.setText("6:00PM - 8:00AM Overnight");
        RoomSchedNightCheckinA1.setContentAreaFilled(false);
        RoomSchedNightCheckinA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedNightCheckinA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(RoomSchedNightCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 250, -1));

        RoomSchedDayCheckinA1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedDayCheckinA1.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedDayCheckinA1.setSelected(true);
        RoomSchedDayCheckinA1.setText("6:00AM - 8:00AM Day");
        RoomSchedDayCheckinA1.setContentAreaFilled(false);
        RoomSchedDayCheckinA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedDayCheckinA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(RoomSchedDayCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 250, -1));

        PaymentMethodCheckin1A1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin1A1.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin1A1.setText("OnlinePayment");
        PaymentMethodCheckin1A1.setContentAreaFilled(false);
        PaymentMethodCheckin1A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin1A1ActionPerformed(evt);
            }
        });
        CheckinA1.add(PaymentMethodCheckin1A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, -1, -1));

        PaymentMethodCheckin2A1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin2A1.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin2A1.setText("Cash");
        PaymentMethodCheckin2A1.setActionCommand("");
        PaymentMethodCheckin2A1.setContentAreaFilled(false);
        PaymentMethodCheckin2A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin2A1ActionPerformed(evt);
            }
        });
        CheckinA1.add(PaymentMethodCheckin2A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 80, -1));

        PaymentMethodCheckin3A1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin3A1.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin3A1.setText("Debit/Credit Card");
        PaymentMethodCheckin3A1.setContentAreaFilled(false);
        PaymentMethodCheckin3A1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin3A1ActionPerformed(evt);
            }
        });
        CheckinA1.add(PaymentMethodCheckin3A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        CheckInGuestNameA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestNameA1.setToolTipText("");
        CheckInGuestNameA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestNameA1.setFocusTraversalPolicyProvider(true);
        CheckInGuestNameA1.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestNameA1.setVerifyInputWhenFocusTarget(false);
        CheckInGuestNameA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestNameA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(CheckInGuestNameA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 250, -1));

        CheckInGuestAddressA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA1.setToolTipText("");
        CheckInGuestAddressA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestAddressA1.setFocusTraversalPolicyProvider(true);
        CheckInGuestAddressA1.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestAddressA1.setVerifyInputWhenFocusTarget(false);
        CheckInGuestAddressA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestAddressA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(CheckInGuestAddressA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, -1));

        TotalAmountA1Checkin.setEditable(false);
        TotalAmountA1Checkin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalAmountA1Checkin.setText("1");
        TotalAmountA1Checkin.setToolTipText("");
        TotalAmountA1Checkin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        TotalAmountA1Checkin.setFocusTraversalPolicyProvider(true);
        TotalAmountA1Checkin.setPreferredSize(new java.awt.Dimension(250, 35));
        TotalAmountA1Checkin.setRequestFocusEnabled(false);
        TotalAmountA1Checkin.setVerifyInputWhenFocusTarget(false);
        TotalAmountA1Checkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountA1CheckinActionPerformed(evt);
            }
        });
        CheckinA1.add(TotalAmountA1Checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 250, -1));

        CheckInGuestAddressA8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA8.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA8.setText("Payment Method");
        CheckInGuestAddressA8.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 160, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(227, 221, 203));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Payment & Confirmation");
        CheckinA1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 400, 46));

        MaxDaysCheckinA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaxDaysCheckinA1.setText("1");
        MaxDaysCheckinA1.setToolTipText("");
        MaxDaysCheckinA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        MaxDaysCheckinA1.setFocusTraversalPolicyProvider(true);
        MaxDaysCheckinA1.setPreferredSize(new java.awt.Dimension(250, 35));
        MaxDaysCheckinA1.setVerifyInputWhenFocusTarget(false);
        MaxDaysCheckinA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxDaysCheckinA1ActionPerformed(evt);
            }
        });
        CheckinA1.add(MaxDaysCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 110, -1));

        RoomPriceA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RoomPriceA1.setForeground(new java.awt.Color(227, 221, 203));
        RoomPriceA1.setText("Room Price Selected: ");
        RoomPriceA1.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(RoomPriceA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 160, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(227, 221, 203));
        jLabel9.setText("Full Name");
        jLabel9.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, -1));

        AddressLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddressLabel.setForeground(new java.awt.Color(227, 221, 203));
        AddressLabel.setText("Address");
        AddressLabel.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(AddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 110, -1));

        DesignCheckin1.setBackground(new java.awt.Color(255, 255, 255));
        DesignCheckin1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DesignCheckin1.setForeground(new java.awt.Color(255, 255, 255));
        DesignCheckin1.setText("Single Class A");
        DesignCheckin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        DesignCheckin1.setPreferredSize(new java.awt.Dimension(250, 35));
        DesignCheckin1.setVerifyInputWhenFocusTarget(false);
        CheckinA1.add(DesignCheckin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 250, -1));

        CheckInGuestAddressA4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA4.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA4.setText("Days");
        CheckInGuestAddressA4.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, -1));

        CheckInGuestAddressA7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA7.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA7.setText("1 -12 MAX");
        CheckInGuestAddressA7.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 383, 150, -1));

        LabelCheckinA1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA1.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA1.setText("RoomType");
        LabelCheckinA1.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(LabelCheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        LabelCheckinA2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA2.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA2.setText("RoomType");
        LabelCheckinA2.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(LabelCheckinA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        CheckInGuestAddressA6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA6.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA6.setText("Total Amount:");
        CheckInGuestAddressA6.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 160, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(227, 221, 203));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Check in info");
        CheckinA1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 260, 46));

        jPanel3.setBackground(new java.awt.Color(185, 178, 139));
        jPanel3.setPreferredSize(new java.awt.Dimension(3, 350));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        CheckinA1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        Background5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background5.setPreferredSize(new java.awt.Dimension(1000, 500));
        CheckinA1.add(Background5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        jLabel77.setText("Successfully Payed!");
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

        OnlinePayment2ndWindow3A1.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow3A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePayment2ndWindow3A1.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow3A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel205.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow3A1.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        jPanel55.setBackground(new java.awt.Color(0, 204, 0));
        jPanel55.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow3A1.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel56.setBackground(new java.awt.Color(0, 204, 0));
        jPanel56.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel206.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(255, 255, 255));
        jLabel206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel206.setText("Aqueza Suites");
        jLabel206.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel56.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel207.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(255, 255, 255));
        jLabel207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel207.setText("Successfully Paid!");
        jLabel207.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel56.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow3A1.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel208.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(153, 153, 153));
        jLabel208.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel208.setText("(Preview)");
        jLabel208.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow3A1.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, -1));

        PriceTextPaymaya2A6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya2A6.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya2A6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya2A6.setText(" php 10000");
        PriceTextPaymaya2A6.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow3A1.add(PriceTextPaymaya2A6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA17.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA17.setText("09xxxxxxxx");
        AccountNameA17.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow3A1.add(AccountNameA17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlineExitButton1A5.setBackground(new java.awt.Color(0, 204, 0));
        OnlineExitButton1A5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlineExitButton1A5.setText("Exit");
        OnlineExitButton1A5.setFocusPainted(false);
        OnlineExitButton1A5.setFocusable(false);
        OnlineExitButton1A5.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlineExitButton1A5.setRequestFocusEnabled(false);
        OnlineExitButton1A5.setVerifyInputWhenFocusTarget(false);
        OnlineExitButton1A5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlineExitButton1A5ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow3A1.add(OnlineExitButton1A5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel209.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(153, 153, 153));
        jLabel209.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel209.setText("You Paid");
        jLabel209.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow3A1.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel210.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(153, 153, 153));
        jLabel210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel210.setText("using your PayMaya");
        jLabel210.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow3A1.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel211.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(153, 153, 153));
        jLabel211.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel211.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel211.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow3A1.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel212.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(153, 153, 153));
        jLabel212.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel212.setText("Account Number");
        jLabel212.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow3A1.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow3A1.add(OnlinePayment2ndWindow3A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow3A1.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow3A1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(186, 173, 99), 3));
        OnlinePaymentMainWindow3A1.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow3A1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel213.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/CreditCardIcon.png"))); // NOI18N
        jLabel213.setPreferredSize(new java.awt.Dimension(225, 50));
        OnlinePaymentMainWindow3A1.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        jPanel57.setBackground(new java.awt.Color(186, 173, 99));
        jPanel57.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow3A1.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel58.setBackground(new java.awt.Color(186, 173, 99));
        jPanel58.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel214.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(255, 255, 255));
        jLabel214.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel214.setText("Aqueza Suites");
        jLabel214.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel58.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel215.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(255, 255, 255));
        jLabel215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel215.setText("Confirmation");
        jLabel215.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel58.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow3A1.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel216.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(153, 153, 153));
        jLabel216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel216.setText("(Preview)");
        jLabel216.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow3A1.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 80, -1));

        PriceTextPaymaya1A6.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya1A6.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya1A6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya1A6.setText(" php 10000");
        PriceTextPaymaya1A6.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow3A1.add(PriceTextPaymaya1A6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA18.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA18.setText("09xxxxxxxx");
        AccountNameA18.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow3A1.add(AccountNameA18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton2GA5.setBackground(new java.awt.Color(186, 173, 99));
        OnlinePaymentButton2GA5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton2GA5.setText("Confirm");
        OnlinePaymentButton2GA5.setFocusPainted(false);
        OnlinePaymentButton2GA5.setFocusable(false);
        OnlinePaymentButton2GA5.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton2GA5.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton2GA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton2GA5ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow3A1.add(OnlinePaymentButton2GA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel217.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(153, 153, 153));
        jLabel217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel217.setText("You are about to pay");
        jLabel217.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow3A1.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel218.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(153, 153, 153));
        jLabel218.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel218.setText("using your CreditCard/DebitCard");
        jLabel218.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow3A1.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 185, 220, -1));

        jLabel219.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(153, 153, 153));
        jLabel219.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel219.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel219.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow3A1.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel220.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(153, 153, 153));
        jLabel220.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel220.setText("Account Number");
        jLabel220.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow3A1.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow3A1.add(OnlinePaymentMainWindow3A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA1.add(OnlinePaymentWindow3A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckInGuestAddressA9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA9.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA9.setText("Room Schedule");
        CheckInGuestAddressA9.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA1.add(CheckInGuestAddressA9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 110, -1));

        CheckInPayment.add(CheckinA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckinA2.setBackground(new java.awt.Color(255, 255, 255));
        CheckinA2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePaymentWindow1A2.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow1A2.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow1A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow1A2.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow1A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePayment2ndWindow1A2.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow1A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel100.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow1A2.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel28.setBackground(new java.awt.Color(51, 51, 255));
        jPanel28.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow1A2.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel29.setBackground(new java.awt.Color(51, 51, 255));
        jPanel29.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("Aqueza Suites");
        jLabel101.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel29.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel102.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("Successfully Payed!");
        jLabel102.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel29.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow1A2.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel103.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(153, 153, 153));
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("(Preview)");
        jLabel103.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A2.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcash1A3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcash1A3.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcash1A3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcash1A3.setText(" php 10000");
        PriceTextGcash1A3.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A2.add(PriceTextGcash1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA5.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA5.setText("09xxxxxxxx");
        AccountNameA5.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A2.add(AccountNameA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA3.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA3.setText("Exit");
        OnlinePaymentButton1GA3.setFocusPainted(false);
        OnlinePaymentButton1GA3.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA3.setRequestFocusEnabled(false);
        OnlinePaymentButton1GA3.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton1GA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA3ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow1A2.add(OnlinePaymentButton1GA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel104.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(153, 153, 153));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("You Paid");
        jLabel104.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A2.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel105.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(153, 153, 153));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("using your GCash");
        jLabel105.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A2.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel106.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(153, 153, 153));
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel106.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow1A2.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel107.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(153, 153, 153));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Account Number");
        jLabel107.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A2.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A2.add(OnlinePayment2ndWindow1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow1A2.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow1A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePaymentMainWindow1A2.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow1A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel108.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow1A2.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel30.setBackground(new java.awt.Color(51, 51, 255));
        jPanel30.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow1A2.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel31.setBackground(new java.awt.Color(51, 51, 255));
        jPanel31.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("Aqueza Suites");
        jLabel109.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel31.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel110.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("Confirmation");
        jLabel110.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel31.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow1A2.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel111.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(153, 153, 153));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("(Preview)");
        jLabel111.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A2.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcashA2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcashA2.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcashA2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcashA2.setText(" php 10000");
        PriceTextGcashA2.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A2.add(PriceTextGcashA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA6.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA6.setText("09xxxxxxxx");
        AccountNameA6.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A2.add(AccountNameA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA4.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA4.setText("Confirm");
        OnlinePaymentButton1GA4.setFocusPainted(false);
        OnlinePaymentButton1GA4.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA4.setRequestFocusEnabled(false);
        OnlinePaymentButton1GA4.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton1GA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA4ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow1A2.add(OnlinePaymentButton1GA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel112.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(153, 153, 153));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("You are about to pay");
        jLabel112.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A2.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel113.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(153, 153, 153));
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("using your GCash");
        jLabel113.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A2.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel114.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(153, 153, 153));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel114.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow1A2.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel115.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(153, 153, 153));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("Account Number");
        jLabel115.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A2.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A2.add(OnlinePaymentMainWindow1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA2.add(OnlinePaymentWindow1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentWindow2A2.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow2A2.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow2A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow2A2.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow2A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePayment2ndWindow2A2.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow2A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel116.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow2A2.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        jPanel32.setBackground(new java.awt.Color(0, 204, 0));
        jPanel32.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow2A2.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel33.setBackground(new java.awt.Color(0, 204, 0));
        jPanel33.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("Aqueza Suites");
        jLabel117.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel33.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel118.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Successfully Paid!");
        jLabel118.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel33.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow2A2.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel119.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(153, 153, 153));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("(Preview)");
        jLabel119.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, -1));

        PriceTextPaymaya2A3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya2A3.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya2A3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya2A3.setText(" php 10000");
        PriceTextPaymaya2A3.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(PriceTextPaymaya2A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA7.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA7.setText("09xxxxxxxx");
        AccountNameA7.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(AccountNameA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlineExitButton1A2.setBackground(new java.awt.Color(0, 204, 0));
        OnlineExitButton1A2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlineExitButton1A2.setText("Exit");
        OnlineExitButton1A2.setFocusPainted(false);
        OnlineExitButton1A2.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlineExitButton1A2.setRequestFocusEnabled(false);
        OnlineExitButton1A2.setVerifyInputWhenFocusTarget(false);
        OnlineExitButton1A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlineExitButton1A2ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow2A2.add(OnlineExitButton1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel120.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(153, 153, 153));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("You Paid");
        jLabel120.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel121.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(153, 153, 153));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("using your PayMaya");
        jLabel121.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel122.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(153, 153, 153));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel122.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow2A2.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel123.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(153, 153, 153));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("Account Number");
        jLabel123.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A2.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A2.add(OnlinePayment2ndWindow2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow2A2.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow2A2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePaymentMainWindow2A2.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow2A2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel124.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow2A2.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel34.setBackground(new java.awt.Color(0, 204, 0));
        jPanel34.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow2A2.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel35.setBackground(new java.awt.Color(0, 204, 0));
        jPanel35.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Aqueza Suites");
        jLabel125.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel35.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel126.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("Confirmation");
        jLabel126.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel35.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow2A2.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel127.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(153, 153, 153));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("(Preview)");
        jLabel127.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 80, -1));

        PriceTextPaymaya1A3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya1A3.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya1A3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya1A3.setText(" php 10000");
        PriceTextPaymaya1A3.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(PriceTextPaymaya1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA8.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA8.setText("09xxxxxxxx");
        AccountNameA8.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(AccountNameA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton2GA2.setBackground(new java.awt.Color(0, 204, 0));
        OnlinePaymentButton2GA2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton2GA2.setText("Confirm");
        OnlinePaymentButton2GA2.setFocusPainted(false);
        OnlinePaymentButton2GA2.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton2GA2.setRequestFocusEnabled(false);
        OnlinePaymentButton2GA2.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton2GA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton2GA2ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow2A2.add(OnlinePaymentButton2GA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel128.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(153, 153, 153));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("You are about to pay");
        jLabel128.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel129.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(153, 153, 153));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("using your PayMaya");
        jLabel129.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel130.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(153, 153, 153));
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel130.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow2A2.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel131.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(153, 153, 153));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setText("Account Number");
        jLabel131.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A2.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A2.add(OnlinePaymentMainWindow2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA2.add(OnlinePaymentWindow2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentChooseA2.setBackground(new java.awt.Color(96, 87, 69));
        OnlinePaymentChooseA2.setOpaque(false);
        OnlinePaymentChooseA2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Designnn1.setBackground(new java.awt.Color(255, 255, 255));
        Designnn1.setPreferredSize(new java.awt.Dimension(3, 50));
        Designnn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton3.setText("jRadioButton1");
        Designnn1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        OnlinePaymentChooseA2.add(Designnn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 7, -1, -1));

        GcashOptionA2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        GcashOptionA2.setForeground(new java.awt.Color(255, 255, 255));
        GcashOptionA2.setText("GCash");
        GcashOptionA2.setContentAreaFilled(false);
        GcashOptionA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GcashOptionA2ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA2.add(GcashOptionA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, -1));

        PaymayaOptionA2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PaymayaOptionA2.setForeground(new java.awt.Color(255, 255, 255));
        PaymayaOptionA2.setText("Pay Maya");
        PaymayaOptionA2.setContentAreaFilled(false);
        PaymayaOptionA2.setRequestFocusEnabled(false);
        PaymayaOptionA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymayaOptionA2ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA2.add(PaymayaOptionA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 110, -1));

        CheckinA2.add(OnlinePaymentChooseA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 180, 130));

        UpdatePriceA1Button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UpdatePriceA1Button1.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePriceA1Button1.setText("Refresh Amount");
        UpdatePriceA1Button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        UpdatePriceA1Button1.setContentAreaFilled(false);
        UpdatePriceA1Button1.setFocusable(false);
        UpdatePriceA1Button1.setPreferredSize(new java.awt.Dimension(135, 35));
        UpdatePriceA1Button1.setRequestFocusEnabled(false);
        UpdatePriceA1Button1.setRolloverEnabled(false);
        UpdatePriceA1Button1.setVerifyInputWhenFocusTarget(false);
        UpdatePriceA1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePriceA1Button1ActionPerformed(evt);
            }
        });
        CheckinA2.add(UpdatePriceA1Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        ConfirmButtonA1Checkin1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ConfirmButtonA1Checkin1.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButtonA1Checkin1.setText("Pay & Confirm");
        ConfirmButtonA1Checkin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        ConfirmButtonA1Checkin1.setContentAreaFilled(false);
        ConfirmButtonA1Checkin1.setFocusPainted(false);
        ConfirmButtonA1Checkin1.setFocusable(false);
        ConfirmButtonA1Checkin1.setPreferredSize(new java.awt.Dimension(150, 40));
        ConfirmButtonA1Checkin1.setRequestFocusEnabled(false);
        ConfirmButtonA1Checkin1.setRolloverEnabled(false);
        ConfirmButtonA1Checkin1.setVerifyInputWhenFocusTarget(false);
        ConfirmButtonA1Checkin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonA1Checkin1ActionPerformed(evt);
            }
        });
        CheckinA2.add(ConfirmButtonA1Checkin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 190, -1));

        RoomSchedNightCheckinA2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedNightCheckinA2.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedNightCheckinA2.setText("6:00PM - 8:00AM Overnight");
        RoomSchedNightCheckinA2.setContentAreaFilled(false);
        RoomSchedNightCheckinA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedNightCheckinA2ActionPerformed(evt);
            }
        });
        CheckinA2.add(RoomSchedNightCheckinA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 250, -1));

        RoomSchedDayCheckinA2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedDayCheckinA2.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedDayCheckinA2.setSelected(true);
        RoomSchedDayCheckinA2.setText("6:00AM - 8:00AM Day");
        RoomSchedDayCheckinA2.setContentAreaFilled(false);
        RoomSchedDayCheckinA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedDayCheckinA2ActionPerformed(evt);
            }
        });
        CheckinA2.add(RoomSchedDayCheckinA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 250, -1));

        PaymentMethodCheckin1A2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin1A2.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin1A2.setText("OnlinePayment");
        PaymentMethodCheckin1A2.setContentAreaFilled(false);
        PaymentMethodCheckin1A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin1A2ActionPerformed(evt);
            }
        });
        CheckinA2.add(PaymentMethodCheckin1A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, -1, -1));

        PaymentMethodCheckin2A2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin2A2.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin2A2.setText("Cash");
        PaymentMethodCheckin2A2.setActionCommand("");
        PaymentMethodCheckin2A2.setContentAreaFilled(false);
        PaymentMethodCheckin2A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin2A2ActionPerformed(evt);
            }
        });
        CheckinA2.add(PaymentMethodCheckin2A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 80, -1));

        PaymentMethodCheckin3A2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin3A2.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin3A2.setText("Debit/Credit Card");
        PaymentMethodCheckin3A2.setContentAreaFilled(false);
        PaymentMethodCheckin3A2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin3A2ActionPerformed(evt);
            }
        });
        CheckinA2.add(PaymentMethodCheckin3A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        CheckInGuestNameA2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestNameA2.setToolTipText("");
        CheckInGuestNameA2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestNameA2.setFocusTraversalPolicyProvider(true);
        CheckInGuestNameA2.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestNameA2.setVerifyInputWhenFocusTarget(false);
        CheckInGuestNameA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestNameA2ActionPerformed(evt);
            }
        });
        CheckinA2.add(CheckInGuestNameA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 250, -1));

        CheckInGuestAddressA2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA2.setToolTipText("");
        CheckInGuestAddressA2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestAddressA2.setFocusTraversalPolicyProvider(true);
        CheckInGuestAddressA2.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestAddressA2.setVerifyInputWhenFocusTarget(false);
        CheckInGuestAddressA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestAddressA2ActionPerformed(evt);
            }
        });
        CheckinA2.add(CheckInGuestAddressA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, -1));

        TotalAmountCheckinA2.setEditable(false);
        TotalAmountCheckinA2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalAmountCheckinA2.setText("1");
        TotalAmountCheckinA2.setToolTipText("");
        TotalAmountCheckinA2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        TotalAmountCheckinA2.setFocusTraversalPolicyProvider(true);
        TotalAmountCheckinA2.setPreferredSize(new java.awt.Dimension(250, 35));
        TotalAmountCheckinA2.setRequestFocusEnabled(false);
        TotalAmountCheckinA2.setVerifyInputWhenFocusTarget(false);
        TotalAmountCheckinA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountCheckinA2ActionPerformed(evt);
            }
        });
        CheckinA2.add(TotalAmountCheckinA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 250, -1));

        RoomPriceA2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RoomPriceA2.setForeground(new java.awt.Color(227, 221, 203));
        RoomPriceA2.setText("Room Price Selected: ");
        RoomPriceA2.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(RoomPriceA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 160, -1));

        CheckInGuestAddressA14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA14.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA14.setText("Payment Method");
        CheckInGuestAddressA14.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(CheckInGuestAddressA14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 160, -1));

        jLabel132.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(227, 221, 203));
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel132.setText("Payment & Confirmation");
        CheckinA2.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 400, 46));

        MaxDaysCheckinA2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaxDaysCheckinA2.setText("1");
        MaxDaysCheckinA2.setToolTipText("");
        MaxDaysCheckinA2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        MaxDaysCheckinA2.setFocusTraversalPolicyProvider(true);
        MaxDaysCheckinA2.setPreferredSize(new java.awt.Dimension(250, 35));
        MaxDaysCheckinA2.setVerifyInputWhenFocusTarget(false);
        MaxDaysCheckinA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxDaysCheckinA2ActionPerformed(evt);
            }
        });
        CheckinA2.add(MaxDaysCheckinA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 110, -1));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(227, 221, 203));
        jLabel133.setText("Full Name");
        jLabel133.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, -1));

        AddressLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddressLabel1.setForeground(new java.awt.Color(227, 221, 203));
        AddressLabel1.setText("Address");
        AddressLabel1.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(AddressLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 110, -1));

        DesignCheckin2.setBackground(new java.awt.Color(255, 255, 255));
        DesignCheckin2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DesignCheckin2.setForeground(new java.awt.Color(255, 255, 255));
        DesignCheckin2.setText("Double Class A");
        DesignCheckin2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        DesignCheckin2.setPreferredSize(new java.awt.Dimension(250, 35));
        DesignCheckin2.setVerifyInputWhenFocusTarget(false);
        CheckinA2.add(DesignCheckin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 250, -1));

        CheckInGuestAddressA5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA5.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA5.setText("Days");
        CheckInGuestAddressA5.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(CheckInGuestAddressA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, -1));

        CheckInGuestAddressA11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA11.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA11.setText("1 -12 MAX");
        CheckInGuestAddressA11.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(CheckInGuestAddressA11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 383, 150, -1));

        LabelCheckinA3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA3.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA3.setText("RoomType");
        LabelCheckinA3.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(LabelCheckinA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        LabelCheckinA4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA4.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA4.setText("RoomType");
        LabelCheckinA4.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(LabelCheckinA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        CheckInGuestAddressA12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA12.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA12.setText("Total Amount:");
        CheckInGuestAddressA12.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(CheckInGuestAddressA12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 160, -1));

        jLabel134.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(227, 221, 203));
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel134.setText("Check in info");
        CheckinA2.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 260, 46));

        jPanel36.setBackground(new java.awt.Color(185, 178, 139));
        jPanel36.setPreferredSize(new java.awt.Dimension(3, 350));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        CheckinA2.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        Background6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background6.setPreferredSize(new java.awt.Dimension(1000, 500));
        CheckinA2.add(Background6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckInGuestAddressA13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA13.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA13.setText("Room Schedule");
        CheckInGuestAddressA13.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA2.add(CheckInGuestAddressA13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 110, -1));

        CheckInPayment.add(CheckinA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckinA3.setBackground(new java.awt.Color(255, 255, 255));
        CheckinA3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePaymentWindow1A3.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow1A3.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow1A3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow1A3.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow1A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePayment2ndWindow1A3.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow1A3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel135.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow1A3.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel37.setBackground(new java.awt.Color(51, 51, 255));
        jPanel37.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow1A3.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel38.setBackground(new java.awt.Color(51, 51, 255));
        jPanel38.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel136.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel136.setText("Aqueza Suites");
        jLabel136.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel38.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel137.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel137.setText("Successfully Payed!");
        jLabel137.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel38.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow1A3.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel138.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(153, 153, 153));
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel138.setText("(Preview)");
        jLabel138.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A3.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcash1A4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcash1A4.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcash1A4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcash1A4.setText(" php 10000");
        PriceTextGcash1A4.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A3.add(PriceTextGcash1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA9.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA9.setText("09xxxxxxxx");
        AccountNameA9.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A3.add(AccountNameA9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA5.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA5.setText("Exit");
        OnlinePaymentButton1GA5.setFocusPainted(false);
        OnlinePaymentButton1GA5.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA5.setRequestFocusEnabled(false);
        OnlinePaymentButton1GA5.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton1GA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA5ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow1A3.add(OnlinePaymentButton1GA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel139.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(153, 153, 153));
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel139.setText("You Paid");
        jLabel139.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A3.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel140.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(153, 153, 153));
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel140.setText("using your GCash");
        jLabel140.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A3.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel141.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(153, 153, 153));
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel141.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow1A3.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel142.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(153, 153, 153));
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setText("Account Number");
        jLabel142.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A3.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A3.add(OnlinePayment2ndWindow1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow1A3.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow1A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePaymentMainWindow1A3.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow1A3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel143.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow1A3.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel39.setBackground(new java.awt.Color(51, 51, 255));
        jPanel39.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow1A3.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel40.setBackground(new java.awt.Color(51, 51, 255));
        jPanel40.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel144.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 255, 255));
        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel144.setText("Aqueza Suites");
        jLabel144.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel40.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel145.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 255, 255));
        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel145.setText("Confirmation");
        jLabel145.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel40.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow1A3.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel146.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(153, 153, 153));
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel146.setText("(Preview)");
        jLabel146.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A3.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcashA3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcashA3.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcashA3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcashA3.setText(" php 10000");
        PriceTextGcashA3.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A3.add(PriceTextGcashA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA10.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA10.setText("09xxxxxxxx");
        AccountNameA10.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A3.add(AccountNameA10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA6.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA6.setText("Confirm");
        OnlinePaymentButton1GA6.setFocusPainted(false);
        OnlinePaymentButton1GA6.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA6.setRequestFocusEnabled(false);
        OnlinePaymentButton1GA6.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton1GA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA6ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow1A3.add(OnlinePaymentButton1GA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel147.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(153, 153, 153));
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel147.setText("You are about to pay");
        jLabel147.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A3.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel148.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(153, 153, 153));
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel148.setText("using your GCash");
        jLabel148.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A3.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel149.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(153, 153, 153));
        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel149.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel149.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow1A3.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel150.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(153, 153, 153));
        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel150.setText("Account Number");
        jLabel150.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A3.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A3.add(OnlinePaymentMainWindow1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA3.add(OnlinePaymentWindow1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentWindow2A3.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow2A3.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow2A3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow2A3.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow2A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePayment2ndWindow2A3.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow2A3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel151.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow2A3.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        jPanel41.setBackground(new java.awt.Color(0, 204, 0));
        jPanel41.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow2A3.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel42.setBackground(new java.awt.Color(0, 204, 0));
        jPanel42.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 255, 255));
        jLabel152.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel152.setText("Aqueza Suites");
        jLabel152.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel42.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel153.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel153.setText("Successfully Paid!");
        jLabel153.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel42.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow2A3.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel154.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(153, 153, 153));
        jLabel154.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel154.setText("(Preview)");
        jLabel154.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A3.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, -1));

        PriceTextPaymaya2A4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya2A4.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya2A4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya2A4.setText(" php 10000");
        PriceTextPaymaya2A4.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A3.add(PriceTextPaymaya2A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA11.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA11.setText("09xxxxxxxx");
        AccountNameA11.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A3.add(AccountNameA11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlineExitButton1A3.setBackground(new java.awt.Color(0, 204, 0));
        OnlineExitButton1A3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlineExitButton1A3.setText("Exit");
        OnlineExitButton1A3.setFocusPainted(false);
        OnlineExitButton1A3.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlineExitButton1A3.setRequestFocusEnabled(false);
        OnlineExitButton1A3.setVerifyInputWhenFocusTarget(false);
        OnlineExitButton1A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlineExitButton1A3ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow2A3.add(OnlineExitButton1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel155.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(153, 153, 153));
        jLabel155.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel155.setText("You Paid");
        jLabel155.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A3.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel156.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(153, 153, 153));
        jLabel156.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel156.setText("using your PayMaya");
        jLabel156.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A3.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel157.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(153, 153, 153));
        jLabel157.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel157.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel157.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow2A3.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel158.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(153, 153, 153));
        jLabel158.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel158.setText("Account Number");
        jLabel158.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A3.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A3.add(OnlinePayment2ndWindow2A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow2A3.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow2A3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePaymentMainWindow2A3.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow2A3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel159.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel159.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel159.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow2A3.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel43.setBackground(new java.awt.Color(0, 204, 0));
        jPanel43.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow2A3.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel44.setBackground(new java.awt.Color(0, 204, 0));
        jPanel44.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel160.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel160.setText("Aqueza Suites");
        jLabel160.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel44.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel161.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("Confirmation");
        jLabel161.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel44.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow2A3.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel162.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(153, 153, 153));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel162.setText("(Preview)");
        jLabel162.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A3.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 80, -1));

        PriceTextPaymaya1A4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya1A4.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya1A4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya1A4.setText(" php 10000");
        PriceTextPaymaya1A4.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A3.add(PriceTextPaymaya1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA12.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA12.setText("09xxxxxxxx");
        AccountNameA12.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A3.add(AccountNameA12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton2GA3.setBackground(new java.awt.Color(0, 204, 0));
        OnlinePaymentButton2GA3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton2GA3.setText("Confirm");
        OnlinePaymentButton2GA3.setFocusPainted(false);
        OnlinePaymentButton2GA3.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton2GA3.setRequestFocusEnabled(false);
        OnlinePaymentButton2GA3.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton2GA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton2GA3ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow2A3.add(OnlinePaymentButton2GA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel163.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(153, 153, 153));
        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel163.setText("You are about to pay");
        jLabel163.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A3.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel164.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(153, 153, 153));
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel164.setText("using your PayMaya");
        jLabel164.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A3.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel165.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(153, 153, 153));
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel165.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel165.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow2A3.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel166.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(153, 153, 153));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel166.setText("Account Number");
        jLabel166.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A3.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A3.add(OnlinePaymentMainWindow2A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA3.add(OnlinePaymentWindow2A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentChooseA3.setBackground(new java.awt.Color(96, 87, 69));
        OnlinePaymentChooseA3.setOpaque(false);
        OnlinePaymentChooseA3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Designnn2.setBackground(new java.awt.Color(255, 255, 255));
        Designnn2.setPreferredSize(new java.awt.Dimension(3, 50));
        Designnn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton4.setText("jRadioButton1");
        Designnn2.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        OnlinePaymentChooseA3.add(Designnn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 7, -1, -1));

        GcashOptionA3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        GcashOptionA3.setForeground(new java.awt.Color(255, 255, 255));
        GcashOptionA3.setText("GCash");
        GcashOptionA3.setContentAreaFilled(false);
        GcashOptionA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GcashOptionA3ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA3.add(GcashOptionA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, -1));

        PaymayaOptionA3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PaymayaOptionA3.setForeground(new java.awt.Color(255, 255, 255));
        PaymayaOptionA3.setText("Pay Maya");
        PaymayaOptionA3.setContentAreaFilled(false);
        PaymayaOptionA3.setRequestFocusEnabled(false);
        PaymayaOptionA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymayaOptionA3ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA3.add(PaymayaOptionA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 110, -1));

        CheckinA3.add(OnlinePaymentChooseA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 180, 130));

        UpdatePriceA1Button2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UpdatePriceA1Button2.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePriceA1Button2.setText("Refresh Amount");
        UpdatePriceA1Button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        UpdatePriceA1Button2.setContentAreaFilled(false);
        UpdatePriceA1Button2.setFocusable(false);
        UpdatePriceA1Button2.setPreferredSize(new java.awt.Dimension(135, 35));
        UpdatePriceA1Button2.setRequestFocusEnabled(false);
        UpdatePriceA1Button2.setRolloverEnabled(false);
        UpdatePriceA1Button2.setVerifyInputWhenFocusTarget(false);
        UpdatePriceA1Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePriceA1Button2ActionPerformed(evt);
            }
        });
        CheckinA3.add(UpdatePriceA1Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        ConfirmButtonA1Checkin2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ConfirmButtonA1Checkin2.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButtonA1Checkin2.setText("Pay & Confirm");
        ConfirmButtonA1Checkin2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        ConfirmButtonA1Checkin2.setContentAreaFilled(false);
        ConfirmButtonA1Checkin2.setFocusPainted(false);
        ConfirmButtonA1Checkin2.setFocusable(false);
        ConfirmButtonA1Checkin2.setPreferredSize(new java.awt.Dimension(150, 40));
        ConfirmButtonA1Checkin2.setRequestFocusEnabled(false);
        ConfirmButtonA1Checkin2.setRolloverEnabled(false);
        ConfirmButtonA1Checkin2.setVerifyInputWhenFocusTarget(false);
        ConfirmButtonA1Checkin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonA1Checkin2ActionPerformed(evt);
            }
        });
        CheckinA3.add(ConfirmButtonA1Checkin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 190, -1));

        RoomSchedNightCheckinA3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedNightCheckinA3.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedNightCheckinA3.setText("6:00PM - 8:00AM Overnight");
        RoomSchedNightCheckinA3.setContentAreaFilled(false);
        RoomSchedNightCheckinA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedNightCheckinA3ActionPerformed(evt);
            }
        });
        CheckinA3.add(RoomSchedNightCheckinA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 250, -1));

        RoomSchedDayCheckinA3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedDayCheckinA3.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedDayCheckinA3.setSelected(true);
        RoomSchedDayCheckinA3.setText("6:00AM - 8:00AM Day");
        RoomSchedDayCheckinA3.setContentAreaFilled(false);
        RoomSchedDayCheckinA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedDayCheckinA3ActionPerformed(evt);
            }
        });
        CheckinA3.add(RoomSchedDayCheckinA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 250, -1));

        PaymentMethodCheckin1A3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin1A3.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin1A3.setText("OnlinePayment");
        PaymentMethodCheckin1A3.setContentAreaFilled(false);
        PaymentMethodCheckin1A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin1A3ActionPerformed(evt);
            }
        });
        CheckinA3.add(PaymentMethodCheckin1A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, -1, -1));

        PaymentMethodCheckin2A3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin2A3.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin2A3.setText("Cash");
        PaymentMethodCheckin2A3.setActionCommand("");
        PaymentMethodCheckin2A3.setContentAreaFilled(false);
        PaymentMethodCheckin2A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin2A3ActionPerformed(evt);
            }
        });
        CheckinA3.add(PaymentMethodCheckin2A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 80, -1));

        PaymentMethodCheckin3A3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin3A3.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin3A3.setText("Debit/Credit Card");
        PaymentMethodCheckin3A3.setContentAreaFilled(false);
        PaymentMethodCheckin3A3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin3A3ActionPerformed(evt);
            }
        });
        CheckinA3.add(PaymentMethodCheckin3A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        CheckInGuestNameA3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestNameA3.setToolTipText("");
        CheckInGuestNameA3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestNameA3.setFocusTraversalPolicyProvider(true);
        CheckInGuestNameA3.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestNameA3.setVerifyInputWhenFocusTarget(false);
        CheckInGuestNameA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestNameA3ActionPerformed(evt);
            }
        });
        CheckinA3.add(CheckInGuestNameA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 250, -1));

        CheckInGuestAddressA3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA3.setToolTipText("");
        CheckInGuestAddressA3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestAddressA3.setFocusTraversalPolicyProvider(true);
        CheckInGuestAddressA3.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestAddressA3.setVerifyInputWhenFocusTarget(false);
        CheckInGuestAddressA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestAddressA3ActionPerformed(evt);
            }
        });
        CheckinA3.add(CheckInGuestAddressA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, -1));

        TotalAmountCheckinA3.setEditable(false);
        TotalAmountCheckinA3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalAmountCheckinA3.setText("1");
        TotalAmountCheckinA3.setToolTipText("");
        TotalAmountCheckinA3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        TotalAmountCheckinA3.setFocusTraversalPolicyProvider(true);
        TotalAmountCheckinA3.setPreferredSize(new java.awt.Dimension(250, 35));
        TotalAmountCheckinA3.setRequestFocusEnabled(false);
        TotalAmountCheckinA3.setVerifyInputWhenFocusTarget(false);
        TotalAmountCheckinA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountCheckinA3ActionPerformed(evt);
            }
        });
        CheckinA3.add(TotalAmountCheckinA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 250, -1));

        RoomPriceA3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RoomPriceA3.setForeground(new java.awt.Color(227, 221, 203));
        RoomPriceA3.setText("Room Price Selected: ");
        RoomPriceA3.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(RoomPriceA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 160, -1));

        CheckInGuestAddressA15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA15.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA15.setText("Payment Method");
        CheckInGuestAddressA15.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(CheckInGuestAddressA15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 160, -1));

        jLabel167.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(227, 221, 203));
        jLabel167.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel167.setText("Payment & Confirmation");
        CheckinA3.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 400, 46));

        MaxDaysCheckinA3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaxDaysCheckinA3.setText("1");
        MaxDaysCheckinA3.setToolTipText("");
        MaxDaysCheckinA3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        MaxDaysCheckinA3.setFocusTraversalPolicyProvider(true);
        MaxDaysCheckinA3.setPreferredSize(new java.awt.Dimension(250, 35));
        MaxDaysCheckinA3.setVerifyInputWhenFocusTarget(false);
        MaxDaysCheckinA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxDaysCheckinA3ActionPerformed(evt);
            }
        });
        CheckinA3.add(MaxDaysCheckinA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 110, -1));

        jLabel168.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(227, 221, 203));
        jLabel168.setText("Full Name");
        jLabel168.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, -1));

        AddressLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddressLabel2.setForeground(new java.awt.Color(227, 221, 203));
        AddressLabel2.setText("Address");
        AddressLabel2.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(AddressLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 110, -1));

        DesignCheckin3.setBackground(new java.awt.Color(255, 255, 255));
        DesignCheckin3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DesignCheckin3.setForeground(new java.awt.Color(255, 255, 255));
        DesignCheckin3.setText("Family Room A");
        DesignCheckin3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        DesignCheckin3.setPreferredSize(new java.awt.Dimension(250, 35));
        DesignCheckin3.setVerifyInputWhenFocusTarget(false);
        CheckinA3.add(DesignCheckin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 250, -1));

        CheckInGuestAddressA10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA10.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA10.setText("Days");
        CheckInGuestAddressA10.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(CheckInGuestAddressA10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, -1));

        CheckInGuestAddressA16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA16.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA16.setText("1 -12 MAX");
        CheckInGuestAddressA16.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(CheckInGuestAddressA16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 383, 150, -1));

        LabelCheckinA5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA5.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA5.setText("RoomType");
        LabelCheckinA5.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(LabelCheckinA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        LabelCheckinA6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA6.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA6.setText("RoomType");
        LabelCheckinA6.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(LabelCheckinA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        CheckInGuestAddressA17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA17.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA17.setText("Total Amount:");
        CheckInGuestAddressA17.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(CheckInGuestAddressA17, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 160, -1));

        jLabel169.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(227, 221, 203));
        jLabel169.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel169.setText("Check in info");
        CheckinA3.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 260, 46));

        jPanel45.setBackground(new java.awt.Color(185, 178, 139));
        jPanel45.setPreferredSize(new java.awt.Dimension(3, 350));

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        CheckinA3.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        Background7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background7.setPreferredSize(new java.awt.Dimension(1000, 500));
        CheckinA3.add(Background7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckInGuestAddressA18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA18.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA18.setText("Room Schedule");
        CheckInGuestAddressA18.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA3.add(CheckInGuestAddressA18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 110, -1));

        CheckInPayment.add(CheckinA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckinA4.setBackground(new java.awt.Color(255, 255, 255));
        CheckinA4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePaymentWindow1A4.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow1A4.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow1A4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow1A4.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow1A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePayment2ndWindow1A4.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow1A4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel170.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel170.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow1A4.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel46.setBackground(new java.awt.Color(51, 51, 255));
        jPanel46.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow1A4.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel47.setBackground(new java.awt.Color(51, 51, 255));
        jPanel47.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel171.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setText("Aqueza Suites");
        jLabel171.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel47.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel172.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel172.setText("Successfully Payed!");
        jLabel172.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel47.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow1A4.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel173.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(153, 153, 153));
        jLabel173.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel173.setText("(Preview)");
        jLabel173.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A4.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcash1A5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcash1A5.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcash1A5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcash1A5.setText(" php 10000");
        PriceTextGcash1A5.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A4.add(PriceTextGcash1A5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA13.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA13.setText("09xxxxxxxx");
        AccountNameA13.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A4.add(AccountNameA13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA7.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA7.setText("Exit");
        OnlinePaymentButton1GA7.setFocusPainted(false);
        OnlinePaymentButton1GA7.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA7.setRequestFocusEnabled(false);
        OnlinePaymentButton1GA7.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton1GA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA7ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow1A4.add(OnlinePaymentButton1GA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel174.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(153, 153, 153));
        jLabel174.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel174.setText("You Paid");
        jLabel174.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A4.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel175.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(153, 153, 153));
        jLabel175.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel175.setText("using your GCash");
        jLabel175.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A4.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel176.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(153, 153, 153));
        jLabel176.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel176.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel176.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow1A4.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel177.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(153, 153, 153));
        jLabel177.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel177.setText("Account Number");
        jLabel177.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow1A4.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A4.add(OnlinePayment2ndWindow1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow1A4.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow1A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        OnlinePaymentMainWindow1A4.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow1A4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel178.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel178.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/GcashIconn.png"))); // NOI18N
        jLabel178.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow1A4.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel48.setBackground(new java.awt.Color(51, 51, 255));
        jPanel48.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow1A4.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel49.setBackground(new java.awt.Color(51, 51, 255));
        jPanel49.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel179.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(255, 255, 255));
        jLabel179.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel179.setText("Aqueza Suites");
        jLabel179.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel49.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel180.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(255, 255, 255));
        jLabel180.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel180.setText("Confirmation");
        jLabel180.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel49.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow1A4.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel181.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(153, 153, 153));
        jLabel181.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel181.setText("(Preview)");
        jLabel181.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A4.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        PriceTextGcashA4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextGcashA4.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextGcashA4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextGcashA4.setText(" php 10000");
        PriceTextGcashA4.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A4.add(PriceTextGcashA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA14.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA14.setText("09xxxxxxxx");
        AccountNameA14.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A4.add(AccountNameA14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton1GA8.setBackground(new java.awt.Color(51, 102, 255));
        OnlinePaymentButton1GA8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton1GA8.setText("Confirm");
        OnlinePaymentButton1GA8.setFocusPainted(false);
        OnlinePaymentButton1GA8.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton1GA8.setRequestFocusEnabled(false);
        OnlinePaymentButton1GA8.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton1GA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton1GA8ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow1A4.add(OnlinePaymentButton1GA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel182.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(153, 153, 153));
        jLabel182.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel182.setText("You are about to pay");
        jLabel182.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A4.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel183.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(153, 153, 153));
        jLabel183.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel183.setText("using your GCash");
        jLabel183.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A4.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel184.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(153, 153, 153));
        jLabel184.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel184.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel184.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow1A4.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel185.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(153, 153, 153));
        jLabel185.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel185.setText("Account Number");
        jLabel185.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow1A4.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow1A4.add(OnlinePaymentMainWindow1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA4.add(OnlinePaymentWindow1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentWindow2A4.setBackground(new java.awt.Color(25, 25, 26, 200));
        OnlinePaymentWindow2A4.setPreferredSize(new java.awt.Dimension(1000, 500));
        OnlinePaymentWindow2A4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnlinePayment2ndWindow2A4.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePayment2ndWindow2A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePayment2ndWindow2A4.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePayment2ndWindow2A4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel186.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel186.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel186.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePayment2ndWindow2A4.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        jPanel50.setBackground(new java.awt.Color(0, 204, 0));
        jPanel50.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePayment2ndWindow2A4.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel51.setBackground(new java.awt.Color(0, 204, 0));
        jPanel51.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel187.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel187.setText("Aqueza Suites");
        jLabel187.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel51.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel188.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(255, 255, 255));
        jLabel188.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel188.setText("Successfully Paid!");
        jLabel188.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel51.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePayment2ndWindow2A4.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel189.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(153, 153, 153));
        jLabel189.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel189.setText("(Preview)");
        jLabel189.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A4.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 80, -1));

        PriceTextPaymaya2A5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya2A5.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya2A5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya2A5.setText(" php 10000");
        PriceTextPaymaya2A5.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A4.add(PriceTextPaymaya2A5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA15.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA15.setText("09xxxxxxxx");
        AccountNameA15.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A4.add(AccountNameA15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlineExitButton1A4.setBackground(new java.awt.Color(0, 204, 0));
        OnlineExitButton1A4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlineExitButton1A4.setText("Exit");
        OnlineExitButton1A4.setFocusPainted(false);
        OnlineExitButton1A4.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlineExitButton1A4.setRequestFocusEnabled(false);
        OnlineExitButton1A4.setVerifyInputWhenFocusTarget(false);
        OnlineExitButton1A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlineExitButton1A4ActionPerformed(evt);
            }
        });
        OnlinePayment2ndWindow2A4.add(OnlineExitButton1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel190.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(153, 153, 153));
        jLabel190.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel190.setText("You Paid");
        jLabel190.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A4.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel191.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(153, 153, 153));
        jLabel191.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel191.setText("using your PayMaya");
        jLabel191.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A4.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel192.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(153, 153, 153));
        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel192.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel192.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePayment2ndWindow2A4.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel193.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(153, 153, 153));
        jLabel193.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel193.setText("Account Number");
        jLabel193.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePayment2ndWindow2A4.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A4.add(OnlinePayment2ndWindow2A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        OnlinePaymentMainWindow2A4.setBackground(new java.awt.Color(255, 255, 255));
        OnlinePaymentMainWindow2A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 3));
        OnlinePaymentMainWindow2A4.setPreferredSize(new java.awt.Dimension(450, 400));
        OnlinePaymentMainWindow2A4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel194.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel194.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BookingHotelSystemIcons/PayMayaIcon-removebg-preview.png"))); // NOI18N
        jLabel194.setPreferredSize(new java.awt.Dimension(225, 35));
        OnlinePaymentMainWindow2A4.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 180, -1));

        jPanel52.setBackground(new java.awt.Color(0, 204, 0));
        jPanel52.setPreferredSize(new java.awt.Dimension(450, 2));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        OnlinePaymentMainWindow2A4.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));

        jPanel53.setBackground(new java.awt.Color(0, 204, 0));
        jPanel53.setPreferredSize(new java.awt.Dimension(450, 65));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel195.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(255, 255, 255));
        jLabel195.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel195.setText("Aqueza Suites");
        jLabel195.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel53.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 10, -1, -1));

        jLabel196.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(255, 255, 255));
        jLabel196.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel196.setText("Confirmation");
        jLabel196.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel53.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 35, -1, -1));

        OnlinePaymentMainWindow2A4.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        jLabel197.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(153, 153, 153));
        jLabel197.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel197.setText("(Preview)");
        jLabel197.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A4.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 80, -1));

        PriceTextPaymaya1A5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PriceTextPaymaya1A5.setForeground(new java.awt.Color(153, 153, 153));
        PriceTextPaymaya1A5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceTextPaymaya1A5.setText(" php 10000");
        PriceTextPaymaya1A5.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A4.add(PriceTextPaymaya1A5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 160, -1, -1));

        AccountNameA16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AccountNameA16.setForeground(new java.awt.Color(153, 153, 153));
        AccountNameA16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountNameA16.setText("09xxxxxxxx");
        AccountNameA16.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A4.add(AccountNameA16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 130, -1));

        OnlinePaymentButton2GA4.setBackground(new java.awt.Color(0, 204, 0));
        OnlinePaymentButton2GA4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        OnlinePaymentButton2GA4.setText("Confirm");
        OnlinePaymentButton2GA4.setFocusPainted(false);
        OnlinePaymentButton2GA4.setPreferredSize(new java.awt.Dimension(300, 40));
        OnlinePaymentButton2GA4.setRequestFocusEnabled(false);
        OnlinePaymentButton2GA4.setVerifyInputWhenFocusTarget(false);
        OnlinePaymentButton2GA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnlinePaymentButton2GA4ActionPerformed(evt);
            }
        });
        OnlinePaymentMainWindow2A4.add(OnlinePaymentButton2GA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, -1, -1));

        jLabel198.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(153, 153, 153));
        jLabel198.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel198.setText("You are about to pay");
        jLabel198.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A4.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 135, -1, -1));

        jLabel199.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(153, 153, 153));
        jLabel199.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel199.setText("using your PayMaya");
        jLabel199.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A4.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 185, -1, -1));

        jLabel200.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(153, 153, 153));
        jLabel200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel200.setText("Note: This is just a gimmick not real. School purposes only.\n");
        jLabel200.setPreferredSize(new java.awt.Dimension(400, 25));
        OnlinePaymentMainWindow2A4.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel201.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(153, 153, 153));
        jLabel201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel201.setText("Account Number");
        jLabel201.setPreferredSize(new java.awt.Dimension(200, 25));
        OnlinePaymentMainWindow2A4.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        OnlinePaymentWindow2A4.add(OnlinePaymentMainWindow2A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        CheckinA4.add(OnlinePaymentWindow2A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        OnlinePaymentChooseA4.setBackground(new java.awt.Color(96, 87, 69));
        OnlinePaymentChooseA4.setOpaque(false);
        OnlinePaymentChooseA4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Designnn3.setBackground(new java.awt.Color(255, 255, 255));
        Designnn3.setPreferredSize(new java.awt.Dimension(3, 50));
        Designnn3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton5.setText("jRadioButton1");
        Designnn3.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, -1));

        OnlinePaymentChooseA4.add(Designnn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 7, -1, -1));

        GcashOptionA4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        GcashOptionA4.setForeground(new java.awt.Color(255, 255, 255));
        GcashOptionA4.setText("GCash");
        GcashOptionA4.setContentAreaFilled(false);
        GcashOptionA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GcashOptionA4ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA4.add(GcashOptionA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, -1));

        PaymayaOptionA4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        PaymayaOptionA4.setForeground(new java.awt.Color(255, 255, 255));
        PaymayaOptionA4.setText("Pay Maya");
        PaymayaOptionA4.setContentAreaFilled(false);
        PaymayaOptionA4.setRequestFocusEnabled(false);
        PaymayaOptionA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymayaOptionA4ActionPerformed(evt);
            }
        });
        OnlinePaymentChooseA4.add(PaymayaOptionA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 35, 110, -1));

        CheckinA4.add(OnlinePaymentChooseA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 180, 130));

        UpdatePriceA1Button3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UpdatePriceA1Button3.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePriceA1Button3.setText("Refresh Amount");
        UpdatePriceA1Button3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        UpdatePriceA1Button3.setContentAreaFilled(false);
        UpdatePriceA1Button3.setFocusable(false);
        UpdatePriceA1Button3.setPreferredSize(new java.awt.Dimension(135, 35));
        UpdatePriceA1Button3.setRequestFocusEnabled(false);
        UpdatePriceA1Button3.setRolloverEnabled(false);
        UpdatePriceA1Button3.setVerifyInputWhenFocusTarget(false);
        UpdatePriceA1Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePriceA1Button3ActionPerformed(evt);
            }
        });
        CheckinA4.add(UpdatePriceA1Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        ConfirmButtonA1Checkin3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ConfirmButtonA1Checkin3.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmButtonA1Checkin3.setText("Pay & Confirm");
        ConfirmButtonA1Checkin3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(129, 128, 89), 2));
        ConfirmButtonA1Checkin3.setContentAreaFilled(false);
        ConfirmButtonA1Checkin3.setFocusPainted(false);
        ConfirmButtonA1Checkin3.setFocusable(false);
        ConfirmButtonA1Checkin3.setPreferredSize(new java.awt.Dimension(150, 40));
        ConfirmButtonA1Checkin3.setRequestFocusEnabled(false);
        ConfirmButtonA1Checkin3.setRolloverEnabled(false);
        ConfirmButtonA1Checkin3.setVerifyInputWhenFocusTarget(false);
        ConfirmButtonA1Checkin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonA1Checkin3ActionPerformed(evt);
            }
        });
        CheckinA4.add(ConfirmButtonA1Checkin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 190, -1));

        RoomSchedNightCheckinA4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedNightCheckinA4.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedNightCheckinA4.setText("6:00PM - 8:00AM Overnight");
        RoomSchedNightCheckinA4.setContentAreaFilled(false);
        RoomSchedNightCheckinA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedNightCheckinA4ActionPerformed(evt);
            }
        });
        CheckinA4.add(RoomSchedNightCheckinA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 250, -1));

        RoomSchedDayCheckinA4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        RoomSchedDayCheckinA4.setForeground(new java.awt.Color(255, 255, 255));
        RoomSchedDayCheckinA4.setSelected(true);
        RoomSchedDayCheckinA4.setText("6:00AM - 8:00AM Day");
        RoomSchedDayCheckinA4.setContentAreaFilled(false);
        RoomSchedDayCheckinA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomSchedDayCheckinA4ActionPerformed(evt);
            }
        });
        CheckinA4.add(RoomSchedDayCheckinA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 250, -1));

        PaymentMethodCheckin1A4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin1A4.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin1A4.setText("OnlinePayment");
        PaymentMethodCheckin1A4.setContentAreaFilled(false);
        PaymentMethodCheckin1A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin1A4ActionPerformed(evt);
            }
        });
        CheckinA4.add(PaymentMethodCheckin1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, -1, -1));

        PaymentMethodCheckin2A4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin2A4.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin2A4.setText("Cash");
        PaymentMethodCheckin2A4.setActionCommand("");
        PaymentMethodCheckin2A4.setContentAreaFilled(false);
        PaymentMethodCheckin2A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin2A4ActionPerformed(evt);
            }
        });
        CheckinA4.add(PaymentMethodCheckin2A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 80, -1));

        PaymentMethodCheckin3A4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PaymentMethodCheckin3A4.setForeground(new java.awt.Color(227, 221, 203));
        PaymentMethodCheckin3A4.setText("Debit/Credit Card");
        PaymentMethodCheckin3A4.setContentAreaFilled(false);
        PaymentMethodCheckin3A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMethodCheckin3A4ActionPerformed(evt);
            }
        });
        CheckinA4.add(PaymentMethodCheckin3A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        CheckInGuestNameA4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestNameA4.setToolTipText("");
        CheckInGuestNameA4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestNameA4.setFocusTraversalPolicyProvider(true);
        CheckInGuestNameA4.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestNameA4.setVerifyInputWhenFocusTarget(false);
        CheckInGuestNameA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestNameA4ActionPerformed(evt);
            }
        });
        CheckinA4.add(CheckInGuestNameA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 250, -1));

        CheckInGuestAddress1A4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddress1A4.setToolTipText("");
        CheckInGuestAddress1A4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        CheckInGuestAddress1A4.setFocusTraversalPolicyProvider(true);
        CheckInGuestAddress1A4.setPreferredSize(new java.awt.Dimension(250, 35));
        CheckInGuestAddress1A4.setVerifyInputWhenFocusTarget(false);
        CheckInGuestAddress1A4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInGuestAddress1A4ActionPerformed(evt);
            }
        });
        CheckinA4.add(CheckInGuestAddress1A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, -1));

        TotalAmountCheckinA4.setEditable(false);
        TotalAmountCheckinA4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TotalAmountCheckinA4.setText("1");
        TotalAmountCheckinA4.setToolTipText("");
        TotalAmountCheckinA4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        TotalAmountCheckinA4.setFocusTraversalPolicyProvider(true);
        TotalAmountCheckinA4.setPreferredSize(new java.awt.Dimension(250, 35));
        TotalAmountCheckinA4.setRequestFocusEnabled(false);
        TotalAmountCheckinA4.setVerifyInputWhenFocusTarget(false);
        TotalAmountCheckinA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountCheckinA4ActionPerformed(evt);
            }
        });
        CheckinA4.add(TotalAmountCheckinA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 250, -1));

        RoomPriceA4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RoomPriceA4.setForeground(new java.awt.Color(227, 221, 203));
        RoomPriceA4.setText("Room Price Selected: ");
        RoomPriceA4.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(RoomPriceA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 310, -1));

        CheckInGuestAddressA20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA20.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA20.setText("Payment Method");
        CheckInGuestAddressA20.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(CheckInGuestAddressA20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 160, -1));

        jLabel202.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(227, 221, 203));
        jLabel202.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel202.setText("Payment & Confirmation");
        CheckinA4.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 400, 46));

        MaxDaysCheckinA4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MaxDaysCheckinA4.setText("1");
        MaxDaysCheckinA4.setToolTipText("");
        MaxDaysCheckinA4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        MaxDaysCheckinA4.setFocusTraversalPolicyProvider(true);
        MaxDaysCheckinA4.setPreferredSize(new java.awt.Dimension(250, 35));
        MaxDaysCheckinA4.setVerifyInputWhenFocusTarget(false);
        MaxDaysCheckinA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxDaysCheckinA4ActionPerformed(evt);
            }
        });
        CheckinA4.add(MaxDaysCheckinA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 110, -1));

        jLabel203.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(227, 221, 203));
        jLabel203.setText("Full Name");
        jLabel203.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, -1));

        AddressLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddressLabel3.setForeground(new java.awt.Color(227, 221, 203));
        AddressLabel3.setText("Address");
        AddressLabel3.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(AddressLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 110, -1));

        DesignCheckin4.setBackground(new java.awt.Color(255, 255, 255));
        DesignCheckin4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DesignCheckin4.setForeground(new java.awt.Color(255, 255, 255));
        DesignCheckin4.setText("Family Room B");
        DesignCheckin4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(110, 104, 70), 2));
        DesignCheckin4.setPreferredSize(new java.awt.Dimension(250, 35));
        DesignCheckin4.setVerifyInputWhenFocusTarget(false);
        CheckinA4.add(DesignCheckin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 250, -1));

        CheckInGuestAddressA21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA21.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA21.setText("Days");
        CheckInGuestAddressA21.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(CheckInGuestAddressA21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, -1));

        CheckInGuestAddressA22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA22.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA22.setText("1 -12 MAX");
        CheckInGuestAddressA22.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(CheckInGuestAddressA22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 383, 150, -1));

        LabelCheckinA7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA7.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA7.setText("RoomType");
        LabelCheckinA7.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(LabelCheckinA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        LabelCheckinA8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelCheckinA8.setForeground(new java.awt.Color(227, 221, 203));
        LabelCheckinA8.setText("RoomType");
        LabelCheckinA8.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(LabelCheckinA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 110, -1));

        CheckInGuestAddressA23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA23.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA23.setText("Total Amount:");
        CheckInGuestAddressA23.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(CheckInGuestAddressA23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 160, -1));

        jLabel204.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(227, 221, 203));
        jLabel204.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel204.setText("Check in info");
        CheckinA4.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 260, 46));

        jPanel54.setBackground(new java.awt.Color(185, 178, 139));
        jPanel54.setPreferredSize(new java.awt.Dimension(3, 350));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        CheckinA4.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        Background8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View Main Intro Blurred100.jpg"))); // NOI18N
        Background8.setPreferredSize(new java.awt.Dimension(1000, 500));
        CheckinA4.add(Background8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CheckInGuestAddressA24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckInGuestAddressA24.setForeground(new java.awt.Color(227, 221, 203));
        CheckInGuestAddressA24.setText("Room Schedule");
        CheckInGuestAddressA24.setPreferredSize(new java.awt.Dimension(50, 30));
        CheckinA4.add(CheckInGuestAddressA24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 110, -1));

        CheckInPayment.add(CheckinA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RoomInfoPanel.add(CheckInPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        getContentPane().add(RoomInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoginSystemPanel.setBackground(new java.awt.Color(235, 231, 203));
        LoginSystemPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        LoginSystemPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AccountInfoPanel.setPreferredSize(new java.awt.Dimension(1000, 500));

        javax.swing.GroupLayout AccountInfoPanelLayout = new javax.swing.GroupLayout(AccountInfoPanel);
        AccountInfoPanel.setLayout(AccountInfoPanelLayout);
        AccountInfoPanelLayout.setHorizontalGroup(
            AccountInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        AccountInfoPanelLayout.setVerticalGroup(
            AccountInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        LoginSystemPanel.add(AccountInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ExitMessageWindow.setBackground(new java.awt.Color(0, 0, 0, 200));
        ExitMessageWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitMessageMainWindow.setBackground(new java.awt.Color(204, 195, 142));
        ExitMessageMainWindow.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(193, 190, 157), 2));
        ExitMessageMainWindow.setPreferredSize(new java.awt.Dimension(400, 400));

        ExitButtonLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ExitButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        ExitButtonLogin.setText("No");
        ExitButtonLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ExitButtonLogin.setContentAreaFilled(false);
        ExitButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonLoginActionPerformed(evt);
            }
        });

        ContinueButtonLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ContinueButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        ContinueButtonLogin.setText("Yes");
        ContinueButtonLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ContinueButtonLogin.setContentAreaFilled(false);
        ContinueButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueButtonLoginActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout ExitMessageMainWindowLayout = new javax.swing.GroupLayout(ExitMessageMainWindow);
        ExitMessageMainWindow.setLayout(ExitMessageMainWindowLayout);
        ExitMessageMainWindowLayout.setHorizontalGroup(
            ExitMessageMainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitMessageMainWindowLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(ExitButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(ContinueButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExitMessageMainWindowLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        ExitMessageMainWindowLayout.setVerticalGroup(
            ExitMessageMainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExitMessageMainWindowLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTextArea4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(ExitMessageMainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContinueButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        ExitMessageWindow.add(ExitMessageMainWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 368, 190));

        LoginSystemPanel.add(ExitMessageWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        ExitLoginButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ExitLoginButton2.setText("Exit");
        ExitLoginButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(182, 174, 140), 2));
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
        LoginSystemPanel.add(ExitLoginButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, -1));

        LoginFormWindow.setBackground(new java.awt.Color(197, 177, 149, 100));
        LoginFormWindow.setPreferredSize(new java.awt.Dimension(500, 300));
        LoginFormWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Sign in to Auqeza Suites");
        LoginFormWindow.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 30));

        PasswordSigninInput1.setBackground(new java.awt.Color(76, 71, 51));
        PasswordSigninInput1.setForeground(new java.awt.Color(255, 255, 255));
        PasswordSigninInput1.setBorder(null);
        PasswordSigninInput1.setPreferredSize(new java.awt.Dimension(250, 35));
        PasswordSigninInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordSigninInput1ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(PasswordSigninInput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        UsernameSigninInput1.setBackground(new java.awt.Color(76, 71, 51));
        UsernameSigninInput1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UsernameSigninInput1.setForeground(new java.awt.Color(255, 255, 255));
        UsernameSigninInput1.setBorder(null);
        UsernameSigninInput1.setFocusTraversalPolicyProvider(true);
        UsernameSigninInput1.setInheritsPopupMenu(true);
        UsernameSigninInput1.setPreferredSize(new java.awt.Dimension(250, 35));
        UsernameSigninInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameSigninInput1ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(UsernameSigninInput1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Doesnt have an account yet?");
        LoginFormWindow.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 160, 30));

        SignInButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SignInButton1.setText("Create Account");
        SignInButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(182, 174, 140), 2));
        SignInButton1.setFocusable(false);
        SignInButton1.setPreferredSize(new java.awt.Dimension(100, 35));
        SignInButton1.setRequestFocusEnabled(false);
        SignInButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButton1ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(SignInButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 150, -1));

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Username:");
        LoginFormWindow.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 140, 30));

        SignInButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SignInButton2.setText("Sign in");
        SignInButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(182, 174, 140), 2));
        SignInButton2.setFocusable(false);
        SignInButton2.setPreferredSize(new java.awt.Dimension(100, 35));
        SignInButton2.setRequestFocusEnabled(false);
        SignInButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButton2ActionPerformed(evt);
            }
        });
        LoginFormWindow.add(SignInButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Password:");
        LoginFormWindow.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 140, 30));

        LoginSystemPanel.add(LoginFormWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 500, 500));

        RegisterFormWindow.setBackground(new java.awt.Color(197, 177, 149, 100));
        RegisterFormWindow.setPreferredSize(new java.awt.Dimension(500, 300));
        RegisterFormWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NumberSignUpInput.setBackground(new java.awt.Color(96, 85, 63));
        NumberSignUpInput.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        NumberSignUpInput.setForeground(new java.awt.Color(255, 255, 255));
        NumberSignUpInput.setBorder(null);
        NumberSignUpInput.setFocusCycleRoot(true);
        NumberSignUpInput.setInheritsPopupMenu(true);
        NumberSignUpInput.setPreferredSize(new java.awt.Dimension(250, 35));
        NumberSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(NumberSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        EmailAddressSignUpInput.setBackground(new java.awt.Color(96, 85, 63));
        EmailAddressSignUpInput.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        EmailAddressSignUpInput.setForeground(new java.awt.Color(255, 255, 255));
        EmailAddressSignUpInput.setBorder(null);
        EmailAddressSignUpInput.setFocusCycleRoot(true);
        EmailAddressSignUpInput.setInheritsPopupMenu(true);
        EmailAddressSignUpInput.setPreferredSize(new java.awt.Dimension(250, 35));
        EmailAddressSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailAddressSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(EmailAddressSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        UsernameSignUpInput.setBackground(new java.awt.Color(96, 85, 63));
        UsernameSignUpInput.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        UsernameSignUpInput.setForeground(new java.awt.Color(255, 255, 255));
        UsernameSignUpInput.setBorder(null);
        UsernameSignUpInput.setFocusCycleRoot(true);
        UsernameSignUpInput.setInheritsPopupMenu(true);
        UsernameSignUpInput.setPreferredSize(new java.awt.Dimension(250, 35));
        UsernameSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(UsernameSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        PasswordSignUpInput.setBackground(new java.awt.Color(96, 85, 63));
        PasswordSignUpInput.setForeground(new java.awt.Color(255, 255, 255));
        PasswordSignUpInput.setBorder(null);
        PasswordSignUpInput.setPreferredSize(new java.awt.Dimension(250, 35));
        PasswordSignUpInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordSignUpInputActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(PasswordSignUpInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        SignUpButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SignUpButton1.setText("Create Account");
        SignUpButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(182, 174, 140), 2));
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
        RegisterFormWindow.add(SignUpButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 170, -1));

        jLabel83.setBackground(new java.awt.Color(255, 255, 255));
        jLabel83.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("EmailAddress:");
        RegisterFormWindow.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 140, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Username:");
        RegisterFormWindow.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 140, 30));

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Register to Auqeza Suites");
        RegisterFormWindow.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 30));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Already have an account?");
        RegisterFormWindow.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 140, 30));

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Password:");
        RegisterFormWindow.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 140, 30));

        GOSigninWindowButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        GOSigninWindowButton.setText("Sign In");
        GOSigninWindowButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(182, 174, 140), 2));
        GOSigninWindowButton.setFocusable(false);
        GOSigninWindowButton.setPreferredSize(new java.awt.Dimension(100, 35));
        GOSigninWindowButton.setRequestFocusEnabled(false);
        GOSigninWindowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GOSigninWindowButtonActionPerformed(evt);
            }
        });
        RegisterFormWindow.add(GOSigninWindowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, -1, -1));

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Phone number:");
        RegisterFormWindow.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 140, 30));

        AccountInfoWindow.setPreferredSize(new java.awt.Dimension(1000, 500));

        jLabel57.setText("Account");

        Background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookinghotelsystem/PicturesforIcons/MainSystemPictures/Room View None.jpg"))); // NOI18N
        Background2.setPreferredSize(new java.awt.Dimension(1000, 500));

        javax.swing.GroupLayout AccountInfoWindowLayout = new javax.swing.GroupLayout(AccountInfoWindow);
        AccountInfoWindow.setLayout(AccountInfoWindowLayout);
        AccountInfoWindowLayout.setHorizontalGroup(
            AccountInfoWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountInfoWindowLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(911, Short.MAX_VALUE))
            .addGroup(AccountInfoWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AccountInfoWindowLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Background2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        AccountInfoWindowLayout.setVerticalGroup(
            AccountInfoWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountInfoWindowLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel57)
                .addContainerGap(430, Short.MAX_VALUE))
            .addGroup(AccountInfoWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AccountInfoWindowLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Background2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        RegisterFormWindow.add(AccountInfoWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        LoginSystemPanel.add(RegisterFormWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, 500));

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
        MenuOpenButton.setVisible(false);
        
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
            RoomInfoPanel.setVisible(false);
            AccountInfoWindow.setVisible(false);
            ExitMessageWindow.setVisible(false);
            AccountInfoPanel.setVisible(false);
            
            
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
            //Opening Main Window Account
            LoginSystemPanel.setVisible(true);
        }
    }//GEN-LAST:event_ViewHotelFeatureButtonActionPerformed

    private void RoomSectionButtionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSectionButtionActionPerformed

       
        
    }//GEN-LAST:event_RoomSectionButtionActionPerformed

    private void ViewHotelFeatureButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewHotelFeatureButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewHotelFeatureButton1ActionPerformed

    private void ExitMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuButtonActionPerformed
        MenuButtonsPanels.setVisible(false);
        CompanyNameLabel.setVisible(true);
        MenuOpenButton.setVisible(true);
    }//GEN-LAST:event_ExitMenuButtonActionPerformed

    private void MenuOpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOpenButtonActionPerformed
        MenuButtonsPanels.setVisible(true);
        CompanyNameLabel.setVisible(false);
        MenuOpenButton.setVisible(false);
    }//GEN-LAST:event_MenuOpenButtonActionPerformed

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
         password = PasswordSigninInput1.getText();
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
                MenuOpenButton.setVisible(true);
                

                
                
                
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
            
        } else {
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
            CheckinA2.setVisible(false);
            CheckinA3.setVisible(false);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowC1.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            
            
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
        ExitMessageWindow.setVisible(true);
        
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
        AccountInfoWindow.setVisible(false);
        Background3.setVisible(false);
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
        MenuOpenButton.setVisible(true);
        
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
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A2.setVisible(false);
            OnlinePaymentMainWindow1A2.setVisible(false);
            OnlinePaymentWindow2A2.setVisible(false);
            OnlinePaymentMainWindow2A2.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(false);
            CheckinA2.setVisible(true);
            CheckinA3.setVisible(false);
            OnlinePaymentChooseA2.setVisible(false);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowB2.setVisible(false);
            InfoWindowC1.setVisible(false);
            InfoWindowC2.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            
            
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
        AccountInfoWindow.setVisible(false);
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
               if (number >= 1 && number <= 10) {
                   PaymentDetailsA1();
               } else {
                   JOptionPane.showMessageDialog(new JFrame(), "Please input a number between 1-10.");
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid number.");
               
           }
        }
        
    }//GEN-LAST:event_MaxDaysCheckinA1ActionPerformed

    private void PaymentMethodCheckin2A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin2A1ActionPerformed
        // if open
        PaymentCheckInA1();
    }//GEN-LAST:event_PaymentMethodCheckin2A1ActionPerformed

    private void PaymentMethodCheckin1A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin1A1ActionPerformed
        // if open
        PaymentCheckInA1();
    }//GEN-LAST:event_PaymentMethodCheckin1A1ActionPerformed

    private void PaymentMethodCheckin3A1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin3A1ActionPerformed
        // if open
        PaymentCheckInA1();
    }//GEN-LAST:event_PaymentMethodCheckin3A1ActionPerformed

    private void RoomB1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomB1ButtonActionPerformed
        //Open Window B1
        RoomInfoPanel.setVisible(true);
        InfoWindows.setVisible(true);
        InfoWindowB1.setVisible(true);
        //closing other windows
        MenuButtonsPanels.setVisible(false);
        MainPanel1.setVisible(false);
        RoomSectionPanel.setVisible(false);
        AccountInfoWindow.setVisible(false);
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
        AccountInfoWindow.setVisible(false);
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
        AccountInfoWindow.setVisible(false);
        LoginSystemPanel.setVisible(false);
        //other Room Info Closed
        InfoWindowA1.setVisible(false);
        InfoWindowA2.setVisible(false);
        InfoWindowB1.setVisible(false);
        InfoWindowB2.setVisible(false);
        InfoWindowC2.setVisible(false);
    }//GEN-LAST:event_RoomB1Button1ActionPerformed

    private void RoomB2Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomB2Button1ActionPerformed
        //Open Window Window C2
        RoomInfoPanel.setVisible(true);
        InfoWindows.setVisible(true);
        InfoWindowC2.setVisible(true);
        //closing other windows
        MenuButtonsPanels.setVisible(false);
        MainPanel1.setVisible(false);
        RoomSectionPanel.setVisible(false);
        AccountInfoWindow.setVisible(false);
        LoginSystemPanel.setVisible(false);
        //other Room Info Closed
        InfoWindowA1.setVisible(false);
        InfoWindowA2.setVisible(false);
        InfoWindowB1.setVisible(false);
        InfoWindowB2.setVisible(false);
        InfoWindowC1.setVisible(false);
                                      
    }//GEN-LAST:event_RoomB2Button1ActionPerformed

    private void ConfirmButtonA1CheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonA1CheckinActionPerformed
        // CheckOut Room A1
        PaymentMethodA1();
    }//GEN-LAST:event_ConfirmButtonA1CheckinActionPerformed

    private void ExitButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonLoginActionPerformed
        // Opening Login Window (On)
        ExitMessageWindow.setVisible(false);
        ExitLoginButton2.setVisible(true);
        Timer timer2 = new Timer(500, e -> {
            ExitMessageMainWindow.setVisible(false);
            
            });
        timer2.setRepeats(false);
        timer2.start();
    }//GEN-LAST:event_ExitButtonLoginActionPerformed

    private void ContinueButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueButtonLoginActionPerformed
        // Closing Login Window (Off)
        ExitLoginButton2.setVisible(true);
        LoginSystemPanel.setVisible(false);
        RoomSectionPanel.setVisible(true);
        MenuOpenButton.setVisible(true);
        ExitMessageMainWindow.setVisible(false);
            
        if (LoginEnabled < 2) {
            ExitMessageWindow.setVisible(false);
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
        roomtypeA1 = "Single Class A";
        paymentmethod = "Online payment";
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
                    JOptionPane.showMessageDialog(new JFrame(), "Booking successfully saved! you may now check your book info in AccountInfo Menu.");
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
        HotelFeaturesPanel.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
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
        HotelFeaturesPanel.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
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
        roomtypeA1 = "Single Class A";
        paymentmethod = "Online payment";
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

    private void OnlinePaymentButton1GA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA3ActionPerformed
        // exit gcash A2
        JOptionPane.showMessageDialog(new JFrame(), "Successfully booked. You will be directly to room section"
         + (" you can view your book info on account info menu."));
        OnlinePaymentWindow1A2.setVisible(false);
        OnlinePayment2ndWindow1A2.setVisible(false);
        CheckinA2.setVisible(false);
        CheckinA1.setVisible(false);
        //making sure the other panel is not visible--
        RoomInfoPanel.setVisible(false);
        MainPanel1.setVisible(false);
        HotelFeaturesPanel.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
           RoomSectionPanel.setVisible(true);
        });
        Hotelappear1.setRepeats(false);
        Hotelappear1.start();
        
    }//GEN-LAST:event_OnlinePaymentButton1GA3ActionPerformed

    private void OnlinePaymentButton1GA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA4ActionPerformed
        // GCash room A2
         String guestnameA1, addressA1, roomtypeA1, roompriceA1, paymentmethod, paymentstatus, paymentTotal;
        
         
        paymentTotal = TotalAmountCheckinA2.getText();
        roompriceA1 = RoomPriceA2.getText();
        guestnameA1 = CheckInGuestNameA2.getText();
        addressA1 = CheckInGuestAddressA2.getText();
        roomtypeA1 = "Double Class A";
        paymentmethod = "Online payment";
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
                    stmt.setString(6, paymentTotal);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        Timer paymentDelayed1 = new Timer(500, e -> {
            OnlinePaymentMainWindow1A2.setVisible(false);
        });
        
        paymentDelayed1.setRepeats(false);
        paymentDelayed1.start();
        Timer paymentDelayed2 = new Timer(500, e -> {
           OnlinePayment2ndWindow1A2.setVisible(true); 
        });
        
        paymentDelayed2.setRepeats(false);
        paymentDelayed2.start();
    }//GEN-LAST:event_OnlinePaymentButton1GA4ActionPerformed

    private void OnlineExitButton1A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlineExitButton1A2ActionPerformed
        // Paymaya exit button A2
        JOptionPane.showMessageDialog(new JFrame(), "Successfully booked. You will be directly to room section"
         + (" you can view your book info on account info menu."));
        OnlinePaymentWindow2A2.setVisible(false);
        OnlinePayment2ndWindow2A2.setVisible(false);
        CheckinA2.setVisible(false);
        CheckinA1.setVisible(false);
        //making sure the other panel is not visible--
        RoomInfoPanel.setVisible(false);
        MainPanel1.setVisible(false);
        HotelFeaturesPanel.setVisible(false);
        
        //closing payment method
        OnlinePaymentWindow1A2.setVisible(false);
            OnlinePaymentWindow2A2.setVisible(false);
            OnlinePaymentChooseA2.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
           RoomSectionPanel.setVisible(true);
        });
        Hotelappear1.setRepeats(false);
        Hotelappear1.start();
        
    }//GEN-LAST:event_OnlineExitButton1A2ActionPerformed

    private void OnlinePaymentButton2GA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton2GA2ActionPerformed
        // Paymaya room A2
         String roomselectedpriceA1 = null, guestnameA1, addressA1, roomtypeA1, roompriceA1, paymentmethod, paymentstatus, paymentTotal;
        
         
        if (RoomSchedDayCheckinA2.isSelected()) {
            roomselectedpriceA1 = "8499";
        } else if (RoomSchedNightCheckinA2.isSelected()) {
            roomselectedpriceA1 = "7499";
        }
        paymentTotal = TotalAmountCheckinA2.getText();
        roompriceA1 = roomselectedpriceA1;
        guestnameA1 = CheckInGuestNameA2.getText();
        addressA1 = CheckInGuestAddressA2.getText();
        roomtypeA1 = "Double Class A";
        paymentmethod = "Online payment";
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
                    stmt.setString(6, paymentTotal);
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

    private void GcashOptionA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GcashOptionA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GcashOptionA2ActionPerformed

    private void PaymayaOptionA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymayaOptionA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymayaOptionA2ActionPerformed

    private void UpdatePriceA1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePriceA1Button1ActionPerformed
        // total display A2
        PaymentDetailsA2();
    }//GEN-LAST:event_UpdatePriceA1Button1ActionPerformed

    private void ConfirmButtonA1Checkin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonA1Checkin1ActionPerformed
        //Payment Confirmation A2
        PaymentMethodA2();
    }//GEN-LAST:event_ConfirmButtonA1Checkin1ActionPerformed

    private void RoomSchedNightCheckinA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedNightCheckinA2ActionPerformed
        // A2 day night selection
        PaymentDetailsA2();
    }//GEN-LAST:event_RoomSchedNightCheckinA2ActionPerformed

    private void RoomSchedDayCheckinA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedDayCheckinA2ActionPerformed
        // A2 day night selection
        PaymentDetailsA2();
    }//GEN-LAST:event_RoomSchedDayCheckinA2ActionPerformed

    private void PaymentMethodCheckin1A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin1A2ActionPerformed
        // A2 payment method 
        PaymentCheckInA2();
    }//GEN-LAST:event_PaymentMethodCheckin1A2ActionPerformed

    private void PaymentMethodCheckin2A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin2A2ActionPerformed
        // A2 payment method
        PaymentCheckInA2();
    }//GEN-LAST:event_PaymentMethodCheckin2A2ActionPerformed

    private void PaymentMethodCheckin3A2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin3A2ActionPerformed
        // A2 payment method
        PaymentCheckInA2();
    }//GEN-LAST:event_PaymentMethodCheckin3A2ActionPerformed

    private void CheckInGuestNameA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestNameA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestNameA2ActionPerformed

    private void CheckInGuestAddressA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestAddressA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestAddressA2ActionPerformed

    private void TotalAmountCheckinA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAmountCheckinA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountCheckinA2ActionPerformed

    private void MaxDaysCheckinA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxDaysCheckinA2ActionPerformed
        // checking days A2
        if ("".equals(MaxDaysCheckinA2.getText())) {
            JOptionPane.showMessageDialog( new JFrame(), "please input a number.");
        } else {
           try {
               int number = Integer.parseInt(MaxDaysCheckinA2.getText());
               if (number >= 1 && number <= 10) {
                   PaymentDetailsA2();
               } else {
                   JOptionPane.showMessageDialog(new JFrame(), "Please input a number between 1-10.");
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid number.");
               
           }
        }
    }//GEN-LAST:event_MaxDaysCheckinA2ActionPerformed

    private void OnlinePaymentButton1GA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA5ActionPerformed
        // exit GCash A3
        JOptionPane.showMessageDialog(new JFrame(), "Successfully booked. You will be directly to room section"
         + (" you can view your book info on account info menu."));
        OnlinePaymentWindow1A3.setVisible(false);
        OnlinePayment2ndWindow1A3.setVisible(false);
        CheckinA3.setVisible(false);
        CheckinA2.setVisible(false);
        CheckinA1.setVisible(false);
        //making sure the other panel is not visible--
        RoomInfoPanel.setVisible(false);
        MainPanel1.setVisible(false);
        HotelFeaturesPanel.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
           RoomSectionPanel.setVisible(true);
        });
        Hotelappear1.setRepeats(false);
        Hotelappear1.start();
        
    }//GEN-LAST:event_OnlinePaymentButton1GA5ActionPerformed

    private void OnlinePaymentButton1GA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA6ActionPerformed
        // GCASH room A3
         String roomselectedpriceA1 = null, guestnameA1, addressA1, roomtypeA1, roompriceA1, paymentmethod, paymentstatus, paymentTotal;
        
         
        if (RoomSchedDayCheckinA3.isSelected()) {
            roomselectedpriceA1 = "15499";
        } else if (RoomSchedNightCheckinA3.isSelected()) {
            roomselectedpriceA1 = "16499";
        }
        paymentTotal = TotalAmountCheckinA3.getText();
        roompriceA1 = roomselectedpriceA1;
        guestnameA1 = CheckInGuestNameA3.getText();
        addressA1 = CheckInGuestAddressA3.getText();
        roomtypeA1 = "Family Room A";
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
                    stmt.setString(6, paymentTotal);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        Timer paymentDelayed1 = new Timer(500, e -> {
            OnlinePaymentMainWindow1A3.setVisible(false);
        });
        
        paymentDelayed1.setRepeats(false);
        paymentDelayed1.start();
        Timer paymentDelayed2 = new Timer(500, e -> {
           OnlinePayment2ndWindow1A3.setVisible(true); 
        });
        
        paymentDelayed2.setRepeats(false);
        paymentDelayed2.start();
    }//GEN-LAST:event_OnlinePaymentButton1GA6ActionPerformed

    private void OnlineExitButton1A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlineExitButton1A3ActionPerformed
        // exit paymaya A3
        JOptionPane.showMessageDialog(new JFrame(), "Successfully booked. You will be directly to room section"
         + (" you can view your book info on account info menu."));
        OnlinePaymentWindow2A3.setVisible(false);
        OnlinePayment2ndWindow2A3.setVisible(false);
        CheckinA3.setVisible(false);
        CheckinA2.setVisible(false);
        CheckinA1.setVisible(false);
        //making sure the other panel is not visible--
        RoomInfoPanel.setVisible(false);
        MainPanel1.setVisible(false);
        HotelFeaturesPanel.setVisible(false);
        Timer Hotelappear1 = new Timer(1000, e -> {
           RoomSectionPanel.setVisible(true);
        });
        Hotelappear1.setRepeats(false);
        Hotelappear1.start();
    }//GEN-LAST:event_OnlineExitButton1A3ActionPerformed

    private void OnlinePaymentButton2GA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton2GA3ActionPerformed
        // Paymaya room A3
         String roomselectedpriceA1 = null, guestnameA1, addressA1, roomtypeA1, roompriceA1, paymentmethod, paymentstatus, paymentTotal;
        
         
        if (RoomSchedDayCheckinA3.isSelected()) {
            roomselectedpriceA1 = "15499";
        } else if (RoomSchedNightCheckinA3.isSelected()) {
            roomselectedpriceA1 = "16499";
        }
        paymentTotal = TotalAmountCheckinA3.getText();
        roompriceA1 = roomselectedpriceA1;
        guestnameA1 = CheckInGuestNameA3.getText();
        addressA1 = CheckInGuestAddressA3.getText();
        roomtypeA1 = "Family Room A";
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
                    stmt.setString(6, paymentTotal);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        Timer paymentDelayed1 = new Timer(500, e -> {
            OnlinePaymentMainWindow2A3.setVisible(false);
        });
        
        paymentDelayed1.setRepeats(false);
        paymentDelayed1.start();
        Timer paymentDelayed2 = new Timer(500, e -> {
           OnlinePayment2ndWindow2A3.setVisible(true); 
        });
        
        paymentDelayed2.setRepeats(false);
        paymentDelayed2.start();
    }//GEN-LAST:event_OnlinePaymentButton2GA3ActionPerformed

    private void GcashOptionA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GcashOptionA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GcashOptionA3ActionPerformed

    private void PaymayaOptionA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymayaOptionA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymayaOptionA3ActionPerformed

    private void UpdatePriceA1Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePriceA1Button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdatePriceA1Button2ActionPerformed

    private void ConfirmButtonA1Checkin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonA1Checkin2ActionPerformed
        // opening the payment method A3
        PaymentMethodA3();
    }//GEN-LAST:event_ConfirmButtonA1Checkin2ActionPerformed

    private void RoomSchedNightCheckinA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedNightCheckinA3ActionPerformed
        // RoomSched night A3
        PaymentDetailsA3();
    }//GEN-LAST:event_RoomSchedNightCheckinA3ActionPerformed

    private void RoomSchedDayCheckinA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedDayCheckinA3ActionPerformed
        // RoomSched day A3
        PaymentDetailsA3();
    }//GEN-LAST:event_RoomSchedDayCheckinA3ActionPerformed

    private void PaymentMethodCheckin1A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin1A3ActionPerformed
        // PaymentMethod online payment A3
        PaymentCheckInA3();
    }//GEN-LAST:event_PaymentMethodCheckin1A3ActionPerformed

    private void PaymentMethodCheckin2A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin2A3ActionPerformed
        // PaymentMethod cash payment A3
        PaymentCheckInA3();
    }//GEN-LAST:event_PaymentMethodCheckin2A3ActionPerformed

    private void PaymentMethodCheckin3A3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin3A3ActionPerformed
        // Payment Method Checkin credit card A3
        PaymentCheckInA3();
    }//GEN-LAST:event_PaymentMethodCheckin3A3ActionPerformed

    private void CheckInGuestNameA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestNameA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestNameA3ActionPerformed

    private void CheckInGuestAddressA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestAddressA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestAddressA3ActionPerformed

    private void TotalAmountCheckinA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAmountCheckinA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountCheckinA3ActionPerformed

    private void MaxDaysCheckinA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxDaysCheckinA3ActionPerformed
        // days max thing A3
        if ("".equals(MaxDaysCheckinA3.getText())) {
            JOptionPane.showMessageDialog( new JFrame(), "please input a number.");
        } else {
           try {
               int number = Integer.parseInt(MaxDaysCheckinA3.getText());
               if (number >= 1 && number <= 10) {
                   PaymentDetailsA3();
               } else {
                   JOptionPane.showMessageDialog(new JFrame(), "Please input a number between 1-10.");
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid number.");
               
           }
        }
    }//GEN-LAST:event_MaxDaysCheckinA3ActionPerformed

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
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A3.setVisible(false);
            OnlinePaymentMainWindow1A3.setVisible(false);
            OnlinePaymentWindow2A3.setVisible(false);
            OnlinePaymentMainWindow2A3.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(false);
            CheckinA2.setVisible(false);
            CheckinA3.setVisible(true);
            OnlinePaymentChooseA2.setVisible(false);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB2.setVisible(false);
            InfoWindowC1.setVisible(false);
            InfoWindowC2.setVisible(false);
            OnlinePaymentChooseA3.setVisible(false);
            
            
        }
    }//GEN-LAST:event_BookButtonB1ActionPerformed

    private void OnlinePaymentButton1GA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OnlinePaymentButton1GA7ActionPerformed

    private void OnlinePaymentButton1GA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton1GA8ActionPerformed
        // GCASH room A4
         String roomselectedpriceA1 = null, guestnameA1, addressA1, roomtypeA1, roompriceA1, paymentmethod, paymentstatus, paymentTotal;
        
         
        if (RoomSchedDayCheckinA4.isSelected()) {
            roomselectedpriceA1 = "17499";
        } else if (RoomSchedNightCheckinA4.isSelected()) {
            roomselectedpriceA1 = "18499";
        }
        paymentTotal = TotalAmountCheckinA4.getText();
        roompriceA1 = roomselectedpriceA1;
        guestnameA1 = CheckInGuestNameA4.getText();
        addressA1 = CheckInGuestAddressA4.getText();
        roomtypeA1 = "Family Room A";
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
                    stmt.setString(6, paymentTotal);
                    stmt.setString(7, paymentmethod);
                    stmt.setString(8, paymentstatus);
                    stmt.setString(9, Usernamee);
                    stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainWindow1.class.getName()).log(Level.SEVERE, null, ex);
            }
        Timer paymentDelayed1 = new Timer(500, e -> {
            OnlinePaymentMainWindow1A4.setVisible(false);
        });
        
        paymentDelayed1.setRepeats(false);
        paymentDelayed1.start();
        Timer paymentDelayed2 = new Timer(500, e -> {
           OnlinePayment2ndWindow1A4.setVisible(true); 
        });
        
        paymentDelayed2.setRepeats(false);
        paymentDelayed2.start();
    }//GEN-LAST:event_OnlinePaymentButton1GA8ActionPerformed

    private void OnlineExitButton1A4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlineExitButton1A4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OnlineExitButton1A4ActionPerformed

    private void OnlinePaymentButton2GA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton2GA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OnlinePaymentButton2GA4ActionPerformed

    private void GcashOptionA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GcashOptionA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GcashOptionA4ActionPerformed

    private void PaymayaOptionA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymayaOptionA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymayaOptionA4ActionPerformed

    private void UpdatePriceA1Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePriceA1Button3ActionPerformed
        //Refresh Amount in A4
        PaymentDetailsA4();
    }//GEN-LAST:event_UpdatePriceA1Button3ActionPerformed

    private void ConfirmButtonA1Checkin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonA1Checkin3ActionPerformed
        // Refresh Amount thingsz
        PaymentMethodA4();
    }//GEN-LAST:event_ConfirmButtonA1Checkin3ActionPerformed

    private void RoomSchedNightCheckinA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedNightCheckinA4ActionPerformed
        // room sched night A4
        PaymentDetailsA4();
    }//GEN-LAST:event_RoomSchedNightCheckinA4ActionPerformed

    private void RoomSchedDayCheckinA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomSchedDayCheckinA4ActionPerformed
        // room sched Day A4
        PaymentDetailsA4();
    }//GEN-LAST:event_RoomSchedDayCheckinA4ActionPerformed

    private void PaymentMethodCheckin1A4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin1A4ActionPerformed
        // Payment Method Selection A4
        PaymentCheckInA4();
    }//GEN-LAST:event_PaymentMethodCheckin1A4ActionPerformed

    private void PaymentMethodCheckin2A4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin2A4ActionPerformed
        // Payment Method Selection A4
        PaymentCheckInA4();
    }//GEN-LAST:event_PaymentMethodCheckin2A4ActionPerformed

    private void PaymentMethodCheckin3A4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMethodCheckin3A4ActionPerformed
        // Payment Method Selection A4
        PaymentCheckInA4();
    }//GEN-LAST:event_PaymentMethodCheckin3A4ActionPerformed

    private void CheckInGuestNameA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestNameA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestNameA4ActionPerformed

    private void CheckInGuestAddress1A4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInGuestAddress1A4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInGuestAddress1A4ActionPerformed

    private void TotalAmountCheckinA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAmountCheckinA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountCheckinA4ActionPerformed

    private void MaxDaysCheckinA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxDaysCheckinA4ActionPerformed
        //Max days checkin A4
        if ("".equals(MaxDaysCheckinA4.getText())) {
            JOptionPane.showMessageDialog( new JFrame(), "please input a number.");
        } else {
           try {
               int number = Integer.parseInt(MaxDaysCheckinA4.getText());
               if (number >= 1 && number <= 10) {
                   PaymentDetailsA4();
               } else {
                   JOptionPane.showMessageDialog(new JFrame(), "Please input a number between 1-10.");
               }
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid number.");
               
           }
        }
    }//GEN-LAST:event_MaxDaysCheckinA4ActionPerformed

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
            //turning off panels
            MainPanel1.setVisible(false);
            MenuButtonsPanels.setVisible(false);
            RoomSectionPanel.setVisible(false);
            OnlinePaymentWindow1A4.setVisible(false);
            OnlinePaymentMainWindow1A4.setVisible(false);
            OnlinePaymentWindow2A4.setVisible(false);
            OnlinePaymentMainWindow2A4.setVisible(false);
            //going to checkout Panel
            CheckInPayment.setVisible(true);
            CheckinA1.setVisible(false);
            CheckinA2.setVisible(false);
            CheckinA3.setVisible(false);
            CheckinA4.setVisible(true);
            OnlinePaymentChooseA4.setVisible(false);
            
            //making sure other window is closed/
            InfoWindows.setVisible(false);
            InfoWindowA1.setVisible(false);
            InfoWindowA2.setVisible(false);
            InfoWindowB1.setVisible(false);
            InfoWindowC1.setVisible(false);
            InfoWindowC2.setVisible(false);
            OnlinePaymentChooseA1.setVisible(false);
            
            
        }
    }//GEN-LAST:event_BookButtonB2ActionPerformed

    private void OnlineExitButton1A5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlineExitButton1A5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OnlineExitButton1A5ActionPerformed

    private void OnlinePaymentButton2GA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnlinePaymentButton2GA5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OnlinePaymentButton2GA5ActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccountInfoPanel;
    private javax.swing.JPanel AccountInfoWindow;
    private javax.swing.JLabel AccountNameA1;
    private javax.swing.JLabel AccountNameA10;
    private javax.swing.JLabel AccountNameA11;
    private javax.swing.JLabel AccountNameA12;
    private javax.swing.JLabel AccountNameA13;
    private javax.swing.JLabel AccountNameA14;
    private javax.swing.JLabel AccountNameA15;
    private javax.swing.JLabel AccountNameA16;
    private javax.swing.JLabel AccountNameA17;
    private javax.swing.JLabel AccountNameA18;
    private javax.swing.JLabel AccountNameA2;
    private javax.swing.JLabel AccountNameA3;
    private javax.swing.JLabel AccountNameA4;
    private javax.swing.JLabel AccountNameA5;
    private javax.swing.JLabel AccountNameA6;
    private javax.swing.JLabel AccountNameA7;
    private javax.swing.JLabel AccountNameA8;
    private javax.swing.JLabel AccountNameA9;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JLabel AddressLabel1;
    private javax.swing.JLabel AddressLabel2;
    private javax.swing.JLabel AddressLabel3;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Background1;
    private javax.swing.JLabel Background2;
    private javax.swing.JLabel Background3;
    private javax.swing.JLabel Background4;
    private javax.swing.JLabel Background5;
    private javax.swing.JLabel Background6;
    private javax.swing.JLabel Background7;
    private javax.swing.JLabel Background8;
    private javax.swing.JButton BookButtonA1;
    private javax.swing.JButton BookButtonA2;
    private javax.swing.JButton BookButtonB1;
    private javax.swing.JButton BookButtonB2;
    private javax.swing.JButton BookButtonC1;
    private javax.swing.JButton BookButtonC2;
    private javax.swing.JTextField CheckInGuestAddress1A4;
    private javax.swing.JTextField CheckInGuestAddressA1;
    private javax.swing.JLabel CheckInGuestAddressA10;
    private javax.swing.JLabel CheckInGuestAddressA11;
    private javax.swing.JLabel CheckInGuestAddressA12;
    private javax.swing.JLabel CheckInGuestAddressA13;
    private javax.swing.JLabel CheckInGuestAddressA14;
    private javax.swing.JLabel CheckInGuestAddressA15;
    private javax.swing.JLabel CheckInGuestAddressA16;
    private javax.swing.JLabel CheckInGuestAddressA17;
    private javax.swing.JLabel CheckInGuestAddressA18;
    private javax.swing.JTextField CheckInGuestAddressA2;
    private javax.swing.JLabel CheckInGuestAddressA20;
    private javax.swing.JLabel CheckInGuestAddressA21;
    private javax.swing.JLabel CheckInGuestAddressA22;
    private javax.swing.JLabel CheckInGuestAddressA23;
    private javax.swing.JLabel CheckInGuestAddressA24;
    private javax.swing.JTextField CheckInGuestAddressA3;
    private javax.swing.JLabel CheckInGuestAddressA4;
    private javax.swing.JLabel CheckInGuestAddressA5;
    private javax.swing.JLabel CheckInGuestAddressA6;
    private javax.swing.JLabel CheckInGuestAddressA7;
    private javax.swing.JLabel CheckInGuestAddressA8;
    private javax.swing.JLabel CheckInGuestAddressA9;
    private javax.swing.JTextField CheckInGuestNameA1;
    private javax.swing.JTextField CheckInGuestNameA2;
    private javax.swing.JTextField CheckInGuestNameA3;
    private javax.swing.JTextField CheckInGuestNameA4;
    private javax.swing.JPanel CheckInPayment;
    private javax.swing.JPanel CheckinA1;
    private javax.swing.JPanel CheckinA2;
    private javax.swing.JPanel CheckinA3;
    private javax.swing.JPanel CheckinA4;
    private javax.swing.JLabel CompanyNameLabel;
    private javax.swing.JLabel CompanyTitle;
    private javax.swing.JLabel CompanyTitle1;
    private javax.swing.JButton ConfirmButtonA1Checkin;
    private javax.swing.JButton ConfirmButtonA1Checkin1;
    private javax.swing.JButton ConfirmButtonA1Checkin2;
    private javax.swing.JButton ConfirmButtonA1Checkin3;
    private javax.swing.JButton ContinueButtonLogin;
    private javax.swing.JPanel Decoration1;
    private javax.swing.JLabel DesignCheckin1;
    private javax.swing.JLabel DesignCheckin2;
    private javax.swing.JLabel DesignCheckin3;
    private javax.swing.JLabel DesignCheckin4;
    private javax.swing.JPanel Designnn;
    private javax.swing.JPanel Designnn1;
    private javax.swing.JPanel Designnn2;
    private javax.swing.JPanel Designnn3;
    private javax.swing.JTextField EmailAddressSignUpInput;
    private javax.swing.JButton ExitButtonLogin;
    private javax.swing.JButton ExitInfoButton;
    private javax.swing.JButton ExitLoginButton2;
    private javax.swing.JButton ExitMenuButton;
    private javax.swing.JPanel ExitMessageMainWindow;
    private javax.swing.JPanel ExitMessageWindow;
    private javax.swing.JButton GOSigninWindowButton;
    private javax.swing.JRadioButton GcashOptionA1;
    private javax.swing.JRadioButton GcashOptionA2;
    private javax.swing.JRadioButton GcashOptionA3;
    private javax.swing.JRadioButton GcashOptionA4;
    private javax.swing.JPanel HotelFeaturesPanel;
    private javax.swing.JPanel InfoWindowA1;
    private javax.swing.JPanel InfoWindowA2;
    private javax.swing.JPanel InfoWindowB1;
    private javax.swing.JPanel InfoWindowB2;
    private javax.swing.JPanel InfoWindowC1;
    private javax.swing.JPanel InfoWindowC2;
    private javax.swing.JPanel InfoWindows;
    private javax.swing.JLabel LabelCheckinA1;
    private javax.swing.JLabel LabelCheckinA2;
    private javax.swing.JLabel LabelCheckinA3;
    private javax.swing.JLabel LabelCheckinA4;
    private javax.swing.JLabel LabelCheckinA5;
    private javax.swing.JLabel LabelCheckinA6;
    private javax.swing.JLabel LabelCheckinA7;
    private javax.swing.JLabel LabelCheckinA8;
    private javax.swing.JPanel LoginFormWindow;
    private javax.swing.JPanel LoginSystemPanel;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel MainPanel1;
    private javax.swing.JTextField MaxDaysCheckinA1;
    private javax.swing.JTextField MaxDaysCheckinA2;
    private javax.swing.JTextField MaxDaysCheckinA3;
    private javax.swing.JTextField MaxDaysCheckinA4;
    private javax.swing.JPanel MenuButtonsPanels;
    private javax.swing.JButton MenuOpenButton;
    private javax.swing.JTextField NumberSignUpInput;
    private javax.swing.JButton OnlineExitButton1A1;
    private javax.swing.JButton OnlineExitButton1A2;
    private javax.swing.JButton OnlineExitButton1A3;
    private javax.swing.JButton OnlineExitButton1A4;
    private javax.swing.JButton OnlineExitButton1A5;
    private javax.swing.JPanel OnlinePayment2ndWindow1A1;
    private javax.swing.JPanel OnlinePayment2ndWindow1A2;
    private javax.swing.JPanel OnlinePayment2ndWindow1A3;
    private javax.swing.JPanel OnlinePayment2ndWindow1A4;
    private javax.swing.JPanel OnlinePayment2ndWindow2A1;
    private javax.swing.JPanel OnlinePayment2ndWindow2A2;
    private javax.swing.JPanel OnlinePayment2ndWindow2A3;
    private javax.swing.JPanel OnlinePayment2ndWindow2A4;
    private javax.swing.JPanel OnlinePayment2ndWindow3A1;
    private javax.swing.JButton OnlinePaymentButton1GA1;
    private javax.swing.JButton OnlinePaymentButton1GA2;
    private javax.swing.JButton OnlinePaymentButton1GA3;
    private javax.swing.JButton OnlinePaymentButton1GA4;
    private javax.swing.JButton OnlinePaymentButton1GA5;
    private javax.swing.JButton OnlinePaymentButton1GA6;
    private javax.swing.JButton OnlinePaymentButton1GA7;
    private javax.swing.JButton OnlinePaymentButton1GA8;
    private javax.swing.JButton OnlinePaymentButton2GA1;
    private javax.swing.JButton OnlinePaymentButton2GA2;
    private javax.swing.JButton OnlinePaymentButton2GA3;
    private javax.swing.JButton OnlinePaymentButton2GA4;
    private javax.swing.JButton OnlinePaymentButton2GA5;
    private javax.swing.JPanel OnlinePaymentChooseA1;
    private javax.swing.JPanel OnlinePaymentChooseA2;
    private javax.swing.JPanel OnlinePaymentChooseA3;
    private javax.swing.JPanel OnlinePaymentChooseA4;
    private javax.swing.JPanel OnlinePaymentMainWindow1A1;
    private javax.swing.JPanel OnlinePaymentMainWindow1A2;
    private javax.swing.JPanel OnlinePaymentMainWindow1A3;
    private javax.swing.JPanel OnlinePaymentMainWindow1A4;
    private javax.swing.JPanel OnlinePaymentMainWindow2A1;
    private javax.swing.JPanel OnlinePaymentMainWindow2A2;
    private javax.swing.JPanel OnlinePaymentMainWindow2A3;
    private javax.swing.JPanel OnlinePaymentMainWindow2A4;
    private javax.swing.JPanel OnlinePaymentMainWindow3A1;
    private javax.swing.JPanel OnlinePaymentWindow1A1;
    private javax.swing.JPanel OnlinePaymentWindow1A2;
    private javax.swing.JPanel OnlinePaymentWindow1A3;
    private javax.swing.JPanel OnlinePaymentWindow1A4;
    private javax.swing.JPanel OnlinePaymentWindow2A1;
    private javax.swing.JPanel OnlinePaymentWindow2A2;
    private javax.swing.JPanel OnlinePaymentWindow2A3;
    private javax.swing.JPanel OnlinePaymentWindow2A4;
    private javax.swing.JPanel OnlinePaymentWindow3A1;
    private javax.swing.JPasswordField PasswordSignUpInput;
    private javax.swing.JPasswordField PasswordSigninInput1;
    private javax.swing.JRadioButton PaymayaOptionA1;
    private javax.swing.JRadioButton PaymayaOptionA2;
    private javax.swing.JRadioButton PaymayaOptionA3;
    private javax.swing.JRadioButton PaymayaOptionA4;
    private javax.swing.JRadioButton PaymentMethodCheckin1A1;
    private javax.swing.JRadioButton PaymentMethodCheckin1A2;
    private javax.swing.JRadioButton PaymentMethodCheckin1A3;
    private javax.swing.JRadioButton PaymentMethodCheckin1A4;
    private javax.swing.JRadioButton PaymentMethodCheckin2A1;
    private javax.swing.JRadioButton PaymentMethodCheckin2A2;
    private javax.swing.JRadioButton PaymentMethodCheckin2A3;
    private javax.swing.JRadioButton PaymentMethodCheckin2A4;
    private javax.swing.JRadioButton PaymentMethodCheckin3A1;
    private javax.swing.JRadioButton PaymentMethodCheckin3A2;
    private javax.swing.JRadioButton PaymentMethodCheckin3A3;
    private javax.swing.JRadioButton PaymentMethodCheckin3A4;
    private javax.swing.JLabel PriceTextGcash1A2;
    private javax.swing.JLabel PriceTextGcash1A3;
    private javax.swing.JLabel PriceTextGcash1A4;
    private javax.swing.JLabel PriceTextGcash1A5;
    private javax.swing.JLabel PriceTextGcash2A2;
    private javax.swing.JLabel PriceTextGcashA2;
    private javax.swing.JLabel PriceTextGcashA3;
    private javax.swing.JLabel PriceTextGcashA4;
    private javax.swing.JLabel PriceTextPaymaya1A2;
    private javax.swing.JLabel PriceTextPaymaya1A3;
    private javax.swing.JLabel PriceTextPaymaya1A4;
    private javax.swing.JLabel PriceTextPaymaya1A5;
    private javax.swing.JLabel PriceTextPaymaya1A6;
    private javax.swing.JLabel PriceTextPaymaya2A2;
    private javax.swing.JLabel PriceTextPaymaya2A3;
    private javax.swing.JLabel PriceTextPaymaya2A4;
    private javax.swing.JLabel PriceTextPaymaya2A5;
    private javax.swing.JLabel PriceTextPaymaya2A6;
    private javax.swing.JPanel RegisterFormWindow;
    private javax.swing.JButton RoomA1Button;
    private javax.swing.JButton RoomA1Button1;
    private javax.swing.JPanel RoomA1S;
    private javax.swing.JPanel RoomA2S;
    private javax.swing.JPanel RoomASelectionPanel;
    private javax.swing.JButton RoomB1Button;
    private javax.swing.JButton RoomB1Button1;
    private javax.swing.JPanel RoomB1S;
    private javax.swing.JPanel RoomB1S1;
    private javax.swing.JButton RoomB2Button;
    private javax.swing.JButton RoomB2Button1;
    private javax.swing.JPanel RoomB2S;
    private javax.swing.JPanel RoomB2S1;
    private javax.swing.JPanel RoomBSelectionPanel1;
    private javax.swing.JPanel RoomBSelectionPanel2;
    private javax.swing.JPanel RoomInfoPanel;
    private javax.swing.JLabel RoomPriceA1;
    private javax.swing.JLabel RoomPriceA2;
    private javax.swing.JLabel RoomPriceA3;
    private javax.swing.JLabel RoomPriceA4;
    private javax.swing.JRadioButton RoomSchedDayCheckinA1;
    private javax.swing.JRadioButton RoomSchedDayCheckinA2;
    private javax.swing.JRadioButton RoomSchedDayCheckinA3;
    private javax.swing.JRadioButton RoomSchedDayCheckinA4;
    private javax.swing.JRadioButton RoomSchedNightCheckinA1;
    private javax.swing.JRadioButton RoomSchedNightCheckinA2;
    private javax.swing.JRadioButton RoomSchedNightCheckinA3;
    private javax.swing.JRadioButton RoomSchedNightCheckinA4;
    private javax.swing.JButton RoomSectionButtion;
    private javax.swing.JPanel RoomSectionPanel;
    private javax.swing.JButton SignInButton1;
    private javax.swing.JButton SignInButton2;
    private javax.swing.JButton SignUpButton1;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JTextField TotalAmountA1Checkin;
    private javax.swing.JTextField TotalAmountCheckinA2;
    private javax.swing.JTextField TotalAmountCheckinA3;
    private javax.swing.JTextField TotalAmountCheckinA4;
    private javax.swing.JButton UpdatePriceA1Button;
    private javax.swing.JButton UpdatePriceA1Button1;
    private javax.swing.JButton UpdatePriceA1Button2;
    private javax.swing.JButton UpdatePriceA1Button3;
    private javax.swing.JLabel UserNameGreetings;
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
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
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
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextArea9;
    // End of variables declaration//GEN-END:variables
    
}
