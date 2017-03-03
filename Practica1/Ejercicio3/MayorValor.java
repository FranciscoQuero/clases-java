class MayorValor{
	public static void main(String args[]){
		int mayor;
		int a=30, b=20;
		mayor = max(50, 90);
		System.out.println("El valor mayor entre 50 y 90 es: " + mayor);
		mayor = max(a, b);
		System.out.printf("El mayor entre %d y %d es: %d\n", a, b, mayor);
	}
	public static int max(int num1, int num2){
		int resultado;
		if(num1>num2)
			resultado = num1;
		else
			resultado = num2;
		return resultado;
	}
}