use estatejdbc82019;

insert into role(code,name) values('MANAGER','Quản lý');
insert into role(code,name) values('STAFF','Nhân viên');

insert into user(username,password,fullname,status)
values('nguyenvana','123456','nguyen van a',1);
insert into user(username,password,fullname,status)
values('nguyenvanb','123456','nguyen van b',1);
insert into user(username,password,fullname,status)
values('nguyenvanc','123456','nguyen van c',1);
insert into user(username,password,fullname,status)
values('nguyenvand','123456','nguyen van d',1);

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);
INSERT INTO user_role(userid,roleid) VALUES (4,2);

insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type) values('FCL Buiding',2,500,'QUAN_1','Phường 2','59 Pham Xích Long',15,'15 triệu/m2','Hùng','012345678','TANG_TRIET,NGUYEN_CAN');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type) values('ACM Tower',2,650,'QUAN_2','Phường 4','96 Cao Thắng',18,'18 triệu/m2','Cường','012345678','NGUYEN_CAN');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type) values('Alpha 2 Building',1,200,'QUAN_3','Phường 6','153 Nguyễn Đình Chiểu',20,'20 triệu/m2','Huy','012345678','TANG_TRIET,NGUYEN_CAN,NOI_THAT');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,type) values('IDD 1 Building',1,200,'QUAN_4','Phường 7','111 Lý Chính Thắng',12,'12 triệu/m2','Vy','012345678','NOI_THAT');
insert into building(name,numberofbasement,buildingarea,district,ward,street,costrent,costdescription,managername,managerphone,createddate,type) values('VINACONEXT',1,150,'QUAN_3','Phường 10','134/1 Cách Mạng Tháng 8',1000,'','Mai','012345678','2019-8-22 10:34:09','NGUYEN_CAN,NOI_THAT')



