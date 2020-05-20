// this class is for displaying a kind of a loading bar 
public class Loading extends Thread {
	public Loading(String nom) {
		super(nom);
	}
	public void run() {
		System.out.println( "\t\t"+this.getName());
		for(int i=0;i<5;i++) {
			System.out.print("\t.");
			try {
				sleep(2000);
			}catch(InterruptedException e) {}
	}

}
}
