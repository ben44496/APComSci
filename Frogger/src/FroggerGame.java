import java.awt.*;
import java.util.ArrayList;

public class FroggerGame {


	// what are the things you see in the game?
	Car car = new Car(0,0,200,100,2700,helenCar);
	Tree tree = new Tree(500,500);
	Player player = new Player (100,500);
	ArrayList<Object> drawList = new ArrayList<>();

	public void makeDrawList (){
		drawList.add(car);
		drawList.add(player);
		//drawList.add(tree);
	}
	
	// What do you want to do when a key is hit?
	public void keyHit(String s) {
		System.out.println("In frogger game (keyHit): "+s);
		player.setCurrentImage(s);
		if (s.equals("up")) {
			//System.out.println("up");
			player.rect.y -= player.getStep();
			//player.setCurrentImage(s);
		}
		else if (s.equals("left")){
			//System.out.println("left");
			player.rect.x-=player.getStep();
			//player.setCurrentImage(3);
		}
		else if (s.equals("right")) {
			//System.out.println("right");
			player.rect.x += player.getStep();
			//player.setCurrentImage(1);
		}
		else if (s.equals("down")){
			//System.out.println("down");
			player.rect.y+=player.getStep();
			//player.setCurrentImage(2);
		}



	}

	public void draw(Graphics g){
		player.draw(g);
		car.draw(g);
		car.move(g);
		tree.draw(g);
	}
	
	
	
	
	
	
	
	
}
