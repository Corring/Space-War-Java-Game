package spacewar.utils;

import spacewar.obj.EnemyObj;
import spacewar.obj.GameObj;
import spacewar.obj.ShellObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/space_map1.png");

    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/ship2.png");

    public static Image boss = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");

    public static Image boom = Toolkit.getDefaultToolkit().getImage("imgs/e6.gif");

    public static Image startBg = Toolkit.getDefaultToolkit().getImage("imgs/bg_start.png");

    public static Image startBtn = Toolkit.getDefaultToolkit().getImage("imgs/start_btn_200.png");

    public static Image bullet1 = Toolkit.getDefaultToolkit().getImage("imgs/bullet3-1.png");

    public static Image enemy = Toolkit.getDefaultToolkit().getImage("imgs/enemy1-30.png");

    public static List<GameObj> gameObjList = new ArrayList<>();

    public static List<GameObj> removeList = new ArrayList<>();

    public static List<ShellObj> shellObjList = new ArrayList<>();

    public static List<ShellObj> removeShell = new ArrayList<>();

    public static List<EnemyObj> enemyObjList = new ArrayList<>();

    public static List<EnemyObj> removeEnemy = new ArrayList<>();

}
