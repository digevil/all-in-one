/*
 Navicat Premium Data Transfer

 Source Server         : localhost.test
 Source Server Type    : PostgreSQL
 Source Server Version : 90504
 Source Host           : localhost:5432
 Source Catalog        : testdb
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90504
 File Encoding         : 65001

 Date: 08/12/2019 00:04:48
*/


-- ----------------------------
-- Table structure for all_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."all_user";
CREATE TABLE "public"."all_user" (
  "id" uuid NOT NULL DEFAULT uuid_generate_v4(),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "public"."all_user" OWNER TO "test";
COMMENT ON COLUMN "public"."all_user"."id" IS 'id';
COMMENT ON COLUMN "public"."all_user"."name" IS 'name';

-- ----------------------------
-- Records of all_user
-- ----------------------------
BEGIN;
INSERT INTO "public"."all_user" VALUES ('7d75b9bd-52fb-46b2-9aed-eb049cdfdfd6', 'billie');
INSERT INTO "public"."all_user" VALUES ('abd4432f-fdcb-43f4-aba8-85e7664a8cb0', 'griffin');
INSERT INTO "public"."all_user" VALUES ('04740c88-91c0-4574-982f-e385e7d3339c', 'toni');
COMMIT;

-- ----------------------------
-- Table structure for cas_users
-- ----------------------------
DROP TABLE IF EXISTS "public"."cas_users";
CREATE TABLE "public"."cas_users" (
  "cid" int4 NOT NULL,
  "cname" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "cpassword" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "used" int2 NOT NULL
)
;
ALTER TABLE "public"."cas_users" OWNER TO "test";

-- ----------------------------
-- Records of cas_users
-- ----------------------------
BEGIN;
INSERT INTO "public"."cas_users" VALUES (1, 'casuser', '9414f9301cdb492b4dcd83f8c711d8bb', 1);
INSERT INTO "public"."cas_users" VALUES (2, 'toni', 'eba12f193f6dba190642b53704e1019b', 1);
INSERT INTO "public"."cas_users" VALUES (3, 'billie', '0ee28a8f4f0b6cff7c62dd2103538bd1', 1);
COMMIT;

-- ----------------------------
-- Table structure for test_table_1
-- ----------------------------
DROP TABLE IF EXISTS "public"."test_table_1";
CREATE TABLE "public"."test_table_1" (
  "id" int8 NOT NULL,
  "name" varchar(1024) COLLATE "pg_catalog"."default",
  "age" int4,
  "birthday" date,
  "version" int4 DEFAULT 0
)
;
ALTER TABLE "public"."test_table_1" OWNER TO "test";

-- ----------------------------
-- Records of test_table_1
-- ----------------------------
BEGIN;
INSERT INTO "public"."test_table_1" VALUES (1, 'toni', 35, '1982-01-16', 0);
INSERT INTO "public"."test_table_1" VALUES (2, 'billie', 35, '1981-03-15', 0);
COMMIT;

-- ----------------------------
-- Table structure for test_time
-- ----------------------------
DROP TABLE IF EXISTS "public"."test_time";
CREATE TABLE "public"."test_time" (
  "cid" int4 NOT NULL,
  "cname" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "c_time" timestamp(0) DEFAULT now()
)
;
ALTER TABLE "public"."test_time" OWNER TO "test";

-- ----------------------------
-- Records of test_time
-- ----------------------------
BEGIN;
INSERT INTO "public"."test_time" VALUES (1, 'casuser', '2016-11-24 16:20:35');
COMMIT;

-- ----------------------------
-- Function structure for uuid_generate_v1
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_generate_v1"();
CREATE OR REPLACE FUNCTION "public"."uuid_generate_v1"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_generate_v1'
  LANGUAGE c VOLATILE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_generate_v1mc
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_generate_v1mc"();
CREATE OR REPLACE FUNCTION "public"."uuid_generate_v1mc"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_generate_v1mc'
  LANGUAGE c VOLATILE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_generate_v3
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_generate_v3"("namespace" uuid, "name" text);
CREATE OR REPLACE FUNCTION "public"."uuid_generate_v3"("namespace" uuid, "name" text)
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_generate_v3'
  LANGUAGE c IMMUTABLE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_generate_v4
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_generate_v4"();
CREATE OR REPLACE FUNCTION "public"."uuid_generate_v4"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_generate_v4'
  LANGUAGE c VOLATILE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_generate_v5
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_generate_v5"("namespace" uuid, "name" text);
CREATE OR REPLACE FUNCTION "public"."uuid_generate_v5"("namespace" uuid, "name" text)
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_generate_v5'
  LANGUAGE c IMMUTABLE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_nil
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_nil"();
CREATE OR REPLACE FUNCTION "public"."uuid_nil"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_nil'
  LANGUAGE c IMMUTABLE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_ns_dns
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_ns_dns"();
CREATE OR REPLACE FUNCTION "public"."uuid_ns_dns"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_ns_dns'
  LANGUAGE c IMMUTABLE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_ns_oid
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_ns_oid"();
CREATE OR REPLACE FUNCTION "public"."uuid_ns_oid"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_ns_oid'
  LANGUAGE c IMMUTABLE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_ns_url
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_ns_url"();
CREATE OR REPLACE FUNCTION "public"."uuid_ns_url"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_ns_url'
  LANGUAGE c IMMUTABLE STRICT
  COST 1;

-- ----------------------------
-- Function structure for uuid_ns_x500
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."uuid_ns_x500"();
CREATE OR REPLACE FUNCTION "public"."uuid_ns_x500"()
  RETURNS "pg_catalog"."uuid" AS '$libdir/uuid-ossp', 'uuid_ns_x500'
  LANGUAGE c IMMUTABLE STRICT
  COST 1;

-- ----------------------------
-- Uniques structure for table all_user
-- ----------------------------
ALTER TABLE "public"."all_user" ADD CONSTRAINT "uniq_all_user_name_hash" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table all_user
-- ----------------------------
ALTER TABLE "public"."all_user" ADD CONSTRAINT "pk_all_user_hash" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table cas_users
-- ----------------------------
ALTER TABLE "public"."cas_users" ADD CONSTRAINT "cas_users_cname_key" UNIQUE ("cname");

-- ----------------------------
-- Checks structure for table cas_users
-- ----------------------------
ALTER TABLE "public"."cas_users" ADD CONSTRAINT "cas_users_cname_check" CHECK (((cname)::text <> ''::text));

-- ----------------------------
-- Primary Key structure for table cas_users
-- ----------------------------
ALTER TABLE "public"."cas_users" ADD CONSTRAINT "cas_users_pkey" PRIMARY KEY ("cid");

-- ----------------------------
-- Primary Key structure for table test_table_1
-- ----------------------------
ALTER TABLE "public"."test_table_1" ADD CONSTRAINT "test_table_1_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table test_time
-- ----------------------------
ALTER TABLE "public"."test_time" ADD CONSTRAINT "test_time_cname_key" UNIQUE ("cname");

-- ----------------------------
-- Checks structure for table test_time
-- ----------------------------
ALTER TABLE "public"."test_time" ADD CONSTRAINT "test_time_cname_check" CHECK (((cname)::text <> ''::text));

-- ----------------------------
-- Primary Key structure for table test_time
-- ----------------------------
ALTER TABLE "public"."test_time" ADD CONSTRAINT "test_time_pkey" PRIMARY KEY ("cid");
