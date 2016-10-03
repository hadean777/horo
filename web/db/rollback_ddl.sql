-- TABLES

DROP TABLE CURRENT_STATUS;
DROP TABLE STATUS_HISTORY;
DROP TABLE HORO_TEXT;
DROP TABLE HORO_TYPE;
DROP TABLE SIGN;

-- SEQUENCES

DROP SEQUENCE SIGN_SEQ;
DROP SEQUENCE HORO_TYPE_SEQ;
DROP SEQUENCE HORO_TEXT_SEQ;
DROP SEQUENCE STATUS_HISTORY_SEQ;
DROP SEQUENCE CURRENT_STATUS_SEQ;

-- FUNCTIONS

DROP FUNCTION UPDATE_PROC();
