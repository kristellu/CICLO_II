public class CreateSQLScriptFill {
    
    public static void main(String[] args){

        String template = "INSERT INTO GRADES (NAME, SUBJECT, GENDER, GRADE)\nVALUES\n";

        SchoolGradingSystem sgs = new SchoolGradingSystem();
        sgs.loadData();
        double data[][] = sgs.getData();
        String[] line = new String[4];
        for(int i=0; i< data.length; i++){
            for(int j = 0; j < 4; j++){
                switch (j) {
                    case 0:
                        line[0] = "'" + sgs.students[(int)(data[i][j] - 1.0)] +  "',";
                        break;
                    case 1:
                        line[1] = "'" + sgs.genders[(int)data[i][j]] +  "',";
                        break;
                    case 2:
                        line[2] = "'" + sgs.subjects[(int)(data[i][j] - 1.0)] +  "',";
                        break;
                    case 3:
                        line[3] = "" + data[i][j];
                        break;
                }
            }
            String end = (i == data.length - 1)?";":",";
            template += "(" + line[0] + line[2] + line[1] + line[3] + ")" + end + "\n";

        }
        System.out.println(" --------------------------- \n");
        System.out.println(template);
    }
}