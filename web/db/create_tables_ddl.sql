-- SEQUENCES

CREATE SEQUENCE SIGN_SEQ
	START WITH 1 
	INCREMENT BY 1 
	NO MAXVALUE
;
CREATE SEQUENCE HORO_TYPE_SEQ
	START WITH 1 
	INCREMENT BY 1 
	NO MAXVALUE
;
CREATE SEQUENCE HORO_TEXT_SEQ
	START WITH 1 
	INCREMENT BY 1 
	NO MAXVALUE
;
CREATE SEQUENCE STATUS_HISTORY_SEQ
	START WITH 1 
	INCREMENT BY 1 
	NO MAXVALUE
;
CREATE SEQUENCE CURRENT_STATUS_SEQ
	START WITH 1 
	INCREMENT BY 1 
	NO MAXVALUE
;

-- TABLES

CREATE TABLE SIGN (
	SIGN_ID		BIGINT NOT NULL DEFAULT NEXTVAL('SIGN_SEQ'),
	NAME		VARCHAR(20) NOT NULL,
	DISPLAY_NAME	VARCHAR(20) NOT NULL,
	DESCRIPTION	TEXT NOT NULL,
	START_DAY	SMALLINT NOT NULL,
	START_MONTH	SMALLINT NOT NULL,
	END_DAY		SMALLINT NOT NULL,
	END_MONTH	SMALLINT NOT NULL,
	ADDED_TS	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	MODIFIED_TS	TIMESTAMP	
);

CREATE TABLE HORO_TYPE (
	HORO_TYPE_ID	BIGINT NOT NULL DEFAULT NEXTVAL('HORO_TYPE_SEQ'),
	NAME		VARCHAR(20) NOT NULL,
	DESCRIPTION	TEXT,
	ADDED_TS	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	MODIFIED_TS	TIMESTAMP	
);

CREATE TABLE HORO_TEXT (
	HORO_TEXT_ID	BIGINT NOT NULL DEFAULT NEXTVAL('HORO_TEXT_SEQ'),
	HORO_TYPE_ID	BIGINT NOT NULL,
	SIGN_ID		BIGINT,
	ASSIGNED_DATE	DATE,
	BODY		TEXT,
	BUSINESS	SMALLINT,
	LOVE		SMALLINT,
	HEALTH		SMALLINT,
	APPROVED	BOOLEAN NOT NULL DEFAULT FALSE,
	SHOW_NUMBER	BIGINT NOT NULL DEFAULT 0,
	LAST_SHOW_DATE	DATE,
	ADDED_TS	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	MODIFIED_TS	TIMESTAMP	
);

CREATE TABLE STATUS_HISTORY (
	STATUS_HISTORY_ID	BIGINT NOT NULL DEFAULT NEXTVAL('STATUS_HISTORY_SEQ'),
	ASSIGNED_DATE	DATE NOT NULL,
	HORO_TYPE_ID	BIGINT NOT NULL,
	HORO_TEXT_ID	BIGINT NOT NULL,
	SIGN_ID		BIGINT NOT NULL,
	ADDED_TS	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	MODIFIED_TS	TIMESTAMP	
);

CREATE TABLE CURRENT_STATUS (
	CURRENT_STATUS_ID	BIGINT NOT NULL DEFAULT NEXTVAL('CURRENT_STATUS_SEQ'),
	ASSIGNED_DATE	DATE NOT NULL,
	HORO_TYPE_ID	BIGINT NOT NULL,
	ARIES		BIGINT NOT NULL,
	TAURUS		BIGINT NOT NULL,
	GEMINI		BIGINT NOT NULL,
	CANCER		BIGINT NOT NULL,
	LEO		BIGINT NOT NULL,
	VIRGO		BIGINT NOT NULL,
	LIBRA		BIGINT NOT NULL,
	SCORPIO		BIGINT NOT NULL,
	SAGITTARIUS	BIGINT NOT NULL,
	CAPRICORN	BIGINT NOT NULL,
	AQUARIUS	BIGINT NOT NULL,
	PIESCES		BIGINT NOT NULL,
	ADDED_TS	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	MODIFIED_TS	TIMESTAMP	
);



-- CONSTRAINTS

ALTER TABLE SIGN ADD CONSTRAINT PK_SIGN PRIMARY KEY (SIGN_ID)
;
ALTER TABLE HORO_TYPE ADD CONSTRAINT PK_HORO_TYPE PRIMARY KEY (HORO_TYPE_ID)
;
ALTER TABLE HORO_TEXT ADD CONSTRAINT PK_HORO_TEXT PRIMARY KEY (HORO_TEXT_ID)
;
ALTER TABLE STATUS_HISTORY ADD CONSTRAINT PK_STATUS_HISTORY PRIMARY KEY (STATUS_HISTORY_ID)
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT PK_CURRENT_STATUS PRIMARY KEY (CURRENT_STATUS_ID)
;


ALTER TABLE HORO_TEXT ADD CONSTRAINT FK_HORO_TEXT_HORO_TYPE
    FOREIGN KEY ( HORO_TYPE_ID ) REFERENCES HORO_TYPE ( HORO_TYPE_ID )
;
ALTER TABLE STATUS_HISTORY ADD CONSTRAINT FK_STATUS_HISTORY_HORO_TYPE
    FOREIGN KEY ( HORO_TYPE_ID ) REFERENCES HORO_TYPE ( HORO_TYPE_ID )
