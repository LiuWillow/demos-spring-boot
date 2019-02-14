package com.generator.entry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KeywordOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KeywordOrderExample() {
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

        public Criteria andKeywordOrderIdIsNull() {
            addCriterion("keyword_order_id is null");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdIsNotNull() {
            addCriterion("keyword_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdEqualTo(Integer value) {
            addCriterion("keyword_order_id =", value, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdNotEqualTo(Integer value) {
            addCriterion("keyword_order_id <>", value, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdGreaterThan(Integer value) {
            addCriterion("keyword_order_id >", value, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("keyword_order_id >=", value, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdLessThan(Integer value) {
            addCriterion("keyword_order_id <", value, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("keyword_order_id <=", value, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdIn(List<Integer> values) {
            addCriterion("keyword_order_id in", values, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdNotIn(List<Integer> values) {
            addCriterion("keyword_order_id not in", values, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("keyword_order_id between", value1, value2, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("keyword_order_id not between", value1, value2, "keywordOrderId");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidIsNull() {
            addCriterion("keyword_order_sid is null");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidIsNotNull() {
            addCriterion("keyword_order_sid is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidEqualTo(String value) {
            addCriterion("keyword_order_sid =", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidNotEqualTo(String value) {
            addCriterion("keyword_order_sid <>", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidGreaterThan(String value) {
            addCriterion("keyword_order_sid >", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidGreaterThanOrEqualTo(String value) {
            addCriterion("keyword_order_sid >=", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidLessThan(String value) {
            addCriterion("keyword_order_sid <", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidLessThanOrEqualTo(String value) {
            addCriterion("keyword_order_sid <=", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidLike(String value) {
            addCriterion("keyword_order_sid like", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidNotLike(String value) {
            addCriterion("keyword_order_sid not like", value, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidIn(List<String> values) {
            addCriterion("keyword_order_sid in", values, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidNotIn(List<String> values) {
            addCriterion("keyword_order_sid not in", values, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidBetween(String value1, String value2) {
            addCriterion("keyword_order_sid between", value1, value2, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordOrderSidNotBetween(String value1, String value2) {
            addCriterion("keyword_order_sid not between", value1, value2, "keywordOrderSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidIsNull() {
            addCriterion("keyword_basic_sid is null");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidIsNotNull() {
            addCriterion("keyword_basic_sid is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidEqualTo(String value) {
            addCriterion("keyword_basic_sid =", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidNotEqualTo(String value) {
            addCriterion("keyword_basic_sid <>", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidGreaterThan(String value) {
            addCriterion("keyword_basic_sid >", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidGreaterThanOrEqualTo(String value) {
            addCriterion("keyword_basic_sid >=", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidLessThan(String value) {
            addCriterion("keyword_basic_sid <", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidLessThanOrEqualTo(String value) {
            addCriterion("keyword_basic_sid <=", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidLike(String value) {
            addCriterion("keyword_basic_sid like", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidNotLike(String value) {
            addCriterion("keyword_basic_sid not like", value, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidIn(List<String> values) {
            addCriterion("keyword_basic_sid in", values, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidNotIn(List<String> values) {
            addCriterion("keyword_basic_sid not in", values, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidBetween(String value1, String value2) {
            addCriterion("keyword_basic_sid between", value1, value2, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andKeywordBasicSidNotBetween(String value1, String value2) {
            addCriterion("keyword_basic_sid not between", value1, value2, "keywordBasicSid");
            return (Criteria) this;
        }

        public Criteria andRankingIsNull() {
            addCriterion("ranking is null");
            return (Criteria) this;
        }

        public Criteria andRankingIsNotNull() {
            addCriterion("ranking is not null");
            return (Criteria) this;
        }

        public Criteria andRankingEqualTo(Integer value) {
            addCriterion("ranking =", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotEqualTo(Integer value) {
            addCriterion("ranking <>", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingGreaterThan(Integer value) {
            addCriterion("ranking >", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("ranking >=", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingLessThan(Integer value) {
            addCriterion("ranking <", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingLessThanOrEqualTo(Integer value) {
            addCriterion("ranking <=", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingIn(List<Integer> values) {
            addCriterion("ranking in", values, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotIn(List<Integer> values) {
            addCriterion("ranking not in", values, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingBetween(Integer value1, Integer value2) {
            addCriterion("ranking between", value1, value2, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("ranking not between", value1, value2, "ranking");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginIsNull() {
            addCriterion("effective_time_begin is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginIsNotNull() {
            addCriterion("effective_time_begin is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginEqualTo(Date value) {
            addCriterion("effective_time_begin =", value, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginNotEqualTo(Date value) {
            addCriterion("effective_time_begin <>", value, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginGreaterThan(Date value) {
            addCriterion("effective_time_begin >", value, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_time_begin >=", value, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginLessThan(Date value) {
            addCriterion("effective_time_begin <", value, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginLessThanOrEqualTo(Date value) {
            addCriterion("effective_time_begin <=", value, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginIn(List<Date> values) {
            addCriterion("effective_time_begin in", values, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginNotIn(List<Date> values) {
            addCriterion("effective_time_begin not in", values, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginBetween(Date value1, Date value2) {
            addCriterion("effective_time_begin between", value1, value2, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBeginNotBetween(Date value1, Date value2) {
            addCriterion("effective_time_begin not between", value1, value2, "effectiveTimeBegin");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndIsNull() {
            addCriterion("effective_time_end is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndIsNotNull() {
            addCriterion("effective_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndEqualTo(Date value) {
            addCriterion("effective_time_end =", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndNotEqualTo(Date value) {
            addCriterion("effective_time_end <>", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndGreaterThan(Date value) {
            addCriterion("effective_time_end >", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_time_end >=", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndLessThan(Date value) {
            addCriterion("effective_time_end <", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("effective_time_end <=", value, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndIn(List<Date> values) {
            addCriterion("effective_time_end in", values, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndNotIn(List<Date> values) {
            addCriterion("effective_time_end not in", values, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndBetween(Date value1, Date value2) {
            addCriterion("effective_time_end between", value1, value2, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("effective_time_end not between", value1, value2, "effectiveTimeEnd");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationIsNull() {
            addCriterion("effective_duration is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationIsNotNull() {
            addCriterion("effective_duration is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationEqualTo(Integer value) {
            addCriterion("effective_duration =", value, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationNotEqualTo(Integer value) {
            addCriterion("effective_duration <>", value, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationGreaterThan(Integer value) {
            addCriterion("effective_duration >", value, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("effective_duration >=", value, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationLessThan(Integer value) {
            addCriterion("effective_duration <", value, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationLessThanOrEqualTo(Integer value) {
            addCriterion("effective_duration <=", value, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationIn(List<Integer> values) {
            addCriterion("effective_duration in", values, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationNotIn(List<Integer> values) {
            addCriterion("effective_duration not in", values, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationBetween(Integer value1, Integer value2) {
            addCriterion("effective_duration between", value1, value2, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andEffectiveDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("effective_duration not between", value1, value2, "effectiveDuration");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Long value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Long value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Long value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Long value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Long value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Long> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Long> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Long value1, Long value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Long value1, Long value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Long value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Long value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Long value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Long value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Long value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Long> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Long> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Long value1, Long value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Long value1, Long value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyIsNull() {
            addCriterion("total_pay_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyIsNotNull() {
            addCriterion("total_pay_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyEqualTo(Long value) {
            addCriterion("total_pay_money =", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyNotEqualTo(Long value) {
            addCriterion("total_pay_money <>", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyGreaterThan(Long value) {
            addCriterion("total_pay_money >", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("total_pay_money >=", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyLessThan(Long value) {
            addCriterion("total_pay_money <", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyLessThanOrEqualTo(Long value) {
            addCriterion("total_pay_money <=", value, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyIn(List<Long> values) {
            addCriterion("total_pay_money in", values, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyNotIn(List<Long> values) {
            addCriterion("total_pay_money not in", values, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyBetween(Long value1, Long value2) {
            addCriterion("total_pay_money between", value1, value2, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andTotalPayMoneyNotBetween(Long value1, Long value2) {
            addCriterion("total_pay_money not between", value1, value2, "totalPayMoney");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(Integer value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(Integer value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(Integer value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(Integer value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(Integer value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<Integer> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<Integer> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(Integer value1, Integer value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(Integer value1, Integer value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdIsNull() {
            addCriterion("main_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMainUserIdIsNotNull() {
            addCriterion("main_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainUserIdEqualTo(Long value) {
            addCriterion("main_user_id =", value, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdNotEqualTo(Long value) {
            addCriterion("main_user_id <>", value, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdGreaterThan(Long value) {
            addCriterion("main_user_id >", value, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("main_user_id >=", value, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdLessThan(Long value) {
            addCriterion("main_user_id <", value, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdLessThanOrEqualTo(Long value) {
            addCriterion("main_user_id <=", value, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdIn(List<Long> values) {
            addCriterion("main_user_id in", values, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdNotIn(List<Long> values) {
            addCriterion("main_user_id not in", values, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdBetween(Long value1, Long value2) {
            addCriterion("main_user_id between", value1, value2, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andMainUserIdNotBetween(Long value1, Long value2) {
            addCriterion("main_user_id not between", value1, value2, "mainUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(Integer value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(Integer value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(Integer value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(Integer value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<Integer> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<Integer> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(Integer value1, Integer value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("platform not between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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