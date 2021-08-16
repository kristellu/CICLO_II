public class GradingSystem {
	private final double[][] gradingScale = {
	    {0,30},
	    {30,60},
	    {60,80},
	    {80,90},
	    {90,100}
	};
    protected final String[] subjects = {"fisica", "quimica", "idiomas"};
    protected final String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    protected final String[] genders = {"m", "f"};


    public GradingSystem(){}

    // '¿Cuál es el desempeño promedio de todo el grupo?'
    private double getAverageAllGrades(double[][] data){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i][3];
        }
        return (sum / data.length);
    }


    private boolean isAprobbed(double grade){
        return gradingScale[2][0] < grade;
    }

	public double stat1( double[][] data ){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i][3];
        }
        return sum / data.length;
    }


    public int stat2(double[][] data){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            if(gradingScale[0][0] <= data[i][3] && gradingScale[0][1] >= data[i][3])
                count++;
        }
        return count;
    }

    public String stat3( double[][] data){
        int[] subjectsCount = {0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < data.length; i++){
            if(isAprobbed(data[i][3])){
                subjectsCount[(int)(data[i][2] - 1)] = subjectsCount[(int)(data[i][2] - 1)] + 1;
            }
        }
        int auxMax = 0;
        int auxIndex = -1;
        for(int i = 0; i < subjectsCount.length; i++){
            if(subjectsCount[i] != 0 && auxMax < subjectsCount[i]){
                auxIndex = i;
                auxMax = subjectsCount[i];
            }
        }
        return subjects[auxIndex];

    }

    public String stat4( double[][] data){
        double[] subjectsMax = {0,0,0};
        int[] subjectsStudentIndex = {0,0,0};
        for(int i = 0; i < data.length; i++){
            if(subjectsMax[(int)(data[i][2] -1 ) ] < data[i][3]){
                subjectsMax[(int)(data[i][2] -1 ) ] = data[i][3];
                subjectsStudentIndex[(int)(data[i][2] -1 )] = (int)data[i][0];
            }
        }
        return students[subjectsStudentIndex[0] - 1];
    }

}