SELECT * FROM user; 
SELECT * FROM counsel;

insert into user (id, password, email, name,nickname, phone_num) values 
('johnKDK', 'kdk', 'johnKDK@gmail.com', '김동규', 'KDK','01012345567'),
('mckim', '0223', 'mckim@gmail.com', 'kimmincheol', 'KMC','01099999999'),
('tester', '123',	'testerhon@naver.com',	'테스터훈','THT','01099555551');

insert into counsel (mentee_id, mentor_id, title, content, answer_content) values ('mckim', 'johnKDK', 'hello', 'helpme','무릎을 조심하세요');
delete from counsel where id = 3;
delete from user where name = '';

UPDATE user
SET password = '1234', email = 'mckim@gmail.com', name = '김민철', nickname = '철' , phone_num = '01088888885'
WHERE id = 'mckim';

-- {
--   "mentee_id": "test",
--   "mentor_id": "johnKDK",
--   "title": "주짓수의 달인",
--   "content": "을 뵙습니다",
--   "answerContent": "반갑습니다"
-- }