package com.demo.fukiapi.home.po;

import java.util.ArrayList;
import java.util.List;

public class HomeNewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HomeNewExample() {
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

        public Criteria andImagePathIsNull() {
            addCriterion("image_path is null");
            return (Criteria) this;
        }

        public Criteria andImagePathIsNotNull() {
            addCriterion("image_path is not null");
            return (Criteria) this;
        }

        public Criteria andImagePathEqualTo(String value) {
            addCriterion("image_path =", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotEqualTo(String value) {
            addCriterion("image_path <>", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThan(String value) {
            addCriterion("image_path >", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_path >=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThan(String value) {
            addCriterion("image_path <", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLessThanOrEqualTo(String value) {
            addCriterion("image_path <=", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathLike(String value) {
            addCriterion("image_path like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotLike(String value) {
            addCriterion("image_path not like", value, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathIn(List<String> values) {
            addCriterion("image_path in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotIn(List<String> values) {
            addCriterion("image_path not in", values, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathBetween(String value1, String value2) {
            addCriterion("image_path between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andImagePathNotBetween(String value1, String value2) {
            addCriterion("image_path not between", value1, value2, "imagePath");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andIsLiveIsNull() {
            addCriterion("is_live is null");
            return (Criteria) this;
        }

        public Criteria andIsLiveIsNotNull() {
            addCriterion("is_live is not null");
            return (Criteria) this;
        }

        public Criteria andIsLiveEqualTo(Boolean value) {
            addCriterion("is_live =", value, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveNotEqualTo(Boolean value) {
            addCriterion("is_live <>", value, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveGreaterThan(Boolean value) {
            addCriterion("is_live >", value, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_live >=", value, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveLessThan(Boolean value) {
            addCriterion("is_live <", value, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_live <=", value, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveIn(List<Boolean> values) {
            addCriterion("is_live in", values, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveNotIn(List<Boolean> values) {
            addCriterion("is_live not in", values, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_live between", value1, value2, "isLive");
            return (Criteria) this;
        }

        public Criteria andIsLiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_live not between", value1, value2, "isLive");
            return (Criteria) this;
        }

        public Criteria andLivePathIsNull() {
            addCriterion("live_path is null");
            return (Criteria) this;
        }

        public Criteria andLivePathIsNotNull() {
            addCriterion("live_path is not null");
            return (Criteria) this;
        }

        public Criteria andLivePathEqualTo(String value) {
            addCriterion("live_path =", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathNotEqualTo(String value) {
            addCriterion("live_path <>", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathGreaterThan(String value) {
            addCriterion("live_path >", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathGreaterThanOrEqualTo(String value) {
            addCriterion("live_path >=", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathLessThan(String value) {
            addCriterion("live_path <", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathLessThanOrEqualTo(String value) {
            addCriterion("live_path <=", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathLike(String value) {
            addCriterion("live_path like", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathNotLike(String value) {
            addCriterion("live_path not like", value, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathIn(List<String> values) {
            addCriterion("live_path in", values, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathNotIn(List<String> values) {
            addCriterion("live_path not in", values, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathBetween(String value1, String value2) {
            addCriterion("live_path between", value1, value2, "livePath");
            return (Criteria) this;
        }

        public Criteria andLivePathNotBetween(String value1, String value2) {
            addCriterion("live_path not between", value1, value2, "livePath");
            return (Criteria) this;
        }

        public Criteria andLanguagesIsNull() {
            addCriterion("languages is null");
            return (Criteria) this;
        }

        public Criteria andLanguagesIsNotNull() {
            addCriterion("languages is not null");
            return (Criteria) this;
        }

        public Criteria andLanguagesEqualTo(String value) {
            addCriterion("languages =", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesNotEqualTo(String value) {
            addCriterion("languages <>", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesGreaterThan(String value) {
            addCriterion("languages >", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesGreaterThanOrEqualTo(String value) {
            addCriterion("languages >=", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesLessThan(String value) {
            addCriterion("languages <", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesLessThanOrEqualTo(String value) {
            addCriterion("languages <=", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesLike(String value) {
            addCriterion("languages like", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesNotLike(String value) {
            addCriterion("languages not like", value, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesIn(List<String> values) {
            addCriterion("languages in", values, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesNotIn(List<String> values) {
            addCriterion("languages not in", values, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesBetween(String value1, String value2) {
            addCriterion("languages between", value1, value2, "languages");
            return (Criteria) this;
        }

        public Criteria andLanguagesNotBetween(String value1, String value2) {
            addCriterion("languages not between", value1, value2, "languages");
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