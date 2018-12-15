CREATE TABLE IF NOT EXISTS ServletStudyUser
(
  uid   VARCHAR(32) PRIMARY KEY COMMENT '用户ID',
  uname VARCHAR(30) NOT NULL COMMENT '用户名',
  upwd  VARCHAR(30) NOT NULL COMMENT '用户密码',
  umail VARCHAR(50) COMMENT '用户邮箱'
) COLLATE utf8_general_ci COMMENT '用户表';

INSERT INTO ServletStudyUser
VALUES ('8b5d43b4004511e9b28f5254002d9a46', 'Jesse', '123456', 'jesse@123.com');

