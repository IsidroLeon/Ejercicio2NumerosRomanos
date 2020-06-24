import java.util.Scanner;
import java.util.InputMismatchException;

public class iLeonNumRom {
		
    	public static void main(String[] args) {
            //array 
            int[] decimal = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romano ={"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            boolean salir = false;
            Scanner s = new Scanner(System.in);
            int opc = 0;
            do
            {
                System.out.println("Que quieres realizar (ingresa el numero de opcion)");
                System.out.println("1 de decimal a romano");                
                System.out.println("2 salir");  
                opc = comproDatoIngresado(s,1,2);
                s.nextLine();//para limpiar scaner
                salir = ejecOpcSel(opc,s, decimal,romano);
            }
            while(!salir);
          } 
          public static boolean ejecOpcSel (int opc, Scanner s, int[] decimal, String[] romano)
          {
              int texto = 0;              
              if (opc ==1)
              {
                  System.out.println("\nIntroduce numero decimal entre 1 y 1000");
                  texto = comproDatoIngresado(s,1,1000);                                    
                  String mensajeTraducido = textAromano(texto,decimal, romano);
                  System.out.println("La conversion es: ");
                  System.out.println(mensajeTraducido+"\n");
              }
              else if (opc == 2)
              {
                  return true;
              }

              return false;

          }
          public static String textAromano(int textoTrad, int[] decimal, String[] romano)
          {
              StringBuilder mensajeTraducido = new StringBuilder();
              int i = 0;
              while (textoTrad > 0 || decimal.length == (i - 1)) 
               {
                   while ((textoTrad - decimal[i]) >= 0) 
                   {
                       textoTrad -= decimal[i];
                       mensajeTraducido.append(romano[i]);
                    }
                    i++;
                }
                return mensajeTraducido.toString();
            }

          public static int comproDatoIngresado(Scanner s, int min, int max)
          {
              int val = 0;
              boolean error = false;
              do 
              {
                  error = false;
                  try
                  {
                      val = s.nextInt();
                      if(!((val>=min) && (val<=max)))
                      {                          
                          System.out.println("digito invalido");
                          System.out.println("Tiene que ser entre"+ min +" y "+ max);
                          error = true;                      
                      }
                      
                  }
                  catch (InputMismatchException e)
                  {
                      System.out.println("la opcion no existe. Se esperaba un numero");
                      error = true;
                      s.nextLine();
                  }
                  catch(Exception e)
                  {
                      System.out.println("error inesperado." + e);
                      error = true;
                  }
              }
              while(error);
              return val;
    }                    
}

  