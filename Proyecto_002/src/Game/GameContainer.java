package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Interfaces.IDieable;
import Interfaces.IDrawable;
import Interfaces.IMovable;

public class GameContainer {
    private static final int HEIGHT = 600;
    private List<IDrawable> drawables; 
    private List<IMovable> movables;
    private List<Bullet> bullets;
    private static final int PLAYER_TOP_LIMIT = 2 * HEIGHT / 3 + 21; 
    private static final int LINE_Y_POSITION = 2 * HEIGHT / 3; 

    private boolean gameOver = false; 

    private static final int ENEMY_DAMAGE = 25;
    private Hero hero;
    private int enemyMoveDelay = 500; 
    private long lastEnemyMoveTime = 0;

    public GameContainer() {
        drawables = new ArrayList<>();
        movables = new ArrayList<>();
        bullets = new ArrayList<>();
        
        hero = new Hero(400, 450, 50, 25, "Walker77", this); 
        addDrawable(hero);
        addMovable(hero);
        
        createEnemies();
    }
    
    private void createEnemies() {
        int enemyWidth = 50;
        int enemyHeight = 50;
        int startX = 50; 
        int startY = 50;
        int gapX = 100;
        int numEnemies = 7;
        
        for (int i = 0; i < numEnemies; i++) {
            Enemy enemy = new Enemy(startX + i * gapX, startY, enemyWidth, enemyHeight,25);
            addDrawable(enemy);
            addMovable(enemy);
        }
    }

    public void addDrawable(IDrawable drawable) {
        drawables.add(drawable);
    }

    public void addMovable(IMovable movable) {
        movables.add(movable);
    }

    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    public void update() {
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            bullet.move(0, -bullet.getSpeed());
            if (bullet.getY() == HEIGHT) { 
                bulletIterator.remove();
            } else {
                for (IDrawable drawable : drawables) {
                    if (drawable instanceof Enemy) {
                        Enemy enemy = (Enemy) drawable;
                        Rectangle bulletRect = new Rectangle(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
                        Rectangle enemyRect = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
                        if (bulletRect.intersects(enemyRect)) {
                            bulletIterator.remove(); 
                            enemy.die(); 
                            hero.increaseScore(25); // Incrementar el puntaje del héroe
                            break; 
                        }
                    }
                }
            }
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastEnemyMoveTime > enemyMoveDelay) {
            moveEnemiesDown();
            lastEnemyMoveTime = currentTime;
        }
     // Comprobar si un enemigo ha pasado la línea
        for (IMovable movable : movables) {
            if (movable instanceof Enemy) {
                Enemy enemy = (Enemy) movable;
                if (enemy.getY() >= LINE_Y_POSITION) {
                    // Reducir la salud del jugador cuando un enemigo pasa la línea
                    hero.decreaseHealth(ENEMY_DAMAGE);
                }
            }
        }

        // Comprobar si el jugador ha perdido todas sus vidas
        if (hero.getCurrentHealth() <= 0) {
            // Establecer el indicador de fin de juego
            gameOver = true;
        }

        for (IMovable movable : movables) {
            movable.move(0, 0); 
        }
        
        
        Iterator<IDrawable> drawableIterator = drawables.iterator();
        while (drawableIterator.hasNext()) {
            IDrawable drawable = drawableIterator.next();
            if (drawable instanceof IDieable) {
                IDieable dieable = (IDieable) drawable;
                if (dieable.isDead()) {
                    drawableIterator.remove();
                }
            }
        }
    }

    public void draw(Graphics g) {
    	Line line = new Line(0, LINE_Y_POSITION, 800, LINE_Y_POSITION);
        line.draw(g);
        int barWidth = 100;
        int barHeight = 10;
        int barX = 10;
        int barY = 60;
        double healthPercentage = (double) hero.getCurrentHealth() / hero.getMaxHealth();
        for (IDrawable drawable : drawables) {
            drawable.draw(g);
        }
     // Dibujar el contorno de la barra de vida
        g.setColor(Color.BLACK);
        g.drawRect(barX, barY, barWidth, barHeight);

        // Dibujar el interior de la barra de vida
        g.setColor(Color.RED);
        g.fillRect(barX, barY, (int) (barWidth * healthPercentage), barHeight);

        // Mostrar "Game Over" si el juego ha terminado
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("GAME OVER", 300, 300);
        }
    }

    private void moveEnemiesDown() {
        for (IMovable movable : movables) {
            if (movable instanceof Enemy) {
                movable.move(0, 10); 
            }
        }
    }

    public void heroShoot() {
        int heroX = hero.getX();
        int heroY = hero.getY();

        Bullet bullet = new Bullet((heroX + hero.getWidth() / 2)-27, heroY - 15, 5, 10, 10);
        addBullet(bullet);

        addDrawable(bullet);
    }

    public void moveHero(int dx, int dy) {
        if (hero != null) {
            int newX = hero.getX() + dx;
            int newY = hero.getY() + dy;

            // Comprobar si el movimiento del jugador está dentro de los límites
            int playerBottom = newY + hero.getHeight();
            if (newX >= 0 && newX + hero.getWidth() <= 800 && newY >= 0 && playerBottom <= HEIGHT && newY >= PLAYER_TOP_LIMIT) {
                hero.move(dx, dy);
            }
        }
    }
}
