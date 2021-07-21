import java.util.Scanner;

public class App {

    public static float promedio(Paciente[] pxs) {
        float tot = 0;
        for (Paciente px : pxs) {
            tot += px.getEdad();
        }
        return (float) tot/pxs.length;
    }

    public static void arribaProm(Paciente[] pxs, float promedio) {
        for (Paciente px : pxs) {
            if (px.getEdad() > promedio) {
                System.out.println(px.getNombre() + " " + px.getCedula());
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

        float prom = promedio(datos);
        System.out.println(String.format("%.2f", prom));

        arribaProm(datos, prom);
        contEnfermedades(datos, contEnf);

        for (int i = 0; i < 6; i++) {
            System.out.println(enfermedades[i] + " " + contEnf[i]);
        }

        for (Paciente px : datos) {
            if (px.clasificarEdad().equalsIgnoreCase("joven adulto")) {
                System.out.println(px.getNombre() + " " + px.getCedula());
            }
        }

    }
}
