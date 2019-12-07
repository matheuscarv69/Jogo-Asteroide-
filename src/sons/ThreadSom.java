/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sons;

/**
 *
 * @author mathe
 */
import java.io.InputStream;
import javazoom.jl.player.Player;

public class ThreadSom extends Thread {

    @Override
    public void run() {
        try {
            InputStream file = getClass().getResourceAsStream("somBackground.mp3");
            Player playMp3 = new Player(file);
            playMp3.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void somTiroDisp() {
        new Thread() {
            @Override
            public void run() {
                try {
                    InputStream file = getClass().getResourceAsStream("tiro.mp3");
                    Player tiroDisp = new Player(file);
                    tiroDisp.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void somTiroAst() {
        new Thread() {
            @Override
            public void run() {
                try {
                    InputStream file = getClass().getResourceAsStream("tiroAst.mp3");
                    Player playMp3 = new Player(file);
                    playMp3.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }.start();

    }

    public void somExpNave() {
        new Thread() {
            @Override
            public void run() {
                try {
                    InputStream file = getClass().getResourceAsStream("explosaoNave.mp3");
                    Player playMp3 = new Player(file);
                    playMp3.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }.start();

    }

    public void gameOver() {
        new Thread() {
            @Override
            public void run() {
                try {
                    InputStream file = getClass().getResourceAsStream("gameOver.mp3");
                    Player playMp3 = new Player(file);
                    playMp3.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }.start();
    }
    
    public void levelComplete() {
        new Thread() {
            @Override
            public void run() {
                try {
                    InputStream file = getClass().getResourceAsStream("levelComplete.mp3");
                    Player playMp3 = new Player(file);
                    playMp3.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }.start();
    }
}
