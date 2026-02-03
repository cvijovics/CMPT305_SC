package lab2;
import java.util.Objects;

public class AssessmentClass {
    private final String assessmentClass1;
    private final Integer assessmentClass1Percent;

    private final String assessmentClass2;
    private final Integer assessmentClass2Percent;

    private final String assessmentClass3;
    private final Integer assessmentClass3Percent;

    public AssessmentClass(String[] singleData)
    {
        assessmentClass1 = singleData[10];
        assessmentClass1Percent = Integer.parseInt(singleData[13]);


        if(singleData[11] == null || singleData[11].trim().isEmpty() || singleData[14] == null || singleData[14].trim().isEmpty()) {
            assessmentClass2 = null;
            assessmentClass2Percent = null;
        } else {
            assessmentClass2 = singleData[11];
            assessmentClass2Percent = Integer.parseInt(singleData[14]);
        }

        if(singleData[12] == null || singleData[12].trim().isEmpty() || singleData[15] == null || singleData[15].trim().isEmpty()) {
            assessmentClass3 = null;
            assessmentClass3Percent = null;
        } else {
            assessmentClass3 = singleData[12];
            assessmentClass3Percent = Integer.parseInt(singleData[15]);
        }

    }

    public String getAssessmentClass1() {
        return assessmentClass1;
    }

    public Integer getAssessmentClass1Percent() {
        return assessmentClass1Percent;
    }

    public String getAssessmentClass2() {
        return assessmentClass2;
    }

    public Integer getAssessmentClass2Percent() {
        return assessmentClass2Percent;
    }

    public Integer getAssessmentClass3Percent() {
        return assessmentClass3Percent;
    }

    public String getAssessmentClass3() {
        return assessmentClass3;
    }

    @Override
    public String toString(){
        if(assessmentClass2 == null)
        {
            return "[" + assessmentClass1 + " " + assessmentClass1Percent + "%]";

        } else if (assessmentClass3 == null) {
            return "[" + assessmentClass1 + " " + assessmentClass1Percent +
                    "%, " + assessmentClass2 + " " + assessmentClass2Percent + "%]";

        } else {
            return "[" + assessmentClass1 + " " + assessmentClass1Percent
                    + "%, " + assessmentClass2 + " " + assessmentClass2Percent +
                    "%, " + assessmentClass3 + " " + assessmentClass3Percent + "%]";

        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(assessmentClass1, assessmentClass2, assessmentClass3,
                assessmentClass1Percent, assessmentClass2Percent, assessmentClass3Percent);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof AssessmentClass otherAssessment)) return false;

        return (otherAssessment.getAssessmentClass1().equals(this.assessmentClass1)) &&
                (otherAssessment.getAssessmentClass1Percent().equals(this.assessmentClass1Percent)) &&
                (otherAssessment.getAssessmentClass2().equals(this.assessmentClass2)) &&
                        (otherAssessment.getAssessmentClass2Percent().equals(this.assessmentClass2Percent)) &&
                                (otherAssessment.getAssessmentClass3().equals(this.assessmentClass3)) &&
                                        (otherAssessment.getAssessmentClass3Percent().equals(this.assessmentClass3Percent));

    }
}
