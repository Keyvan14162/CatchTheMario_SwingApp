
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Keyvan
 */
public final class GameScreen extends javax.swing.JFrame {
    
    private int score = 0;
    private int addScore = 0;
    private int label;
    private int randomLuigi;
    private int randomMushroom;
    private int randomFatMario;
    private int clickCount = 0;
    private int timeDelay  = 1000;
    private int delayControl;
    private int timeControl = 500;
    private int randomWait = 1000;
    private boolean finish = false;
    
    private final String WRONG = "src/resource/sounds/smb_bump.wav";
    private final String COIN = "src/resource/sounds/smb_coin.wav";
    private final String END = "src/resource/sounds/smb_mariodie.wav";
    private final String SOUND1 = "src/resource/sounds/sm64_mario_boing.wav";
    private final String SOUND2 = "src/resource/sounds/sm64_mario_burned.wav";
    private final String SOUND3 = "src/resource/sounds/sm64_mario_doh.wav";
    private final String SOUND4 = "src/resource/sounds/sm64_mario_drowning.wav";
    private final String SOUND5 = "src/resource/sounds/sm64_mario_falling.wav";
    private final String SOUND6 = "src/resource/sounds/sm64_mario_haha.wav";
    private final String SOUND7 = "src/resource/sounds/sm64_mario_hello.wav";
    private final String SOUND8 = "src/resource/sounds/sm64_mario_here_we_go.wav";
    private final String SOUND9 = "src/resource/sounds/sm64_mario_hoo.wav";
    private final String SOUND10 = "src/resource/sounds/sm64_mario_hoohoo.wav";
    private final String SOUND11 = "src/resource/sounds/sm64_mario_hurt.wav";
    private final String SOUND12 = "src/resource/sounds/sm64_mario_its_me.wav";
    private final String SOUND13 = "src/resource/sounds/sm64_mario_lets_go.wav";
    private final String SOUND14 = "src/resource/sounds/sm64_mario_lost_a_life.wav";
    private final String SOUND15 = "src/resource/sounds/sm64_mario_mamma-mia.wav";
    private final String SOUND16 = "src/resource/sounds/sm64_mario_okey-dokey.wav";
    private final String SOUND17 = "src/resource/sounds/sm64_mario_oof.wav";
    private final String SOUND18 = "src/resource/sounds/sm64_mario_pulling_up.wav";
    private final String SOUND19 = "src/resource/sounds/sm64_mario_so_long_bowser.wav";
    private final String SOUND20 = "src/resource/sounds/sm64_mario_thank_you.wav";
    private final String SOUND21 = "src/resource/sounds/sm64_mario_tired.wav";
    private final String SOUND22 = "src/resource/sounds/sm64_mario_ungh.wav";
    private final String SOUND23 = "src/resource/sounds/sm64_mario_waha.wav";
    private final String SOUND24 = "src/resource/sounds/sm64_mario_whoa.wav";
    private final String SOUND25 = "src/resource/sounds/sm64_mario_yahoo.wav";
    private final String SOUND26 = "src/resource/sounds/sm64_mario_yippee.wav";
    
    Icon mario = new ImageIcon("src/resource/icons/marioo.png");
    Icon luigi = new ImageIcon("src/resource/icons/luigii.png");
    Icon mushroom = new ImageIcon("src/resource/icons/mushroomm.png");
    Icon fatmario = new ImageIcon("src/resource/icons/fatmarioo.png");
    Icon star = new ImageIcon("src/resource/icons/starr.png");
    Icon box = new ImageIcon("src/resource/icons/box.png");
    
