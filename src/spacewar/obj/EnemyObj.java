package spacewar.obj;

import spacewar.GameWin;
import spacewar.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj {
    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public EnemyObj() {
        super();
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        // enemy and meplane
        if(this.getRec().intersects(this.frame.planeObj.getRec())) {
            GameWin.state = 3;
        }
        // enemy and bullet will be removed from the arraylist after crashed
        for(ShellObj shellObj: GameUtils.shellObjList) {
            if(this.getRec().intersects(shellObj.getRec())) {
//                shellObj.setX(-100);
//                shellObj.setY(-100);
//                this.x = -200;
//                this.y = -200;
                try {
                    GameUtils.removeList.add(shellObj);
                    GameUtils.removeList.add(this);
                    GameUtils.removeShell.add(shellObj);
                    GameUtils.removeEnemy.add(this);
                } finally {

                }
            }
        }

            if(GameUtils.enemyObjList.get(0).y > 700) {
                GameUtils.enemyObjList.remove(0);
                System.out.println(GameUtils.enemyObjList.size());
                GameUtils.removeList.add(this);
            }

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
