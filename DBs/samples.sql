SELECT * FROM user; 
SELECT * FROM counsel;

INSERT INTO user (id, password, email, name, nickname, phone_num) VALUES
('johnKDK', 'kdk', 'johnKDK@gmail.com', '김동규', 'KDK','01012345567'),
('mckim', '0223', 'mckim@gmail.com', 'kimmincheol', 'KMC','01099999999'),
('tester', '123',	'testerhon@naver.com',	'테스터훈','THT','01099555551'),
('user1', 'pass123', 'user1@example.com', 'John Doe', 'JD', '1234567890'),
('user2', 'pass456', 'user2@example.com', 'Jane Smith', 'JS', '0987654321'),
('user3', 'pass789', 'user3@example.com', 'Michael Johnson', 'MJ', '1112223333'),
('user4', 'passabc', 'user4@example.com', 'Emily Brown', 'EB', '9998887777'),
('user5', 'passxyz', 'user5@example.com', 'Daniel Wilson', 'DW', '7776665555'),
('user6', 'pass321', 'user6@example.com', 'Sarah Lee', 'SL', '4445556666'),
('user7', 'pass654', 'user7@example.com', 'Matthew Kim', 'MK', '2223334444'),
('user8', 'pass987', 'user8@example.com', 'Jennifer Park', 'JP', '8889990000'),
('user9', 'passdef', 'user9@example.com', 'David Lee', 'DL', '5554443333'),
('user10', 'passuvw', 'user10@example.com', 'Jessica Chen', 'JC', '6667778888'),
('user11', 'pass123', 'user11@example.com', 'Christopher Brown', 'CB', '1234567890'),
('user12', 'pass456', 'user12@example.com', 'Amanda Wilson', 'AW', '0987654321'),
('user13', 'pass789', 'user13@example.com', 'Kevin Johnson', 'KJ', '1112223333'),
('user14', 'passabc', 'user14@example.com', 'Elizabeth Smith', 'ES', '9998887777'),
('user15', 'passxyz', 'user15@example.com', 'Brandon Taylor', 'BT', '7776665555'),
('user16', 'pass321', 'user16@example.com', 'Michelle Brown', 'MB', '4445556666'),
('user17', 'pass654', 'user17@example.com', 'Justin Lee', 'JL', '2223334444'),
('user18', 'pass987', 'user18@example.com', 'Stephanie Kim', 'SK', '8889990000'),
('user19', 'passdef', 'user19@example.com', 'Andrew Park', 'AP', '5554443333'),
('user20', 'passuvw', 'user20@example.com', 'Melissa Chen', 'MC', '6667778888');

UPDATE user
SET password = '1234', email = 'mckim@gmail.com', name = '김민철', nickname = '철' , phone_num = '01088888885'
WHERE id = 'mckim';

INSERT INTO counsel (mentee_id, mentor_id, title, content, answer_content, status) VALUES
('user1', 'user2', 'title1', 'content1', 'answer1', 4),
('user3', 'user4', 'title2', 'content2', 'answer2', 5),
('user5', 'user6', 'title3', 'content3', 'answer3', 1),
('user7', 'user8', 'title4', 'content4', 'answer4', 1),
('user9', 'user10', 'title5', 'content5', 'answer5', 1),
('user11', 'user12', 'title6', 'content6', 'answer6', 1),
('user13', 'user14', 'title7', 'content7', 'answer7', 1),
('user15', 'user16', 'title8', 'content8', 'answer8', 1),
('user17', 'user18', 'title9', 'content9', 'answer9', 2),
('user19', 'user20', 'title10', 'content10', 'answer10', 2),
('user2', 'user3', 'title11', 'content11', 'answer11', 2),
('user4', 'user5', 'title12', 'content12', 'answer12', 2),
('user6', 'user7', 'title13', 'content13', 'answer13', 2),
('user8', 'user9', 'title14', 'content14', 'answer14', 2),
('user10', 'user11', 'title15', 'content15', 'answer15', 2),
('user12', 'user13', 'title16', 'content16', 'answer16', 3),
('user14', 'user15', 'title17', 'content17', 'answer17', 3),
('user16', 'user17', 'title18', 'content18', 'answer18', 3),
('user18', 'user19', 'title19', 'content19', 'answer19', 3),
('user20', 'user1', 'title20', 'content20', 'answer20', 3),
('mckim', 'johnKDK', 'hello', 'helpme','무릎을 조심하세요', 3),
('tester', 'johnKDK', 'ㅎㅇ', '다이어트 팁을 알려주세요','유산소를 많이하세요', 3);
