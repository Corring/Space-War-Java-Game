package spacewar;

import spacewar.obj.*;
import spacewar.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameWin extends JFrame {
    // state 0 havent start, 1 gaming, 2 stop, 3, fail, 4 success
    public static int state = 0;

    Image offScreenImage = null;

    int width = 500;
    int height = 500;
    int count = 1;
    int end_x, end_y;
    boolean ended = true;
    public static long gam_start_time;
    long start_time;
    long end_time;
    long times;

    // Background instance
    BgObj obj = new BgObj(GameUtils.bgImg, 0, -3500, 2);

    public PlaneObj planeObj = new PlaneObj(GameUtils.planeImg, 200, 400, 100, 76, 0, this);

    public BossObj bossObj = new BossObj(GameUtils.boss, 250, 35, 64,45, 1,this);

    public void launch() {
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setTitle("space war");

        GameUtils.gameObjList.add(obj);
        GameUtils.gameObjList.add(planeObj);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 1 && state == 0) {
                    gam_start_time =  System.currentTimeMillis();
                    state = 1;
                    repaint();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        while (true) {
            if(state == 1 || state == 3){
                createObj();
                repaint();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // draw the whole picture and then post it into the window
        // back buffer
        // offscreen image will show in the surface after all element painted in there
        if(offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0, width, height);
        switch(state) {
            case 0:
                gImage.drawImage(GameUtils.startBg, 0, 0, null);
                gImage.drawImage(GameUtils.startBtn, 155, 300, null);
                gImage.setColor(Color.white);
                gImage.setFont(new Font("Papyrus", Font.BOLD, 50));
                gImage.drawString("Space War", 120, 200);
                gImage.setColor(Color.white);
                gImage.setFont(new Font("Calibre", Font.BOLD, 10));
                gImage.drawString("Click to start", 225, 370);
                break;
            case 1:
                end_time = System.currentTimeMillis();
                times = (end_time - gam_start_time) / 1000;
                if(times == 2) {
                    GameUtils.gameObjList.add(bossObj);
                    BossObj.appear = true;
                }
                for (int i = 0; i < GameUtils.shellObjList.size(); i++) {
                    GameUtils.gameObjList.get(i).paintSelf(gImage);
                }
                GameUtils.gameObjList.removeAll(GameUtils.removeList);
                GameUtils.shellObjList.removeAll(GameUtils.removeShell);
                GameUtils.enemyObjList.removeAll(GameUtils.removeEnemy);
                break;
            case 2: break;
            case 3:
                end_time = System.currentTimeMillis();
                long tim = 1 - (end_time - start_time) / 1000;
                obj.paintSelf(gImage);
                // the enemy will keep come attack to our side
                for (int i = 0; i < GameUtils.enemyObjList.size(); i++) {
                    GameUtils.enemyObjList.get(i).paintSelf(gImage);
                }
                // get the plane crash spot
                if(ended) {
                    start_time = System.currentTimeMillis();
                    ended = false;
                    end_x = planeObj.getX();
                    end_y = planeObj.getY();
                }
                // boom gif happen one time in the crash spot
                if(tim > 0) {
                    gImage.drawImage(GameUtils.boom,  end_x, end_y, null);
                }
                gImage.setColor(Color.white);
                gImage.setFont(new Font("Papyrus", Font.BOLD, 50));
                gImage.drawString("Game Over", 120, 200);
                g.drawImage(offScreenImage, 0, 0, null);
                break;
            case 4: break;
            default:
        }
        g.drawImage(offScreenImage, 0, 0, null);
        count ++;
    }

    void createObj() {
        if(count % 5 == 0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.bullet1, planeObj.getX() + 47, planeObj.getY() - 16, 9, 16, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        if(count % 30 == 0) {
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemy, (int)( Math.random() * 500), 0, 30, 41, 3, this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
            System.out.println(GameUtils.gameObjList.size());
        }


    }

    public static void main(String[] args) {
        GameWin gamewin = new GameWin();
        gamewin.launch();
    }
}