    private JLabel selectedJLabel ; 
    private Random random = new Random();
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 
    /**
     * Creates new form GameScreen
     */
    public GameScreen() {
        initComponents();
        
        this.setLocation(screenSize.width/2 - this.getSize().width/2 , screenSize.height/2 - this.getSize().height/2);
        boxIconSetter();
        randomSoundPlayer();
        gameplay(mario ,luigi ,mushroom);
    }
    
    
    public void randomSoundPlayer() {
        
        Thread playSoundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!finish) {
                    
                    int sound = random.nextInt(26)+1;
                    
                    if(sound == 1)
                        playSound(SOUND1);
                    if(sound == 2)
                        playSound(SOUND2);
                    if(sound == 3)
                        playSound(SOUND3);
                    if(sound == 4)
                        playSound(SOUND4);
                    if(sound == 5)
                        playSound(SOUND5);
                    if(sound == 6)
                        playSound(SOUND6);
                    if(sound == 7)
                        playSound(SOUND7);
                    if(sound == 8)
                        playSound(SOUND8);
                    if(sound == 9)
                        playSound(SOUND9);
                    if(sound == 10)
                        playSound(SOUND10);
                    if(sound == 11)
                        playSound(SOUND11);
                    if(sound == 12)
                        playSound(SOUND12);
                    if(sound == 13)
                        playSound(SOUND13);
                    if(sound == 14)
                        playSound(SOUND14);
                    if(sound == 15)
                        playSound(SOUND15);
                    if(sound == 16)
                        playSound(SOUND16);
                    if(sound == 17)
                        playSound(SOUND17);
                    if(sound == 18)
                        playSound(SOUND18);
                    if(sound == 19)
                        playSound(SOUND19);
                    if(sound == 20)
                        playSound(SOUND20);
                    if(sound == 21)
                        playSound(SOUND21);
                    if(sound == 22)
                        playSound(SOUND22);
                    if(sound == 23)
                        playSound(SOUND23);
                    if(sound == 24)
                        playSound(SOUND24);
                    if(sound == 25)
                        playSound(SOUND25);
                    if(sound == 26)
                        playSound(SOUND26);
                                
                    try {
                        Thread.sleep(randomWait);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(rootPane, "InterruptedException Thread.sleep()");
                    }
                }
            }
        });
        
        playSoundThread.start();
    }
    
    
    public void playSound(String wav) {
             
        try {
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(wav));
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            clip.start();
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            JOptionPane.showMessageDialog(new GameScreen(), "Cannot Found "+ wav);
        }
    }
  
    
    public void gameplay(Icon mario ,Icon luigi ,Icon mushroom) {
  
        Thread showImgThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while(timeControl >= 0) {
    
                    label = random.nextInt(40) + 1;
                    randomLuigi = random.nextInt(5);
                    randomMushroom = random.nextInt(8);
                    randomFatMario = random.nextInt(18);
                    
                    selectedJLabel = findRandomSelectedLabel(label);
       
                    if(randomLuigi == 3) {
                        selectedJLabel.setIcon(luigi);
                        addScore = 2;
                    } 
                    else if(randomMushroom == 4) {
                        selectedJLabel.setIcon(mushroom);
                        addScore = -5;
                    }                                                  
                    else if(randomFatMario == 6) {
                        selectedJLabel.setIcon(fatmario);
                        addScore = 5;
                    }                  
                    else{
                        selectedJLabel.setIcon(mario);
                        addScore = 1;
                    }
                    
                    try {
                        Thread.sleep(timeDelay);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(rootPane, "InterruptedException Thread.sleep()");
                    }
                    
                    selectedJLabel.setIcon(box);
                }
                finish = true;
                playSound(END);
                afterFinish();
                   
            }
        });
        
        Thread delayControlThread = new Thread(new Runnable() {
            @Override
            public void run() {
        
                while(!finish) {
                    delayControl = jSliderDifficulty.getValue();
                
                    if(delayControl == 0) {
                        timeDelay = 1000;
                        randomWait = 1000;
                    }
                    if(delayControl == 1) {
                        timeDelay = 700;
                        randomWait = 700;
                    }
                    if(delayControl == 2) {
                        timeDelay = 500;
                        randomWait = 500;
                    }
                    if(delayControl == 3) {
                        timeDelay = 500;
                        randomWait = 500;
                        try {
                            int x = random.nextInt(1000);
                            int y = random.nextInt(1500);
                            Robot robot = new Robot();
                            robot.mouseMove(x, y);
                            Thread.sleep(3000);
                        } catch (AWTException ex) {
                            JOptionPane.showMessageDialog(rootPane, "AWTException Thread.sleep()");
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(rootPane, "InterruptedException Thread.sleep()");
                        }
                    }
                    labelDelay.setText("Delay:"+timeDelay+"ms");  
                }
                    
            }
        });
        
        Thread timeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                
                while(timeControl >= 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(rootPane, "InterruptedException Thread.sleep()");
                    }
                    
                    jLabelTimer.setText("Time:"+timeControl);
                    timeControl--;      
                }
            }
        });
  
        showImgThread.start();
        delayControlThread.start();
        timeThread.start();
    }
    
    
    public void afterFinish() {
        JOptionPane.showMessageDialog(this, "CONGRATULATIONS\n"
                + "Score:"+score+"\n"
                        + "ClickCount:"+clickCount);
        
        boolean control = true;
        
        while(control) {
          int input = JOptionPane.showConfirmDialog(this, "Wanna continue?\nYes will be reset your score", "Message", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, star);
        
            if(input == 0) {
                this.dispose();
                GameScreen gameScreen = new GameScreen();
                gameScreen.setVisible(true);     
                control = false;
            }
            else if(input == 1) {
                System.exit(0);
            }
            else {
                input = JOptionPane.showConfirmDialog(this, "Play again?", "Message", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, star);
            }
        } 
        
    }
 
    
    public void scoreClickControl(JLabel jLabel) {       
        if(jLabel.getIcon() == box || jLabel.getIcon() == null) {
            score --;
            playSound(WRONG);
        }
        else {
            score += addScore;
            if(jLabel.getIcon() == mushroom)
                playSound(WRONG);
            else
                playSound(COIN);
        }
        
        clickCount++;
        
        labelScore.setText("Score:"+score);
        labelClickCount.setText("ClickCount:"+clickCount);     
    }
    
    
    public JLabel findRandomSelectedLabel(int label) {
        
        if(label == 1)
            return jLab1;
        if(label == 2)
            return jLab2;
        if(label == 3)
            return jLab3;
        if(label == 4)
            return jLab4;
        if(label == 5)
            return jLab5;
        if(label == 6)
            return jLab6;
        if(label == 7)
            return jLab7;
        if(label == 8)
            return jLab8;
        if(label == 9)
            return jLab9;
        if(label == 10)
            return jLab10;
        if(label == 11)
            return jLab11;
        if(label == 12)
            return jLab12;
        if(label == 13)
            return jLab13;
        if(label == 14)
            return jLab14;
        if(label == 15)
            return jLab15;
        if(label == 16)
            return jLab16;
        if(label == 17)
            return jLab17;
        if(label == 18)
            return jLab18;
        if(label == 19)
            return jLab19;
        if(label == 20)
            return jLab20;
        if(label == 21)
            return jLab21;
        if(label == 22)
            return jLab22;
        if(label == 23)
            return jLab23;
        if(label == 24)
            return jLab24;
        if(label == 25)
            return jLab25;
        if(label == 26)
            return jLab26;
        if(label == 27)
            return jLab27;
        if(label == 28)
            return jLab28;
        if(label == 29)
            return jLab29;
        if(label == 30)
            return jLab30;
        if(label == 31)
            return jLab31;
        if(label == 32)
            return jLab32;
        if(label == 33)
            return jLab33;
        if(label == 34)
            return jLab34;
        if(label == 35)
            return jLab35;
        if(label == 36)
            return jLab36;
        if(label == 37)
            return jLab37;
        if(label == 38)
            return jLab38;
        if(label == 39)
            return jLab39;
        if(label == 40)
            return jLab40;
        
        //not possible
        return jLab20;
    }
    
    public void boxIconSetter() {
        jLab1.setIcon(box);
        jLab2.setIcon(box);
        jLab3.setIcon(box);
        jLab4.setIcon(box);
        jLab5.setIcon(box);
        jLab6.setIcon(box);
        jLab7.setIcon(box);
        jLab8.setIcon(box);
        jLab9.setIcon(box);
        jLab10.setIcon(box);
        jLab11.setIcon(box);
        jLab12.setIcon(box);
        jLab13.setIcon(box);
        jLab14.setIcon(box);
        jLab15.setIcon(box);
        jLab16.setIcon(box);
        jLab17.setIcon(box);
        jLab18.setIcon(box);
        jLab19.setIcon(box);
        jLab20.setIcon(box);
        jLab21.setIcon(box);
        jLab22.setIcon(box);
        jLab23.setIcon(box);
        jLab24.setIcon(box);
        jLab25.setIcon(box);
        jLab26.setIcon(box);
        jLab27.setIcon(box);
        jLab28.setIcon(box);
        jLab29.setIcon(box);
        jLab30.setIcon(box);
        jLab31.setIcon(box);
        jLab32.setIcon(box);
        jLab33.setIcon(box);
        jLab34.setIcon(box);
        jLab35.setIcon(box);
        jLab36.setIcon(box);
        jLab37.setIcon(box);
        jLab38.setIcon(box);
        jLab39.setIcon(box);
        jLab40.setIcon(box);  
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanBackground = new javax.swing.JPanel();
        jPan1 = new javax.swing.JPanel();
        jLab1 = new javax.swing.JLabel();
        jPan9 = new javax.swing.JPanel();
        jLab9 = new javax.swing.JLabel();
        jPan17 = new javax.swing.JPanel();
        jLab17 = new javax.swing.JLabel();
        jPan25 = new javax.swing.JPanel();
        jLab25 = new javax.swing.JLabel();
        jPan33 = new javax.swing.JPanel();
        jLab33 = new javax.swing.JLabel();
        jPan2 = new javax.swing.JPanel();
        jLab2 = new javax.swing.JLabel();
        jPan3 = new javax.swing.JPanel();
        jLab3 = new javax.swing.JLabel();
        jPan4 = new javax.swing.JPanel();
        jLab4 = new javax.swing.JLabel();
        jPan5 = new javax.swing.JPanel();
        jLab5 = new javax.swing.JLabel();
        jPan6 = new javax.swing.JPanel();
        jLab6 = new javax.swing.JLabel();
        jPan7 = new javax.swing.JPanel();
        jLab7 = new javax.swing.JLabel();
        jPan8 = new javax.swing.JPanel();
        jLab8 = new javax.swing.JLabel();
        jPan16 = new javax.swing.JPanel();
        jLab16 = new javax.swing.JLabel();
        jPan15 = new javax.swing.JPanel();
        jLab15 = new javax.swing.JLabel();
        jPan14 = new javax.swing.JPanel();
        jLab14 = new javax.swing.JLabel();
        jPan13 = new javax.swing.JPanel();
        jLab13 = new javax.swing.JLabel();
        jPan12 = new javax.swing.JPanel();
        jLab12 = new javax.swing.JLabel();
        jPan11 = new javax.swing.JPanel();
        jLab11 = new javax.swing.JLabel();
        jPan10 = new javax.swing.JPanel();
        jLab10 = new javax.swing.JLabel();
        jPan18 = new javax.swing.JPanel();
        jLab18 = new javax.swing.JLabel();
        jPan19 = new javax.swing.JPanel();
        jLab19 = new javax.swing.JLabel();
        jPan20 = new javax.swing.JPanel();
        jLab20 = new javax.swing.JLabel();
        jPan21 = new javax.swing.JPanel();
        jLab21 = new javax.swing.JLabel();
        jPan22 = new javax.swing.JPanel();
        jLab22 = new javax.swing.JLabel();
        jPan23 = new javax.swing.JPanel();
        jLab23 = new javax.swing.JLabel();
        jPan24 = new javax.swing.JPanel();
        jLab24 = new javax.swing.JLabel();
        jPan26 = new javax.swing.JPanel();
        jLab26 = new javax.swing.JLabel();
        jPan27 = new javax.swing.JPanel();
        jLab27 = new javax.swing.JLabel();
        jPan28 = new javax.swing.JPanel();
        jLab28 = new javax.swing.JLabel();
        jPan29 = new javax.swing.JPanel();
        jLab29 = new javax.swing.JLabel();
        jPan30 = new javax.swing.JPanel();
        jLab30 = new javax.swing.JLabel();
        jPan31 = new javax.swing.JPanel();
        jLab31 = new javax.swing.JLabel();
        jPan32 = new javax.swing.JPanel();
        jLab32 = new javax.swing.JLabel();
        jPan34 = new javax.swing.JPanel();
        jLab34 = new javax.swing.JLabel();
        jPan35 = new javax.swing.JPanel();
        jLab35 = new javax.swing.JLabel();
        jPan36 = new javax.swing.JPanel();
        jLab36 = new javax.swing.JLabel();
        jPan37 = new javax.swing.JPanel();
        jLab37 = new javax.swing.JLabel();
        jPan38 = new javax.swing.JPanel();
        jLab38 = new javax.swing.JLabel();
        jPan39 = new javax.swing.JPanel();
        jLab39 = new javax.swing.JLabel();
        jPan40 = new javax.swing.JPanel();
        jLab40 = new javax.swing.JLabel();
        labelDelay = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelTimer = new javax.swing.JLabel();
        jButtonFinish = new javax.swing.JButton();
        labelScore = new javax.swing.JLabel();
        labelClickCount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSliderDifficulty = new javax.swing.JSlider();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(100, 100));
        setResizable(false);

        jPanBackground.setBackground(new java.awt.Color(0, 153, 153));
        jPanBackground.setForeground(new java.awt.Color(0, 153, 153));
        jPanBackground.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanBackgroundMousePressed(evt);
            }
        });

        jPan1.setBackground(new java.awt.Color(0, 204, 204));
        jPan1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPan1MouseClicked(evt);
            }
        });

        jLab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan1Layout = new javax.swing.GroupLayout(jPan1);
        jPan1.setLayout(jPan1Layout);
        jPan1Layout.setHorizontalGroup(
            jPan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan1Layout.setVerticalGroup(
            jPan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan9.setBackground(new java.awt.Color(0, 204, 204));
        jPan9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab9MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan9Layout = new javax.swing.GroupLayout(jPan9);
        jPan9.setLayout(jPan9Layout);
        jPan9Layout.setHorizontalGroup(
            jPan9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan9Layout.setVerticalGroup(
            jPan9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan17.setBackground(new java.awt.Color(0, 204, 204));
        jPan17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab17MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan17Layout = new javax.swing.GroupLayout(jPan17);
        jPan17.setLayout(jPan17Layout);
        jPan17Layout.setHorizontalGroup(
            jPan17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan17Layout.setVerticalGroup(
            jPan17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan25.setBackground(new java.awt.Color(0, 204, 204));
        jPan25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab25MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan25Layout = new javax.swing.GroupLayout(jPan25);
        jPan25.setLayout(jPan25Layout);
        jPan25Layout.setHorizontalGroup(
            jPan25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan25Layout.setVerticalGroup(
            jPan25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan33.setBackground(new java.awt.Color(0, 204, 204));
        jPan33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab33MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan33Layout = new javax.swing.GroupLayout(jPan33);
        jPan33.setLayout(jPan33Layout);
        jPan33Layout.setHorizontalGroup(
            jPan33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan33Layout.setVerticalGroup(
            jPan33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan2.setBackground(new java.awt.Color(0, 204, 204));
        jPan2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan2Layout = new javax.swing.GroupLayout(jPan2);
        jPan2.setLayout(jPan2Layout);
        jPan2Layout.setHorizontalGroup(
            jPan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan2Layout.setVerticalGroup(
            jPan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan3.setBackground(new java.awt.Color(0, 204, 204));
        jPan3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan3Layout = new javax.swing.GroupLayout(jPan3);
        jPan3.setLayout(jPan3Layout);
        jPan3Layout.setHorizontalGroup(
            jPan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan3Layout.setVerticalGroup(
            jPan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan4.setBackground(new java.awt.Color(0, 204, 204));
        jPan4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan4Layout = new javax.swing.GroupLayout(jPan4);
        jPan4.setLayout(jPan4Layout);
        jPan4Layout.setHorizontalGroup(
            jPan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan4Layout.setVerticalGroup(
            jPan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan5.setBackground(new java.awt.Color(0, 204, 204));
        jPan5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan5Layout = new javax.swing.GroupLayout(jPan5);
        jPan5.setLayout(jPan5Layout);
        jPan5Layout.setHorizontalGroup(
            jPan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan5Layout.setVerticalGroup(
            jPan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan6.setBackground(new java.awt.Color(0, 204, 204));
        jPan6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan6Layout = new javax.swing.GroupLayout(jPan6);
        jPan6.setLayout(jPan6Layout);
        jPan6Layout.setHorizontalGroup(
            jPan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan6Layout.setVerticalGroup(
            jPan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan7.setBackground(new java.awt.Color(0, 204, 204));
        jPan7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab7MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan7Layout = new javax.swing.GroupLayout(jPan7);
        jPan7.setLayout(jPan7Layout);
        jPan7Layout.setHorizontalGroup(
            jPan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan7Layout.setVerticalGroup(
            jPan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan8.setBackground(new java.awt.Color(0, 204, 204));
        jPan8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan8Layout = new javax.swing.GroupLayout(jPan8);
        jPan8.setLayout(jPan8Layout);
        jPan8Layout.setHorizontalGroup(
            jPan8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan8Layout.setVerticalGroup(
            jPan8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan16.setBackground(new java.awt.Color(0, 204, 204));
        jPan16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab16MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan16Layout = new javax.swing.GroupLayout(jPan16);
        jPan16.setLayout(jPan16Layout);
        jPan16Layout.setHorizontalGroup(
            jPan16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan16Layout.setVerticalGroup(
            jPan16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan15.setBackground(new java.awt.Color(0, 204, 204));
        jPan15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab15MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan15Layout = new javax.swing.GroupLayout(jPan15);
        jPan15.setLayout(jPan15Layout);
        jPan15Layout.setHorizontalGroup(
            jPan15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan15Layout.setVerticalGroup(
            jPan15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan14.setBackground(new java.awt.Color(0, 204, 204));
        jPan14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab14MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan14Layout = new javax.swing.GroupLayout(jPan14);
        jPan14.setLayout(jPan14Layout);
        jPan14Layout.setHorizontalGroup(
            jPan14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan14Layout.setVerticalGroup(
            jPan14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan13.setBackground(new java.awt.Color(0, 204, 204));
        jPan13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab13MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan13Layout = new javax.swing.GroupLayout(jPan13);
        jPan13.setLayout(jPan13Layout);
        jPan13Layout.setHorizontalGroup(
            jPan13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan13Layout.setVerticalGroup(
            jPan13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan12.setBackground(new java.awt.Color(0, 204, 204));
        jPan12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab12MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan12Layout = new javax.swing.GroupLayout(jPan12);
        jPan12.setLayout(jPan12Layout);
        jPan12Layout.setHorizontalGroup(
            jPan12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan12Layout.setVerticalGroup(
            jPan12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan11.setBackground(new java.awt.Color(0, 204, 204));
        jPan11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab11MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan11Layout = new javax.swing.GroupLayout(jPan11);
        jPan11.setLayout(jPan11Layout);
        jPan11Layout.setHorizontalGroup(
            jPan11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan11Layout.setVerticalGroup(
            jPan11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan10.setBackground(new java.awt.Color(0, 204, 204));
        jPan10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan10Layout = new javax.swing.GroupLayout(jPan10);
        jPan10.setLayout(jPan10Layout);
        jPan10Layout.setHorizontalGroup(
            jPan10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan10Layout.setVerticalGroup(
            jPan10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan18.setBackground(new java.awt.Color(0, 204, 204));
        jPan18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab18MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan18Layout = new javax.swing.GroupLayout(jPan18);
        jPan18.setLayout(jPan18Layout);
        jPan18Layout.setHorizontalGroup(
            jPan18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan18Layout.setVerticalGroup(
            jPan18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan19.setBackground(new java.awt.Color(0, 204, 204));
        jPan19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab19MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan19Layout = new javax.swing.GroupLayout(jPan19);
        jPan19.setLayout(jPan19Layout);
        jPan19Layout.setHorizontalGroup(
            jPan19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan19Layout.setVerticalGroup(
            jPan19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan20.setBackground(new java.awt.Color(0, 204, 204));
        jPan20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab20MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan20Layout = new javax.swing.GroupLayout(jPan20);
        jPan20.setLayout(jPan20Layout);
        jPan20Layout.setHorizontalGroup(
            jPan20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan20Layout.setVerticalGroup(
            jPan20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan21.setBackground(new java.awt.Color(0, 204, 204));
        jPan21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab21MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan21Layout = new javax.swing.GroupLayout(jPan21);
        jPan21.setLayout(jPan21Layout);
        jPan21Layout.setHorizontalGroup(
            jPan21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan21Layout.setVerticalGroup(
            jPan21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan22.setBackground(new java.awt.Color(0, 204, 204));
        jPan22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab22MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan22Layout = new javax.swing.GroupLayout(jPan22);
        jPan22.setLayout(jPan22Layout);
        jPan22Layout.setHorizontalGroup(
            jPan22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan22Layout.setVerticalGroup(
            jPan22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan23.setBackground(new java.awt.Color(0, 204, 204));
        jPan23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab23MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan23Layout = new javax.swing.GroupLayout(jPan23);
        jPan23.setLayout(jPan23Layout);
        jPan23Layout.setHorizontalGroup(
            jPan23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan23Layout.setVerticalGroup(
            jPan23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan24.setBackground(new java.awt.Color(0, 204, 204));
        jPan24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab24MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan24Layout = new javax.swing.GroupLayout(jPan24);
        jPan24.setLayout(jPan24Layout);
        jPan24Layout.setHorizontalGroup(
            jPan24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan24Layout.setVerticalGroup(
            jPan24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan26.setBackground(new java.awt.Color(0, 204, 204));
        jPan26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab26MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan26Layout = new javax.swing.GroupLayout(jPan26);
        jPan26.setLayout(jPan26Layout);
        jPan26Layout.setHorizontalGroup(
            jPan26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan26Layout.setVerticalGroup(
            jPan26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan27.setBackground(new java.awt.Color(0, 204, 204));
        jPan27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab27MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan27Layout = new javax.swing.GroupLayout(jPan27);
        jPan27.setLayout(jPan27Layout);
        jPan27Layout.setHorizontalGroup(
            jPan27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan27Layout.setVerticalGroup(
            jPan27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan28.setBackground(new java.awt.Color(0, 204, 204));
        jPan28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab28MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan28Layout = new javax.swing.GroupLayout(jPan28);
        jPan28.setLayout(jPan28Layout);
        jPan28Layout.setHorizontalGroup(
            jPan28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan28Layout.setVerticalGroup(
            jPan28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan29.setBackground(new java.awt.Color(0, 204, 204));
        jPan29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab29MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan29Layout = new javax.swing.GroupLayout(jPan29);
        jPan29.setLayout(jPan29Layout);
        jPan29Layout.setHorizontalGroup(
            jPan29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan29Layout.setVerticalGroup(
            jPan29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan30.setBackground(new java.awt.Color(0, 204, 204));
        jPan30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab30MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan30Layout = new javax.swing.GroupLayout(jPan30);
        jPan30.setLayout(jPan30Layout);
        jPan30Layout.setHorizontalGroup(
            jPan30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan30Layout.setVerticalGroup(
            jPan30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan31.setBackground(new java.awt.Color(0, 204, 204));
        jPan31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab31MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan31Layout = new javax.swing.GroupLayout(jPan31);
        jPan31.setLayout(jPan31Layout);
        jPan31Layout.setHorizontalGroup(
            jPan31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan31Layout.setVerticalGroup(
            jPan31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan32.setBackground(new java.awt.Color(0, 204, 204));
        jPan32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab32MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan32Layout = new javax.swing.GroupLayout(jPan32);
        jPan32.setLayout(jPan32Layout);
        jPan32Layout.setHorizontalGroup(
            jPan32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan32Layout.setVerticalGroup(
            jPan32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan34.setBackground(new java.awt.Color(0, 204, 204));
        jPan34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab34MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan34Layout = new javax.swing.GroupLayout(jPan34);
        jPan34.setLayout(jPan34Layout);
        jPan34Layout.setHorizontalGroup(
            jPan34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan34Layout.setVerticalGroup(
            jPan34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan35.setBackground(new java.awt.Color(0, 204, 204));
        jPan35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab35MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan35Layout = new javax.swing.GroupLayout(jPan35);
        jPan35.setLayout(jPan35Layout);
        jPan35Layout.setHorizontalGroup(
            jPan35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan35Layout.setVerticalGroup(
            jPan35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan36.setBackground(new java.awt.Color(0, 204, 204));
        jPan36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab36MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan36Layout = new javax.swing.GroupLayout(jPan36);
        jPan36.setLayout(jPan36Layout);
        jPan36Layout.setHorizontalGroup(
            jPan36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan36Layout.setVerticalGroup(
            jPan36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan37.setBackground(new java.awt.Color(0, 204, 204));
        jPan37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab37MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan37Layout = new javax.swing.GroupLayout(jPan37);
        jPan37.setLayout(jPan37Layout);
        jPan37Layout.setHorizontalGroup(
            jPan37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan37Layout.setVerticalGroup(
            jPan37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan38.setBackground(new java.awt.Color(0, 204, 204));
        jPan38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab38MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan38Layout = new javax.swing.GroupLayout(jPan38);
        jPan38.setLayout(jPan38Layout);
        jPan38Layout.setHorizontalGroup(
            jPan38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan38Layout.setVerticalGroup(
            jPan38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan39.setBackground(new java.awt.Color(0, 204, 204));
        jPan39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab39MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan39Layout = new javax.swing.GroupLayout(jPan39);
        jPan39.setLayout(jPan39Layout);
        jPan39Layout.setHorizontalGroup(
            jPan39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan39Layout.setVerticalGroup(
            jPan39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPan40.setBackground(new java.awt.Color(0, 204, 204));
        jPan40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLab40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/box.png"))); // NOI18N
        jLab40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLab40MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPan40Layout = new javax.swing.GroupLayout(jPan40);
        jPan40.setLayout(jPan40Layout);
        jPan40Layout.setHorizontalGroup(
            jPan40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPan40Layout.setVerticalGroup(
            jPan40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLab40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        labelDelay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDelay.setText("Delay:1000ms");

        jButtonReset.setBackground(new java.awt.Color(255, 255, 0));
        jButtonReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonReset.setText("RESET");
        jButtonReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 10));
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/starr.png"))); // NOI18N

        jLabelTimer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTimer.setText("Time:");

        jButtonFinish.setBackground(new java.awt.Color(255, 255, 0));
        jButtonFinish.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonFinish.setText("FINISH");
        jButtonFinish.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 10));
        jButtonFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinishActionPerformed(evt);
            }
        });

        labelScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelScore.setText("Score = 0");

        labelClickCount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelClickCount.setText("ClickCount:0");

        jLabel1.setText("Easy           Medium             Hard     Impossible");

        jSliderDifficulty.setBackground(new java.awt.Color(255, 255, 255));
        jSliderDifficulty.setForeground(new java.awt.Color(204, 51, 0));
        jSliderDifficulty.setMaximum(3);
        jSliderDifficulty.setPaintTicks(true);
        jSliderDifficulty.setToolTipText("");
        jSliderDifficulty.setValue(0);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanBackgroundLayout = new javax.swing.GroupLayout(jPanBackground);
        jPanBackground.setLayout(jPanBackgroundLayout);
        jPanBackgroundLayout.setHorizontalGroup(
            jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanBackgroundLayout.createSequentialGroup()
                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPan9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanBackgroundLayout.createSequentialGroup()
                                .addComponent(jPan10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanBackgroundLayout.createSequentialGroup()
                                .addComponent(jPan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPan7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelClickCount, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelScore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSliderDifficulty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDelay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPan16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFinish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanBackgroundLayout.createSequentialGroup()
                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanBackgroundLayout.createSequentialGroup()
                        .addComponent(jPan17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanBackgroundLayout.createSequentialGroup()
                        .addComponent(jPan25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanBackgroundLayout.createSequentialGroup()
                        .addComponent(jPan33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPan40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanBackgroundLayout.setVerticalGroup(
            jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanBackgroundLayout.createSequentialGroup()
                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanBackgroundLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanBackgroundLayout.createSequentialGroup()
                                    .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelDelay))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanBackgroundLayout.createSequentialGroup()
                                    .addComponent(labelScore)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(labelClickCount)))
                            .addComponent(jButtonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFinish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanBackgroundLayout.createSequentialGroup()
                                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPan9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPan17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPan19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPan20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPan24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPan18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPan27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPan28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPan29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPan30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPan31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPan32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPan25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPan26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPan33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPan40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPan1MouseClicked
    }//GEN-LAST:event_jPan1MouseClicked

    private void jLab1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab1MousePressed
    scoreClickControl(jLab1);
    }//GEN-LAST:event_jLab1MousePressed

    private void jLab2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab2MousePressed
    scoreClickControl(jLab2);
    }//GEN-LAST:event_jLab2MousePressed

    private void jLab3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab3MousePressed
    scoreClickControl(jLab3);
    }//GEN-LAST:event_jLab3MousePressed

    private void jLab4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab4MousePressed
    scoreClickControl(jLab4);
    }//GEN-LAST:event_jLab4MousePressed

    private void jLab5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab5MousePressed
    scoreClickControl(jLab5);
    }//GEN-LAST:event_jLab5MousePressed

    private void jLab6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab6MousePressed
    scoreClickControl(jLab6);
    }//GEN-LAST:event_jLab6MousePressed

    private void jLab7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab7MousePressed
    scoreClickControl(jLab7);
    }//GEN-LAST:event_jLab7MousePressed

    private void jLab8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab8MousePressed
    scoreClickControl(jLab8);
    }//GEN-LAST:event_jLab8MousePressed

    private void jLab9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab9MousePressed
    scoreClickControl(jLab9);
    }//GEN-LAST:event_jLab9MousePressed

    private void jLab10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab10MousePressed
    scoreClickControl(jLab10);
    }//GEN-LAST:event_jLab10MousePressed

    private void jLab11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab11MousePressed
    scoreClickControl(jLab11);
    }//GEN-LAST:event_jLab11MousePressed

    private void jLab12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab12MousePressed
    scoreClickControl(jLab12);
    }//GEN-LAST:event_jLab12MousePressed

    private void jLab13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab13MousePressed
    scoreClickControl(jLab13);
    }//GEN-LAST:event_jLab13MousePressed

    private void jLab14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab14MousePressed
    scoreClickControl(jLab14);
    }//GEN-LAST:event_jLab14MousePressed

    private void jLab15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab15MousePressed
    scoreClickControl(jLab15);
    }//GEN-LAST:event_jLab15MousePressed

    private void jLab16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab16MousePressed
    scoreClickControl(jLab16);
    }//GEN-LAST:event_jLab16MousePressed

    private void jLab17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab17MousePressed
    scoreClickControl(jLab17);
    }//GEN-LAST:event_jLab17MousePressed

    private void jLab18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab18MousePressed
    scoreClickControl(jLab18);
    }//GEN-LAST:event_jLab18MousePressed

    private void jLab19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab19MousePressed
    scoreClickControl(jLab19);
    }//GEN-LAST:event_jLab19MousePressed

    private void jLab20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab20MousePressed
    scoreClickControl(jLab20);
    }//GEN-LAST:event_jLab20MousePressed

    private void jLab21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab21MousePressed
    scoreClickControl(jLab21);
    }//GEN-LAST:event_jLab21MousePressed

    private void jLab22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab22MousePressed
    scoreClickControl(jLab22);
    }//GEN-LAST:event_jLab22MousePressed

    private void jLab23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab23MousePressed
    scoreClickControl(jLab23);
    }//GEN-LAST:event_jLab23MousePressed

    private void jLab24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab24MousePressed
    scoreClickControl(jLab24);
    }//GEN-LAST:event_jLab24MousePressed

    private void jLab25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab25MousePressed
    scoreClickControl(jLab25);
    }//GEN-LAST:event_jLab25MousePressed

    private void jLab26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab26MousePressed
    scoreClickControl(jLab26);
    }//GEN-LAST:event_jLab26MousePressed

    private void jLab27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab27MousePressed
    scoreClickControl(jLab27);
    }//GEN-LAST:event_jLab27MousePressed

    private void jLab28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab28MousePressed
    scoreClickControl(jLab28);
    }//GEN-LAST:event_jLab28MousePressed

    private void jLab29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab29MousePressed
    scoreClickControl(jLab29);
    }//GEN-LAST:event_jLab29MousePressed

    private void jLab30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab30MousePressed
    scoreClickControl(jLab30);
    }//GEN-LAST:event_jLab30MousePressed

    private void jLab31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab31MousePressed
    scoreClickControl(jLab31);
    }//GEN-LAST:event_jLab31MousePressed

    private void jLab32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab32MousePressed
    scoreClickControl(jLab32);
    }//GEN-LAST:event_jLab32MousePressed

    private void jLab33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab33MousePressed
    scoreClickControl(jLab33);
    }//GEN-LAST:event_jLab33MousePressed

    private void jLab34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab34MousePressed
    scoreClickControl(jLab34);
    }//GEN-LAST:event_jLab34MousePressed

    private void jLab35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab35MousePressed
    scoreClickControl(jLab35);
    }//GEN-LAST:event_jLab35MousePressed

    private void jLab36MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab36MousePressed
    scoreClickControl(jLab36);
    }//GEN-LAST:event_jLab36MousePressed

    private void jLab37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab37MousePressed
    scoreClickControl(jLab37);
    }//GEN-LAST:event_jLab37MousePressed

    private void jLab38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab38MousePressed
    scoreClickControl(jLab38);
    }//GEN-LAST:event_jLab38MousePressed

    private void jLab39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab39MousePressed
    scoreClickControl(jLab39);
    }//GEN-LAST:event_jLab39MousePressed

    private void jLab40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLab40MousePressed
    scoreClickControl(jLab40);
    }//GEN-LAST:event_jLab40MousePressed

    private void jPanBackgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanBackgroundMousePressed
    clickCount++;
    }//GEN-LAST:event_jPanBackgroundMousePressed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
    clickCount = 0 ;
    score = 0 ;
    jSliderDifficulty.setValue(0);
    timeDelay  = 1000;
    timeControl = 500;
    randomWait = 1000;
    labelScore.setText("Score:"+score);
    labelClickCount.setText("ClickCount:"+clickCount);
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinishActionPerformed
    timeControl = 3;
    }//GEN-LAST:event_jButtonFinishActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFinish;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLab1;
    private javax.swing.JLabel jLab10;
    private javax.swing.JLabel jLab11;
    private javax.swing.JLabel jLab12;
    private javax.swing.JLabel jLab13;
    private javax.swing.JLabel jLab14;
    private javax.swing.JLabel jLab15;
    private javax.swing.JLabel jLab16;
    private javax.swing.JLabel jLab17;
    private javax.swing.JLabel jLab18;
    private javax.swing.JLabel jLab19;
    private javax.swing.JLabel jLab2;
    private javax.swing.JLabel jLab20;
    private javax.swing.JLabel jLab21;
    private javax.swing.JLabel jLab22;
    private javax.swing.JLabel jLab23;
    private javax.swing.JLabel jLab24;
    private javax.swing.JLabel jLab25;
    private javax.swing.JLabel jLab26;
    private javax.swing.JLabel jLab27;
    private javax.swing.JLabel jLab28;
    private javax.swing.JLabel jLab29;
    private javax.swing.JLabel jLab3;
    private javax.swing.JLabel jLab30;
    private javax.swing.JLabel jLab31;
    private javax.swing.JLabel jLab32;
    private javax.swing.JLabel jLab33;
    private javax.swing.JLabel jLab34;
    private javax.swing.JLabel jLab35;
    private javax.swing.JLabel jLab36;
    private javax.swing.JLabel jLab37;
    private javax.swing.JLabel jLab38;
    private javax.swing.JLabel jLab39;
    private javax.swing.JLabel jLab4;
    private javax.swing.JLabel jLab40;
    private javax.swing.JLabel jLab5;
    private javax.swing.JLabel jLab6;
    private javax.swing.JLabel jLab7;
    private javax.swing.JLabel jLab8;
    private javax.swing.JLabel jLab9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTimer;
    private javax.swing.JPanel jPan1;
    private javax.swing.JPanel jPan10;
    private javax.swing.JPanel jPan11;
    private javax.swing.JPanel jPan12;
    private javax.swing.JPanel jPan13;
    private javax.swing.JPanel jPan14;
    private javax.swing.JPanel jPan15;
    private javax.swing.JPanel jPan16;
    private javax.swing.JPanel jPan17;
    private javax.swing.JPanel jPan18;
    private javax.swing.JPanel jPan19;
    private javax.swing.JPanel jPan2;
    private javax.swing.JPanel jPan20;
    private javax.swing.JPanel jPan21;
    private javax.swing.JPanel jPan22;
    private javax.swing.JPanel jPan23;
    private javax.swing.JPanel jPan24;
    private javax.swing.JPanel jPan25;
    private javax.swing.JPanel jPan26;
    private javax.swing.JPanel jPan27;
    private javax.swing.JPanel jPan28;
    private javax.swing.JPanel jPan29;
    private javax.swing.JPanel jPan3;
    private javax.swing.JPanel jPan30;
    private javax.swing.JPanel jPan31;
    private javax.swing.JPanel jPan32;
    private javax.swing.JPanel jPan33;
    private javax.swing.JPanel jPan34;
    private javax.swing.JPanel jPan35;
    private javax.swing.JPanel jPan36;
    private javax.swing.JPanel jPan37;
    private javax.swing.JPanel jPan38;
    private javax.swing.JPanel jPan39;
    private javax.swing.JPanel jPan4;
    private javax.swing.JPanel jPan40;
    private javax.swing.JPanel jPan5;
    private javax.swing.JPanel jPan6;
    private javax.swing.JPanel jPan7;
    private javax.swing.JPanel jPan8;
    private javax.swing.JPanel jPan9;
    private javax.swing.JPanel jPanBackground;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSliderDifficulty;
    private javax.swing.JLabel labelClickCount;
    private javax.swing.JLabel labelDelay;
    private javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables

}