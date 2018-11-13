import java.util.Scanner;
import java.util.InputMismatchException;

public class Taller1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner scan_menu = new Scanner(System.in);
		System.out.println("Bienvenido al sistema que encuentra al criminal en tu arreglo");
		
		
		int seleccion_menu = -1;
		
		while(seleccion_menu != 2){
            try{
                desplegarMenu();
                seleccion_menu = scan_menu.nextInt();
            }catch(InputMismatchException ex){
            	System.out.println("No es un número entero");
                System.out.println("Intentelo de nuevo");
                scan_menu.next();
                seleccion_menu = -1;
            }
            switch(seleccion_menu){
                
                case 1:
                    //Cuando se quiere trabajar en la busqueda del criminal
                    Scanner scan_arreglo = new Scanner(System.in);
                    System.out.println("Escriba el tamaño del arreglo a trabajar: ");
                    try{
                        int tamanio_arreglo;
                        tamanio_arreglo = scan_arreglo.nextInt();
                        
                        if(tamanio_arreglo <= 0){
                            System.out.println("No se aceptan arreglos sin datos");
                            break;
                        }
                        int[] arreglo = new int[tamanio_arreglo];
                        int indice = 0;
                        while(indice < arreglo.length){
                        	System.out.println("Ingrese el siguiente dato en la posicion " + indice + ":");
                        	arreglo[indice]= scan_arreglo.nextInt();
                        	indice++;
                        }
                        System.out.println("Ingrese el criminal a buscar: ");
                        int criminal = scan_arreglo.nextInt();
                        
                        if(DivideAndConquer(0, arreglo.length-1, arreglo, criminal)){
                        	System.out.println("En el arreglo ingresado SI se encontro al criminal.");
                        }else{
                        	System.out.println("En el arreglo ingresado NO se encontro al criminal.");
                        }
                        	
                        
                        
                    }catch(InputMismatchException ex){
                        System.out.println("No es un número entero");
                        System.out.println("Intentelo de nuevo");
                        scan_arreglo.next();
                    }                    
                    break;
                
                default:
                    if(seleccion_menu != 2 )
                        System.out.println("Escriba un numero entre las opciones dadas por favor.");                    
                    break;
            }
            
                    
        }
		

	}
	
	public static boolean DivideAndConquer(int low, int high, int[] A, int criminal){
		//Definimos el indice central
		int centro = (low+high)/2;
		//Se encuentra al criminal
		if(A[centro] == criminal){
			return true;
		}
		//NO está en esta parte del arreglo
		if(low == high){
			return false;
		}
		//Buscamos en cada mitad del arreglo
		return (DivideAndConquer(low, centro, A, criminal)||DivideAndConquer(centro+1, high, A, criminal));
		
	}
	
	public static void desplegarMenu(){
		System.out.println("\n");
        System.out.println("...MENU PRINCIPAL...");
        System.out.println("[1] Verificar si hay un criminal en un arreglo.");
        System.out.println("[2] SALIR");
        System.out.println("\n Ingrese una opcion: ");
	}

}
