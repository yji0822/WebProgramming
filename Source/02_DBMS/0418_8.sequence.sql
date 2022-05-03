
 -- [VIII] SEQUENCE :  ������ȣ ������
 --        ��κ� �������� PK ��� �뵵. �ǹ̰� �ִ°� �ƴ� �׳� ���������� ����ϴ� ��
 
 -- ���̺��� ���鶧 PRIMARY KEY�� ����ϱ� ����!
 -- FRIEND_SEQ��� SEQUENCE�� �����ϴ� �� / DDL : ��ҺҰ���
 -- DDL�� �ѹ� �����Ҷ����� ������ ����ȴ�.
 -- START WITH : ����Ʈ�� = 1! (����)
 -- INCREMENT BY : ����Ʈ�� 1, ���� ** ��? 1�� �����Ѵ�.
 -- SEQUENCE�� ��ȣŸ���� 4�ڸ��� �س��Ҵٸ� 9999������ �����ϴ�
 -- *** NOCACHE : ĳ�� �޸𸮿� �ƹ��͵� ������ �ʴ� �� / �밳 18�� �׾Ƴ��� ***
                -- �س��� ������ ���ڱ� 20�� ��ȣ�� ƥ �� ����
 -- *** NOCYCLE : MAXVALUE�� �� ���ư��� ���� 1�� ���ư��� ���� �ƴϰ� ������ �߻��ϴ� ��
 -- MAXVALUE : �����س��� �ʾ����� 38�ڸ� ���ڱ��� ����ؼ� �����ȴ�.
    DROP SEQUENCE FRIEND_SEQ;
    CREATE SEQUENCE FRIEND_SEQ
        START WITH 1
        INCREMENT BY 1
        MAXVALUE 9999
        MINVALUE 1
        NOCACHE
        NOCYCLE;
    
    CREATE SEQUENCE FRIEND_SEQ 
        MAXVALUE 9999; -- 1���� 1���� �����Ǵµ� MAX ���ڴ� 9999!
    
    SELECT FRIEND_SEQ.NEXTVAL FROM DUAL; -- �����Ҷ����� 1�� ������ �Ǵ� ��
    
    -- SEQUENCE ���� �� ����
    DROP SEQUENCE FRIEND_SEQ;
    CREATE SEQUENCE FRIEND_SEQ
        MAXVALUE 9999
        NOCACHE
        NOCYCLE;
        
    DROP TABLE FRIEND;
    CREATE TABLE FRIEND(
        NUM     NUMBER(4)    PRIMARY KEY, -- ������ �̿� MAXVALUE�� Ÿ���� ��ġ �����ش�!!
        NAME    VARCHAR2(30) NOT NULL, -- NULL �Է��ϸ� �ȵ�
        TEL     VARCHAR2(30) UNIQUE,  -- ��ȭ��ȣ�� �ߺ��� �ȵ�! NULL ���
        ADDRESS VARCHAR2(300),
        LAST_MODIFYED DATE DEFAULT SYSDATE -- �ֱ� ������ ��¥�� ����Ʈ���� ���� ��¥
        );
    
    INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
        VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', NULL, '����� ��걸'); -- 3�� ����
        
    SELECT * FROM FRIEND;
    
    INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
        VALUES (FRIEND_SEQ.NEXTVAL, '�ڱ浿', '010-9999-9999', '����� ������ �������94�� 13 ������ 402');
    -- 
    SELECT * FROM FRIEND;
    
    -- NUM���� 6���� ����� �ǰ� ��
    INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
        VALUES(FRIEND_SEQ.NEXTVAL, '�ű浿', '010-8888-8888', '����� ��������');
    
    -- 
    SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- ���� ������ ��
    COMMIT;
    
    -- EX. �ʱⰪ 101���� �ִ밪 999,999���� 1�� �����ϴ� TEST_SEQ �������� ����
    CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
    SELECT TEST_SEQ.CURRVAL FROM DUAL; -- �������� ���� ���� ��� ����
    SELECT TEST_SEQ.NEXTVAL FROM DUAL; 
    -- ���� �� �������ִ� �� // �ϳ��� ������ ��������� ���� ���� ��µȴ�.

    
    -- �������� // SEQUENCE DOC���� 3������
    -- MEMBER_LEVEL
    DROP TABLE MEMBER_LEVEL;
    CREATE TABLE MEMBER_LEVEL(
        LEVELNO   NUMBER(1) PRIMARY KEY,
        LEVELNAME VARCHAR2(10) NOT NULL
    );  
    
    INSERT INTO MEMBER_LEVEL VALUES(-1, 'BALCK');
    INSERT INTO MEMBER_LEVEL VALUES(0, '�Ϲ�');
    INSERT INTO MEMBER_LEVEL VALUES(1, '�ǹ�');
    INSERT INTO MEMBER_LEVEL VALUES(2, '���');
    
    SELECT * FROM MEMBER_LEVEL;
    COMMIT;
    
    -- SEQUENCE 
    DROP SEQUENCE MEMBER_MNO_SQ;
    CREATE SEQUENCE MEMBER_MNO_SQ
        MAXVALUE 9999
        NOCACHE
        NOCYCLE;
    
    -- MEMBER TABLE 
    DROP TABLE MEMBER;
    CREATE TABLE MEMBER(
        mNO    NUMBER(2)    PRIMARY KEY,
        mNAME  VARCHAR2(20) NOT NULL,
        mPW    VARCHAR2(9)  CHECK(LENGTH(mPW)< 9),
        mMAIL  VARCHAR2(30) UNIQUE,
        mPOINT NUMBER(9)    CHECK(mPOINT>=0),
        mRDATE DATE         DEFAULT SYSDATE,
        LEVELNO NUMBER(1),
        FOREIGN KEY(LEVELNO) REFERENCES MEMBER_LEVEL(LEVELNO) 
    );
    
    INSERT INTO MEMBER VALUES(MEMBER_MNO_SQ.NEXTVAL, 'ȫ�浿', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
    INSERT INTO MEMBER VALUES(MEMBER_MNO_SQ.NEXTVAL, '�ű浿', 'bb', 'sin@sin.com', 1000, '22/04/01', 1);    
    
    SELECT * FROM MEMBER;
    
    -- �׽�Ʈ ��� ����
    SELECT mNO, mNAME, mRDATE, mMAIL, mPOINT, LEVELNAME || '��'
        FROM MEMBER M, MEMBER_LEVEL L
        WHERE M.LEVELNO = L.LEVELNO; 
    
    COMMIT;