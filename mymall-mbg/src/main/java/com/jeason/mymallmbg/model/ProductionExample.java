package com.jeason.mymallmbg.model;

import java.util.ArrayList;
import java.util.List;

public class ProductionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductionExample() {
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

        public Criteria andProductionidIsNull() {
            addCriterion("productionId is null");
            return (Criteria) this;
        }

        public Criteria andProductionidIsNotNull() {
            addCriterion("productionId is not null");
            return (Criteria) this;
        }

        public Criteria andProductionidEqualTo(Integer value) {
            addCriterion("productionId =", value, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidNotEqualTo(Integer value) {
            addCriterion("productionId <>", value, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidGreaterThan(Integer value) {
            addCriterion("productionId >", value, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productionId >=", value, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidLessThan(Integer value) {
            addCriterion("productionId <", value, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidLessThanOrEqualTo(Integer value) {
            addCriterion("productionId <=", value, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidIn(List<Integer> values) {
            addCriterion("productionId in", values, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidNotIn(List<Integer> values) {
            addCriterion("productionId not in", values, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidBetween(Integer value1, Integer value2) {
            addCriterion("productionId between", value1, value2, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionidNotBetween(Integer value1, Integer value2) {
            addCriterion("productionId not between", value1, value2, "productionid");
            return (Criteria) this;
        }

        public Criteria andProductionnmIsNull() {
            addCriterion("productionNm is null");
            return (Criteria) this;
        }

        public Criteria andProductionnmIsNotNull() {
            addCriterion("productionNm is not null");
            return (Criteria) this;
        }

        public Criteria andProductionnmEqualTo(String value) {
            addCriterion("productionNm =", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmNotEqualTo(String value) {
            addCriterion("productionNm <>", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmGreaterThan(String value) {
            addCriterion("productionNm >", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmGreaterThanOrEqualTo(String value) {
            addCriterion("productionNm >=", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmLessThan(String value) {
            addCriterion("productionNm <", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmLessThanOrEqualTo(String value) {
            addCriterion("productionNm <=", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmLike(String value) {
            addCriterion("productionNm like", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmNotLike(String value) {
            addCriterion("productionNm not like", value, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmIn(List<String> values) {
            addCriterion("productionNm in", values, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmNotIn(List<String> values) {
            addCriterion("productionNm not in", values, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmBetween(String value1, String value2) {
            addCriterion("productionNm between", value1, value2, "productionnm");
            return (Criteria) this;
        }

        public Criteria andProductionnmNotBetween(String value1, String value2) {
            addCriterion("productionNm not between", value1, value2, "productionnm");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
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