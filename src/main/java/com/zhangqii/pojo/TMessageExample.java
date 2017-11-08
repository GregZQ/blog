package com.zhangqii.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMessageExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMconIsNull() {
            addCriterion("mcon is null");
            return (Criteria) this;
        }

        public Criteria andMconIsNotNull() {
            addCriterion("mcon is not null");
            return (Criteria) this;
        }

        public Criteria andMconEqualTo(String value) {
            addCriterion("mcon =", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconNotEqualTo(String value) {
            addCriterion("mcon <>", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconGreaterThan(String value) {
            addCriterion("mcon >", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconGreaterThanOrEqualTo(String value) {
            addCriterion("mcon >=", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconLessThan(String value) {
            addCriterion("mcon <", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconLessThanOrEqualTo(String value) {
            addCriterion("mcon <=", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconLike(String value) {
            addCriterion("mcon like", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconNotLike(String value) {
            addCriterion("mcon not like", value, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconIn(List<String> values) {
            addCriterion("mcon in", values, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconNotIn(List<String> values) {
            addCriterion("mcon not in", values, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconBetween(String value1, String value2) {
            addCriterion("mcon between", value1, value2, "mcon");
            return (Criteria) this;
        }

        public Criteria andMconNotBetween(String value1, String value2) {
            addCriterion("mcon not between", value1, value2, "mcon");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNull() {
            addCriterion("mtime is null");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNotNull() {
            addCriterion("mtime is not null");
            return (Criteria) this;
        }

        public Criteria andMtimeEqualTo(Date value) {
            addCriterionForJDBCDate("mtime =", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("mtime <>", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("mtime >", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mtime >=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThan(Date value) {
            addCriterionForJDBCDate("mtime <", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mtime <=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeIn(List<Date> values) {
            addCriterionForJDBCDate("mtime in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("mtime not in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mtime between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mtime not between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMurlIsNull() {
            addCriterion("murl is null");
            return (Criteria) this;
        }

        public Criteria andMurlIsNotNull() {
            addCriterion("murl is not null");
            return (Criteria) this;
        }

        public Criteria andMurlEqualTo(String value) {
            addCriterion("murl =", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlNotEqualTo(String value) {
            addCriterion("murl <>", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlGreaterThan(String value) {
            addCriterion("murl >", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlGreaterThanOrEqualTo(String value) {
            addCriterion("murl >=", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlLessThan(String value) {
            addCriterion("murl <", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlLessThanOrEqualTo(String value) {
            addCriterion("murl <=", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlLike(String value) {
            addCriterion("murl like", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlNotLike(String value) {
            addCriterion("murl not like", value, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlIn(List<String> values) {
            addCriterion("murl in", values, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlNotIn(List<String> values) {
            addCriterion("murl not in", values, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlBetween(String value1, String value2) {
            addCriterion("murl between", value1, value2, "murl");
            return (Criteria) this;
        }

        public Criteria andMurlNotBetween(String value1, String value2) {
            addCriterion("murl not between", value1, value2, "murl");
            return (Criteria) this;
        }

        public Criteria andMmailIsNull() {
            addCriterion("mmail is null");
            return (Criteria) this;
        }

        public Criteria andMmailIsNotNull() {
            addCriterion("mmail is not null");
            return (Criteria) this;
        }

        public Criteria andMmailEqualTo(String value) {
            addCriterion("mmail =", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailNotEqualTo(String value) {
            addCriterion("mmail <>", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailGreaterThan(String value) {
            addCriterion("mmail >", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailGreaterThanOrEqualTo(String value) {
            addCriterion("mmail >=", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailLessThan(String value) {
            addCriterion("mmail <", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailLessThanOrEqualTo(String value) {
            addCriterion("mmail <=", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailLike(String value) {
            addCriterion("mmail like", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailNotLike(String value) {
            addCriterion("mmail not like", value, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailIn(List<String> values) {
            addCriterion("mmail in", values, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailNotIn(List<String> values) {
            addCriterion("mmail not in", values, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailBetween(String value1, String value2) {
            addCriterion("mmail between", value1, value2, "mmail");
            return (Criteria) this;
        }

        public Criteria andMmailNotBetween(String value1, String value2) {
            addCriterion("mmail not between", value1, value2, "mmail");
            return (Criteria) this;
        }

        public Criteria andMnameIsNull() {
            addCriterion("mname is null");
            return (Criteria) this;
        }

        public Criteria andMnameIsNotNull() {
            addCriterion("mname is not null");
            return (Criteria) this;
        }

        public Criteria andMnameEqualTo(String value) {
            addCriterion("mname =", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotEqualTo(String value) {
            addCriterion("mname <>", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThan(String value) {
            addCriterion("mname >", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThanOrEqualTo(String value) {
            addCriterion("mname >=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThan(String value) {
            addCriterion("mname <", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThanOrEqualTo(String value) {
            addCriterion("mname <=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLike(String value) {
            addCriterion("mname like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotLike(String value) {
            addCriterion("mname not like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameIn(List<String> values) {
            addCriterion("mname in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotIn(List<String> values) {
            addCriterion("mname not in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameBetween(String value1, String value2) {
            addCriterion("mname between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotBetween(String value1, String value2) {
            addCriterion("mname not between", value1, value2, "mname");
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