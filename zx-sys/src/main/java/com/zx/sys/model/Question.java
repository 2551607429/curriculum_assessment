package com.zx.sys.model;

import java.io.Serializable;

public class Question implements Serializable {
    private Integer id;

    private Integer typeId;

    private String stem;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    private String keyword;

    private Integer curriculumId;

    private Integer chapterId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem == null ? null : stem.trim();
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA == null ? null : optionA.trim();
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB == null ? null : optionB.trim();
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC == null ? null : optionC.trim();
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD == null ? null : optionD.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
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
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getStem() == null ? other.getStem() == null : this.getStem().equals(other.getStem()))
            && (this.getOptionA() == null ? other.getOptionA() == null : this.getOptionA().equals(other.getOptionA()))
            && (this.getOptionB() == null ? other.getOptionB() == null : this.getOptionB().equals(other.getOptionB()))
            && (this.getOptionC() == null ? other.getOptionC() == null : this.getOptionC().equals(other.getOptionC()))
            && (this.getOptionD() == null ? other.getOptionD() == null : this.getOptionD().equals(other.getOptionD()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getKeyword() == null ? other.getKeyword() == null : this.getKeyword().equals(other.getKeyword()))
            && (this.getCurriculumId() == null ? other.getCurriculumId() == null : this.getCurriculumId().equals(other.getCurriculumId()))
            && (this.getChapterId() == null ? other.getChapterId() == null : this.getChapterId().equals(other.getChapterId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getStem() == null) ? 0 : getStem().hashCode());
        result = prime * result + ((getOptionA() == null) ? 0 : getOptionA().hashCode());
        result = prime * result + ((getOptionB() == null) ? 0 : getOptionB().hashCode());
        result = prime * result + ((getOptionC() == null) ? 0 : getOptionC().hashCode());
        result = prime * result + ((getOptionD() == null) ? 0 : getOptionD().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getKeyword() == null) ? 0 : getKeyword().hashCode());
        result = prime * result + ((getCurriculumId() == null) ? 0 : getCurriculumId().hashCode());
        result = prime * result + ((getChapterId() == null) ? 0 : getChapterId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typeId=").append(typeId);
        sb.append(", stem=").append(stem);
        sb.append(", optionA=").append(optionA);
        sb.append(", optionB=").append(optionB);
        sb.append(", optionC=").append(optionC);
        sb.append(", optionD=").append(optionD);
        sb.append(", answer=").append(answer);
        sb.append(", keyword=").append(keyword);
        sb.append(", curriculumId=").append(curriculumId);
        sb.append(", chapterId=").append(chapterId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}