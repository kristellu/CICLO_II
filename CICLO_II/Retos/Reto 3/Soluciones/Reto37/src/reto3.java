import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class reto3 {

    /**jjj
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
        
        String nomM="";
        double creM=-1000;

        for (int i = 0; i < n; i++) {
            System.out.println((i+1));
            int ptpp = 0, numMPD=0; 
            String numM="";

            Paciente pacActual = datos[i];
            
            if (pacActual.getGenero().equals("M")) {
                //Masculino
                if(pacActual.getMuestra1() < 0.74){
                    numMPD++;
                    numM+="1";
                }
            } else {
                //Femenino
                if(pacActual.getMuestra1() < 0.59){
                    numMPD++;
                    numM+="1";
                }
            }

            double m2 = pacActual.getMuestra2();
            if (pacActual.getGenero().equals("M")) {
                //Masculino
                if(m2 < 0.74){
                    numMPD++;
                    numM+=" 2";
                }
            } else {
                //Femenino
                if(m2 < 0.59){
                    numMPD++;
                    numM+=" 2";
                }
            }

            double m3 = pacActual.getMuestra3();
            if (pacActual.getGenero().equals("M")) {
                //Masculino
                if(m3 < 14){
                    numMPD++;
                    numM+=" 3";
                }
            } else {
                //Femenino
                if(m3 < 11){
                    numMPD++;
                    numM+=" 3";
                }
            }
            
            if(m3 > creM){
                creM = m3;
                nomM = pacActual.getNombre();
            }
            
            ptpp = pacActual.getPuntaje();
            System.out.println(ptpp);
            puntaje[i] = ptpp;
            
            switch (ptpp) {
                case 0:
                    System.out.println("Sin Riesgo");
                    break;
                case 5:
                    System.out.println("Bajo");
                    break;
                case 10:
                    System.out.println("Medio");
                    break;
                case 15:
                    System.out.println("Alto");
                    break;
            }
            
            puntaje[i] = ptpp;
            System.out.println(numMPD);
            System.out.println(numM);
            
        }
        System.out.println(nomM);
    }

}
