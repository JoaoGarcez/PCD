import java.util.concurrent.BrokenBarrierException;

public class ProcessoLigeiro extends Thread{

	private Barreira barreira;
	
	public ProcessoLigeiro(Barreira barreira) {
		this.barreira = barreira;
	}

	
	@Override
	public void run() {
		
		try {
			sleep((long) (1000 + Math.random() * 4000));
			System.out.println("à espera " + currentThread());
			barreira.await();
			
			System.out.println("Fim " + currentThread());	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
