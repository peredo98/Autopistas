import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Color;
public class Mapa extends Canvas implements Runnable{

	private Thread thread;
	public boolean running = false;

	public Reloj tiempo;
	private int rate;
	public GrafoAutopista au;

	public Mapa(){
		tiempo = new Reloj();
		au = new GrafoAutopista();
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			running = false;
			thread.join();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int segundos = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta --;
			}
			if (running){
				render();
			frames ++;
			}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				segundos++;
				segundos = segundos * rate;
				tiempo.setSegundo(segundos);
				if(segundos >= 60){
					segundos = 0;
				}
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}
	private void tick(){

	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		BufferedImage img = null;
		try {
  			img = ImageIO.read(new File("mapa_prototipo.png"));
		} 
		catch (IOException e) {
		}
		g.drawImage(img, 0, 0, Ventana.width *3/4, Ventana.height, null);
		
		g.setColor(Color.black);
		
		g.drawString("hora: " + tiempo.toString(), 500, 75);
		
		g.dispose();
		bs.show();
	}

	public void setRate(int rate){
		this.rate = rate;
	}

	public int getRate(){
		return rate;
	}
	
}