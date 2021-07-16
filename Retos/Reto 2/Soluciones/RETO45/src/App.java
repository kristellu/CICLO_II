import java.util.Scanner;

public class App {

    public static boolean buscarElem(String[] vec, String elem) {
        boolean res = false;
        for (int  i = 0; i  < vec.length; i ++) {
            if (elem.equals(vec[i])) {
                return true;
            }
        }
        return res;
    }

    public static void contarCiudades(Paciente[] pxs) {
        String[] visitadas = new String[pxs.length];
        int pos = 0;
        for (int i = 0; i < pxs.length; i++) visitadas[i] = "";
        for (Paciente px : pxs) {
            if(buscarElem(visitadas, px.getCiudad()) == false) {
                visitadas[pos] = px.getCiudad();
                pos += 1;
            }
        }

        int[] cont = new int[pos];
        for (int i = 0; i < pos; i++) {
            for (Paciente px : pxs) {
                if (visitadas[i].equals(px.getCiudad())) {
                    cont[i] += 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] > max) max = cont[i];
        }
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] == max) {
                System.out.println(visitadas[i]);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        int cantPx = Integer.parseInt(leer.nextLine());
        Paciente[] datos = new Paciente[cantPx];

        for (int i = 0; i < cantPx; i++) {
            String[] paciente = leer.nextLine().split("-");
            Paciente px = new Paciente(paciente[0], paciente[1], paciente[2], paciente[3], paciente[4], paciente[5]);

            datos[i] = px;
        }

        leer.close();

        contarCiudades(datos);

        for (Paciente px : datos) {
            System.out.println(px.getCedula() + " " + px.clasificarEdad());
        }

    }
}
