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

UPDATE mydb.counsel
SET 
  question1 = CASE
                WHEN question1 IS NULL THEN '새로운 질문 내용'
                ELSE question1
              END,
  question2 = CASE
                WHEN question1 IS NOT NULL AND question2 IS NULL THEN '새로운 질문 내용'
                ELSE question2
              END,
  question3 = CASE
                WHEN question1 IS NOT NULL AND question2 IS NOT NULL AND question3 IS NULL THEN '새로운 질문 내용'
                ELSE question3
              END
WHERE id = 1;

UPDATE counsel 
SET 
    review_star = 4,
    review_Content = '4점'
WHERE
    id = 1;
        
-- {
--   "mentee_id": "test",
--   "mentor_id": "johnKDK",
--   "title": "주짓수의 달인",
--   "content": "을 뵙습니다",
--   "answerContent": "반갑습니다"
-- }