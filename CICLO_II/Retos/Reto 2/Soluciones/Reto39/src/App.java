import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        Paciente[] datos = new Paciente[100];
        int puntaje[] = new int[100];

        Scanner leer = new Scanner(System.in);

        //System.out.println("Digite el número de pacientes: ");
        n = Integer.parseInt(leer.nextLine());

        for (int i = 0; i < n; i++) {
            String[] linea = leer.nextLine().split("-");
            datos[i] = new Paciente(linea[0], linea[1], linea[2], 
            Double.parseDouble(linea[3]), Double.parseDouble(linea[4]), 
            Double.parseDouble(linea[5]), Double.parseDouble(linea[6]));
        }
        
        double mM1=1000000;
        String pacM1 = "";
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1));
            int ptpp = datos[i].getPuntaje();
            puntaje[i] = ptpp;

            switch (ptpp) {
                case 0:
                    System.out.println("Sin Riesgo");
                    break;
                case 10:
                    System.out.println("Bajo");
                    break;
                case 20:
                    System.out.println("Medio");
                    break;
                case 30:
                    System.out.println("Medio");
                    break;
                case 40:
                    System.out.println("Alto");
                    break;
            }

            puntaje[i] = ptpp;
            
            System.out.println((datos[i].getMuestra1()+datos[i].getMuestra2())/2);
            System.out.println((datos[i].getMuestra3()+datos[i].getMuestra4())/2); 
            
            if (datos[i].getMuestra1() < mM1) {
                mM1 = datos[i].getMuestra1();
                pacM1 = datos[i].getCedula();
            }
        }
        
        System.out.println(pacM1); 
    }

}
