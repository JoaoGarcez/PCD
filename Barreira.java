
public class Barreira {

	private int num_threads;
	private int passed_threads;
	
	public Barreira(int num_threads) {
		passed_threads= 0;
		this.num_threads=num_threads;
	}
	
	public synchronized void await() throws InterruptedException{
		while(passed_threads < num_threads) {
			passed_threads++;
			if(passed_threads== num_threads) {
				break;
			}
				
			wait();
		}
		
		notifyAll();
	}
	
	
	public static void main(String[] args) {
		
		Barreira b = new Barreira(5);
		
		ProcessoLigeiro[] processos = new ProcessoLigeiro[5];
		
		for(ProcessoLigeiro p : processos) {
			p = new ProcessoLigeiro(b);
			p.start();
		}

	}

}
