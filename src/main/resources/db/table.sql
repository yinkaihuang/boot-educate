create table  if not exists t_user_table (
    id bigint primary key auto_increment comment '主键ID',
    name varchar(50) not null comment '用户姓名',
    gender tinyint comment '性别 1男 2女 3未知',
    identity_card varchar(255) comment '身份证',
    birth_day datetime comment '出生日期',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    remark varchar(255) comment '备注',
    index index_card(identity_card)
)engine=innodb comment '用户表';
