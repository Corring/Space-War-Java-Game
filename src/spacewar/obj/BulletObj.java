package spacewar.obj;

import spacewar.GameWin;
import spacewar.utils.GameUtils;

import java.awt.*;

public class BulletObj extends GameObj{
    public BulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        if(BossObj.appear) {
            if(this.getRec().intersects(this.frame.planeObj.getRec())) {
                GameWin.state = 3;
            }
            super.paintSelf(gImage);
            y += speed;
            if (GameUtils.bulletObjList.get(0).y > 700) {
                GameUtils.bulletObjList.remove(0);
                GameUtils.removeList.add(this);
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
