package com.juhe.work2.entity;

/**
 * QQ号测吉凶
 */
public class QQTest {
    private String 	conclusion;
    private String 	analysis;

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "QQTest{" +
                "conclusion='" + conclusion + '\'' +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}
