package com.zx.sys.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andStemIsNull() {
            addCriterion("stem is null");
            return (Criteria) this;
        }

        public Criteria andStemIsNotNull() {
            addCriterion("stem is not null");
            return (Criteria) this;
        }

        public Criteria andStemEqualTo(String value) {
            addCriterion("stem =", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemNotEqualTo(String value) {
            addCriterion("stem <>", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemGreaterThan(String value) {
            addCriterion("stem >", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemGreaterThanOrEqualTo(String value) {
            addCriterion("stem >=", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemLessThan(String value) {
            addCriterion("stem <", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemLessThanOrEqualTo(String value) {
            addCriterion("stem <=", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemLike(String value) {
            addCriterion("stem like", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemNotLike(String value) {
            addCriterion("stem not like", value, "stem");
            return (Criteria) this;
        }

        public Criteria andStemIn(List<String> values) {
            addCriterion("stem in", values, "stem");
            return (Criteria) this;
        }

        public Criteria andStemNotIn(List<String> values) {
            addCriterion("stem not in", values, "stem");
            return (Criteria) this;
        }

        public Criteria andStemBetween(String value1, String value2) {
            addCriterion("stem between", value1, value2, "stem");
            return (Criteria) this;
        }

        public Criteria andStemNotBetween(String value1, String value2) {
            addCriterion("stem not between", value1, value2, "stem");
            return (Criteria) this;
        }

        public Criteria andOptionAIsNull() {
            addCriterion("option_a is null");
            return (Criteria) this;
        }

        public Criteria andOptionAIsNotNull() {
            addCriterion("option_a is not null");
            return (Criteria) this;
        }

        public Criteria andOptionAEqualTo(String value) {
            addCriterion("option_a =", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotEqualTo(String value) {
            addCriterion("option_a <>", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAGreaterThan(String value) {
            addCriterion("option_a >", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAGreaterThanOrEqualTo(String value) {
            addCriterion("option_a >=", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALessThan(String value) {
            addCriterion("option_a <", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALessThanOrEqualTo(String value) {
            addCriterion("option_a <=", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionALike(String value) {
            addCriterion("option_a like", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotLike(String value) {
            addCriterion("option_a not like", value, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionAIn(List<String> values) {
            addCriterion("option_a in", values, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotIn(List<String> values) {
            addCriterion("option_a not in", values, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionABetween(String value1, String value2) {
            addCriterion("option_a between", value1, value2, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionANotBetween(String value1, String value2) {
            addCriterion("option_a not between", value1, value2, "optionA");
            return (Criteria) this;
        }

        public Criteria andOptionBIsNull() {
            addCriterion("option_b is null");
            return (Criteria) this;
        }

        public Criteria andOptionBIsNotNull() {
            addCriterion("option_b is not null");
            return (Criteria) this;
        }

        public Criteria andOptionBEqualTo(String value) {
            addCriterion("option_b =", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotEqualTo(String value) {
            addCriterion("option_b <>", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBGreaterThan(String value) {
            addCriterion("option_b >", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBGreaterThanOrEqualTo(String value) {
            addCriterion("option_b >=", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLessThan(String value) {
            addCriterion("option_b <", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLessThanOrEqualTo(String value) {
            addCriterion("option_b <=", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBLike(String value) {
            addCriterion("option_b like", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotLike(String value) {
            addCriterion("option_b not like", value, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBIn(List<String> values) {
            addCriterion("option_b in", values, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotIn(List<String> values) {
            addCriterion("option_b not in", values, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBBetween(String value1, String value2) {
            addCriterion("option_b between", value1, value2, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionBNotBetween(String value1, String value2) {
            addCriterion("option_b not between", value1, value2, "optionB");
            return (Criteria) this;
        }

        public Criteria andOptionCIsNull() {
            addCriterion("option_c is null");
            return (Criteria) this;
        }

        public Criteria andOptionCIsNotNull() {
            addCriterion("option_c is not null");
            return (Criteria) this;
        }

        public Criteria andOptionCEqualTo(String value) {
            addCriterion("option_c =", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotEqualTo(String value) {
            addCriterion("option_c <>", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCGreaterThan(String value) {
            addCriterion("option_c >", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCGreaterThanOrEqualTo(String value) {
            addCriterion("option_c >=", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLessThan(String value) {
            addCriterion("option_c <", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLessThanOrEqualTo(String value) {
            addCriterion("option_c <=", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCLike(String value) {
            addCriterion("option_c like", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotLike(String value) {
            addCriterion("option_c not like", value, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCIn(List<String> values) {
            addCriterion("option_c in", values, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotIn(List<String> values) {
            addCriterion("option_c not in", values, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCBetween(String value1, String value2) {
            addCriterion("option_c between", value1, value2, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionCNotBetween(String value1, String value2) {
            addCriterion("option_c not between", value1, value2, "optionC");
            return (Criteria) this;
        }

        public Criteria andOptionDIsNull() {
            addCriterion("option_d is null");
            return (Criteria) this;
        }

        public Criteria andOptionDIsNotNull() {
            addCriterion("option_d is not null");
            return (Criteria) this;
        }

        public Criteria andOptionDEqualTo(String value) {
            addCriterion("option_d =", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDNotEqualTo(String value) {
            addCriterion("option_d <>", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDGreaterThan(String value) {
            addCriterion("option_d >", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDGreaterThanOrEqualTo(String value) {
            addCriterion("option_d >=", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDLessThan(String value) {
            addCriterion("option_d <", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDLessThanOrEqualTo(String value) {
            addCriterion("option_d <=", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDLike(String value) {
            addCriterion("option_d like", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDNotLike(String value) {
            addCriterion("option_d not like", value, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDIn(List<String> values) {
            addCriterion("option_d in", values, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDNotIn(List<String> values) {
            addCriterion("option_d not in", values, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDBetween(String value1, String value2) {
            addCriterion("option_d between", value1, value2, "optionD");
            return (Criteria) this;
        }

        public Criteria andOptionDNotBetween(String value1, String value2) {
            addCriterion("option_d not between", value1, value2, "optionD");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNull() {
            addCriterion("curriculum_id is null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIsNotNull() {
            addCriterion("curriculum_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdEqualTo(Integer value) {
            addCriterion("curriculum_id =", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotEqualTo(Integer value) {
            addCriterion("curriculum_id <>", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThan(Integer value) {
            addCriterion("curriculum_id >", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id >=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThan(Integer value) {
            addCriterion("curriculum_id <", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdLessThanOrEqualTo(Integer value) {
            addCriterion("curriculum_id <=", value, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdIn(List<Integer> values) {
            addCriterion("curriculum_id in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotIn(List<Integer> values) {
            addCriterion("curriculum_id not in", values, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andCurriculumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("curriculum_id not between", value1, value2, "curriculumId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNull() {
            addCriterion("chapter_id is null");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNotNull() {
            addCriterion("chapter_id is not null");
            return (Criteria) this;
        }

        public Criteria andChapterIdEqualTo(Integer value) {
            addCriterion("chapter_id =", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotEqualTo(Integer value) {
            addCriterion("chapter_id <>", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThan(Integer value) {
            addCriterion("chapter_id >", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapter_id >=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThan(Integer value) {
            addCriterion("chapter_id <", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThanOrEqualTo(Integer value) {
            addCriterion("chapter_id <=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIn(List<Integer> values) {
            addCriterion("chapter_id in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotIn(List<Integer> values) {
            addCriterion("chapter_id not in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdBetween(Integer value1, Integer value2) {
            addCriterion("chapter_id between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chapter_id not between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Float value) {
            addCriterion("difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Float value) {
            addCriterion("difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Float value) {
            addCriterion("difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Float value) {
            addCriterion("difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Float value) {
            addCriterion("difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Float value) {
            addCriterion("difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Float> values) {
            addCriterion("difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Float> values) {
            addCriterion("difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Float value1, Float value2) {
            addCriterion("difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Float value1, Float value2) {
            addCriterion("difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}