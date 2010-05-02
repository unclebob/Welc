/**
 * + The original program is by Jack Hauber, and the source is
 * "Basic Computer Games." Used with permission of David Ahl;
 * see www.SwapMeetDave.com.
 * + This exercise was inspired by Alan Hensel's use of Amazing
 * as a refactoring challenge.
 * + This transliteration to Java was created by Bill Wake, William.Wake@acm.org
 */
package amazing;
import java.util.Random;

public class Amazing {
    static int target = 0;      // where GOTO goes
    public static Random random = new Random(0);
    static StringBuffer result = new StringBuffer();

    public static void main(String[] args) {
        doit(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        System.out.println(result);
    }

    private static void clear() {
        result.setLength(0);
    }

    private static void println() {
        result.append("\n");
    }

    public static void print(String text) {
        result.append(text);
    }

    public static int rnd(int count) {
        return (int) (count * random.nextFloat()) + 1;
    }

    public static void GOTO(int lineno) {
        target = lineno;
    }

    public static void doit(int horizontal, int vertical) {
        clear();
        print("Amazing - Copyright by Creative Computing, Morristown, NJ");
        println();

        int h = horizontal;
        int v = vertical;
        if (h == 1 || v == 1) return;

        int[][] wArray = new int[h + 1][v + 1];
        for (int i = 0; i <= h; i++) {
            wArray[i] = new int[v + 1];
        }

        int[][] vArray = new int[h + 1][v + 1];
        for (int i = 0; i <= h; i++) {
            vArray[i] = new int[v + 1];
        }

        int q = 0;
        int z = 0;
        int x = rnd(h);

        // 130:170
        for (int i = 1; i <= h; i++) {
            if (i == x)
                print(":  ");
            else
                print(":--");
        }
        // 180
        print(":");
        println();

        // 190
        int c = 1;
        wArray[x][1] = c;
        c++;

        // 200
        int r = x;
        int s = 1;
        GOTO(270);

        while (target != -1) {
            switch (target) {
                case 210:
                    if (r != h)
                        GOTO(250);
                    else
                        GOTO(220);
                    continue;
                case 220:
                    if (s != v)
                        GOTO(240);
                    else
                        GOTO(230);
                    continue;
                case 230:
                    r = 1;
                    s = 1;
                    GOTO(260);
                    continue;
                case 240:
                    r = 1;
                    s++;
                    GOTO(260);
                    continue;
                case 250:
                    r++;
                    GOTO(260);
                    continue;
                case 260:
                    if (wArray[r][s] == 0)
                        GOTO(210);
                    else
                        GOTO(270);
                    continue;
                case 270:
                    if (r - 1 == 0)
                        GOTO(600);
                    else
                        GOTO(280);
                    continue;
                case 280:
                    if (wArray[r - 1][s] != 0)
                        GOTO(600);
                    else
                        GOTO(290);
                    continue;
                case 290:
                    if (s - 1 == 0)
                        GOTO(430);
                    else
                        GOTO(300);
                    continue;
                case 300:
                    if (wArray[r][s - 1] != 0)
                        GOTO(430);
                    else
                        GOTO(310);
                    continue;
                case 310:
                    if (r == h)
                        GOTO(350);
                    else
                        GOTO(320);
                    continue;
                case 320:
                    if (wArray[r + 1][s] != 0)
                        GOTO(350);
                    else
                        GOTO(330);
                    continue;
                case 330:
                    x = rnd(3);
                    GOTO(340);
                    continue;
                case 340:
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(980);
                    else if (x == 3)
                        GOTO(1020);
                    else
                        GOTO(350);
                    continue;
                case 350:
                    if (s != v)
                        GOTO(380);
                    else
                        GOTO(360);
                    continue;
                case 360:
                    if (z == 1)
                        GOTO(410);
                    else
                        GOTO(370);
                    continue;
                case 370:
                    q = 1;
                    GOTO(390);
                    continue;
                case 380:
                    if (wArray[r][s + 1] != 0)
                        GOTO(410);
                    else
                        GOTO(390);
                    continue;
                case 390:
                    x = rnd(3);
                    GOTO(400);
                    continue;
                case 400:
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(980);
                    else if (x == 3)
                        GOTO(1090);
                    else
                        GOTO(410);
                    continue;
                case 410:
                    x = rnd(2);
                    GOTO(420);
                    continue;
                case 420:
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(980);
                    else
                        GOTO(430);
                    continue;
                case 430:
                    if (r == h)
                        GOTO(530);
                    else
                        GOTO(440);
                    continue;
                case 440:
                    if (wArray[r + 1][s] != 0)
                        GOTO(530);
                    else
                        GOTO(450);
                    continue;
                case 450:
                    if (s != v)
                        GOTO(480);
                    else
                        GOTO(460);
                    continue;
                case 460:
                    if (z == 1)
                        GOTO(510);
                    else
                        GOTO(470);
                    continue;
                case 470:
                    q = 1;
                    GOTO(490);
                    continue;
                case 480:
                    if (wArray[r][s + 1] != 0)
                        GOTO(510);
                    else
                        GOTO(490);
                    continue;
                case 490:
                    x = rnd(3);
                    GOTO(500);
                    continue;
                case 500:
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(1020);
                    else if (x == 3)
                        GOTO(1090);
                    else
                        GOTO(510);
                    continue;
                case 510:
                    x = rnd(2);
                    GOTO(520);
                    continue;
                case 520:
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(1020);
                    else
                        GOTO(530);
                    continue;
                case 530:
                    if (s != v)
                        GOTO(560);
                    else
                        GOTO(540);
                    continue;
                case 540:
                    if (z == 1)
                        GOTO(590);
                    else
                        GOTO(550);
                    continue;
                case 550:
                    q = 1;
                    GOTO(570);
                    continue;
                case 560:
                    if (wArray[r][s + 1] != 0)
                        GOTO(590);
                    else
                        GOTO(570);
                    continue;
                case 570:
                    x = rnd(2);
                    GOTO(580);
                    continue;
                case 580:
                    if (x == 1)
                        GOTO(940);
                    else if (x == 2)
                        GOTO(1090);
                    else
                        GOTO(590);
                    continue;
                case 590:
                    GOTO(940);
                    continue;
                case 600:
                    if (s - 1 == 0)
                        GOTO(790);
                    else
                        GOTO(610);
                    continue;
                case 610:
                    if (wArray[r][s - 1] != 0)
                        GOTO(790);
                    else
                        GOTO(620);
                    continue;
                case 620:
                    if (r == h)
                        GOTO(720);
                    else
                        GOTO(630);
                    continue;
                case 630:
                    if (wArray[r + 1][s] != 0)
                        GOTO(720);
                    else
                        GOTO(640);
                    continue;
                case 640:
                    if (s != v)
                        GOTO(670);
                    else
                        GOTO(650);
                    continue;
                case 650:
                    if (z == 1)
                        GOTO(700);
                    else
                        GOTO(660);
                    continue;
                case 660:
                    q = 1;
                    GOTO(680);
                    continue;
                case 670:
                    if (wArray[r][s + 1] != 0)
                        GOTO(700);
                    else
                        GOTO(680);
                    continue;
                case 680:
                    x = rnd(3);
                    GOTO(690);
                    continue;
                case 690:
                    if (x == 1)
                        GOTO(980);
                    else if (x == 2)
                        GOTO(1020);
                    else if (x == 3)
                        GOTO(1090);
                    else
                        GOTO(700);
                    continue;
                case 700:
                    x = rnd(2);
                    GOTO(710);
                    continue;
                case 710:
                    if (x == 1)
                        GOTO(980);
                    else if (x == 2)
                        GOTO(1020);
                    else
                        GOTO(720);
                    continue;
                case 720:
                    if (s != v)
                        GOTO(750);
                    else
                        GOTO(730);
                    continue;
                case 730:
                    if (z == 1)
                        GOTO(780);
                    else
                        GOTO(740);
                    continue;
                case 740:
                    q = 1;
                    GOTO(760);
                    continue;
                case 750:
                    if (wArray[r][s + 1] != 0)
                        GOTO(780);
                    else
                        GOTO(760);
                    continue;
                case 760:
                    x = rnd(2);
                    GOTO(770);
                    continue;
                case 770:
                    if (x == 1)
                        GOTO(980);
                    else if (x == 2)
                        GOTO(1090);
                    else
                        GOTO(780);
                    continue;
                case 780:
                    GOTO(980);
                    continue;
                case 790:
                    if (r == h)
                        GOTO(880);
                    else
                        GOTO(800);
                    continue;
                case 800:
                    if (wArray[r + 1][s] != 0)
                        GOTO(880);
                    else
                        GOTO(810);
                    continue;
                case 810:
                    if (s != v)
                        GOTO(840);
                    else
                        GOTO(820);
                    continue;
                case 820:
                    if (z == 1)
                        GOTO(870);
                    else
                        GOTO(830);
                    continue;
                case 830:
                    q = 1;
                    GOTO(990);
                    continue;
                case 840:
                    if (wArray[r][s + 1] != 0)
                        GOTO(870);
                    else
                        GOTO(850);
                    continue;
                case 850:
                    x = rnd(2);
                    GOTO(860);
                    continue;
                case 860:
                    if (x == 1)
                        GOTO(1020);
                    else if (x == 2)
                        GOTO(1090);
                    else
                        GOTO(870);
                    continue;
                case 870:
                    GOTO(1020);
                    continue;
                case 880:
                    if (s != v)
                        GOTO(910);
                    else
                        GOTO(890);
                    continue;
                case 890:
                    if (z == 1)
                        GOTO(930);
                    else
                        GOTO(900);
                    continue;
                case 900:
                    q = 1;
                    GOTO(920);
                    continue;
                case 910:
                    if (wArray[r][s + 1] != 0)
                        GOTO(930);
                    else
                        GOTO(920);
                    continue;
                case 920:
                    GOTO(1090);
                    continue;
                case 930:
                    GOTO(1190);
                    continue;
                case 940:
                    wArray[r - 1][s] = c;
                    GOTO(950);
                    continue;
                case 950:
                    c++;
                    vArray[r - 1][s] = 2;
                    r--;
                    GOTO(960);
                    continue;
                case 960:
                    if (c == h * v + 1)
                        GOTO(1200);
                    else
                        GOTO(970);
                    continue;
                case 970:
                    q = 0;
                    GOTO(270);
                    continue;
                case 980:
                    wArray[r][s - 1] = c;
                    GOTO(990);
                    continue;
                case 990:
                    c++;
                    GOTO(1000);
                    continue;
                case 1000:
                    vArray[r][s - 1] = 1;
                    s--;
                    if (c == h * v + 1)
                        GOTO(1200);
                    else
                        GOTO(1010);
                    continue;
                case 1010:
                    q = 0;
                    GOTO(270);
                    continue;
                case 1020:
                    wArray[r + 1][s] = c;
                    GOTO(1030);
                    continue;
                case 1030:
                    c++;
                    if (vArray[r][s] == 0)
                        GOTO(1050);
                    else
                        GOTO(1040);
                    continue;
                case 1040:
                    vArray[r][s] = 3;
                    GOTO(1060);
                    continue;
                case 1050:
                    vArray[r][s] = 2;
                    GOTO(1060);
                    continue;
                case 1060:
                    r++;
                    GOTO(1070);
                    continue;
                case 1070:
                    if (c == h * v + 1)
                        GOTO(1200);
                    else
                        GOTO(1080);
                    continue;
                case 1080:
                    GOTO(600);
                    continue;
                case 1090:
                    if (q == 1)
                        GOTO(1150);
                    else
                        GOTO(1100);
                    continue;
                case 1100:
                    wArray[r][s + 1] = c;
                    c++;
                    if (vArray[r][s] == 0)
                        GOTO(1120);
                    else
                        GOTO(1110);
                    continue;
                case 1110:
                    vArray[r][s] = 3;
                    GOTO(1130);
                    continue;
                case 1120:
                    vArray[r][s] = 1;
                    GOTO(1130);
                    continue;
                case 1130:
                    s++;
                    if (c == v * h + 1)
                        GOTO(1200);
                    else
                        GOTO(1140);
                    continue;
                case 1140:
                    GOTO(270);
                    continue;
                case 1150:
                    z = 1;
                    GOTO(1160);
                    continue;
                case 1160:
                    if (vArray[r][s] == 0)
                        GOTO(1180);
                    else
                        GOTO(1170);
                    continue;
                case 1170:
                    vArray[r][s] = 3;
                    q = 0;
                    GOTO(1190);
                    continue;
                case 1180:
                    vArray[r][s] = 1;
                    q = 0;
                    r = 1;
                    s = 1;
                    GOTO(260);
                    continue;
                case 1190:
                    GOTO(210);
                    continue;
                case 1200:
                    target = -1;
                    continue;
            }

        }

        // 1200:
        for (int j = 1; j <= v; j++) {
            print("I");        // 1210

            for (int i = 1; i <= h; i++) {
                if (vArray[i][j] >= 2)
                    print("   ");  // 1240
                else
                    print("  I");  // 1260
            }

            print(" ");   // 1280
            println();

            for (int i = 1; i <= h; i++) {
                if (vArray[i][j] == 0)
                    print(":--");   // 1300, 1340
                else if (vArray[i][j] == 2)
                    print(":--");  // 1310, 1340
                else
                    print(":  "); // 1320
            }

            print(":");    // 1360
            println();
        }
    }
}
