public class Nodule {
    private String composition;
    private String echogenicity;
    private String form;
    private String margin;
    private String[] echogenicFoci = new String[4];
    private float size;
    private int score = 0;
    private String alert;
    private String treatment;

    public Nodule(String composition, String echogenicity, String form, String margin, String[] echogenicFoci, String size) {
        this.composition = composition;
        this.echogenicity = echogenicity;
        this.form = form;
        this.margin = margin;
        for (int i = 0; i < 4; i++) {
            this.echogenicFoci[i] = echogenicFoci[i];
        }
        this.size = Float.parseFloat(size);
        this.score = this.computeComposition() + this.computeEchogenicity() + this.computeForm() + this.computeMargin() + this.computeEchogenicFoci();
        String[] temp = new String[2];
        temp = this.computeResults();
        this.alert = this.computeAlert();
        this.treatment = this.computeTreatment();
    }

    public String getAlert() {
        return this.alert;
    }

    public String getTreatment() {
        return this.treatment;
    }

    private int computeComposition() {
        int score = 0;
        if (this.composition.equals("C3")) {
            score += 1;
        }else if (this.composition.equals("C4")) {
            score += 2;
        }
        return score;
    }

    private int computeEchogenicity() {
        int score = 0;
        if (this.echogenicity.equals("E2")) {
            score += 1;
        }else if (this.echogenicity.equals("E3")) {
            score += 2;
        }else if (this.echogenicity.equals("E4")) {
            score += 3;
        }
        return score;
    }

    private int computeForm() {
        return this.form.equals("F1") ? 0 : 3;
    }

    private int computeMargin() {
        int score = 0;
        if (this.margin.equals("M3")) {
            score += 2;
        }else if (this.margin.equals("M4")) {
            score += 3;
        }
        return score;
    }

    private int computeEchogenicFoci() {
        int score = 0;
        if (this.echogenicFoci[0].equals("1")) {
            score += 0;
        }
        if (this.echogenicFoci[1].equals("1")) {
            score += 1;
        }
        if (this.echogenicFoci[2].equals("1")) {
            score += 2;
        }
        if (this.echogenicFoci[3].equals("1")) {
            score += 3;
        }
        return score;
    }

    public String computeAlert(){
        String res = "";
        if ((this.score >= 0) && (this.score <= 1)) {
            res = "benigno";
        } else if (this.score == 2) {
            res = "no sospechoso";
        } else if (this.score == 3) {
            res  = "levemente sospechoso";
        } else if ((this.score >= 4) && (this.score <= 6)) {
            res = "moderadamente sospechoso";
        } else if (this.score >= 7) {
            res = "altamente sospechoso";
        }
        return res;
    }

    public String computeTreatment() {
        String res = "";
        if ((this.score >= 0) && (this.score <= 1)) {
            res = "no aaf";
        } else if (this.score == 2) {
            res = "no aaf";
        } else if (this.score == 3) {
            if (this.size >= 2.5) {
                res = "aaf";
            } else {
                res = "seguimiento";
            }
        } else if ((this.score >= 4) && (this.score <= 6)) {
            if (this.size >= 1.5) {
                res = "aaf";
            } else {
                res = "seguimiento";
            }
        } else if (this.score >= 7) {
            if (this.size >= 1) {
                res = "aaf";
            } else {
                res = "seguimiento";
            }
        }
        return res;
    }

    private String[] computeResults(){
        String[] arr = new String[2];
        if ((this.score >= 0) && (this.score <= 1)) {
            arr[0] = "benigno";
            arr[1] = "no aaf";
        } else if (this.score == 2) {
            arr[0] = "no sospechoso";
            arr[1] = "no aaf";
        } else if (this.score == 3) {
            arr[0]  = "levemente sospechoso";
            if (this.size >= 2.5) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        } else if ((this.score >= 4) && (this.score <= 6)) {
            arr[0] = "moderadamente sospechoso";
            if (this.size >= 1.5) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        } else if (this.score >= 7) {
            arr[0] = "altamente sospechoso";
            if (this.size >= 1) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        }
        return arr;
    }

}
