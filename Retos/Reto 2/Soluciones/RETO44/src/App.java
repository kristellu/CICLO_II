import java.util.Scanner;

public class App {

    public static void enfermedadMasFrecuente(String[] enf, int[] cont) {
        int max = -1;
        for (int i = 0; i < 6; i++) {
            if (cont[i] > max) max = cont[i];
        }
        for (int i = 0; i < 6; i++) {
            if (cont[i] == max) {
                System.out.println(enf[i]);
                break;
            }
        }
    }

    public static void enfermedadMenosFrecuente(String[] enf, int[] cont) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            if (cont[i] < min) min = cont[i];
        }
        for (int i = 0; i < 6; i++) {
            if (cont[i] == min) {
                System.out.println(enf[i]);
                break;
            }
        }
    }

    public static boolean buscarElem(String[] vec, String elem) {
        boolean res = false;
        for (int  i = 0; i  < vec.length; i ++) {
            if (elem.equals(vec[i])) {
                return true;
            }
        }
        return res;
    }

    public static void contarEPS(Paciente[] pxs) {
        String[] visitadas = new String[pxs.length];
        int pos = 0;
        for (int i = 0; i < pxs.length; i++) visitadas[i] = "";
        for (Paciente px : pxs) {
            if(buscarElem(visitadas, px.getEps()) == false) {
                visitadas[pos] = px.getEps();
                pos += 1;
            }
        }

        int[] cont = new int[pos];
        for (int i = 0; i < pos; i++) {
            for (Paciente px : pxs) {
                if (visitadas[i].equals(px.getEps())) {
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

    public static void contEnfermedades(Paciente[] pxs, int[] conts) {
        for (Paciente px : pxs) {
            switch (px.getEnfermedad()) {
                case "Cancer":
                    conts[0] += 1;
                    break;
                case "Cardiovasculares":
                    conts[1] += 1;
                    break;
                case "Respiratorias":
                    conts[2] += 1;
                    break;
                case "Cerebrovasculares":
                    conts[3] += 1;
                    break;
                case "Hipertension":
                    conts[4] += 1;
                    break;
                case "Diabetes":
                    conts[5] += 1;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        int cantPx = Integer.parseInt(leer.nextLine());
        Paciente[] datos = new Paciente[cantPx];

        String[] enfermedades = {"Cancer", "Cardiovasculares", "Respiratorias", "Cerebrovasculares", "Hipertension", "Diabetes"};
        int[] contEnf = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < cantPx; i++) {
            String[] paciente = leer.nextLine().split("-");
            Paciente px = new Paciente(paciente[0], paciente[1], paciente[2], paciente[3], paciente[4], paciente[5]);

            datos[i] = px;
        }

        leer.close();

        contEnfermedades(datos, contEnf);
        enfermedadMasFrecuente(enfermedades, contEnf);
        enfermedadMenosFrecuente(enfermedades, contEnf);
        contarEPS(datos);

        for (Paciente px : datos) {
            if (px.clasificarEdad().equalsIgnoreCase("adulto")) {
                System.out.println(px.getNombre() + " " + px.getCedula());
            }
        }

    }
}
