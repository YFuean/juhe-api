package com.juhe.work2.frame;

import com.juhe.work2.entity.QQTest;
import com.juhe.work2.entity.Today;
import com.juhe.work2.service.AlmService;
import com.juhe.work2.service.TodayService;
import com.juhe.work2.entity.Almanac;
import com.juhe.work2.entity.Dream;
import com.juhe.work2.service.QQTestService;
import com.juhe.work2.service.DreamService;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FortuneTellingFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton almBtn;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel almPanel;
    private JButton todayBtn;
    private JButton dreamBtn;
    private JPanel todayPanel;
    private JPanel dreamPanel;
    private JButton qqBtn;
    private JPanel qqTestPanel;
    private JPanel qqJPanel;
    private JTextField qqTextField;
    private Font font,font1,font3,font4;
    private JButton qqButton;
    //private CardLayout cardLayout;

    public FortuneTellingFrame() {
        CardLayout cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.add("alm", almPanel);
        centerPanel.add("today",todayPanel);
        centerPanel.add("dream",dreamPanel);
        centerPanel.add("qqTest",qqTestPanel);
        cardLayout.show(centerPanel, "today");//默认展示
        LocalDate localDate = LocalDate.now();
        Today today = TodayService.getTod(localDate.toString());
        showToday(today,todayPanel);

        todayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"today");
                Today today = TodayService.getTod(localDate.toString());
                showToday(today,todayPanel);
            }
        });
        almBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "alm");
                List<Almanac> almanacList = AlmService.getAlm(localDate.toString());
                showAlm(almanacList,almPanel);
            }
        });
        dreamBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"dream");
                List<Dream> dreamList = DreamService.getDream("12");
                showDream(dreamList,dreamPanel);
            }
        });
        qqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //qq测吉凶界面
                font = new Font("微软雅黑",Font.PLAIN,20);
                qqTestPanel.setLayout(null);
                JLabel qqLabel = new JLabel("请输入QQ号");
                qqLabel.setFont(font);
                qqLabel.setBounds(180,200,200,50);
                qqTestPanel.add(qqLabel);
                qqTextField = new JTextField();
                qqTextField.setFont(font);
                qqTextField.setBounds(180,260,400,50);
                qqTestPanel.add(qqTextField);
                qqButton = new JButton();
                qqButton.setText("确定");
                qqButton.setFont(font);
                qqButton.setBounds(180,320,200,50);
                qqButton.setForeground(Color.WHITE);
                qqButton.addActionListener(this);
                qqTestPanel.add(qqButton);
                qqJPanel = new JPanel();
                qqJPanel.setBackground(Color.WHITE);
                qqJPanel.setBounds(650,200,600,400);
                qqJPanel.setLayout(null);
                qqTestPanel.add(qqJPanel);
                cardLayout.show(centerPanel,"qqTest");

                qqButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String qq = qqTextField.getText();
                        QQTest qqTest = QQTestService.getQQTest(qq);
                        showQQTest(qqTest,qqJPanel);
                    }
                });
            }
        });
    }
    public void showAlm(List<Almanac> almanacList,JPanel almPanel) {
        almPanel.removeAll();
        font1 = new Font("微软雅黑", Font.PLAIN, 35);
        int length = almanacList.size();
        int row = length % 4 == 0 ? length / 4 : length / 4 + 1;
        GridLayout gridLayout = new GridLayout(row, 4, 40, 30);
        almPanel.setLayout(gridLayout);
        almPanel.setBorder(new EmptyBorder(15, 25, 15, 25));
        for (Almanac almanac : almanacList) {
            JPanel jPanel = new JPanel();
            jPanel.setSize(370, 230);
            jPanel.setBackground(new Color(94, 174, 255));
            jPanel.setLayout(null);
            JPanel smallPanel = new JPanel();
            smallPanel.setBounds(3, 0, 367, 70);
            smallPanel.setBackground(new Color(94, 174, 255));
            GridLayout gridLayout1 = new GridLayout(2, 1, 0, 3);
            smallPanel.setLayout(gridLayout1);
            JLabel hourLabel = new JLabel("时辰：" + almanac.getHours());
            hourLabel.setForeground(Color.WHITE);
            hourLabel.setFont(font);
            smallPanel.add(hourLabel);
            JLabel desLabel = new JLabel("描述：" + almanac.getDes());
            desLabel.setForeground(Color.WHITE);
            desLabel.setFont(font);
            smallPanel.add(desLabel);
            jPanel.add(smallPanel);
            JLabel yijiLabel = new JLabel("宜                忌");
            yijiLabel.setFont(font1);
            yijiLabel.setBounds(3, 77, 367, 35);
            yijiLabel.setForeground(Color.WHITE);
            jPanel.add(yijiLabel);
            JTextArea yiTextArea = new JTextArea(almanac.getYi());
            yiTextArea.setBackground(new Color(94, 174, 255));
            yiTextArea.setEditable(false);
            yiTextArea.setLineWrap(true);
            yiTextArea.setFont(font);
            yiTextArea.setBounds(3, 115, 175, 130);
            yiTextArea.setForeground(Color.WHITE);
            jPanel.add(yiTextArea);
            JTextArea jiTextArea = new JTextArea(almanac.getJi());
            jiTextArea.setBackground(new Color(94, 174, 255));
            jiTextArea.setEditable(false);
            jiTextArea.setLineWrap(true);
            jiTextArea.setFont(font);
            jiTextArea.setBounds(195, 115, 180, 130);
            jiTextArea.setForeground(Color.WHITE);
            jPanel.add(jiTextArea);
            almPanel.add(jPanel);
        }
    }
    public void showToday(Today today,JPanel todayPanel){
        font3 = new Font("微软雅黑",Font.PLAIN,30);
        font4 = new Font("微软雅黑",Font.BOLD,50);
        todayPanel.setLayout(null);
        JPanel tPanel = new JPanel();
        tPanel.setLayout(new GridLayout(5,1,20,0));
        tPanel.setBackground(new Color(111, 183, 255));
        tPanel.setBounds(200,50,600,500);
        tPanel.setBorder(new EmptyBorder(15,25,15,25));
        todayPanel.add(tPanel);
        JLabel yangliLabel = new JLabel("阳历：" + today.getYangli());
        yangliLabel.setFont(font3);
        yangliLabel.setForeground(Color.WHITE);
        tPanel.add(yangliLabel);
        JLabel yinliLabel = new JLabel("阴历：" + today.getYinli());
        yinliLabel.setFont(font3);
        yinliLabel.setForeground(Color.WHITE);
        tPanel.add(yinliLabel);
        JLabel wuxingLabel = new JLabel("五行：" + today.getWuxing());
        wuxingLabel.setFont(font3);
        wuxingLabel.setForeground(Color.WHITE);
        tPanel.add(wuxingLabel);
        JLabel chongshaLabel = new JLabel("冲煞：" + today.getChongsha());
        chongshaLabel.setFont(font3);
        chongshaLabel.setForeground(Color.WHITE);
        tPanel.add(chongshaLabel);
        JLabel baijiLabel = new JLabel("百忌：" + today.getBaiji());
        baijiLabel.setFont(font3);
        baijiLabel.setForeground(Color.WHITE);
        tPanel.add(baijiLabel);
        JLabel yLabel = new JLabel("宜");
        yLabel.setFont(font4);
        yLabel.setForeground(new Color(111, 183, 255));
        yLabel.setBounds(870,50,100,100);
        todayPanel.add(yLabel);
        JTextArea yTextArea = new JTextArea(today.getYi());
        yTextArea.setFont(font3);
        yTextArea.setBackground(new Color(111, 183, 255));
        yTextArea.setForeground(Color.WHITE);
        yTextArea.setBounds(940,50,250,240);
        yTextArea.setEditable(false);
        yTextArea.setLineWrap(true);
        todayPanel.add(yTextArea);
        JLabel jLabel = new JLabel("忌");
        jLabel.setFont(font4);
        jLabel.setForeground(new Color(111, 183, 255));
        jLabel.setBounds(870,300,100,100);
        todayPanel.add(jLabel);
        JTextArea jTextArea = new JTextArea(today.getJi());
        jTextArea.setFont(font3);
        jTextArea.setBackground(new Color(111, 183, 255));
        jTextArea.setForeground(Color.WHITE);
        jTextArea.setBounds(940,300,250,240);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        todayPanel.add(jTextArea);
    }
    public void showQQTest(QQTest qqTest,JPanel qqJPanel){
        qqJPanel.removeAll();
        JTextArea jTextArea1 = new JTextArea("结论：" + qqTest.getConclusion());
        jTextArea1.setBackground(Color.WHITE);
        jTextArea1.setBounds(0,0,600,100);
        jTextArea1.setFont(font);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        qqJPanel.add(jTextArea1);
        JTextArea jTextArea2 = new JTextArea("分析：" + qqTest.getAnalysis());
        jTextArea2.setBackground(Color.WHITE);
        jTextArea2.setBounds(0,130,600,270);
        jTextArea2.setFont(font);
        jTextArea2.setEditable(false);
        jTextArea2.setLineWrap(true);
        qqJPanel.add(jTextArea2);
    }
    public void showDream(List<Dream> dreamList,JPanel dreamPanel){
        dreamPanel.removeAll();
        dreamPanel.setLayout(new BorderLayout());
        Font font = new Font("微软雅黑",Font.BOLD,50);
        dreamPanel.setLayout(new GridLayout(3,3,50,50));
        dreamPanel.setBorder(new EmptyBorder(50,50,50,50));
        dreamPanel.setBackground(Color.WHITE);
        for (Dream dream:dreamList) {
            JPanel jPanel = new JPanel(){
                protected void paintComponent(Graphics g){
                    try{
                        Image bg = ImageIO.read(new File("D:/JavaStudy/juhe-api/src/main" +
                                "/resources/img/classical3.jpg"));
                        g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };
            jPanel.setLayout(null);
            dreamPanel.add(jPanel);
            JLabel typeLabel = new JLabel(dream.getName());
            typeLabel.setFont(font);
            typeLabel.setForeground(Color.BLACK);
            typeLabel.setBounds(150,70,200,50);
            jPanel.add(typeLabel);
        }
    }
    public static void main(String[] args) throws Exception {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("老神棍算命");
        frame.setContentPane(new FortuneTellingFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
