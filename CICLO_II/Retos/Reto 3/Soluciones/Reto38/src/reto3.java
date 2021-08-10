import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class reto3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        Paciente datos[] = new Paciente[100];
        int puntaje[] = new int[100];

        Scanner leer = new Scanner(System.in);

        //System.out.println("Digite el número de pacientes: ");
        n = Integer.parseInt(leer.nextLine());

        for (int i = 0; i < n; i++) {
            String[] linea = leer.nextLine().split("-");
            datos[i] = new Paciente(linea[0], linea[1], linea[2], 
            Double.parseDouble(linea[3]), Double.parseDouble(linea[4]), Double.parseDouble(linea[5]));
        }

        String pacM1 = "", pacM2 = "", pacM3 = "";
        double mM1 = 0, mM2 = 0, mM3 = 0;
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1));
            int ptpp = 0;

            Paciente actual = datos[i];

            ptpp += actual.getPuntajeParcial(1);
            ptpp += actual.getPuntajeParcial(2);
            ptpp += actual.getPuntajeParcial(3);

            

            System.out.println(ptpp);
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
                    System.out.println("Alto");
                    break;
            }

            puntaje[i] = ptpp;
            double m1 = actual.getMuestra1();
            double m2 = actual.getMuestra2();
            double m3 = actual.getMuestra3();
            

            if (m1 >= m2 && m1 >= m3) {
                System.out.println("1");
            }

            if (m2 >= m1 && m2 >= m3) {
                System.out.println("2");
            }

            if (m3 >= m1 && m3 >= m2) {
                System.out.println("3");
            }

            if (m1 > mM1) {
                mM1 = m1;
                pacM1 = actual.getNombre();
            }

            if (m2 > mM2) {
                mM2 = m2;
                pacM2 = actual.getNombre();
            }

            if (m3 > mM3) {
                mM3 = m3;
                pacM3 = actual.getNombre();
            }

        }

        System.out.println(pacM1);
        System.out.println(pacM2);
        System.out.println(pacM3);
    }

}
