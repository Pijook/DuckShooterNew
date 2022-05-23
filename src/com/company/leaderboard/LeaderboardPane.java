package com.company.leaderboard;

import com.company.Assets;
import com.company.Frame;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeaderboardPane extends JPanel {

    private JList<PlayerScore> playerScoreJList;
    private JScrollPane jScrollPane;
    private LeaderboardModel leaderboardModel;
    private JButton returnButton;

    public LeaderboardPane(){
        createElements();
        createLayout();
    }

    private void createElements(){
        /*
            Leaderboard model
         */
        leaderboardModel = new LeaderboardModel();

        /*
            PlayerScore list
         */

        playerScoreJList = new JList<>();
        playerScoreJList.setModel(leaderboardModel);
        playerScoreJList.setOpaque(false);
        playerScoreJList.setBackground(new Color(0,0,0,0));
        playerScoreJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayerScore playerScore = playerScoreJList.getModel().getElementAt(playerScoreJList.locationToIndex(e.getPoint()));

                JLabel jLabel = new JLabel("<html>Nickname: " + playerScore.nickname() +
                        "<br>Score: " + playerScore.score() +
                        "<br>Time: " + playerScore.time() +
                        "<br>Ammo upgrade: " + playerScore.reloadUpgrade() +
                        "<br>Damage upgrade: " + playerScore.damageUpgrade() +
                        "</html>");

                jLabel.setFont(Assets.rainyHeartsFont);

                JOptionPane.showMessageDialog(null, jLabel);
            }
        });
        setUpCellRenderer();

        /*
            Scrolling pane
         */
        jScrollPane = new JScrollPane(playerScoreJList);

        /*
            Return button
         */
        returnButton = new JButton();
        returnButton.setText("Return");
        returnButton.setFont(Assets.rainyHeartsFont.deriveFont(36f));
        returnButton.setIcon(Assets.greenButtonImage);
        returnButton.setHorizontalTextPosition(SwingUtilities.HORIZONTAL);
        returnButton.setContentAreaFilled(false);
        returnButton.setBorder(BorderFactory.createEmptyBorder());
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getGameFrame().getCardLayout().show(Main.getGameFrame().getMainPane(), Frame.MAIN_MENU.name());
            }
        });
    }

    private void createLayout(){
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /*
            Overall settings
         */
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.ipadx = 100;

        /*
            Scrolling pane
         */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(jScrollPane, gridBagConstraints);

        /*
            Return button
         */
        gridBagConstraints.insets = new Insets(25, 0, 0, 0);
        gridBagConstraints.gridy = 1;
        add(returnButton, gridBagConstraints);
    }

    private void setUpCellRenderer() {
        playerScoreJList.setCellRenderer(new ListCellRenderer<PlayerScore>() {

            final PlayerScoreView playerScoreView = new PlayerScoreView();

            @Override
            public Component getListCellRendererComponent(JList<? extends PlayerScore> list, PlayerScore value, int index, boolean isSelected, boolean cellHasFocus) {
                if(value != null){
                    playerScoreView.setPlayerScore(value);
                }
                return playerScoreView;
            }
        });
    }

    public void updateList(){
        setUpCellRenderer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image image = Assets.backgroundImage.getImage();
        g.drawImage(image, 0,0,this);
    }

    public JList<PlayerScore> getPlayerScoreJList() {
        return playerScoreJList;
    }

    public LeaderboardModel getLeaderboardModel() {
        return leaderboardModel;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}
