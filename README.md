# OnlineShopping
在线水果商城

```sql
/*
Navicat SQL Server Data Transfer

Source Server         : sqlserver_localhost
Source Server Version : 100000
Source Host           : localhost:1433
Source Database       : fruit
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 100000
File Encoding         : 65001

Date: 2018-06-22 17:44:48
*/


-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE [cart]
GO
CREATE TABLE [cart] (
[id] varchar(255) NOT NULL ,
[num] int NOT NULL ,
[uid] varchar(255) NOT NULL 
)


GO

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN TRANSACTION
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Table structure for fruit
-- ----------------------------
DROP TABLE [fruit]
GO
CREATE TABLE [fruit] (
[id] varchar(255) NOT NULL ,
[name] varchar(255) NOT NULL ,
[price] money NOT NULL ,
[address] varchar(255) NOT NULL ,
[tid] varchar(1) NOT NULL 
)


GO

-- ----------------------------
-- Records of fruit
-- ----------------------------
BEGIN TRANSACTION
GO
INSERT INTO [fruit] ([id], [name], [price], [address], [tid]) VALUES (N'0ec2371f-9fd0-49fe-9e72-d30b894fcebc', N'橙子2', N'7.0000', N'6f7b163d-1dbd-4d3a-a2e4-4805821d12fb.jpg', N'1')
GO
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Table structure for fruittype
-- ----------------------------
DROP TABLE [fruittype]
GO
CREATE TABLE [fruittype] (
[id] varchar(255) NOT NULL ,
[name] varchar(255) NOT NULL 
)


GO

-- ----------------------------
-- Records of fruittype
-- ----------------------------
BEGIN TRANSACTION
GO
INSERT INTO [fruittype] ([id], [name]) VALUES (N'1', N'哇')
GO
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE [user]
GO
CREATE TABLE [user] (
[id] varchar(255) NOT NULL ,
[username] varchar(255) NOT NULL ,
[password] varchar(255) NOT NULL 
)


GO

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN TRANSACTION
GO
INSERT INTO [user] ([id], [username], [password]) VALUES (N'1', N'1', N'1'), (N'13c46e86-6a95-4f49-a1bb-00faa5b869e6', N'11', N'22'), (N'5774c9c2-feaf-411d-b2eb-23c40dc44ebc', N'33', N'33'), (N'bc37d551-0844-4ebe-abd8-ab889bfc92ff', N'aaa', N'123')
GO
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Indexes structure for table cart
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table cart
-- ----------------------------
ALTER TABLE [cart] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table fruit
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table fruit
-- ----------------------------
ALTER TABLE [fruit] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table fruittype
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table fruittype
-- ----------------------------
ALTER TABLE [fruittype] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE [user] ADD PRIMARY KEY ([id])
GO

```
