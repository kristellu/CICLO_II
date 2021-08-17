public class DensidadPoblacional extends ObjetoGeografico{
    private int cantidadHabitantes;

    public DensidadPoblacional(double id, String ciudad) {
        super(id, ciudad);
    }

    public int getCantidadHabitantes() {
        return this.cantidadHabitantes;
    }

    public void setCantidadHabitantes(int cantidadHabitantes) {
        this.cantidadHabitantes = cantidadHabitantes;
    }

    public int afeccion() {
        if (this.cantidadHabitantes < 10000) {
            return 0;
        } else if (this.cantidadHabitantes >= 10000 && this.cantidadHabitantes <= 50000) {
            return 1;
        } else {
            return 2;
        }
    }
}