;
ALTER TABLE STATUS_HISTORY ADD CONSTRAINT FK_STATUS_HISTORY_HORO_TEXT
    FOREIGN KEY ( HORO_TEXT_ID ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE STATUS_HISTORY ADD CONSTRAINT FK_STATUS_HISTORY_SIGN
    FOREIGN KEY ( SIGN_ID ) REFERENCES SIGN ( SIGN_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_HORO_TYPE
    FOREIGN KEY ( HORO_TYPE_ID ) REFERENCES HORO_TYPE ( HORO_TYPE_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_ARIES
    FOREIGN KEY ( ARIES ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_TAURUS
    FOREIGN KEY ( TAURUS ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_GEMINI
    FOREIGN KEY ( GEMINI ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_CANCER
    FOREIGN KEY ( CANCER ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_LEO
    FOREIGN KEY ( LEO ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_VIRGO
    FOREIGN KEY ( VIRGO ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_LIBRA
    FOREIGN KEY ( LIBRA ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_SCORPIO
    FOREIGN KEY ( SCORPIO ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_SAGITTARIUS
    FOREIGN KEY ( SAGITTARIUS ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_CAPRICORN
    FOREIGN KEY ( CAPRICORN ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_AQUARIUS
    FOREIGN KEY ( AQUARIUS ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;
ALTER TABLE CURRENT_STATUS ADD CONSTRAINT FK_CURRENT_STATUS_PIESCES
    FOREIGN KEY ( PIESCES ) REFERENCES HORO_TEXT ( HORO_TEXT_ID )
;

-- TRIGGERS

CREATE OR REPLACE FUNCTION UPDATE_PROC() RETURNS TRIGGER AS $BODY$
    BEGIN
	IF (TG_OP = 'UPDATE') THEN
	      SELECT CURRENT_TIMESTAMP INTO NEW.MODIFIED_TS;
	END IF;
	RETURN NEW;
    END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER SIGN_UPD_TRG
 BEFORE UPDATE ON SIGN
 FOR EACH ROW EXECUTE PROCEDURE UPDATE_PROC();

CREATE TRIGGER HORO_TYPE_UPD_TRG
 BEFORE UPDATE ON HORO_TYPE
 FOR EACH ROW EXECUTE PROCEDURE UPDATE_PROC();

CREATE TRIGGER HORO_TEXT_UPD_TRG
 BEFORE UPDATE ON HORO_TEXT
 FOR EACH ROW EXECUTE PROCEDURE UPDATE_PROC();

CREATE TRIGGER STATUS_HISTORY_UPD_TRG
 BEFORE UPDATE ON STATUS_HISTORY
 FOR EACH ROW EXECUTE PROCEDURE UPDATE_PROC();

CREATE TRIGGER CURRENT_STATUS_UPD_TRG
 BEFORE UPDATE ON CURRENT_STATUS
 FOR EACH ROW EXECUTE PROCEDURE UPDATE_PROC();


-- INDEXES

CREATE INDEX IX_FK_HORO_TEXT_HORO_TYPE ON HORO_TEXT ( HORO_TEXT_ID )
;
CREATE INDEX IX_FK_STATUS_HISTORY_HORO_TYPE ON STATUS_HISTORY ( HORO_TYPE_ID )
;
CREATE INDEX IX_FK_STATUS_HISTORY_HORO_TEXT ON STATUS_HISTORY ( HORO_TEXT_ID )
;
CREATE INDEX IX_FK_STATUS_HISTORY_SIGN ON STATUS_HISTORY ( SIGN_ID )
;
CREATE INDEX IX_FK_CURRENT_STATUS_ARIES ON CURRENT_STATUS ( ARIES )
;
CREATE INDEX IX_FK_CURRENT_STATUS_TAURUS ON CURRENT_STATUS ( TAURUS )
;
CREATE INDEX IX_FK_CURRENT_STATUS_GEMINI ON CURRENT_STATUS ( GEMINI )
;
CREATE INDEX IX_FK_CURRENT_STATUS_CANCER ON CURRENT_STATUS ( CANCER )
;
CREATE INDEX IX_FK_CURRENT_STATUS_LEO ON CURRENT_STATUS ( LEO )
;
CREATE INDEX IX_FK_CURRENT_STATUS_VIRGO ON CURRENT_STATUS ( VIRGO )
;
CREATE INDEX IX_FK_CURRENT_STATUS_LIBRA ON CURRENT_STATUS ( LIBRA )
;
CREATE INDEX IX_FK_CURRENT_STATUS_SCORPIO ON CURRENT_STATUS ( SCORPIO )
;
CREATE INDEX IX_FK_CURRENT_STATUS_SAGITTARIUS ON CURRENT_STATUS ( SAGITTARIUS )
;
CREATE INDEX IX_FK_CURRENT_STATUS_CAPRICORN ON CURRENT_STATUS ( CAPRICORN )
;
CREATE INDEX IX_FK_CURRENT_STATUS_AQUARIUS ON CURRENT_STATUS ( AQUARIUS )
;
CREATE INDEX IX_FK_CURRENT_STATUS_PIESCES ON CURRENT_STATUS ( PIESCES )
;
CREATE UNIQUE INDEX UN_SIGN_NAME ON SIGN ( UPPER( NAME ) )
;
CREATE UNIQUE INDEX UN_HORO_TYPE_NAME ON HORO_TYPE ( UPPER( NAME ) )
;
