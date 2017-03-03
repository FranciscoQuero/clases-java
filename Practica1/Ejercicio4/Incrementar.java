public class Incrementar {
	public static void main(String[] args) {
		int x = 1;
		System.out.println("Antes de la llamada, x vale " + x);
		incrementar(x);
		System.out.println("Tras la llamada, x vale " + x);
	}

	public static void incrementar(int n) {
		n++;
		System.out.println("n dentro del metodo vale " + n);
	}
}