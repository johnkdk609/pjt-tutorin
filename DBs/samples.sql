SELECT * FROM user; 
SELECT * FROM counsel;
-- UPDATE counsel
-- SET update_time = DATE_ADD(create_time, INTERVAL 1 DAY)
-- WHERE id = '1';

-- UPDATE counsel
-- SET answer_time = DATE_ADD(now(), INTERVAL 1 DAY)
-- WHERE id = '1';

-- UPDATE counsel
-- SET answer_content = '규칙적인생활' , feedback_time = DATE_ADD(now(), INTERVAL 7 DAY), status = 3
-- WHERE id = 3;

INSERT INTO user (id, password, email, name, nickname, phone_num) VALUES
('johnKDK', 'kdk', 'johnKDK@gmail.com', '김동규', 'KDK','01012345567'),
('mckim', '0223', 'mckim@gmail.com', 'kimmincheol', 'KMC','01099999999'),
('tester', '123',	'testerhon@naver.com',	'테스터훈','THT','01099555551'),
('john', '111', 'user1@example.com', 'John Doe', 'JD', '1234567890'),
('jane', '111', 'user2@example.com', 'Jane Smith', 'JS', '0987654321'),
('michael', '111', 'user3@example.com', 'Michael Johnson', 'MJ', '1112223333'),
('emily', '111', 'user4@example.com', 'Emily Brown', 'EB', '9998887777'),
('daniel', '111', 'user5@example.com', 'Daniel Wilson', 'DW', '7776665555'),
('sarah', '111', 'user6@example.com', 'Sarah Lee', 'SL', '4445556666'),
('matthew', '111', 'user7@example.com', 'Matthew Kim', 'MK', '2223334444'),
('jennifer', '111', 'user8@example.com', 'Jennifer Park', 'JP', '8889990000'),
('david', '111', 'user9@example.com', 'David Lee', 'DL', '5554443333'),
('jessica', '111', 'user10@example.com', 'Jessica Chen', 'JC', '6667778888'),
('christopher', '111', 'user11@example.com', 'Christopher Brown', 'CB', '1234567890'),
('amanda', '111', 'user12@example.com', 'Amanda Wilson', 'AW', '0987654321'),
('kevin', '111', 'user13@example.com', 'Kevin Johnson', 'KJ', '1112223333'),
('elizabeth', '111', 'user14@example.com', 'Elizabeth Smith', 'ES', '9998887777'),
('brandon', '111', 'user15@example.com', 'Brandon Taylor', 'BT', '7776665555'),
('michelle', '111', 'user16@example.com', 'Michelle Brown', 'MB', '4445556666'),
('justin', '111', 'user17@example.com', 'Justin Lee', 'JL', '2223334444'),
('stephanie', '111', 'user18@example.com', 'Stephanie Kim', 'SK', '8889990000'),
('andrew', '111', 'user19@example.com', 'Andrew Park', 'AP', '5554443333'),
('melissa', '111', 'user20@example.com', 'Melissa Chen', 'MC', '6667778888');

UPDATE user
SET password = '1234', email = 'mckim@gmail.com', name = '김민철', nickname = '철' , phone_num = '01088888885'
WHERE id = 'mckim';

INSERT INTO counsel (mentee_id, mentor_id, title, content, answer_content, status) VALUES
('mckim', 'johnKDK', 'hello', 'helpme','무릎을 조심하세요', 3),
('tester', 'johnKDK', 'ㅎㅇ', '다이어트 팁을 알려주세요','유산소를 많이하세요', 3),
('john', 'jane', 'title1', 'content1', 'answer1', 1),
('john', 'michael', 'title2', 'content2', 'answer2', 5),
('john', 'emily', 'title3', 'content3', 'answer3', 1),
('john', 'daniel', 'title4', 'content4', 'answer4', 1),
('daniel', 'sarah', 'title5', 'content5', 'answer5', 1),
('daniel', 'matthew', 'title6', 'content6', 'answer6', 1),
('daniel', 'jennifer', 'title7', 'content7', 'answer7', 1),
('daniel', 'david', 'title8', 'content8', 'answer8', 1),
('jessica', 'christopher', 'title9', 'content9', 'answer9', 2),
('jessica', 'amanda', 'title10', 'content10', 'answer10', 2),
('jessica', 'kevin', 'title11', 'content11', 'answer11', 2),
('jessica', 'elizabeth', 'title12', 'content12', 'answer12', 2),
('brandon', 'michelle', 'title13', 'content13', 'answer13', 2),
('brandon', 'justin', 'title14', 'content14', 'answer14', 2),
('brandon', 'stephanie', 'title15', 'content15', 'answer15', 2),
('brandon', 'andrew', 'title16', 'content16', 'answer16', 3);
