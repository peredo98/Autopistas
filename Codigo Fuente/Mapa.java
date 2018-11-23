import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Color;
import java.util.LinkedList;

public class Mapa extends Canvas implements Runnable{

	private Thread thread;
	public boolean running = false;

	public Reloj tiempo;
	private int rate;
	public GrafoAutopista au;

	public LinkedList<Auto> autos;

	public Mapa(){
		tiempo = new Reloj();
		au = new GrafoAutopista();
		autos = new LinkedList();
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

		g.drawString("Fecha: " + tiempo.getFecha().toString(), 500, 50);
		g.drawString("hora: " + tiempo.toString(), 500, 75);

		g.setColor(Color.red);

		for (Auto a: autos) {
			g.fillOval(a.getX(), a.getY(), 5, 5);

			try{
				a.move();
			}catch(IndexOutOfBoundsException e){
				Recorrido r = new Recorrido(a.getId(), a.getSalida().getNombre() + " (Salida)", a.getHora().toString(), a.getHora().getFecha().toString());
				Registro.registro.add(r);
				Registro.area1.append(r.getId()+"\n");
				Registro.area2.append(r.getLugar()+"\n");
				Registro.area3.append(r.getHora()+"\n");
				Registro.area4.append(r.getFecha()+"\n");
				removeAuto(a);
				break;
			}
		}

		g.dispose();
		bs.show();
	}

	public void setRate(int rate){
		this.rate = rate;
	}

	public int getRate(){
		return rate;
	}

	public void addAuto(Auto auto){
		autos.addFirst(auto);
	}

	public void removeAuto(Auto auto){
		autos.remove(auto);
	}

}
