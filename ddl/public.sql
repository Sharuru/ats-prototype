/*
 Navicat Premium Data Transfer

 Source Server Type    : PostgreSQL
 Source Server Version : 110002
 Source Catalog        : ats
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110002
 File Encoding         : 65001

 Date: 22/04/2019 23:19:27
*/


-- ----------------------------
-- Sequence structure for t_gantt_extend_metas_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_gantt_extend_metas_id_seq";
CREATE SEQUENCE "public"."t_gantt_extend_metas_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gantt_links_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_gantt_links_id_seq";
CREATE SEQUENCE "public"."t_gantt_links_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gantt_tasks_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."t_gantt_tasks_id_seq";
CREATE SEQUENCE "public"."t_gantt_tasks_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for t_gantt_extend_metas
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_gantt_extend_metas";
CREATE TABLE "public"."t_gantt_extend_metas" (
  "id" int4 NOT NULL DEFAULT nextval('t_gantt_extend_metas_id_seq'::regclass),
  "task_id" numeric NOT NULL,
  "task_rank" numeric
)
;

-- ----------------------------
-- Records of t_gantt_extend_metas
-- ----------------------------
INSERT INTO "public"."t_gantt_extend_metas" VALUES (1, 2, 2);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (2, 3, 2);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (3, 4, 2);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (5, 6, 2);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (4, 5, 2);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (6, 8, 3);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (7, 7, 2);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (8, 9, 3);
INSERT INTO "public"."t_gantt_extend_metas" VALUES (9, 10, 3);

-- ----------------------------
-- Table structure for t_gantt_links
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_gantt_links";
CREATE TABLE "public"."t_gantt_links" (
  "id" int4 NOT NULL DEFAULT nextval('t_gantt_links_id_seq'::regclass),
  "source" numeric,
  "target" numeric,
  "type" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of t_gantt_links
-- ----------------------------
INSERT INTO "public"."t_gantt_links" VALUES (2, 2, 3, '0');
INSERT INTO "public"."t_gantt_links" VALUES (3, 3, 4, '0');
INSERT INTO "public"."t_gantt_links" VALUES (1, 1, 2, '1');
INSERT INTO "public"."t_gantt_links" VALUES (4, 1, 5, '1');
INSERT INTO "public"."t_gantt_links" VALUES (5, 5, 6, '0');
INSERT INTO "public"."t_gantt_links" VALUES (6, 6, 7, '0');
INSERT INTO "public"."t_gantt_links" VALUES (7, 1, 8, '1');
INSERT INTO "public"."t_gantt_links" VALUES (8, 8, 9, '0');
INSERT INTO "public"."t_gantt_links" VALUES (9, 9, 10, '0');

-- ----------------------------
-- Table structure for t_gantt_tasks
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_gantt_tasks";
CREATE TABLE "public"."t_gantt_tasks" (
  "id" int4 NOT NULL DEFAULT nextval('t_gantt_tasks_id_seq'::regclass),
  "start_date" timestamp(6),
  "text" text COLLATE "pg_catalog"."default",
  "progress" numeric,
  "duration" numeric,
  "sortorder" numeric,
  "parent" numeric
)
;

-- ----------------------------
-- Records of t_gantt_tasks
-- ----------------------------
INSERT INTO "public"."t_gantt_tasks" VALUES (2, '2019-04-01 00:00:00', 'L2_Design_#01', 0, 2, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (3, '2019-04-03 00:00:00', 'L2_Development_#01', 0, 4, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (4, '2019-04-07 00:00:00', 'L2_Unit Test_#01', 0, 2, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (5, '2019-04-02 00:00:00', 'L2_Design_#02', 0, 2, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (6, '2019-04-04 00:00:00', 'L2_Development_#02', 0, 4, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (7, '2019-04-08 00:00:00', 'L2_Unit Test_#02', 0, 2, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (8, '2019-04-01 00:00:00', 'L3_Design_#03', 0, 4, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (9, '2019-04-05 00:00:00', 'L3_Development_#03', 0, 4, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (10, '2019-04-09 00:00:00', 'L3_Unit Test_#03', 0, 4, 10, 1);
INSERT INTO "public"."t_gantt_tasks" VALUES (1, '2019-04-01 15:11:49', 'Project ATS', 0, 30, 10, NULL);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."t_gantt_extend_metas_id_seq"
OWNED BY "public"."t_gantt_extend_metas"."id";
SELECT setval('"public"."t_gantt_extend_metas_id_seq"', 10, true);
ALTER SEQUENCE "public"."t_gantt_links_id_seq"
OWNED BY "public"."t_gantt_links"."id";
SELECT setval('"public"."t_gantt_links_id_seq"', 11, true);
ALTER SEQUENCE "public"."t_gantt_tasks_id_seq"
OWNED BY "public"."t_gantt_tasks"."id";
SELECT setval('"public"."t_gantt_tasks_id_seq"', 12, true);

-- ----------------------------
-- Primary Key structure for table t_gantt_extend_metas
-- ----------------------------
ALTER TABLE "public"."t_gantt_extend_metas" ADD CONSTRAINT "t_gantt_extend_metas_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_gantt_links
-- ----------------------------
ALTER TABLE "public"."t_gantt_links" ADD CONSTRAINT "t_gantt_links_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table t_gantt_tasks
-- ----------------------------
ALTER TABLE "public"."t_gantt_tasks" ADD CONSTRAINT "t_gantt_tasks_pkey" PRIMARY KEY ("id");
