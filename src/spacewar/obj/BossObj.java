package spacewar.obj;

import spacewar.GameWin;
import spacewar.utils.GameUtils;

import java.awt.*;

public class BossObj extends GameObj {
    int health = 1000;
    public static boolean appear = false;

    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(appear) {
            for(ShellObj shellObj: GameUtils.shellObjList) {
                if(this.getRec().intersects(shellObj.getRec())) {
                    health --;
                    try {
                        GameUtils.removeList.add(shellObj);
                    } finally {

                    }
                }
                if(health == 0) {
                    GameUtils.removeList.add(this);
                    GameWin.state = 4;
                }
            }
            if(x > 550 || x < -50) {
                speed = -speed;
            }
            x += speed;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
