-- Insert into users (Note the lowercase table name)
INSERT INTO user (username, email, password, is_active, is_locked, created_at, updated_at)
VALUES 
('pavan', 'pavan@gmail.com', '{bcrypt}$2a$12$TK9Yt2264DZqZBsGLKCcTe3b.HL8s88vo6eHx.30UrwTEylmpLYVC', TRUE, FALSE, NOW(), NOW()),
('ram', 'ram@gmail.com', '{bcrypt}$2a$12$TK9Yt2264DZqZBsGLKCcTe3b.HL8s88vo6eHx.30UrwTEylmpLYVC', TRUE, FALSE, NOW(), NOW());

-- Insert into user_profile (Check for foreign key constraint on user_id)
INSERT INTO user_profile (user_id, first_name, last_name, phone_number, date_of_birth, gender, address, bio, created_at, updated_at)
VALUES 
(1, 'Pavan', 'Kumar', '1234567890', '1990-01-01', 'Male', 'Pragathi Nagar', 'Software Developer', NOW(), NOW()),
(2, 'Ram', 'Kumar', '9876543210', '1992-05-15', 'Female', 'JNTUH', 'Designer', NOW(), NOW());

-- Insert into roles (Ensure user_id corresponds to existing users)
INSERT INTO roles (role_name, user_id, created_at, updated_at)
VALUES 
('ADMIN', 1, NOW(), NOW()),
('ADMIN', 2, NOW(), NOW()),
('USER', 2, NOW(), NOW());
