package com.zhangqii.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TTitleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTitleExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("tname is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("tname is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("tname =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("tname <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("tname >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("tname >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("tname <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("tname <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("tname like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("tname not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("tname in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("tname not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("tname between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("tname not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTcountIsNull() {
            addCriterion("tcount is null");
            return (Criteria) this;
        }

        public Criteria andTcountIsNotNull() {
            addCriterion("tcount is not null");
            return (Criteria) this;
        }

        public Criteria andTcountEqualTo(Integer value) {
            addCriterion("tcount =", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountNotEqualTo(Integer value) {
            addCriterion("tcount <>", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountGreaterThan(Integer value) {
            addCriterion("tcount >", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("tcount >=", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountLessThan(Integer value) {
            addCriterion("tcount <", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountLessThanOrEqualTo(Integer value) {
            addCriterion("tcount <=", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountIn(List<Integer> values) {
            addCriterion("tcount in", values, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountNotIn(List<Integer> values) {
            addCriterion("tcount not in", values, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountBetween(Integer value1, Integer value2) {
            addCriterion("tcount between", value1, value2, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountNotBetween(Integer value1, Integer value2) {
            addCriterion("tcount not between", value1, value2, "tcount");
            return (Criteria) this;
        }

        public Criteria andTtagIsNull() {
            addCriterion("ttag is null");
            return (Criteria) this;
        }

        public Criteria andTtagIsNotNull() {
            addCriterion("ttag is not null");
            return (Criteria) this;
        }

        public Criteria andTtagEqualTo(Integer value) {
            addCriterion("ttag =", value, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagNotEqualTo(Integer value) {
            addCriterion("ttag <>", value, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagGreaterThan(Integer value) {
            addCriterion("ttag >", value, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagGreaterThanOrEqualTo(Integer value) {
            addCriterion("ttag >=", value, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagLessThan(Integer value) {
            addCriterion("ttag <", value, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagLessThanOrEqualTo(Integer value) {
            addCriterion("ttag <=", value, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagIn(List<Integer> values) {
            addCriterion("ttag in", values, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagNotIn(List<Integer> values) {
            addCriterion("ttag not in", values, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagBetween(Integer value1, Integer value2) {
            addCriterion("ttag between", value1, value2, "ttag");
            return (Criteria) this;
        }

        public Criteria andTtagNotBetween(Integer value1, Integer value2) {
            addCriterion("ttag not between", value1, value2, "ttag");
            return (Criteria) this;
        }

        public Criteria andTabIsNull() {
            addCriterion("tab is null");
            return (Criteria) this;
        }

        public Criteria andTabIsNotNull() {
            addCriterion("tab is not null");
            return (Criteria) this;
        }

        public Criteria andTabEqualTo(String value) {
            addCriterion("tab =", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabNotEqualTo(String value) {
            addCriterion("tab <>", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabGreaterThan(String value) {
            addCriterion("tab >", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabGreaterThanOrEqualTo(String value) {
            addCriterion("tab >=", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabLessThan(String value) {
            addCriterion("tab <", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabLessThanOrEqualTo(String value) {
            addCriterion("tab <=", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabLike(String value) {
            addCriterion("tab like", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabNotLike(String value) {
            addCriterion("tab not like", value, "tab");
            return (Criteria) this;
        }

        public Criteria andTabIn(List<String> values) {
            addCriterion("tab in", values, "tab");
            return (Criteria) this;
        }

        public Criteria andTabNotIn(List<String> values) {
            addCriterion("tab not in", values, "tab");
            return (Criteria) this;
        }

        public Criteria andTabBetween(String value1, String value2) {
            addCriterion("tab between", value1, value2, "tab");
            return (Criteria) this;
        }

        public Criteria andTabNotBetween(String value1, String value2) {
            addCriterion("tab not between", value1, value2, "tab");
            return (Criteria) this;
        }

        public Criteria andTpicIsNull() {
            addCriterion("tpic is null");
            return (Criteria) this;
        }

        public Criteria andTpicIsNotNull() {
            addCriterion("tpic is not null");
            return (Criteria) this;
        }

        public Criteria andTpicEqualTo(String value) {
            addCriterion("tpic =", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotEqualTo(String value) {
            addCriterion("tpic <>", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicGreaterThan(String value) {
            addCriterion("tpic >", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicGreaterThanOrEqualTo(String value) {
            addCriterion("tpic >=", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicLessThan(String value) {
            addCriterion("tpic <", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicLessThanOrEqualTo(String value) {
            addCriterion("tpic <=", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicLike(String value) {
            addCriterion("tpic like", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotLike(String value) {
            addCriterion("tpic not like", value, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicIn(List<String> values) {
            addCriterion("tpic in", values, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotIn(List<String> values) {
            addCriterion("tpic not in", values, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicBetween(String value1, String value2) {
            addCriterion("tpic between", value1, value2, "tpic");
            return (Criteria) this;
        }

        public Criteria andTpicNotBetween(String value1, String value2) {
            addCriterion("tpic not between", value1, value2, "tpic");
            return (Criteria) this;
        }

        public Criteria andTtimeIsNull() {
            addCriterion("ttime is null");
            return (Criteria) this;
        }

        public Criteria andTtimeIsNotNull() {
            addCriterion("ttime is not null");
            return (Criteria) this;
        }

        public Criteria andTtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ttime =", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ttime <>", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ttime >", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ttime >=", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeLessThan(Date value) {
            addCriterionForJDBCDate("ttime <", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ttime <=", value, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ttime in", values, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ttime not in", values, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ttime between", value1, value2, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ttime not between", value1, value2, "ttime");
            return (Criteria) this;
        }

        public Criteria andTtypeIsNull() {
            addCriterion("ttype is null");
            return (Criteria) this;
        }

        public Criteria andTtypeIsNotNull() {
            addCriterion("ttype is not null");
            return (Criteria) this;
        }

        public Criteria andTtypeEqualTo(Boolean value) {
            addCriterion("ttype =", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotEqualTo(Boolean value) {
            addCriterion("ttype <>", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeGreaterThan(Boolean value) {
            addCriterion("ttype >", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ttype >=", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLessThan(Boolean value) {
            addCriterion("ttype <", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeLessThanOrEqualTo(Boolean value) {
            addCriterion("ttype <=", value, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeIn(List<Boolean> values) {
            addCriterion("ttype in", values, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotIn(List<Boolean> values) {
            addCriterion("ttype not in", values, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeBetween(Boolean value1, Boolean value2) {
            addCriterion("ttype between", value1, value2, "ttype");
            return (Criteria) this;
        }

        public Criteria andTtypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ttype not between", value1, value2, "ttype");
            return (Criteria) this;
        }

        public Criteria andTstatusIsNull() {
            addCriterion("tstatus is null");
            return (Criteria) this;
        }

        public Criteria andTstatusIsNotNull() {
            addCriterion("tstatus is not null");
            return (Criteria) this;
        }

        public Criteria andTstatusEqualTo(Boolean value) {
            addCriterion("tstatus =", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusNotEqualTo(Boolean value) {
            addCriterion("tstatus <>", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusGreaterThan(Boolean value) {
            addCriterion("tstatus >", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tstatus >=", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusLessThan(Boolean value) {
            addCriterion("tstatus <", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusLessThanOrEqualTo(Boolean value) {
            addCriterion("tstatus <=", value, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusIn(List<Boolean> values) {
            addCriterion("tstatus in", values, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusNotIn(List<Boolean> values) {
            addCriterion("tstatus not in", values, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusBetween(Boolean value1, Boolean value2) {
            addCriterion("tstatus between", value1, value2, "tstatus");
            return (Criteria) this;
        }

        public Criteria andTstatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tstatus not between", value1, value2, "tstatus");
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