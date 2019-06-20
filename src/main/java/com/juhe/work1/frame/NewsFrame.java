package com.juhe.work1.frame;

import com.juhe.work1.service.NewsService;
import com.juhe.work1.entity.News;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class NewsFrame {
    private JPanel mainPanel;
    private JButton topBtn;
    private JButton sportsBtn;
    private JButton fashionBtn;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JPanel fashionPanel;
    private JPanel sportsPanel;

    public NewsFrame() {
        CardLayout cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.add("top", topPanel);
        centerPanel.add("sports", sportsPanel);
        centerPanel.add("fashion", fashionPanel);
        List<News> newsList = NewsService.getNews("top");
        showData(newsList,topPanel);
        cardLayout.show(centerPanel, "top");
        topBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<News> newsList = NewsService.getNews("top");
                showData(newsList,topPanel);
                cardLayout.show(centerPanel, "top");

            }
        });
        sportsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "sports");
                List<News> newsList = NewsService.getNews("tiyu");
                showData(newsList,sportsPanel);
            }
        });
        fashionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "fashion");
                List<News> newsList = NewsService.getNews("shishang");
                showData(newsList,fashionPanel);
            }
        });
    }

    public void showData(List<News> newsList,JPanel contentPanel){
        contentPanel.removeAll();
        int length = newsList.size();
        int row = length % 6 == 0 ? length / 6 : length / 6 + 1;
        GridLayout gridLayout = new GridLayout(row, 6, 15, 20);
        contentPanel.setLayout(gridLayout);
        for (News news : newsList) {
            JPanel jPanel = new JPanel();
            JLabel imgLabel = new JLabel();
            imgLabel.setText("<html><img src='" + news.getThumbnailPicS() + "' /></html>");
            JLabel titleLabel = new JLabel(news.getTitle());
            jPanel.add(imgLabel);
            jPanel.add(titleLabel);
            jPanel.setPreferredSize(new Dimension(200, 220));
            contentPanel.add(jPanel);
        }
    }

    public static void main(String[] args) throws Exception {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("NewsFrame");
        frame.setContentPane(new NewsFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
