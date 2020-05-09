package com.zx.sys.model;

import java.io.Serializable;

public class AnswerPaper extends AnswerPaperKey implements Serializable {
    private String stuAnswer;

    private Float score;

    private Float stuScore;

    private static final long serialVersionUID = 1L;

    public String getStuAnswer() {
        return stuAnswer;
    }

    public void setStuAnswer(String stuAnswer) {
        this.stuAnswer = stuAnswer == null ? null : stuAnswer.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getStuScore() {
        return stuScore;
    }

    public void setStuScore(Float stuScore) {
        this.stuScore = stuScore;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AnswerPaper other = (AnswerPaper) that;
        return (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()))
            && (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getStuAnswer() == null ? other.getStuAnswer() == null : this.getStuAnswer().equals(other.getStuAnswer()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getStuScore() == null ? other.getStuScore() == null : this.getStuScore().equals(other.getStuScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getStuAnswer() == null) ? 0 : getStuAnswer().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getStuScore() == null) ? 0 : getStuScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuAnswer=").append(stuAnswer);
        sb.append(", score=").append(score);
        sb.append(", stuScore=").append(stuScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}