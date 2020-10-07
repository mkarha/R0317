import javax.swing.JFrame;

public class Ikkuna extends JFrame{
	
	private int width;
	private int height;
	
	private String title;
	
	public Ikkuna (int width, int height, String title) {
		this.setSize(width, height);;
		this.width = width;
		this.height = height;
		this.title = title;
		this.setTitle(title);
		this.setLocationRelativeTo(null);
	}
	
	public void nayta() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}
		
	
}
