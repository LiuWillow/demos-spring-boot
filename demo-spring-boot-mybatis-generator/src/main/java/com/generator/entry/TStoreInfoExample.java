package com.generator.entry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TStoreInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStoreInfoExample() {
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
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

        public Criteria andStoreSidIsNull() {
            addCriterion("store_sid is null");
            return (Criteria) this;
        }

        public Criteria andStoreSidIsNotNull() {
            addCriterion("store_sid is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSidEqualTo(String value) {
            addCriterion("store_sid =", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidNotEqualTo(String value) {
            addCriterion("store_sid <>", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidGreaterThan(String value) {
            addCriterion("store_sid >", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidGreaterThanOrEqualTo(String value) {
            addCriterion("store_sid >=", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidLessThan(String value) {
            addCriterion("store_sid <", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidLessThanOrEqualTo(String value) {
            addCriterion("store_sid <=", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidLike(String value) {
            addCriterion("store_sid like", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidNotLike(String value) {
            addCriterion("store_sid not like", value, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidIn(List<String> values) {
            addCriterion("store_sid in", values, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidNotIn(List<String> values) {
            addCriterion("store_sid not in", values, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidBetween(String value1, String value2) {
            addCriterion("store_sid between", value1, value2, "storeSid");
            return (Criteria) this;
        }

        public Criteria andStoreSidNotBetween(String value1, String value2) {
            addCriterion("store_sid not between", value1, value2, "storeSid");
            return (Criteria) this;
        }

        public Criteria andUserSidIsNull() {
            addCriterion("user_sid is null");
            return (Criteria) this;
        }

        public Criteria andUserSidIsNotNull() {
            addCriterion("user_sid is not null");
            return (Criteria) this;
        }

        public Criteria andUserSidEqualTo(String value) {
            addCriterion("user_sid =", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotEqualTo(String value) {
            addCriterion("user_sid <>", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidGreaterThan(String value) {
            addCriterion("user_sid >", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidGreaterThanOrEqualTo(String value) {
            addCriterion("user_sid >=", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLessThan(String value) {
            addCriterion("user_sid <", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLessThanOrEqualTo(String value) {
            addCriterion("user_sid <=", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLike(String value) {
            addCriterion("user_sid like", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotLike(String value) {
            addCriterion("user_sid not like", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidIn(List<String> values) {
            addCriterion("user_sid in", values, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotIn(List<String> values) {
            addCriterion("user_sid not in", values, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidBetween(String value1, String value2) {
            addCriterion("user_sid between", value1, value2, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotBetween(String value1, String value2) {
            addCriterion("user_sid not between", value1, value2, "userSid");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhIsNull() {
            addCriterion("store_name_zh is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhIsNotNull() {
            addCriterion("store_name_zh is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhEqualTo(String value) {
            addCriterion("store_name_zh =", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhNotEqualTo(String value) {
            addCriterion("store_name_zh <>", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhGreaterThan(String value) {
            addCriterion("store_name_zh >", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhGreaterThanOrEqualTo(String value) {
            addCriterion("store_name_zh >=", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhLessThan(String value) {
            addCriterion("store_name_zh <", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhLessThanOrEqualTo(String value) {
            addCriterion("store_name_zh <=", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhLike(String value) {
            addCriterion("store_name_zh like", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhNotLike(String value) {
            addCriterion("store_name_zh not like", value, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhIn(List<String> values) {
            addCriterion("store_name_zh in", values, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhNotIn(List<String> values) {
            addCriterion("store_name_zh not in", values, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhBetween(String value1, String value2) {
            addCriterion("store_name_zh between", value1, value2, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andStoreNameZhNotBetween(String value1, String value2) {
            addCriterion("store_name_zh not between", value1, value2, "storeNameZh");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountIsNull() {
            addCriterion("home_photo_count is null");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountIsNotNull() {
            addCriterion("home_photo_count is not null");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountEqualTo(Byte value) {
            addCriterion("home_photo_count =", value, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountNotEqualTo(Byte value) {
            addCriterion("home_photo_count <>", value, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountGreaterThan(Byte value) {
            addCriterion("home_photo_count >", value, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("home_photo_count >=", value, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountLessThan(Byte value) {
            addCriterion("home_photo_count <", value, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountLessThanOrEqualTo(Byte value) {
            addCriterion("home_photo_count <=", value, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountIn(List<Byte> values) {
            addCriterion("home_photo_count in", values, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountNotIn(List<Byte> values) {
            addCriterion("home_photo_count not in", values, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountBetween(Byte value1, Byte value2) {
            addCriterion("home_photo_count between", value1, value2, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andHomePhotoCountNotBetween(Byte value1, Byte value2) {
            addCriterion("home_photo_count not between", value1, value2, "homePhotoCount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountIsNull() {
            addCriterion("transaction_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountIsNotNull() {
            addCriterion("transaction_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountEqualTo(String value) {
            addCriterion("transaction_amount =", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountNotEqualTo(String value) {
            addCriterion("transaction_amount <>", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountGreaterThan(String value) {
            addCriterion("transaction_amount >", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_amount >=", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountLessThan(String value) {
            addCriterion("transaction_amount <", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountLessThanOrEqualTo(String value) {
            addCriterion("transaction_amount <=", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountLike(String value) {
            addCriterion("transaction_amount like", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountNotLike(String value) {
            addCriterion("transaction_amount not like", value, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountIn(List<String> values) {
            addCriterion("transaction_amount in", values, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountNotIn(List<String> values) {
            addCriterion("transaction_amount not in", values, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountBetween(String value1, String value2) {
            addCriterion("transaction_amount between", value1, value2, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountNotBetween(String value1, String value2) {
            addCriterion("transaction_amount not between", value1, value2, "transactionAmount");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbIsNull() {
            addCriterion("transaction_amount_plused_rmb is null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbIsNotNull() {
            addCriterion("transaction_amount_plused_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbEqualTo(Long value) {
            addCriterion("transaction_amount_plused_rmb =", value, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbNotEqualTo(Long value) {
            addCriterion("transaction_amount_plused_rmb <>", value, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbGreaterThan(Long value) {
            addCriterion("transaction_amount_plused_rmb >", value, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbGreaterThanOrEqualTo(Long value) {
            addCriterion("transaction_amount_plused_rmb >=", value, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbLessThan(Long value) {
            addCriterion("transaction_amount_plused_rmb <", value, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbLessThanOrEqualTo(Long value) {
            addCriterion("transaction_amount_plused_rmb <=", value, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbIn(List<Long> values) {
            addCriterion("transaction_amount_plused_rmb in", values, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbNotIn(List<Long> values) {
            addCriterion("transaction_amount_plused_rmb not in", values, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbBetween(Long value1, Long value2) {
            addCriterion("transaction_amount_plused_rmb between", value1, value2, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountPlusedRmbNotBetween(Long value1, Long value2) {
            addCriterion("transaction_amount_plused_rmb not between", value1, value2, "transactionAmountPlusedRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdIsNull() {
            addCriterion("transaction_amount_display_usd is null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdIsNotNull() {
            addCriterion("transaction_amount_display_usd is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdEqualTo(String value) {
            addCriterion("transaction_amount_display_usd =", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdNotEqualTo(String value) {
            addCriterion("transaction_amount_display_usd <>", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdGreaterThan(String value) {
            addCriterion("transaction_amount_display_usd >", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_amount_display_usd >=", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdLessThan(String value) {
            addCriterion("transaction_amount_display_usd <", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdLessThanOrEqualTo(String value) {
            addCriterion("transaction_amount_display_usd <=", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdLike(String value) {
            addCriterion("transaction_amount_display_usd like", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdNotLike(String value) {
            addCriterion("transaction_amount_display_usd not like", value, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdIn(List<String> values) {
            addCriterion("transaction_amount_display_usd in", values, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdNotIn(List<String> values) {
            addCriterion("transaction_amount_display_usd not in", values, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdBetween(String value1, String value2) {
            addCriterion("transaction_amount_display_usd between", value1, value2, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayUsdNotBetween(String value1, String value2) {
            addCriterion("transaction_amount_display_usd not between", value1, value2, "transactionAmountDisplayUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbIsNull() {
            addCriterion("transaction_amount_display_rmb is null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbIsNotNull() {
            addCriterion("transaction_amount_display_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbEqualTo(String value) {
            addCriterion("transaction_amount_display_rmb =", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbNotEqualTo(String value) {
            addCriterion("transaction_amount_display_rmb <>", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbGreaterThan(String value) {
            addCriterion("transaction_amount_display_rmb >", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_amount_display_rmb >=", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbLessThan(String value) {
            addCriterion("transaction_amount_display_rmb <", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbLessThanOrEqualTo(String value) {
            addCriterion("transaction_amount_display_rmb <=", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbLike(String value) {
            addCriterion("transaction_amount_display_rmb like", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbNotLike(String value) {
            addCriterion("transaction_amount_display_rmb not like", value, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbIn(List<String> values) {
            addCriterion("transaction_amount_display_rmb in", values, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbNotIn(List<String> values) {
            addCriterion("transaction_amount_display_rmb not in", values, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbBetween(String value1, String value2) {
            addCriterion("transaction_amount_display_rmb between", value1, value2, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountDisplayRmbNotBetween(String value1, String value2) {
            addCriterion("transaction_amount_display_rmb not between", value1, value2, "transactionAmountDisplayRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdIsNull() {
            addCriterion("transaction_amount_real_usd is null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdIsNotNull() {
            addCriterion("transaction_amount_real_usd is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdEqualTo(Long value) {
            addCriterion("transaction_amount_real_usd =", value, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdNotEqualTo(Long value) {
            addCriterion("transaction_amount_real_usd <>", value, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdGreaterThan(Long value) {
            addCriterion("transaction_amount_real_usd >", value, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdGreaterThanOrEqualTo(Long value) {
            addCriterion("transaction_amount_real_usd >=", value, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdLessThan(Long value) {
            addCriterion("transaction_amount_real_usd <", value, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdLessThanOrEqualTo(Long value) {
            addCriterion("transaction_amount_real_usd <=", value, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdIn(List<Long> values) {
            addCriterion("transaction_amount_real_usd in", values, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdNotIn(List<Long> values) {
            addCriterion("transaction_amount_real_usd not in", values, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdBetween(Long value1, Long value2) {
            addCriterion("transaction_amount_real_usd between", value1, value2, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealUsdNotBetween(Long value1, Long value2) {
            addCriterion("transaction_amount_real_usd not between", value1, value2, "transactionAmountRealUsd");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbIsNull() {
            addCriterion("transaction_amount_real_rmb is null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbIsNotNull() {
            addCriterion("transaction_amount_real_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbEqualTo(Long value) {
            addCriterion("transaction_amount_real_rmb =", value, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbNotEqualTo(Long value) {
            addCriterion("transaction_amount_real_rmb <>", value, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbGreaterThan(Long value) {
            addCriterion("transaction_amount_real_rmb >", value, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbGreaterThanOrEqualTo(Long value) {
            addCriterion("transaction_amount_real_rmb >=", value, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbLessThan(Long value) {
            addCriterion("transaction_amount_real_rmb <", value, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbLessThanOrEqualTo(Long value) {
            addCriterion("transaction_amount_real_rmb <=", value, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbIn(List<Long> values) {
            addCriterion("transaction_amount_real_rmb in", values, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbNotIn(List<Long> values) {
            addCriterion("transaction_amount_real_rmb not in", values, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbBetween(Long value1, Long value2) {
            addCriterion("transaction_amount_real_rmb between", value1, value2, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andTransactionAmountRealRmbNotBetween(Long value1, Long value2) {
            addCriterion("transaction_amount_real_rmb not between", value1, value2, "transactionAmountRealRmb");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgIsNull() {
            addCriterion("inquiry_reply_time_avg is null");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgIsNotNull() {
            addCriterion("inquiry_reply_time_avg is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgEqualTo(Integer value) {
            addCriterion("inquiry_reply_time_avg =", value, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgNotEqualTo(Integer value) {
            addCriterion("inquiry_reply_time_avg <>", value, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgGreaterThan(Integer value) {
            addCriterion("inquiry_reply_time_avg >", value, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgGreaterThanOrEqualTo(Integer value) {
            addCriterion("inquiry_reply_time_avg >=", value, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgLessThan(Integer value) {
            addCriterion("inquiry_reply_time_avg <", value, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgLessThanOrEqualTo(Integer value) {
            addCriterion("inquiry_reply_time_avg <=", value, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgIn(List<Integer> values) {
            addCriterion("inquiry_reply_time_avg in", values, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgNotIn(List<Integer> values) {
            addCriterion("inquiry_reply_time_avg not in", values, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgBetween(Integer value1, Integer value2) {
            addCriterion("inquiry_reply_time_avg between", value1, value2, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyTimeAvgNotBetween(Integer value1, Integer value2) {
            addCriterion("inquiry_reply_time_avg not between", value1, value2, "inquiryReplyTimeAvg");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentIsNull() {
            addCriterion("inquiry_reply_percent is null");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentIsNotNull() {
            addCriterion("inquiry_reply_percent is not null");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentEqualTo(String value) {
            addCriterion("inquiry_reply_percent =", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentNotEqualTo(String value) {
            addCriterion("inquiry_reply_percent <>", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentGreaterThan(String value) {
            addCriterion("inquiry_reply_percent >", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentGreaterThanOrEqualTo(String value) {
            addCriterion("inquiry_reply_percent >=", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentLessThan(String value) {
            addCriterion("inquiry_reply_percent <", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentLessThanOrEqualTo(String value) {
            addCriterion("inquiry_reply_percent <=", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentLike(String value) {
            addCriterion("inquiry_reply_percent like", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentNotLike(String value) {
            addCriterion("inquiry_reply_percent not like", value, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentIn(List<String> values) {
            addCriterion("inquiry_reply_percent in", values, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentNotIn(List<String> values) {
            addCriterion("inquiry_reply_percent not in", values, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentBetween(String value1, String value2) {
            addCriterion("inquiry_reply_percent between", value1, value2, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andInquiryReplyPercentNotBetween(String value1, String value2) {
            addCriterion("inquiry_reply_percent not between", value1, value2, "inquiryReplyPercent");
            return (Criteria) this;
        }

        public Criteria andStoreScoreIsNull() {
            addCriterion("store_score is null");
            return (Criteria) this;
        }

        public Criteria andStoreScoreIsNotNull() {
            addCriterion("store_score is not null");
            return (Criteria) this;
        }

        public Criteria andStoreScoreEqualTo(String value) {
            addCriterion("store_score =", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotEqualTo(String value) {
            addCriterion("store_score <>", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreGreaterThan(String value) {
            addCriterion("store_score >", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreGreaterThanOrEqualTo(String value) {
            addCriterion("store_score >=", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreLessThan(String value) {
            addCriterion("store_score <", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreLessThanOrEqualTo(String value) {
            addCriterion("store_score <=", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreLike(String value) {
            addCriterion("store_score like", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotLike(String value) {
            addCriterion("store_score not like", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreIn(List<String> values) {
            addCriterion("store_score in", values, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotIn(List<String> values) {
            addCriterion("store_score not in", values, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreBetween(String value1, String value2) {
            addCriterion("store_score between", value1, value2, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotBetween(String value1, String value2) {
            addCriterion("store_score not between", value1, value2, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvIsNull() {
            addCriterion("store_goods_pv is null");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvIsNotNull() {
            addCriterion("store_goods_pv is not null");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvEqualTo(Integer value) {
            addCriterion("store_goods_pv =", value, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvNotEqualTo(Integer value) {
            addCriterion("store_goods_pv <>", value, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvGreaterThan(Integer value) {
            addCriterion("store_goods_pv >", value, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_goods_pv >=", value, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvLessThan(Integer value) {
            addCriterion("store_goods_pv <", value, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvLessThanOrEqualTo(Integer value) {
            addCriterion("store_goods_pv <=", value, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvIn(List<Integer> values) {
            addCriterion("store_goods_pv in", values, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvNotIn(List<Integer> values) {
            addCriterion("store_goods_pv not in", values, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvBetween(Integer value1, Integer value2) {
            addCriterion("store_goods_pv between", value1, value2, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStoreGoodsPvNotBetween(Integer value1, Integer value2) {
            addCriterion("store_goods_pv not between", value1, value2, "storeGoodsPv");
            return (Criteria) this;
        }

        public Criteria andStorePvIsNull() {
            addCriterion("store_pv is null");
            return (Criteria) this;
        }

        public Criteria andStorePvIsNotNull() {
            addCriterion("store_pv is not null");
            return (Criteria) this;
        }

        public Criteria andStorePvEqualTo(Integer value) {
            addCriterion("store_pv =", value, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvNotEqualTo(Integer value) {
            addCriterion("store_pv <>", value, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvGreaterThan(Integer value) {
            addCriterion("store_pv >", value, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_pv >=", value, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvLessThan(Integer value) {
            addCriterion("store_pv <", value, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvLessThanOrEqualTo(Integer value) {
            addCriterion("store_pv <=", value, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvIn(List<Integer> values) {
            addCriterion("store_pv in", values, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvNotIn(List<Integer> values) {
            addCriterion("store_pv not in", values, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvBetween(Integer value1, Integer value2) {
            addCriterion("store_pv between", value1, value2, "storePv");
            return (Criteria) this;
        }

        public Criteria andStorePvNotBetween(Integer value1, Integer value2) {
            addCriterion("store_pv not between", value1, value2, "storePv");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(Date value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(Date value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(Date value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(Date value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<Date> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<Date> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(Date value1, Date value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
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

        public Criteria andProductPresentationIsNull() {
            addCriterion("product_presentation is null");
            return (Criteria) this;
        }

        public Criteria andProductPresentationIsNotNull() {
            addCriterion("product_presentation is not null");
            return (Criteria) this;
        }

        public Criteria andProductPresentationEqualTo(String value) {
            addCriterion("product_presentation =", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationNotEqualTo(String value) {
            addCriterion("product_presentation <>", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationGreaterThan(String value) {
            addCriterion("product_presentation >", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationGreaterThanOrEqualTo(String value) {
            addCriterion("product_presentation >=", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationLessThan(String value) {
            addCriterion("product_presentation <", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationLessThanOrEqualTo(String value) {
            addCriterion("product_presentation <=", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationLike(String value) {
            addCriterion("product_presentation like", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationNotLike(String value) {
            addCriterion("product_presentation not like", value, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationIn(List<String> values) {
            addCriterion("product_presentation in", values, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationNotIn(List<String> values) {
            addCriterion("product_presentation not in", values, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationBetween(String value1, String value2) {
            addCriterion("product_presentation between", value1, value2, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andProductPresentationNotBetween(String value1, String value2) {
            addCriterion("product_presentation not between", value1, value2, "productPresentation");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNull() {
            addCriterion("country_id is null");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNotNull() {
            addCriterion("country_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIdEqualTo(Integer value) {
            addCriterion("country_id =", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotEqualTo(Integer value) {
            addCriterion("country_id <>", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThan(Integer value) {
            addCriterion("country_id >", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("country_id >=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThan(Integer value) {
            addCriterion("country_id <", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThanOrEqualTo(Integer value) {
            addCriterion("country_id <=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIn(List<Integer> values) {
            addCriterion("country_id in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotIn(List<Integer> values) {
            addCriterion("country_id not in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdBetween(Integer value1, Integer value2) {
            addCriterion("country_id between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("country_id not between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNull() {
            addCriterion("country_name is null");
            return (Criteria) this;
        }

        public Criteria andCountryNameIsNotNull() {
            addCriterion("country_name is not null");
            return (Criteria) this;
        }

        public Criteria andCountryNameEqualTo(String value) {
            addCriterion("country_name =", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotEqualTo(String value) {
            addCriterion("country_name <>", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThan(String value) {
            addCriterion("country_name >", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameGreaterThanOrEqualTo(String value) {
            addCriterion("country_name >=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThan(String value) {
            addCriterion("country_name <", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLessThanOrEqualTo(String value) {
            addCriterion("country_name <=", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameLike(String value) {
            addCriterion("country_name like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotLike(String value) {
            addCriterion("country_name not like", value, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameIn(List<String> values) {
            addCriterion("country_name in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotIn(List<String> values) {
            addCriterion("country_name not in", values, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameBetween(String value1, String value2) {
            addCriterion("country_name between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andCountryNameNotBetween(String value1, String value2) {
            addCriterion("country_name not between", value1, value2, "countryName");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedIsNull() {
            addCriterion("ciq_validated is null");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedIsNotNull() {
            addCriterion("ciq_validated is not null");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedEqualTo(Boolean value) {
            addCriterion("ciq_validated =", value, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedNotEqualTo(Boolean value) {
            addCriterion("ciq_validated <>", value, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedGreaterThan(Boolean value) {
            addCriterion("ciq_validated >", value, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ciq_validated >=", value, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedLessThan(Boolean value) {
            addCriterion("ciq_validated <", value, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedLessThanOrEqualTo(Boolean value) {
            addCriterion("ciq_validated <=", value, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedIn(List<Boolean> values) {
            addCriterion("ciq_validated in", values, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedNotIn(List<Boolean> values) {
            addCriterion("ciq_validated not in", values, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedBetween(Boolean value1, Boolean value2) {
            addCriterion("ciq_validated between", value1, value2, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCiqValidatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ciq_validated not between", value1, value2, "ciqValidated");
            return (Criteria) this;
        }

        public Criteria andCorpProductIsNull() {
            addCriterion("corp_product is null");
            return (Criteria) this;
        }

        public Criteria andCorpProductIsNotNull() {
            addCriterion("corp_product is not null");
            return (Criteria) this;
        }

        public Criteria andCorpProductEqualTo(String value) {
            addCriterion("corp_product =", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductNotEqualTo(String value) {
            addCriterion("corp_product <>", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductGreaterThan(String value) {
            addCriterion("corp_product >", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductGreaterThanOrEqualTo(String value) {
            addCriterion("corp_product >=", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductLessThan(String value) {
            addCriterion("corp_product <", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductLessThanOrEqualTo(String value) {
            addCriterion("corp_product <=", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductLike(String value) {
            addCriterion("corp_product like", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductNotLike(String value) {
            addCriterion("corp_product not like", value, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductIn(List<String> values) {
            addCriterion("corp_product in", values, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductNotIn(List<String> values) {
            addCriterion("corp_product not in", values, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductBetween(String value1, String value2) {
            addCriterion("corp_product between", value1, value2, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andCorpProductNotBetween(String value1, String value2) {
            addCriterion("corp_product not between", value1, value2, "corpProduct");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNull() {
            addCriterion("pay_way is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("pay_way is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(String value) {
            addCriterion("pay_way =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(String value) {
            addCriterion("pay_way <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(String value) {
            addCriterion("pay_way >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(String value) {
            addCriterion("pay_way <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(String value) {
            addCriterion("pay_way <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLike(String value) {
            addCriterion("pay_way like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotLike(String value) {
            addCriterion("pay_way not like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<String> values) {
            addCriterion("pay_way in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<String> values) {
            addCriterion("pay_way not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(String value1, String value2) {
            addCriterion("pay_way between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(String value1, String value2) {
            addCriterion("pay_way not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andIsCpIsNull() {
            addCriterion("is_cp is null");
            return (Criteria) this;
        }

        public Criteria andIsCpIsNotNull() {
            addCriterion("is_cp is not null");
            return (Criteria) this;
        }

        public Criteria andIsCpEqualTo(Boolean value) {
            addCriterion("is_cp =", value, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpNotEqualTo(Boolean value) {
            addCriterion("is_cp <>", value, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpGreaterThan(Boolean value) {
            addCriterion("is_cp >", value, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_cp >=", value, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpLessThan(Boolean value) {
            addCriterion("is_cp <", value, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpLessThanOrEqualTo(Boolean value) {
            addCriterion("is_cp <=", value, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpIn(List<Boolean> values) {
            addCriterion("is_cp in", values, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpNotIn(List<Boolean> values) {
            addCriterion("is_cp not in", values, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cp between", value1, value2, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cp not between", value1, value2, "isCp");
            return (Criteria) this;
        }

        public Criteria andIsCpTtIsNull() {
            addCriterion("is_cp_tt is null");
            return (Criteria) this;
        }

        public Criteria andIsCpTtIsNotNull() {
            addCriterion("is_cp_tt is not null");
            return (Criteria) this;
        }

        public Criteria andIsCpTtEqualTo(Boolean value) {
            addCriterion("is_cp_tt =", value, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtNotEqualTo(Boolean value) {
            addCriterion("is_cp_tt <>", value, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtGreaterThan(Boolean value) {
            addCriterion("is_cp_tt >", value, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_cp_tt >=", value, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtLessThan(Boolean value) {
            addCriterion("is_cp_tt <", value, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtLessThanOrEqualTo(Boolean value) {
            addCriterion("is_cp_tt <=", value, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtIn(List<Boolean> values) {
            addCriterion("is_cp_tt in", values, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtNotIn(List<Boolean> values) {
            addCriterion("is_cp_tt not in", values, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cp_tt between", value1, value2, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andIsCpTtNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cp_tt not between", value1, value2, "isCpTt");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountIsNull() {
            addCriterion("goods_released_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountIsNotNull() {
            addCriterion("goods_released_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountEqualTo(Integer value) {
            addCriterion("goods_released_count =", value, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountNotEqualTo(Integer value) {
            addCriterion("goods_released_count <>", value, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountGreaterThan(Integer value) {
            addCriterion("goods_released_count >", value, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_released_count >=", value, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountLessThan(Integer value) {
            addCriterion("goods_released_count <", value, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_released_count <=", value, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountIn(List<Integer> values) {
            addCriterion("goods_released_count in", values, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountNotIn(List<Integer> values) {
            addCriterion("goods_released_count not in", values, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountBetween(Integer value1, Integer value2) {
            addCriterion("goods_released_count between", value1, value2, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andGoodsReleasedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_released_count not between", value1, value2, "goodsReleasedCount");
            return (Criteria) this;
        }

        public Criteria andCorpLogoIsNull() {
            addCriterion("corp_logo is null");
            return (Criteria) this;
        }

        public Criteria andCorpLogoIsNotNull() {
            addCriterion("corp_logo is not null");
            return (Criteria) this;
        }

        public Criteria andCorpLogoEqualTo(String value) {
            addCriterion("corp_logo =", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotEqualTo(String value) {
            addCriterion("corp_logo <>", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoGreaterThan(String value) {
            addCriterion("corp_logo >", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoGreaterThanOrEqualTo(String value) {
            addCriterion("corp_logo >=", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoLessThan(String value) {
            addCriterion("corp_logo <", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoLessThanOrEqualTo(String value) {
            addCriterion("corp_logo <=", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoLike(String value) {
            addCriterion("corp_logo like", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotLike(String value) {
            addCriterion("corp_logo not like", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoIn(List<String> values) {
            addCriterion("corp_logo in", values, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotIn(List<String> values) {
            addCriterion("corp_logo not in", values, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoBetween(String value1, String value2) {
            addCriterion("corp_logo between", value1, value2, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotBetween(String value1, String value2) {
            addCriterion("corp_logo not between", value1, value2, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdIsNull() {
            addCriterion("customer_service_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdIsNotNull() {
            addCriterion("customer_service_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdEqualTo(Integer value) {
            addCriterion("customer_service_manager_id =", value, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdNotEqualTo(Integer value) {
            addCriterion("customer_service_manager_id <>", value, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdGreaterThan(Integer value) {
            addCriterion("customer_service_manager_id >", value, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_service_manager_id >=", value, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdLessThan(Integer value) {
            addCriterion("customer_service_manager_id <", value, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_service_manager_id <=", value, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdIn(List<Integer> values) {
            addCriterion("customer_service_manager_id in", values, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdNotIn(List<Integer> values) {
            addCriterion("customer_service_manager_id not in", values, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_service_manager_id between", value1, value2, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_service_manager_id not between", value1, value2, "customerServiceManagerId");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameIsNull() {
            addCriterion("customer_service_manager_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameIsNotNull() {
            addCriterion("customer_service_manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameEqualTo(String value) {
            addCriterion("customer_service_manager_name =", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameNotEqualTo(String value) {
            addCriterion("customer_service_manager_name <>", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameGreaterThan(String value) {
            addCriterion("customer_service_manager_name >", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_service_manager_name >=", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameLessThan(String value) {
            addCriterion("customer_service_manager_name <", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_service_manager_name <=", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameLike(String value) {
            addCriterion("customer_service_manager_name like", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameNotLike(String value) {
            addCriterion("customer_service_manager_name not like", value, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameIn(List<String> values) {
            addCriterion("customer_service_manager_name in", values, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameNotIn(List<String> values) {
            addCriterion("customer_service_manager_name not in", values, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameBetween(String value1, String value2) {
            addCriterion("customer_service_manager_name between", value1, value2, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andCustomerServiceManagerNameNotBetween(String value1, String value2) {
            addCriterion("customer_service_manager_name not between", value1, value2, "customerServiceManagerName");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIsNull() {
            addCriterion("operate_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIsNotNull() {
            addCriterion("operate_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdEqualTo(Integer value) {
            addCriterion("operate_user_id =", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotEqualTo(Integer value) {
            addCriterion("operate_user_id <>", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdGreaterThan(Integer value) {
            addCriterion("operate_user_id >", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operate_user_id >=", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdLessThan(Integer value) {
            addCriterion("operate_user_id <", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("operate_user_id <=", value, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdIn(List<Integer> values) {
            addCriterion("operate_user_id in", values, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotIn(List<Integer> values) {
            addCriterion("operate_user_id not in", values, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("operate_user_id between", value1, value2, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operate_user_id not between", value1, value2, "operateUserId");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameIsNull() {
            addCriterion("operate_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameIsNotNull() {
            addCriterion("operate_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameEqualTo(String value) {
            addCriterion("operate_user_name =", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameNotEqualTo(String value) {
            addCriterion("operate_user_name <>", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameGreaterThan(String value) {
            addCriterion("operate_user_name >", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("operate_user_name >=", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameLessThan(String value) {
            addCriterion("operate_user_name <", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameLessThanOrEqualTo(String value) {
            addCriterion("operate_user_name <=", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameLike(String value) {
            addCriterion("operate_user_name like", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameNotLike(String value) {
            addCriterion("operate_user_name not like", value, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameIn(List<String> values) {
            addCriterion("operate_user_name in", values, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameNotIn(List<String> values) {
            addCriterion("operate_user_name not in", values, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameBetween(String value1, String value2) {
            addCriterion("operate_user_name between", value1, value2, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateUserNameNotBetween(String value1, String value2) {
            addCriterion("operate_user_name not between", value1, value2, "operateUserName");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNull() {
            addCriterion("operate_time is null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIsNotNull() {
            addCriterion("operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperateTimeEqualTo(Date value) {
            addCriterion("operate_time =", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotEqualTo(Date value) {
            addCriterion("operate_time <>", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThan(Date value) {
            addCriterion("operate_time >", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operate_time >=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThan(Date value) {
            addCriterion("operate_time <", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("operate_time <=", value, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeIn(List<Date> values) {
            addCriterion("operate_time in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotIn(List<Date> values) {
            addCriterion("operate_time not in", values, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeBetween(Date value1, Date value2) {
            addCriterion("operate_time between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("operate_time not between", value1, value2, "operateTime");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginIsNull() {
            addCriterion("rectify_time_begin is null");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginIsNotNull() {
            addCriterion("rectify_time_begin is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginEqualTo(Date value) {
            addCriterion("rectify_time_begin =", value, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginNotEqualTo(Date value) {
            addCriterion("rectify_time_begin <>", value, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginGreaterThan(Date value) {
            addCriterion("rectify_time_begin >", value, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginGreaterThanOrEqualTo(Date value) {
            addCriterion("rectify_time_begin >=", value, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginLessThan(Date value) {
            addCriterion("rectify_time_begin <", value, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginLessThanOrEqualTo(Date value) {
            addCriterion("rectify_time_begin <=", value, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginIn(List<Date> values) {
            addCriterion("rectify_time_begin in", values, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginNotIn(List<Date> values) {
            addCriterion("rectify_time_begin not in", values, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginBetween(Date value1, Date value2) {
            addCriterion("rectify_time_begin between", value1, value2, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeBeginNotBetween(Date value1, Date value2) {
            addCriterion("rectify_time_begin not between", value1, value2, "rectifyTimeBegin");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndIsNull() {
            addCriterion("rectify_time_end is null");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndIsNotNull() {
            addCriterion("rectify_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndEqualTo(Date value) {
            addCriterion("rectify_time_end =", value, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndNotEqualTo(Date value) {
            addCriterion("rectify_time_end <>", value, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndGreaterThan(Date value) {
            addCriterion("rectify_time_end >", value, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("rectify_time_end >=", value, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndLessThan(Date value) {
            addCriterion("rectify_time_end <", value, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("rectify_time_end <=", value, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndIn(List<Date> values) {
            addCriterion("rectify_time_end in", values, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndNotIn(List<Date> values) {
            addCriterion("rectify_time_end not in", values, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndBetween(Date value1, Date value2) {
            addCriterion("rectify_time_end between", value1, value2, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andRectifyTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("rectify_time_end not between", value1, value2, "rectifyTimeEnd");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeIsNull() {
            addCriterion("charge_expired_time is null");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeIsNotNull() {
            addCriterion("charge_expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeEqualTo(Date value) {
            addCriterion("charge_expired_time =", value, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeNotEqualTo(Date value) {
            addCriterion("charge_expired_time <>", value, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeGreaterThan(Date value) {
            addCriterion("charge_expired_time >", value, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("charge_expired_time >=", value, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeLessThan(Date value) {
            addCriterion("charge_expired_time <", value, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeLessThanOrEqualTo(Date value) {
            addCriterion("charge_expired_time <=", value, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeIn(List<Date> values) {
            addCriterion("charge_expired_time in", values, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeNotIn(List<Date> values) {
            addCriterion("charge_expired_time not in", values, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeBetween(Date value1, Date value2) {
            addCriterion("charge_expired_time between", value1, value2, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andChargeExpiredTimeNotBetween(Date value1, Date value2) {
            addCriterion("charge_expired_time not between", value1, value2, "chargeExpiredTime");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeIsNull() {
            addCriterion("status_notice is null");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeIsNotNull() {
            addCriterion("status_notice is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeEqualTo(Boolean value) {
            addCriterion("status_notice =", value, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeNotEqualTo(Boolean value) {
            addCriterion("status_notice <>", value, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeGreaterThan(Boolean value) {
            addCriterion("status_notice >", value, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status_notice >=", value, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeLessThan(Boolean value) {
            addCriterion("status_notice <", value, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeLessThanOrEqualTo(Boolean value) {
            addCriterion("status_notice <=", value, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeIn(List<Boolean> values) {
            addCriterion("status_notice in", values, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeNotIn(List<Boolean> values) {
            addCriterion("status_notice not in", values, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeBetween(Boolean value1, Boolean value2) {
            addCriterion("status_notice between", value1, value2, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andStatusNoticeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status_notice not between", value1, value2, "statusNotice");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeIsNull() {
            addCriterion("notice_submit_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeIsNotNull() {
            addCriterion("notice_submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeEqualTo(Date value) {
            addCriterion("notice_submit_time =", value, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeNotEqualTo(Date value) {
            addCriterion("notice_submit_time <>", value, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeGreaterThan(Date value) {
            addCriterion("notice_submit_time >", value, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_submit_time >=", value, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeLessThan(Date value) {
            addCriterion("notice_submit_time <", value, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("notice_submit_time <=", value, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeIn(List<Date> values) {
            addCriterion("notice_submit_time in", values, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeNotIn(List<Date> values) {
            addCriterion("notice_submit_time not in", values, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("notice_submit_time between", value1, value2, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("notice_submit_time not between", value1, value2, "noticeSubmitTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeIsNull() {
            addCriterion("notice_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeIsNotNull() {
            addCriterion("notice_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeEqualTo(Date value) {
            addCriterion("notice_begin_time =", value, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeNotEqualTo(Date value) {
            addCriterion("notice_begin_time <>", value, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeGreaterThan(Date value) {
            addCriterion("notice_begin_time >", value, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_begin_time >=", value, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeLessThan(Date value) {
            addCriterion("notice_begin_time <", value, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("notice_begin_time <=", value, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeIn(List<Date> values) {
            addCriterion("notice_begin_time in", values, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeNotIn(List<Date> values) {
            addCriterion("notice_begin_time not in", values, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeBetween(Date value1, Date value2) {
            addCriterion("notice_begin_time between", value1, value2, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("notice_begin_time not between", value1, value2, "noticeBeginTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeIsNull() {
            addCriterion("notice_end_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeIsNotNull() {
            addCriterion("notice_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeEqualTo(Date value) {
            addCriterion("notice_end_time =", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeNotEqualTo(Date value) {
            addCriterion("notice_end_time <>", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeGreaterThan(Date value) {
            addCriterion("notice_end_time >", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_end_time >=", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeLessThan(Date value) {
            addCriterion("notice_end_time <", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("notice_end_time <=", value, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeIn(List<Date> values) {
            addCriterion("notice_end_time in", values, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeNotIn(List<Date> values) {
            addCriterion("notice_end_time not in", values, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeBetween(Date value1, Date value2) {
            addCriterion("notice_end_time between", value1, value2, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("notice_end_time not between", value1, value2, "noticeEndTime");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeIsNull() {
            addCriterion("notice_submit_user_type is null");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeIsNotNull() {
            addCriterion("notice_submit_user_type is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeEqualTo(Boolean value) {
            addCriterion("notice_submit_user_type =", value, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeNotEqualTo(Boolean value) {
            addCriterion("notice_submit_user_type <>", value, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeGreaterThan(Boolean value) {
            addCriterion("notice_submit_user_type >", value, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("notice_submit_user_type >=", value, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeLessThan(Boolean value) {
            addCriterion("notice_submit_user_type <", value, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("notice_submit_user_type <=", value, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeIn(List<Boolean> values) {
            addCriterion("notice_submit_user_type in", values, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeNotIn(List<Boolean> values) {
            addCriterion("notice_submit_user_type not in", values, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("notice_submit_user_type between", value1, value2, "noticeSubmitUserType");
            return (Criteria) this;
        }

        public Criteria andNoticeSubmitUserTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("notice_submit_user_type not between", value1, value2, "noticeSubmitUserType");
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