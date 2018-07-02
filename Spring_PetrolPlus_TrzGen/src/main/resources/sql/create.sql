-- Create table
create table SPC_GEN_ROLE
(
  id        NUMBER(10) not null,
  authority VARCHAR2(255 CHAR)
);
-- Create/Recreate primary, unique and foreign key constraints
alter table SPC_GEN_ROLE
  add primary key (ID);

-- Create table
create table SPC_GEN_TRZ
(
  id VARCHAR2(255 CHAR) not null
);
-- Create/Recreate primary, unique and foreign key constraints
alter table SPC_GEN_TRZ
  add primary key (ID);

-- Create table
create table SPC_GEN_USER
(
  id                      NUMBER(10) not null,
  account_non_expired     NUMBER(1) not null,
  account_non_locked      NUMBER(1) not null,
  credentials_non_expired NUMBER(1) not null,
  enabled                 NUMBER(1) not null,
  password                VARCHAR2(255 CHAR),
  username                VARCHAR2(255 CHAR)
);
-- Create/Recreate primary, unique and foreign key constraints
alter table SPC_GEN_USER
  add primary key (ID);

-- Create table
create table SPC_GEN_USER_ROLE
(
  user_id NUMBER(10) not null,
  role_id NUMBER(10) not null
);
-- Create/Recreate primary, unique and foreign key constraints
alter table SPC_GEN_USER_ROLE
  add constraint FK3MRA1NB5MNHGCCH2AEUM58Y0M foreign key (USER_ID)
  references SPC_GEN_USER (ID);
alter table SPC_GEN_USER_ROLE
  add constraint FK4J62JC6AQ4NFNP8JDN1A5UWVO foreign key (ROLE_ID)
  references SPC_GEN_ROLE (ID);

-- Create sequence
create sequence HIBERNATE_SEQUENCE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;