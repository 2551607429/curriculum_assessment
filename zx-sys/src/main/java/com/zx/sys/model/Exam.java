package com.zx.sys.model;

import java.io.Serializable;
import java.util.Date;

public class Exam implements Serializable {
    private Integer id;

    private String name;

    private Date startTime;

    private Date endTime;

    private Integer totalScore;

    private Float difficulty;

    private Integer examRange;

    private String classRange;

    private Integer curriculumId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Float difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getExamRange() {
        return examRange;
    }

    public void setExamRange(Integer examRange) {
        this.examRange = examRange;
    }

    public String getClassRange() {
        return classRange;
    }

    public void setClassRange(String classRange) {
        this.classRange = classRange == null ? null : classRange.trim();
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
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
        Exam other = (Exam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getTotalScore() == null ? other.getTotalScore() == null : this.getTotalScore().equals(other.getTotalScore()))
            && (this.getDifficulty() == null ? other.getDifficulty() == null : this.getDifficulty().equals(other.getDifficulty()))
            && (this.getExamRange() == null ? other.getExamRange() == null : this.getExamRange().equals(other.getExamRange()))
            && (this.getClassRange() == null ? other.getClassRange() == null : this.getClassRange().equals(other.getClassRange()))
            && (this.getCurriculumId() == null ? other.getCurriculumId() == null : this.getCurriculumId().equals(other.getCurriculumId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getTotalScore() == null) ? 0 : getTotalScore().hashCode());
        result = prime * result + ((getDifficulty() == null) ? 0 : getDifficulty().hashCode());
        result = prime * result + ((getExamRange() == null) ? 0 : getExamRange().hashCode());
        result = prime * result + ((getClassRange() == null) ? 0 : getClassRange().hashCode());
        result = prime * result + ((getCurriculumId() == null) ? 0 : getCurriculumId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", difficulty=").append(difficulty);
        sb.append(", examRange=").append(examRange);
        sb.append(", classRange=").append(classRange);
        sb.append(", curriculumId=").append(curriculumId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}