SELECT * FROM user; 
SELECT * FROM counsel;

insert into user (id, password, email, name,nickname,phoneNum) values ('johnKDK', 'kdk', 'johnKDK@gmail.com', '김동규', 'KDK',01012345567);
insert into user (id, password, email, name,nickname,phoneNum) values ('mckim', '0223', 'mckim@gmail.com', 'kimmincheol', 'KMC',01099999999);
insert into user (id, password, email, name,nickname,phoneNum) values ('tester', 123,	'testerhon@naver.com',	'테스터훈','THT',01099555551);

insert into counsel (mentee_id, mentor_id, title, content,answerContent) values ('mckim', 'johnKDK', 'hello', 'helpme','무릎을 조심하세요');
delete from counsel where id = 3;
delete from user where name = '김동규';

-- {
--   "mentee_id": "test",
--   "mentor_id": "johnKDK",
--   "title": "주짓수의 달인",
--   "content": "을 뵙습니다",
--   "answerContent": "반갑습니다"
-- }